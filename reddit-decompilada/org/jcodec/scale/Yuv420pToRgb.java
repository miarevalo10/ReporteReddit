package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv420pToRgb implements Transform {
    private final int downShift;
    private final int upShift;

    public Yuv420pToRgb(int i, int i2) {
        this.upShift = i;
        this.downShift = i2;
    }

    public final void transform(Picture picture, Picture picture2) {
        Yuv420pToRgb yuv420pToRgb = this;
        Picture picture3 = picture;
        int i = 0;
        int[] planeData = picture3.getPlaneData(0);
        int i2 = 1;
        int[] planeData2 = picture3.getPlaneData(1);
        int[] planeData3 = picture3.getPlaneData(2);
        int[] planeData4 = picture2.getPlaneData(0);
        int width = picture2.getWidth();
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        while (i3 < (picture2.getHeight() >> i2)) {
            int i6;
            int i7 = i5;
            i5 = i;
            while (i5 < (picture2.getWidth() >> i2)) {
                int i8 = (i5 << 1) + i4;
                Yuv422pToRgb.YUV444toRGB888((planeData[i8] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i8 * 3);
                i = i8 + 1;
                i6 = i3;
                Yuv422pToRgb.YUV444toRGB888((planeData[i] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i * 3);
                i8 += width;
                Yuv422pToRgb.YUV444toRGB888((planeData[i8] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i8 * 3);
                i8++;
                Yuv422pToRgb.YUV444toRGB888((planeData[i8] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i8 * 3);
                i7++;
                i5++;
                i3 = i6;
                i2 = 1;
            }
            i6 = i3;
            if ((picture2.getWidth() & 1) != 0) {
                i = (picture2.getWidth() - 1) + i4;
                Yuv422pToRgb.YUV444toRGB888((planeData[i] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i * 3);
                i += width;
                Yuv422pToRgb.YUV444toRGB888((planeData[i] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i7] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i * 3);
                i7++;
            }
            i5 = i7;
            i4 += 2 * width;
            i3 = i6 + 1;
            int i9 = 2;
            i = 0;
            i2 = 1;
        }
        i2 = 1;
        if ((picture2.getHeight() & 1) != 0) {
            i = 0;
            while (i < (picture2.getWidth() >> i2)) {
                i2 = (i << 1) + i4;
                Yuv422pToRgb.YUV444toRGB888((planeData[i2] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i2 * 3);
                i2++;
                Yuv422pToRgb.YUV444toRGB888((planeData[i2] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i2 * 3);
                i5++;
                i++;
                i2 = 1;
            }
            if ((picture2.getWidth() & 1) != 0) {
                i4 += picture2.getWidth() - 1;
                Yuv422pToRgb.YUV444toRGB888((planeData[i4] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData2[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, (planeData3[i5] << yuv420pToRgb.upShift) >> yuv420pToRgb.downShift, planeData4, i4 * 3);
            }
        }
    }
}
