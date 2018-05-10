package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv444jToRgb implements Transform {
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
            i2 = 0;
            while (i2 < picture2.getWidth()) {
                Yuv420jToRgb.YUVJtoRGB(planeData[i3], planeData2[i3], picture[i3], planeData3, i4);
                i2++;
                i3++;
                i4 += 3;
            }
            i++;
            i2 = i3;
            i3 = i4;
        }
    }
}
