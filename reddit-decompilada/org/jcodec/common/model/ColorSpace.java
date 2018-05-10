package org.jcodec.common.model;

public enum ColorSpace {
    RGB(3, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV420(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV420J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 1, 1}),
    YUV422(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV422J(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    YUV444(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444J(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV422_10(3, new int[]{0, 1, 2}, new int[]{0, 1, 1}, new int[]{0, 0, 0}),
    GREY(1, new int[]{0}, new int[]{0}, new int[]{0}),
    MONO(1, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}),
    YUV444_10(3, new int[]{0, 1, 2}, new int[]{0, 0, 0}, new int[]{0, 0, 0});
    
    public static final int MAX_PLANES = 4;
    public int[] compHeight;
    public int[] compPlane;
    public int[] compWidth;
    public int nComp;

    private ColorSpace(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        this.nComp = i;
        this.compPlane = iArr;
        this.compWidth = iArr2;
        this.compHeight = iArr3;
    }
}
