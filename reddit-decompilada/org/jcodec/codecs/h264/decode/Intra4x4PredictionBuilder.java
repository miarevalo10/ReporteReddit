package org.jcodec.codecs.h264.decode;

import org.jcodec.common.tools.MathUtil;

public class Intra4x4PredictionBuilder {
    public static void predictWithMode(int i, int[] iArr, boolean z, boolean z2, boolean z3, int[] iArr2, int[] iArr3, int[] iArr4, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                predictVertical(iArr, z2, iArr3, i2, i3, i4);
                break;
            case 1:
                predictHorizontal(iArr, z, iArr2, i2, i3, i4);
                break;
            case 2:
                predictDC(iArr, z, z2, iArr2, iArr3, i2, i3, i4);
                break;
            case 3:
                predictDiagonalDownLeft(iArr, z2, z3, iArr3, i2, i3, i4);
                break;
            case 4:
                predictDiagonalDownRight(iArr, z, z2, iArr2, iArr3, iArr4, i2, i3, i4);
                break;
            case 5:
                predictVerticalRight(iArr, z, z2, iArr2, iArr3, iArr4, i2, i3, i4);
                break;
            case 6:
                predictHorizontalDown(iArr, z, z2, iArr2, iArr3, iArr4, i2, i3, i4);
                break;
            case 7:
                predictVerticalLeft(iArr, z2, z3, iArr3, i2, i3, i4);
                break;
            case 8:
                predictHorizontalUp(iArr, z, iArr2, i2, i3, i4);
                break;
            default:
                break;
        }
        int i5 = i2 + i3;
        int i6 = (i4 << 4) + i3;
        int i7 = i6 + 3;
        int i8 = i5 + 3;
        iArr4[i4 >> 2] = iArr3[i8];
        iArr2[i4] = iArr[i7];
        iArr2[i4 + 1] = iArr[i7 + 16];
        iArr2[i4 + 2] = iArr[i7 + 32];
        iArr2[i4 + 3] = iArr[i7 + 48];
        i6 += 48;
        iArr3[i5] = iArr[i6];
        iArr3[i5 + 1] = iArr[i6 + 1];
        iArr3[i5 + 2] = iArr[i6 + 2];
        iArr3[i8] = iArr[i6 + 3];
    }

    public static void predictVertical(int[] iArr, boolean z, int[] iArr2, int i, int i2, int i3) {
        i += i2;
        int i4 = (i3 << 4) + i2;
        for (i3 = 0; i3 < 4; i3++) {
            iArr[i4] = MathUtil.clip(iArr[i4] + iArr2[i], 0, 255);
            int i5 = i4 + 1;
            iArr[i5] = MathUtil.clip(iArr[i5] + iArr2[i + 1], 0, 255);
            i5 = i4 + 2;
            iArr[i5] = MathUtil.clip(iArr[i5] + iArr2[i + 2], 0, 255);
            i5 = i4 + 3;
            iArr[i5] = MathUtil.clip(iArr[i5] + iArr2[i + 3], 0, 255);
            i4 += 16;
        }
    }

    public static void predictHorizontal(int[] iArr, boolean z, int[] iArr2, int i, int i2, int i3) {
        i2 = (i3 << 4) + i2;
        for (z = false; z < true; z++) {
            int i4 = iArr2[i3 + z];
            iArr[i2] = MathUtil.clip(iArr[i2] + i4, 0, 255);
            int i5 = i2 + 1;
            iArr[i5] = MathUtil.clip(iArr[i5] + i4, 0, 255);
            i5 = i2 + 2;
            iArr[i5] = MathUtil.clip(iArr[i5] + i4, 0, 255);
            i5 = i2 + 3;
            iArr[i5] = MathUtil.clip(iArr[i5] + i4, 0, 255);
            i2 += 16;
        }
    }

    public static void predictDC(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        if (z && z2) {
            i += i2;
            z = ((((((((iArr2[i3] + iArr2[i3 + 1]) + iArr2[i3 + 2]) + iArr2[i3 + 3]) + iArr3[i]) + iArr3[i + 1]) + iArr3[i + 2]) + iArr3[i + 3]) + true) >> 3;
        } else if (z) {
            z = ((((iArr2[i3] + iArr2[i3 + 1]) + iArr2[i3 + 2]) + iArr2[i3 + 3]) + 2) >> 2;
        } else if (z2) {
            i += i2;
            z = ((((iArr3[i] + iArr3[i + 1]) + iArr3[i + 2]) + iArr3[i + 3]) + 2) >> 2;
        } else {
            z = true;
        }
        iArr3 = (i3 << 4) + i2;
        for (z2 = false; z2 < true; z2++) {
            iArr[iArr3] = MathUtil.clip(iArr[iArr3] + z, 0, 255);
            i = iArr3 + 1;
            iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
            i = iArr3 + 2;
            iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
            i = iArr3 + 3;
            iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
            iArr3 += 16;
        }
    }

    public static void predictDiagonalDownLeft(int[] iArr, boolean z, boolean z2, int[] iArr2, int i, int i2, int i3) {
        i += i2;
        z = i + 3;
        int i4 = iArr2[z];
        int i5 = iArr2[z];
        int i6 = iArr2[z];
        int i7 = iArr2[z];
        if (z2) {
            i4 = iArr2[i + 4];
            i5 = iArr2[i + 5];
            i6 = iArr2[i + 6];
            i7 = iArr2[i + 7];
        }
        int i8 = i + 2;
        i++;
        z2 = (((iArr2[i] + iArr2[i8]) + (iArr2[i] * 2)) + true) >> true;
        i = (((iArr2[i] + iArr2[z]) + (iArr2[i8] * 2)) + 2) >> 2;
        i8 = (((iArr2[i8] + i4) + (iArr2[z] * 2)) + 2) >> 2;
        z = (((iArr2[z] + i5) + (2 * i4)) + true) >> true;
        iArr2 = (((i4 + i6) + (2 * i5)) + 2) >> 2;
        i4 = (((i5 + i7) + (2 * i6)) + 2) >> 2;
        i5 = ((i6 + (3 * i7)) + 2) >> 2;
        i3 = (i3 << 4) + i2;
        iArr[i3] = MathUtil.clip(iArr[i3] + z2, 0, 255);
        i2 = i3 + 1;
        iArr[i2] = MathUtil.clip(iArr[i2] + i, 0, 255);
        i2 = i3 + 2;
        iArr[i2] = MathUtil.clip(iArr[i2] + i8, 0, 255);
        i2 = i3 + 3;
        iArr[i2] = MathUtil.clip(iArr[i2] + z, 0, 255);
        i2 = i3 + 16;
        iArr[i2] = MathUtil.clip(iArr[i2] + i, 0, 255);
        i = i3 + 17;
        iArr[i] = MathUtil.clip(iArr[i] + i8, 0, 255);
        i = i3 + 18;
        iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
        i = i3 + 19;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 32;
        iArr[i] = MathUtil.clip(iArr[i] + i8, 0, 255);
        i = i3 + 33;
        iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
        i = i3 + 34;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 35;
        iArr[i] = MathUtil.clip(iArr[i] + i4, 0, 255);
        i = i3 + 48;
        iArr[i] = MathUtil.clip(iArr[i] + z, 0, 255);
        z = i3 + 49;
        iArr[z] = MathUtil.clip(iArr[z] + iArr2, 0, 255);
        z = i3 + 50;
        iArr[z] = MathUtil.clip(iArr[z] + i4, 0, 255);
        i3 += 51;
        iArr[i3] = MathUtil.clip(iArr[i3] + i5, 0, 255);
    }

    public static void predictDiagonalDownRight(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int i4 = (i3 << 4) + i2;
        int i5 = 0;
        while (true) {
            int i6 = 4;
            if (i5 < 4) {
                int i7 = 0;
                while (i7 < i6) {
                    int i8;
                    int i9;
                    int i10;
                    if (i7 > i5) {
                        i8 = i7 - i5;
                        if (i8 - 2 == -1) {
                            i6 = iArr4[i3 >> 2];
                        } else {
                            i6 = iArr3[(((i + i2) + i7) - i5) - 2];
                        }
                        if (i8 - 1 == -1) {
                            i9 = iArr4[i3 >> 2];
                        } else {
                            i9 = iArr3[(((i + i2) + i7) - i5) - 1];
                        }
                        if (i8 == -1) {
                            i10 = iArr4[i3 >> 2];
                        } else {
                            i10 = iArr3[((i + i2) + i7) - i5];
                        }
                        i8 = i4 + i7;
                        iArr[i8] = MathUtil.clip(((((i6 + (i9 * 2)) + i10) + 2) >> 2) + iArr[i8], 0, 255);
                    } else if (i7 < i5) {
                        i9 = i5 - i7;
                        if (i9 - 2 == -1) {
                            i6 = iArr4[i3 >> 2];
                        } else {
                            i6 = iArr2[((i3 + i5) - i7) - 2];
                        }
                        if (i9 - 1 == -1) {
                            i8 = iArr4[i3 >> 2];
                        } else {
                            i8 = iArr2[((i3 + i5) - i7) - 1];
                        }
                        if (i9 == -1) {
                            i9 = iArr4[i3 >> 2];
                        } else {
                            i9 = iArr2[(i3 + i5) - i7];
                        }
                        i10 = i4 + i7;
                        iArr[i10] = MathUtil.clip(((((i6 + (i8 * 2)) + i9) + 2) >> 2) + iArr[i10], 0, 255);
                    } else {
                        i9 = i4 + i7;
                        iArr[i9] = MathUtil.clip(iArr[i9] + ((((iArr3[(i + i2) + 0] + (iArr4[i3 >> 2] * 2)) + iArr2[i3]) + 2) >> 2), 0, 255);
                    }
                    i7++;
                    i6 = 4;
                }
                i4 += 16;
                i5++;
            } else {
                return;
            }
        }
    }

    public static void predictVerticalRight(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int i4 = i3 >> 2;
        int i5 = i + i2;
        int i6 = i5 + 0;
        int i7 = ((iArr4[i4] + iArr3[i6]) + 1) >> 1;
        int i8 = i5 + 1;
        int i9 = ((iArr3[i6] + iArr3[i8]) + 1) >> 1;
        int i10 = i5 + 2;
        int i11 = ((iArr3[i8] + iArr3[i10]) + 1) >> 1;
        i5 += 3;
        int i12 = ((iArr3[i10] + iArr3[i5]) + 1) >> 1;
        int i13 = (((iArr2[i3] + (iArr4[i4] * 2)) + iArr3[i6]) + 2) >> 2;
        int i14 = (((iArr4[i4] + (iArr3[i6] * 2)) + iArr3[i8]) + 2) >> 2;
        i6 = (((iArr3[i6] + (iArr3[i8] * 2)) + iArr3[i10]) + 2) >> 2;
        int i15 = (((iArr3[i8] + (iArr3[i10] * 2)) + iArr3[i5]) + 2) >> 2;
        int i16 = iArr4[i4] + (iArr2[i3] * 2);
        i4 = i3 + 1;
        i16 = ((i16 + iArr2[i4]) + 2) >> 2;
        int i17 = (((iArr2[i3] + (iArr2[i4] * 2)) + iArr2[i3 + 2]) + 2) >> 2;
        int i18 = (i3 << 4) + i2;
        iArr[i18] = MathUtil.clip(iArr[i18] + i7, 0, 255);
        int i19 = i18 + 1;
        iArr[i19] = MathUtil.clip(iArr[i19] + i9, 0, 255);
        i19 = i18 + 2;
        iArr[i19] = MathUtil.clip(iArr[i19] + i11, 0, 255);
        i19 = i18 + 3;
        iArr[i19] = MathUtil.clip(iArr[i19] + i12, 0, 255);
        i19 = i18 + 16;
        iArr[i19] = MathUtil.clip(iArr[i19] + i13, 0, 255);
        i19 = i18 + 17;
        iArr[i19] = MathUtil.clip(iArr[i19] + i14, 0, 255);
        i19 = i18 + 18;
        iArr[i19] = MathUtil.clip(iArr[i19] + i6, 0, 255);
        i19 = i18 + 19;
        iArr[i19] = MathUtil.clip(iArr[i19] + i15, 0, 255);
        i15 = i18 + 32;
        iArr[i15] = MathUtil.clip(iArr[i15] + i16, 0, 255);
        i15 = i18 + 33;
        iArr[i15] = MathUtil.clip(iArr[i15] + i7, 0, 255);
        i15 = i18 + 34;
        iArr[i15] = MathUtil.clip(iArr[i15] + i9, 0, 255);
        i15 = i18 + 35;
        iArr[i15] = MathUtil.clip(iArr[i15] + i11, 0, 255);
        i15 = i18 + 48;
        iArr[i15] = MathUtil.clip(iArr[i15] + i17, 0, 255);
        i17 = i18 + 49;
        iArr[i17] = MathUtil.clip(iArr[i17] + i13, 0, 255);
        i17 = i18 + 50;
        iArr[i17] = MathUtil.clip(iArr[i17] + i14, 0, 255);
        i18 += 51;
        iArr[i18] = MathUtil.clip(iArr[i18] + i6, 0, 255);
    }

    public static void predictHorizontalDown(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int i4 = i3 >> 2;
        int i5 = ((iArr4[i4] + iArr2[i3]) + 1) >> 1;
        int i6 = i + i2;
        int i7 = i6 + 0;
        int i8 = (((iArr2[i3] + (iArr4[i4] * 2)) + iArr3[i7]) + 2) >> 2;
        int i9 = i6 + 1;
        int i10 = (((iArr4[i4] + (iArr3[i7] * 2)) + iArr3[i9]) + 2) >> 2;
        int i11 = (((iArr3[i7] + (iArr3[i9] * 2)) + iArr3[i6 + 2]) + 2) >> 2;
        i7 = i3 + 1;
        i6 = ((iArr2[i3] + iArr2[i7]) + 1) >> 1;
        int i12 = (((iArr4[i4] + (iArr2[i3] * 2)) + iArr2[i7]) + 2) >> 2;
        i9 = i3 + 2;
        i4 = ((iArr2[i7] + iArr2[i9]) + 1) >> 1;
        int i13 = (((iArr2[i3] + (iArr2[i7] * 2)) + iArr2[i9]) + 2) >> 2;
        int i14 = i3 + 3;
        int i15 = ((iArr2[i9] + iArr2[i14]) + 1) >> 1;
        int i16 = (((iArr2[i7] + (iArr2[i9] * 2)) + iArr2[i14]) + 2) >> 2;
        int i17 = (i3 << 4) + i2;
        iArr[i17] = MathUtil.clip(iArr[i17] + i5, 0, 255);
        int i18 = i17 + 1;
        iArr[i18] = MathUtil.clip(iArr[i18] + i8, 0, 255);
        i18 = i17 + 2;
        iArr[i18] = MathUtil.clip(iArr[i18] + i10, 0, 255);
        i18 = i17 + 3;
        iArr[i18] = MathUtil.clip(iArr[i18] + i11, 0, 255);
        i11 = i17 + 16;
        iArr[i11] = MathUtil.clip(iArr[i11] + i6, 0, 255);
        i11 = i17 + 17;
        iArr[i11] = MathUtil.clip(iArr[i11] + i12, 0, 255);
        i11 = i17 + 18;
        iArr[i11] = MathUtil.clip(iArr[i11] + i5, 0, 255);
        i11 = i17 + 19;
        iArr[i11] = MathUtil.clip(iArr[i11] + i8, 0, 255);
        i11 = i17 + 32;
        iArr[i11] = MathUtil.clip(iArr[i11] + i4, 0, 255);
        i11 = i17 + 33;
        iArr[i11] = MathUtil.clip(iArr[i11] + i13, 0, 255);
        i11 = i17 + 34;
        iArr[i11] = MathUtil.clip(iArr[i11] + i6, 0, 255);
        i11 = i17 + 35;
        iArr[i11] = MathUtil.clip(iArr[i11] + i12, 0, 255);
        i11 = i17 + 48;
        iArr[i11] = MathUtil.clip(iArr[i11] + i15, 0, 255);
        i11 = i17 + 49;
        iArr[i11] = MathUtil.clip(iArr[i11] + i16, 0, 255);
        i16 = i17 + 50;
        iArr[i16] = MathUtil.clip(iArr[i16] + i4, 0, 255);
        i17 += 51;
        iArr[i17] = MathUtil.clip(iArr[i17] + i13, 0, 255);
    }

    public static void predictVerticalLeft(int[] iArr, boolean z, boolean z2, int[] iArr2, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i4 + 3;
        int i6 = iArr2[i5];
        int i7 = iArr2[i5];
        int i8 = iArr2[i5];
        if (z2) {
            i6 = iArr2[i4 + 4];
            i7 = iArr2[i4 + 5];
            i8 = iArr2[i4 + 6];
        }
        int i9 = i4 + 1;
        int i10 = ((iArr2[i4] + iArr2[i9]) + 1) >> 1;
        int i11 = i4 + 2;
        int i12 = ((iArr2[i9] + iArr2[i11]) + 1) >> 1;
        int i13 = ((iArr2[i11] + iArr2[i5]) + 1) >> 1;
        int i14 = ((iArr2[i5] + i6) + 1) >> 1;
        int i15 = ((i6 + i7) + 1) >> 1;
        i4 = (((iArr2[i4] + (iArr2[i9] * 2)) + iArr2[i11]) + 2) >> 2;
        i9 = (((iArr2[i9] + (iArr2[i11] * 2)) + iArr2[i5]) + 2) >> 2;
        i11 = (((iArr2[i11] + (iArr2[i5] * 2)) + i6) + 2) >> 2;
        int i16 = (((iArr2[i5] + (2 * i6)) + i7) + 2) >> 2;
        i5 = (((i6 + (i7 * 2)) + i8) + 2) >> 2;
        i6 = (i3 << 4) + i2;
        iArr[i6] = MathUtil.clip(iArr[i6] + i10, 0, 255);
        int i17 = i6 + 1;
        iArr[i17] = MathUtil.clip(iArr[i17] + i12, 0, 255);
        i17 = i6 + 2;
        iArr[i17] = MathUtil.clip(iArr[i17] + i13, 0, 255);
        i17 = i6 + 3;
        iArr[i17] = MathUtil.clip(iArr[i17] + i14, 0, 255);
        i17 = i6 + 16;
        iArr[i17] = MathUtil.clip(iArr[i17] + i4, 0, 255);
        i17 = i6 + 17;
        iArr[i17] = MathUtil.clip(iArr[i17] + i9, 0, 255);
        i17 = i6 + 18;
        iArr[i17] = MathUtil.clip(iArr[i17] + i11, 0, 255);
        i17 = i6 + 19;
        iArr[i17] = MathUtil.clip(iArr[i17] + i16, 0, 255);
        i17 = i6 + 32;
        iArr[i17] = MathUtil.clip(iArr[i17] + i12, 0, 255);
        i17 = i6 + 33;
        iArr[i17] = MathUtil.clip(iArr[i17] + i13, 0, 255);
        i17 = i6 + 34;
        iArr[i17] = MathUtil.clip(iArr[i17] + i14, 0, 255);
        i17 = i6 + 35;
        iArr[i17] = MathUtil.clip(iArr[i17] + i15, 0, 255);
        i17 = i6 + 48;
        iArr[i17] = MathUtil.clip(iArr[i17] + i9, 0, 255);
        i17 = i6 + 49;
        iArr[i17] = MathUtil.clip(iArr[i17] + i11, 0, 255);
        i17 = i6 + 50;
        iArr[i17] = MathUtil.clip(iArr[i17] + i16, 0, 255);
        i6 += 51;
        iArr[i6] = MathUtil.clip(iArr[i6] + i5, 0, 255);
    }

    public static void predictHorizontalUp(int[] iArr, boolean z, int[] iArr2, int i, int i2, int i3) {
        i = i3 + 1;
        z = ((iArr2[i3] + iArr2[i]) + 1) >> 1;
        int i4 = i3 + 2;
        int i5 = (((iArr2[i3] + (iArr2[i] << 1)) + iArr2[i4]) + 2) >> 2;
        int i6 = ((iArr2[i] + iArr2[i4]) + 1) >> 1;
        int i7 = i3 + 3;
        i = (((iArr2[i] + (iArr2[i4] << 1)) + iArr2[i7]) + 2) >> 2;
        int i8 = ((iArr2[i4] + iArr2[i7]) + 1) >> 1;
        i4 = (((iArr2[i4] + (iArr2[i7] << 1)) + iArr2[i7]) + 2) >> 2;
        iArr2 = iArr2[i7];
        i3 = (i3 << 4) + i2;
        iArr[i3] = MathUtil.clip(iArr[i3] + z, 0, 255);
        i2 = i3 + 1;
        iArr[i2] = MathUtil.clip(iArr[i2] + i5, 0, 255);
        i2 = i3 + 2;
        iArr[i2] = MathUtil.clip(iArr[i2] + i6, 0, 255);
        i2 = i3 + 3;
        iArr[i2] = MathUtil.clip(iArr[i2] + i, 0, 255);
        i2 = i3 + 16;
        iArr[i2] = MathUtil.clip(iArr[i2] + i6, 0, 255);
        i2 = i3 + 17;
        iArr[i2] = MathUtil.clip(iArr[i2] + i, 0, 255);
        i = i3 + 18;
        iArr[i] = MathUtil.clip(iArr[i] + i8, 0, 255);
        i = i3 + 19;
        iArr[i] = MathUtil.clip(iArr[i] + i4, 0, 255);
        i = i3 + 32;
        iArr[i] = MathUtil.clip(iArr[i] + i8, 0, 255);
        i = i3 + 33;
        iArr[i] = MathUtil.clip(iArr[i] + i4, 0, 255);
        i = i3 + 34;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 35;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 48;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 49;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i = i3 + 50;
        iArr[i] = MathUtil.clip(iArr[i] + iArr2, 0, 255);
        i3 += 51;
        iArr[i3] = MathUtil.clip(iArr[i3] + iArr2, 0, 255);
    }
}
