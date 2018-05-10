package org.jcodec.containers.mxf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.DemuxerTrackMeta.Type;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mxf.MXFConst.MXFCodecMapping;
import org.jcodec.containers.mxf.model.FileDescriptor;
import org.jcodec.containers.mxf.model.GenericDescriptor;
import org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor;
import org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor;
import org.jcodec.containers.mxf.model.IndexSegment;
import org.jcodec.containers.mxf.model.KLV;
import org.jcodec.containers.mxf.model.MXFMetadata;
import org.jcodec.containers.mxf.model.MXFPartition;
import org.jcodec.containers.mxf.model.MXFUtil;
import org.jcodec.containers.mxf.model.TimecodeComponent;
import org.jcodec.containers.mxf.model.TimelineTrack;
import org.jcodec.containers.mxf.model.UL;
import org.jcodec.containers.mxf.model.WaveAudioDescriptor;

public class MXFDemuxer {
    protected SeekableByteChannel ch;
    protected double duration;
    protected MXFPartition header;
    protected List<IndexSegment> indexSegments;
    protected List<MXFMetadata> metadata;
    protected List<MXFPartition> partitions;
    protected TimecodeComponent timecode = ((TimecodeComponent) MXFUtil.findMeta(this.metadata, TimecodeComponent.class));
    protected int totalFrames;
    protected MXFDemuxerTrack[] tracks = findTracks();

    public enum OP {
        OP1a(1, 1),
        OP1b(1, 2),
        OP1c(1, 3),
        OP2a(2, 1),
        OP2b(2, 2),
        OP2c(2, 3),
        OP3a(3, 1),
        OP3b(3, 2),
        OP3c(3, 3),
        OPAtom(16, 0);
        
        public int major;
        public int minor;

        private OP(int i, int i2) {
            this.major = i;
            this.minor = i2;
        }
    }

    public static class Fast extends MXFDemuxer {
        public Fast(SeekableByteChannel seekableByteChannel) throws IOException {
            super(seekableByteChannel);
        }

        public void parseHeader(SeekableByteChannel seekableByteChannel) throws IOException {
            this.partitions = new ArrayList();
            this.metadata = new ArrayList();
            this.header = MXFDemuxer.readHeaderPartition(seekableByteChannel);
            this.metadata.addAll(MXFDemuxer.readPartitionMeta(seekableByteChannel, this.header));
            this.partitions.add(this.header);
            seekableByteChannel.position(this.header.getPack().getFooterPartition());
            KLV readKL = KLV.readKL(seekableByteChannel);
            this.metadata.addAll(MXFDemuxer.readPartitionMeta(seekableByteChannel, MXFPartition.read(readKL.key, NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) readKL.len), seekableByteChannel.position() - readKL.offset, seekableByteChannel.size())));
        }
    }

    public static class MXFPacket extends Packet {
        private int len;
        private long offset;

        public MXFPacket(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode, long j5, int i) {
            super(byteBuffer, j, j2, j3, j4, z, tapeTimecode);
            this.offset = j5;
            this.len = i;
        }

        public long getOffset() {
            return this.offset;
        }

        public int getLen() {
            return this.len;
        }
    }

    public class MXFDemuxerTrack implements SeekableDemuxerTrack {
        private boolean audio;
        private int audioFrameDuration;
        private int audioTimescale;
        private MXFCodecMapping codec;
        private int dataLen;
        private GenericDescriptor descriptor;
        private UL essenceUL;
        private int frameNo;
        private int indexSegmentIdx;
        private int indexSegmentSubIdx;
        private long partEssenceOffset;
        private int partIdx;
        private long pts;
        private TimelineTrack track;
        private boolean video;

        public MXFDemuxerTrack(UL ul, TimelineTrack timelineTrack, GenericDescriptor genericDescriptor) throws IOException {
            this.essenceUL = ul;
            this.track = timelineTrack;
            this.descriptor = genericDescriptor;
            if ((genericDescriptor instanceof GenericPictureEssenceDescriptor) != null) {
                this.video = true;
            } else if ((genericDescriptor instanceof GenericSoundEssenceDescriptor) != null) {
                this.audio = true;
            }
            this.codec = resolveCodec();
            if (this.codec != null || (genericDescriptor instanceof WaveAudioDescriptor) != null) {
                ul = new StringBuilder("Track type: ");
                ul.append(this.video);
                ul.append(", ");
                ul.append(this.audio);
                Logger.warn(ul.toString());
                if (this.audio != null && (genericDescriptor instanceof WaveAudioDescriptor) != null) {
                    WaveAudioDescriptor waveAudioDescriptor = (WaveAudioDescriptor) genericDescriptor;
                    cacheAudioFrameSizes(MXFDemuxer.this.ch);
                    this.audioFrameDuration = this.dataLen / ((waveAudioDescriptor.getQuantizationBits() >> 3) * waveAudioDescriptor.getChannelCount());
                    this.audioTimescale = (int) waveAudioDescriptor.getAudioSamplingRate().scalar();
                }
            }
        }

        public boolean isAudio() {
            return this.audio;
        }

        public boolean isVideo() {
            return this.video;
        }

        public double getDuration() {
            return MXFDemuxer.this.duration;
        }

        public int getNumFrames() {
            return MXFDemuxer.this.totalFrames;
        }

        public String getName() {
            return this.track.getName();
        }

        private void cacheAudioFrameSizes(SeekableByteChannel seekableByteChannel) throws IOException {
            for (MXFPartition mXFPartition : MXFDemuxer.this.partitions) {
                if (mXFPartition.getEssenceLength() > 0) {
                    KLV readKL;
                    seekableByteChannel.position(mXFPartition.getEssenceFilePos());
                    do {
                        readKL = KLV.readKL(seekableByteChannel);
                        if (readKL == null) {
                            break;
                        }
                        seekableByteChannel.position(seekableByteChannel.position() + readKL.len);
                    } while (!this.essenceUL.equals(readKL.key));
                    if (this.essenceUL.equals(readKL.key)) {
                        this.dataLen = (int) readKL.len;
                        return;
                    }
                }
            }
        }

        public Packet nextFrame() throws IOException {
            if (this.indexSegmentIdx >= MXFDemuxer.this.indexSegments.size()) {
                return null;
            }
            Packet readPacket;
            IndexSegment indexSegment = (IndexSegment) MXFDemuxer.this.indexSegments.get(r10.indexSegmentIdx);
            long[] fileOff = indexSegment.getIe().getFileOff();
            int indexEditRateNum = indexSegment.getIndexEditRateNum();
            int indexEditRateDen = indexSegment.getIndexEditRateDen();
            long j = fileOff[r10.indexSegmentSubIdx];
            byte b = indexSegment.getIe().getDisplayOff()[r10.indexSegmentSubIdx];
            boolean z = indexSegment.getIe().getKeyFrameOff()[r10.indexSegmentSubIdx] == (byte) 0;
            while (j >= r10.partEssenceOffset + ((MXFPartition) MXFDemuxer.this.partitions.get(r10.partIdx)).getEssenceLength() && r10.partIdx < MXFDemuxer.this.partitions.size() - 1) {
                r10.partEssenceOffset += ((MXFPartition) MXFDemuxer.this.partitions.get(r10.partIdx)).getEssenceLength();
                r10.partIdx++;
            }
            j = (j - r10.partEssenceOffset) + ((MXFPartition) MXFDemuxer.this.partitions.get(r10.partIdx)).getEssenceFilePos();
            int i;
            if (r10.audio) {
                int i2 = r10.dataLen;
                long j2 = r10.pts;
                int i3 = r10.audioTimescale;
                int i4 = r10.audioFrameDuration;
                i = r10.frameNo;
                r10.frameNo = i + 1;
                readPacket = readPacket(j, i2, j2, i3, i4, i, z);
                r10.pts += (long) r10.audioFrameDuration;
            } else {
                int i5 = r10.dataLen;
                long j3 = r10.pts + ((long) (b * indexEditRateDen));
                i = r10.frameNo;
                r10.frameNo = i + 1;
                readPacket = readPacket(j, i5, j3, indexEditRateNum, indexEditRateDen, i, z);
                r10.pts += (long) indexEditRateDen;
            }
            r10.indexSegmentSubIdx++;
            if (r10.indexSegmentSubIdx >= fileOff.length) {
                r10.indexSegmentIdx++;
                r10.indexSegmentSubIdx = 0;
                if (r10.dataLen == 0 && r10.indexSegmentIdx < MXFDemuxer.this.indexSegments.size()) {
                    r10.pts = (r10.pts * ((long) ((IndexSegment) MXFDemuxer.this.indexSegments.get(r10.indexSegmentIdx)).getIndexEditRateNum())) / ((long) indexEditRateNum);
                }
            }
            return readPacket;
        }

        public org.jcodec.containers.mxf.MXFDemuxer.MXFPacket readPacket(long r21, int r23, long r24, int r26, int r27, int r28, boolean r29) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r20 = this;
            r1 = r20;
            r2 = org.jcodec.containers.mxf.MXFDemuxer.this;
            r2 = r2.ch;
            monitor-enter(r2);
            r3 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r3 = r3.ch;	 Catch:{ all -> 0x0075 }
            r14 = r21;	 Catch:{ all -> 0x0075 }
            r3.position(r14);	 Catch:{ all -> 0x0075 }
            r3 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r3 = r3.ch;	 Catch:{ all -> 0x0075 }
            r3 = org.jcodec.containers.mxf.model.KLV.readKL(r3);	 Catch:{ all -> 0x0075 }
        L_0x0018:
            if (r3 == 0) goto L_0x003f;	 Catch:{ all -> 0x0075 }
        L_0x001a:
            r4 = r1.essenceUL;	 Catch:{ all -> 0x0075 }
            r5 = r3.key;	 Catch:{ all -> 0x0075 }
            r4 = r4.equals(r5);	 Catch:{ all -> 0x0075 }
            if (r4 != 0) goto L_0x003f;	 Catch:{ all -> 0x0075 }
        L_0x0024:
            r4 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r4 = r4.ch;	 Catch:{ all -> 0x0075 }
            r5 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r5 = r5.ch;	 Catch:{ all -> 0x0075 }
            r5 = r5.position();	 Catch:{ all -> 0x0075 }
            r7 = r3.len;	 Catch:{ all -> 0x0075 }
            r5 = r5 + r7;	 Catch:{ all -> 0x0075 }
            r4.position(r5);	 Catch:{ all -> 0x0075 }
            r3 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r3 = r3.ch;	 Catch:{ all -> 0x0075 }
            r3 = org.jcodec.containers.mxf.model.KLV.readKL(r3);	 Catch:{ all -> 0x0075 }
            goto L_0x0018;	 Catch:{ all -> 0x0075 }
        L_0x003f:
            if (r3 == 0) goto L_0x0071;	 Catch:{ all -> 0x0075 }
        L_0x0041:
            r4 = r1.essenceUL;	 Catch:{ all -> 0x0075 }
            r5 = r3.key;	 Catch:{ all -> 0x0075 }
            r4 = r4.equals(r5);	 Catch:{ all -> 0x0075 }
            if (r4 == 0) goto L_0x0071;	 Catch:{ all -> 0x0075 }
        L_0x004b:
            r19 = new org.jcodec.containers.mxf.MXFDemuxer$MXFPacket;	 Catch:{ all -> 0x0075 }
            r4 = org.jcodec.containers.mxf.MXFDemuxer.this;	 Catch:{ all -> 0x0075 }
            r4 = r4.ch;	 Catch:{ all -> 0x0075 }
            r5 = r3.len;	 Catch:{ all -> 0x0075 }
            r3 = (int) r5;	 Catch:{ all -> 0x0075 }
            r5 = org.jcodec.common.NIOUtils.fetchFrom(r4, r3);	 Catch:{ all -> 0x0075 }
            r3 = r26;	 Catch:{ all -> 0x0075 }
            r8 = (long) r3;	 Catch:{ all -> 0x0075 }
            r3 = r27;	 Catch:{ all -> 0x0075 }
            r10 = (long) r3;	 Catch:{ all -> 0x0075 }
            r3 = r28;	 Catch:{ all -> 0x0075 }
            r12 = (long) r3;	 Catch:{ all -> 0x0075 }
            r3 = 0;	 Catch:{ all -> 0x0075 }
            r4 = r19;	 Catch:{ all -> 0x0075 }
            r6 = r24;	 Catch:{ all -> 0x0075 }
            r14 = r29;	 Catch:{ all -> 0x0075 }
            r15 = r3;	 Catch:{ all -> 0x0075 }
            r16 = r21;	 Catch:{ all -> 0x0075 }
            r18 = r23;	 Catch:{ all -> 0x0075 }
            r4.<init>(r5, r6, r8, r10, r12, r14, r15, r16, r18);	 Catch:{ all -> 0x0075 }
            goto L_0x0073;	 Catch:{ all -> 0x0075 }
        L_0x0071:
            r19 = 0;	 Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r2);	 Catch:{ all -> 0x0075 }
            return r19;	 Catch:{ all -> 0x0075 }
        L_0x0075:
            r0 = move-exception;	 Catch:{ all -> 0x0075 }
            r3 = r0;	 Catch:{ all -> 0x0075 }
            monitor-exit(r2);	 Catch:{ all -> 0x0075 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mxf.MXFDemuxer.MXFDemuxerTrack.readPacket(long, int, long, int, int, int, boolean):org.jcodec.containers.mxf.MXFDemuxer$MXFPacket");
        }

        public boolean gotoFrame(long j) {
            if (j == ((long) this.frameNo)) {
                return true;
            }
            this.indexSegmentSubIdx = (int) j;
            this.indexSegmentIdx = 0;
            while (this.indexSegmentIdx < MXFDemuxer.this.indexSegments.size() && ((long) this.indexSegmentSubIdx) >= ((IndexSegment) MXFDemuxer.this.indexSegments.get(this.indexSegmentIdx)).getIndexDuration()) {
                this.indexSegmentSubIdx = (int) (((long) this.indexSegmentSubIdx) - ((IndexSegment) MXFDemuxer.this.indexSegments.get(this.indexSegmentIdx)).getIndexDuration());
                this.indexSegmentIdx++;
            }
            this.indexSegmentSubIdx = Math.min(this.indexSegmentSubIdx, (int) ((IndexSegment) MXFDemuxer.this.indexSegments.get(this.indexSegmentIdx)).getIndexDuration());
            return true;
        }

        public boolean gotoSyncFrame(long j) {
            if (gotoFrame(j)) {
                return gotoFrame(j + ((long) ((IndexSegment) MXFDemuxer.this.indexSegments.get(this.indexSegmentIdx)).getIe().getKeyFrameOff()[this.indexSegmentSubIdx]));
            }
            return 0;
        }

        public long getCurFrame() {
            return (long) this.frameNo;
        }

        public void seek(double d) {
            throw new UnsupportedOperationException();
        }

        public UL getEssenceUL() {
            return this.essenceUL;
        }

        public GenericDescriptor getDescriptor() {
            return this.descriptor;
        }

        public MXFCodecMapping getCodec() {
            return this.codec;
        }

        private MXFCodecMapping resolveCodec() {
            UL pictureEssenceCoding;
            if (this.video) {
                pictureEssenceCoding = ((GenericPictureEssenceDescriptor) this.descriptor).getPictureEssenceCoding();
            } else if (!this.audio) {
                return null;
            } else {
                pictureEssenceCoding = ((GenericSoundEssenceDescriptor) this.descriptor).getSoundEssenceCompression();
            }
            Iterator it = EnumSet.allOf(MXFCodecMapping.class).iterator();
            while (it.hasNext()) {
                MXFCodecMapping mXFCodecMapping = (MXFCodecMapping) it.next();
                if (mXFCodecMapping.getUl().equals(pictureEssenceCoding, 65407)) {
                    return mXFCodecMapping;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unknown codec: ");
            stringBuilder.append(pictureEssenceCoding);
            Logger.warn(stringBuilder.toString());
            return null;
        }

        public int getTrackId() {
            return this.track.getTrackId();
        }

        public DemuxerTrackMeta getMeta() {
            Size size;
            if (this.video) {
                GenericPictureEssenceDescriptor genericPictureEssenceDescriptor = (GenericPictureEssenceDescriptor) this.descriptor;
                size = new Size(genericPictureEssenceDescriptor.getStoredWidth(), genericPictureEssenceDescriptor.getStoredHeight());
            } else {
                size = null;
            }
            Size size2 = size;
            Type type = this.video ? Type.VIDEO : this.audio ? Type.AUDIO : Type.OTHER;
            return new DemuxerTrackMeta(type, null, MXFDemuxer.this.totalFrames, MXFDemuxer.this.duration, size2);
        }
    }

    public MXFDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
        seekableByteChannel.position(0);
        parseHeader(seekableByteChannel);
        findIndex();
    }

    public OP getOp() {
        UL op = this.header.getPack().getOp();
        Iterator it = EnumSet.allOf(OP.class).iterator();
        while (it.hasNext()) {
            OP op2 = (OP) it.next();
            if (op.get(12) == op2.major && op.get(13) == op2.minor) {
                return op2;
            }
        }
        return OP.OPAtom;
    }

    private MXFDemuxerTrack[] findTracks() throws IOException {
        List arrayList = new ArrayList();
        List<TimelineTrack> findAllMeta = MXFUtil.findAllMeta(this.metadata, TimelineTrack.class);
        List findAllMeta2 = MXFUtil.findAllMeta(this.metadata, FileDescriptor.class);
        for (TimelineTrack timelineTrack : findAllMeta) {
            if (timelineTrack.getTrackNumber() != 0) {
                int trackNumber = timelineTrack.getTrackNumber();
                GenericDescriptor findDescriptor = findDescriptor(findAllMeta2, timelineTrack.getTrackId());
                if (findDescriptor == null) {
                    StringBuilder stringBuilder = new StringBuilder("No generic descriptor for track: ");
                    stringBuilder.append(timelineTrack.getTrackId());
                    Logger.warn(stringBuilder.toString());
                    if (findAllMeta2.size() == 1 && ((FileDescriptor) findAllMeta2.get(0)).getLinkedTrackId() == 0) {
                        findDescriptor = (FileDescriptor) findAllMeta2.get(0);
                    }
                }
                if (findDescriptor == null) {
                    StringBuilder stringBuilder2 = new StringBuilder("Track without descriptor: ");
                    stringBuilder2.append(timelineTrack.getTrackId());
                    Logger.warn(stringBuilder2.toString());
                } else {
                    MXFDemuxerTrack createTrack = createTrack(new UL(6, 14, 43, 52, 1, 2, 1, 1, 13, 1, 3, 1, (trackNumber >>> 24) & 255, (trackNumber >>> 16) & 255, (trackNumber >>> 8) & 255, trackNumber & 255), timelineTrack, findDescriptor);
                    if (createTrack.getCodec() != null || (findDescriptor instanceof WaveAudioDescriptor)) {
                        arrayList.add(createTrack);
                    }
                }
            }
        }
        return (MXFDemuxerTrack[]) arrayList.toArray(new MXFDemuxerTrack[0]);
    }

    public static FileDescriptor findDescriptor(List<FileDescriptor> list, int i) {
        for (FileDescriptor fileDescriptor : list) {
            if (fileDescriptor.getLinkedTrackId() == i) {
                return fileDescriptor;
            }
        }
        return null;
    }

    public MXFDemuxerTrack createTrack(UL ul, TimelineTrack timelineTrack, GenericDescriptor genericDescriptor) throws IOException {
        return new MXFDemuxerTrack(ul, timelineTrack, genericDescriptor);
    }

    public List<IndexSegment> getIndexes() {
        return this.indexSegments;
    }

    public List<MXFPartition> getEssencePartitions() {
        return this.partitions;
    }

    public TimecodeComponent getTimecode() {
        return this.timecode;
    }

    public void parseHeader(SeekableByteChannel seekableByteChannel) throws IOException {
        this.header = readHeaderPartition(seekableByteChannel);
        this.metadata = new ArrayList();
        this.partitions = new ArrayList();
        long size = seekableByteChannel.size();
        seekableByteChannel.position(this.header.getPack().getFooterPartition());
        do {
            long j = size;
            size = seekableByteChannel.position();
            KLV readKL = KLV.readKL(seekableByteChannel);
            this.header = MXFPartition.read(readKL.key, NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) readKL.len), seekableByteChannel.position() - readKL.offset, j);
            if (this.header.getPack().getNbEssenceContainers() > 0) {
                this.partitions.add(0, this.header);
            }
            this.metadata.addAll(0, readPartitionMeta(seekableByteChannel, this.header));
            seekableByteChannel.position(this.header.getPack().getPrevPartition());
        } while (this.header.getPack().getThisPartition() != 0);
    }

    public static List<MXFMetadata> readPartitionMeta(SeekableByteChannel seekableByteChannel, MXFPartition mXFPartition) throws IOException {
        long position = seekableByteChannel.position();
        List<MXFMetadata> arrayList = new ArrayList();
        ByteBuffer fetchFrom = NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) Math.max(0, mXFPartition.getEssenceFilePos() - position));
        while (fetchFrom.hasRemaining() != null) {
            mXFPartition = KLV.readKL(fetchFrom, position);
            if (mXFPartition == null) {
                break;
            }
            mXFPartition = parseMeta(mXFPartition.key, NIOUtils.read(fetchFrom, (int) mXFPartition.len));
            if (mXFPartition != null) {
                arrayList.add(mXFPartition);
            }
        }
        return arrayList;
    }

    public static MXFPartition readHeaderPartition(SeekableByteChannel seekableByteChannel) throws IOException {
        while (true) {
            KLV readKL = KLV.readKL(seekableByteChannel);
            if (readKL == null) {
                return null;
            }
            if (MXFConst.HEADER_PARTITION_KLV.equals(readKL.key)) {
                return MXFPartition.read(readKL.key, NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, (int) readKL.len), seekableByteChannel.position() - readKL.offset, 0);
            }
            seekableByteChannel.position(seekableByteChannel.position() + readKL.len);
        }
    }

    private static org.jcodec.containers.mxf.model.MXFMetadata parseMeta(org.jcodec.containers.mxf.model.UL r6, java.nio.ByteBuffer r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.jcodec.containers.mxf.MXFConst.klMetadataMapping;
        r0 = r0.get(r6);
        r0 = (java.lang.Class) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x001d;
    L_0x000b:
        r7 = new java.lang.StringBuilder;
        r0 = "Unknown metadata piece: ";
        r7.<init>(r0);
        r7.append(r6);
        r6 = r7.toString();
        org.jcodec.common.logging.Logger.warn(r6);
        return r1;
    L_0x001d:
        r2 = 1;
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0037 }
        r4 = org.jcodec.containers.mxf.model.UL.class;	 Catch:{ Exception -> 0x0037 }
        r5 = 0;	 Catch:{ Exception -> 0x0037 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0037 }
        r0 = r0.getConstructor(r3);	 Catch:{ Exception -> 0x0037 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0037 }
        r2[r5] = r6;	 Catch:{ Exception -> 0x0037 }
        r0 = r0.newInstance(r2);	 Catch:{ Exception -> 0x0037 }
        r0 = (org.jcodec.containers.mxf.model.MXFMetadata) r0;	 Catch:{ Exception -> 0x0037 }
        r0.read(r7);	 Catch:{ Exception -> 0x0037 }
        return r0;
    L_0x0037:
        r7 = new java.lang.StringBuilder;
        r0 = "Unknown metadata piece: ";
        r7.<init>(r0);
        r7.append(r6);
        r6 = r7.toString();
        org.jcodec.common.logging.Logger.warn(r6);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mxf.MXFDemuxer.parseMeta(org.jcodec.containers.mxf.model.UL, java.nio.ByteBuffer):org.jcodec.containers.mxf.model.MXFMetadata");
    }

    private void findIndex() {
        this.indexSegments = new ArrayList();
        for (MXFMetadata mXFMetadata : this.metadata) {
            if (mXFMetadata instanceof IndexSegment) {
                IndexSegment indexSegment = (IndexSegment) mXFMetadata;
                this.indexSegments.add(indexSegment);
                this.totalFrames = (int) (((long) this.totalFrames) + indexSegment.getIndexDuration());
                this.duration += (((double) indexSegment.getIndexEditRateDen()) * ((double) indexSegment.getIndexDuration())) / ((double) indexSegment.getIndexEditRateNum());
            }
        }
    }

    public MXFDemuxerTrack[] getTracks() {
        return this.tracks;
    }

    public MXFDemuxerTrack getVideoTrack() {
        for (MXFDemuxerTrack mXFDemuxerTrack : this.tracks) {
            if (mXFDemuxerTrack.isVideo()) {
                return mXFDemuxerTrack;
            }
        }
        return null;
    }

    public MXFDemuxerTrack[] getAudioTracks() {
        List arrayList = new ArrayList();
        for (MXFDemuxerTrack mXFDemuxerTrack : this.tracks) {
            if (mXFDemuxerTrack.isAudio()) {
                arrayList.add(mXFDemuxerTrack);
            }
        }
        return (MXFDemuxerTrack[]) arrayList.toArray(new MXFDemuxerTrack[0]);
    }
}
