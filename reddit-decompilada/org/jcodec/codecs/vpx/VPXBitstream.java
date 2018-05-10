package org.jcodec.codecs.vpx;

import org.jcodec.codecs.common.biari.VPxBooleanEncoder;
import org.jcodec.common.tools.MathUtil;

public class VPXBitstream {
    public static final int[] coeffBandMapping = new int[]{0, 1, 2, 3, 6, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7};
    private int[][] dctNzLeft = new int[][]{new int[4], new int[2], new int[2]};
    private int[][] dctNzTop;
    private int[][][][] tokenBinProbs;
    private int whtNzLeft = 0;
    private int[] whtNzTop;

    public VPXBitstream(int[][][][] iArr, int i) {
        this.tokenBinProbs = iArr;
        this.whtNzTop = new int[i];
        iArr = new int[3][];
        i <<= 1;
        iArr[1] = new int[i];
        iArr[2] = new int[i];
        this.dctNzTop = iArr;
    }

    public void encodeCoeffsWHT(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int i) {
        int i2;
        int fastCountCoeffWHT = fastCountCoeffWHT(iArr);
        int i3 = 0;
        if (i != 0) {
            if (this.whtNzLeft > 0) {
                i2 = 1;
                if (this.whtNzTop[i] > 0) {
                    i3 = 1;
                }
                encodeCoeffs(vPxBooleanEncoder, iArr, 0, fastCountCoeffWHT, 1, i2 + i3);
                this.whtNzLeft = fastCountCoeffWHT;
                this.whtNzTop[i] = fastCountCoeffWHT;
            }
        }
        i2 = 0;
        if (this.whtNzTop[i] > 0) {
            i3 = 1;
        }
        encodeCoeffs(vPxBooleanEncoder, iArr, 0, fastCountCoeffWHT, 1, i2 + i3);
        this.whtNzLeft = fastCountCoeffWHT;
        this.whtNzTop[i] = fastCountCoeffWHT;
    }

    public void encodeCoeffsDCT15(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int i, int i2, int i3) {
        int i4;
        int countCoeff = countCoeff(iArr, 16);
        i = (i << 2) + i2;
        if (i != 0) {
            if (this.dctNzLeft[0][i3] > 0) {
                i4 = 1;
                encodeCoeffs(vPxBooleanEncoder, iArr, 1, countCoeff, 0, i4 + (this.dctNzTop[0][i] <= 0 ? 1 : 0));
                countCoeff--;
                this.dctNzLeft[0][i3] = Math.max(countCoeff, 0);
                this.dctNzTop[0][i] = Math.max(countCoeff, 0);
            }
        }
        i4 = 0;
        if (this.dctNzTop[0][i] <= 0) {
        }
        encodeCoeffs(vPxBooleanEncoder, iArr, 1, countCoeff, 0, i4 + (this.dctNzTop[0][i] <= 0 ? 1 : 0));
        countCoeff--;
        this.dctNzLeft[0][i3] = Math.max(countCoeff, 0);
        this.dctNzTop[0][i] = Math.max(countCoeff, 0);
    }

    public void encodeCoeffsDCT16(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int i, int i2, int i3) {
        int i4;
        int countCoeff = countCoeff(iArr, 16);
        i = (i << 2) + i2;
        i2 = 1;
        if (i != 0) {
            if (this.dctNzLeft[0][i3] > 0) {
                i4 = 1;
                if (this.dctNzTop[0][i] > 0) {
                    i2 = 0;
                }
                encodeCoeffs(vPxBooleanEncoder, iArr, 0, countCoeff, 3, i4 + i2);
                this.dctNzLeft[0][i3] = countCoeff;
                this.dctNzTop[0][i] = countCoeff;
            }
        }
        i4 = 0;
        if (this.dctNzTop[0][i] > 0) {
            i2 = 0;
        }
        encodeCoeffs(vPxBooleanEncoder, iArr, 0, countCoeff, 3, i4 + i2);
        this.dctNzLeft[0][i3] = countCoeff;
        this.dctNzTop[0][i] = countCoeff;
    }

    public void encodeCoeffsDCTUV(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int i, int i2, int i3, int i4) {
        int i5;
        int countCoeff = countCoeff(iArr, 16);
        i2 = (i2 << 1) + i3;
        i3 = 0;
        if (i2 != 0) {
            if (this.dctNzLeft[i][i4] > 0) {
                i5 = 1;
                if (this.dctNzTop[i][i2] > 0) {
                    i3 = 1;
                }
                encodeCoeffs(vPxBooleanEncoder, iArr, 0, countCoeff, 2, i5 + i3);
                this.dctNzLeft[i][i4] = countCoeff;
                this.dctNzTop[i][i2] = countCoeff;
            }
        }
        i5 = 0;
        if (this.dctNzTop[i][i2] > 0) {
            i3 = 1;
        }
        encodeCoeffs(vPxBooleanEncoder, iArr, 0, countCoeff, 2, i5 + i3);
        this.dctNzLeft[i][i4] = countCoeff;
        this.dctNzTop[i][i2] = countCoeff;
    }

    public void encodeCoeffs(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        while (i < i2) {
            i4 = this.tokenBinProbs[i3][coeffBandMapping[i]][i4];
            int abs = MathUtil.abs(iArr[i]);
            if (i5 == 0) {
                vPxBooleanEncoder.writeBit(i4[0], 1);
            }
            if (abs == 0) {
                vPxBooleanEncoder.writeBit(i4[1], 0);
                i4 = 0;
            } else {
                vPxBooleanEncoder.writeBit(i4[1], 1);
                i5 = 2;
                if (abs == 1) {
                    vPxBooleanEncoder.writeBit(i4[2], 0);
                    i5 = 1;
                } else {
                    vPxBooleanEncoder.writeBit(i4[2], 1);
                    if (abs <= 4) {
                        vPxBooleanEncoder.writeBit(i4[3], 0);
                        if (abs == 2) {
                            vPxBooleanEncoder.writeBit(i4[4], 0);
                        } else {
                            vPxBooleanEncoder.writeBit(i4[4], 1);
                            vPxBooleanEncoder.writeBit(i4[5], abs - 3);
                        }
                    } else {
                        vPxBooleanEncoder.writeBit(i4[3], 1);
                        if (abs <= 10) {
                            vPxBooleanEncoder.writeBit(i4[6], 0);
                            if (abs <= 6) {
                                vPxBooleanEncoder.writeBit(i4[7], 0);
                                vPxBooleanEncoder.writeBit(159, abs - 5);
                            } else {
                                vPxBooleanEncoder.writeBit(i4[7], 1);
                                i4 = abs - 7;
                                vPxBooleanEncoder.writeBit(165, i4 >> 1);
                                vPxBooleanEncoder.writeBit(145, i4 & 1);
                            }
                        } else {
                            vPxBooleanEncoder.writeBit(i4[6], 1);
                            if (abs <= 34) {
                                vPxBooleanEncoder.writeBit(i4[8], 0);
                                if (abs <= 18) {
                                    vPxBooleanEncoder.writeBit(i4[9], 0);
                                    writeCat3Ext(vPxBooleanEncoder, abs);
                                } else {
                                    vPxBooleanEncoder.writeBit(i4[9], 1);
                                    writeCat4Ext(vPxBooleanEncoder, abs);
                                }
                            } else {
                                vPxBooleanEncoder.writeBit(i4[8], 1);
                                if (abs <= 66) {
                                    vPxBooleanEncoder.writeBit(i4[10], 0);
                                    writeCatExt(vPxBooleanEncoder, abs, 35, VPXConst.probCoeffExtCat5);
                                } else {
                                    vPxBooleanEncoder.writeBit(i4[10], 1);
                                    writeCatExt(vPxBooleanEncoder, abs, 67, VPXConst.probCoeffExtCat6);
                                }
                            }
                        }
                    }
                }
                vPxBooleanEncoder.writeBit(128, MathUtil.sign(iArr[i]));
                i4 = i5;
            }
            i5 = abs == 0 ? 1 : 0;
            i++;
        }
        if (i2 < 16) {
            vPxBooleanEncoder.writeBit(this.tokenBinProbs[i3][coeffBandMapping[i]][i4][0], 0);
        }
    }

    private static void writeCat3Ext(VPxBooleanEncoder vPxBooleanEncoder, int i) {
        i -= 11;
        vPxBooleanEncoder.writeBit(173, i >> 2);
        vPxBooleanEncoder.writeBit(148, (i >> 1) & 1);
        vPxBooleanEncoder.writeBit(140, i & 1);
    }

    private static void writeCat4Ext(VPxBooleanEncoder vPxBooleanEncoder, int i) {
        i -= 19;
        vPxBooleanEncoder.writeBit(176, i >> 3);
        vPxBooleanEncoder.writeBit(155, (i >> 2) & 1);
        vPxBooleanEncoder.writeBit(140, (i >> 1) & 1);
        vPxBooleanEncoder.writeBit(135, i & 1);
    }

    private static final void writeCatExt(VPxBooleanEncoder vPxBooleanEncoder, int i, int i2, int[] iArr) {
        i -= i2;
        i2 = 0;
        int length = iArr.length - 1;
        while (length >= 0) {
            int i3 = i2 + 1;
            vPxBooleanEncoder.writeBit(iArr[i2], (i >> length) & 1);
            length--;
            i2 = i3;
        }
    }

    private int fastCountCoeffWHT(int[] iArr) {
        if (iArr[15] != 0) {
            return 16;
        }
        return countCoeff(iArr, 15);
    }

    private int countCoeff(int[] iArr, int i) {
        while (i > 0) {
            i--;
            if (iArr[i] != 0) {
                return i + 1;
            }
        }
        return i;
    }
}
