package org.jcodec.common.tools;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.RationalLarge;

public class MathUtil {
    private static final int[] logTab = new int[]{0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int[] reverseTab = new int[]{0, 128, 64, JpegConst.SOF0, 32, 160, 96, JpegConst.APP0, 16, 144, 80, JpegConst.RST0, 48, 176, 112, 240, 8, 136, 72, HttpStatus.HTTP_OK, 40, 168, 104, JpegConst.APP8, 24, 152, 88, JpegConst.SOI, 56, MPEGConst.GROUP_START_CODE, 120, 248, 4, 132, 68, JpegConst.DHT, 36, 164, 100, JpegConst.APP4, 20, 148, 84, JpegConst.RST4, 52, 180, 116, 244, 12, 140, 76, 204, 44, 172, 108, JpegConst.APPC, 28, 156, 92, 220, 60, 188, 124, 252, 2, 130, 66, JpegConst.SOF2, 34, 162, 98, JpegConst.APP2, 18, 146, 82, JpegConst.RST2, 50, MPEGConst.USER_DATA_START_CODE, 114, 242, 10, 138, 74, 202, 42, 170, 106, JpegConst.APPA, 26, 154, 90, JpegConst.SOS, 58, 186, 122, 250, 6, 134, 70, 198, 38, 166, 102, JpegConst.APP6, 22, ModuleDescriptor.MODULE_VERSION, 86, JpegConst.RST6, 54, 182, 118, 246, 14, 142, 78, 206, 46, 174, 110, JpegConst.APPE, 30, 158, 94, 222, 62, 190, 126, JpegConst.COM, 1, 129, 65, JpegConst.SOF1, 33, 161, 97, JpegConst.APP1, 17, 145, 81, JpegConst.RST1, 49, 177, 113, 241, 9, 137, 73, 201, 41, 169, 105, JpegConst.APP9, 25, 153, 89, JpegConst.EOI, 57, 185, 121, 249, 5, 133, 69, 197, 37, 165, 101, JpegConst.APP5, 21, 149, 85, JpegConst.RST5, 53, MPEGConst.EXTENSION_START_CODE, 117, 245, 13, 141, 77, 205, 45, 173, 109, JpegConst.APPD, 29, 157, 93, JpegConst.DRI, 61, 189, 125, 253, 3, 131, 67, JpegConst.SOF3, 35, 163, 99, JpegConst.APP3, 19, 147, 83, JpegConst.RST3, 51, MPEGConst.SEQUENCE_HEADER_CODE, 115, 243, 11, 139, 75, 203, 43, 171, 107, JpegConst.APPB, 27, 155, 91, JpegConst.DQT, 59, 187, 123, 251, 7, 135, 71, 199, 39, 167, 103, JpegConst.APP7, 23, 151, 87, JpegConst.RST7, 55, MPEGConst.SEQUENCE_END_CODE, 119, 247, 15, 143, 79, 207, 47, MPEGConst.SLICE_START_CODE_LAST, 111, JpegConst.APPF, 31, 159, 95, 223, 63, 191, 127, 255};

    public static final int abs(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    public static final int clip(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static final int clip(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static int cubeRoot(int i) {
        return 0;
    }

    public static final int golomb(int r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: org.jcodec.common.tools.MathUtil.golomb(int):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 7 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.MathUtil.golomb(int):int");
    }

    public static int log2Slow(int i) {
        int i2 = 0;
        while ((Integer.MIN_VALUE & i) == 0) {
            i <<= 1;
            i2++;
        }
        return 31 - i2;
    }

    public static int nextPowerOfTwo(int i) {
        i--;
        i |= i >> 1;
        i |= i >> 2;
        i |= i >> 4;
        i |= i >> 8;
        return (i | (i >> 16)) + 1;
    }

    public static final int sign(int i) {
        return -(i >> 31);
    }

    public static final int toSigned(int i, int i2) {
        return (i ^ i2) - i2;
    }

    public static int wrap(int i, int i2) {
        if (i < 0) {
            return i + i2;
        }
        if (i >= i2) {
            i -= i2;
        }
        return i;
    }

    public static int log2(int i) {
        int i2;
        if ((-65536 & i) != 0) {
            i >>= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if ((65280 & i) != 0) {
            i >>= 8;
            i2 += 8;
        }
        return i2 + logTab[i];
    }

    public static int log2(long j) {
        int i = 32;
        if ((-4294967296L & j) != 0) {
            j >>= 32;
        } else {
            i = 0;
        }
        if ((4294901760L & j) != 0) {
            j >>= 16;
            i += 16;
        }
        if ((65280 & j) != 0) {
            j >>= 8;
            i += 8;
        }
        return i + logTab[(int) j];
    }

    public static int gcd(int i, int i2) {
        while (true) {
            int i3 = i2;
            i2 = i;
            i = i3;
            if (i == 0) {
                return i2;
            }
            i2 %= i;
        }
    }

    public static long gcd(long j, long j2) {
        while (true) {
            long j3 = j;
            j = j2;
            j2 = j3;
            if (j == 0) {
                return j2;
            }
            j2 %= j;
        }
    }

    public static Rational reduce(Rational rational) {
        return reduce(rational.getNum(), rational.getDen());
    }

    public static Rational reduce(int i, int i2) {
        int gcd = gcd(i, i2);
        return new Rational(i / gcd, i2 / gcd);
    }

    public static RationalLarge reduce(long j, long j2) {
        long gcd = gcd(j, j2);
        return new RationalLarge(j / gcd, j2 / gcd);
    }

    public static final int reverse(int i) {
        return reverseTab[i & 255];
    }
}
