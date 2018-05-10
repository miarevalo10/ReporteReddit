package org.jcodec.common.model;

public class Picture {
    private ColorSpace color;
    private Rect crop;
    private int[][] data;
    private int height;
    private int width;

    public Picture(int i, int i2, int[][] iArr, ColorSpace colorSpace) {
        this(i, i2, iArr, colorSpace, new Rect(0, 0, i, i2));
    }

    public Picture(int i, int i2, int[][] iArr, ColorSpace colorSpace, Rect rect) {
        this.width = i;
        this.height = i2;
        this.data = iArr;
        this.color = colorSpace;
        this.crop = rect;
    }

    public Picture(Picture picture) {
        this(picture.width, picture.height, picture.data, picture.color, picture.crop);
    }

    public static Picture create(int i, int i2, ColorSpace colorSpace) {
        return create(i, i2, colorSpace, null);
    }

    public static Picture create(int i, int i2, ColorSpace colorSpace, Rect rect) {
        int i3;
        int i4;
        int[] iArr = new int[4];
        int i5 = 0;
        for (i3 = 0; i3 < colorSpace.nComp; i3++) {
            i4 = colorSpace.compPlane[i3];
            iArr[i4] = iArr[i4] + ((i >> colorSpace.compWidth[i3]) * (i2 >> colorSpace.compHeight[i3]));
        }
        i3 = 0;
        i4 = i3;
        while (i3 < 4) {
            i4 += iArr[i3] != 0 ? 1 : 0;
            i3++;
        }
        int[][] iArr2 = new int[i4][];
        i3 = 0;
        while (i5 < 4) {
            if (iArr[i5] != 0) {
                i4 = i3 + 1;
                iArr2[i3] = new int[iArr[i5]];
                i3 = i4;
            }
            i5++;
        }
        return new Picture(i, i2, iArr2, colorSpace, rect);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int[] getPlaneData(int i) {
        return this.data[i];
    }

    public ColorSpace getColor() {
        return this.color;
    }

    public int[][] getData() {
        return this.data;
    }

    public Rect getCrop() {
        return this.crop;
    }

    public int getPlaneWidth(int i) {
        return this.width >> this.color.compWidth[i];
    }

    public int getPlaneHeight(int i) {
        return this.height >> this.color.compHeight[i];
    }

    public boolean compatible(Picture picture) {
        return (picture.color == this.color && picture.width == this.width && picture.height == this.height) ? true : null;
    }

    public Picture createCompatible() {
        return create(this.width, this.height, this.color);
    }

    public void copyFrom(Picture picture) {
        if (compatible(picture)) {
            for (int i = 0; i < this.color.nComp; i++) {
                if (this.data[i] != null) {
                    System.arraycopy(picture.data[i], 0, this.data[i], 0, (this.width >> this.color.compWidth[i]) * (this.height >> this.color.compHeight[i]));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Can not copy to incompatible picture");
    }

    public Picture cropped() {
        if (this.crop != null) {
            if (this.crop.getX() != 0 || this.crop.getY() != 0 || this.crop.getWidth() != this.width || this.crop.getHeight() != this.height) {
                Picture create = create(this.crop.getWidth(), this.crop.getHeight(), this.color);
                for (int i = 0; i < this.color.nComp; i++) {
                    if (this.data[i] != null) {
                        cropSub(this.data[i], this.crop.getX() >> this.color.compWidth[i], this.crop.getY() >> this.color.compHeight[i], this.crop.getWidth() >> this.color.compWidth[i], this.crop.getHeight() >> this.color.compHeight[i], this.width >> this.color.compWidth[i], create.data[i]);
                    }
                }
                return create;
            }
        }
        return this;
    }

    private void cropSub(int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2) {
        int i6 = 0;
        int i7 = (i2 * i5) + i;
        for (i2 = i6; i2 < i4; i2++) {
            for (int i8 = 0; i8 < i3; i8++) {
                iArr2[i6 + i8] = iArr[i7 + i8];
            }
            i7 += i5;
            i6 += i3;
        }
    }

    public void setCrop(Rect rect) {
        this.crop = rect;
    }

    public int getCroppedWidth() {
        return this.crop == null ? this.width : this.crop.getWidth();
    }

    public int getCroppedHeight() {
        return this.crop == null ? this.height : this.crop.getHeight();
    }
}
