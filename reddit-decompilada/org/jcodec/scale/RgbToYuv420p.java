package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class RgbToYuv420p implements Transform {
    private int downShift;
    private int downShiftChr;
    private int upShift;

    private static final int clip(int i) {
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    public RgbToYuv420p(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
        this.downShiftChr = i2 + 2;
    }

    public void transform(Picture picture, Picture picture2) {
        RgbToYuv420p rgbToYuv420p = this;
        int[] iArr = picture.getData()[0];
        int[][] data = picture2.getData();
        int width = picture.getWidth() * 3;
        int width2 = picture2.getWidth();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        int i4 = i3;
        while (i < (picture.getHeight() >> 1)) {
            int i5 = i3;
            i3 = i2;
            for (i2 = 0; i2 < (picture.getWidth() >> 1); i2++) {
                data[1][i3] = 0;
                data[2][i3] = 0;
                int i6 = i3;
                int i7 = i3;
                rgb2yuv(iArr[i4], iArr[i4 + 1], iArr[i4 + 2], data[0], i5, data[1], i6, data[2], i7);
                data[0][i5] = (data[0][i5] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShift;
                int i8 = i4 + width;
                int i9 = i5 + width2;
                rgb2yuv(iArr[i8], iArr[i8 + 1], iArr[i8 + 2], data[0], i9, data[1], i6, data[2], i7);
                data[0][i9] = (data[0][i9] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShift;
                i5++;
                rgb2yuv(iArr[i4 + 3], iArr[i4 + 4], iArr[i4 + 5], data[0], i5, data[1], i6, data[2], i7);
                data[0][i5] = (data[0][i5] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShift;
                i8 = i5 + width2;
                rgb2yuv(iArr[i8 + 3], iArr[i8 + 4], iArr[i8 + 5], data[0], i8, data[1], i6, data[2], i7);
                data[0][i8] = (data[0][i8] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShift;
                i5++;
                data[1][i3] = (data[1][i3] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShiftChr;
                data[2][i3] = (data[2][i3] << rgbToYuv420p.upShift) >> rgbToYuv420p.downShiftChr;
                i3++;
                i4 += 6;
            }
            i4 += width;
            i++;
            int i10 = i3;
            i3 = i5 + width2;
            i2 = i10;
        }
    }

    public static final void rgb2yuv(int i, int i2, int i3, int[] iArr, int i4, int[] iArr2, int i5, int[] iArr3, int i6) {
        int i7 = ((66 * i) + (129 * i2)) + (25 * i3);
        int i8 = ((112 * i) - (94 * i2)) - (18 * i3);
        i2 = ((((-38 * i) - (74 * i2)) + (112 * i3)) + 128) >> 8;
        i3 = (i8 + 128) >> 8;
        iArr[i4] = clip(((i7 + 128) >> 8) + 16);
        iArr2[i5] = iArr2[i5] + clip(i2 + 128);
        iArr3[i6] = iArr3[i6] + clip(i3 + 128);
    }
}
