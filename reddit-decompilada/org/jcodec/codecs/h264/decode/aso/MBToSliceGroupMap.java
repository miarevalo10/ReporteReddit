package org.jcodec.codecs.h264.decode.aso;

public class MBToSliceGroupMap {
    private int[] groups;
    private int[] indices;
    private int[][] inverse;

    public MBToSliceGroupMap(int[] iArr, int[] iArr2, int[][] iArr3) {
        this.groups = iArr;
        this.indices = iArr2;
        this.inverse = iArr3;
    }

    public int[] getGroups() {
        return this.groups;
    }

    public int[] getIndices() {
        return this.indices;
    }

    public int[][] getInverse() {
        return this.inverse;
    }
}
