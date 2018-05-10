package org.jcodec.codecs.h264.decode;

import org.jcodec.common.Assert;
import org.jcodec.common.tools.MathUtil;

public class Intra8x8PredictionBuilder {
    static int[] genBuf = new int[24];
    static int[] leftBuf = new int[8];
    static int[] topBuf = new int[16];

    public static void predictWithMode(int i, int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, int[] iArr2, int[] iArr3, int[] iArr4, int i2, int i3, int i4) {
        boolean z5;
        switch (i) {
            case 0:
                Assert.assertTrue(z2);
                predictVertical(iArr, z3, z4, iArr4, iArr3, i2, i3, i4);
                break;
            case 1:
                Assert.assertTrue(z);
                predictHorizontal(iArr, z3, iArr4, iArr2, i2, i3, i4);
                break;
            case 2:
                predictDC(iArr, z3, z4, z, z2, iArr4, iArr2, iArr3, i2, i3, i4);
                break;
            case 3:
                Assert.assertTrue(z2);
                predictDiagonalDownLeft(iArr, z3, z2, z4, iArr4, iArr3, i2, i3, i4);
                break;
            case 4:
                z5 = z2 && z && z3;
                Assert.assertTrue(z5);
                predictDiagonalDownRight(iArr, z4, iArr4, iArr2, iArr3, i2, i3, i4);
                break;
            case 5:
                z5 = z2 && z && z3;
                Assert.assertTrue(z5);
                predictVerticalRight(iArr, z4, iArr4, iArr2, iArr3, i2, i3, i4);
                break;
            case 6:
                z5 = z2 && z && z3;
                Assert.assertTrue(z5);
                predictHorizontalDown(iArr, z4, iArr4, iArr2, iArr3, i2, i3, i4);
                break;
            case 7:
                Assert.assertTrue(z2);
                predictVerticalLeft(iArr, z3, z4, iArr4, iArr3, i2, i3, i4);
                break;
            case 8:
                Assert.assertTrue(z);
                predictHorizontalUp(iArr, z3, iArr4, iArr2, i2, i3, i4);
                break;
            default:
                break;
        }
        int i5 = i2 + i3;
        int i6 = (i4 << 4) + i3;
        int i7 = i6 + 7;
        int i8 = i4 >> 2;
        iArr4[i8] = iArr3[i5 + 7];
        for (int i9 = 0; i9 < 8; i9++) {
            iArr2[i4 + i9] = iArr[(i9 << 4) + i7];
        }
        i6 += 112;
        for (i7 = 0; i7 < 8; i7++) {
            iArr3[i5 + i7] = iArr[i6 + i7];
        }
        iArr4[i8 + 1] = iArr2[i4 + 3];
    }

    private static void interpolateTop(boolean z, boolean z2, int[] iArr, int[] iArr2, int i, int i2, int[] iArr3) {
        iArr3[null] = ((((z ? iArr[i2 >> 2] : iArr2[i]) + (iArr2[i] << 1)) + iArr2[i + 1]) + 2) >> 2;
        z = true;
        while (z < true) {
            iArr = i + z;
            iArr3[z] = (((iArr2[iArr - 1] + (iArr2[iArr] << 1)) + iArr2[iArr + 1]) + 2) >> 2;
            z++;
        }
        if (z2) {
            while (z < true) {
                z2 = i + z;
                iArr3[z] = (((iArr2[z2 - 1] + (iArr2[z2] << 1)) + iArr2[z2 + true]) + 2) >> 2;
                z++;
            }
            i += 15;
            iArr3[15] = (((iArr2[i + 14] + (iArr2[i] << 1)) + iArr2[i]) + 2) >> 2;
            return;
        }
        i += 7;
        iArr3[7] = (((iArr2[i + 6] + (iArr2[i] << true)) + iArr2[i]) + 2) >> 2;
        for (z = true; z < true; z++) {
            iArr3[z] = iArr2[i];
        }
    }

    private static void interpolateLeft(boolean z, int[] iArr, int[] iArr2, int i, int[] iArr3) {
        iArr3[0] = ((((z ? iArr[i >> 2] : iArr2[0]) + (iArr2[i] << 1)) + iArr2[i + 1]) + 2) >> 2;
        for (z = true; z < true; z++) {
            iArr = i + z;
            iArr3[z] = (((iArr2[iArr - 1] + (iArr2[iArr] << 1)) + iArr2[iArr + 1]) + 2) >> 2;
        }
        i += 7;
        iArr3[7] = (((iArr2[i + 6] + (iArr2[i] << 1)) + iArr2[i]) + 2) >> 2;
    }

    private static int interpolateTopLeft(boolean z, boolean z2, int[] iArr, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        iArr = iArr[i3 >> 2];
        return ((((iArr << 1) + (z ? iArr2[i + i2] : iArr)) + (z2 ? iArr3[i3] : iArr)) + 2) >> 2;
    }

    public static void copyAdd(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2] = MathUtil.clip(iArr2[i2] + iArr[i], 0, 255);
        int i3 = i2 + 1;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 1], 0, 255);
        i3 = i2 + 2;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 2], 0, 255);
        i3 = i2 + 3;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 3], 0, 255);
        i3 = i2 + 4;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 4], 0, 255);
        i3 = i2 + 5;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 5], 0, 255);
        i3 = i2 + 6;
        iArr2[i3] = MathUtil.clip(iArr2[i3] + iArr[i + 6], 0, 255);
        i2 += 7;
        iArr2[i2] = MathUtil.clip(iArr2[i2] + iArr[i + 7], 0, 255);
    }

    public static void fillAdd(int[] iArr, int i, int i2) {
        int i3 = i;
        i = 0;
        while (i < 8) {
            iArr[i3] = MathUtil.clip(iArr[i3] + i2, 0, 255);
            int i4 = i3 + 1;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 2;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 3;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 4;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 5;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 6;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i4 = i3 + 7;
            iArr[i4] = MathUtil.clip(iArr[i4] + i2, 0, 255);
            i++;
            i3 += 16;
        }
    }

    private static void predictVertical(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        interpolateTop(z, z2, iArr2, iArr3, i + i2, i3, topBuf);
        iArr3 = (i3 << 4) + i2;
        z2 = false;
        while (z2 < true) {
            iArr[iArr3] = MathUtil.clip(iArr[iArr3] + topBuf[0], 0, 255);
            i = iArr3 + 1;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[1], 0, 255);
            i = iArr3 + 2;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[2], 0, 255);
            i = iArr3 + 3;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[3], 0, 255);
            i = iArr3 + 4;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[true], 0, 255);
            i = iArr3 + 5;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[5], 0, 255);
            i = iArr3 + 6;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[6], 0, 255);
            i = iArr3 + 7;
            iArr[i] = MathUtil.clip(iArr[i] + topBuf[7], 0, 255);
            z2++;
            iArr3 += 16;
        }
    }

    private static void predictHorizontal(int[] iArr, boolean z, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        interpolateLeft(z, iArr2, iArr3, i3, leftBuf);
        iArr3 = (i3 << 4) + i2;
        z = false;
        while (z < true) {
            iArr[iArr3] = MathUtil.clip(iArr[iArr3] + leftBuf[z], 0, 255);
            i = iArr3 + 1;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 2;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 3;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 4;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 5;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 6;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            i = iArr3 + 7;
            iArr[i] = MathUtil.clip(iArr[i] + leftBuf[z], 0, 255);
            z++;
            iArr3 += 16;
        }
    }

    private static void predictDC(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int[] iArr5 = iArr;
        boolean z5 = z;
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        int i4 = i3;
        if (z4 && z3) {
            interpolateTop(z5, z2, iArr6, iArr4, i + i2, i4, topBuf);
            interpolateLeft(z5, iArr6, iArr7, i4, leftBuf);
            int i5 = ((leftBuf[0] + leftBuf[1]) + leftBuf[2]) + leftBuf[3];
            int i6 = ((leftBuf[4] + leftBuf[5]) + leftBuf[6]) + leftBuf[7];
            fillAdd(iArr5, (i4 << 4) + i2, (((((((topBuf[0] + topBuf[1]) + topBuf[2]) + topBuf[3]) + (((topBuf[4] + topBuf[5]) + topBuf[6]) + topBuf[7])) + i5) + i6) + 8) >> 4);
        } else if (z3) {
            interpolateLeft(z5, iArr6, iArr7, i4, leftBuf);
            fillAdd(iArr5, (i4 << 4) + i2, (((((leftBuf[0] + leftBuf[1]) + leftBuf[2]) + leftBuf[3]) + (((leftBuf[4] + leftBuf[5]) + leftBuf[6]) + leftBuf[7])) + 4) >> 3);
        } else if (z4) {
            interpolateTop(z5, z2, iArr6, iArr4, i + i2, i4, topBuf);
            fillAdd(iArr5, (i4 << 4) + i2, (((((topBuf[0] + topBuf[1]) + topBuf[2]) + topBuf[3]) + (((topBuf[4] + topBuf[5]) + topBuf[6]) + topBuf[7])) + 4) >> 3);
        } else {
            fillAdd(iArr5, (i4 << 4) + i2, 128);
        }
    }

    private static void predictDiagonalDownLeft(int[] iArr, boolean z, boolean z2, boolean z3, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        int[] iArr4 = iArr;
        interpolateTop(z, z3, iArr2, iArr3, i + i2, i3, topBuf);
        genBuf[0] = (((topBuf[0] + topBuf[2]) + (topBuf[1] << 1)) + 2) >> 2;
        genBuf[1] = (((topBuf[1] + topBuf[3]) + (topBuf[2] << 1)) + 2) >> 2;
        genBuf[2] = (((topBuf[2] + topBuf[4]) + (topBuf[3] << 1)) + 2) >> 2;
        genBuf[3] = (((topBuf[3] + topBuf[5]) + (topBuf[4] << 1)) + 2) >> 2;
        genBuf[4] = (((topBuf[4] + topBuf[6]) + (topBuf[5] << 1)) + 2) >> 2;
        genBuf[5] = (((topBuf[5] + topBuf[7]) + (topBuf[6] << 1)) + 2) >> 2;
        genBuf[6] = (((topBuf[6] + topBuf[8]) + (topBuf[7] << 1)) + 2) >> 2;
        genBuf[7] = (((topBuf[7] + topBuf[9]) + (topBuf[8] << 1)) + 2) >> 2;
        genBuf[8] = (((topBuf[8] + topBuf[10]) + (topBuf[9] << 1)) + 2) >> 2;
        genBuf[9] = (((topBuf[9] + topBuf[11]) + (topBuf[10] << 1)) + 2) >> 2;
        genBuf[10] = (((topBuf[10] + topBuf[12]) + (topBuf[11] << 1)) + 2) >> 2;
        genBuf[11] = (((topBuf[11] + topBuf[13]) + (topBuf[12] << 1)) + 2) >> 2;
        genBuf[12] = (((topBuf[12] + topBuf[14]) + (topBuf[13] << 1)) + 2) >> 2;
        genBuf[13] = (((topBuf[13] + topBuf[15]) + (topBuf[14] << 1)) + 2) >> 2;
        genBuf[14] = (((topBuf[14] + topBuf[15]) + (topBuf[15] << 1)) + 2) >> 2;
        int i4 = (i3 << 4) + i2;
        copyAdd(genBuf, 0, iArr4, i4);
        copyAdd(genBuf, 1, iArr4, i4 + 16);
        copyAdd(genBuf, 2, iArr4, i4 + 32);
        copyAdd(genBuf, 3, iArr4, i4 + 48);
        copyAdd(genBuf, 4, iArr4, i4 + 64);
        copyAdd(genBuf, 5, iArr4, i4 + 80);
        copyAdd(genBuf, 6, iArr4, i4 + 96);
        copyAdd(genBuf, 7, iArr4, i4 + 112);
    }

    private static void predictDiagonalDownRight(int[] iArr, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int[] iArr5 = iArr;
        int i4 = i3;
        interpolateTop(true, z, iArr2, iArr4, i + i2, i4, topBuf);
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        interpolateLeft(true, iArr6, iArr7, i4, leftBuf);
        int i5 = i4;
        int interpolateTopLeft = interpolateTopLeft(true, true, iArr6, iArr4, iArr7, i, i2, i4);
        genBuf[0] = (((leftBuf[7] + leftBuf[5]) + (leftBuf[6] << 1)) + 2) >> 2;
        genBuf[1] = (((leftBuf[6] + leftBuf[4]) + (leftBuf[5] << 1)) + 2) >> 2;
        genBuf[2] = (((leftBuf[5] + leftBuf[3]) + (leftBuf[4] << 1)) + 2) >> 2;
        genBuf[3] = (((leftBuf[4] + leftBuf[2]) + (leftBuf[3] << 1)) + 2) >> 2;
        genBuf[4] = (((leftBuf[3] + leftBuf[1]) + (leftBuf[2] << 1)) + 2) >> 2;
        genBuf[5] = (((leftBuf[2] + leftBuf[0]) + (leftBuf[1] << 1)) + 2) >> 2;
        genBuf[6] = (((leftBuf[1] + interpolateTopLeft) + (leftBuf[0] << 1)) + 2) >> 2;
        genBuf[7] = (((leftBuf[0] + topBuf[0]) + (interpolateTopLeft << 1)) + 2) >> 2;
        genBuf[8] = (((interpolateTopLeft + topBuf[1]) + (topBuf[0] << 1)) + 2) >> 2;
        genBuf[9] = (((topBuf[0] + topBuf[2]) + (topBuf[1] << 1)) + 2) >> 2;
        genBuf[10] = (((topBuf[1] + topBuf[3]) + (topBuf[2] << 1)) + 2) >> 2;
        genBuf[11] = (((topBuf[2] + topBuf[4]) + (topBuf[3] << 1)) + 2) >> 2;
        genBuf[12] = (((topBuf[3] + topBuf[5]) + (topBuf[4] << 1)) + 2) >> 2;
        genBuf[13] = (((topBuf[4] + topBuf[6]) + (topBuf[5] << 1)) + 2) >> 2;
        genBuf[14] = (((topBuf[5] + topBuf[7]) + (topBuf[6] << 1)) + 2) >> 2;
        interpolateTopLeft = (i5 << 4) + i2;
        copyAdd(genBuf, 7, iArr5, interpolateTopLeft);
        copyAdd(genBuf, 6, iArr5, interpolateTopLeft + 16);
        copyAdd(genBuf, 5, iArr5, interpolateTopLeft + 32);
        copyAdd(genBuf, 4, iArr5, interpolateTopLeft + 48);
        copyAdd(genBuf, 3, iArr5, interpolateTopLeft + 64);
        copyAdd(genBuf, 2, iArr5, interpolateTopLeft + 80);
        copyAdd(genBuf, 1, iArr5, interpolateTopLeft + 96);
        copyAdd(genBuf, 0, iArr5, interpolateTopLeft + 112);
    }

    private static void predictVerticalRight(int[] iArr, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int[] iArr5 = iArr;
        int i4 = i3;
        interpolateTop(true, z, iArr2, iArr4, i + i2, i4, topBuf);
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        interpolateLeft(true, iArr6, iArr7, i4, leftBuf);
        int i5 = i4;
        int interpolateTopLeft = interpolateTopLeft(true, true, iArr6, iArr4, iArr7, i, i2, i4);
        genBuf[0] = (((leftBuf[5] + leftBuf[3]) + (leftBuf[4] << 1)) + 2) >> 2;
        genBuf[1] = (((leftBuf[3] + leftBuf[1]) + (leftBuf[2] << 1)) + 2) >> 2;
        genBuf[2] = (((leftBuf[1] + interpolateTopLeft) + (leftBuf[0] << 1)) + 2) >> 2;
        genBuf[3] = ((topBuf[0] + interpolateTopLeft) + 1) >> 1;
        genBuf[4] = ((topBuf[0] + topBuf[1]) + 1) >> 1;
        genBuf[5] = ((topBuf[1] + topBuf[2]) + 1) >> 1;
        genBuf[6] = ((topBuf[2] + topBuf[3]) + 1) >> 1;
        genBuf[7] = ((topBuf[3] + topBuf[4]) + 1) >> 1;
        genBuf[8] = ((topBuf[4] + topBuf[5]) + 1) >> 1;
        genBuf[9] = ((topBuf[5] + topBuf[6]) + 1) >> 1;
        genBuf[10] = ((topBuf[6] + topBuf[7]) + 1) >> 1;
        genBuf[11] = (((leftBuf[6] + leftBuf[4]) + (leftBuf[5] << 1)) + 2) >> 2;
        genBuf[12] = (((leftBuf[4] + leftBuf[2]) + (leftBuf[3] << 1)) + 2) >> 2;
        genBuf[13] = (((leftBuf[2] + leftBuf[0]) + (leftBuf[1] << 1)) + 2) >> 2;
        genBuf[14] = (((leftBuf[0] + topBuf[0]) + (interpolateTopLeft << 1)) + 2) >> 2;
        genBuf[15] = (((interpolateTopLeft + topBuf[1]) + (topBuf[0] << 1)) + 2) >> 2;
        genBuf[16] = (((topBuf[0] + topBuf[2]) + (topBuf[1] << 1)) + 2) >> 2;
        genBuf[17] = (((topBuf[1] + topBuf[3]) + (topBuf[2] << 1)) + 2) >> 2;
        genBuf[18] = (((topBuf[2] + topBuf[4]) + (topBuf[3] << 1)) + 2) >> 2;
        genBuf[19] = (((topBuf[3] + topBuf[5]) + (topBuf[4] << 1)) + 2) >> 2;
        genBuf[20] = (((topBuf[4] + topBuf[6]) + (topBuf[5] << 1)) + 2) >> 2;
        genBuf[21] = (((topBuf[5] + topBuf[7]) + (topBuf[6] << 1)) + 2) >> 2;
        interpolateTopLeft = (i5 << 4) + i2;
        copyAdd(genBuf, 3, iArr5, interpolateTopLeft);
        copyAdd(genBuf, 14, iArr5, interpolateTopLeft + 16);
        copyAdd(genBuf, 2, iArr5, interpolateTopLeft + 32);
        copyAdd(genBuf, 13, iArr5, interpolateTopLeft + 48);
        copyAdd(genBuf, 1, iArr5, interpolateTopLeft + 64);
        copyAdd(genBuf, 12, iArr5, interpolateTopLeft + 80);
        copyAdd(genBuf, 0, iArr5, interpolateTopLeft + 96);
        copyAdd(genBuf, 11, iArr5, interpolateTopLeft + 112);
    }

    private static void predictHorizontalDown(int[] iArr, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, int i, int i2, int i3) {
        int[] iArr5 = iArr;
        int i4 = i3;
        interpolateTop(true, z, iArr2, iArr4, i + i2, i4, topBuf);
        int[] iArr6 = iArr2;
        int[] iArr7 = iArr3;
        interpolateLeft(true, iArr6, iArr7, i4, leftBuf);
        int i5 = i4;
        int interpolateTopLeft = interpolateTopLeft(true, true, iArr6, iArr4, iArr7, i, i2, i4);
        genBuf[0] = ((leftBuf[7] + leftBuf[6]) + 1) >> 1;
        genBuf[1] = (((leftBuf[5] + leftBuf[7]) + (leftBuf[6] << 1)) + 2) >> 2;
        genBuf[2] = ((leftBuf[6] + leftBuf[5]) + 1) >> 1;
        genBuf[3] = (((leftBuf[4] + leftBuf[6]) + (leftBuf[5] << 1)) + 2) >> 2;
        genBuf[4] = ((leftBuf[5] + leftBuf[4]) + 1) >> 1;
        genBuf[5] = (((leftBuf[3] + leftBuf[5]) + (leftBuf[4] << 1)) + 2) >> 2;
        genBuf[6] = ((leftBuf[4] + leftBuf[3]) + 1) >> 1;
        genBuf[7] = (((leftBuf[2] + leftBuf[4]) + (leftBuf[3] << 1)) + 2) >> 2;
        genBuf[8] = ((leftBuf[3] + leftBuf[2]) + 1) >> 1;
        genBuf[9] = (((leftBuf[1] + leftBuf[3]) + (leftBuf[2] << 1)) + 2) >> 2;
        genBuf[10] = ((leftBuf[2] + leftBuf[1]) + 1) >> 1;
        genBuf[11] = (((leftBuf[0] + leftBuf[2]) + (leftBuf[1] << 1)) + 2) >> 2;
        genBuf[12] = ((leftBuf[1] + leftBuf[0]) + 1) >> 1;
        genBuf[13] = (((leftBuf[1] + interpolateTopLeft) + (leftBuf[0] << 1)) + 2) >> 2;
        genBuf[14] = ((leftBuf[0] + interpolateTopLeft) + 1) >> 1;
        genBuf[15] = (((leftBuf[0] + topBuf[0]) + (interpolateTopLeft << 1)) + 2) >> 2;
        genBuf[16] = (((interpolateTopLeft + topBuf[1]) + (topBuf[0] << 1)) + 2) >> 2;
        genBuf[17] = (((topBuf[0] + topBuf[2]) + (topBuf[1] << 1)) + 2) >> 2;
        genBuf[18] = (((topBuf[1] + topBuf[3]) + (topBuf[2] << 1)) + 2) >> 2;
        genBuf[19] = (((topBuf[2] + topBuf[4]) + (topBuf[3] << 1)) + 2) >> 2;
        genBuf[20] = (((topBuf[3] + topBuf[5]) + (topBuf[4] << 1)) + 2) >> 2;
        genBuf[21] = (((topBuf[4] + topBuf[6]) + (topBuf[5] << 1)) + 2) >> 2;
        interpolateTopLeft = (i5 << 4) + i2;
        copyAdd(genBuf, 14, iArr5, interpolateTopLeft);
        copyAdd(genBuf, 12, iArr5, interpolateTopLeft + 16);
        copyAdd(genBuf, 10, iArr5, interpolateTopLeft + 32);
        copyAdd(genBuf, 8, iArr5, interpolateTopLeft + 48);
        copyAdd(genBuf, 6, iArr5, interpolateTopLeft + 64);
        copyAdd(genBuf, 4, iArr5, interpolateTopLeft + 80);
        copyAdd(genBuf, 2, iArr5, interpolateTopLeft + 96);
        copyAdd(genBuf, 0, iArr5, interpolateTopLeft + 112);
    }

    private static void predictVerticalLeft(int[] iArr, boolean z, boolean z2, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        int[] iArr4 = iArr;
        interpolateTop(z, z2, iArr2, iArr3, i + i2, i3, topBuf);
        genBuf[0] = ((topBuf[0] + topBuf[1]) + 1) >> 1;
        genBuf[1] = ((topBuf[1] + topBuf[2]) + 1) >> 1;
        genBuf[2] = ((topBuf[2] + topBuf[3]) + 1) >> 1;
        genBuf[3] = ((topBuf[3] + topBuf[4]) + 1) >> 1;
        genBuf[4] = ((topBuf[4] + topBuf[5]) + 1) >> 1;
        genBuf[5] = ((topBuf[5] + topBuf[6]) + 1) >> 1;
        genBuf[6] = ((topBuf[6] + topBuf[7]) + 1) >> 1;
        genBuf[7] = ((topBuf[7] + topBuf[8]) + 1) >> 1;
        genBuf[8] = ((topBuf[8] + topBuf[9]) + 1) >> 1;
        genBuf[9] = ((topBuf[9] + topBuf[10]) + 1) >> 1;
        genBuf[10] = ((topBuf[10] + topBuf[11]) + 1) >> 1;
        genBuf[11] = (((topBuf[0] + topBuf[2]) + (topBuf[1] << 1)) + 2) >> 2;
        genBuf[12] = (((topBuf[1] + topBuf[3]) + (topBuf[2] << 1)) + 2) >> 2;
        genBuf[13] = (((topBuf[2] + topBuf[4]) + (topBuf[3] << 1)) + 2) >> 2;
        genBuf[14] = (((topBuf[3] + topBuf[5]) + (topBuf[4] << 1)) + 2) >> 2;
        genBuf[15] = (((topBuf[4] + topBuf[6]) + (topBuf[5] << 1)) + 2) >> 2;
        genBuf[16] = (((topBuf[5] + topBuf[7]) + (topBuf[6] << 1)) + 2) >> 2;
        genBuf[17] = (((topBuf[6] + topBuf[8]) + (topBuf[7] << 1)) + 2) >> 2;
        genBuf[18] = (((topBuf[7] + topBuf[9]) + (topBuf[8] << 1)) + 2) >> 2;
        genBuf[19] = (((topBuf[8] + topBuf[10]) + (topBuf[9] << 1)) + 2) >> 2;
        genBuf[20] = (((topBuf[9] + topBuf[11]) + (topBuf[10] << 1)) + 2) >> 2;
        genBuf[21] = (((topBuf[10] + topBuf[12]) + (topBuf[11] << 1)) + 2) >> 2;
        int i4 = (i3 << 4) + i2;
        copyAdd(genBuf, 0, iArr4, i4);
        copyAdd(genBuf, 11, iArr4, i4 + 16);
        copyAdd(genBuf, 1, iArr4, i4 + 32);
        copyAdd(genBuf, 12, iArr4, i4 + 48);
        copyAdd(genBuf, 2, iArr4, i4 + 64);
        copyAdd(genBuf, 13, iArr4, i4 + 80);
        copyAdd(genBuf, 3, iArr4, i4 + 96);
        copyAdd(genBuf, 14, iArr4, i4 + 112);
    }

    private static void predictHorizontalUp(int[] iArr, boolean z, int[] iArr2, int[] iArr3, int i, int i2, int i3) {
        int[] iArr4 = iArr;
        int i4 = i3;
        interpolateLeft(z, iArr2, iArr3, i4, leftBuf);
        genBuf[0] = ((leftBuf[0] + leftBuf[1]) + 1) >> 1;
        genBuf[1] = (((leftBuf[2] + leftBuf[0]) + (leftBuf[1] << 1)) + 2) >> 2;
        genBuf[2] = ((leftBuf[1] + leftBuf[2]) + 1) >> 1;
        genBuf[3] = (((leftBuf[3] + leftBuf[1]) + (leftBuf[2] << 1)) + 2) >> 2;
        genBuf[4] = ((leftBuf[2] + leftBuf[3]) + 1) >> 1;
        genBuf[5] = (((leftBuf[4] + leftBuf[2]) + (leftBuf[3] << 1)) + 2) >> 2;
        genBuf[6] = ((leftBuf[3] + leftBuf[4]) + 1) >> 1;
        genBuf[7] = (((leftBuf[5] + leftBuf[3]) + (leftBuf[4] << 1)) + 2) >> 2;
        genBuf[8] = ((leftBuf[4] + leftBuf[5]) + 1) >> 1;
        genBuf[9] = (((leftBuf[6] + leftBuf[4]) + (leftBuf[5] << 1)) + 2) >> 2;
        genBuf[10] = ((leftBuf[5] + leftBuf[6]) + 1) >> 1;
        genBuf[11] = (((leftBuf[7] + leftBuf[5]) + (leftBuf[6] << 1)) + 2) >> 2;
        genBuf[12] = ((leftBuf[6] + leftBuf[7]) + 1) >> 1;
        genBuf[13] = (((leftBuf[6] + leftBuf[7]) + (leftBuf[7] << 1)) + 2) >> 2;
        int[] iArr5 = genBuf;
        int[] iArr6 = genBuf;
        int[] iArr7 = genBuf;
        int[] iArr8 = genBuf;
        int[] iArr9 = genBuf;
        int[] iArr10 = genBuf;
        int[] iArr11 = genBuf;
        int[] iArr12 = genBuf;
        int i5 = leftBuf[7];
        iArr12[21] = i5;
        iArr11[20] = i5;
        iArr10[19] = i5;
        iArr9[18] = i5;
        iArr8[17] = i5;
        iArr7[16] = i5;
        iArr6[15] = i5;
        iArr5[14] = i5;
        i4 = (i4 << 4) + i2;
        copyAdd(genBuf, 0, iArr4, i4);
        copyAdd(genBuf, 2, iArr4, i4 + 16);
        copyAdd(genBuf, 4, iArr4, i4 + 32);
        copyAdd(genBuf, 6, iArr4, i4 + 48);
        copyAdd(genBuf, 8, iArr4, i4 + 64);
        copyAdd(genBuf, 10, iArr4, i4 + 80);
        copyAdd(genBuf, 12, iArr4, i4 + 96);
        copyAdd(genBuf, 14, iArr4, i4 + 112);
    }
}
