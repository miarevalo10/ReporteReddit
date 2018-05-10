package org.jcodec.movtool.streaming;

import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderAtom;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChannelBox;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ClearApertureBox;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox.Entry;
import org.jcodec.containers.mp4.boxes.DataInfoBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.EncodedPixelBox;
import org.jcodec.containers.mp4.boxes.GenericMediaInfoBox;
import org.jcodec.containers.mp4.boxes.HandlerBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.MediaBox;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.ProductionApertureBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TimecodeMediaInfoBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.channel.ChannelUtils;
import org.jcodec.containers.mp4.muxer.FramesMP4MuxerTrack;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.movtool.streaming.VirtualMP4Movie.PacketChunk;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class MovieHelper {
    private static final int MEBABYTE = 1048576;
    private static int[] timescales = new int[]{AbstractSpiCall.DEFAULT_TIMEOUT, 12000, 15000, 24000, 25000, 30000, 50000, 41000, 48000, 96000};

    public static ByteBuffer produceHeader(PacketChunk[] packetChunkArr, VirtualTrack[] virtualTrackArr, long j, Brand brand) throws IOException {
        PacketChunk[] packetChunkArr2 = packetChunkArr;
        VirtualTrack[] virtualTrackArr2 = virtualTrackArr;
        ByteBuffer allocate = ByteBuffer.allocate(6291456);
        NodeBox movieBox = new MovieBox();
        double[] calcTrackDurations = calcTrackDurations(packetChunkArr, virtualTrackArr);
        int i = 1000;
        long calcMovieDuration = calcMovieDuration(virtualTrackArr2, 1000, calcTrackDurations);
        movieBox.add(movieHeader(movieBox, virtualTrackArr2.length, calcMovieDuration, 1000));
        int i2 = 0;
        while (i2 < virtualTrackArr2.length) {
            long j2;
            Size size;
            int i3;
            long j3;
            int i4;
            ByteBuffer byteBuffer;
            boolean z;
            CodecMeta codecMeta;
            VirtualTrack virtualTrack;
            Box box;
            int i5;
            Box trackHeaderBox;
            Box mediaBox;
            TrackType trackType;
            Box mediaInfoBox;
            Box nodeBox;
            SampleEntry[] sampleEntryArr;
            CodecMeta codecMeta2;
            int i6;
            VirtualTrack virtualTrack2 = virtualTrackArr2[i2];
            CodecMeta codecMeta3 = virtualTrack2.getCodecMeta();
            boolean z2 = codecMeta3 instanceof AudioCodecMeta;
            Object obj = (z2 && ((AudioCodecMeta) codecMeta3).isPCM()) ? 1 : null;
            int preferredTimescale = virtualTrack2.getPreferredTimescale();
            if (preferredTimescale <= 0) {
                preferredTimescale = obj != null ? getPCMTs((AudioCodecMeta) codecMeta3, packetChunkArr2, i2) : chooseTimescale(packetChunkArr2, i2);
            } else if (preferredTimescale < 100) {
                preferredTimescale *= 1000;
            } else if (preferredTimescale < i) {
                preferredTimescale *= 100;
            } else if (preferredTimescale < AbstractSpiCall.DEFAULT_TIMEOUT) {
                preferredTimescale *= 10;
            }
            int i7 = preferredTimescale;
            long j4 = (long) (((double) i7) * calcTrackDurations[i2]);
            Box trakBox = new TrakBox();
            Size size2 = new Size(0, 0);
            double[] dArr = calcTrackDurations;
            Size size3 = new Size(0, 0);
            if (codecMeta3 instanceof VideoCodecMeta) {
                VideoCodecMeta videoCodecMeta = (VideoCodecMeta) codecMeta3;
                Rational pasp = videoCodecMeta.getPasp();
                if (pasp == null) {
                    j2 = j4;
                    size = videoCodecMeta.getSize();
                    size3 = size;
                    i3 = i2 + 1;
                    j3 = j2;
                    i4 = i7;
                    byteBuffer = allocate;
                    z = z2;
                    codecMeta = codecMeta3;
                    virtualTrack = virtualTrack2;
                    box = trakBox;
                    i5 = i2;
                    j2 = calcMovieDuration;
                    trackHeaderBox = new TrackHeaderBox(i3, calcMovieDuration, (float) size.getWidth(), (float) size.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
                    trackHeaderBox.setFlags(15);
                    box.add(trackHeaderBox);
                    mediaBox = new MediaBox();
                    box.add(mediaBox);
                    mediaBox.add(new MediaHeaderBox(i4, j3, 0, new Date().getTime(), new Date().getTime(), 0));
                    trackType = z ? TrackType.SOUND : TrackType.VIDEO;
                    if (trackType == TrackType.VIDEO) {
                        Box nodeBox2 = new NodeBox(new Header(TrackApertureModeDimensionAtom.TYPE));
                        nodeBox2.add(new ClearApertureBox(size.getWidth(), size.getHeight()));
                        nodeBox2.add(new ProductionApertureBox(size.getWidth(), size.getHeight()));
                        nodeBox2.add(new EncodedPixelBox(size3.getWidth(), size3.getHeight()));
                        box.add(nodeBox2);
                    }
                    mediaBox.add(new HandlerBox("mhlr", trackType.getHandler(), "appl", 0, 0));
                    mediaInfoBox = new MediaInfoBox();
                    mediaBox.add(mediaInfoBox);
                    mediaHeader(mediaInfoBox, trackType);
                    mediaInfoBox.add(new HandlerBox("dhlr", DataEntryUrlBox.TYPE, "appl", 0, 0));
                    addDref(mediaInfoBox);
                    nodeBox = new NodeBox(new Header(SampleTableBox.TYPE));
                    mediaInfoBox.add(nodeBox);
                    sampleEntryArr = new SampleEntry[1];
                    codecMeta2 = codecMeta;
                    sampleEntryArr[0] = toSampleEntry(codecMeta2);
                    nodeBox.add(new SampleDescriptionBox(sampleEntryArr));
                    if (obj == null) {
                        populateStblPCM(nodeBox, packetChunkArr2, i5, codecMeta2);
                        i6 = i4;
                    } else {
                        i6 = i4;
                        populateStblGeneric(nodeBox, packetChunkArr2, i5, codecMeta2, i6);
                    }
                    i = 1000;
                    addEdits(box, virtualTrack, 1000, i6);
                    movieBox.add(box);
                    i2 = i3;
                    calcTrackDurations = dArr;
                    calcMovieDuration = j2;
                    allocate = byteBuffer;
                    virtualTrackArr2 = virtualTrackArr;
                } else {
                    size = videoCodecMeta.getSize();
                    j2 = j4;
                    size2 = new Size(pasp.multiplyS(size.getWidth()), size.getHeight());
                    size3 = size;
                }
            } else {
                j2 = j4;
            }
            size = size2;
            i3 = i2 + 1;
            j3 = j2;
            i4 = i7;
            byteBuffer = allocate;
            z = z2;
            codecMeta = codecMeta3;
            virtualTrack = virtualTrack2;
            box = trakBox;
            i5 = i2;
            j2 = calcMovieDuration;
            trackHeaderBox = new TrackHeaderBox(i3, calcMovieDuration, (float) size.getWidth(), (float) size.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
            trackHeaderBox.setFlags(15);
            box.add(trackHeaderBox);
            mediaBox = new MediaBox();
            box.add(mediaBox);
            mediaBox.add(new MediaHeaderBox(i4, j3, 0, new Date().getTime(), new Date().getTime(), 0));
            if (z) {
            }
            if (trackType == TrackType.VIDEO) {
                Box nodeBox22 = new NodeBox(new Header(TrackApertureModeDimensionAtom.TYPE));
                nodeBox22.add(new ClearApertureBox(size.getWidth(), size.getHeight()));
                nodeBox22.add(new ProductionApertureBox(size.getWidth(), size.getHeight()));
                nodeBox22.add(new EncodedPixelBox(size3.getWidth(), size3.getHeight()));
                box.add(nodeBox22);
            }
            mediaBox.add(new HandlerBox("mhlr", trackType.getHandler(), "appl", 0, 0));
            mediaInfoBox = new MediaInfoBox();
            mediaBox.add(mediaInfoBox);
            mediaHeader(mediaInfoBox, trackType);
            mediaInfoBox.add(new HandlerBox("dhlr", DataEntryUrlBox.TYPE, "appl", 0, 0));
            addDref(mediaInfoBox);
            nodeBox = new NodeBox(new Header(SampleTableBox.TYPE));
            mediaInfoBox.add(nodeBox);
            sampleEntryArr = new SampleEntry[1];
            codecMeta2 = codecMeta;
            sampleEntryArr[0] = toSampleEntry(codecMeta2);
            nodeBox.add(new SampleDescriptionBox(sampleEntryArr));
            if (obj == null) {
                i6 = i4;
                populateStblGeneric(nodeBox, packetChunkArr2, i5, codecMeta2, i6);
            } else {
                populateStblPCM(nodeBox, packetChunkArr2, i5, codecMeta2);
                i6 = i4;
            }
            i = 1000;
            addEdits(box, virtualTrack, 1000, i6);
            movieBox.add(box);
            i2 = i3;
            calcTrackDurations = dArr;
            calcMovieDuration = j2;
            allocate = byteBuffer;
            virtualTrackArr2 = virtualTrackArr;
        }
        ByteBuffer byteBuffer2 = allocate;
        brand.getFileTypeBox().write(byteBuffer2);
        movieBox.write(byteBuffer2);
        new Header(MediaDataBox.TYPE, j).write(byteBuffer2);
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private static SampleEntry toSampleEntry(CodecMeta codecMeta) {
        SampleEntry createMOVSampleEntry;
        Rational pasp;
        if (VisualSampleEntry.TYPE3.equals(codecMeta.getFourcc())) {
            createMOVSampleEntry = H264Utils.createMOVSampleEntry(H264Utils.parseAVCC(codecMeta.getCodecPrivate().duplicate()));
            pasp = ((VideoCodecMeta) codecMeta).getPasp();
        } else if (codecMeta instanceof VideoCodecMeta) {
            VideoCodecMeta videoCodecMeta = (VideoCodecMeta) codecMeta;
            Rational pasp2 = videoCodecMeta.getPasp();
            createMOVSampleEntry = MP4Muxer.videoSampleEntry(codecMeta.getFourcc(), videoCodecMeta.getSize(), "JCodec");
            pasp = pasp2;
        } else {
            AudioCodecMeta audioCodecMeta = (AudioCodecMeta) codecMeta;
            codecMeta = MP4Muxer.audioSampleEntry(codecMeta.getFourcc(), 0, audioCodecMeta.getSampleSize(), audioCodecMeta.getChannelCount(), audioCodecMeta.getSampleRate(), audioCodecMeta.getEndian());
            ChannelBox channelBox = new ChannelBox();
            ChannelUtils.setLabels(audioCodecMeta.getChannelLabels(), channelBox);
            codecMeta.add(channelBox);
            createMOVSampleEntry = codecMeta;
            pasp = null;
        }
        if (pasp != null) {
            createMOVSampleEntry.add(new PixelAspectExt(pasp));
        }
        return createMOVSampleEntry;
    }

    private static int chooseTimescale(PacketChunk[] packetChunkArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < packetChunkArr.length; i3++) {
            if (packetChunkArr[i3].getTrackNo() == i) {
                packetChunkArr = packetChunkArr[i3].getPacket().getDuration();
                double d = Double.MAX_VALUE;
                int i4 = -1;
                while (i2 < timescales.length) {
                    double d2 = ((double) timescales[i2]) * packetChunkArr;
                    d2 -= (double) ((int) d2);
                    if (d2 < d) {
                        i4 = i2;
                        d = d2;
                    }
                    i2++;
                }
                return timescales[i4];
            }
        }
        return 0;
    }

    private static void addEdits(TrakBox trakBox, VirtualTrack virtualTrack, int i, int i2) {
        virtualTrack = virtualTrack.getEdits();
        if (virtualTrack != null) {
            List arrayList = new ArrayList();
            for (VirtualEdit virtualEdit : virtualTrack) {
                arrayList.add(new Edit((long) ((int) (virtualEdit.getDuration() * ((double) i))), (long) ((int) (virtualEdit.getIn() * ((double) i2))), 1.0f));
            }
            trakBox.setEdits(arrayList);
        }
    }

    private static long calcMovieDuration(VirtualTrack[] virtualTrackArr, int i, double[] dArr) {
        long j = 0;
        for (int i2 = 0; i2 < virtualTrackArr.length; i2++) {
            j = Math.max(j, (long) (((double) i) * dArr[i2]));
        }
        return j;
    }

    private static double[] calcTrackDurations(PacketChunk[] packetChunkArr, VirtualTrack[] virtualTrackArr) {
        int i = 0;
        virtualTrackArr = new double[virtualTrackArr.length];
        Arrays.fill(virtualTrackArr, -1.0d);
        for (int length = packetChunkArr.length - 1; length >= 0 && i < virtualTrackArr.length; length--) {
            PacketChunk packetChunk = packetChunkArr[length];
            int trackNo = packetChunk.getTrackNo();
            if (virtualTrackArr[trackNo] == -1.0d) {
                virtualTrackArr[trackNo] = packetChunk.getPacket().getPts() + packetChunk.getPacket().getDuration();
                i++;
            }
        }
        return virtualTrackArr;
    }

    private static void populateStblGeneric(NodeBox nodeBox, PacketChunk[] packetChunkArr, int i, CodecMeta codecMeta, int i2) throws IOException {
        NodeBox nodeBox2;
        NodeBox nodeBox3 = nodeBox;
        PacketChunk[] packetChunkArr2 = packetChunkArr;
        LongArrayList longArrayList = new LongArrayList(256000);
        IntArrayList intArrayList = new IntArrayList(256000);
        List arrayList = new ArrayList();
        IntArrayList intArrayList2 = new IntArrayList(4096);
        List arrayList2 = new ArrayList();
        long j = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        int i8 = 1;
        while (i3 < packetChunkArr2.length) {
            int i9;
            PacketChunk packetChunk = packetChunkArr2[i3];
            if (packetChunk.getTrackNo() == i) {
                int i10;
                longArrayList.add(packetChunk.getPos());
                intArrayList.add(Math.max(0, packetChunk.getDataLen()));
                i9 = i3;
                double d = (double) i2;
                int round = (int) Math.round(packetChunk.getPacket().getDuration() * d);
                if (round != i4) {
                    if (i7 != -1) {
                        arrayList.add(new TimeToSampleEntry(i7, i4));
                    }
                    i4 = round;
                    i10 = 1;
                    i7 = 0;
                } else {
                    i10 = 1;
                }
                i7 += i10;
                boolean isKeyframe = packetChunk.getPacket().isKeyframe();
                i8 &= isKeyframe;
                if (isKeyframe) {
                    intArrayList2.add(packetChunk.getPacket().getFrameNo() + 1);
                }
                i10 = (int) (Math.round(packetChunk.getPacket().getPts() * d) - j);
                if (i10 != i6) {
                    if (i5 > 0) {
                        arrayList2.add(new Entry(i5, i6));
                    }
                    i6 = i10;
                    i10 = 1;
                    i5 = 0;
                } else {
                    i10 = 1;
                }
                i5 += i10;
                j += (long) round;
            } else {
                int i11 = i2;
                i9 = i3;
            }
            i3 = i9 + 1;
            nodeBox3 = nodeBox;
            packetChunkArr2 = packetChunkArr;
        }
        if (arrayList2.size() > 0) {
            arrayList2.add(new Entry(i5, i6));
        }
        if (i7 > 0) {
            arrayList.add(new TimeToSampleEntry(i7, i4));
        }
        if (i8 == 0) {
            nodeBox2 = nodeBox;
            nodeBox2.add(new SyncSamplesBox(intArrayList2.toArray()));
        } else {
            nodeBox2 = nodeBox;
        }
        nodeBox2.add(new ChunkOffsets64Box(longArrayList.toArray()));
        nodeBox2.add(new SampleToChunkBox(new SampleToChunkEntry[]{new SampleToChunkEntry(1, 1, 1)}));
        nodeBox2.add(new SampleSizesBox(intArrayList.toArray()));
        nodeBox2.add(new TimeToSampleBox((TimeToSampleEntry[]) arrayList.toArray(new TimeToSampleEntry[0])));
        compositionOffsets(arrayList2, nodeBox2);
    }

    private static void compositionOffsets(List<Entry> list, NodeBox nodeBox) {
        if (list.size() > 0) {
            int minOffset = FramesMP4MuxerTrack.minOffset(list);
            for (Entry entry : list) {
                entry.offset -= minOffset;
            }
            nodeBox.add(new CompositionOffsetsBox((Entry[]) list.toArray(new Entry[0])));
        }
    }

    private static void populateStblPCM(NodeBox nodeBox, PacketChunk[] packetChunkArr, int i, CodecMeta codecMeta) throws IOException {
        NodeBox nodeBox2 = nodeBox;
        PacketChunk[] packetChunkArr2 = packetChunkArr;
        AudioCodecMeta audioCodecMeta = (AudioCodecMeta) codecMeta;
        int frameSize = audioCodecMeta.getFrameSize();
        LongArrayList longArrayList = new LongArrayList(256000);
        List arrayList = new ArrayList();
        int i2 = -1;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < packetChunkArr2.length) {
            int i7;
            PacketChunk packetChunk = packetChunkArr2[i4];
            if (packetChunk.getTrackNo() == i) {
                i7 = i4;
                longArrayList.add(packetChunk.getPos());
                int dataLen = packetChunk.getDataLen() / frameSize;
                if (dataLen != i2) {
                    if (i2 != -1) {
                        arrayList.add(new SampleToChunkEntry((long) i3, i2, 1));
                    }
                    i2 = dataLen;
                    i3 = i6;
                }
                i6++;
                i5 += dataLen;
            } else {
                i7 = i4;
            }
            i4 = i7 + 1;
        }
        if (i2 != -1) {
            arrayList.add(new SampleToChunkEntry((long) i3, i2, 1));
        }
        nodeBox2.add(new ChunkOffsets64Box(longArrayList.toArray()));
        nodeBox2.add(new SampleToChunkBox((SampleToChunkEntry[]) arrayList.toArray(new SampleToChunkEntry[0])));
        nodeBox2.add(new SampleSizesBox(audioCodecMeta.getFrameSize(), i5));
        nodeBox2.add(new TimeToSampleBox(new TimeToSampleEntry[]{new TimeToSampleEntry(i5, 1)}));
    }

    private static int getPCMTs(AudioCodecMeta audioCodecMeta, PacketChunk[] packetChunkArr, int i) throws IOException {
        for (int i2 = 0; i2 < packetChunkArr.length; i2++) {
            if (packetChunkArr[i2].getTrackNo() == i) {
                return (int) Math.round(((double) packetChunkArr[i2].getDataLen()) / (((double) audioCodecMeta.getFrameSize()) * packetChunkArr[i2].getPacket().getDuration()));
            }
        }
        throw new RuntimeException("Crap");
    }

    private static void mediaHeader(MediaInfoBox mediaInfoBox, TrackType trackType) {
        switch (trackType) {
            case VIDEO:
                trackType = new VideoMediaHeaderBox(0, 0, 0, 0);
                trackType.setFlags(1);
                mediaInfoBox.add(trackType);
                return;
            case SOUND:
                trackType = new SoundMediaHeaderBox();
                trackType.setFlags(1);
                mediaInfoBox.add(trackType);
                return;
            case TIMECODE:
                trackType = new NodeBox(new Header(GenericMediaHeaderAtom.TYPE));
                trackType.add(new GenericMediaInfoBox());
                Box nodeBox = new NodeBox(new Header(TimeCodeBox.TYPE));
                trackType.add(nodeBox);
                nodeBox.add(new TimecodeMediaInfoBox((short) 0, (short) 0, (short) 12, new short[]{(short) 0, (short) 0, (short) 0}, new short[]{(short) 255, (short) 255, (short) 255}, "Lucida Grande"));
                mediaInfoBox.add(trackType);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Handler ");
                stringBuilder.append(trackType.getHandler());
                stringBuilder.append(" not supported");
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static void addDref(NodeBox nodeBox) {
        Box dataInfoBox = new DataInfoBox();
        nodeBox.add(dataInfoBox);
        nodeBox = new DataRefBox();
        dataInfoBox.add(nodeBox);
        nodeBox.add(new LeafBox(new Header("alis", 0), ByteBuffer.wrap(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1})));
    }

    private static MovieHeaderBox movieHeader(NodeBox nodeBox, int i, long j, int i2) {
        return new MovieHeaderBox(i2, j, 1.0f, 1.0f, new Date().getTime(), new Date().getTime(), new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824}, i + 1);
    }
}
