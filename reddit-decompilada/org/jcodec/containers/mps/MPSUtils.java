package org.jcodec.containers.mps;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.Rational;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;

public class MPSUtils {
    public static final int AUDIO_MAX = 479;
    public static final int AUDIO_MIN = 448;
    public static final int PACK = 442;
    public static final int PRIVATE_1 = 445;
    public static final int PRIVATE_2 = 447;
    public static final int PSM = 444;
    public static final int SYSTEM = 443;
    public static final int VIDEO_MAX = 495;
    public static final int VIDEO_MIN = 480;
    public static Class<? extends MPEGMediaDescriptor>[] dMapping;

    public static class MPEGMediaDescriptor {
        private int len;
        private int tag;

        public void parse(ByteBuffer byteBuffer) {
            this.tag = byteBuffer.get() & 255;
            this.len = byteBuffer.get() & 255;
        }
    }

    public static abstract class PESReader {
        private int lenFieldLeft;
        private int marker = -1;
        private boolean pes;
        private ByteBuffer pesBuffer = ByteBuffer.allocate(2097152);
        private long pesFileStart = -1;
        private int pesLeft;
        private int pesLen;
        private int stream;

        public abstract void pes(ByteBuffer byteBuffer, long j, int i, int i2);

        public void analyseBuffer(ByteBuffer byteBuffer, long j) {
            PESReader pESReader = this;
            int position = byteBuffer.position();
            while (byteBuffer.hasRemaining()) {
                int min;
                ByteBuffer byteBuffer2;
                long position2;
                if (pESReader.pesLeft > 0) {
                    min = Math.min(byteBuffer.remaining(), pESReader.pesLeft);
                    byteBuffer2 = byteBuffer;
                    pESReader.pesBuffer.put(NIOUtils.read(byteBuffer2, min));
                    pESReader.pesLeft -= min;
                    if (pESReader.pesLeft == 0) {
                        position2 = (j + ((long) byteBuffer2.position())) - ((long) position);
                        pes1(pESReader.pesBuffer, pESReader.pesFileStart, (int) (position2 - pESReader.pesFileStart), pESReader.stream);
                        pESReader.pesFileStart = -1;
                        pESReader.pes = false;
                        pESReader.stream = -1;
                    }
                } else {
                    byteBuffer2 = byteBuffer;
                    min = byteBuffer2.get() & 255;
                    if (pESReader.pes) {
                        pESReader.pesBuffer.put((byte) (pESReader.marker >>> 24));
                    }
                    pESReader.marker = (pESReader.marker << 8) | min;
                    if (pESReader.marker >= MPSUtils.SYSTEM && pESReader.marker <= MPSUtils.VIDEO_MAX) {
                        long position3 = ((j + ((long) byteBuffer2.position())) - ((long) position)) - 4;
                        if (pESReader.pes) {
                            pes1(pESReader.pesBuffer, pESReader.pesFileStart, (int) (position3 - pESReader.pesFileStart), pESReader.stream);
                        }
                        pESReader.pesFileStart = position3;
                        pESReader.pes = true;
                        pESReader.stream = pESReader.marker & 255;
                        pESReader.lenFieldLeft = 2;
                        pESReader.pesLen = 0;
                    } else if (pESReader.marker >= 441 && pESReader.marker <= 511) {
                        if (pESReader.pes) {
                            position2 = ((j + ((long) byteBuffer2.position())) - ((long) position)) - 4;
                            pes1(pESReader.pesBuffer, pESReader.pesFileStart, (int) (position2 - pESReader.pesFileStart), pESReader.stream);
                        }
                        pESReader.pesFileStart = -1;
                        pESReader.pes = false;
                        pESReader.stream = -1;
                    } else if (pESReader.lenFieldLeft > 0) {
                        pESReader.pesLen = min | (pESReader.pesLen << 8);
                        pESReader.lenFieldLeft--;
                        if (pESReader.lenFieldLeft == 0) {
                            pESReader.pesLeft = pESReader.pesLen;
                            if (pESReader.pesLen != 0) {
                                flushMarker();
                                pESReader.marker = -1;
                            }
                        }
                    }
                }
            }
        }

        private void flushMarker() {
            this.pesBuffer.put((byte) (this.marker >>> 24));
            this.pesBuffer.put((byte) ((this.marker >>> 16) & 255));
            this.pesBuffer.put((byte) ((this.marker >>> 8) & 255));
            this.pesBuffer.put((byte) (this.marker & 255));
        }

        private void pes1(ByteBuffer byteBuffer, long j, int i, int i2) {
            byteBuffer.flip();
            pes(byteBuffer, j, i, i2);
            byteBuffer.clear();
        }

        public void finishRead() {
            if (this.pesLeft <= 4) {
                flushMarker();
                pes1(this.pesBuffer, this.pesFileStart, this.pesBuffer.position(), this.stream);
            }
        }
    }

    public static class AACAudioDescriptor extends MPEGMediaDescriptor {
        private int channel;
        private int flags;
        private int profile;

        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profile = byteBuffer.get() & 255;
            this.channel = byteBuffer.get() & 255;
            this.flags = byteBuffer.get() & 255;
        }
    }

    public static class AVCVideoDescriptor extends MPEGMediaDescriptor {
        private int flags;
        private int level;
        private int profileIdc;

        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileIdc = byteBuffer.get() & 255;
            this.flags = byteBuffer.get() & 255;
            this.level = byteBuffer.get() & 255;
        }
    }

    public static class AudioStreamDescriptor extends MPEGMediaDescriptor {
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            byteBuffer.get();
        }
    }

    public static class ISO639LanguageDescriptor extends MPEGMediaDescriptor {
        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            while (byteBuffer.remaining() >= 4) {
                byteBuffer.getInt();
            }
        }
    }

    public static class MP4TextDescriptor extends MPEGMediaDescriptor {
    }

    public static class Mpeg4AudioDescriptor extends MPEGMediaDescriptor {
        private int profileLevel;

        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileLevel = byteBuffer.get() & 255;
        }
    }

    public static class Mpeg4VideoDescriptor extends MPEGMediaDescriptor {
        private int profileLevel;

        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            this.profileLevel = byteBuffer.get() & 255;
        }
    }

    public static class VideoStreamDescriptor extends MPEGMediaDescriptor {
        private int chromaFormat;
        private int constrainedParameter;
        private int frameRateCode;
        private int frameRateExtension;
        Rational[] frameRates = new Rational[]{null, new Rational(24000, CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT), new Rational(24, 1), new Rational(25, 1), new Rational(30000, CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT), new Rational(30, 1), new Rational(50, 1), new Rational(60000, CredentialsApi.ACTIVITY_RESULT_OTHER_ACCOUNT), new Rational(60, 1), null, null, null, null, null, null, null};
        private boolean mpeg1Only;
        private int multipleFrameRate;
        private int profileAndLevel;
        private int stillPicture;

        public void parse(ByteBuffer byteBuffer) {
            super.parse(byteBuffer);
            int i = byteBuffer.get() & 255;
            this.multipleFrameRate = (i >> 7) & 1;
            this.frameRateCode = (i >> 3) & 15;
            this.mpeg1Only = ((i >> 2) & 1) == 0;
            this.constrainedParameter = (i >> 1) & 1;
            this.stillPicture = i & 1;
            if (!this.mpeg1Only) {
                this.profileAndLevel = byteBuffer.get() & 255;
                byteBuffer = byteBuffer.get() & 255;
                this.chromaFormat = byteBuffer >> 6;
                this.frameRateExtension = (byteBuffer >> 5) & 1;
            }
        }

        public Rational getFrameRate() {
            return this.frameRates[this.frameRateCode];
        }
    }

    static int m28385$(int i) {
        return i & 255;
    }

    public static final boolean mediaMarker(int i) {
        if ((i < AUDIO_MIN || i > VIDEO_MAX) && i != PRIVATE_1) {
            if (i != PRIVATE_2) {
                return false;
            }
        }
        return true;
    }

    public static final boolean psMarker(int i) {
        return i >= PRIVATE_1 && i <= VIDEO_MAX;
    }

    public static boolean videoMarker(int i) {
        return i >= VIDEO_MIN && i <= VIDEO_MAX;
    }

    public static final boolean mediaStream(int i) {
        if ((i < m28385$(AUDIO_MIN) || i > m28385$(VIDEO_MAX)) && i != m28385$(PRIVATE_1)) {
            if (i != m28385$(PRIVATE_2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean videoStream(int i) {
        return i >= m28385$(VIDEO_MIN) && i <= m28385$(VIDEO_MAX);
    }

    public static boolean audioStream(int i) {
        if ((i < m28385$(AUDIO_MIN) || i > m28385$(AUDIO_MAX)) && i != m28385$(PRIVATE_1)) {
            if (i != m28385$(PRIVATE_2)) {
                return false;
            }
        }
        return true;
    }

    public static PESPacket readPESHeader(ByteBuffer byteBuffer, long j) {
        int i = byteBuffer.getInt() & 255;
        short s = byteBuffer.getShort();
        if (i == 191) {
            return new PESPacket(null, -1, i, s, j, -1);
        }
        int i2 = byteBuffer.get() & 255;
        if ((i2 & JpegConst.SOF0) == 128) {
            return mpeg2Pes(i2, s, i, byteBuffer, j);
        }
        return mpeg1Pes(i2, s, i, byteBuffer, j);
    }

    public static PESPacket mpeg1Pes(int i, int i2, int i3, ByteBuffer byteBuffer, long j) {
        long j2;
        while (i == 255) {
            i = byteBuffer.get() & 255;
        }
        if ((i & JpegConst.SOF0) == 64) {
            byteBuffer.get();
            i = byteBuffer.get() & 255;
        }
        int i4 = i & 240;
        long j3 = -1;
        if (i4 == 32) {
            j2 = -1;
            j3 = readTs(byteBuffer, i);
        } else if (i4 == 48) {
            j3 = readTs(byteBuffer, i);
            j2 = readTs(byteBuffer);
        } else if (i != 15) {
            throw new RuntimeException("Invalid data");
        } else {
            j2 = -1;
        }
        return new PESPacket(null, j3, i3, i2, j, j2);
    }

    public static long readTs(ByteBuffer byteBuffer, int i) {
        return ((long) ((byteBuffer.get() & 255) >> 1)) | (((((((long) i) & 14) << 29) | ((long) ((byteBuffer.get() & 255) << 22))) | ((long) (((byteBuffer.get() & 255) >> 1) << 15))) | ((long) ((byteBuffer.get() & 255) << 7)));
    }

    public static PESPacket mpeg2Pes(int i, int i2, int i3, ByteBuffer byteBuffer, long j) {
        long j2;
        long j3;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = byteBuffer.get() & 255;
        int i5 = (byteBuffer.get() & 255) & JpegConst.SOF0;
        long readTs;
        if (i5 == 128) {
            readTs = readTs(byteBuffer);
            NIOUtils.skip(byteBuffer2, i4 - 5);
            j2 = -1;
            j3 = readTs;
        } else if (i5 == JpegConst.SOF0) {
            long readTs2 = readTs(byteBuffer);
            readTs = readTs(byteBuffer);
            NIOUtils.skip(byteBuffer2, i4 - 10);
            j3 = readTs2;
            j2 = readTs;
        } else {
            NIOUtils.skip(byteBuffer2, i4);
            j3 = -1;
            j2 = j3;
        }
        return new PESPacket(null, j3, i3, i2, j, j2);
    }

    public static long readTs(ByteBuffer byteBuffer) {
        return (((((((long) byteBuffer.get()) & 14) << 29) | ((long) ((byteBuffer.get() & 255) << 22))) | ((long) (((byteBuffer.get() & 255) >> 1) << 15))) | ((long) ((byteBuffer.get() & 255) << 7))) | ((long) ((byteBuffer.get() & 255) >> 1));
    }

    public static void writeTs(ByteBuffer byteBuffer, long j) {
        byteBuffer.put((byte) ((int) ((j >> 29) << 1)));
        byteBuffer.put((byte) ((int) (j >> 22)));
        byteBuffer.put((byte) ((int) ((j >> 15) << 1)));
        byteBuffer.put((byte) ((int) (j >> 7)));
        byteBuffer.put((byte) ((int) (j >> 1)));
    }

    static {
        Class[] clsArr = new Class[256];
        dMapping = clsArr;
        clsArr[2] = VideoStreamDescriptor.class;
        dMapping[3] = AudioStreamDescriptor.class;
        dMapping[10] = ISO639LanguageDescriptor.class;
        dMapping[27] = Mpeg4VideoDescriptor.class;
        dMapping[28] = Mpeg4AudioDescriptor.class;
        dMapping[40] = AVCVideoDescriptor.class;
        dMapping[43] = AACAudioDescriptor.class;
    }

    public static List<MPEGMediaDescriptor> parseDescriptors(ByteBuffer byteBuffer) {
        List arrayList = new ArrayList();
        while (byteBuffer.remaining() >= 2) {
            int i = byteBuffer.get() & 255;
            ByteBuffer read = NIOUtils.read(byteBuffer, byteBuffer.get() & 255);
            if (dMapping[i] != null) {
                try {
                    ((MPEGMediaDescriptor) dMapping[i].newInstance()).parse(read);
                } catch (ByteBuffer byteBuffer2) {
                    throw new RuntimeException(byteBuffer2);
                }
            }
        }
        return arrayList;
    }
}
