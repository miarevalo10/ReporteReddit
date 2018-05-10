package org.jcodec.codecs.vpx;

public class VPXDCT {
    public static int cospi8sqrt2minus1 = 20091;
    public static int sinpi8sqrt2 = 35468;

    public static void fdct4x4(int[] iArr) {
        int i;
        for (i = 0; i < 16; i += 4) {
            int i2 = i + 3;
            int i3 = (iArr[i] + iArr[i2]) << 3;
            int i4 = i + 1;
            int i5 = i + 2;
            int i6 = (iArr[i4] + iArr[i5]) << 3;
            int i7 = (iArr[i4] - iArr[i5]) << 3;
            int i8 = (iArr[i] - iArr[i2]) << 3;
            iArr[i] = i3 + i6;
            iArr[i5] = i3 - i6;
            iArr[i4] = (((i7 * 2217) + (i8 * 5352)) + 14500) >> 12;
            iArr[i2] = (((i8 * 2217) - (i7 * 5352)) + 7500) >> 12;
        }
        for (i = 0; i < 4; i++) {
            i6 = i + 12;
            i4 = iArr[i] + iArr[i6];
            i5 = i + 4;
            i8 = i + 8;
            i7 = iArr[i5] + iArr[i8];
            int i9 = iArr[i5] - iArr[i8];
            int i10 = iArr[i] - iArr[i6];
            iArr[i] = ((i4 + i7) + 7) >> 4;
            iArr[i8] = ((i4 - i7) + 7) >> 4;
            iArr[i5] = ((((i9 * 2217) + (i10 * 5352)) + 12000) >> 16) + (i10 != 0 ? 1 : 0);
            iArr[i6] = (((i10 * 2217) - (i9 * 5352)) + 51000) >> 16;
        }
    }

    public static void walsh4x4(int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= 16) {
                break;
            }
            int i3 = i + 2;
            int i4 = (iArr[i] + iArr[i3]) << 2;
            int i5 = i + 1;
            int i6 = i + 3;
            int i7 = (iArr[i5] + iArr[i6]) << 2;
            int i8 = (iArr[i5] - iArr[i6]) << 2;
            int i9 = (iArr[i] - iArr[i3]) << 2;
            int i10 = i4 + i7;
            if (i4 == 0) {
                i2 = 0;
            }
            iArr[i] = i10 + i2;
            iArr[i5] = i9 + i8;
            iArr[i3] = i9 - i8;
            iArr[i6] = i4 - i7;
            i += 4;
        }
        for (i = 0; i < 4; i++) {
            i3 = i + 8;
            i4 = iArr[i] + iArr[i3];
            i5 = i + 4;
            i6 = i + 12;
            i7 = iArr[i5] + iArr[i6];
            i8 = iArr[i5] - iArr[i6];
            i9 = iArr[i] - iArr[i3];
            i10 = i4 + i7;
            int i11 = i9 + i8;
            i9 -= i8;
            i4 -= i7;
            i11 += i11 < 0 ? 1 : 0;
            i9 += i9 < 0 ? 1 : 0;
            i4 += i4 < 0 ? 1 : 0;
            iArr[i] = ((i10 + (i10 < 0 ? 1 : 0)) + 3) >> 3;
            iArr[i5] = (i11 + 3) >> 3;
            iArr[i3] = (i9 + 3) >> 3;
            iArr[i6] = (i4 + 3) >> 3;
        }
    }

    public static void idct4x4(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 4; i++) {
            int i3 = i + 8;
            int i4 = iArr[i] + iArr[i3];
            int i5 = iArr[i] - iArr[i3];
            int i6 = i + 4;
            int i7 = i + 12;
            int i8 = ((iArr[i6] * sinpi8sqrt2) >> 16) - (iArr[i7] + ((iArr[i7] * cospi8sqrt2minus1) >> 16));
            int i9 = (iArr[i6] + ((iArr[i6] * cospi8sqrt2minus1) >> 16)) + ((iArr[i7] * sinpi8sqrt2) >> 16);
            iArr[i] = i4 + i9;
            iArr[i7] = i4 - i9;
            iArr[i6] = i5 + i8;
            iArr[i3] = i5 - i8;
        }
        while (i2 < 16) {
            i3 = i2 + 2;
            i = iArr[i2] + iArr[i3];
            i5 = iArr[i2] - iArr[i3];
            i6 = i2 + 1;
            i7 = i2 + 3;
            i8 = ((iArr[i6] * sinpi8sqrt2) >> 16) - (iArr[i7] + ((iArr[i7] * cospi8sqrt2minus1) >> 16));
            i9 = (iArr[i6] + ((iArr[i6] * cospi8sqrt2minus1) >> 16)) + ((iArr[i7] * sinpi8sqrt2) >> 16);
            iArr[i2] = ((i + i9) + 4) >> 3;
            iArr[i7] = ((i - i9) + 4) >> 3;
            iArr[i6] = ((i5 + i8) + 4) >> 3;
            iArr[i3] = ((i5 - i8) + 4) >> 3;
            i2 += 4;
        }
    }

    public static void iwalsh4x4(int[] iArr) {
        int i;
        int i2 = 0;
        for (i = 0; i < 4; i++) {
            int i3 = i + 12;
            int i4 = iArr[i] + iArr[i3];
            int i5 = i + 4;
            int i6 = i + 8;
            int i7 = iArr[i5] + iArr[i6];
            int i8 = iArr[i5] - iArr[i6];
            int i9 = iArr[i] - iArr[i3];
            iArr[i] = i4 + i7;
            iArr[i5] = i8 + i9;
            iArr[i6] = i4 - i7;
            iArr[i3] = i9 - i8;
        }
        while (i2 < 16) {
            i4 = i2 + 3;
            i = iArr[i2] + iArr[i4];
            i3 = i2 + 1;
            i7 = i2 + 2;
            i5 = iArr[i3] + iArr[i7];
            i6 = iArr[i3] - iArr[i7];
            i8 = iArr[i2] - iArr[i4];
            i9 = i + i5;
            int i10 = i6 + i8;
            i -= i5;
            i8 -= i6;
            iArr[i2] = (i9 + 3) >> 3;
            iArr[i3] = (i10 + 3) >> 3;
            iArr[i7] = (i + 3) >> 3;
            iArr[i4] = (i8 + 3) >> 3;
            i2 += 4;
        }
    }
}
