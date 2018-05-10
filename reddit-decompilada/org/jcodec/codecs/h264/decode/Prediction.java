package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Const.PartPred;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.PredictionWeightTable;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.tools.MathUtil;

public class Prediction {
    private SliceHeader sh;

    public Prediction(SliceHeader sliceHeader) {
        this.sh = sliceHeader;
    }

    public void mergePrediction(int i, int i2, PartPred partPred, int i3, int[] iArr, int[] iArr2, int i4, int i5, int i6, int i7, int[] iArr3, Frame[][] frameArr, Frame frame) {
        int i8 = i;
        int i9 = i2;
        PictureParameterSet pictureParameterSet = this.sh.pps;
        if (this.sh.slice_type != SliceType.P) {
            PartPred partPred2;
            if (!pictureParameterSet.weighted_pred_flag || r14.sh.pps.weighted_bipred_idc == 0) {
                partPred2 = partPred;
            } else {
                if (r14.sh.pps.weighted_bipred_idc == 2) {
                    partPred2 = partPred;
                    if (partPred2 != PartPred.Bi) {
                    }
                } else {
                    partPred2 = partPred;
                }
                int i10;
                int i11;
                if (r14.sh.pps.weighted_bipred_idc == 1) {
                    int i12;
                    int i13;
                    PredictionWeightTable predictionWeightTable = r14.sh.pred_weight_table;
                    if (i8 == -1) {
                        i10 = 0;
                    } else {
                        i10 = i3 == 0 ? predictionWeightTable.luma_weight[0][i8] : predictionWeightTable.chroma_weight[0][i3 - 1][i8];
                    }
                    if (i9 == -1) {
                        i11 = 0;
                    } else {
                        i11 = i3 == 0 ? predictionWeightTable.luma_weight[1][i9] : predictionWeightTable.chroma_weight[1][i3 - 1][i9];
                    }
                    if (i8 == -1) {
                        i12 = 0;
                    } else {
                        i12 = i3 == 0 ? predictionWeightTable.luma_offset[0][i8] : predictionWeightTable.chroma_offset[0][i3 - 1][i8];
                    }
                    if (i9 == -1) {
                        i13 = 0;
                    } else {
                        i13 = i3 == 0 ? predictionWeightTable.luma_offset[1][i9] : predictionWeightTable.chroma_offset[1][i3 - 1][i9];
                    }
                    mergeWeight(iArr, iArr2, i5, partPred2, i4, i6, i7, i3 == 0 ? predictionWeightTable.luma_log2_weight_denom : predictionWeightTable.chroma_log2_weight_denom, i10, i11, i12, i13, iArr3);
                    return;
                }
                int clip = MathUtil.clip(frame.getPOC() - frameArr[0][i8].getPOC(), -128, 127);
                int clip2 = MathUtil.clip(frameArr[1][i9].getPOC() - frameArr[0][i8].getPOC(), -128, 127);
                i10 = 32;
                if (clip2 != 0 && frameArr[0][i8].isShortTerm() && frameArr[1][i9].isShortTerm()) {
                    i8 = MathUtil.clip(((clip * ((16384 + Math.abs(clip2 / 2)) / clip2)) + 32) >> 6, -1024, 1023) >> 2;
                    if (i8 >= -64 && i8 <= 128) {
                        i11 = i8;
                        i10 = 64 - i8;
                        mergeWeight(iArr, iArr2, i5, partPred2, i4, i6, i7, 5, i10, i11, 0, 0, iArr3);
                        return;
                    }
                }
                i11 = 32;
                mergeWeight(iArr, iArr2, i5, partPred2, i4, i6, i7, 5, i10, i11, 0, 0, iArr3);
                return;
            }
            mergeAvg(iArr, iArr2, i5, partPred2, i4, i6, i7, iArr3);
        } else if (!pictureParameterSet.weighted_pred_flag || r14.sh.pred_weight_table == null) {
            copyPrediction(iArr, i5, i4, i6, i7, iArr3);
        } else {
            PredictionWeightTable predictionWeightTable2 = r14.sh.pred_weight_table;
            weight(iArr, i5, i4, i6, i7, i3 == 0 ? predictionWeightTable2.luma_log2_weight_denom : predictionWeightTable2.chroma_log2_weight_denom, i3 == 0 ? predictionWeightTable2.luma_weight[0][i8] : predictionWeightTable2.chroma_weight[0][i3 - 1][i8], i3 == 0 ? predictionWeightTable2.luma_offset[0][i8] : predictionWeightTable2.chroma_offset[0][i3 - 1][i8], iArr3);
        }
    }

    private void mergeAvg(int[] iArr, int[] iArr2, int i, PartPred partPred, int i2, int i3, int i4, int[] iArr3) {
        if (partPred == PartPred.Bi) {
            mergePrediction(iArr, iArr2, i, partPred, i2, i3, i4, iArr3);
        } else if (partPred == PartPred.L0) {
            copyPrediction(iArr, i, i2, i3, i4, iArr3);
        } else {
            if (partPred == PartPred.L1) {
                copyPrediction(iArr2, i, i2, i3, i4, iArr3);
            }
        }
    }

    private void mergeWeight(int[] iArr, int[] iArr2, int i, PartPred partPred, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr3) {
        PartPred partPred2 = partPred;
        if (partPred2 == PartPred.L0) {
            weight(iArr, i, i2, i3, i4, i5, i6, i8, iArr3);
        } else if (partPred2 == PartPred.L1) {
            weight(iArr2, i, i2, i3, i4, i5, i7, i9, iArr3);
        } else {
            if (partPred2 == PartPred.Bi) {
                weightPrediction(iArr, iArr2, i, i2, i3, i4, i5, i6, i7, i8, i9, iArr3);
            }
        }
    }

    private void copyPrediction(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2) {
        int i5 = i2;
        i2 = 0;
        while (i2 < i4) {
            int i6 = i5;
            i5 = 0;
            while (i5 < i3) {
                iArr2[i6] = iArr[i6];
                i5++;
                i6++;
            }
            i2++;
            i5 = (i - i3) + i6;
        }
    }

    private void mergePrediction(int[] iArr, int[] iArr2, int i, PartPred partPred, int i2, int i3, int i4, int[] iArr3) {
        int i5 = i2;
        i2 = 0;
        while (i2 < i4) {
            int i6 = i5;
            i5 = 0;
            while (i5 < i3) {
                iArr3[i6] = ((iArr[i6] + iArr2[i6]) + 1) >> 1;
                i5++;
                i6++;
            }
            i2++;
            i5 = (i - i3) + i6;
        }
    }

    private void weightPrediction(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr3) {
        int i10 = i3;
        int i11 = 1 << i5;
        int i12 = ((i8 + i9) + 1) >> 1;
        int i13 = i5 + 1;
        int i14 = i2;
        int i15 = i4;
        int i16 = 0;
        while (i16 < i15) {
            int i17 = i14;
            i14 = 0;
            while (i14 < i10) {
                iArr3[i17] = MathUtil.clip(((((iArr[i17] * i6) + (iArr2[i17] * i7)) + i11) >> i13) + i12, 0, 255);
                i14++;
                i17++;
            }
            i16++;
            i14 = i17 + (i - i10);
        }
    }

    private void weight(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr2) {
        int i8 = 1 << (i5 - 1);
        if (i5 > 0) {
            int i9 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i10 = i9;
                i9 = 0;
                while (i9 < i3) {
                    iArr2[i10] = MathUtil.clip((((iArr[i10] * i6) + i8) >> i5) + i7, 0, 255);
                    i9++;
                    i10++;
                }
                i2++;
                i9 = (i - i3) + i10;
            }
            return;
        }
        i5 = i2;
        i2 = 0;
        while (i2 < i4) {
            i8 = i5;
            i5 = 0;
            while (i5 < i3) {
                iArr2[i8] = MathUtil.clip((iArr[i8] * i6) + i7, 0, 255);
                i5++;
                i8++;
            }
            i2++;
            i5 = (i - i3) + i8;
        }
    }
}
