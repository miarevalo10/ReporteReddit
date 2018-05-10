package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.NIOUtils.FileReader;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.ChannelLabel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.MPSUtils.PESReader;

public class MPSMediaInfo extends PESReader {
    private Map<Integer, MPEGTrackMetadata> infos = new HashMap();
    private int pesTried;
    private PSM psm;

    public class MPEGTimecodeMetadata {
        public String getNumFrames() {
            return null;
        }

        public String getStartCounter() {
            return null;
        }

        public String isDropFrame() {
            return null;
        }
    }

    public class MPEGTrackMetadata {
        Codec codec;
        ByteBuffer probeData;
        int streamId;

        public AudioFormat getAudioFormat() {
            return null;
        }

        public ChannelLabel[] getChannelLables() {
            return null;
        }

        public Size getCodedSize() {
            return null;
        }

        public Size getDisplaySize() {
            return null;
        }

        public float getDuration() {
            return 0.0f;
        }

        public String getFourcc() {
            return null;
        }

        public float getFps() {
            return 0.0f;
        }

        public Rational getFpsR() {
            return null;
        }

        public int getNumFrames() {
            return 0;
        }

        public MPEGTimecodeMetadata getTimecode() {
            return null;
        }

        public MPEGTrackMetadata(int i) {
            this.streamId = i;
        }
    }

    public class MediaInfoDone extends RuntimeException {
    }

    public static class PSM {
    }

    class C26451 extends FileReader {
        final /* synthetic */ MPSMediaInfo f33272a;

        protected void done() {
        }

        C26451(MPSMediaInfo mPSMediaInfo) {
            this.f33272a = mPSMediaInfo;
        }

        protected void data(ByteBuffer byteBuffer, long j) {
            this.f33272a.analyseBuffer(byteBuffer, j);
        }
    }

    public static MPSMediaInfo extract(SeekableByteChannel seekableByteChannel) {
        return null;
    }

    public List<MPEGTrackMetadata> getAudioTracks() {
        return null;
    }

    public MPEGTrackMetadata getVideoTrack() {
        return null;
    }

    public java.util.List<org.jcodec.codecs.mpeg12.MPSMediaInfo.MPEGTrackMetadata> getMediaInfo(java.io.File r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.jcodec.codecs.mpeg12.MPSMediaInfo$1;	 Catch:{ MediaInfoDone -> 0x000c }
        r0.<init>(r3);	 Catch:{ MediaInfoDone -> 0x000c }
        r1 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;	 Catch:{ MediaInfoDone -> 0x000c }
        r2 = 0;	 Catch:{ MediaInfoDone -> 0x000c }
        r0.readFile(r4, r1, r2);	 Catch:{ MediaInfoDone -> 0x000c }
        goto L_0x0011;
    L_0x000c:
        r4 = "Media info done";
        org.jcodec.common.logging.Logger.info(r4);
    L_0x0011:
        r4 = r3.getInfos();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MPSMediaInfo.getMediaInfo(java.io.File):java.util.List<org.jcodec.codecs.mpeg12.MPSMediaInfo$MPEGTrackMetadata>");
    }

    protected void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
        if (MPSUtils.mediaStream(i2) != null) {
            j = (MPEGTrackMetadata) this.infos.get(Integer.valueOf(i2));
            if (j == null) {
                j = new MPEGTrackMetadata(i2);
                this.infos.put(Integer.valueOf(i2), j);
            }
            if (j.probeData == null) {
                j.probeData = NIOUtils.cloneBuffer(byteBuffer);
            }
            byteBuffer = this.pesTried + 1;
            this.pesTried = byteBuffer;
            if (byteBuffer >= 100) {
                deriveMediaInfo();
                throw new MediaInfoDone();
            }
        }
    }

    private void deriveMediaInfo() {
        for (MPEGTrackMetadata mPEGTrackMetadata : this.infos.values()) {
            int i = 256 | mPEGTrackMetadata.streamId;
            if (i >= MPSUtils.AUDIO_MIN && i <= MPSUtils.AUDIO_MAX) {
                mPEGTrackMetadata.codec = Codec.MP2;
            } else if (i == MPSUtils.PRIVATE_1) {
                ByteBuffer duplicate = mPEGTrackMetadata.probeData.duplicate();
                MPSUtils.readPESHeader(duplicate, 0);
                i = duplicate.get() & 255;
                if (i >= 128 && i <= 135) {
                    mPEGTrackMetadata.codec = Codec.AC3;
                } else if ((i >= 136 && i <= 143) || (i >= 152 && i <= 159)) {
                    mPEGTrackMetadata.codec = Codec.DTS;
                } else if (i >= 160 && i <= MPEGConst.SLICE_START_CODE_LAST) {
                    mPEGTrackMetadata.codec = Codec.PCM_DVD;
                } else if (i >= 176 && i <= 191) {
                    mPEGTrackMetadata.codec = Codec.TRUEHD;
                } else if (i >= JpegConst.SOF0 && i <= 207) {
                    mPEGTrackMetadata.codec = Codec.AC3;
                }
            } else if (i >= MPSUtils.VIDEO_MIN && i <= MPSUtils.VIDEO_MAX) {
                mPEGTrackMetadata.codec = Codec.MPEG2;
            }
        }
    }

    private int[] parseSystem(ByteBuffer byteBuffer) {
        NIOUtils.skip(byteBuffer, 12);
        IntArrayList intArrayList = new IntArrayList();
        while (byteBuffer.remaining() >= 3 && (byteBuffer.get(byteBuffer.position()) & 128) == 128) {
            intArrayList.add(byteBuffer.get() & 255);
            byteBuffer.getShort();
        }
        return intArrayList.toArray();
    }

    private PSM parsePSM(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        if (byteBuffer.getShort() > (short) 1018) {
            throw new RuntimeException("Invalid PSM");
        }
        byteBuffer.get();
        if ((byteBuffer.get() & 1) != 1) {
            throw new RuntimeException("Invalid PSM");
        }
        NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535);
        parseElStreams(NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535));
        byteBuffer.getInt();
        return new PSM();
    }

    private void parseElStreams(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            byteBuffer.get();
            byteBuffer.get();
            NIOUtils.read(byteBuffer, byteBuffer.getShort() & 65535);
        }
    }

    public List<MPEGTrackMetadata> getInfos() {
        return new ArrayList(this.infos.values());
    }

    public static void main(String[] strArr) throws IOException {
        new MPSMediaInfo().getMediaInfo(new File(strArr[0]));
    }
}
