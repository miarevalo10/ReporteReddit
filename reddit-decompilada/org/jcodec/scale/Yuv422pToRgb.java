package org.jcodec.scale;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.model.Picture;

public class Yuv422pToRgb implements Transform {
    private int downShift;
    private int upShift;

    private static int crop(int i) {
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    public Yuv422pToRgb(int i, int i2) {
        this.downShift = i;
        this.upShift = i2;
    }

    public void transform(Picture picture, Picture picture2) {
        int[] planeData = picture.getPlaneData(0);
        int[] planeData2 = picture.getPlaneData(1);
        picture = picture.getPlaneData(2);
        int[] planeData3 = picture2.getPlaneData(0);
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < picture2.getHeight()) {
            int i4 = i3;
            i3 = i2;
            for (i2 = 0; i2 < picture2.getWidth(); i2 += 2) {
                YUV444toRGB888((planeData[i3] << this.upShift) >> this.downShift, (planeData2[i4] << this.upShift) >> this.downShift, (picture[i4] << this.upShift) >> this.downShift, planeData3, i3 * 3);
                int i5 = i3 + 1;
                YUV444toRGB888((planeData[i5] << this.upShift) >> this.downShift, (planeData2[i4] << this.upShift) >> this.downShift, (picture[i4] << this.upShift) >> this.downShift, planeData3, i5 * 3);
                i3 += 2;
                i4++;
            }
            i++;
            i2 = i3;
            i3 = i4;
        }
    }

    public static final void YUV444toRGB888(int i, int i2, int i3, int[] iArr, int i4) {
        i2 -= 128;
        i3 -= 128;
        int i5 = 298 * (i - 16);
        i = (((409 * i3) + i5) + 128) >> 8;
        i3 = (((i5 - (100 * i2)) - (JpegConst.RST0 * i3)) + 128) >> 8;
        iArr[i4] = crop(((i5 + (516 * i2)) + 128) >> 8);
        iArr[i4 + 1] = crop(i3);
        iArr[i4 + 2] = crop(i);
    }
}
