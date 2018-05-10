package org.jcodec.scale;

import org.jcodec.common.model.Picture;

public class Yuv420pToYuv422p implements Transform {
    private int shiftDown;
    private int shiftUp;

    public Yuv420pToYuv422p(int i, int i2) {
        this.shiftUp = i;
        this.shiftDown = i2;
    }

    public void transform(Picture picture, Picture picture2) {
        Picture picture3 = picture;
        Picture picture4 = picture2;
        copy(picture3.getPlaneData(0), picture4.getPlaneData(0), picture.getWidth(), picture2.getWidth(), picture2.getHeight(), this.shiftUp, this.shiftDown);
        copy(picture3.getPlaneData(1), picture4.getPlaneData(1), 0, 0, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight(), this.shiftUp, this.shiftDown);
        copy(picture3.getPlaneData(1), picture4.getPlaneData(1), 0, 1, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight(), this.shiftUp, this.shiftDown);
        copy(picture3.getPlaneData(2), picture4.getPlaneData(2), 0, 0, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight(), this.shiftUp, this.shiftDown);
        copy(picture3.getPlaneData(2), picture4.getPlaneData(2), 0, 1, 1, 2, picture.getWidth() >> 1, picture2.getWidth() >> 1, picture.getHeight() >> 1, picture2.getHeight(), this.shiftUp, this.shiftDown);
    }

    private static final void copy(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        i9 = i + (i2 * i6);
        i = 0;
        i10 = i;
        while (i < i7) {
            int i11;
            int i12 = i10;
            i10 = i9;
            i9 = 0;
            while (i9 < i5) {
                i11 = i12 + 1;
                iArr2[i10] = (iArr[i12] & 255) << 2;
                i10 += i3;
                i9++;
                i12 = i11;
            }
            i9 = i10 - i3;
            i11 = i5 * i3;
            while (i11 < i6) {
                iArr2[i10] = iArr2[i9];
                i10 += i3;
                i11 += i3;
            }
            i9 = ((i4 - 1) * i6) + i10;
            i++;
            i10 = i12;
        }
        iArr = i9 - (i4 * i6);
        i7 *= i4;
        while (i7 < i8) {
            i = 0;
            while (i < i6) {
                iArr2[i9] = iArr2[iArr + i];
                i9 += i3;
                i += i3;
            }
            i9 += (i4 - 1) * i6;
            i7 += i4;
        }
    }

    private static void copy(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        i5 = iArr.length / i;
        int i6 = 0;
        int i7 = i6;
        int i8 = i7;
        while (i6 < i5) {
            int i9 = i8;
            i8 = i7;
            i7 = 0;
            while (i7 < i) {
                int i10 = i8 + 1;
                int i11 = i9 + 1;
                iArr2[i8] = (iArr[i9] & 255) << 2;
                i7++;
                i8 = i10;
                i9 = i11;
            }
            i7 = i;
            while (i7 < i2) {
                i10 = i8 + 1;
                iArr2[i8] = iArr2[i - 1];
                i7++;
                i8 = i10;
            }
            i6++;
            i7 = i8;
            i8 = i9;
        }
        iArr = (i5 - 1) * i2;
        while (i5 < i3) {
            i = 0;
            while (i < i2) {
                i6 = i7 + 1;
                iArr2[i7] = iArr2[iArr + i];
                i++;
                i7 = i6;
            }
            i5++;
        }
    }
}
