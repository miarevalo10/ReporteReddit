package org.jcodec.common.dct;

public class DCTRef {
    static double[] coefficients = new double[64];

    static {
        int i = 0;
        while (true) {
            int i2 = 8;
            if (i < 8) {
                coefficients[i] = Math.sqrt(0.125d);
                while (i2 < 64) {
                    coefficients[i2 + i] = 0.5d * Math.cos(((((double) i2) * (((double) i) + 0.5d)) * 3.141592653589793d) / 64.0d);
                    i2 += 8;
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void fdct(int[] iArr, int i) {
        int i2;
        double[] dArr = new double[64];
        for (i2 = 0; i2 < 64; i2 += 8) {
            for (int i3 = 0; i3 < 8; i3++) {
                double d = 0.0d;
                for (int i4 = 0; i4 < 8; i4++) {
                    d += coefficients[i2 + i4] * ((double) iArr[((i4 * 8) + i3) + i]);
                }
                dArr[i2 + i3] = d * 4.0d;
            }
        }
        for (i2 = 0; i2 < 8; i2++) {
            for (int i5 = 0; i5 < 64; i5 += 8) {
                double d2 = 0.0d;
                for (int i6 = 0; i6 < 8; i6++) {
                    d2 += dArr[i5 + i6] * coefficients[(i2 * 8) + i6];
                }
                iArr[(i5 + i2) + i] = (int) (d2 + 0.499999999999d);
            }
        }
    }

    public static void idct(int[] iArr, int i) {
        int i2;
        int i3;
        double[] dArr = new double[64];
        for (i2 = 0; i2 < 64; i2 += 8) {
            int i4;
            for (i4 = 0; i4 < 8; i4++) {
                double d = 0.0d;
                for (i3 = 0; i3 < 8; i3++) {
                    d += ((double) iArr[i2 + i3]) * coefficients[(i3 * 8) + i4];
                }
                dArr[i2 + i4] = d;
            }
        }
        for (i2 = 0; i2 < 8; i2++) {
            for (i4 = 0; i4 < 8; i4++) {
                d = 0.0d;
                for (i3 = 0; i3 < 64; i3 += 8) {
                    d += coefficients[i3 + i2] * dArr[i3 + i4];
                }
                iArr[(i2 * 8) + i4] = (int) (d + 0.5d);
            }
        }
    }
}
