package org.jcodec.codecs.h264.decode.aso;

public class SliceGroupMapBuilder {
    private static int Max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    private static int Min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static int[] buildInterleavedMap(int i, int i2, int[] iArr) {
        int length = iArr.length;
        i *= i2;
        i2 = new int[i];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            for (i3 = 0; i3 < length && i4 < i; i3++) {
                for (int i5 = 0; i5 < iArr[i3]; i5++) {
                    int i6 = i4 + i5;
                    if (i6 >= i) {
                        break;
                    }
                    i2[i6] = i3;
                }
                i4 += iArr[i3];
            }
            if (i4 >= i) {
                return i2;
            }
            i3 = i4;
        }
    }

    public static int[] buildDispersedMap(int i, int i2, int i3) {
        i2 *= i;
        int[] iArr = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            iArr[i4] = ((i4 % i) + (((i4 / i) * i3) / 2)) % i3;
        }
        return iArr;
    }

    public static int[] buildForegroundMap(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        int i4;
        i2 *= i;
        int[] iArr3 = new int[i2];
        for (i4 = 0; i4 < i2; i4++) {
            iArr3[i4] = i3 - 1;
        }
        for (i3 -= 2; i3 >= 0; i3--) {
            i4 = iArr[i3] % i;
            int i5 = iArr2[i3] / i;
            int i6 = iArr2[i3] % i;
            for (i2 = iArr[i3] / i; i2 <= i5; i2++) {
                for (int i7 = i4; i7 <= i6; i7++) {
                    iArr3[(i2 * i) + i7] = i3;
                }
            }
        }
        return iArr3;
    }

    public static int[] buildBoxOutMap(int i, int i2, boolean z, int i3) {
        int i4 = i * i2;
        int[] iArr = new int[i4];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i6 >= i4) {
                break;
            }
            iArr[i6] = 1;
            i6++;
        }
        int i8 = z;
        int i9 = (i - z) / 2;
        int i10 = i9;
        int i11 = i10;
        int i12 = (i2 - z) / 2;
        int i13 = i12;
        int i14 = z - 1;
        i4 = i3;
        int i15 = i13;
        int i16 = 0;
        while (i16 < i4) {
            int i17 = (i15 * i) + i9;
            i6 = iArr[i17] == i7 ? i7 : i5;
            if (i6 != 0) {
                iArr[i17] = i5;
            }
            if (i14 == -1 && i9 == i10) {
                i10 = Max(i10 - 1, i5);
                i8 = (2 * z) - 1;
                i17 = 2;
                i14 = i5;
                i5 = 1;
                i9 = i10;
            } else {
                i5 = 1;
                if (i14 == 1 && i9 == i11) {
                    i17 = 2;
                    i11 = Min(i11 + 1, i - 1);
                    i8 = 1 - (2 * z);
                    i14 = 0;
                    i9 = i11;
                } else {
                    i17 = 2;
                    if (i8 == -1 && i15 == i12) {
                        i15 = Max(i12 - 1, 0);
                        i14 = 1 - (2 * z);
                        i8 = 0;
                        i12 = i15;
                    } else {
                        if (i8 == 1) {
                            i7 = i13;
                            if (i15 == i7) {
                                i13 = Min(i7 + 1, i2 - 1);
                                i14 = (2 * z) - 1;
                                i8 = 0;
                                i15 = i13;
                            }
                        } else {
                            i7 = i13;
                        }
                        i9 += i14;
                        i15 += i8;
                        i13 = i7;
                    }
                }
            }
            i16 += i6;
            i7 = i5;
            i6 = i17;
            i5 = 0;
        }
        return iArr;
    }

    public static int[] buildRasterScanMap(int i, int i2, int i3, boolean z) {
        i *= i2;
        i2 = new int[i];
        int i4 = 0;
        while (i4 < i3) {
            i2[i4] = z;
            i4++;
        }
        while (i4 < i) {
            i2[i4] = 1 - z;
            i4++;
        }
        return i2;
    }

    public static int[] buildWipeMap(int i, int i2, int i3, boolean z) {
        int[] iArr = new int[(i * i2)];
        int i4 = 0;
        int i5 = i4;
        while (i4 < i) {
            int i6 = i5;
            i5 = 0;
            while (i5 < i2) {
                int i7 = (i5 * i) + i4;
                int i8 = i6 + 1;
                if (i6 < i3) {
                    iArr[i7] = z;
                } else {
                    iArr[i7] = 1 - z;
                }
                i5++;
                i6 = i8;
            }
            i4++;
            i5 = i6;
        }
        return iArr;
    }
}
