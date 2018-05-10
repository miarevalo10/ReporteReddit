package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv420jToYuv420 implements Transform {
    public static int Y_COEFF = 7168;

    public void transform(Picture picture, Picture picture2) {
        int i = 0;
        int[] planeData = picture.getPlaneData(0);
        int[] planeData2 = picture2.getPlaneData(0);
        for (int i2 = 0; i2 < picture.getPlaneWidth(0) * picture.getPlaneHeight(0); i2++) {
            planeData2[i2] = ((planeData[i2] * Y_COEFF) >> 13) + 16;
        }
        planeData2 = picture.getPlaneData(1);
        int[] planeData3 = picture2.getPlaneData(1);
        for (int i3 = 0; i3 < picture.getPlaneWidth(1) * picture.getPlaneHeight(1); i3++) {
            planeData3[i3] = (((planeData2[i3] - 128) * Y_COEFF) >> 13) + 128;
        }
        planeData2 = picture.getPlaneData(2);
        picture2 = picture2.getPlaneData(2);
        while (i < picture.getPlaneWidth(2) * picture.getPlaneHeight(2)) {
            picture2[i] = (((planeData2[i] - 128) * Y_COEFF) >> 13) + 128;
            i++;
        }
    }
}
