package org.jcodec.common.dct;

import org.jcodec.scale.ImageConvert;

public class SlowDCT extends DCT {
    public static final SlowDCT INSTANCE = new SlowDCT();
    private static final double rSqrt2 = (1.0d / Math.sqrt(2.0d));

    public short[] encode(byte[] bArr) {
        int i;
        short[] sArr = new short[64];
        int i2 = 0;
        while (true) {
            int i3 = 8;
            if (i2 >= 8) {
                break;
            }
            int i4 = 0;
            while (i4 < i3) {
                float f = 0.0f;
                i = 0;
                while (i < i3) {
                    float f2 = f;
                    int i5 = 0;
                    while (i5 < i3) {
                        i3 = i4;
                        f2 = (float) (((double) f2) + ((((double) ((float) bArr[(i * 8) + i5])) * Math.cos(((((double) i) + 0.5d) * 0.39269908169872414d) * ((double) i2))) * Math.cos(((double) i3) * (0.39269908169872414d * (((double) i5) + 0.5d)))));
                        i5++;
                        i4 = i3;
                        i3 = 8;
                    }
                    i3 = i4;
                    i++;
                    f = f2;
                    i3 = 8;
                }
                i3 = i4;
                sArr[(i2 * 8) + i3] = (short) ((byte) ((int) f));
                i4 = i3 + 1;
                i3 = 8;
            }
            i2++;
        }
        sArr[0] = (short) ((byte) ((int) (((float) sArr[0]) / 8.0f)));
        double sqrt = Math.sqrt(2.0d);
        i = 1;
        for (i5 = 8; i < i5; i5 = 8) {
            sArr[i] = (short) ((byte) ((int) ((((double) ((float) sArr[0])) * sqrt) / 8.0d)));
            i5 = i * 8;
            sArr[i5] = (short) ((byte) ((int) ((((double) ((float) sArr[0])) * sqrt) / 8.0d)));
            for (int i6 = 1; i6 < 8; i6++) {
                sArr[i5 + i6] = (short) ((byte) ((int) (((float) sArr[0]) / 4.0f)));
            }
            i++;
        }
        return sArr;
    }

    public int[] decode(int[] iArr) {
        int[] iArr2 = new int[64];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 8;
            if (i >= 8) {
                return iArr2;
            }
            int i4 = i2;
            i2 = 0;
            while (i2 < i3) {
                int i5;
                int i6;
                double d = 0.0d;
                int i7 = 0;
                int i8 = 0;
                while (i7 < i3) {
                    double d2 = i7 == 0 ? rSqrt2 : 1.0d;
                    int i9 = i8;
                    double d3 = d;
                    int i10 = 0;
                    while (i10 < i3) {
                        i5 = i;
                        d3 += ((((i10 == 0 ? rSqrt2 : 1.0d) * d2) * ((double) iArr[i9])) * Math.cos((((double) (((2 * i2) + 1) * i10)) * 3.141592653589793d) / 16.0d)) * Math.cos((((double) (((2 * i5) + 1) * i7)) * 3.141592653589793d) / 16.0d);
                        i9++;
                        i10++;
                        i = i5;
                        i2 = i2;
                        i3 = 8;
                    }
                    i5 = i;
                    i6 = i2;
                    i7++;
                    d = d3;
                    i8 = i9;
                    i3 = 8;
                }
                i5 = i;
                i6 = i2;
                i = i4 + 1;
                iArr2[i4] = ImageConvert.icrop((int) ((double) Math.round((d * 0.25d) + 128.0d)));
                i2 = i6 + 1;
                i4 = i;
                i = i5;
                i3 = 8;
            }
            i++;
            i2 = i4;
        }
    }
}
