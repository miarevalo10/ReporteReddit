package org.jcodec.common.model;

public class Plane {
    int[] data;
    Size size;

    public Plane(int[] iArr, Size size) {
        this.data = iArr;
        this.size = size;
    }

    public int[] getData() {
        return this.data;
    }

    public Size getSize() {
        return this.size;
    }
}
