package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv422jToRgb implements Transform {
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
                Yuv420jToRgb.YUVJtoRGB(planeData[i3], planeData2[i4], picture[i4], planeData3, i3 * 3);
                int i5 = i3 + 1;
                Yuv420jToRgb.YUVJtoRGB(planeData[i5], planeData2[i4], picture[i4], planeData3, i5 * 3);
                i3 += 2;
                i4++;
            }
            i++;
            i2 = i3;
            i3 = i4;
        }
    }
}
