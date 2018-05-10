package org.jcodec.containers.mps;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.EnumSet;
import java.util.Iterator;
import org.jcodec.common.Assert;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PMTSection;
import org.jcodec.containers.mps.psi.PMTSection.PMTStream;
import org.jcodec.containers.mps.psi.PSISection;

public class MTSUtils {

    public enum StreamType {
        RESERVED(0, false, false),
        VIDEO_MPEG1(1, true, false),
        VIDEO_MPEG2(2, true, false),
        AUDIO_MPEG1(3, false, true),
        AUDIO_MPEG2(4, false, true),
        PRIVATE_SECTION(5, false, false),
        PRIVATE_DATA(6, false, false),
        MHEG(7, false, false),
        DSM_CC(8, false, false),
        ATM_SYNC(9, false, false),
        DSM_CC_A(10, false, false),
        DSM_CC_B(11, false, false),
        DSM_CC_C(12, false, false),
        DSM_CC_D(13, false, false),
        MPEG_AUX(14, false, false),
        AUDIO_AAC_ADTS(15, false, true),
        VIDEO_MPEG4(16, true, false),
        AUDIO_AAC_LATM(17, false, true),
        FLEXMUX_PES(18, false, false),
        FLEXMUX_SEC(19, false, false),
        DSM_CC_SDP(20, false, false),
        META_PES(21, false, false),
        META_SEC(22, false, false),
        DSM_CC_DATA_CAROUSEL(23, false, false),
        DSM_CC_OBJ_CAROUSEL(24, false, false),
        DSM_CC_SDP1(25, false, false),
        IPMP(26, false, false),
        VIDEO_H264(27, true, false),
        AUDIO_AAC_RAW(28, false, true),
        SUBS(29, false, false),
        AUX_3D(30, false, false),
        VIDEO_AVC_SVC(31, true, false),
        VIDEO_AVC_MVC(32, true, false),
        VIDEO_J2K(33, true, false),
        VIDEO_MPEG2_3D(34, true, false),
        VIDEO_H264_3D(35, true, false),
        VIDEO_CAVS(66, false, true),
        IPMP_STREAM(127, false, false),
        AUDIO_AC3(129, false, true),
        AUDIO_DTS(138, false, true);
        
        private static EnumSet<StreamType> typeEnum;
        private boolean audio;
        private int tag;
        private boolean video;

        static {
            typeEnum = EnumSet.allOf(StreamType.class);
        }

        private StreamType(int i, boolean z, boolean z2) {
            this.tag = i;
            this.video = z;
            this.audio = z2;
        }

        public static StreamType fromTag(int i) {
            Iterator it = typeEnum.iterator();
            while (it.hasNext()) {
                StreamType streamType = (StreamType) it.next();
                if (streamType.tag == i) {
                    return streamType;
                }
            }
            return 0;
        }

        public final int getTag() {
            return this.tag;
        }

        public final boolean isVideo() {
            return this.video;
        }

        public final boolean isAudio() {
            return this.audio;
        }
    }

    public static abstract class TSReader {
        public static final int BUFFER_SIZE = 96256;

        public abstract boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j);

        public void readTsFile(SeekableByteChannel seekableByteChannel) throws IOException {
            seekableByteChannel.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(96256);
            while (true) {
                long position = seekableByteChannel.position();
                if (seekableByteChannel.read(allocate) != -1) {
                    allocate.flip();
                    while (allocate.hasRemaining()) {
                        ByteBuffer read = NIOUtils.read(allocate, 188);
                        position += 188;
                        Assert.assertEquals(71, read.get() & 255);
                        int i = ((read.get() & 255) << 8) | (read.get() & 255);
                        int i2 = i & 8191;
                        i = (i >> 14) & 1;
                        if (((read.get() & 255) & 32) != 0) {
                            NIOUtils.skip(read, read.get() & 255);
                        }
                        boolean z = false;
                        int i3 = (i == 1 && (NIOUtils.getRel(read, NIOUtils.getRel(read, 0) + 2) & 128) == 128) ? 1 : false;
                        if (i3 != 0) {
                            NIOUtils.skip(read, read.get() & 255);
                        }
                        if (i == 1) {
                            z = true;
                        }
                        if (!onPkt(i2, z, read, position - ((long) read.remaining()))) {
                            return;
                        }
                    }
                    allocate.flip();
                } else {
                    return;
                }
            }
        }
    }

    private static class PMTExtractor extends TSReader {
        PMTSection f33287a;
        private int f33288b;

        private PMTExtractor() {
            this.f33288b = -1;
        }

        protected boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j) {
            if (i == 0) {
                this.f33288b = MTSUtils.parsePAT(byteBuffer);
            } else if (this.f33288b != -1 && i == this.f33288b) {
                this.f33287a = MTSUtils.parsePMT(byteBuffer);
                return false;
            }
            return true;
        }
    }

    private static void parseEsInfo(ByteBuffer byteBuffer) {
    }

    @Deprecated
    public static int parsePAT(ByteBuffer byteBuffer) {
        byteBuffer = PATSection.parse(byteBuffer);
        return byteBuffer.getPrograms().size() > 0 ? byteBuffer.getPrograms().values()[0] : -1;
    }

    @Deprecated
    public static PMTSection parsePMT(ByteBuffer byteBuffer) {
        return PMTSection.parse(byteBuffer);
    }

    @Deprecated
    public static PSISection parseSection(ByteBuffer byteBuffer) {
        return PSISection.parse(byteBuffer);
    }

    public static PMTStream[] getProgramGuids(File file) throws IOException {
        Throwable th;
        ReadableByteChannel readableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                PMTStream[] programGuids = getProgramGuids((SeekableByteChannel) readableFileChannel);
                NIOUtils.closeQuietly(readableFileChannel);
                return programGuids;
            } catch (Throwable th2) {
                th = th2;
                NIOUtils.closeQuietly(readableFileChannel);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            readableFileChannel = null;
            NIOUtils.closeQuietly(readableFileChannel);
            throw th;
        }
    }

    public static PMTStream[] getProgramGuids(SeekableByteChannel seekableByteChannel) throws IOException {
        PMTExtractor pMTExtractor = new PMTExtractor();
        pMTExtractor.readTsFile(seekableByteChannel);
        return pMTExtractor.f33287a.getStreams();
    }

    public static int getVideoPid(File file) throws IOException {
        for (PMTStream pMTStream : getProgramGuids(file)) {
            if (pMTStream.getStreamType().isVideo()) {
                return pMTStream.getPid();
            }
        }
        throw new RuntimeException("No video stream");
    }

    public static int getAudioPid(File file) throws IOException {
        for (PMTStream pMTStream : getProgramGuids(file)) {
            if (pMTStream.getStreamType().isVideo()) {
                return pMTStream.getPid();
            }
        }
        throw new RuntimeException("No video stream");
    }

    public static int[] getMediaPids(SeekableByteChannel seekableByteChannel) throws IOException {
        return filterMediaPids(getProgramGuids(seekableByteChannel));
    }

    public static int[] getMediaPids(File file) throws IOException {
        return filterMediaPids(getProgramGuids(file));
    }

    private static int[] filterMediaPids(PMTStream[] pMTStreamArr) {
        IntArrayList intArrayList = new IntArrayList();
        for (PMTStream pMTStream : pMTStreamArr) {
            if (pMTStream.getStreamType().isVideo() || pMTStream.getStreamType().isAudio()) {
                intArrayList.add(pMTStream.getPid());
            }
        }
        return intArrayList.toArray();
    }
}
