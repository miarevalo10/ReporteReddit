package org.jcodec.codecs.mpeg12;

import java.lang.reflect.Array;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class MPEGPred {
    private int chromaFormat;
    private int[][] fCode;
    protected int[][][] mvPred = ((int[][][]) Array.newInstance(int.class, new int[]{2, 2, 2}));
    private boolean topFieldFirst;

    private final int dpXField(int i, int i2, int i3) {
        return ((i + (i > 0 ? 1 : 0)) >> 1) + i2;
    }

    private final int dpYField(int i, int i2, int i3) {
        return (((i + (i > 0 ? 1 : 0)) >> 1) + (1 - (i3 << 1))) + i2;
    }

    private final int sign_extend(int i, int i2) {
        i2 = 32 - i2;
        return (i << i2) >> i2;
    }

    public MPEGPred(int[][] iArr, int i, boolean z) {
        this.fCode = iArr;
        this.chromaFormat = i;
        this.topFieldFirst = z;
    }

    public MPEGPred(MPEGPred mPEGPred) {
        this.fCode = mPEGPred.fCode;
        this.chromaFormat = mPEGPred.chromaFormat;
        this.topFieldFirst = mPEGPred.topFieldFirst;
    }

    public void predictEvenEvenSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        i2 = (((i2 << i5) + i6) * i3) + i;
        i7 *= i8;
        i = (i3 << i5) - i8;
        i10 *= i8;
        i4 = i2;
        for (i2 = 0; i2 < i9; i2++) {
            i5 = i4;
            i4 = 0;
            while (i4 < i8) {
                i6 = i7 + 1;
                int i11 = i5 + 1;
                iArr2[i7] = iArr[i5];
                i4++;
                i7 = i6;
                i5 = i11;
            }
            i4 = i5 + i;
            i7 += i10;
        }
    }

    public void predictEvenOddSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        i2 = (((i2 << i5) + i6) * i3) + i;
        i7 *= i8;
        i = (i3 << i5) - i8;
        i10 *= i8;
        i4 = i2;
        for (i2 = 0; i2 < i9; i2++) {
            i5 = i4;
            i4 = 0;
            while (i4 < i8) {
                i6 = i7 + 1;
                int i11 = iArr[i5];
                i5++;
                iArr2[i7] = ((i11 + iArr[i5]) + 1) >> 1;
                i4++;
                i7 = i6;
            }
            i4 = i5 + i;
            i7 += i10;
        }
    }

    public void predictOddEvenSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        i2 = (((i2 << i5) + i6) * i3) + i;
        i7 *= i8;
        i = i3 << i5;
        i3 = i - i8;
        i10 *= i8;
        i5 = i2;
        for (i2 = 0; i2 < i9; i2++) {
            i6 = i5;
            i5 = 0;
            while (i5 < i8) {
                int i11 = i7 + 1;
                iArr2[i7] = ((iArr[i6] + iArr[i6 + i]) + 1) >> 1;
                i6++;
                i5++;
                i7 = i11;
            }
            i5 = i6 + i3;
            i7 += i10;
        }
    }

    public void predictOddOddSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11 = i8;
        int i12 = i3 << i5;
        int i13 = i12 - i11;
        int i14 = i10 * i11;
        int i15 = (((i2 << i5) + i6) * i3) + i;
        int i16 = i11 * i7;
        int i17 = 0;
        int i18 = i9;
        while (i17 < i18) {
            int i19 = i15;
            i15 = i16;
            i16 = 0;
            while (i16 < i11) {
                int i20 = i15 + 1;
                int i21 = i19 + 1;
                i19 += i12;
                iArr2[i15] = ((((iArr[i19] + iArr[i21]) + iArr[i19]) + iArr[i19 + 1]) + 3) >> 2;
                i16++;
                i15 = i20;
                i19 = i21;
            }
            i17++;
            int i22 = i15 + i14;
            i15 = i19 + i13;
            i16 = i22;
        }
    }

    protected final int getPix1(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        return iArr[(MathUtil.clip(i4, 0, (i2 - (1 << i5)) + i6) * i) + MathUtil.clip(i3, 0, i - 1)];
    }

    protected final int getPix2(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i - 1;
        i2 = (i2 - (1 << i7)) + i8;
        return ((iArr[(MathUtil.clip(i4, 0, i2) * i) + MathUtil.clip(i3, 0, i9)] + iArr[(MathUtil.clip(i6, 0, i2) * i) + MathUtil.clip(i5, 0, i9)]) + 1) >> 1;
    }

    protected final int getPix4(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        i2 = (i2 - (1 << i11)) + i12;
        i11 = i - 1;
        return ((((iArr[(MathUtil.clip(i4, 0, i2) * i) + MathUtil.clip(i3, 0, i11)] + iArr[(MathUtil.clip(i6, 0, i2) * i) + MathUtil.clip(i5, 0, i11)]) + iArr[(MathUtil.clip(i8, 0, i2) * i) + MathUtil.clip(i7, 0, i11)]) + iArr[(MathUtil.clip(i10, 0, i2) * i) + MathUtil.clip(i9, 0, i11)]) + 3) >> 2;
    }

    public void predictEvenEvenUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11 = i8;
        int i12 = i10 * i11;
        int i13 = i11 * i7;
        int i14 = i9;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = ((i15 + i2) << i5) + i6;
            int i17 = i13;
            i13 = 0;
            while (i13 < i11) {
                int i18 = i17 + 1;
                iArr2[i17] = getPix1(iArr, i3, i4, i13 + i, i16, i5, i6);
                i13++;
                i17 = i18;
            }
            i13 = i17 + i12;
        }
    }

    public void predictEvenOddUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11 = i8;
        int i12 = i10 * i11;
        int i13 = i11 * i7;
        int i14 = i9;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = ((i15 + i2) << i5) + i6;
            int i17 = i13;
            i13 = 0;
            while (i13 < i11) {
                int i18 = i17 + 1;
                int i19 = i13 + i;
                iArr2[i17] = getPix2(iArr, i3, i4, i19, i16, i19 + 1, i16, i5, i6);
                i13++;
                i17 = i18;
            }
            i13 = i17 + i12;
        }
    }

    public void predictOddEvenUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11 = i8;
        int i12 = i11 * i7;
        int i13 = i10 * i11;
        int i14 = i9;
        int i15 = 0;
        while (i15 < i14) {
            int i16 = i15 + i2;
            int i17 = (i16 << i5) + i6;
            int i18 = ((i16 + 1) << i5) + i6;
            int i19 = i12;
            int i20 = 0;
            while (i20 < i11) {
                int i21 = i19 + 1;
                int i22 = i20 + i;
                int i23 = i20;
                int i24 = i15;
                iArr2[i19] = getPix2(iArr, i3, i4, i22, i17, i22, i18, i5, i6);
                i20 = i23 + 1;
                i19 = i21;
                i15 = i24;
            }
            i12 = i19 + i13;
            i15++;
        }
    }

    public void predictOddOddUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11 = i8;
        int i12 = i11 * i7;
        int i13 = i10 * i11;
        int i14 = i9;
        int i15 = 0;
        while (i15 < i14) {
            int i16 = i15 + i2;
            int i17 = (i16 << i5) + i6;
            int i18 = ((i16 + 1) << i5) + i6;
            int i19 = i12;
            int i20 = 0;
            while (i20 < i11) {
                int i21 = i20 + i;
                int i22 = i19 + 1;
                int i23 = i21 + 1;
                int i24 = i20;
                i20 = i23;
                i23 = i15;
                iArr2[i19] = getPix4(iArr, i3, i4, i21, i17, i23, i17, i21, i18, i20, i18, i5, i6);
                i20 = i24 + 1;
                i11 = i8;
                i14 = i9;
                i19 = i22;
                i15 = i23;
            }
            i12 = i19 + i13;
            i15++;
            i11 = i8;
            i14 = i9;
        }
    }

    public void predictPlane(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        Object obj;
        int i13 = i >> 1;
        int i14 = i2 >> 1;
        if (i13 < 0 || i14 < 0) {
            i11 = i3;
        } else {
            i11 = i3;
            if (i13 + i8 < i11) {
                i12 = i4;
                if (((i14 + i9) << i5) < i12) {
                    obj = 1;
                    if ((i & 1) == 0) {
                        if ((i2 & 1) == 0) {
                            if (obj != null) {
                                predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                            } else {
                                predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                            }
                        } else if (obj != null) {
                            predictOddEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        } else {
                            predictOddEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        }
                    } else if ((i2 & 1) == 0) {
                        if (obj != null) {
                            predictEvenOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        } else {
                            predictEvenOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        }
                    } else if (obj != null) {
                        predictOddOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else {
                        predictOddOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    }
                }
                obj = null;
                if ((i & 1) == 0) {
                    if ((i2 & 1) == 0) {
                        if (obj != null) {
                            predictOddOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        } else {
                            predictOddOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        }
                    } else if (obj != null) {
                        predictEvenOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else {
                        predictEvenOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    }
                } else if ((i2 & 1) == 0) {
                    if (obj != null) {
                        predictOddEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else {
                        predictOddEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    }
                } else if (obj != null) {
                    predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                } else {
                    predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                }
            }
        }
        i12 = i4;
        obj = null;
        if ((i & 1) == 0) {
            if ((i2 & 1) == 0) {
                if (obj != null) {
                    predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                } else {
                    predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                }
            } else if (obj != null) {
                predictOddEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            } else {
                predictOddEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            }
        } else if ((i2 & 1) == 0) {
            if (obj != null) {
                predictEvenOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            } else {
                predictEvenOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            }
        } else if (obj != null) {
            predictOddOddSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
        } else {
            predictOddOddUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
        }
    }

    public void predictInField(Picture[] pictureArr, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4, int i5) {
        switch (i3) {
            case 1:
                predict16x16Field(pictureArr, i, i2, bitReader, i4, iArr);
                return;
            case 2:
                predict16x8MC(pictureArr, i, i2, bitReader, i4, iArr, 0, 0);
                predict16x8MC(pictureArr, i, i2, bitReader, i4, iArr, 8, 1);
                return;
            case 3:
                predict16x16DualPrimeField(pictureArr, i, i2, bitReader, iArr, i5);
                break;
            default:
                break;
        }
    }

    public void predictInFrame(Picture picture, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4, int i5) {
        Picture[] pictureArr = new Picture[]{picture, picture};
        switch (i3) {
            case 1:
                predictFieldInFrame(picture, i, i2, iArr, bitReader, i4, i5);
                return;
            case 2:
                predict16x16Frame(picture, i, i2, bitReader, i4, iArr);
                return;
            case 3:
                predict16x16DualPrimeFrame(pictureArr, i, i2, bitReader, i4, iArr);
                break;
            default:
                break;
        }
    }

    private void predict16x16DualPrimeField(Picture[] pictureArr, int i, int i2, BitReader bitReader, int[][] iArr, int i3) {
        BitReader bitReader2 = bitReader;
        int mvectDecode = mvectDecode(bitReader2, this.fCode[0][0], this.mvPred[0][0][0]);
        int readVLC = MPEGConst.vlcDualPrime.readVLC(bitReader2) - 1;
        int mvectDecode2 = mvectDecode(bitReader2, this.fCode[0][1], this.mvPred[0][0][1]);
        int readVLC2 = MPEGConst.vlcDualPrime.readVLC(bitReader2) - 1;
        int i4 = 1 - i3;
        int dpXField = dpXField(mvectDecode, readVLC, i4);
        int dpYField = dpYField(mvectDecode2, readVLC2, i4);
        int i5 = this.chromaFormat == 1 ? 1 : 0;
        int i6 = r13.chromaFormat == 3 ? 0 : 1;
        int i7 = r13.chromaFormat == 1 ? 2 : 1;
        int i8 = r13.chromaFormat == 3 ? 1 : 2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{3, 256});
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{3, 256});
        int i9 = i << 1;
        int i10 = i2 << 1;
        int i11 = i9 >> i6;
        int i12 = i11 + (mvectDecode / i8);
        int i13 = i10 >> i5;
        int i14 = i13 + (mvectDecode2 / i7);
        int i15 = i3;
        int i16 = i4;
        int i17 = mvectDecode2;
        int i18 = mvectDecode;
        int i19 = 0;
        predictPlane(pictureArr[i3].getPlaneData(0), i9 + mvectDecode, i10 + mvectDecode2, pictureArr[i3].getPlaneWidth(0), pictureArr[i3].getPlaneHeight(0), 1, i15, iArr2[0], 0, 16, 16, 0);
        i6 = 16 >> i6;
        i5 = 16 >> i5;
        int i20 = i12;
        int i21 = i14;
        int i22 = i6;
        mvectDecode = i5;
        predictPlane(pictureArr[i3].getPlaneData(1), i20, i21, pictureArr[i3].getPlaneWidth(1), pictureArr[i3].getPlaneHeight(1), 1, i15, iArr2[1], 0, i22, mvectDecode, 0);
        predictPlane(pictureArr[i3].getPlaneData(2), i20, i21, pictureArr[i3].getPlaneWidth(2), pictureArr[i3].getPlaneHeight(2), 1, i15, iArr2[2], 0, i22, mvectDecode, 0);
        int i23 = i11 + (dpXField / i8);
        dpXField = i13 + (dpYField / i7);
        i15 = i16;
        predictPlane(pictureArr[i16].getPlaneData(i19), i9 + dpXField, i10 + dpYField, pictureArr[i16].getPlaneWidth(i19), pictureArr[i16].getPlaneHeight(i19), 1, i15, iArr3[i19], 0, 16, 16, 0);
        i21 = dpXField;
        i22 = i6;
        mvectDecode = i5;
        i7 = 1;
        predictPlane(pictureArr[i16].getPlaneData(1), i23, i21, pictureArr[i16].getPlaneWidth(1), pictureArr[i16].getPlaneHeight(1), 1, i15, iArr3[1], 0, i22, mvectDecode, 0);
        predictPlane(pictureArr[i16].getPlaneData(2), i23, i21, pictureArr[i16].getPlaneWidth(2), pictureArr[i16].getPlaneHeight(2), 1, i15, iArr3[2], 0, i22, mvectDecode, 0);
        readVLC2 = i19;
        while (readVLC2 < 3) {
            i21 = i19;
            while (i19 < iArr[readVLC2].length) {
                iArr[readVLC2][i19] = ((iArr2[readVLC2][i19] + iArr3[readVLC2][i19]) + 1) >> 1;
                i19++;
            }
            readVLC2++;
            i19 = i21;
        }
        i21 = i19;
        int[] iArr4 = r13.mvPred[i7][i21];
        r13.mvPred[i21][i21][i21] = i18;
        iArr4[i21] = i18;
        iArr4 = r13.mvPred[i7][i21];
        r13.mvPred[i21][i21][i7] = i17;
        iArr4[i7] = i17;
    }

    private void predict16x8MC(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr, int i4, int i5) {
        int read1Bit = bitReader.read1Bit();
        predictGeneric(pictureArr[read1Bit], i, i2 + i4, bitReader, i3, iArr, i4, 16, 8, 1, read1Bit, 0, i5, 0);
    }

    protected void predict16x16Field(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        int read1Bit = bitReader.read1Bit();
        predictGeneric(pictureArr[read1Bit], i, i2, bitReader, i3, iArr, 0, 16, 16, 1, read1Bit, 0, 0, 0);
        this.mvPred[1][i3][0] = this.mvPred[0][i3][0];
        this.mvPred[1][i3][1] = this.mvPred[0][i3][1];
    }

    private void predict16x16DualPrimeFrame(Picture[] pictureArr, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        BitReader bitReader2 = bitReader;
        int mvectDecode = mvectDecode(bitReader2, this.fCode[0][0], this.mvPred[0][0][0]);
        int readVLC = MPEGConst.vlcDualPrime.readVLC(bitReader2) - 1;
        int mvectDecode2 = mvectDecode(bitReader2, this.fCode[0][1], this.mvPred[0][0][1] >> 1);
        int readVLC2 = MPEGConst.vlcDualPrime.readVLC(bitReader2) - 1;
        int i4 = this.topFieldFirst ? 1 : 3;
        int i5 = (((mvectDecode * i4) + (mvectDecode > 0 ? 1 : 0)) >> 1) + readVLC;
        int i6 = ((((mvectDecode2 * i4) + (mvectDecode2 > 0 ? 1 : 0)) >> 1) + readVLC2) - 1;
        i4 = 4 - i4;
        int i7 = (((mvectDecode * i4) + (mvectDecode > 0 ? 1 : 0)) >> 1) + readVLC;
        int i8 = ((((i4 * mvectDecode2) + (mvectDecode2 > 0 ? 1 : 0)) >> 1) + readVLC2) + 1;
        int i9 = r13.chromaFormat == 1 ? 1 : 0;
        int i10 = r13.chromaFormat == 3 ? 0 : 1;
        int i11 = r13.chromaFormat == 1 ? 2 : 1;
        int i12 = r13.chromaFormat == 3 ? 1 : 2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{3, 256});
        int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{3, 256});
        int i13 = i << 1;
        int i14 = i13 + mvectDecode;
        int i15 = i2 + mvectDecode2;
        int i16 = i13 >> i10;
        int i17 = i16 + (mvectDecode / i12);
        int i18 = i2 >> i9;
        int i19 = i18 + (mvectDecode2 / i11);
        int i20 = 0;
        predictPlane(pictureArr[0].getPlaneData(0), i14, i15, pictureArr[0].getPlaneWidth(0), pictureArr[0].getPlaneHeight(0), 1, 0, iArr2[0], 0, 16, 8, 1);
        i10 = 16 >> i10;
        i9 = 8 >> i9;
        i4 = i17;
        int i21 = i19;
        int i22 = i10;
        int i23 = i9;
        predictPlane(pictureArr[i20].getPlaneData(1), i4, i21, pictureArr[i20].getPlaneWidth(1), pictureArr[i20].getPlaneHeight(1), 1, 0, iArr2[1], 0, i22, i23, 1);
        predictPlane(pictureArr[i20].getPlaneData(2), i4, i21, pictureArr[i20].getPlaneWidth(2), pictureArr[i20].getPlaneHeight(2), 1, 0, iArr2[2], 0, i22, i23, 1);
        int[] planeData = pictureArr[1].getPlaneData(i20);
        int planeWidth = pictureArr[1].getPlaneWidth(i20);
        int planeHeight = pictureArr[1].getPlaneHeight(i20);
        int[] iArr4 = iArr2[i20];
        i20 = 1;
        predictPlane(planeData, i14, i15, planeWidth, planeHeight, 1, 1, iArr4, 1, 16, 8, 1);
        i4 = i17;
        i21 = i19;
        i22 = i10;
        i23 = i9;
        predictPlane(pictureArr[i20].getPlaneData(i20), i4, i21, pictureArr[i20].getPlaneWidth(i20), pictureArr[i20].getPlaneHeight(i20), 1, 1, iArr2[i20], 1, i22, i23, 1);
        predictPlane(pictureArr[i20].getPlaneData(2), i4, i21, pictureArr[i20].getPlaneWidth(2), pictureArr[i20].getPlaneHeight(2), 1, 1, iArr2[2], 1, i22, i23, 1);
        i4 = i13 + i5;
        i21 = i2 + i6;
        i5 = i16 + (i5 / i12);
        i6 = i18 + (i6 / i11);
        predictPlane(pictureArr[i20].getPlaneData(0), i4, i21, pictureArr[i20].getPlaneWidth(0), pictureArr[i20].getPlaneHeight(0), 1, 1, iArr3[0], 0, 16, 8, 1);
        i4 = i5;
        i21 = i6;
        i22 = i10;
        i23 = i9;
        predictPlane(pictureArr[i20].getPlaneData(i20), i4, i21, pictureArr[i20].getPlaneWidth(i20), pictureArr[i20].getPlaneHeight(i20), 1, 1, iArr3[i20], 0, i22, i23, 1);
        predictPlane(pictureArr[i20].getPlaneData(2), i4, i21, pictureArr[i20].getPlaneWidth(2), pictureArr[i20].getPlaneHeight(2), 1, 1, iArr3[2], 0, i22, i23, 1);
        i21 = i2 + i8;
        i5 = i16 + (i7 / i12);
        i6 = i18 + (i8 / i11);
        i8 = 0;
        predictPlane(pictureArr[0].getPlaneData(0), i13 + i7, i21, pictureArr[0].getPlaneWidth(0), pictureArr[0].getPlaneHeight(0), 1, 0, iArr3[0], 1, 16, 8, 1);
        i21 = i6;
        i22 = i10;
        i23 = i9;
        predictPlane(pictureArr[i8].getPlaneData(i20), i5, i21, pictureArr[i8].getPlaneWidth(i20), pictureArr[i8].getPlaneHeight(i20), 1, 0, iArr3[i20], 1, i22, i23, 1);
        predictPlane(pictureArr[i8].getPlaneData(2), i5, i21, pictureArr[i8].getPlaneWidth(2), pictureArr[i8].getPlaneHeight(2), 1, 0, iArr3[2], 1, i22, i23, 1);
        for (readVLC2 = i8; readVLC2 < 3; readVLC2++) {
            for (i4 = i8; i4 < iArr[readVLC2].length; i4++) {
                iArr[readVLC2][i4] = ((iArr2[readVLC2][i4] + iArr3[readVLC2][i4]) + i20) >> i20;
            }
        }
        int[] iArr5 = r13.mvPred[i20][i8];
        r13.mvPred[i8][i8][i8] = mvectDecode;
        iArr5[i8] = mvectDecode;
        iArr5 = r13.mvPred[i20][i8];
        i4 = mvectDecode2 << 1;
        r13.mvPred[i8][i8][i20] = i4;
        iArr5[i20] = i4;
    }

    protected void predict16x16Frame(Picture picture, int i, int i2, BitReader bitReader, int i3, int[][] iArr) {
        predictGeneric(picture, i, i2, bitReader, i3, iArr, 0, 16, 16, 0, 0, 0, 0, 0);
        this.mvPred[1][i3][0] = this.mvPred[0][i3][0];
        this.mvPred[1][i3][1] = this.mvPred[0][i3][1];
    }

    private final int mvectDecode(BitReader bitReader, int i, int i2) {
        int readVLC = MPEGConst.vlcMotionCode.readVLC(bitReader);
        if (readVLC == 0) {
            return i2;
        }
        if (readVLC < 0) {
            return 65535;
        }
        int read1Bit = bitReader.read1Bit();
        i--;
        if (i > 0) {
            readVLC = (bitReader.readNBit(i) | ((readVLC - 1) << i)) + 1;
        }
        if (read1Bit != 0) {
            readVLC = -readVLC;
        }
        return sign_extend(readVLC + i2, 5 + i);
    }

    protected void predictGeneric(Picture picture, int i, int i2, BitReader bitReader, int i3, int[][] iArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        BitReader bitReader2 = bitReader;
        int mvectDecode = mvectDecode(bitReader2, this.fCode[i3][0], this.mvPred[i10][i3][0]);
        int mvectDecode2 = mvectDecode(bitReader2, this.fCode[i3][1], this.mvPred[i10][i3][1] >> i11);
        predictMB(picture, i << 1, mvectDecode, i2 << 1, mvectDecode2, i5, i6, i7, i8, iArr, i4, i9);
        this.mvPred[i10][i3][0] = mvectDecode;
        this.mvPred[i10][i3][1] = mvectDecode2 << i11;
    }

    private void predictFieldInFrame(Picture picture, int i, int i2, int[][] iArr, BitReader bitReader, int i3, int i4) {
        int i5 = i4;
        int i6 = i2 >> 1;
        int read1Bit = bitReader.read1Bit();
        int i7 = i5;
        predictGeneric(picture, i, i6, bitReader, i3, iArr, 0, 16, 8, 1, read1Bit, 1, 0, 1);
        if (i7 != 0) {
            if (i7 != 1) {
                this.mvPred[1][i3][0] = this.mvPred[0][i3][0];
                this.mvPred[1][i3][1] = this.mvPred[0][i3][1];
                predictMB(picture, this.mvPred[1][i3][0], 0, this.mvPred[1][i3][1], 0, 16, 8, 1, 1 - read1Bit, iArr, 1, 1);
                return;
            }
        }
        predictGeneric(picture, i, i6, bitReader, i3, iArr, 1, 16, 8, 1, bitReader.read1Bit(), 1, 1, 1);
    }

    public void predictMB(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[][] iArr, int i9, int i10) {
        Picture picture2 = picture;
        int i11 = this.chromaFormat == 1 ? 1 : 0;
        int i12 = r13.chromaFormat == 3 ? 0 : 1;
        int i13 = r13.chromaFormat == 1 ? 2 : 1;
        int i14 = r13.chromaFormat == 3 ? 1 : 2;
        int i15 = i7;
        int i16 = i8;
        int i17 = i9;
        int i18 = 1;
        int i19 = i10;
        predictPlane(picture2.getPlaneData(0), i + i2, i3 + i4, picture2.getPlaneWidth(0), picture2.getPlaneHeight(0), i15, i16, iArr[0], i17, i5, i6, i19);
        int i20 = (i >> i12) + (i2 / i14);
        int i21 = (i3 >> i11) + (i4 / i13);
        int i22 = i5 >> i12;
        int i23 = i6 >> i11;
        predictPlane(picture2.getPlaneData(i18), i20, i21, picture2.getPlaneWidth(i18), picture2.getPlaneHeight(i18), i15, i16, iArr[i18], i17, i22, i23, i19);
        predictPlane(picture2.getPlaneData(2), i20, i21, picture2.getPlaneWidth(2), picture2.getPlaneHeight(2), i15, i16, iArr[2], i17, i22, i23, i19);
    }

    public void predict16x16NoMV(Picture picture, int i, int i2, int i3, int i4, int[][] iArr) {
        MPEGPred mPEGPred = this;
        int i5 = i3;
        if (i5 == 3) {
            predictMB(picture, i << 1, mPEGPred.mvPred[0][i4][0], i2 << 1, mPEGPred.mvPred[0][i4][1], 16, 16, 0, 0, iArr, 0, 0);
            return;
        }
        predictMB(picture, i << 1, mPEGPred.mvPred[0][i4][0], i2 << 1, mPEGPred.mvPred[0][i4][1], 16, 16, 1, i5 - 1, iArr, 0, 0);
    }

    public void reset() {
        int[] iArr = this.mvPred[0][0];
        int[] iArr2 = this.mvPred[0][0];
        int[] iArr3 = this.mvPred[0][1];
        int[] iArr4 = this.mvPred[0][1];
        int[] iArr5 = this.mvPred[1][0];
        int[] iArr6 = this.mvPred[1][0];
        int[] iArr7 = this.mvPred[1][1];
        this.mvPred[1][1][1] = 0;
        iArr7[0] = 0;
        iArr6[1] = 0;
        iArr5[0] = 0;
        iArr4[1] = 0;
        iArr3[0] = 0;
        iArr2[1] = 0;
        iArr[0] = 0;
    }
}
