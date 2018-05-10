package org.jcodec.common.dct;

import java.util.Arrays;

public class SparseIDCT {
    public static final int[][] COEFF;
    public static final int DC_SHIFT = 10;
    public static final int PRECISION = 13;

    private static final int div(int i) {
        int i2 = i >> 31;
        int i3 = i >>> 31;
        return ((((i ^ i2) + i3) >> 13) ^ i2) + i3;
    }

    static {
        int[][] iArr = new int[64][];
        COEFF = iArr;
        iArr[0] = new int[64];
        Arrays.fill(COEFF[0], 1024);
        for (int i = 1; i < 64; i++) {
            COEFF[i] = new int[64];
            COEFF[i][i] = 8192;
            SimpleIDCT10Bit.idct10(COEFF[i], 0);
        }
    }

    public static final void start(int[] iArr, int i) {
        i <<= 10;
        for (int i2 = 0; i2 < 64; i2 += 4) {
            iArr[i2 + 0] = i;
            iArr[i2 + 1] = i;
            iArr[i2 + 2] = i;
            iArr[i2 + 3] = i;
        }
    }

    public static final void coeff(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < 64; i3 += 4) {
            iArr[i3] = iArr[i3] + (COEFF[i][i3] * i2);
            int i4 = i3 + 1;
            iArr[i4] = iArr[i4] + (COEFF[i][i4] * i2);
            i4 = i3 + 2;
            iArr[i4] = iArr[i4] + (COEFF[i][i4] * i2);
            i4 = i3 + 3;
            iArr[i4] = iArr[i4] + (COEFF[i][i4] * i2);
        }
    }

    public static final void finish(int[] iArr) {
        for (int i = 0; i < 64; i += 4) {
            iArr[i] = div(iArr[i]);
            int i2 = i + 1;
            iArr[i2] = div(iArr[i2]);
            i2 = i + 2;
            iArr[i2] = div(iArr[i2]);
            i2 = i + 3;
            iArr[i2] = div(iArr[i2]);
        }
    }
}
