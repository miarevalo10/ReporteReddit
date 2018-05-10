package org.jcodec.codecs.h264.decode.deblock;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class DeblockingFilter {
    static int[] alphaTab = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 17, 20, 22, 25, 28, 32, 36, 40, 45, 50, 56, 63, 71, 80, 90, 101, 113, 127, 144, 162, 182, 203, JpegConst.APP2, 255, 255};
    static int[] betaTab = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18};
    static int[] inverse = new int[]{0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 10, 11, 14, 15};
    static int[][] tcs = new int[][]{new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9, 10, 11, 13}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8, 10, 11, 12, 13, 15, 17}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9, 10, 11, 13, 14, 16, 18, 20, 23, 25}};
    private int[][] mbQps;
    private MBType[] mbTypes;
    private int[][][][] mvs;
    private int[][] nCoeff;
    private Picture[][][] refsUsed;
    private SliceHeader[] shs;
    private boolean[] tr8x8Used;

    public DeblockingFilter(int i, int i2, int[][] iArr, int[][][][] iArr2, MBType[] mBTypeArr, int[][] iArr3, SliceHeader[] sliceHeaderArr, boolean[] zArr, Picture[][][] pictureArr) {
        this.nCoeff = iArr;
        this.mvs = iArr2;
        this.mbTypes = mBTypeArr;
        this.mbQps = iArr3;
        this.shs = sliceHeaderArr;
        this.tr8x8Used = zArr;
        this.refsUsed = pictureArr;
    }

    public void deblockFrame(Picture picture) {
        ColorSpace color = picture.getColor();
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{4, 4});
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{4, 4});
        for (int i = 0; i < this.shs.length; i++) {
            calcBsH(picture, i, iArr2);
            calcBsV(picture, i, iArr);
            for (int i2 = 0; i2 < color.nComp; i2++) {
                fillVerticalEdge(picture, i2, i, iArr);
                fillHorizontalEdge(picture, i2, i, iArr2);
            }
        }
    }

    private int calcBoundaryStrenth(boolean z, boolean z2, boolean z3, int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int i3, int i4) {
        if (z && (z2 || z3)) {
            return true;
        }
        if (!z2) {
            if (!z3) {
                if (i <= 0) {
                    if (i2 <= 0) {
                        if ((!iArr[2]) + (iArr3[2] == -1 ? 0 : 1) != (iArr2[2] == -1 ? 0 : 1) + (iArr4[2] != -1)) {
                            return 1;
                        }
                        z3 = false;
                        z2 = iArr[2] >= false ? false : this.refsUsed[i3][0][iArr[2]];
                        boolean z4 = iArr3[2] < 0 ? false : this.refsUsed[i3][1][iArr3[2]];
                        boolean z5 = iArr2[2] < 0 ? false : this.refsUsed[i4][0][iArr2[2]];
                        if (iArr4[2] >= 0) {
                            z3 = this.refsUsed[i4][1][iArr4[2]];
                        }
                        if ((z2 != z5 && z2 != z3) || ((z4 != z5 && z4 != z3) || ((z5 != z2 && z5 != z4) || (z3 != z2 && z3 != z4)))) {
                            return 1;
                        }
                        if (z2 == z4 && z4 == z5 && z5 == z3) {
                            return (z2 && (mvThresh(iArr, iArr2) || mvThresh(iArr3, iArr2) || mvThresh(iArr, iArr4) || mvThresh(iArr3, iArr4))) ? 1 : 0;
                        } else {
                            if (z2 == z5 && z4 == z3) {
                                return ((z2 && mvThresh(iArr, iArr2)) || (z4 && mvThresh(iArr3, iArr4))) ? 1 : 0;
                            } else {
                                if (z2 == z3 && z4 == z5) {
                                    return ((z2 && mvThresh(iArr, iArr4)) || (z4 && mvThresh(iArr3, iArr2))) ? 1 : 0;
                                } else {
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return 2;
            }
        }
        return true;
    }

    private boolean mvThresh(int[] iArr, int[] iArr2) {
        if (Math.abs(iArr[0] - iArr2[0]) < 4) {
            if (Math.abs(iArr[1] - iArr2[1]) < 4) {
                return false;
            }
        }
        return true;
    }

    private static int getIdxBeta(int i, int i2) {
        return MathUtil.clip(i2 + i, 0, 51);
    }

    private static int getIdxAlpha(int i, int i2) {
        return MathUtil.clip(i2 + i, 0, 51);
    }

    private void calcBsH(Picture picture, int i, int[][] iArr) {
        Object obj;
        SliceHeader sliceHeader = this.shs[i];
        int i2 = 1;
        int i3 = sliceHeader.sps.pic_width_in_mbs_minus1 + 1;
        int i4 = i % i3;
        int i5 = i / i3;
        Object obj2 = 2;
        int i6 = (i5 <= 0 || (sliceHeader.disable_deblocking_filter_idc == 2 && r12.shs[i - i3] != sliceHeader)) ? 0 : 1;
        boolean z = r12.mbTypes[i] != null && r12.mbTypes[i].isIntra();
        int i7 = 4;
        if (i6 != 0) {
            int i8 = i - i3;
            boolean z2 = r12.mbTypes[i8] != null && r12.mbTypes[i8].isIntra();
            int i9 = 0;
            while (i9 < i7) {
                i6 = (i4 << 2) + i9;
                i3 = i5 << 2;
                int[] iArr2 = iArr[0];
                int i10 = r12.nCoeff[i3][i6];
                int i11 = i3 - 1;
                int i12 = r12.nCoeff[i11][i6];
                int[] iArr3 = r12.mvs[0][i3][i6];
                int[] iArr4 = r12.mvs[0][i11][i6];
                int[] iArr5 = r12.mvs[i2][i3][i6];
                int[] iArr6 = r12.mvs[i2][i11][i6];
                i11 = i12;
                int[] iArr7 = iArr3;
                iArr3 = iArr4;
                iArr4 = iArr5;
                int i13 = i9;
                i2 = i7;
                obj = obj2;
                iArr2[i13] = calcBoundaryStrenth(true, z2, z, i10, i11, iArr7, iArr3, iArr4, iArr6, i, i8);
                i9 = i13 + 1;
                i7 = i2;
                obj2 = obj;
                i2 = 1;
            }
        }
        i2 = i7;
        obj = obj2;
        int i14 = 1;
        while (i14 < i2) {
            i7 = 0;
            while (i7 < i2) {
                i6 = (i4 << 2) + i7;
                i3 = (i5 << 2) + i14;
                int[] iArr8 = iArr[i14];
                i10 = r12.nCoeff[i3][i6];
                i11 = i3 - 1;
                i12 = r12.nCoeff[i11][i6];
                iArr3 = r12.mvs[0][i3][i6];
                iArr4 = r12.mvs[0][i11][i6];
                int[] iArr9 = r12.mvs[1][i3][i6];
                iArr2 = r12.mvs[1][i11][i6];
                i11 = i12;
                iArr7 = iArr3;
                iArr3 = iArr4;
                iArr4 = iArr9;
                iArr9 = iArr2;
                int i15 = i7;
                int i16 = i14;
                iArr8[i15] = calcBoundaryStrenth(false, z, z, i10, i11, iArr7, iArr3, iArr4, iArr9, i, i);
                i7 = i15 + 1;
                i14 = i16;
            }
            i14++;
        }
    }

    private void fillHorizontalEdge(Picture picture, int i, int i2, int[][] iArr) {
        int i3;
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        SliceHeader sliceHeader = this.shs[i2];
        int i8 = 1;
        int i9 = sliceHeader.sps.pic_width_in_mbs_minus1 + 1;
        int i10 = sliceHeader.slice_alpha_c0_offset_div2 << 1;
        int i11 = sliceHeader.slice_beta_offset_div2 << 1;
        int i12 = i2 % i9;
        int i13 = i2 / i9;
        Object obj2 = 2;
        int i14 = (i13 <= 0 || (sliceHeader.disable_deblocking_filter_idc == 2 && r9.shs[i2 - i9] != sliceHeader)) ? 0 : 1;
        int i15 = r9.mbQps[i][i2];
        int i16 = 2 - picture.getColor().compWidth[i];
        int i17 = 2 - picture.getColor().compHeight[i];
        int i18 = 4;
        if (i14 != 0) {
            i3 = ((r9.mbQps[i][i2 - i9] + i15) + 1) >> 1;
            i4 = 0;
            while (i4 < i18) {
                int i19 = ((i12 << 2) + i4) << i16;
                int i20 = (i13 << 2) << i17;
                int idxAlpha = getIdxAlpha(i10, i3);
                int idxBeta = getIdxBeta(i11, i3);
                int i21 = iArr[0][i4];
                int i22 = i8 << i16;
                int i23 = i4;
                i4 = i19;
                i19 = i3;
                i8 = i17;
                i5 = i15;
                obj = obj2;
                filterBlockEdgeHoris(picture, i, i4, i20, idxAlpha, idxBeta, i21, i22);
                i4 = i23 + 1;
                i15 = i5;
                i17 = i8;
                i3 = i19;
                obj2 = obj;
                i18 = 4;
                i8 = 1;
            }
        }
        i8 = i17;
        i5 = i15;
        obj = obj2;
        if (i == 0) {
            if (r9.tr8x8Used[i2]) {
                i14 = 1;
                i6 = i14;
                i7 = i14;
                i15 = 4;
                while (i7 < i15) {
                    if (i6 != 0) {
                        if ((i7 & 1) != i14) {
                            i21 = i14;
                            i19 = i15;
                            idxBeta = i7;
                            idxAlpha = i5;
                            i7 = idxBeta + 1;
                            i15 = i19;
                            i5 = idxAlpha;
                            i14 = i21;
                        }
                    }
                    i17 = 0;
                    while (i17 < i15) {
                        i4 = ((i12 << 2) + i17) << i16;
                        i3 = ((i13 << 2) + i7) << i8;
                        i18 = getIdxAlpha(i10, i5);
                        i19 = getIdxBeta(i11, i5);
                        idxAlpha = i5;
                        idxBeta = iArr[i7][i17];
                        i23 = i17;
                        i17 = i19;
                        i19 = i15;
                        i15 = idxBeta;
                        idxBeta = i7;
                        filterBlockEdgeHoris(picture, i, i4, i3, i18, i17, i15, 1 << i16);
                        i17 = i23 + 1;
                        i15 = i19;
                        i7 = idxBeta;
                    }
                    i19 = i15;
                    idxBeta = i7;
                    idxAlpha = i5;
                    i21 = 1;
                    i7 = idxBeta + 1;
                    i15 = i19;
                    i5 = idxAlpha;
                    i14 = i21;
                }
            }
        }
        i14 = 1;
        if (i8 != 1) {
            i6 = 0;
            i7 = i14;
            i15 = 4;
            while (i7 < i15) {
                if (i6 != 0) {
                    if ((i7 & 1) != i14) {
                        i21 = i14;
                        i19 = i15;
                        idxBeta = i7;
                        idxAlpha = i5;
                        i7 = idxBeta + 1;
                        i15 = i19;
                        i5 = idxAlpha;
                        i14 = i21;
                    }
                }
                i17 = 0;
                while (i17 < i15) {
                    i4 = ((i12 << 2) + i17) << i16;
                    i3 = ((i13 << 2) + i7) << i8;
                    i18 = getIdxAlpha(i10, i5);
                    i19 = getIdxBeta(i11, i5);
                    idxAlpha = i5;
                    idxBeta = iArr[i7][i17];
                    i23 = i17;
                    i17 = i19;
                    i19 = i15;
                    i15 = idxBeta;
                    idxBeta = i7;
                    filterBlockEdgeHoris(picture, i, i4, i3, i18, i17, i15, 1 << i16);
                    i17 = i23 + 1;
                    i15 = i19;
                    i7 = idxBeta;
                }
                i19 = i15;
                idxBeta = i7;
                idxAlpha = i5;
                i21 = 1;
                i7 = idxBeta + 1;
                i15 = i19;
                i5 = idxAlpha;
                i14 = i21;
            }
        }
        i6 = i14;
        i7 = i14;
        i15 = 4;
        while (i7 < i15) {
            if (i6 != 0) {
                if ((i7 & 1) != i14) {
                    i21 = i14;
                    i19 = i15;
                    idxBeta = i7;
                    idxAlpha = i5;
                    i7 = idxBeta + 1;
                    i15 = i19;
                    i5 = idxAlpha;
                    i14 = i21;
                }
            }
            i17 = 0;
            while (i17 < i15) {
                i4 = ((i12 << 2) + i17) << i16;
                i3 = ((i13 << 2) + i7) << i8;
                i18 = getIdxAlpha(i10, i5);
                i19 = getIdxBeta(i11, i5);
                idxAlpha = i5;
                idxBeta = iArr[i7][i17];
                i23 = i17;
                i17 = i19;
                i19 = i15;
                i15 = idxBeta;
                idxBeta = i7;
                filterBlockEdgeHoris(picture, i, i4, i3, i18, i17, i15, 1 << i16);
                i17 = i23 + 1;
                i15 = i19;
                i7 = idxBeta;
            }
            i19 = i15;
            idxBeta = i7;
            idxAlpha = i5;
            i21 = 1;
            i7 = idxBeta + 1;
            i15 = i19;
            i5 = idxAlpha;
            i14 = i21;
        }
    }

    private void calcBsV(Picture picture, int i, int[][] iArr) {
        Object obj;
        SliceHeader sliceHeader = this.shs[i];
        int i2 = 1;
        int i3 = sliceHeader.sps.pic_width_in_mbs_minus1 + 1;
        int i4 = i % i3;
        int i5 = i / i3;
        Object obj2 = 2;
        int i6 = (i4 <= 0 || (sliceHeader.disable_deblocking_filter_idc == 2 && r12.shs[i - 1] != sliceHeader)) ? 0 : 1;
        boolean z = r12.mbTypes[i] != null && r12.mbTypes[i].isIntra();
        int i7 = 4;
        if (i6 != 0) {
            int i8 = i - 1;
            boolean z2 = r12.mbTypes[i8] != null && r12.mbTypes[i8].isIntra();
            int i9 = 0;
            while (i9 < i7) {
                i6 = i4 << 2;
                i3 = (i5 << 2) + i9;
                int[] iArr2 = iArr[i9];
                int i10 = r12.nCoeff[i3][i6];
                int i11 = i6 - 1;
                int i12 = r12.nCoeff[i3][i11];
                int[] iArr3 = r12.mvs[0][i3][i6];
                int[] iArr4 = r12.mvs[0][i3][i11];
                int[] iArr5 = r12.mvs[i2][i3][i6];
                int[] iArr6 = r12.mvs[i2][i3][i11];
                i11 = i12;
                int[] iArr7 = iArr3;
                iArr3 = iArr4;
                iArr4 = iArr5;
                int i13 = i9;
                i2 = i7;
                obj = obj2;
                iArr2[0] = calcBoundaryStrenth(true, z2, z, i10, i11, iArr7, iArr3, iArr4, iArr6, i, i8);
                i9 = i13 + 1;
                i7 = i2;
                obj2 = obj;
                i2 = 1;
            }
        }
        i2 = i7;
        obj = obj2;
        int i14 = 1;
        while (i14 < i2) {
            i7 = 0;
            while (i7 < i2) {
                i6 = (i4 << 2) + i14;
                i3 = (i5 << 2) + i7;
                int[] iArr8 = iArr[i7];
                i10 = r12.nCoeff[i3][i6];
                i11 = i6 - 1;
                i12 = r12.nCoeff[i3][i11];
                iArr3 = r12.mvs[0][i3][i6];
                iArr4 = r12.mvs[0][i3][i11];
                int[] iArr9 = r12.mvs[1][i3][i6];
                iArr2 = r12.mvs[1][i3][i11];
                i11 = i12;
                iArr7 = iArr3;
                iArr3 = iArr4;
                iArr4 = iArr9;
                iArr9 = iArr2;
                int i15 = i7;
                int i16 = i14;
                iArr8[i16] = calcBoundaryStrenth(false, z, z, i10, i11, iArr7, iArr3, iArr4, iArr9, i, i);
                i7 = i15 + 1;
                i14 = i16;
            }
            i14++;
        }
    }

    private void fillVerticalEdge(Picture picture, int i, int i2, int[][] iArr) {
        int i3;
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        SliceHeader sliceHeader = this.shs[i2];
        int i8 = 1;
        int i9 = sliceHeader.sps.pic_width_in_mbs_minus1 + 1;
        int i10 = sliceHeader.slice_alpha_c0_offset_div2 << 1;
        int i11 = sliceHeader.slice_beta_offset_div2 << 1;
        int i12 = i2 % i9;
        int i13 = i2 / i9;
        Object obj2 = 2;
        int i14 = (i12 <= 0 || (sliceHeader.disable_deblocking_filter_idc == 2 && r9.shs[i2 - 1] != sliceHeader)) ? 0 : 1;
        int i15 = r9.mbQps[i][i2];
        int i16 = 2 - picture.getColor().compWidth[i];
        int i17 = 2 - picture.getColor().compHeight[i];
        int i18 = 4;
        if (i14 != 0) {
            i3 = ((r9.mbQps[i][i2 - 1] + i15) + 1) >> 1;
            i4 = 0;
            while (i4 < i18) {
                int i19 = (i12 << 2) << i16;
                int i20 = ((i13 << 2) + i4) << i17;
                int idxAlpha = getIdxAlpha(i10, i3);
                int idxBeta = getIdxBeta(i11, i3);
                int i21 = iArr[i4][0];
                int i22 = i8 << i17;
                int i23 = i4;
                i4 = i19;
                i19 = i3;
                i8 = i16;
                i5 = i15;
                obj = obj2;
                filterBlockEdgeVert(picture, i, i4, i20, idxAlpha, idxBeta, i21, i22);
                i4 = i23 + 1;
                i15 = i5;
                i16 = i8;
                i3 = i19;
                obj2 = obj;
                i18 = 4;
                i8 = 1;
            }
        }
        i8 = i16;
        i5 = i15;
        obj = obj2;
        if (i == 0) {
            if (r9.tr8x8Used[i2]) {
                i14 = 1;
                i6 = i14;
                i7 = i14;
                i15 = 4;
                while (i7 < i15) {
                    if (i6 != 0) {
                        if ((i7 & 1) != i14) {
                            i21 = i14;
                            i19 = i15;
                            idxBeta = i7;
                            idxAlpha = i5;
                            i7 = idxBeta + 1;
                            i15 = i19;
                            i5 = idxAlpha;
                            i14 = i21;
                        }
                    }
                    i16 = 0;
                    while (i16 < i15) {
                        i4 = ((i12 << 2) + i7) << i8;
                        i3 = ((i13 << 2) + i16) << i17;
                        i18 = getIdxAlpha(i10, i5);
                        i19 = getIdxBeta(i11, i5);
                        idxAlpha = i5;
                        idxBeta = iArr[i16][i7];
                        i23 = i16;
                        i16 = i19;
                        i19 = i15;
                        i15 = idxBeta;
                        idxBeta = i7;
                        filterBlockEdgeVert(picture, i, i4, i3, i18, i16, i15, 1 << i17);
                        i16 = i23 + 1;
                        i15 = i19;
                        i7 = idxBeta;
                    }
                    i19 = i15;
                    idxBeta = i7;
                    idxAlpha = i5;
                    i21 = 1;
                    i7 = idxBeta + 1;
                    i15 = i19;
                    i5 = idxAlpha;
                    i14 = i21;
                }
            }
        }
        i14 = 1;
        if (i8 != 1) {
            i6 = 0;
            i7 = i14;
            i15 = 4;
            while (i7 < i15) {
                if (i6 != 0) {
                    if ((i7 & 1) != i14) {
                        i21 = i14;
                        i19 = i15;
                        idxBeta = i7;
                        idxAlpha = i5;
                        i7 = idxBeta + 1;
                        i15 = i19;
                        i5 = idxAlpha;
                        i14 = i21;
                    }
                }
                i16 = 0;
                while (i16 < i15) {
                    i4 = ((i12 << 2) + i7) << i8;
                    i3 = ((i13 << 2) + i16) << i17;
                    i18 = getIdxAlpha(i10, i5);
                    i19 = getIdxBeta(i11, i5);
                    idxAlpha = i5;
                    idxBeta = iArr[i16][i7];
                    i23 = i16;
                    i16 = i19;
                    i19 = i15;
                    i15 = idxBeta;
                    idxBeta = i7;
                    filterBlockEdgeVert(picture, i, i4, i3, i18, i16, i15, 1 << i17);
                    i16 = i23 + 1;
                    i15 = i19;
                    i7 = idxBeta;
                }
                i19 = i15;
                idxBeta = i7;
                idxAlpha = i5;
                i21 = 1;
                i7 = idxBeta + 1;
                i15 = i19;
                i5 = idxAlpha;
                i14 = i21;
            }
        }
        i6 = i14;
        i7 = i14;
        i15 = 4;
        while (i7 < i15) {
            if (i6 != 0) {
                if ((i7 & 1) != i14) {
                    i21 = i14;
                    i19 = i15;
                    idxBeta = i7;
                    idxAlpha = i5;
                    i7 = idxBeta + 1;
                    i15 = i19;
                    i5 = idxAlpha;
                    i14 = i21;
                }
            }
            i16 = 0;
            while (i16 < i15) {
                i4 = ((i12 << 2) + i7) << i8;
                i3 = ((i13 << 2) + i16) << i17;
                i18 = getIdxAlpha(i10, i5);
                i19 = getIdxBeta(i11, i5);
                idxAlpha = i5;
                idxBeta = iArr[i16][i7];
                i23 = i16;
                i16 = i19;
                i19 = i15;
                i15 = idxBeta;
                idxBeta = i7;
                filterBlockEdgeVert(picture, i, i4, i3, i18, i16, i15, 1 << i17);
                i16 = i23 + 1;
                i15 = i19;
                i7 = idxBeta;
            }
            i19 = i15;
            idxBeta = i7;
            idxAlpha = i5;
            i21 = 1;
            i7 = idxBeta + 1;
            i15 = i19;
            i5 = idxAlpha;
            i14 = i21;
        }
    }

    private void filterBlockEdgeHoris(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int planeWidth = picture.getPlaneWidth(i);
        int i9 = (i3 * planeWidth) + i2;
        int i10 = i7;
        int i11 = 0;
        while (i11 < i10) {
            int i12;
            int i13 = 3 * planeWidth;
            int i14 = (i9 - i13) + i11;
            int i15 = 2 * planeWidth;
            int i16 = (i9 - i15) + i11;
            int i17 = (i9 - planeWidth) + i11;
            int i18 = i9 + i11;
            int i19 = (i9 + planeWidth) + i11;
            int i20 = (i15 + i9) + i11;
            if (i8 == 4) {
                filterBs4(i4, i5, picture.getPlaneData(i), (i9 - (4 * planeWidth)) + i11, i14, i16, i17, i18, i19, i20, (i13 + i9) + i11, i != 0);
            } else if (i8 > 0) {
                i12 = i11;
                filterBs(i8, i4, i5, picture.getPlaneData(i), i14, i16, i17, i18, i19, i20, i != 0);
                i11 = i12 + 1;
                i10 = i7;
            }
            i12 = i11;
            i11 = i12 + 1;
            i10 = i7;
        }
    }

    private void filterBlockEdgeVert(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int planeWidth = picture.getPlaneWidth(i);
        int i9 = i7;
        int i10 = 0;
        while (i10 < i9) {
            int i11;
            int i12 = ((i3 + i10) * planeWidth) + i2;
            int i13 = i12 - 3;
            int i14 = i12 - 2;
            int i15 = i12 - 1;
            int i16 = i12 + 1;
            int i17 = i12 + 2;
            if (i8 == 4) {
                filterBs4(i4, i5, picture.getPlaneData(i), i12 - 4, i13, i14, i15, i12, i16, i17, i12 + 3, i != 0);
            } else if (i8 > 0) {
                i11 = i10;
                filterBs(i8, i4, i5, picture.getPlaneData(i), i13, i14, i15, i12, i16, i17, i != 0);
                i10 = i11 + 1;
                i9 = i7;
            }
            i11 = i10;
            i10 = i11 + 1;
            i9 = i7;
        }
    }

    private void filterBs(int i, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10 = iArr[i5];
        int i11 = iArr[i6];
        int i12 = iArr[i7];
        int i13 = iArr[i8];
        int i14 = alphaTab[i2];
        int i15 = betaTab[i3];
        i14 = (Math.abs(i11 - i12) >= i14 || Math.abs(i10 - i11) >= i15 || Math.abs(i13 - i12) >= i15) ? 0 : 1;
        if (i14 != 0) {
            int i16;
            int i17;
            int i18 = tcs[i - 1][i2];
            if (z) {
                i14 = i18 + 1;
                i15 = 0;
                i16 = 0;
            } else {
                i14 = Math.abs(iArr[i4] - i11);
                i16 = Math.abs(iArr[i9] - i12);
                int i19 = ((i14 < i15 ? 1 : 0) + i18) + (i16 < i15 ? 1 : 0);
                i16 = i16 < i15 ? 1 : 0;
                i15 = i14 < i15 ? 1 : 0;
                i14 = i19;
            }
            int i20 = ((((i12 - i11) << 2) + (i10 - i13)) + 4) >> 3;
            int i21 = -i14;
            if (i20 >= i21) {
                i21 = i20 > i14 ? i14 : i20;
            }
            i20 = i11 + i21;
            if (i20 < 0) {
                i20 = 0;
            }
            i21 = i12 - i21;
            if (i21 < 0) {
                i21 = 0;
            }
            if (i15 != 0) {
                i17 = ((iArr[i4] + (((i11 + i12) + 1) >> 1)) - (i10 << 1)) >> 1;
                i15 = -i18;
                if (i17 < i15) {
                    i17 = i15;
                } else if (i17 > i18) {
                    i17 = i18;
                }
                iArr[i5] = MathUtil.clip(i10 + i17, 0, 255);
            }
            if (i16 != 0) {
                i17 = ((iArr[i9] + (((i11 + i12) + 1) >> 1)) - (i13 << 1)) >> 1;
                int i22 = -i18;
                if (i17 < i22) {
                    i17 = i22;
                } else if (i17 > i18) {
                    i17 = i18;
                }
                i18 = 0;
                iArr[i8] = MathUtil.clip(i13 + i17, 0, 255);
            } else {
                i18 = 0;
            }
            iArr[i7] = MathUtil.clip(i21, i18, 255);
            iArr[i6] = MathUtil.clip(i20, i18, 255);
        }
    }

    private void filterBs4(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z) {
        int i11 = iArr[i6];
        int i12 = iArr[i7];
        int i13 = iArr[i5];
        int i14 = iArr[i8];
        int i15 = alphaTab[i];
        int i16 = betaTab[i2];
        int i17 = i11 - i12;
        Object obj = 1;
        Object obj2 = (Math.abs(i17) >= i15 || Math.abs(i13 - i11) >= i16 || Math.abs(i14 - i12) >= i16) ? null : 1;
        if (obj2 != null) {
            Object obj3;
            int abs;
            int i18;
            if (z) {
                obj3 = null;
            } else {
                abs = Math.abs(iArr[i4] - i11);
                int abs2 = Math.abs(iArr[i9] - i12);
                if (abs < i16) {
                    if (Math.abs(i17) < (i15 >> 2) + 2) {
                        obj3 = 1;
                        if (abs2 < i16 && Math.abs(i17) < (i15 >> 2) + 2) {
                            if (obj3 != null) {
                                abs = iArr[i3];
                                i16 = iArr[i4];
                                i15 = ((((i16 + i13) + i11) + i12) + 2) >> 2;
                                abs = ((((((abs * 2) + (i16 * 3)) + i13) + i11) + i12) + 4) >> 3;
                                iArr[i6] = MathUtil.clip(((((((2 * i13) + i16) + (2 * i11)) + (2 * i12)) + i14) + 4) >> 3, 0, 255);
                                iArr[i5] = MathUtil.clip(i15, 0, 255);
                                iArr[i4] = MathUtil.clip(abs, 0, 255);
                                i18 = 2;
                            } else {
                                i18 = 2;
                                iArr[i6] = MathUtil.clip(((((2 * i13) + i11) + i14) + 2) >> 2, 0, 255);
                            }
                            if (obj != null || z) {
                                iArr[i7] = MathUtil.clip(((((i18 * i14) + i12) + i13) + i18) >> 2, 0, 255);
                            }
                            int i19 = iArr[i9];
                            int i20 = ((((i11 + i12) + i14) + i19) + i18) >> i18;
                            i18 = ((((((i18 * iArr[i10]) + (i19 * 3)) + i14) + i12) + i11) + 4) >> 3;
                            iArr[i7] = MathUtil.clip((((((i13 + (i18 * i11)) + (i18 * i12)) + (i18 * i14)) + i19) + 4) >> 3, 0, 255);
                            int clip = MathUtil.clip(i20, 0, 255);
                            i20 = 0;
                            iArr[i8] = clip;
                            iArr[i9] = MathUtil.clip(i18, i20, 255);
                            return;
                        }
                    }
                }
                obj3 = null;
                if (obj3 != null) {
                    i18 = 2;
                    iArr[i6] = MathUtil.clip(((((2 * i13) + i11) + i14) + 2) >> 2, 0, 255);
                } else {
                    abs = iArr[i3];
                    i16 = iArr[i4];
                    i15 = ((((i16 + i13) + i11) + i12) + 2) >> 2;
                    abs = ((((((abs * 2) + (i16 * 3)) + i13) + i11) + i12) + 4) >> 3;
                    iArr[i6] = MathUtil.clip(((((((2 * i13) + i16) + (2 * i11)) + (2 * i12)) + i14) + 4) >> 3, 0, 255);
                    iArr[i5] = MathUtil.clip(i15, 0, 255);
                    iArr[i4] = MathUtil.clip(abs, 0, 255);
                    i18 = 2;
                }
                if (obj != null) {
                }
                iArr[i7] = MathUtil.clip(((((i18 * i14) + i12) + i13) + i18) >> 2, 0, 255);
            }
            obj = null;
            if (obj3 != null) {
                abs = iArr[i3];
                i16 = iArr[i4];
                i15 = ((((i16 + i13) + i11) + i12) + 2) >> 2;
                abs = ((((((abs * 2) + (i16 * 3)) + i13) + i11) + i12) + 4) >> 3;
                iArr[i6] = MathUtil.clip(((((((2 * i13) + i16) + (2 * i11)) + (2 * i12)) + i14) + 4) >> 3, 0, 255);
                iArr[i5] = MathUtil.clip(i15, 0, 255);
                iArr[i4] = MathUtil.clip(abs, 0, 255);
                i18 = 2;
            } else {
                i18 = 2;
                iArr[i6] = MathUtil.clip(((((2 * i13) + i11) + i14) + 2) >> 2, 0, 255);
            }
            if (obj != null) {
            }
            iArr[i7] = MathUtil.clip(((((i18 * i14) + i12) + i13) + i18) >> 2, 0, 255);
        }
    }
}
