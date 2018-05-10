package org.jcodec.codecs.h264.decode;

import org.jcodec.common.tools.MathUtil;

public class ChromaPredictionBuilder {
    public static void predictWithMode(int[] iArr, int i, int i2, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4) {
        switch (i) {
            case 0:
                predictDC(iArr, i2, z, z2, iArr2, iArr3);
                return;
            case 1:
                predictHorizontal(iArr, i2, z, iArr2);
                return;
            case 2:
                predictVertical(iArr, i2, z2, iArr3);
                return;
            case 3:
                predictPlane(iArr, i2, z, z2, iArr2, iArr3, iArr4);
                break;
            default:
                break;
        }
    }

    public static void predictDC(int[] iArr, int i, boolean z, boolean z2, int[] iArr2, int[] iArr3) {
        predictDCInside(iArr, 0, 0, i, z, z2, iArr2, iArr3);
        predictDCTopBorder(iArr, 1, 0, i, z, z2, iArr2, iArr3);
        predictDCLeftBorder(iArr, 0, 1, i, z, z2, iArr2, iArr3);
        predictDCInside(iArr, 1, 1, i, z, z2, iArr2, iArr3);
    }

    public static void predictVertical(int[] iArr, int i, boolean z, int[] iArr2) {
        int i2 = 0;
        int i3 = i2;
        while (i2 < 8) {
            int i4 = i3;
            i3 = 0;
            while (i3 < 8) {
                iArr[i4] = MathUtil.clip(iArr[i4] + iArr2[(i << 3) + i3], 0, 255);
                i3++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
    }

    public static void predictHorizontal(int[] iArr, int i, boolean z, int[] iArr2) {
        z = false;
        boolean z2 = z;
        while (z < true) {
            boolean z3 = z2;
            int i2 = 0;
            while (i2 < 8) {
                iArr[z3] = MathUtil.clip(iArr[z3] + iArr2[z], 0, 255);
                i2++;
                z3++;
            }
            z++;
            z2 = z3;
        }
    }

    public static void predictDCInside(int[] iArr, int i, int i2, int i3, boolean z, boolean z2, int[] iArr2, int[] iArr3) {
        i <<= 2;
        i3 = (i3 << 3) + i;
        int i4 = i2 << 2;
        if (z && z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr2[z + i4];
                z++;
            }
            for (z = false; z < true; z++) {
                z2 += iArr3[i3 + z];
            }
            i3 = (z2 + true) >> 3;
        } else if (z) {
            i3 = 0;
            z = i3;
            while (i3 < 4) {
                z += iArr2[i4 + i3];
                i3++;
            }
            i3 = (z + 2) >> 2;
        } else if (z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr3[i3 + z];
                z++;
            }
            i3 = (z2 + 2) >> 2;
        } else {
            i3 = 128;
        }
        i2 = (i2 << 5) + i;
        i = 0;
        while (i < 4) {
            iArr[i2] = MathUtil.clip(iArr[i2] + i3, 0, 255);
            z = i2 + 1;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 2;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 3;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            i++;
            i2 += 8;
        }
    }

    public static void predictDCTopBorder(int[] iArr, int i, int i2, int i3, boolean z, boolean z2, int[] iArr2, int[] iArr3) {
        i <<= 2;
        i3 = (i3 << 3) + i;
        int i4 = i2 << 2;
        if (z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr3[i3 + z];
                z++;
            }
            i3 = (z2 + 2) >> 2;
        } else if (z) {
            i3 = 0;
            z = i3;
            while (i3 < 4) {
                z += iArr2[i4 + i3];
                i3++;
            }
            i3 = (z + 2) >> 2;
        } else {
            i3 = 128;
        }
        i2 = (i2 << 5) + i;
        i = 0;
        while (i < 4) {
            iArr[i2] = MathUtil.clip(iArr[i2] + i3, 0, 255);
            z = i2 + 1;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 2;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 3;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            i++;
            i2 += 8;
        }
    }

    public static void predictDCLeftBorder(int[] iArr, int i, int i2, int i3, boolean z, boolean z2, int[] iArr2, int[] iArr3) {
        i <<= 2;
        i3 = (i3 << 3) + i;
        int i4 = i2 << 2;
        if (z) {
            i3 = 0;
            z = i3;
            while (i3 < 4) {
                z += iArr2[i4 + i3];
                i3++;
            }
            i3 = (z + 2) >> 2;
        } else if (z2) {
            z = false;
            z2 = z;
            while (z < true) {
                z2 += iArr3[i3 + z];
                z++;
            }
            i3 = (z2 + 2) >> 2;
        } else {
            i3 = 128;
        }
        i2 = (i2 << 5) + i;
        i = 0;
        while (i < 4) {
            iArr[i2] = MathUtil.clip(iArr[i2] + i3, 0, 255);
            z = i2 + 1;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 2;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            z = i2 + 3;
            iArr[z] = MathUtil.clip(iArr[z] + i3, 0, 255);
            i++;
            i2 += 8;
        }
    }

    public static void predictPlane(int[] iArr, int i, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i2;
        i <<= 3;
        int i3 = 0;
        int i4 = i3;
        while (i3 < 3) {
            i2 = i3 + 1;
            i4 += (iArr3[(i + 4) + i3] - iArr3[(i + 2) - i3]) * i2;
            i3 = i2;
        }
        i += 7;
        i4 += (iArr3[i] - iArr4[0]) * 4;
        i2 = 0;
        int i5 = i2;
        while (i2 < 3) {
            int i6 = i2 + 1;
            i5 += (iArr2[4 + i2] - iArr2[2 - i2]) * i6;
            i2 = i6;
        }
        iArr4 = (((i5 + (4 * (iArr2[7] - iArr4[0]))) * 34) + 32) >> 6;
        z = ((true * i4) + 32) >> 6;
        iArr2 = (iArr2[7] + iArr3[i]) * 16;
        iArr3 = null;
        int[] iArr5 = iArr3;
        while (iArr3 < 8) {
            i2 = iArr5;
            i3 = 0;
            while (i3 < 8) {
                iArr[i2] = MathUtil.clip(iArr[i2] + MathUtil.clip((((((i3 - 3) * z) + iArr2) + ((iArr3 - 3) * iArr4)) + 16) >> 5, 0, 255), 0, 255);
                i3++;
                i2++;
            }
            iArr3++;
            iArr5 = i2;
        }
    }
}
