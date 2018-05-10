package org.jcodec.scale;

import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class Yuv420jToRgb implements Transform {
    private static final int FIX_0_71414 = FIX(0.71414d);
    private static final int FIX_1_402 = FIX(1.402d);
    private static final int FIX_1_772 = FIX(1.772d);
    private static final int ONE_HALF = 512;
    private static final int SCALEBITS = 10;
    private static final int _FIX_0_34414 = (-FIX(0.34414d));

    private static final int FIX(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    public final void transform(Picture picture, Picture picture2) {
        Picture picture3 = picture;
        int i = 0;
        int[] planeData = picture3.getPlaneData(0);
        int[] planeData2 = picture3.getPlaneData(1);
        int[] planeData3 = picture3.getPlaneData(2);
        int[] planeData4 = picture2.getPlaneData(0);
        int width = picture2.getWidth();
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (i2 < (picture2.getHeight() >> 1)) {
            int i5 = i4;
            for (i4 = i; i4 < (picture2.getWidth() >> 1); i4++) {
                int i6 = (i4 << 1) + i3;
                YUVJtoRGB(planeData[i6], planeData2[i5], planeData3[i5], planeData4, i6 * 3);
                i = i6 + 1;
                YUVJtoRGB(planeData[i], planeData2[i5], planeData3[i5], planeData4, i * 3);
                i6 += width;
                YUVJtoRGB(planeData[i6], planeData2[i5], planeData3[i5], planeData4, i6 * 3);
                i6++;
                YUVJtoRGB(planeData[i6], planeData2[i5], planeData3[i5], planeData4, i6 * 3);
                i5++;
            }
            if ((picture2.getWidth() & 1) != 0) {
                i = (picture2.getWidth() - 1) + i3;
                YUVJtoRGB(planeData[i], planeData2[i5], planeData3[i5], planeData4, i * 3);
                i += width;
                YUVJtoRGB(planeData[i], planeData2[i5], planeData3[i5], planeData4, i * 3);
                i5++;
            }
            i4 = i5;
            i3 += 2 * width;
            i2++;
            int i7 = 2;
            i = 0;
        }
        if ((picture2.getHeight() & 1) != 0) {
            for (i = 0; i < (picture2.getWidth() >> 1); i++) {
                i7 = (i << 1) + i3;
                YUVJtoRGB(planeData[i7], planeData2[i4], planeData3[i4], planeData4, i7 * 3);
                i7++;
                YUVJtoRGB(planeData[i7], planeData2[i4], planeData3[i4], planeData4, i7 * 3);
                i4++;
            }
            if ((picture2.getWidth() & 1) != 0) {
                i3 += picture2.getWidth() - 1;
                YUVJtoRGB(planeData[i3], planeData2[i4], planeData3[i4], planeData4, i3 * 3);
            }
        }
    }

    public static final void YUVJtoRGB(int i, int i2, int i3, int[] iArr, int i4) {
        i <<= 10;
        i2 -= 128;
        i3 -= 128;
        int i5 = ((_FIX_0_34414 * i2) - (FIX_0_71414 * i3)) + 512;
        i2 = (((FIX_1_402 * i3) + 512) + i) >> 10;
        int i6 = (i5 + i) >> 10;
        iArr[i4] = MathUtil.clip((i + ((FIX_1_772 * i2) + 512)) >> 10, 0, 255);
        iArr[i4 + 1] = MathUtil.clip(i6, 0, 255);
        iArr[i4 + 2] = MathUtil.clip(i2, 0, 255);
    }
}
