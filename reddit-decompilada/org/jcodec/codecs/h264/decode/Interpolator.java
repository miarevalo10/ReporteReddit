package org.jcodec.codecs.h264.decode;

import com.google.android.gms.ads.AdRequest;

public class Interpolator {
    private static int PADDING = 16;

    private int roundAndClip1024(int i) {
        i = (i + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10;
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    private int roundAndClip32(int i) {
        i = (i + 16) >> 5;
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    public int[] interpolateChroma(int[] iArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 << 3;
        int[] iArr2 = new int[((i4 << 3) * i5)];
        int i6 = 0;
        while (i6 < i4) {
            int i7 = 0;
            while (i7 < i3) {
                for (int i8 = 0; i8 < 8; i8++) {
                    for (int i9 = 0; i9 < 8; i9++) {
                        int i10 = (i6 * i3) + i7;
                        int i11 = (i6 < i4 + -1 ? i3 : 0) + i10;
                        int i12 = (i7 < i3 + -1 ? 1 : 0) + i10;
                        int i13 = 8 - i9;
                        int i14 = 8 - i8;
                        iArr2[((((i6 << 3) + i8) * i5) + (i7 << 3)) + i9] = ((((((i13 * i14) * iArr[i10]) + ((i14 * i9) * iArr[i12])) + ((i13 * i8) * iArr[i11])) + ((i9 * i8) * iArr[(i12 + i11) - i10])) + 32) >> 6;
                    }
                }
                i7++;
            }
            i6++;
        }
        return iArr2;
    }

    public int[] interpolateLuma(int[] iArr, int i, int i2) {
        int i3 = ((PADDING * 2) + i) * 4;
        int i4 = ((PADDING * 2) + i2) * 4;
        int[] iArr2 = new int[(i3 * i4)];
        fillFullPel(iArr, i, i2, iArr2);
        scanHPelHorizontalWithRound(i3, i4, iArr2);
        scanHPelVertical(i3, i4, iArr2);
        scanHPelCenterWidhRound(i3, i4, iArr2);
        roundHPelVertical(i3, i4, iArr2);
        scanQPel(i3, i4, iArr2);
        return iArr2;
    }

    protected void scanQPel(int i, int i2, int[] iArr) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = 0;
            while (i4 < i) {
                int i5 = (i3 * i) + i4;
                int i6 = i2 - 2;
                int i7 = i3 < i6 ? iArr[(2 * i) + i5] : iArr[i5];
                int i8 = i - 2;
                int i9 = i4 < i8 ? iArr[i5 + 2] : iArr[i5];
                if (i3 < i6 && i4 < i8) {
                    i6 = iArr[((2 * i) + i5) + 2];
                } else if (i3 < i6) {
                    i6 = iArr[(2 * i) + i5];
                } else if (i4 < i8) {
                    i6 = iArr[i5 + 2];
                } else {
                    i6 = iArr[i5];
                }
                int i10 = i5 + i;
                iArr[i10] = ((iArr[i5] + i7) + 1) >> 1;
                iArr[i5 + 1] = ((iArr[i5] + i9) + 1) >> 1;
                if (i4 % 4 == i3 % 4) {
                    iArr[i10 + 1] = ((i9 + i7) + 1) >> 1;
                } else {
                    iArr[i10 + 1] = ((iArr[i5] + i6) + 1) >> 1;
                }
                i4 += 2;
            }
            i3 += 2;
        }
    }

    protected void fillFullPel(int[] iArr, int i, int i2, int[] iArr2) {
        int i3;
        int i4;
        int i5 = ((PADDING * 2) + i) * 4;
        for (i3 = 0; i3 < i2; i3++) {
            int i6 = (PADDING + i3) * 4;
            for (i4 = 0; i4 < i; i4++) {
                iArr2[(i6 * i5) + ((PADDING + i4) * 4)] = iArr[(i3 * i) + i4];
            }
            for (i4 = 0; i4 < PADDING; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[i3 * i];
            }
            for (i4 = PADDING + i; i4 < (PADDING * 2) + i; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[((i3 * i) + i) - 1];
            }
        }
        for (i3 = 0; i3 < PADDING; i3++) {
            i6 = i3 * 4;
            for (i4 = 0; i4 < i; i4++) {
                iArr2[(i6 * i5) + ((PADDING + i4) * 4)] = iArr[i4];
            }
            for (i4 = 0; i4 < PADDING; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[0];
            }
            for (i4 = PADDING + i; i4 < (PADDING * 2) + i; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[i - 1];
            }
        }
        for (i3 = PADDING + i2; i3 < (PADDING * 2) + i2; i3++) {
            i6 = i3 * 4;
            for (i4 = 0; i4 < i; i4++) {
                iArr2[(i6 * i5) + ((PADDING + i4) * 4)] = iArr[((i2 - 1) * i) + i4];
            }
            for (i4 = 0; i4 < PADDING; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[(i2 - 1) * i];
            }
            for (i4 = PADDING + i; i4 < (PADDING * 2) + i; i4++) {
                iArr2[(i6 * i5) + (i4 * 4)] = iArr[(((i2 - 1) * i) + i) - 1];
            }
        }
    }

    protected void scanHPelVertical(int i, int i2, int[] iArr) {
        int i3 = i;
        int i4 = i2;
        for (int i5 = 0; i5 < i3; i5 += 4) {
            int i6 = iArr[i5];
            int i7 = iArr[i5];
            int i8 = iArr[i5];
            int i9 = iArr[(4 * i3) + i5];
            int i10 = iArr[(8 * i3) + i5];
            int i11 = iArr[(12 * i3) + i5];
            int i12 = i10;
            i10 = i9;
            i9 = i8;
            i8 = i7;
            i7 = i6;
            i6 = 0;
            while (i6 < i4) {
                iArr[((i6 + 2) * i3) + i5] = ((((i7 - (5 * i8)) + (20 * i9)) + (20 * i10)) - (5 * i12)) + i11;
                i7 = i6 + 16;
                i6 += 4;
                int i13 = i11;
                i11 = i7 < i4 ? iArr[(i7 * i3) + i5] : i11;
                i7 = i8;
                i8 = i9;
                i9 = i10;
                i10 = i12;
                i12 = i13;
            }
        }
    }

    protected void roundHPelVertical(int i, int i2, int[] iArr) {
        for (int i3 = 0; i3 < i; i3 += 4) {
            for (int i4 = 0; i4 < i2; i4 += 4) {
                int i5 = ((i4 + 2) * i) + i3;
                iArr[i5] = roundAndClip32(iArr[i5]);
            }
        }
    }

    protected void scanHPelHorizontalWithRound(int i, int i2, int[] iArr) {
        Interpolator interpolator;
        int i3 = i;
        int i4 = i2;
        for (int i5 = 0; i5 < i4; i5 += 4) {
            int i6 = i5 * i3;
            int i7 = iArr[i6];
            int i8 = iArr[i6];
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 4];
            int i11 = iArr[i6 + 8];
            int i12 = iArr[i6 + 12];
            int i13 = i11;
            i11 = i10;
            i10 = i9;
            i9 = i8;
            i8 = i7;
            i7 = 0;
            while (i7 < i3) {
                iArr[(i6 + i7) + 2] = roundAndClip32(((((i8 - (5 * i9)) + (20 * i10)) + (20 * i11)) - (5 * i13)) + i12);
                i8 = i7 + 16;
                i7 += 4;
                int i14 = i12;
                i12 = i8 < i3 ? iArr[i8 + i6] : i12;
                i8 = i9;
                i9 = i10;
                i10 = i11;
                i11 = i13;
                i13 = i14;
            }
            interpolator = this;
        }
        interpolator = this;
    }

    protected void scanHPelCenterWidhRound(int i, int i2, int[] iArr) {
        Interpolator interpolator;
        int i3 = i;
        int i4 = i2;
        for (int i5 = 0; i5 < i4; i5 += 4) {
            int i6 = (i5 + 2) * i3;
            int i7 = iArr[i6];
            int i8 = iArr[i6];
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 4];
            int i11 = iArr[i6 + 8];
            int i12 = iArr[i6 + 12];
            int i13 = i11;
            i11 = i10;
            i10 = i9;
            i9 = i8;
            i8 = i7;
            i7 = 0;
            while (i7 < i3) {
                iArr[(i6 + i7) + 2] = roundAndClip1024(((((i8 - (5 * i9)) + (20 * i10)) + (20 * i11)) - (5 * i13)) + i12);
                i8 = i7 + 16;
                i7 += 4;
                int i14 = i12;
                i12 = i8 < i3 ? iArr[i8 + i6] : i12;
                i8 = i9;
                i9 = i10;
                i10 = i11;
                i11 = i13;
                i13 = i14;
            }
            interpolator = this;
        }
        interpolator = this;
    }
}
