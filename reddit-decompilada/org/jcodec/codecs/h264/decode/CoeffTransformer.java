package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.common.ArrayUtil;

public class CoeffTransformer {
    static int[][] dequantCoef = new int[][]{new int[]{10, 13, 10, 13, 13, 16, 13, 16, 10, 13, 10, 13, 13, 16, 13, 16}, new int[]{11, 14, 11, 14, 14, 18, 14, 18, 11, 14, 11, 14, 14, 18, 14, 18}, new int[]{13, 16, 13, 16, 16, 20, 16, 20, 13, 16, 13, 16, 16, 20, 16, 20}, new int[]{14, 18, 14, 18, 18, 23, 18, 23, 14, 18, 14, 18, 18, 23, 18, 23}, new int[]{16, 20, 16, 20, 20, 25, 20, 25, 16, 20, 16, 20, 20, 25, 20, 25}, new int[]{18, 23, 18, 23, 23, 29, 23, 29, 18, 23, 18, 23, 23, 29, 23, 29}};
    static int[][] dequantCoef8x8 = ((int[][]) Array.newInstance(int.class, new int[]{6, 64}));
    static int[][] initDequantCoeff8x8 = new int[][]{new int[]{20, 18, 32, 19, 25, 24}, new int[]{22, 19, 35, 21, 28, 26}, new int[]{26, 23, 42, 24, 33, 31}, new int[]{28, 25, 45, 26, 35, 33}, new int[]{32, 28, 51, 30, 40, 38}, new int[]{36, 32, 58, 34, 46, 43}};
    private static final int[][] quantCoeff = new int[][]{new int[]{13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243, 13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243}, new int[]{11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660, 11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660}, new int[]{10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194, 10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194}, new int[]{9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647, 9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647}, new int[]{8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355, 8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355}, new int[]{7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893, 7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893}};
    public static int[] zigzag4x4 = new int[]{0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};
    public static int[] zigzag8x8 = new int[]{0, 1, 8, 16, 9, 2, 3, 10, 17, 24, 32, 25, 18, 11, 4, 5, 12, 19, 26, 33, 40, 48, 41, 34, 27, 20, 13, 6, 7, 14, 21, 28, 35, 42, 49, 56, 57, 50, 43, 36, 29, 22, 15, 23, 30, 37, 44, 51, 58, 59, 52, 45, 38, 31, 39, 46, 53, 60, 61, 54, 47, 55, 62, 63};
    private int[] fieldScan4x4 = new int[]{0, 4, 1, 8, 12, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
    private int[] fieldScan8x8 = new int[]{0, 8, 16, 1, 9, 24, 32, 17, 2, 25, 40, 48, 56, 33, 10, 3, 18, 41, 49, 57, 26, 11, 4, 19, 34, 42, 50, 58, 27, 12, 5, 20, 35, 43, 51, 58, 28, 13, 6, 21, 36, 44, 52, 60, 29, 14, 22, 37, 45, 53, 61, 30, 7, 15, 38, 46, 54, 62, 23, 31, 39, 47, 55, 63};

    public static void dequantizeDC4x2(int[] iArr, int i) {
    }

    public static void fvdDC4x2(int[] iArr) {
    }

    public static void invDC4x2(int[] iArr) {
    }

    public static void quantizeDC4x2(int[] iArr, int i) {
    }

    static {
        for (int i = 0; i < 6; i++) {
            int i2;
            int i3;
            Arrays.fill(dequantCoef8x8[i], initDequantCoeff8x8[i][5]);
            for (i2 = 0; i2 < 8; i2 += 4) {
                for (i3 = 0; i3 < 8; i3 += 4) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][0];
                }
            }
            for (i2 = 1; i2 < 8; i2 += 2) {
                for (i3 = 1; i3 < 8; i3 += 2) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][1];
                }
            }
            for (i2 = 2; i2 < 8; i2 += 4) {
                for (i3 = 2; i3 < 8; i3 += 4) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][2];
                }
            }
            for (i2 = 0; i2 < 8; i2 += 4) {
                for (i3 = 1; i3 < 8; i3 += 2) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][3];
                }
            }
            for (i2 = 1; i2 < 8; i2 += 2) {
                for (i3 = 0; i3 < 8; i3 += 4) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][3];
                }
            }
            for (i2 = 0; i2 < 8; i2 += 4) {
                for (i3 = 2; i3 < 8; i3 += 4) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][4];
                }
            }
            for (i2 = 2; i2 < 8; i2 += 4) {
                for (i3 = 0; i3 < 8; i3 += 4) {
                    dequantCoef8x8[i][(i2 << 3) + i3] = initDequantCoeff8x8[i][4];
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CoeffTransformer(int[][] r1) {
        /*
        r0 = this;
        r0.<init>();
        r1 = 16;
        r1 = new int[r1];
        r1 = {0, 4, 1, 8, 12, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
        r0.fieldScan4x4 = r1;
        r1 = 64;
        r1 = new int[r1];
        r1 = {0, 8, 16, 1, 9, 24, 32, 17, 2, 25, 40, 48, 56, 33, 10, 3, 18, 41, 49, 57, 26, 11, 4, 19, 34, 42, 50, 58, 27, 12, 5, 20, 35, 43, 51, 58, 28, 13, 6, 21, 36, 44, 52, 60, 29, 14, 22, 37, 45, 53, 61, 30, 7, 15, 38, 46, 54, 62, 23, 31, 39, 47, 55, 63};
        r0.fieldScan8x8 = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.CoeffTransformer.<init>(int[][]):void");
    }

    public static final void idct4x4(int[] iArr) {
        idct4x4(iArr, iArr);
    }

    public static final void idct4x4(int[] iArr, int[] iArr2) {
        int i;
        int i2 = 0;
        for (i = 0; i < 16; i += 4) {
            int i3 = i + 2;
            int i4 = iArr[i] + iArr[i3];
            int i5 = iArr[i] - iArr[i3];
            int i6 = i + 1;
            int i7 = i + 3;
            int i8 = (iArr[i6] >> 1) - iArr[i7];
            int i9 = iArr[i6] + (iArr[i7] >> 1);
            iArr2[i] = i4 + i9;
            iArr2[i6] = i5 + i8;
            iArr2[i3] = i5 - i8;
            iArr2[i7] = i4 - i9;
        }
        for (iArr = null; iArr < 4; iArr++) {
            i3 = iArr + 8;
            i = iArr2[iArr] + iArr2[i3];
            i5 = iArr2[iArr] - iArr2[i3];
            i6 = iArr + 4;
            i7 = iArr + 12;
            i8 = (iArr2[i6] >> 1) - iArr2[i7];
            i9 = iArr2[i6] + (iArr2[i7] >> 1);
            iArr2[iArr] = i + i9;
            iArr2[i6] = i5 + i8;
            iArr2[i3] = i5 - i8;
            iArr2[i7] = i - i9;
        }
        while (i2 < 16) {
            iArr2[i2] = (iArr2[i2] + 32) >> 6;
            i2++;
        }
    }

    public static void fdct4x4(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 16; i += 4) {
            int i3 = i + 3;
            int i4 = iArr[i] + iArr[i3];
            int i5 = i + 1;
            int i6 = i + 2;
            int i7 = iArr[i5] + iArr[i6];
            int i8 = iArr[i5] - iArr[i6];
            int i9 = iArr[i] - iArr[i3];
            iArr[i] = i4 + i7;
            iArr[i5] = (i9 << 1) + i8;
            iArr[i6] = i4 - i7;
            iArr[i3] = i9 - (i8 << 1);
        }
        while (i2 < 4) {
            i4 = i2 + 12;
            i = iArr[i2] + iArr[i4];
            i3 = i2 + 4;
            i7 = i2 + 8;
            i5 = iArr[i3] + iArr[i7];
            i6 = iArr[i3] - iArr[i7];
            i8 = iArr[i2] - iArr[i4];
            iArr[i2] = i + i5;
            iArr[i3] = (i8 << 1) + i6;
            iArr[i7] = i - i5;
            iArr[i4] = i8 - (i6 << 1);
            i2++;
        }
    }

    public static void invDC4x4(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 16; i += 4) {
            int i3 = i + 2;
            int i4 = iArr[i] + iArr[i3];
            int i5 = iArr[i] - iArr[i3];
            int i6 = i + 1;
            int i7 = i + 3;
            int i8 = iArr[i6] - iArr[i7];
            int i9 = iArr[i6] + iArr[i7];
            iArr[i] = i4 + i9;
            iArr[i6] = i5 + i8;
            iArr[i3] = i5 - i8;
            iArr[i7] = i4 - i9;
        }
        while (i2 < 4) {
            i4 = i2 + 8;
            i = iArr[i2] + iArr[i4];
            i3 = iArr[i2] - iArr[i4];
            i5 = i2 + 4;
            i8 = i2 + 12;
            i6 = iArr[i5] - iArr[i8];
            i7 = iArr[i5] + iArr[i8];
            iArr[i2] = i + i7;
            iArr[i5] = i3 + i6;
            iArr[i4] = i3 - i6;
            iArr[i8] = i - i7;
            i2++;
        }
    }

    public static void fvdDC4x4(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 16; i += 4) {
            int i3 = i + 3;
            int i4 = iArr[i] + iArr[i3];
            int i5 = i + 1;
            int i6 = i + 2;
            int i7 = iArr[i5] + iArr[i6];
            int i8 = iArr[i5] - iArr[i6];
            int i9 = iArr[i] - iArr[i3];
            iArr[i] = i4 + i7;
            iArr[i5] = i9 + i8;
            iArr[i6] = i4 - i7;
            iArr[i3] = i9 - i8;
        }
        while (i2 < 4) {
            i4 = i2 + 12;
            i = iArr[i2] + iArr[i4];
            i3 = i2 + 4;
            i7 = i2 + 8;
            i5 = iArr[i3] + iArr[i7];
            i6 = iArr[i3] - iArr[i7];
            i8 = iArr[i2] - iArr[i4];
            iArr[i2] = (i + i5) >> 1;
            iArr[i3] = (i6 + i8) >> 1;
            iArr[i7] = (i - i5) >> 1;
            iArr[i4] = (i8 - i6) >> 1;
            i2++;
        }
    }

    public static void dequantizeAC(int[] iArr, int i) {
        int i2 = i % 6;
        int i3 = 0;
        if (i >= 24) {
            i /= 6;
            while (i3 < 16) {
                iArr[i3] = (iArr[i3] * dequantCoef[i2][i3]) << i;
                i3++;
            }
            return;
        }
        i /= 6;
        int i4 = 4 - i;
        i = 1 << (3 - i);
        while (i3 < 16) {
            iArr[i3] = ((iArr[i3] * (dequantCoef[i2][i3] << 4)) + i) >> i4;
            i3++;
        }
    }

    public static void quantizeAC(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 4);
        int i5 = 15 + i2;
        int i6 = 1;
        if (i < 10) {
            while (i6 < 16) {
                i = iArr[i6] >> 31;
                iArr[i6] = (Math.min(((((iArr[i6] ^ i) - i) * quantCoeff[i3][i6]) + i4) >> i5, 2063) ^ i) - i;
                i6++;
            }
            return;
        }
        while (i6 < 16) {
            i = iArr[i6] >> 31;
            iArr[i6] = ((((((iArr[i6] ^ i) - i) * quantCoeff[i3][i6]) + i4) >> i5) ^ i) - i;
            i6++;
        }
    }

    public static int[] unzigzagAC(int[] iArr) {
        int[] iArr2;
        if (iArr.length == 16) {
            iArr2 = zigzag4x4;
        } else if (iArr.length == 64) {
            iArr2 = zigzag8x8;
        } else {
            throw new IllegalArgumentException("Coefficients array should be of either 16 or 64 length.");
        }
        int[] iArr3 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr3[iArr2[i]] = iArr[i];
        }
        return iArr3;
    }

    public static void dequantizeDC4x4(int[] iArr, int i) {
        int i2 = i % 6;
        int i3;
        if (i >= 36) {
            i = (i / 6) - 2;
            for (i3 = 0; i3 < 16; i3++) {
                iArr[i3] = (iArr[i3] * dequantCoef[i2][0]) << i;
            }
            return;
        }
        i /= 6;
        i3 = 6 - i;
        i = 1 << (5 - i);
        for (int i4 = 0; i4 < 16; i4++) {
            iArr[i4] = ((iArr[i4] * (dequantCoef[i2][0] << 4)) + i) >> i3;
        }
    }

    public static void quantizeDC4x4(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 5);
        i2 += 16;
        if (i < 10) {
            for (i = 0; i < 16; i++) {
                int i5 = iArr[i] >> 31;
                iArr[i] = (Math.min(((((iArr[i] ^ i5) - i5) * quantCoeff[i3][0]) + i4) >> i2, 2063) ^ i5) - i5;
            }
            return;
        }
        for (i = 0; i < 16; i++) {
            i5 = iArr[i] >> 31;
            iArr[i] = ((((((iArr[i] ^ i5) - i5) * quantCoeff[i3][0]) + i4) >> i2) ^ i5) - i5;
        }
    }

    public static void invDC2x2(int[] iArr) {
        int i = iArr[0] + iArr[1];
        int i2 = iArr[0] - iArr[1];
        int i3 = iArr[2] + iArr[3];
        int i4 = iArr[2] - iArr[3];
        iArr[0] = i + i3;
        iArr[1] = i2 + i4;
        iArr[2] = i - i3;
        iArr[3] = i2 - i4;
    }

    public static void fvdDC2x2(int[] iArr) {
        invDC2x2(iArr);
    }

    public static void dequantizeDC2x2(int[] iArr, int i) {
        int i2 = i % 6;
        i /= 6;
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = ((iArr[i3] * dequantCoef[i2][0]) << i) >> 1;
        }
    }

    public static void quantizeDC2x2(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 5);
        int i5 = 16 + i2;
        if (i < 4) {
            for (i = 0; i < 4; i++) {
                int i6 = iArr[i] >> 31;
                iArr[i] = (Math.min(((((iArr[i] ^ i6) - i6) * quantCoeff[i3][0]) + i4) >> i5, 2063) ^ i6) - i6;
            }
            return;
        }
        for (i = 0; i < 4; i++) {
            i6 = iArr[i] >> 31;
            iArr[i] = ((((((iArr[i] ^ i6) - i6) * quantCoeff[i3][0]) + i4) >> i5) ^ i6) - i6;
        }
    }

    public static void reorderDC4x4(int[] iArr) {
        ArrayUtil.swap(iArr, 2, 4);
        ArrayUtil.swap(iArr, 3, 5);
        ArrayUtil.swap(iArr, 10, 12);
        ArrayUtil.swap(iArr, 11, 13);
    }

    public static void dequantizeAC8x8(int[] iArr, int i) {
        int i2 = i % 6;
        int i3 = 0;
        if (i >= 36) {
            i = (i / 6) - 2;
            while (i3 < 64) {
                iArr[i3] = (iArr[i3] * dequantCoef8x8[i2][i3]) << i;
                i3++;
            }
            return;
        }
        i /= 6;
        int i4 = 6 - i;
        i = 1 << (5 - i);
        while (i3 < 64) {
            iArr[i3] = ((iArr[i3] * (dequantCoef8x8[i2][i3] << 4)) + i) >> i4;
            i3++;
        }
    }

    public static void idct8x8(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 8; i++) {
            int i3 = i2 + 4;
            int i4 = iArr[i2] + iArr[i3];
            int i5 = i2 + 3;
            int i6 = i2 + 5;
            int i7 = i2 + 7;
            int i8 = (((-iArr[i5]) + iArr[i6]) - iArr[i7]) - (iArr[i7] >> 1);
            int i9 = iArr[i2] - iArr[i3];
            int i10 = i2 + 1;
            int i11 = ((iArr[i10] + iArr[i7]) - iArr[i5]) - (iArr[i5] >> 1);
            int i12 = i2 + 2;
            int i13 = i2 + 6;
            int i14 = (iArr[i12] >> 1) - iArr[i13];
            int i15 = (((-iArr[i10]) + iArr[i7]) + iArr[i6]) + (iArr[i6] >> 1);
            int i16 = iArr[i12] + (iArr[i13] >> 1);
            int i17 = ((iArr[i5] + iArr[i6]) + iArr[i10]) + (iArr[i10] >> 1);
            int i18 = i4 + i16;
            int i19 = i8 + (i17 >> 2);
            int i20 = i9 + i14;
            int i21 = i11 + (i15 >> 2);
            i9 -= i14;
            i11 = (i11 >> 2) - i15;
            i4 -= i16;
            i17 -= i8 >> 2;
            iArr[i2] = i18 + i17;
            iArr[i10] = i20 + i11;
            iArr[i12] = i9 + i21;
            iArr[i5] = i4 + i19;
            iArr[i3] = i4 - i19;
            iArr[i6] = i9 - i21;
            iArr[i13] = i20 - i11;
            iArr[i7] = i18 - i17;
            i2 += 8;
        }
        for (i15 = 0; i15 < 8; i15++) {
            i2 = i15 + 32;
            i = iArr[i15] + iArr[i2];
            i4 = i15 + 24;
            i5 = i15 + 40;
            i8 = i15 + 56;
            i3 = (((-iArr[i4]) + iArr[i5]) - iArr[i8]) - (iArr[i8] >> 1);
            i6 = iArr[i15] - iArr[i2];
            i7 = i15 + 8;
            i9 = ((iArr[i7] + iArr[i8]) - iArr[i4]) - (iArr[i4] >> 1);
            i10 = i15 + 16;
            i12 = i15 + 48;
            i11 = (iArr[i10] >> 1) - iArr[i12];
            i14 = (((-iArr[i7]) + iArr[i8]) + iArr[i5]) + (iArr[i5] >> 1);
            i13 = iArr[i10] + (iArr[i12] >> 1);
            i16 = ((iArr[i4] + iArr[i5]) + iArr[i7]) + (iArr[i7] >> 1);
            i17 = i + i13;
            i18 = i3 + (i16 >> 2);
            i19 = i6 + i11;
            i20 = i9 + (i14 >> 2);
            i6 -= i11;
            i9 = (i9 >> 2) - i14;
            i -= i13;
            i16 -= i3 >> 2;
            iArr[i15] = i17 + i16;
            iArr[i7] = i19 + i9;
            iArr[i10] = i6 + i20;
            iArr[i4] = i + i18;
            iArr[i2] = i - i18;
            iArr[i5] = i6 - i20;
            iArr[i12] = i19 - i9;
            iArr[i8] = i17 - i16;
        }
        for (i15 = 0; i15 < 64; i15++) {
            iArr[i15] = (iArr[i15] + 32) >> 6;
        }
    }
}
