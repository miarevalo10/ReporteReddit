package org.jcodec.codecs.vp8;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.codecs.vp8.VP8Util.PLANE;
import org.jcodec.codecs.vp8.VP8Util.QuantizationParams;
import org.jcodec.codecs.vp8.VP8Util.SubblockConstants;

public class Macroblock {
    public final int Rrow;
    public int chromaMode;
    public final int column;
    public boolean debug = true;
    public int filterLevel;
    public int lumaMode;
    public int segment = 0;
    public int skipCoeff;
    boolean skipFilter;
    public final Subblock[][] uSubblocks = ((Subblock[][]) Array.newInstance(Subblock.class, new int[]{2, 2}));
    public final Subblock[][] vSubblocks = ((Subblock[][]) Array.newInstance(Subblock.class, new int[]{2, 2}));
    public final Subblock y2 = new Subblock(0, 0, PLANE.Y2);
    public final Subblock[][] ySubblocks = ((Subblock[][]) Array.newInstance(Subblock.class, new int[]{4, 4}));

    public class Subblock {
        private int col;
        public int mode;
        private PLANE plane;
        public int[] predict;
        public int[] residue;
        private int row;
        public boolean someValuePresent;
        private int[] tokens = new int[16];
        public int[] val;

        public Subblock(int i, int i2, PLANE plane) {
            this.row = i;
            this.col = i2;
            this.plane = plane;
        }

        public void predict(Macroblock[][] macroblockArr) {
            Subblock above = getAbove(this.plane, macroblockArr);
            Subblock left = getLeft(this.plane, macroblockArr);
            int[] iArr = new int[4];
            int[] iArr2 = new int[4];
            int[] iArr3 = above.val != null ? above.val : VP8Util.PRED_BLOCK_127;
            iArr[0] = iArr3[12];
            iArr[1] = iArr3[13];
            iArr[2] = iArr3[14];
            iArr[3] = iArr3[15];
            iArr3 = left.val != null ? left.val : VP8Util.pickDefaultPrediction(this.mode);
            iArr2[0] = iArr3[3];
            iArr2[1] = iArr3[7];
            iArr2[2] = iArr3[11];
            iArr2[3] = iArr3[15];
            Subblock left2 = above.getLeft(this.plane, macroblockArr);
            int i = 127;
            if (left.val != null || above.val != null) {
                if (above.val != null) {
                    i = left2.val != null ? left2.val[15] : VP8Util.pickDefaultPrediction(this.mode)[15];
                }
            }
            macroblockArr = getAboveRightLowestRow(macroblockArr);
            switch (this.mode) {
                case 0:
                    this.predict = VP8Util.predictDC(iArr, iArr2);
                    return;
                case 1:
                    this.predict = VP8Util.predictTM(iArr, iArr2, i);
                    return;
                case 2:
                    this.predict = VP8Util.predictVE(iArr, i, macroblockArr);
                    return;
                case 3:
                    this.predict = VP8Util.predictHE(iArr2, i);
                    return;
                case 4:
                    this.predict = VP8Util.predictLD(iArr, macroblockArr);
                    return;
                case 5:
                    this.predict = VP8Util.predictRD(iArr, iArr2, i);
                    return;
                case 6:
                    this.predict = VP8Util.predictVR(iArr, iArr2, i);
                    return;
                case 7:
                    this.predict = VP8Util.predictVL(iArr, macroblockArr);
                    return;
                case 8:
                    this.predict = VP8Util.predictHD(iArr, iArr2, i);
                    return;
                case 9:
                    this.predict = VP8Util.predictHU(iArr2);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("TODO: unknowwn mode: ");
                    stringBuilder.append(this.mode);
                    throw new UnsupportedOperationException(stringBuilder.toString());
            }
        }

        public void reconstruct() {
            int[] iArr = this.val != null ? this.val : this.predict;
            int[] iArr2 = new int[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = (i * 4) + i2;
                    iArr2[i3] = QuantizationParams.clip255(this.residue[i3] + iArr[i3]);
                }
            }
            this.val = iArr2;
        }

        public Subblock getAbove(PLANE plane, Macroblock[][] macroblockArr) {
            if (this.row > 0) {
                if (PLANE.Y1.equals(this.plane)) {
                    return Macroblock.this.ySubblocks[this.row - 1][this.col];
                }
                if (PLANE.U.equals(this.plane)) {
                    return Macroblock.this.uSubblocks[this.row - 1][this.col];
                }
                if (PLANE.V.equals(this.plane)) {
                    return Macroblock.this.vSubblocks[this.row - 1][this.col];
                }
            }
            int i = this.col;
            Macroblock macroblock = macroblockArr[Macroblock.this.Rrow - 1][Macroblock.this.column];
            if (plane == PLANE.Y2) {
                while (macroblock.lumaMode == 4) {
                    macroblock = macroblockArr[macroblock.Rrow - 1][macroblock.column];
                }
            }
            return macroblock.getBottomSubblock(i, plane);
        }

        public Subblock getLeft(PLANE plane, Macroblock[][] macroblockArr) {
            if (this.col > 0) {
                if (PLANE.Y1.equals(this.plane)) {
                    return Macroblock.this.ySubblocks[this.row][this.col - 1];
                }
                if (PLANE.U.equals(this.plane)) {
                    return Macroblock.this.uSubblocks[this.row][this.col - 1];
                }
                if (PLANE.V.equals(this.plane)) {
                    return Macroblock.this.vSubblocks[this.row][this.col - 1];
                }
            }
            int i = this.row;
            Macroblock macroblock = macroblockArr[Macroblock.this.Rrow][Macroblock.this.column - 1];
            if (plane == PLANE.Y2) {
                while (macroblock.lumaMode == 4) {
                    macroblock = macroblockArr[macroblock.Rrow][macroblock.column - 1];
                }
            }
            return macroblock.getRightSubBlock(i, plane);
        }

        private int[] getAboveRightLowestRow(Macroblock[][] macroblockArr) {
            Subblock subblock = this;
            while (PLANE.Y1.equals(subblock.plane)) {
                if (subblock.row == 0 && subblock.col < 3) {
                    macroblockArr = macroblockArr[Macroblock.this.Rrow - 1][Macroblock.this.column].ySubblocks[3][subblock.col + 1].val;
                } else if (subblock.row > 0 && subblock.col < 3) {
                    macroblockArr = Macroblock.this.ySubblocks[subblock.row - 1][subblock.col + 1].val;
                } else if (subblock.row == 0 && subblock.col == 3) {
                    Macroblock macroblock = macroblockArr[Macroblock.this.Rrow - 1][Macroblock.this.column + 1];
                    if (macroblock.column < macroblockArr[0].length - 1) {
                        macroblockArr = macroblock.ySubblocks[3][0].val;
                    } else {
                        int[] iArr = new int[16];
                        Arrays.fill(iArr, macroblock.Rrow == 0 ? 127 : macroblockArr[Macroblock.this.Rrow - 1][Macroblock.this.column].ySubblocks[3][3].val[15]);
                        macroblockArr = iArr;
                    }
                } else {
                    subblock = Macroblock.this.ySubblocks[0][3];
                }
                if (macroblockArr == null) {
                    macroblockArr = VP8Util.PRED_BLOCK_127;
                }
                return new int[]{macroblockArr[12], macroblockArr[13], macroblockArr[14], macroblockArr[15]};
            }
            throw new IllegalArgumentException("Decoder.getAboveRight: not implemented for Y2 and chroma planes");
        }

        public void decodeSubBlock(BooleanArithmeticDecoder booleanArithmeticDecoder, int[][][][] iArr, int i, int i2, boolean z) {
            int i3 = 0;
            this.someValuePresent = false;
            int i4 = i;
            int i5 = 0;
            int i6 = i5;
            i = 1;
            while (i != 11) {
                i = i5 + z;
                if (i >= 16) {
                    break;
                }
                int i7;
                boolean z2;
                boolean z3;
                int[] iArr2 = iArr[i2][SubblockConstants.vp8CoefBands[i]][i4];
                if (i6 == 0) {
                    i4 = booleanArithmeticDecoder.readTree(SubblockConstants.vp8CoefTree, iArr2);
                } else {
                    i4 = booleanArithmeticDecoder.readTreeSkip(SubblockConstants.vp8CoefTree, iArr2, 1);
                }
                i6 = decodeToken(booleanArithmeticDecoder, i4);
                if (i6 != 1) {
                    if (i6 != -1) {
                        if (i6 <= 1) {
                            if (i6 >= -1) {
                                if (i6 == 0) {
                                    i7 = 0;
                                    z2 = true;
                                } else {
                                    z2 = false;
                                    i7 = z2;
                                }
                                if (i4 == 11) {
                                    this.tokens[SubblockConstants.vp8defaultZigZag1d[i]] = i6;
                                }
                                i5++;
                                i = i4;
                                z3 = z2;
                                i4 = i7;
                            }
                        }
                        i7 = 2;
                        z2 = false;
                        if (i4 == 11) {
                            this.tokens[SubblockConstants.vp8defaultZigZag1d[i]] = i6;
                        }
                        i5++;
                        i = i4;
                        z3 = z2;
                        i4 = i7;
                    }
                }
                z2 = false;
                i7 = true;
                if (i4 == 11) {
                    this.tokens[SubblockConstants.vp8defaultZigZag1d[i]] = i6;
                }
                i5++;
                i = i4;
                z3 = z2;
                i4 = i7;
            }
            while (i3 < 16) {
                if (this.tokens[i3] != null) {
                    this.someValuePresent = true;
                }
                i3++;
            }
        }

        private int decodeToken(BooleanArithmeticDecoder booleanArithmeticDecoder, int i) {
            int DCTextra = i == 5 ? 5 + DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat1) : i;
            if (i == 6) {
                DCTextra = DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat2) + 7;
            }
            if (i == 7) {
                DCTextra = DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat3) + 11;
            }
            if (i == 8) {
                DCTextra = 19 + DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat4);
            }
            if (i == 9) {
                DCTextra = 35 + DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat5);
            }
            if (i == 10) {
                DCTextra = 67 + DCTextra(booleanArithmeticDecoder, SubblockConstants.Pcat6);
            }
            return (i == 0 || i == 11 || booleanArithmeticDecoder.decodeBit() <= null) ? DCTextra : -DCTextra;
        }

        private int DCTextra(BooleanArithmeticDecoder booleanArithmeticDecoder, int[] iArr) {
            int i = 0;
            int i2 = 0;
            do {
                i += booleanArithmeticDecoder.decodeBool(iArr[i2]) + i;
                i2++;
            } while (iArr[i2] > 0);
            return i;
        }

        public void dequantSubblock(int i, int i2, Integer num) {
            int[] iArr = new int[16];
            iArr[0] = this.tokens[0] * i;
            for (i = 1; i < 16; i++) {
                iArr[i] = this.tokens[i] * i2;
            }
            if (num != null) {
                iArr[0] = num.intValue();
            }
            this.residue = VP8DCT.decodeDCT(iArr);
        }
    }

    public Macroblock(int i, int i2) {
        this.Rrow = i;
        this.column = i2;
        for (i = 0; i < 4; i++) {
            for (i2 = 0; i2 < 4; i2++) {
                this.ySubblocks[i][i2] = new Subblock(i, i2, PLANE.Y1);
            }
        }
        for (i = 0; i < 2; i++) {
            for (i2 = 0; i2 < 2; i2++) {
                this.uSubblocks[i][i2] = new Subblock(i, i2, PLANE.U);
                this.vSubblocks[i][i2] = new Subblock(i, i2, PLANE.V);
            }
        }
    }

    public void dequantMacroBlock(Macroblock[][] macroblockArr, QuantizationParams quantizationParams) {
        int i;
        int i2;
        if (this.lumaMode != 4) {
            i = quantizationParams.y2AC;
            int[] iArr = new int[16];
            iArr[0] = this.y2.tokens[0] * quantizationParams.y2DC;
            for (i2 = 1; i2 < 16; i2++) {
                iArr[i2] = this.y2.tokens[i2] * i;
            }
            this.y2.residue = VP8DCT.decodeWHT(iArr);
            for (i = 0; i < 4; i++) {
                for (i2 = 0; i2 < 4; i2++) {
                    this.ySubblocks[i][i2].dequantSubblock(quantizationParams.yDC, quantizationParams.yAC, Integer.valueOf(this.y2.residue[(i * 4) + i2]));
                }
            }
            predictY(macroblockArr);
            predictUV(macroblockArr);
            for (macroblockArr = null; macroblockArr < 2; macroblockArr++) {
                for (i = 0; i < 2; i++) {
                    this.uSubblocks[macroblockArr][i].dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                    this.vSubblocks[macroblockArr][i].dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                }
            }
            reconstruct();
            return;
        }
        for (i = 0; i < 4; i++) {
            for (i2 = 0; i2 < 4; i2++) {
                Subblock subblock = this.ySubblocks[i][i2];
                subblock.dequantSubblock(quantizationParams.yDC, quantizationParams.yAC, null);
                subblock.predict(macroblockArr);
                subblock.reconstruct();
            }
        }
        predictUV(macroblockArr);
        for (macroblockArr = null; macroblockArr < 2; macroblockArr++) {
            for (i = 0; i < 2; i++) {
                Subblock subblock2 = this.uSubblocks[macroblockArr][i];
                subblock2.dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                subblock2.reconstruct();
            }
        }
        for (macroblockArr = null; macroblockArr < 2; macroblockArr++) {
            for (i = 0; i < 2; i++) {
                subblock2 = this.vSubblocks[macroblockArr][i];
                subblock2.dequantSubblock(quantizationParams.chromaDC, quantizationParams.chromaAC, null);
                subblock2.reconstruct();
            }
        }
    }

    public void reconstruct() {
        int i;
        int i2;
        for (i = 0; i < 4; i++) {
            for (i2 = 0; i2 < 4; i2++) {
                this.ySubblocks[i][i2].reconstruct();
            }
        }
        for (i = 0; i < 2; i++) {
            for (i2 = 0; i2 < 2; i2++) {
                this.uSubblocks[i][i2].reconstruct();
            }
        }
        for (i = 0; i < 2; i++) {
            for (i2 = 0; i2 < 2; i2++) {
                this.vSubblocks[i][i2].reconstruct();
            }
        }
    }

    public void predictUV(Macroblock[][] macroblockArr) {
        Macroblock macroblock = macroblockArr[this.Rrow - 1][this.column];
        Macroblock macroblock2 = macroblockArr[this.Rrow][this.column - 1];
        int i = 4;
        int i2;
        int i3;
        int i4;
        int i5;
        Subblock subblock;
        Subblock subblock2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Subblock subblock3;
        int i12;
        Subblock[] subblockArr;
        int[] iArr;
        int i13;
        switch (this.chromaMode) {
            case 0:
                int[] iArr2;
                int[] iArr3;
                int i14;
                Subblock subblock4;
                i2 = r0.column > 1 ? 1 : 0;
                i3 = r0.Rrow > 1 ? 1 : 0;
                i = 128;
                if (i3 == 0) {
                    if (i2 == 0) {
                        i2 = 128;
                        iArr2 = new int[16];
                        i4 = 0;
                        while (true) {
                            i5 = 4;
                            if (i4 >= 4) {
                                i3 = 0;
                                while (i3 < i5) {
                                    iArr2[(i4 * 4) + i3] = i;
                                    i3++;
                                    i5 = 4;
                                }
                                i4++;
                            } else {
                                iArr3 = new int[16];
                                for (i5 = 0; i5 < 4; i5++) {
                                    for (i14 = 0; i14 < 4; i14++) {
                                        iArr3[(i5 * 4) + i14] = i2;
                                    }
                                }
                                for (i2 = 0; i2 < 2; i2++) {
                                    for (i5 = 0; i5 < 2; i5++) {
                                        subblock = r0.uSubblocks[i2][i5];
                                        subblock2 = r0.vSubblocks[i2][i5];
                                        subblock.predict = iArr2;
                                        subblock2.predict = iArr3;
                                    }
                                }
                                return;
                            }
                        }
                    }
                }
                if (i3 != 0) {
                    i = 0;
                    i6 = 0;
                    i7 = 0;
                    while (i < 2) {
                        subblock4 = macroblock.uSubblocks[1][i];
                        Subblock subblock5 = macroblock.vSubblocks[1][i];
                        i8 = i7;
                        i7 = i6;
                        i6 = 0;
                        for (i9 = 4; i6 < i9; i9 = 4) {
                            i10 = 12 + i6;
                            i7 += subblock4.val[i10];
                            i8 += subblock5.val[i10];
                            i6++;
                        }
                        i++;
                        i6 = i7;
                        i7 = i8;
                    }
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                i11 = 3;
                if (i2 != 0) {
                    i14 = 0;
                    while (i14 < 2) {
                        subblock3 = macroblock2.uSubblocks[i14][1];
                        subblock4 = macroblock2.vSubblocks[i14][1];
                        i12 = i7;
                        i7 = i6;
                        i6 = 0;
                        for (i8 = 4; i6 < i8; i8 = 4) {
                            i9 = (i6 * 4) + 3;
                            i7 += subblock3.val[i9];
                            i12 += subblock4.val[i9];
                            i6++;
                        }
                        i14++;
                        i6 = i7;
                        i7 = i12;
                    }
                }
                if (i3 == 0) {
                    i11 = 2;
                }
                if (i2 != 0) {
                    i11++;
                }
                i2 = 1 << (i11 - 1);
                i = (i6 + i2) >> i11;
                i2 = (i7 + i2) >> i11;
                iArr2 = new int[16];
                i4 = 0;
                while (true) {
                    i5 = 4;
                    if (i4 >= 4) {
                        iArr3 = new int[16];
                        for (i5 = 0; i5 < 4; i5++) {
                            for (i14 = 0; i14 < 4; i14++) {
                                iArr3[(i5 * 4) + i14] = i2;
                            }
                        }
                        for (i2 = 0; i2 < 2; i2++) {
                            for (i5 = 0; i5 < 2; i5++) {
                                subblock = r0.uSubblocks[i2][i5];
                                subblock2 = r0.vSubblocks[i2][i5];
                                subblock.predict = iArr2;
                                subblock2.predict = iArr3;
                            }
                        }
                        return;
                    }
                    i3 = 0;
                    while (i3 < i5) {
                        iArr2[(i4 * 4) + i3] = i;
                        i3++;
                        i5 = 4;
                    }
                    i4++;
                }
            case 1:
                subblockArr = new Subblock[2];
                Subblock[] subblockArr2 = new Subblock[2];
                for (i3 = 0; i3 < 2; i3++) {
                    subblockArr[i3] = macroblock.uSubblocks[1][i3];
                    subblockArr2[i3] = macroblock.vSubblocks[1][i3];
                }
                for (i11 = 0; i11 < 2; i11++) {
                    i4 = 0;
                    while (i4 < 2) {
                        subblock = r0.uSubblocks[i11][i4];
                        subblock3 = r0.vSubblocks[i11][i4];
                        iArr = new int[16];
                        int[] iArr4 = new int[16];
                        i13 = 0;
                        while (true) {
                            i12 = 4;
                            if (i13 < 4) {
                                i8 = 0;
                                while (i8 < i12) {
                                    i12 = (i13 * 4) + i8;
                                    i10 = 127;
                                    iArr[i12] = subblockArr[i4].val != null ? subblockArr[i4].val[12 + i8] : 127;
                                    if (subblockArr2[i4].val != null) {
                                        i10 = subblockArr2[i4].val[12 + i8];
                                    }
                                    iArr4[i12] = i10;
                                    i8++;
                                    i12 = 4;
                                }
                                i13++;
                            } else {
                                subblock.predict = iArr;
                                subblock3.predict = iArr4;
                                i4++;
                            }
                        }
                    }
                }
                return;
            case 2:
                subblockArr = new Subblock[2];
                Subblock[] subblockArr3 = new Subblock[2];
                for (i3 = 0; i3 < 2; i3++) {
                    subblockArr[i3] = macroblock2.uSubblocks[i3][1];
                    subblockArr3[i3] = macroblock2.vSubblocks[i3][1];
                }
                for (i4 = 0; i4 < 2; i4++) {
                    i5 = 0;
                    while (i5 < 2) {
                        subblock = r0.uSubblocks[i4][i5];
                        subblock2 = r0.vSubblocks[i4][i5];
                        int[] iArr5 = new int[16];
                        iArr = new int[16];
                        i7 = 0;
                        while (true) {
                            i13 = 4;
                            if (i7 < 4) {
                                i12 = 0;
                                while (i12 < i13) {
                                    i13 = i7 * 4;
                                    i8 = i13 + i12;
                                    i10 = 129;
                                    iArr5[i8] = subblockArr[i4].val != null ? subblockArr[i4].val[i13 + 3] : 129;
                                    if (subblockArr3[i4].val != null) {
                                        i10 = subblockArr3[i4].val[i13 + 3];
                                    }
                                    iArr[i8] = i10;
                                    i12++;
                                    i13 = 4;
                                }
                                i7++;
                            } else {
                                subblock.predict = iArr5;
                                subblock2.predict = iArr;
                                i5++;
                            }
                        }
                    }
                }
                return;
            case 3:
                Macroblock macroblock3 = macroblockArr[r0.Rrow - 1][r0.column - 1];
                i3 = macroblock3.uSubblocks[1][1].val[15];
                i2 = macroblock3.vSubblocks[1][1].val[15];
                Subblock[] subblockArr4 = new Subblock[2];
                Subblock[] subblockArr5 = new Subblock[2];
                Subblock[] subblockArr6 = new Subblock[2];
                Subblock[] subblockArr7 = new Subblock[2];
                for (i9 = 0; i9 < 2; i9++) {
                    subblockArr4[i9] = macroblock.uSubblocks[1][i9];
                    subblockArr5[i9] = macroblock2.uSubblocks[i9][1];
                    subblockArr6[i9] = macroblock.vSubblocks[1][i9];
                    subblockArr7[i9] = macroblock2.vSubblocks[i9][1];
                }
                i11 = 0;
                while (i11 < 2) {
                    i4 = 0;
                    while (i4 < i) {
                        i5 = 0;
                        while (i5 < 2) {
                            if (r0.uSubblocks[i11][i5].val == null) {
                                r0.uSubblocks[i11][i5].val = new int[16];
                            }
                            if (r0.vSubblocks[i11][i5].val == null) {
                                r0.vSubblocks[i11][i5].val = new int[16];
                            }
                            i6 = 0;
                            for (i = 
/*
Method generation error in method: org.jcodec.codecs.vp8.Macroblock.predictUV(org.jcodec.codecs.vp8.Macroblock[][]):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r8_3 'i' int) = (r8_2 'i' int), (r8_16 'i' int) binds: {(r8_16 'i' int)=B:22:0x0100, (r8_2 'i' int)=B:11:0x008e} in method: org.jcodec.codecs.vp8.Macroblock.predictUV(org.jcodec.codecs.vp8.Macroblock[][]):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:264)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 35 more

*/

                            private void predictY(Macroblock[][] macroblockArr) {
                                Macroblock macroblock = macroblockArr[this.Rrow - 1][this.column];
                                Macroblock macroblock2 = macroblockArr[this.Rrow][this.column - 1];
                                switch (this.lumaMode) {
                                    case 0:
                                        predictLumaDC(macroblock, macroblock2);
                                        return;
                                    case 1:
                                        predictLumaV(macroblock);
                                        return;
                                    case 2:
                                        predictLumaH(macroblock2);
                                        return;
                                    case 3:
                                        predictLumaTM(macroblock, macroblock2, macroblockArr[this.Rrow - 1][this.column - 1].ySubblocks[3][3].val[15]);
                                        return;
                                    default:
                                        macroblockArr = System.err;
                                        StringBuilder stringBuilder = new StringBuilder("TODO predict_mb_y: ");
                                        stringBuilder.append(this.lumaMode);
                                        macroblockArr.println(stringBuilder.toString());
                                        System.exit(null);
                                        return;
                                }
                            }

                            private void predictLumaDC(Macroblock macroblock, Macroblock macroblock2) {
                                int i = this.Rrow > 1 ? 1 : 0;
                                int i2 = this.column > 1 ? 1 : 0;
                                int i3 = 128;
                                if (!(i == 0 && i2 == 0)) {
                                    int i4;
                                    i3 = 3;
                                    if (i != 0) {
                                        int i5 = 0;
                                        i4 = i5;
                                        while (i5 < 4) {
                                            Subblock subblock = macroblock.ySubblocks[3][i5];
                                            int i6 = i4;
                                            for (i4 = 0; i4 < 4; i4++) {
                                                i6 += subblock.val[12 + i4];
                                            }
                                            i5++;
                                            i4 = i6;
                                        }
                                    } else {
                                        i4 = 0;
                                    }
                                    if (i2 != 0) {
                                        macroblock = null;
                                        while (macroblock < 4) {
                                            Subblock subblock2 = macroblock2.ySubblocks[macroblock][3];
                                            int i7 = i4;
                                            for (i4 = 0; i4 < 4; i4++) {
                                                i7 += subblock2.val[(i4 * 4) + 3];
                                            }
                                            macroblock++;
                                            i4 = i7;
                                        }
                                    }
                                    if (i != 0) {
                                        i3 = 4;
                                    }
                                    if (i2 != 0) {
                                        i3++;
                                    }
                                    i3 = (i4 + (1 << (i3 - 1))) >> i3;
                                }
                                macroblock2 = new int[16];
                                for (i = 0; i < 16; i++) {
                                    macroblock2[i] = i3;
                                }
                                for (macroblock = null; macroblock < 4; macroblock++) {
                                    for (i = 0; i < 4; i++) {
                                        this.ySubblocks[macroblock][i].predict = macroblock2;
                                    }
                                }
                            }

                            private void predictLumaH(Macroblock macroblock) {
                                int i;
                                Subblock[] subblockArr = new Subblock[4];
                                for (i = 0; i < 4; i++) {
                                    subblockArr[i] = macroblock.ySubblocks[i][3];
                                }
                                for (macroblock = null; macroblock < 4; macroblock++) {
                                    for (i = 0; i < 4; i++) {
                                        Subblock subblock = this.ySubblocks[macroblock][i];
                                        int[] iArr = new int[16];
                                        for (int i2 = 0; i2 < 4; i2++) {
                                            for (int i3 = 0; i3 < 4; i3++) {
                                                int i4 = i2 * 4;
                                                iArr[i4 + i3] = subblockArr[macroblock].val != null ? subblockArr[macroblock].val[i4 + 3] : 129;
                                            }
                                        }
                                        subblock.predict = iArr;
                                    }
                                }
                            }

                            private void predictLumaTM(Macroblock macroblock, Macroblock macroblock2, int i) {
                                int i2;
                                Subblock[] subblockArr = new Subblock[4];
                                Subblock[] subblockArr2 = new Subblock[4];
                                for (i2 = 0; i2 < 4; i2++) {
                                    subblockArr[i2] = macroblock.ySubblocks[3][i2];
                                }
                                for (macroblock = null; macroblock < 4; macroblock++) {
                                    subblockArr2[macroblock] = macroblock2.ySubblocks[macroblock][3];
                                }
                                for (macroblock = null; macroblock < 4; macroblock++) {
                                    for (macroblock2 = null; macroblock2 < 4; macroblock2++) {
                                        for (i2 = 0; i2 < 4; i2++) {
                                            if (this.ySubblocks[macroblock][i2].val == null) {
                                                this.ySubblocks[macroblock][i2].val = new int[16];
                                            }
                                            for (int i3 = 0; i3 < 4; i3++) {
                                                int i4 = macroblock2 * 4;
                                                this.ySubblocks[macroblock][i2].val[i4 + i3] = QuantizationParams.clip255((subblockArr2[macroblock].val[i4 + 3] + subblockArr[i2].val[12 + i3]) - i);
                                            }
                                        }
                                    }
                                }
                            }

                            private void predictLumaV(Macroblock macroblock) {
                                int i;
                                Subblock[] subblockArr = new Subblock[4];
                                for (i = 0; i < 4; i++) {
                                    subblockArr[i] = macroblock.ySubblocks[3][i];
                                }
                                for (macroblock = null; macroblock < 4; macroblock++) {
                                    for (i = 0; i < 4; i++) {
                                        Subblock subblock = this.ySubblocks[macroblock][i];
                                        int[] iArr = new int[16];
                                        for (int i2 = 0; i2 < 4; i2++) {
                                            for (int i3 = 0; i3 < 4; i3++) {
                                                iArr[(i2 * 4) + i3] = subblockArr[i].val != null ? subblockArr[i].val[12 + i3] : 127;
                                            }
                                        }
                                        subblock.predict = iArr;
                                    }
                                }
                            }

                            public Subblock getBottomSubblock(int i, PLANE plane) {
                                if (plane == PLANE.Y1) {
                                    return this.ySubblocks[3][i];
                                }
                                if (plane == PLANE.U) {
                                    return this.uSubblocks[1][i];
                                }
                                if (plane == PLANE.V) {
                                    return this.vSubblocks[1][i];
                                }
                                return plane == PLANE.Y2 ? this.y2 : 0;
                            }

                            public Subblock getRightSubBlock(int i, PLANE plane) {
                                if (plane == PLANE.Y1) {
                                    return this.ySubblocks[i][3];
                                }
                                if (plane == PLANE.U) {
                                    return this.uSubblocks[i][1];
                                }
                                if (plane == PLANE.V) {
                                    return this.vSubblocks[i][1];
                                }
                                return plane == PLANE.Y2 ? this.y2 : 0;
                            }

                            public void decodeMacroBlock(Macroblock[][] macroblockArr, BooleanArithmeticDecoder booleanArithmeticDecoder, int[][][][] iArr) {
                                boolean z = false;
                                if (this.skipCoeff > 0) {
                                    if (this.lumaMode != 4) {
                                        z = true;
                                    }
                                    this.skipFilter = z;
                                } else if (this.lumaMode != 4) {
                                    decodeMacroBlockTokens(true, macroblockArr, booleanArithmeticDecoder, iArr);
                                } else {
                                    decodeMacroBlockTokens(false, macroblockArr, booleanArithmeticDecoder, iArr);
                                }
                            }

                            private void decodeMacroBlockTokens(boolean z, Macroblock[][] macroblockArr, BooleanArithmeticDecoder booleanArithmeticDecoder, int[][][][] iArr) {
                                this.skipFilter = false;
                                if (z) {
                                    this.skipFilter |= decodePlaneTokens(1, PLANE.Y2, false, macroblockArr, booleanArithmeticDecoder, iArr);
                                }
                                this.skipFilter = decodePlaneTokens(4, PLANE.Y1, z, macroblockArr, booleanArithmeticDecoder, iArr) | this.skipFilter;
                                Macroblock[][] macroblockArr2 = macroblockArr;
                                BooleanArithmeticDecoder booleanArithmeticDecoder2 = booleanArithmeticDecoder;
                                int[][][][] iArr2 = iArr;
                                this.skipFilter |= decodePlaneTokens(2, PLANE.U, false, macroblockArr2, booleanArithmeticDecoder2, iArr2);
                                this.skipFilter |= decodePlaneTokens(2, PLANE.V, false, macroblockArr2, booleanArithmeticDecoder2, iArr2);
                                this.skipFilter ^= 1;
                            }

                            private boolean decodePlaneTokens(int i, PLANE plane, boolean z, Macroblock[][] macroblockArr, BooleanArithmeticDecoder booleanArithmeticDecoder, int[][][][] iArr) {
                                Macroblock macroblock = this;
                                int i2 = i;
                                PLANE plane2 = plane;
                                Macroblock[][] macroblockArr2 = macroblockArr;
                                int i3 = 0;
                                boolean z2 = i3;
                                while (i3 < i2) {
                                    boolean z3 = z2;
                                    for (int i4 = 0; i4 < i2; i4++) {
                                        Subblock subblock = null;
                                        if (PLANE.Y1.equals(plane2)) {
                                            subblock = macroblock.ySubblocks[i3][i4];
                                        } else if (PLANE.U.equals(plane2)) {
                                            subblock = macroblock.uSubblocks[i3][i4];
                                        } else if (PLANE.V.equals(plane2)) {
                                            subblock = macroblock.vSubblocks[i3][i4];
                                        } else if (PLANE.Y2.equals(plane2)) {
                                            subblock = macroblock.y2;
                                        }
                                        subblock.decodeSubBlock(booleanArithmeticDecoder, iArr, subblock.getLeft(plane2, macroblockArr2).someValuePresent + subblock.getAbove(plane2, macroblockArr2).someValuePresent, VP8Util.planeToType(plane2, Boolean.valueOf(z)), z);
                                        z3 |= subblock.someValuePresent;
                                    }
                                    i3++;
                                    z2 = z3;
                                }
                                return z2;
                            }
                        }
