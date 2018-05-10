package org.jcodec.common.tools;

import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;

public class ImageOP {
    public static void subImageWithFill(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        i2 = Math.min(i2 - i6, i4);
        int min = Math.min(i - i5, i3);
        int i7 = 0;
        int i8 = (i6 * i) + i5;
        i6 = i7;
        while (i6 < i2) {
            int i9 = 0;
            while (i9 < min) {
                iArr2[i7 + i9] = iArr[i8 + i9];
                i9++;
            }
            int i10 = iArr2[i9 - 1];
            while (i9 < i3) {
                iArr2[i7 + i9] = i10;
                i9++;
            }
            i8 += i;
            i7 += i3;
            i6++;
        }
        iArr = i7 - i3;
        while (i6 < i4) {
            System.arraycopy(iArr2, iArr, iArr2, i7, i3);
            i7 += i3;
            i6++;
        }
    }

    public static void subImageWithFill(Picture picture, Picture picture2, Rect rect) {
        int width = picture.getWidth();
        int height = picture.getHeight();
        ColorSpace color = picture.getColor();
        picture = picture.getData();
        for (int i = 0; i < picture.length; i++) {
            subImageWithFill(picture[i], width >> color.compWidth[i], height >> color.compHeight[i], picture2.getPlaneData(i), rect.getWidth() >> color.compWidth[i], rect.getHeight() >> color.compHeight[i], rect.getX() >> color.compWidth[i], rect.getY() >> color.compHeight[i]);
        }
    }
}
