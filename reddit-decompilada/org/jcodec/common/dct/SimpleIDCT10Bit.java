package org.jcodec.common.dct;

public class SimpleIDCT10Bit {
    public static int COL_SHIFT = 20;
    public static int ROW_SHIFT = 15;
    public static int W1 = 90901;
    public static int W2 = 85627;
    public static int W3 = 77062;
    public static int W4 = 65535;
    public static int W5 = 51491;
    public static int W6 = 35468;
    public static int W7 = 18081;

    private static void fdctRow(int[] iArr, int i) {
    }

    public static final void idct10(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            idctRow(iArr, (i3 << 3) + i);
        }
        while (i2 < 8) {
            idctCol(iArr, i + i2);
            i2++;
        }
    }

    private static final void idctCol(int[] iArr, int i) {
        int i2;
        int i3;
        int i4 = W4 * (iArr[i + 0] + ((1 << (COL_SHIFT - 1)) / W4));
        int i5 = i + 16;
        int i6 = (W2 * iArr[i5]) + i4;
        int i7 = (W6 * iArr[i5]) + i4;
        int i8 = ((-W6) * iArr[i5]) + i4;
        i4 += (-W2) * iArr[i5];
        int i9 = i + 8;
        int i10 = i + 24;
        int i11 = (W1 * iArr[i9]) + (W3 * iArr[i10]);
        int i12 = (W3 * iArr[i9]) + ((-W7) * iArr[i10]);
        int i13 = (W5 * iArr[i9]) + ((-W1) * iArr[i10]);
        int i14 = (W7 * iArr[i9]) + ((-W5) * iArr[i10]);
        int i15 = i + 32;
        if (iArr[i15] != 0) {
            i6 += W4 * iArr[i15];
            i7 += (-W4) * iArr[i15];
            i8 += (-W4) * iArr[i15];
            i4 += W4 * iArr[i15];
        }
        int i16 = i + 40;
        if (iArr[i16] != 0) {
            i11 += W5 * iArr[i16];
            i12 += (-W1) * iArr[i16];
            i13 += W7 * iArr[i16];
            i14 += W3 * iArr[i16];
        }
        int i17 = i + 48;
        if (iArr[i17] != 0) {
            i2 = i6 + (W6 * iArr[i17]);
            i7 += (-W2) * iArr[i17];
            i8 += W2 * iArr[i17];
            i4 += (-W6) * iArr[i17];
        } else {
            i2 = i6;
        }
        i6 = i + 56;
        if (iArr[i6] != 0) {
            i3 = i11 + (W7 * iArr[i6]);
            i12 += (-W5) * iArr[i6];
            i13 += W3 * iArr[i6];
            i14 += (-W1) * iArr[i6];
        } else {
            i3 = i11;
        }
        iArr[i] = (i2 + i3) >> COL_SHIFT;
        iArr[i9] = (i7 + i12) >> COL_SHIFT;
        iArr[i5] = (i8 + i13) >> COL_SHIFT;
        iArr[i10] = (i4 + i14) >> COL_SHIFT;
        iArr[i15] = (i4 - i14) >> COL_SHIFT;
        iArr[i16] = (i8 - i13) >> COL_SHIFT;
        iArr[i17] = (i7 - i12) >> COL_SHIFT;
        iArr[i6] = (i2 - i3) >> COL_SHIFT;
    }

    private static final void idctRow(int[] iArr, int i) {
        int i2 = (W4 * iArr[i]) + (1 << (ROW_SHIFT - 1));
        int i3 = i + 2;
        int i4 = (W2 * iArr[i3]) + i2;
        int i5 = (W6 * iArr[i3]) + i2;
        int i6 = i2 - (W6 * iArr[i3]);
        i2 -= W2 * iArr[i3];
        int i7 = i + 1;
        int i8 = i + 3;
        int i9 = (W1 * iArr[i7]) + (W3 * iArr[i8]);
        int i10 = (W3 * iArr[i7]) + ((-W7) * iArr[i8]);
        int i11 = (W5 * iArr[i7]) + ((-W1) * iArr[i8]);
        int i12 = (W7 * iArr[i7]) + ((-W5) * iArr[i8]);
        int i13 = i + 4;
        if (!(iArr[i13] == 0 && iArr[i + 5] == 0 && iArr[i + 6] == 0 && iArr[i + 7] == 0)) {
            int i14 = i + 6;
            i4 += (W4 * iArr[i13]) + (W6 * iArr[i14]);
            i5 += ((-W4) * iArr[i13]) - (W2 * iArr[i14]);
            i6 += ((-W4) * iArr[i13]) + (W2 * iArr[i14]);
            i2 += (W4 * iArr[i13]) - (W6 * iArr[i14]);
            int i15 = i + 5;
            i14 = i + 7;
            i9 = (i9 + (W5 * iArr[i15])) + (W7 * iArr[i14]);
            i10 = (i10 + ((-W1) * iArr[i15])) + ((-W5) * iArr[i14]);
            i11 = (i11 + (W7 * iArr[i15])) + (W3 * iArr[i14]);
            i12 = (i12 + (W3 * iArr[i15])) + ((-W1) * iArr[i14]);
        }
        iArr[i + 0] = (i4 + i9) >> ROW_SHIFT;
        iArr[i + 7] = (i4 - i9) >> ROW_SHIFT;
        iArr[i7] = (i5 + i10) >> ROW_SHIFT;
        iArr[i + 6] = (i5 - i10) >> ROW_SHIFT;
        iArr[i3] = (i6 + i11) >> ROW_SHIFT;
        iArr[i + 5] = (i6 - i11) >> ROW_SHIFT;
        iArr[i8] = (i2 + i12) >> ROW_SHIFT;
        iArr[i13] = (i2 - i12) >> ROW_SHIFT;
    }
}
