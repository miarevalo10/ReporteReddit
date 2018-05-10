package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv422pToYuv420j implements Transform {
    public static int COEFF = 9362;
    private int halfDst;
    private int halfSrc;
    private int shift;

    public Yuv422pToYuv420j(int i, int i2) {
        int i3 = i2 + 13;
        this.shift = i3 - i;
        if (this.shift < 0) {
            i2 = new StringBuilder("Maximum upshift allowed: ");
            i2.append(i3);
            throw new IllegalArgumentException(i2.toString());
        }
        this.halfSrc = 128 << Math.max(i2 - i, 0);
        this.halfDst = 128 << Math.max(i - i2, 0);
    }

    public void transform(Picture picture, Picture picture2) {
        int[] planeData = picture.getPlaneData(0);
        int[] planeData2 = picture2.getPlaneData(0);
        for (int i = 0; i < picture.getPlaneWidth(0) * picture.getPlaneHeight(0); i++) {
            planeData2[i] = ((planeData[i] - 16) * COEFF) >> this.shift;
        }
        copyAvg(picture.getPlaneData(1), picture2.getPlaneData(1), picture.getPlaneWidth(1), picture.getPlaneHeight(1));
        copyAvg(picture.getPlaneData(2), picture2.getPlaneData(2), picture.getPlaneWidth(2), picture.getPlaneHeight(2));
    }

    private void copyAvg(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        while (i3 < i2 / 2) {
            int i6 = i5;
            i5 = i4;
            i4 = 0;
            while (i4 < i) {
                iArr2[i6] = ((((((iArr[i5] - this.halfSrc) * COEFF) >> this.shift) + this.halfDst) + ((((iArr[i5 + i] - this.halfSrc) * COEFF) >> this.shift) + this.halfDst)) + 1) >> 1;
                i4++;
                i6++;
                i5++;
            }
            i4 = i5 + i;
            i3++;
            i5 = i6;
        }
    }
}
