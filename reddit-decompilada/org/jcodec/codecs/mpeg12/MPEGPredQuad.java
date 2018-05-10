package org.jcodec.codecs.mpeg12;

import org.jcodec.common.tools.MathUtil;

public class MPEGPredQuad extends MPEGPred {
    public MPEGPredQuad(MPEGPred mPEGPred) {
        super(mPEGPred);
    }

    public void predictPlane(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr2, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        Object obj;
        int[] iArr3;
        int i13 = i >> 2;
        int i14 = i2 >> 2;
        if (i13 < 0 || i14 < 0) {
            i11 = i3;
        } else {
            i11 = i3;
            if (i13 + i8 < i11) {
                i12 = i4;
                if (((i14 + i9) << i5) < i12) {
                    obj = 1;
                    if ((i & 3) == 0) {
                        if ((i2 & 3) == 0) {
                            if (obj != null) {
                                predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                            } else {
                                predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                            }
                        } else if (obj != null) {
                            predictOddEvenSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        } else {
                            predictOddEvenUnSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        }
                    } else if ((i2 & 3) == 0) {
                        if (obj != null) {
                            predictEvenOddSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                            return;
                        }
                        predictEvenOddUnSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else if (obj != null) {
                        iArr3 = iArr;
                        predictOddOddSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else {
                        iArr3 = iArr;
                        predictOddOddUnSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    }
                }
                obj = null;
                if ((i & 3) == 0) {
                    if ((i2 & 3) == 0) {
                        if (obj != null) {
                            iArr3 = iArr;
                            predictOddOddUnSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        }
                        iArr3 = iArr;
                        predictOddOddSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else if (obj != null) {
                        predictEvenOddUnSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    } else {
                        predictEvenOddSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                        return;
                    }
                } else if ((i2 & 3) == 0) {
                    if (obj != null) {
                        predictOddEvenUnSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                    }
                    predictOddEvenSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                } else if (obj != null) {
                    predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                } else {
                    predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                }
            }
        }
        i12 = i4;
        obj = null;
        if ((i & 3) == 0) {
            if ((i2 & 3) == 0) {
                if (obj != null) {
                    predictEvenEvenSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                } else {
                    predictEvenEvenUnSafe(iArr, i13, i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                }
            } else if (obj != null) {
                predictOddEvenSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            } else {
                predictOddEvenUnSafe(iArr, i13, i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
            }
        } else if ((i2 & 3) == 0) {
            if (obj != null) {
                predictEvenOddSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
                return;
            }
            predictEvenOddUnSafe(iArr, i13, i - (i13 << 2), i14, i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
        } else if (obj != null) {
            iArr3 = iArr;
            predictOddOddSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
        } else {
            iArr3 = iArr;
            predictOddOddUnSafe(iArr3, i13, i - (i13 << 2), i14, i2 - (i14 << 2), i11, i12, i5, i6, iArr2, i7, i8, i9, i10);
        }
    }

    private void predictOddOddUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr2, int i9, int i10, int i11, int i12) {
        int i13 = i10;
        int i14 = i13 * i9;
        int i15 = i12 * i13;
        int i16 = i11;
        int i17 = 0;
        while (i17 < i16) {
            int i18 = i17 + i3;
            int i19 = (i18 << i7) + i8;
            int i20 = ((i18 + 1) << i7) + i8;
            int i21 = i14;
            int i22 = 0;
            while (i22 < i13) {
                int i23 = i22 + i;
                int i24 = i21 + 1;
                int i25 = i23 + 1;
                int i26 = i22;
                int i27 = i17;
                iArr2[i21] = getPix4(iArr, i5, i6, i23, i19, i25, i19, i23, i20, i25, i20, i7, i8, i2, i4);
                i22 = i26 + 1;
                i13 = i10;
                i16 = i11;
                i21 = i24;
                i17 = i27;
            }
            i14 = i21 + i15;
            i17++;
            i13 = i10;
            i16 = i11;
        }
    }

    protected int getPix4(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        int i15 = (i2 - (1 << i11)) + i12;
        int i16 = i - 1;
        int i17 = 4 - i13;
        int i18 = 4 - i14;
        return ((((((iArr[(MathUtil.clip(i4, 0, i15) * i) + MathUtil.clip(i3, 0, i16)] * i17) * i18) + ((iArr[(MathUtil.clip(i6, 0, i15) * i) + MathUtil.clip(i5, 0, i16)] * i13) * i18)) + ((iArr[(MathUtil.clip(i8, 0, i15) * i) + MathUtil.clip(i7, 0, i16)] * i17) * i14)) + ((iArr[(MathUtil.clip(i10, 0, i15) * i) + MathUtil.clip(i9, 0, i16)] * i13) * i14)) + 8) >> 4;
    }

    private void predictOddOddSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr2, int i9, int i10, int i11, int i12) {
        int i13 = i10;
        int i14 = i5 << i7;
        int i15 = i14 - i13;
        int i16 = i12 * i13;
        int i17 = 4 - i2;
        int i18 = 4 - i4;
        int i19 = (((i3 << i7) + i8) * i5) + i;
        int i20 = i13 * i9;
        int i21 = i11;
        for (int i22 = 0; i22 < i21; i22++) {
            int i23 = i19;
            i19 = 0;
            while (i19 < i13) {
                int i24 = i20 + 1;
                int i25 = i23 + 1;
                i23 += i14;
                iArr2[i20] = ((((((iArr[i23] * i17) * i18) + ((iArr[i25] * i2) * i18)) + ((iArr[i23] * i17) * i4)) + ((iArr[i23 + 1] * i2) * i4)) + 8) >> 4;
                i19++;
                i20 = i24;
                i23 = i25;
            }
            i19 = i23 + i15;
            i20 += i16;
        }
    }

    protected int getPix2(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i - 1;
        i2 = (i2 - (1 << i7)) + i8;
        return (((iArr[(MathUtil.clip(i4, 0, i2) * i) + MathUtil.clip(i3, 0, i10)] * (4 - i9)) + (iArr[(MathUtil.clip(i6, 0, i2) * i) + MathUtil.clip(i5, 0, i10)] * i9)) + 2) >> 2;
    }

    private void predictEvenOddUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int i11) {
        int i12 = i9;
        int i13 = i11 * i12;
        int i14 = i12 * i8;
        int i15 = i10;
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = ((i16 + i3) << i6) + i7;
            int i18 = i14;
            i14 = 0;
            while (i14 < i12) {
                int i19 = i18 + 1;
                int i20 = i14 + i;
                iArr2[i18] = getPix2(iArr, i4, i5, i20, i17, i20 + 1, i17, i6, i7, i2);
                i14++;
                i18 = i19;
            }
            i14 = i18 + i13;
        }
    }

    private void predictEvenOddSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int i11) {
        int i12 = i9;
        int i13 = (i4 << i6) - i12;
        int i14 = i11 * i12;
        int i15 = 4 - i2;
        int i16 = (((i3 << i6) + i7) * i4) + i;
        int i17 = i12 * i8;
        int i18 = i10;
        for (int i19 = 0; i19 < i18; i19++) {
            int i20 = i16;
            i16 = 0;
            while (i16 < i12) {
                int i21 = i17 + 1;
                i20++;
                iArr2[i17] = (((iArr[i20] * i15) + (iArr[i20] * i2)) + 2) >> 2;
                i16++;
                i17 = i21;
            }
            i16 = i20 + i13;
            i17 += i14;
        }
    }

    private void predictOddEvenUnSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int i11) {
        int i12 = i9;
        int i13 = i12 * i8;
        int i14 = i11 * i12;
        int i15 = i10;
        int i16 = 0;
        while (i16 < i15) {
            int i17 = i16 + i2;
            int i18 = (i17 << i6) + i7;
            int i19 = ((i17 + 1) << i6) + i7;
            int i20 = i13;
            int i21 = 0;
            while (i21 < i12) {
                int i22 = i20 + 1;
                int i23 = i21 + i;
                int i24 = i21;
                int i25 = i16;
                iArr2[i20] = getPix2(iArr, i4, i5, i23, i18, i23, i19, i6, i7, i3);
                i21 = i24 + 1;
                i15 = i10;
                i20 = i22;
                i16 = i25;
            }
            i13 = i20 + i14;
            i16++;
            i15 = i10;
        }
    }

    private void predictOddEvenSafe(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr2, int i8, int i9, int i10, int i11) {
        int i12 = i9;
        int i13 = i4 << i6;
        int i14 = i13 - i12;
        int i15 = i11 * i12;
        int i16 = 4 - i3;
        int i17 = (((i2 << i6) + i7) * i4) + i;
        int i18 = i12 * i8;
        int i19 = i10;
        for (int i20 = 0; i20 < i19; i20++) {
            int i21 = i17;
            i17 = 0;
            while (i17 < i12) {
                int i22 = i18 + 1;
                iArr2[i18] = (((iArr[i21] * i16) + (iArr[i21 + i13] * i3)) + 2) >> 2;
                i21++;
                i17++;
                i18 = i22;
            }
            i17 = i21 + i14;
            i18 += i15;
        }
    }
}
