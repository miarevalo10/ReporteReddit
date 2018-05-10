package org.jcodec.containers.mkv.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mkv.MKVParser;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlFloat;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.boxes.MkvBlock;

public final class MKVDemuxer {
    private static final TapeTimecode ZERO_TAPE_TIMECODE = new TapeTimecode((short) 0, (byte) 0, (byte) 0, (byte) 0, false);
    private List<DemuxerTrack> aTracks = new ArrayList();
    private SeekableByteChannel channel;
    int pictureHeight;
    int pictureWidth;
    private List<EbmlMaster> f26812t;
    long timescale = 1;
    private VideoTrack vTrack = null;

    public static class IndexedBlock {
        public MkvBlock block;
        public int firstFrameNo;

        public static IndexedBlock make(int i, MkvBlock mkvBlock) {
            IndexedBlock indexedBlock = new IndexedBlock();
            indexedBlock.firstFrameNo = i;
            indexedBlock.block = mkvBlock;
            return indexedBlock;
        }
    }

    public class AudioTrack implements SeekableDemuxerTrack {
        private int blockIdx = 0;
        List<IndexedBlock> blocks = new ArrayList();
        private int frameIdx = 0;
        private int frameInBlockIdx = 0;
        private int framesCount = 0;
        public double samplingFrequency;
        public final int trackNo;

        static /* synthetic */ int access$012(AudioTrack audioTrack, int i) {
            int i2 = audioTrack.framesCount + i;
            audioTrack.framesCount = i2;
            return i2;
        }

        public AudioTrack(int i) {
            this.trackNo = i;
        }

        public Packet nextFrame() throws IOException {
            if (this.frameIdx > this.blocks.size()) {
                return null;
            }
            MkvBlock mkvBlock = ((IndexedBlock) this.blocks.get(this.blockIdx)).block;
            if (mkvBlock == null) {
                throw new RuntimeException("Something somewhere went wrong.");
            }
            if (mkvBlock.frames == null || mkvBlock.frames.length == 0) {
                MKVDemuxer.this.channel.position(mkvBlock.dataOffset);
                ByteBuffer allocate = ByteBuffer.allocate(mkvBlock.dataLen);
                MKVDemuxer.this.channel.read(allocate);
                mkvBlock.readFrames(allocate);
            }
            ByteBuffer duplicate = mkvBlock.frames[this.frameInBlockIdx].duplicate();
            this.frameInBlockIdx++;
            this.frameIdx++;
            if (this.frameInBlockIdx >= mkvBlock.frames.length) {
                this.blockIdx++;
                this.frameInBlockIdx = 0;
            }
            return new Packet(duplicate, mkvBlock.absoluteTimecode, Math.round(this.samplingFrequency), 1, 0, false, MKVDemuxer.ZERO_TAPE_TIMECODE);
        }

        public boolean gotoFrame(long j) {
            if (j > 2147483647L || j > ((long) this.framesCount)) {
                return false;
            }
            int findBlockIndex = findBlockIndex(j);
            if (findBlockIndex == -1) {
                return false;
            }
            j = (int) j;
            this.frameIdx = j;
            this.blockIdx = findBlockIndex;
            this.frameInBlockIdx = j - ((IndexedBlock) this.blocks.get(this.blockIdx)).firstFrameNo;
            return 1;
        }

        private int findBlockIndex(long j) {
            for (int i = 0; i < this.blocks.size(); i++) {
                if (j < ((long) ((IndexedBlock) this.blocks.get(i)).block.frameSizes.length)) {
                    return i;
                }
                j -= (long) ((IndexedBlock) this.blocks.get(i)).block.frameSizes.length;
            }
            return -1;
        }

        public long getCurFrame() {
            return (long) this.frameIdx;
        }

        public void seek(double d) {
            throw new RuntimeException("Not implemented yet");
        }

        public Packet getFrames(int i) {
            if (i + this.frameIdx >= this.framesCount) {
                return null;
            }
            int i2;
            ByteBuffer allocate;
            List<ByteBuffer> arrayList = new ArrayList();
            MkvBlock mkvBlock = ((IndexedBlock) r1.blocks.get(r1.blockIdx)).block;
            int i3 = i;
            while (true) {
                i2 = 0;
                if (i3 <= 0) {
                    break;
                }
                MkvBlock mkvBlock2 = ((IndexedBlock) r1.blocks.get(r1.blockIdx)).block;
                if (mkvBlock2.frames == null || mkvBlock2.frames.length == 0) {
                    try {
                        MKVDemuxer.this.channel.position(mkvBlock2.dataOffset);
                        allocate = ByteBuffer.allocate(mkvBlock2.dataLen);
                        MKVDemuxer.this.channel.read(allocate);
                        mkvBlock2.readFrames(allocate);
                    } catch (Throwable e) {
                        Throwable th = e;
                        StringBuilder stringBuilder = new StringBuilder("while reading frames of a Block at offset 0x");
                        stringBuilder.append(Long.toHexString(mkvBlock2.dataOffset).toUpperCase());
                        stringBuilder.append(")");
                        throw new RuntimeException(stringBuilder.toString(), th);
                    }
                }
                arrayList.add(mkvBlock2.frames[r1.frameInBlockIdx].duplicate());
                r1.frameIdx++;
                r1.frameInBlockIdx++;
                if (r1.frameInBlockIdx >= mkvBlock2.frames.length) {
                    r1.frameInBlockIdx = 0;
                    r1.blockIdx++;
                }
                i3--;
            }
            for (ByteBuffer limit : arrayList) {
                i2 += limit.limit();
            }
            allocate = ByteBuffer.allocate(i2);
            for (ByteBuffer put : arrayList) {
                allocate.put(put);
            }
            return new Packet(allocate, mkvBlock.absoluteTimecode, Math.round(r1.samplingFrequency), (long) arrayList.size(), 0, false, MKVDemuxer.ZERO_TAPE_TIMECODE);
        }

        public DemuxerTrackMeta getMeta() {
            throw new RuntimeException("Unsupported");
        }

        public boolean gotoSyncFrame(long j) {
            return gotoFrame(j);
        }
    }

    public class VideoTrack implements SeekableDemuxerTrack {
        List<MkvBlock> blocks = new ArrayList();
        private int frameIdx = null;
        private ByteBuffer state;
        public final int trackNo;

        public VideoTrack(int i, ByteBuffer byteBuffer) {
            this.trackNo = i;
            this.state = byteBuffer;
        }

        public Packet nextFrame() throws IOException {
            if (this.frameIdx >= this.blocks.size()) {
                return null;
            }
            MkvBlock mkvBlock = (MkvBlock) this.blocks.get(this.frameIdx);
            if (mkvBlock == null) {
                throw new RuntimeException("Something somewhere went wrong.");
            }
            this.frameIdx++;
            MKVDemuxer.this.channel.position(mkvBlock.dataOffset);
            ByteBuffer allocate = ByteBuffer.allocate(mkvBlock.dataLen);
            MKVDemuxer.this.channel.read(allocate);
            allocate.flip();
            mkvBlock.readFrames(allocate.duplicate());
            long j = 1;
            if (this.frameIdx < this.blocks.size()) {
                j = ((MkvBlock) this.blocks.get(this.frameIdx)).absoluteTimecode - mkvBlock.absoluteTimecode;
            }
            return new Packet(mkvBlock.frames[0].duplicate(), mkvBlock.absoluteTimecode, MKVDemuxer.this.timescale, j, (long) (this.frameIdx - 1), mkvBlock.keyFrame, MKVDemuxer.ZERO_TAPE_TIMECODE);
        }

        public boolean gotoFrame(long j) {
            if (j > 2147483647L || j > ((long) this.blocks.size())) {
                return false;
            }
            this.frameIdx = (int) j;
            return 1;
        }

        public long getCurFrame() {
            return (long) this.frameIdx;
        }

        public void seek(double d) {
            throw new RuntimeException("Not implemented yet");
        }

        public int getFrameCount() {
            return this.blocks.size();
        }

        public ByteBuffer getCodecState() {
            return this.state;
        }

        public DemuxerTrackMeta getMeta() {
            throw new RuntimeException("Unsupported");
        }

        public boolean gotoSyncFrame(long j) {
            throw new RuntimeException("Unsupported");
        }
    }

    public MKVDemuxer(List<EbmlMaster> list, SeekableByteChannel seekableByteChannel) {
        this.f26812t = list;
        this.channel = seekableByteChannel;
        demux();
    }

    private void demux() {
        EbmlUint ebmlUint = (EbmlUint) MKVType.findFirst(this.f26812t, MKVType.Segment, MKVType.Info, MKVType.TimecodeScale);
        if (ebmlUint != null) {
            this.timescale = ebmlUint.get();
        }
        for (EbmlBase ebmlBase : MKVType.findList(this.f26812t, EbmlMaster.class, MKVType.Segment, MKVType.Tracks, MKVType.TrackEntry)) {
            long j = ((EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.TrackType)).get();
            long j2 = ((EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.TrackNumber)).get();
            if (j == 1) {
                if (this.vTrack != null) {
                    throw new RuntimeException("More then 1 video track, can not compute...");
                }
                EbmlBin ebmlBin = (EbmlBin) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.CodecPrivate);
                ByteBuffer byteBuffer = null;
                if (ebmlBin != null) {
                    byteBuffer = ebmlBin.data;
                }
                EbmlUint ebmlUint2 = (EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Video, MKVType.PixelWidth);
                EbmlUint ebmlUint3 = (EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Video, MKVType.PixelHeight);
                EbmlUint ebmlUint4 = (EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Video, MKVType.DisplayWidth);
                EbmlUint ebmlUint5 = (EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Video, MKVType.DisplayHeight);
                EbmlUint ebmlUint6 = (EbmlUint) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Video, MKVType.DisplayUnit);
                if (ebmlUint2 != null && ebmlUint3 != null) {
                    this.pictureWidth = (int) ebmlUint2.get();
                    this.pictureHeight = (int) ebmlUint3.get();
                } else if (!(ebmlUint4 == null || ebmlUint5 == null)) {
                    if (ebmlUint6 != null) {
                        if (ebmlUint6.get() != 0) {
                            throw new RuntimeException("DisplayUnits other then 0 are not implemented yet");
                        }
                    }
                    this.pictureHeight = (int) ebmlUint5.get();
                    this.pictureWidth = (int) ebmlUint4.get();
                }
                this.vTrack = new VideoTrack((int) j2, byteBuffer);
            } else if (j == 2) {
                AudioTrack audioTrack = new AudioTrack((int) j2);
                EbmlFloat ebmlFloat = (EbmlFloat) MKVType.findFirst(ebmlBase, MKVType.TrackEntry, MKVType.Audio, MKVType.SamplingFrequency);
                if (ebmlFloat != null) {
                    audioTrack.samplingFrequency = ebmlFloat.get();
                }
                this.aTracks.add(audioTrack);
            }
        }
        for (EbmlBase ebmlBase2 : MKVType.findList(this.f26812t, EbmlMaster.class, MKVType.Segment, MKVType.Cluster)) {
            long j3 = ((EbmlUint) MKVType.findFirst(ebmlBase2, MKVType.Cluster, MKVType.Timecode)).get();
            Iterator it = ebmlBase2.children.iterator();
            while (it.hasNext()) {
                EbmlBase ebmlBase3 = (EbmlBase) it.next();
                if (MKVType.SimpleBlock.equals(ebmlBase3.type)) {
                    MkvBlock mkvBlock = (MkvBlock) ebmlBase3;
                    mkvBlock.absoluteTimecode = ((long) mkvBlock.timecode) + j3;
                    putIntoRightBasket(mkvBlock);
                } else if (MKVType.BlockGroup.equals(ebmlBase3.type)) {
                    Iterator it2 = ((EbmlMaster) ebmlBase3).children.iterator();
                    while (it2.hasNext()) {
                        if (MKVType.Block.equals((EbmlBase) it2.next())) {
                            MkvBlock mkvBlock2 = (MkvBlock) ebmlBase3;
                            mkvBlock2.absoluteTimecode = ((long) mkvBlock2.timecode) + j3;
                            putIntoRightBasket(mkvBlock2);
                        }
                    }
                }
            }
        }
    }

    private void putIntoRightBasket(MkvBlock mkvBlock) {
        if (mkvBlock.trackNumber == ((long) this.vTrack.trackNo)) {
            this.vTrack.blocks.add(mkvBlock);
            return;
        }
        for (int i = 0; i < this.aTracks.size(); i++) {
            AudioTrack audioTrack = (AudioTrack) this.aTracks.get(i);
            if (mkvBlock.trackNumber == ((long) audioTrack.trackNo)) {
                audioTrack.blocks.add(IndexedBlock.make(audioTrack.framesCount, mkvBlock));
                AudioTrack.access$012(audioTrack, mkvBlock.frameSizes.length);
            }
        }
    }

    public static MKVDemuxer getDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        return new MKVDemuxer(new MKVParser(seekableByteChannel).parse(), seekableByteChannel);
    }

    public final DemuxerTrack getVideoTrack() {
        return this.vTrack;
    }

    public final int getPictureWidth() {
        return this.pictureWidth;
    }

    public final int getPictureHeight() {
        return this.pictureHeight;
    }

    public final List<DemuxerTrack> getAudioTracks() {
        return this.aTracks;
    }
}
