package com.google.android.exoplayer2.extractor;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mps.MPSUtils;

public final class MpegAudioHeader {
    private static final String[] f4254h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] f4255i = new int[]{44100, 48000, 32000};
    private static final int[] f4256j = new int[]{32, 64, 96, 128, 160, JpegConst.SOF0, JpegConst.APP0, 256, 288, 320, 352, 384, 416, MPSUtils.AUDIO_MIN};
    private static final int[] f4257k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, JpegConst.SOF0, JpegConst.APP0, 256};
    private static final int[] f4258l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, JpegConst.SOF0, JpegConst.APP0, 256, 320, 384};
    private static final int[] f4259m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JpegConst.SOF0, JpegConst.APP0, 256, 320};
    private static final int[] f4260n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int f4261a;
    public String f4262b;
    public int f4263c;
    public int f4264d;
    public int f4265e;
    public int f4266f;
    public int f4267g;

    public static int m3754a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 != 0) {
            if (i4 != 15) {
                int i5 = (i >>> 10) & 3;
                if (i5 == 3) {
                    return -1;
                }
                int i6 = f4255i[i5];
                if (i2 == 2) {
                    i6 /= 2;
                } else if (i2 == 0) {
                    i6 /= 4;
                }
                i = (i >>> 9) & 1;
                if (i3 == 3) {
                    return (((12000 * (i2 == 3 ? f4256j[i4 - 1] : f4257k[i4 - 1])) / i6) + i) * 4;
                }
                i4 = i2 == 3 ? i3 == 2 ? f4258l[i4 - 1] : f4259m[i4 - 1] : f4260n[i4 - 1];
                i5 = 144000;
                if (i2 == 3) {
                    return ((144000 * i4) / i6) + i;
                }
                if (i3 == 1) {
                    i5 = 72000;
                }
                return ((i5 * i4) / i6) + i;
            }
        }
        return -1;
    }

    public static boolean m3755a(int i, MpegAudioHeader mpegAudioHeader) {
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return false;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return false;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 != 0) {
            if (i4 != 15) {
                int i5 = (i >>> 10) & 3;
                if (i5 == 3) {
                    return false;
                }
                int i6;
                int i7 = f4255i[i5];
                i5 = 2;
                if (i2 == 2) {
                    i7 /= 2;
                } else if (i2 == 0) {
                    i7 /= 4;
                }
                int i8 = (i >>> 9) & 1;
                if (i3 == 3) {
                    i4 = i2 == 3 ? f4256j[i4 - 1] : f4257k[i4 - 1];
                    i6 = 384;
                    i8 = (((12000 * i4) / i7) + i8) * 4;
                } else {
                    int i9;
                    i6 = 1152;
                    if (i2 == 3) {
                        i4 = i3 == 2 ? f4258l[i4 - 1] : f4259m[i4 - 1];
                    } else {
                        i4 = f4260n[i4 - 1];
                        if (i3 == 1) {
                            i6 = 576;
                        }
                        if (i3 == 1) {
                            i9 = 72000;
                            i8 += (i9 * i4) / i7;
                        }
                    }
                    i9 = 144000;
                    i8 += (i9 * i4) / i7;
                }
                String str = f4254h[3 - i3];
                if (((i >> 6) & 3) == 3) {
                    i5 = 1;
                }
                i4 *= 1000;
                mpegAudioHeader.f4261a = i2;
                mpegAudioHeader.f4262b = str;
                mpegAudioHeader.f4263c = i8;
                mpegAudioHeader.f4264d = i7;
                mpegAudioHeader.f4265e = i5;
                mpegAudioHeader.f4266f = i4;
                mpegAudioHeader.f4267g = i6;
                return true;
            }
        }
        return false;
    }
}
