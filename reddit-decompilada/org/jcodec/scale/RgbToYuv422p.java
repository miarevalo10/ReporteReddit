package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class RgbToYuv422p implements Transform {
    private int downShift;
    private int downShiftChr;
    private int upShift;

    public RgbToYuv422p(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
        this.downShiftChr = i2 + 1;
    }

    public void transform(Picture picture, Picture picture2) {
        RgbToYuv422p rgbToYuv422p = this;
        int[] iArr = picture.getData()[0];
        int[][] data = picture2.getData();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < picture.getHeight()) {
            int i4 = i2;
            i2 = 0;
            while (i2 < (picture.getWidth() >> 1)) {
                data[1][i4] = 0;
                data[2][i4] = 0;
                int i5 = i4 << 1;
                int i6 = i3 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int i9 = i4;
                int i10 = i4;
                RgbToYuv420p.rgb2yuv(iArr[i3], iArr[i6], iArr[i7], data[0], i5, data[1], i9, data[2], i10);
                data[0][i5] = (data[0][i5] << rgbToYuv422p.upShift) >> rgbToYuv422p.downShift;
                i3 = i8 + 1;
                i6 = iArr[i8];
                i7 = i3 + 1;
                int i11 = iArr[i3];
                i8 = i7 + 1;
                i5++;
                i3 = i6;
                i6 = i11;
                RgbToYuv420p.rgb2yuv(i3, i6, iArr[i7], data[0], i5, data[1], i9, data[2], i10);
                data[0][i5] = (data[0][i5] << rgbToYuv422p.upShift) >> rgbToYuv422p.downShift;
                data[1][i4] = (data[1][i4] << rgbToYuv422p.upShift) >> rgbToYuv422p.downShiftChr;
                data[2][i4] = (data[2][i4] << rgbToYuv422p.upShift) >> rgbToYuv422p.downShiftChr;
                i4++;
                i2++;
                i3 = i8;
            }
            i++;
            i2 = i4;
        }
    }
}
