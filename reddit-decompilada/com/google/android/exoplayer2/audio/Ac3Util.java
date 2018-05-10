package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mps.MPSUtils;

public final class Ac3Util {
    private static final int[] f4087a = new int[]{1, 2, 3, 6};
    private static final int[] f4088b = new int[]{48000, 44100, 32000};
    private static final int[] f4089c = new int[]{24000, 22050, 16000};
    private static final int[] f4090d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] f4091e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JpegConst.SOF0, JpegConst.APP0, 256, 320, 384, MPSUtils.AUDIO_MIN, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};
    private static final int[] f4092f = new int[]{69, 87, 104, 121, 139, 174, JpegConst.RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class Ac3SyncFrameInfo {
        public final String f4082a;
        public final int f4083b;
        public final int f4084c;
        public final int f4085d;
        public final int f4086e;

        private Ac3SyncFrameInfo(String str, int i, int i2, int i3, int i4) {
            this.f4082a = str;
            this.f4084c = i;
            this.f4083b = i2;
            this.f4085d = i3;
            this.f4086e = i4;
        }
    }

    public static int m3639a() {
        return 1536;
    }

    public static Format m3643a(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = f4088b[(parsableByteArray.m4250d() & JpegConst.SOF0) >> 6];
        parsableByteArray = parsableByteArray.m4250d();
        int i2 = f4090d[(parsableByteArray & 56) >> 3];
        if ((parsableByteArray & 4) != null) {
            i2++;
        }
        return Format.m3558a(str, "audio/ac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static Format m3645b(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.m4251d(2);
        int i = f4088b[(parsableByteArray.m4250d() & JpegConst.SOF0) >> 6];
        parsableByteArray = parsableByteArray.m4250d();
        int i2 = f4090d[(parsableByteArray & 14) >> 1];
        if ((parsableByteArray & 1) != null) {
            i2++;
        }
        return Format.m3558a(str, "audio/eac3", -1, -1, i2, i, null, drmInitData, str2);
    }

    public static int m3642a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return m3640a((bArr[4] & JpegConst.SOF0) >> 6, bArr[4] & 63);
    }

    public static int m3641a(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & JpegConst.SOF0) >> 6) != 3) {
            i = f4087a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return 256 * i;
    }

    private static int m3640a(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0 && i < f4088b.length && i2 >= 0) {
            if (i3 < f4092f.length) {
                i = f4088b[i];
                if (i == 44100) {
                    return 2 * (f4092f[i3] + (i2 % 2));
                }
                i2 = f4091e[i3];
                return i == 32000 ? 6 * i2 : 4 * i2;
            }
        }
        return -1;
    }

    public static Ac3SyncFrameInfo m3644a(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int i3;
        String str;
        int i4 = (parsableBitArray.f5253b * 8) + parsableBitArray.f5254c;
        parsableBitArray.m4234b(40);
        int i5 = parsableBitArray.m4236c(5) == 16 ? 1 : 0;
        parsableBitArray.m4231a(i4);
        i4 = 6;
        if (i5 != 0) {
            String str2 = "audio/eac3";
            parsableBitArray.m4234b(21);
            i5 = (parsableBitArray.m4236c(11) + 1) * 2;
            int c = parsableBitArray.m4236c(2);
            if (c == 3) {
                c = f4089c[parsableBitArray.m4236c(2)];
            } else {
                i4 = f4087a[parsableBitArray.m4236c(2)];
                c = f4088b[c];
            }
            i = 256 * i4;
            i4 = parsableBitArray.m4236c(3);
            i2 = c;
            i3 = i;
            i = i5;
            str = str2;
        } else {
            str = "audio/ac3";
            parsableBitArray.m4234b(32);
            i3 = parsableBitArray.m4236c(2);
            i4 = m3640a(i3, parsableBitArray.m4236c(6));
            parsableBitArray.m4234b(8);
            int c2 = parsableBitArray.m4236c(3);
            if (!((c2 & 1) == 0 || c2 == 1)) {
                parsableBitArray.m4234b(2);
            }
            if ((c2 & 4) != 0) {
                parsableBitArray.m4234b(2);
            }
            if (c2 == 2) {
                parsableBitArray.m4234b(2);
            }
            i2 = f4088b[i3];
            i3 = 1536;
            i = i4;
            i4 = c2;
        }
        return new Ac3SyncFrameInfo(str, f4090d[i4] + parsableBitArray.m4237c(), i2, i, i3);
    }
}
