package org.jcodec.codecs.vp8;

import java.lang.reflect.Array;

public class VP8DCT {
    private static final int cospi8sqrt2minus1 = 20091;
    private static final int sinpi8sqrt2 = 35468;

    public static int[] decodeDCT(int[] iArr) {
        int[] iArr2 = new int[16];
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < 4) {
            int i4 = i3 + 0;
            int i5 = i3 + 8;
            int i6 = iArr[i4] + iArr[i5];
            int i7 = iArr[i4] - iArr[i5];
            int i8 = i3 + 4;
            int i9 = i3 + 12;
            int i10 = ((iArr[i8] * sinpi8sqrt2) >> 16) - (iArr[i9] + ((iArr[i9] * cospi8sqrt2minus1) >> 16));
            int i11 = (iArr[i8] + ((iArr[i8] * cospi8sqrt2minus1) >> 16)) + ((iArr[i9] * sinpi8sqrt2) >> 16);
            iArr2[i4] = i6 + i11;
            iArr2[i9] = i6 - i11;
            iArr2[i8] = i7 + i10;
            iArr2[i5] = i7 - i10;
            i3++;
            i2++;
        }
        iArr = null;
        while (i < 4) {
            i2 = iArr * 4;
            i3 = i2 + 0;
            i5 = i2 + 2;
            i6 = iArr2[i3] + iArr2[i5];
            i7 = iArr2[i3] - iArr2[i5];
            i8 = i2 + 1;
            i2 += 3;
            i10 = ((iArr2[i8] * sinpi8sqrt2) >> 16) - (iArr2[i2] + ((iArr2[i2] * cospi8sqrt2minus1) >> 16));
            i9 = (iArr2[i8] + ((iArr2[i8] * cospi8sqrt2minus1) >> 16)) + ((iArr2[i2] * sinpi8sqrt2) >> 16);
            iArr2[i3] = ((i6 + i9) + 4) >> 3;
            iArr2[i2] = ((i6 - i9) + 4) >> 3;
            iArr2[i8] = ((i7 + i10) + 4) >> 3;
            iArr2[i5] = ((i7 - i10) + 4) >> 3;
            iArr++;
            i++;
        }
        return iArr2;
    }

    public static int[] encodeDCT(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < 4) {
            int i4 = i2 + 0;
            int i5 = i2 + 3;
            int i6 = (iArr[i4] + iArr[i5]) << 3;
            int i7 = i2 + 1;
            int i8 = i2 + 2;
            int i9 = (iArr[i7] + iArr[i8]) << 3;
            i7 = (iArr[i7] - iArr[i8]) << 3;
            i4 = (iArr[i4] - iArr[i5]) << 3;
            iArr2[i3 + 0] = i6 + i9;
            iArr2[i3 + 2] = i6 - i9;
            iArr2[i3 + 1] = (((i7 * 2217) + (i4 * 5352)) + 14500) >> 12;
            iArr2[i3 + 3] = (((i4 * 2217) - (i7 * 5352)) + 7500) >> 12;
            i2 += 4;
            i3 += 4;
            i++;
        }
        iArr = null;
        i = iArr;
        i2 = i;
        while (iArr < 4) {
            i3 = i + 0;
            i6 = i + 12;
            i4 = iArr2[i3] + iArr2[i6];
            i5 = i + 4;
            i9 = i + 8;
            i7 = iArr2[i5] + iArr2[i9];
            i5 = iArr2[i5] - iArr2[i9];
            i3 = iArr2[i3] - iArr2[i6];
            iArr2[i2 + 0] = ((i4 + i7) + 7) >> 4;
            iArr2[i2 + 8] = ((i4 - i7) + 7) >> 4;
            iArr2[i2 + 4] = ((((i5 * 2217) + (i3 * 5352)) + 12000) >> 16) + (i3 != 0 ? 1 : 0);
            iArr2[i2 + 12] = (((i3 * 2217) - (i5 * 5352)) + 51000) >> 16;
            i++;
            i2++;
            iArr++;
        }
        return iArr2;
    }

    public static int[] decodeWHT(int[] iArr) {
        int[] iArr2 = new int[16];
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{4, 4});
        int i = 0;
        int i2 = i;
        while (i < 4) {
            int i3 = i2 + 0;
            int i4 = i2 + 12;
            int i5 = iArr[i3] + iArr[i4];
            int i6 = i2 + 4;
            int i7 = i2 + 8;
            int i8 = iArr[i6] + iArr[i7];
            int i9 = iArr[i6] - iArr[i7];
            int i10 = iArr[i3] - iArr[i4];
            iArr2[i3] = i5 + i8;
            iArr2[i6] = i9 + i10;
            iArr2[i7] = i5 - i8;
            iArr2[i4] = i10 - i9;
            i2++;
            i++;
        }
        int i11 = 0;
        i = i11;
        while (i11 < 4) {
            i2 = i + 0;
            i5 = i + 3;
            i3 = iArr2[i2] + iArr2[i5];
            i4 = i + 1;
            i8 = i + 2;
            i6 = iArr2[i4] + iArr2[i8];
            i7 = iArr2[i4] - iArr2[i8];
            i9 = iArr2[i2] - iArr2[i5];
            i10 = i3 + i6;
            int i12 = i7 + i9;
            i3 -= i6;
            i9 -= i7;
            i7 = (i10 + 3) >> 3;
            iArr2[i2] = i7;
            i2 = (i12 + 3) >> 3;
            iArr2[i4] = i2;
            i3 = (i3 + 3) >> 3;
            iArr2[i8] = i3;
            i4 = (i9 + 3) >> 3;
            iArr2[i5] = i4;
            iArr3[0][i11] = i7;
            iArr3[1][i11] = i2;
            iArr3[2][i11] = i3;
            iArr3[3][i11] = i4;
            i += 4;
            i11++;
        }
        return iArr2;
    }

    public static int[] encodeWHT(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (true) {
            int i4 = 1;
            if (i >= 4) {
                break;
            }
            int i5 = i2 + 0;
            int i6 = i2 + 2;
            int i7 = (iArr[i5] + iArr[i6]) << 2;
            int i8 = i2 + 1;
            int i9 = i2 + 3;
            int i10 = (iArr[i8] + iArr[i9]) << 2;
            i8 = (iArr[i8] - iArr[i9]) << 2;
            i5 = (iArr[i5] - iArr[i6]) << 2;
            i6 = i3 + 0;
            i9 = i7 + i10;
            if (i7 == 0) {
                i4 = 0;
            }
            iArr2[i6] = i9 + i4;
            iArr2[i3 + 1] = i5 + i8;
            iArr2[i3 + 2] = i5 - i8;
            iArr2[i3 + 3] = i7 - i10;
            i2 += 4;
            i3 += 4;
            i++;
        }
        iArr = null;
        i = iArr;
        i2 = i;
        while (iArr < 4) {
            i3 = i + 0;
            i6 = i + 8;
            i7 = iArr2[i3] + iArr2[i6];
            i8 = i + 4;
            i9 = i + 12;
            i10 = iArr2[i8] + iArr2[i9];
            i8 = iArr2[i8] - iArr2[i9];
            i3 = iArr2[i3] - iArr2[i6];
            i6 = i7 + i10;
            i9 = i3 + i8;
            i3 -= i8;
            i7 -= i10;
            i9 += i9 < 0 ? 1 : 0;
            i3 += i3 < 0 ? 1 : 0;
            i7 += i7 < 0 ? 1 : 0;
            iArr2[i2 + 0] = ((i6 + (i6 < 0 ? 1 : 0)) + 3) >> 3;
            iArr2[i2 + 4] = (i9 + 3) >> 3;
            iArr2[i2 + 8] = (i3 + 3) >> 3;
            iArr2[i2 + 12] = (i7 + 3) >> 3;
            i++;
            i2++;
            iArr++;
        }
        return iArr2;
    }
}
