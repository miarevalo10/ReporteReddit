package org.jcodec.codecs.h264.decode;

import org.jcodec.common.tools.MathUtil;

public class Intra16x16PredictionBuilder {
    public static void predictWithMode(int i, int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, int i2) {
        switch (i) {
            case 0:
                predictVertical(iArr, z2, iArr3, i2);
                return;
            case 1:
                predictHorizontal(iArr, z, iArr2, i2);
                return;
            case 2:
                predictDC(iArr, z, z2, iArr2, iArr3, i2);
                return;
            case 3:
                predictPlane(iArr, z, z2, iArr2, iArr3, iArr4, i2);
                break;
            default:
                break;
        }
    }

    public static void predictVertical(int[] iArr, boolean z, int[] iArr2, int i) {
        int i2 = 0;
        int i3 = i2;
        while (i2 < 16) {
            int i4 = i3;
            i3 = 0;
            while (i3 < 16) {
                iArr[i4] = MathUtil.clip(iArr[i4] + iArr2[i + i3], 0, 255);
                i3++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
    }

    public static void predictHorizontal(int[] iArr, boolean z, int[] iArr2, int i) {
        i = 0;
        int i2 = i;
        while (i < 16) {
            int i3 = i2;
            i2 = 0;
            while (i2 < 16) {
                iArr[i3] = MathUtil.clip(iArr[i3] + iArr2[i], 0, 255);
                i2++;
                i3++;
            }
            i++;
            i2 = i3;
        }
    }

    public static void predictDC(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int i) {
        if (z && z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr2[z];
                z++;
            }
            for (z = false; z < true; z++) {
                z2 += iArr3[i + z];
            }
            z = (z2 + true) >> 5;
        } else if (z) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr2[z];
                z++;
            }
            z = (z2 + 8) >> 4;
        } else if (z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr3[i + z];
                z++;
            }
            z = (z2 + 8) >> 4;
        } else {
            z = true;
        }
        for (z2 = false; z2 < 256; z2++) {
            iArr[z2] = MathUtil.clip(iArr[z2] + z, 0, 255);
        }
    }

    public static void predictPlane(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, int i) {
        z2 = false;
        int i2 = z2;
        while (z2 < true) {
            boolean z3 = z2 + 1;
            i2 += (iArr3[(i + 8) + z2] - iArr3[(i + 6) - z2]) * z3;
            z2 = z3;
        }
        i += 15;
        i2 += (iArr3[i] - iArr4[0]) * 8;
        int i3 = 0;
        int i4 = i3;
        while (i3 < 7) {
            int i5 = i3 + 1;
            i4 += (iArr2[8 + i3] - iArr2[6 - i3]) * i5;
            i3 = i5;
        }
        int i6 = (((i4 + (8 * (iArr2[15] - iArr4[0]))) * 5) + 32) >> 6;
        i2 = ((i2 * 5) + 32) >> 6;
        z2 = (iArr2[15] + iArr3[i]) * true;
        iArr3 = null;
        i = iArr3;
        while (iArr3 < 16) {
            i3 = i;
            i = 0;
            while (i < 16) {
                iArr[i3] = MathUtil.clip(iArr[i3] + MathUtil.clip((((((i - 7) * i2) + z2) + ((iArr3 - 7) * i6)) + 16) >> 5, 0, 255), 0, 255);
                i++;
                i3++;
            }
            iArr3++;
            i = i3;
        }
    }
}
