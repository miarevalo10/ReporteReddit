package org.jcodec.common.dct;

public class IDCT4x4 {
    public static final int C1 = C_FIX(0.6532814824d);
    public static final int C2 = C_FIX(0.2705980501d);
    public static final int C3 = C_FIX(0.5d);
    public static final int CN_SHIFT = 12;
    public static final int C_SHIFT = 18;
    public static final int R1 = R_FIX(0.6532814824d);
    public static final int R2 = R_FIX(0.2705980501d);
    public static final int R3 = R_FIX(0.5d);
    public static final int RN_SHIFT = 15;
    public static final int R_SHIFT = 11;

    public static final int C_FIX(double d) {
        return (int) (((d * 1.414213562d) * 4096.0d) + 0.5d);
    }

    public static final int R_FIX(double d) {
        return (int) (((d * 1.414213562d) * 32768.0d) + 0.5d);
    }

    public static void idct(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            idct4row(iArr, (i3 << 2) + i);
        }
        while (i2 < 4) {
            idct4col_add(iArr, i + i2);
            i2++;
        }
    }

    private static void idct4col_add(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 4;
        int i4 = iArr[i3];
        int i5 = i + 8;
        int i6 = iArr[i5];
        int i7 = i + 12;
        int i8 = iArr[i7];
        int i9 = ((i2 + i6) * C3) + 131072;
        i2 = ((i2 - i6) * C3) + 131072;
        i6 = (C1 * i4) + (C2 * i8);
        i4 = (i4 * C2) - (i8 * C1);
        iArr[i] = (i9 + i6) >> 18;
        iArr[i3] = (i2 + i4) >> 18;
        iArr[i5] = (i2 - i4) >> 18;
        iArr[i7] = (i9 - i6) >> 18;
    }

    private static void idct4row(int[] iArr, int i) {
        int i2 = iArr[i];
        int i3 = i + 1;
        int i4 = iArr[i3];
        int i5 = i + 2;
        int i6 = iArr[i5];
        int i7 = i + 3;
        int i8 = iArr[i7];
        int i9 = ((i2 + i6) * R3) + 1024;
        i2 = ((i2 - i6) * R3) + 1024;
        i6 = (R1 * i4) + (R2 * i8);
        i4 = (i4 * R2) - (i8 * R1);
        iArr[i] = (i9 + i6) >> 11;
        iArr[i3] = (i2 + i4) >> 11;
        iArr[i5] = (i2 - i4) >> 11;
        iArr[i7] = (i9 - i6) >> 11;
    }
}
