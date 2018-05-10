package org.jcodec.codecs.h264.io;

import java.lang.reflect.Array;
import org.jcodec.codecs.common.biari.MDecoder;
import org.jcodec.codecs.common.biari.MEncoder;
import org.jcodec.codecs.h264.H264Const.PartPred;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.CABACContst;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mps.MPSUtils;

public class CABAC {
    private int chromaPredModeLeft = 0;
    private int[] chromaPredModeTop;
    private int[] codedBlkDCLeft;
    private int[][] codedBlkDCTop;
    private int[][] codedBlkLeft;
    private int[][] codedBlkTop;
    private int[][][] mvdLeft;
    private int[][][] mvdTop;
    private int prevCBP;
    private int prevMbQpDelta;
    private int[][] refIdxLeft;
    private int[][] refIdxTop;
    private boolean skipFlagLeft;
    private boolean[] skipFlagsTop;
    public int[] tmp = new int[16];

    public enum BlockType {
        LUMA_16_DC(85, 105, 166, 277, 338, JpegConst.APP3, 0),
        LUMA_15_AC(89, 120, MPEGConst.EXTENSION_START_CODE, 292, 353, JpegConst.APPD, 0),
        LUMA_16(93, 134, JpegConst.SOF3, 306, 367, 247, 0),
        CHROMA_DC(97, 149, JpegConst.RST2, 321, 382, 257, 1),
        CHROMA_AC(101, 152, JpegConst.RST5, 324, 385, 266, 0),
        LUMA_64(1012, 402, 417, 436, 451, 426, 0),
        CB_16_DC(460, 484, 572, 776, 864, 952, 0),
        CB_15x16_AC(464, 499, 587, 791, 879, 962, 0),
        CB_16(468, 513, 601, 805, 893, 972, 0),
        CB_64(1016, 660, 690, 675, 699, 708, 0),
        CR_16_DC(472, 528, 616, 820, 908, 982, 0),
        CR_15x16_AC(476, 543, 631, 835, 923, 992, 0),
        CR_16(MPSUtils.VIDEO_MIN, 557, 645, 849, 937, 1002, 0),
        CR_64(1020, 718, 748, 733, 757, 766, 0);
        
        public int codedBlockCtxOff;
        public int coeffAbsLevelAdjust;
        public int coeffAbsLevelCtxOff;
        public int lastSigCoeffCtxOff;
        public int lastSigCoeffFldCtxOff;
        public int sigCoeffFlagCtxOff;
        public int sigCoeffFlagFldCtxOff;

        private BlockType(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.codedBlockCtxOff = i;
            this.sigCoeffFlagCtxOff = i2;
            this.lastSigCoeffCtxOff = i3;
            this.sigCoeffFlagFldCtxOff = i4;
            this.lastSigCoeffFldCtxOff = i4;
            this.coeffAbsLevelCtxOff = i6;
            this.coeffAbsLevelAdjust = i7;
        }
    }

    private boolean cbp(int i, int i2, int i3) {
        return ((i >> ((i3 & 2) + (i2 >> 1))) & 1) == 1;
    }

    public CABAC(int i) {
        this.chromaPredModeTop = new int[i];
        this.codedBlkLeft = new int[][]{new int[4], new int[2], new int[2]};
        int[][] iArr = new int[3][];
        int i2 = i << 2;
        iArr[0] = new int[i2];
        int i3 = i << 1;
        iArr[1] = new int[i3];
        iArr[2] = new int[i3];
        this.codedBlkTop = iArr;
        this.codedBlkDCLeft = new int[3];
        this.codedBlkDCTop = (int[][]) Array.newInstance(int.class, new int[]{3, i});
        this.refIdxLeft = (int[][]) Array.newInstance(int.class, new int[]{2, 4});
        this.refIdxTop = (int[][]) Array.newInstance(int.class, new int[]{2, i2});
        this.skipFlagsTop = new boolean[i];
        this.mvdTop = (int[][][]) Array.newInstance(int.class, new int[]{2, 2, i2});
        this.mvdLeft = (int[][][]) Array.newInstance(int.class, new int[]{2, 2, 4});
    }

    public int readCoeffs(MDecoder mDecoder, BlockType blockType, int[] iArr, int i, int i2, int[] iArr2, int[] iArr3, int[] iArr4) {
        boolean[] zArr = new boolean[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2 - 1) {
            zArr[i4] = mDecoder.decodeBin(blockType.sigCoeffFlagCtxOff + iArr3[i4]) == 1;
            if (zArr[i4] && mDecoder.decodeBin(blockType.lastSigCoeffCtxOff + iArr4[i4]) == 1) {
                break;
            }
            i4++;
        }
        i2 = i4 + 1;
        zArr[i4] = true;
        iArr3 = null;
        for (i2--; i2 >= 0; i2--) {
            if (zArr[i2] != null) {
                iArr4 = readCoeffAbsLevel(mDecoder, blockType, i3, iArr3);
                if (iArr4 == null) {
                    iArr3++;
                } else {
                    i3++;
                }
                iArr[iArr2[i2 + i]] = MathUtil.toSigned(iArr4 + 1, -mDecoder.decodeBinBypass());
            }
        }
        return i3 + iArr3;
    }

    private int readCoeffAbsLevel(MDecoder mDecoder, BlockType blockType, int i, int i2) {
        int i3 = 0;
        int min = 5 + Math.min(4 - blockType.coeffAbsLevelAdjust, i);
        i = mDecoder.decodeBin(blockType.coeffAbsLevelCtxOff + (i != 0 ? 0 : Math.min(4, i2 + 1)));
        i2 = 0;
        while (i != 0 && i2 < 13) {
            i = mDecoder.decodeBin(blockType.coeffAbsLevelCtxOff + min);
            i2++;
        }
        i2 += i;
        if (i2 != 14) {
            return i2;
        }
        blockType = -2;
        do {
            blockType += 1;
        } while (mDecoder.decodeBinBypass() != 0);
        i = 0;
        while (blockType >= null) {
            i3 |= mDecoder.decodeBinBypass() << blockType;
            i += 1 << blockType;
            blockType--;
        }
        return i2 + (i3 + i);
    }

    public void writeCoeffs(MEncoder mEncoder, BlockType blockType, int[] iArr, int i, int i2, int[] iArr2) {
        int i3;
        for (i3 = 0; i3 < i2; i3++) {
            this.tmp[i3] = iArr[iArr2[i + i3]];
        }
        iArr = null;
        i = iArr;
        while (iArr < i2) {
            if (this.tmp[iArr] != null) {
                i = iArr + 1;
            }
            iArr++;
        }
        iArr = null;
        while (true) {
            iArr2 = 1;
            if (iArr >= Math.min(i, i2 - 1)) {
                break;
            }
            if (this.tmp[iArr] != 0) {
                mEncoder.encodeBin(blockType.sigCoeffFlagCtxOff + iArr, 1);
                i3 = blockType.lastSigCoeffCtxOff + iArr;
                if (iArr != i - 1) {
                    iArr2 = null;
                }
                mEncoder.encodeBin(i3, iArr2);
            } else {
                mEncoder.encodeBin(blockType.sigCoeffFlagCtxOff + iArr, 0);
            }
            iArr++;
        }
        iArr = null;
        i2 = iArr;
        for (i--; i >= 0; i--) {
            if (this.tmp[i] != 0) {
                int abs = MathUtil.abs(this.tmp[i]) - 1;
                writeCoeffAbsLevel(mEncoder, blockType, iArr, i2, abs);
                if (abs == 0) {
                    i2++;
                } else {
                    iArr++;
                }
                mEncoder.encodeBinBypass(MathUtil.sign(this.tmp[i]));
            }
        }
    }

    private void writeCoeffAbsLevel(MEncoder mEncoder, BlockType blockType, int i, int i2, int i3) {
        i2 = i != 0 ? 0 : Math.min(4, i2 + 1);
        int min = 5 + Math.min(4 - blockType.coeffAbsLevelAdjust, i);
        if (i3 == 0) {
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + i2, 0);
            return;
        }
        mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + i2, 1);
        if (i3 < 14) {
            for (i = 1; i < i3; i++) {
                mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + min, 1);
            }
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + min, 0);
            return;
        }
        for (i2 = 1; i2 < 14; i2++) {
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + min, 1);
        }
        i3 -= 14;
        i = 0;
        blockType = 1;
        while (i3 >= blockType) {
            mEncoder.encodeBinBypass(1);
            i3 -= blockType;
            i++;
            blockType = 1 << i;
        }
        mEncoder.encodeBinBypass(0);
        while (true) {
            i--;
            if (i >= 0) {
                mEncoder.encodeBinBypass((i3 >> i) & 1);
            } else {
                return;
            }
        }
    }

    public void initModels(int[][] iArr, SliceType sliceType, int i, int i2) {
        int[] iArr2 = sliceType.isIntra() ? CABACContst.cabac_context_init_I_A : CABACContst.cabac_context_init_PB_A[i];
        sliceType = sliceType.isIntra() != null ? CABACContst.cabac_context_init_I_B : CABACContst.cabac_context_init_PB_B[i];
        for (int i3 = 0; i3 < 1024; i3++) {
            int clip = MathUtil.clip(((iArr2[i3] * MathUtil.clip(i2, 0, 51)) >> 4) + sliceType[i3], 1, 126);
            if (clip <= 63) {
                iArr[0][i3] = 63 - clip;
                iArr[1][i3] = 0;
            } else {
                iArr[0][i3] = clip - 64;
                iArr[1][i3] = 1;
            }
        }
    }

    public int readMBTypeI(MDecoder mDecoder, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        if (z) {
            if (mBType != MBType.I_NxN) {
                mBType = 1;
                z = true + mBType;
                if (z2) {
                    if (mBType2 == MBType.I_NxN) {
                        mBType = 1;
                        if (mDecoder.decodeBin(z + mBType) != null) {
                            return 0;
                        }
                        return mDecoder.decodeFinalBin() != 1 ? 25 : 1 + readMBType16x16(mDecoder);
                    }
                }
                mBType = null;
                if (mDecoder.decodeBin(z + mBType) != null) {
                    return 0;
                }
                if (mDecoder.decodeFinalBin() != 1) {
                }
            }
        }
        mBType = null;
        z = true + mBType;
        if (z2) {
            if (mBType2 == MBType.I_NxN) {
                mBType = 1;
                if (mDecoder.decodeBin(z + mBType) != null) {
                    return 0;
                }
                if (mDecoder.decodeFinalBin() != 1) {
                }
            }
        }
        mBType = null;
        if (mDecoder.decodeBin(z + mBType) != null) {
            return 0;
        }
        if (mDecoder.decodeFinalBin() != 1) {
        }
    }

    private int readMBType16x16(MDecoder mDecoder) {
        int decodeBin = mDecoder.decodeBin(6) * 12;
        if (mDecoder.decodeBin(7) == 0) {
            return (decodeBin + (mDecoder.decodeBin(9) << 1)) + mDecoder.decodeBin(10);
        }
        return (((decodeBin + (mDecoder.decodeBin(8) << 2)) + (mDecoder.decodeBin(9) << 1)) + mDecoder.decodeBin(10)) + 4;
    }

    public int readMBTypeP(MDecoder mDecoder) {
        if (mDecoder.decodeBin(14) == 1) {
            return 5 + readIntraP(mDecoder, 17);
        }
        if (mDecoder.decodeBin(15) == 0) {
            return mDecoder.decodeBin(16) == null ? null : 3;
        } else {
            if (mDecoder.decodeBin(17) == null) {
                return 2;
            }
            return 1;
        }
    }

    private int readIntraP(MDecoder mDecoder, int i) {
        if (mDecoder.decodeBin(i) == 0) {
            return null;
        }
        return mDecoder.decodeFinalBin() == 1 ? 25 : 1 + readMBType16x16P(mDecoder, i);
    }

    private int readMBType16x16P(MDecoder mDecoder, int i) {
        i++;
        int decodeBin = mDecoder.decodeBin(i) * 12;
        i++;
        if (mDecoder.decodeBin(i) == 0) {
            i++;
            return (decodeBin + (mDecoder.decodeBin(i) << 1)) + mDecoder.decodeBin(i);
        }
        i++;
        return (((decodeBin + (mDecoder.decodeBin(i) << 2)) + (mDecoder.decodeBin(i) << 1)) + mDecoder.decodeBin(i)) + 4;
    }

    public int readMBTypeB(MDecoder mDecoder, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        if (z && mBType != null) {
            if (mBType != MBType.B_Direct_16x16) {
                mBType = 1;
                z = true + mBType;
                if (z2 && mBType2 != null) {
                    if (mBType2 == MBType.B_Direct_16x16) {
                        mBType = 1;
                        if (mDecoder.decodeBin(z + mBType) != null) {
                            return 0;
                        }
                        if (mDecoder.decodeBin(30) != null) {
                            return 1 + mDecoder.decodeBin(32);
                        }
                        if (mDecoder.decodeBin(31) != null) {
                            return 3 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
                        } else if (mDecoder.decodeBin(32) != null) {
                            return 12 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
                        } else {
                            switch ((mDecoder.decodeBin(32) << 1) + mDecoder.decodeBin(32)) {
                                case null:
                                    return 20 + mDecoder.decodeBin(32);
                                case 1:
                                    return 23 + readIntraP(mDecoder, 32);
                                case 2:
                                    return 11;
                                case 3:
                                    return 22;
                                default:
                                    return 0;
                            }
                        }
                    }
                }
                mBType = null;
                if (mDecoder.decodeBin(z + mBType) != null) {
                    return 0;
                }
                if (mDecoder.decodeBin(30) != null) {
                    return 1 + mDecoder.decodeBin(32);
                }
                if (mDecoder.decodeBin(31) != null) {
                    return 3 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
                } else if (mDecoder.decodeBin(32) != null) {
                    switch ((mDecoder.decodeBin(32) << 1) + mDecoder.decodeBin(32)) {
                        case null:
                            return 20 + mDecoder.decodeBin(32);
                        case 1:
                            return 23 + readIntraP(mDecoder, 32);
                        case 2:
                            return 11;
                        case 3:
                            return 22;
                        default:
                            return 0;
                    }
                } else {
                    return 12 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
                }
            }
        }
        mBType = null;
        z = true + mBType;
        if (mBType2 == MBType.B_Direct_16x16) {
            mBType = 1;
            if (mDecoder.decodeBin(z + mBType) != null) {
                return 0;
            }
            if (mDecoder.decodeBin(30) != null) {
                return 1 + mDecoder.decodeBin(32);
            }
            if (mDecoder.decodeBin(31) != null) {
                return 3 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
            } else if (mDecoder.decodeBin(32) != null) {
                return 12 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
            } else {
                switch ((mDecoder.decodeBin(32) << 1) + mDecoder.decodeBin(32)) {
                    case null:
                        return 20 + mDecoder.decodeBin(32);
                    case 1:
                        return 23 + readIntraP(mDecoder, 32);
                    case 2:
                        return 11;
                    case 3:
                        return 22;
                    default:
                        return 0;
                }
            }
        }
        mBType = null;
        if (mDecoder.decodeBin(z + mBType) != null) {
            return 0;
        }
        if (mDecoder.decodeBin(30) != null) {
            return 1 + mDecoder.decodeBin(32);
        }
        if (mDecoder.decodeBin(31) != null) {
            return 3 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
        } else if (mDecoder.decodeBin(32) != null) {
            switch ((mDecoder.decodeBin(32) << 1) + mDecoder.decodeBin(32)) {
                case null:
                    return 20 + mDecoder.decodeBin(32);
                case 1:
                    return 23 + readIntraP(mDecoder, 32);
                case 2:
                    return 11;
                case 3:
                    return 22;
                default:
                    return 0;
            }
        } else {
            return 12 + (mDecoder.decodeBin(32) | ((mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << true)));
        }
    }

    public void writeMBTypeI(MEncoder mEncoder, MBType mBType, MBType mBType2, boolean z, boolean z2, int i) {
        if (z) {
            if (mBType != MBType.I_NxN) {
                mBType = 1;
                z = true + mBType;
                if (z2) {
                    if (mBType2 == MBType.I_NxN) {
                        mBType = 1;
                        z += mBType;
                        if (i != 0) {
                            mEncoder.encodeBin(z, 0);
                        }
                        mEncoder.encodeBin(z, 1);
                        if (i != 25) {
                            mEncoder.encodeBinFinal(1);
                            return;
                        }
                        mEncoder.encodeBinFinal(0);
                        writeMBType16x16(mEncoder, i - 1);
                        return;
                    }
                }
                mBType = null;
                z += mBType;
                if (i != 0) {
                    mEncoder.encodeBin(z, 1);
                    if (i != 25) {
                        mEncoder.encodeBinFinal(0);
                        writeMBType16x16(mEncoder, i - 1);
                        return;
                    }
                    mEncoder.encodeBinFinal(1);
                    return;
                }
                mEncoder.encodeBin(z, 0);
            }
        }
        mBType = null;
        z = true + mBType;
        if (z2) {
            if (mBType2 == MBType.I_NxN) {
                mBType = 1;
                z += mBType;
                if (i != 0) {
                    mEncoder.encodeBin(z, 0);
                }
                mEncoder.encodeBin(z, 1);
                if (i != 25) {
                    mEncoder.encodeBinFinal(1);
                    return;
                }
                mEncoder.encodeBinFinal(0);
                writeMBType16x16(mEncoder, i - 1);
                return;
            }
        }
        mBType = null;
        z += mBType;
        if (i != 0) {
            mEncoder.encodeBin(z, 1);
            if (i != 25) {
                mEncoder.encodeBinFinal(0);
                writeMBType16x16(mEncoder, i - 1);
                return;
            }
            mEncoder.encodeBinFinal(1);
            return;
        }
        mEncoder.encodeBin(z, 0);
    }

    private void writeMBType16x16(MEncoder mEncoder, int i) {
        if (i < 12) {
            mEncoder.encodeBin(6, 0);
        } else {
            mEncoder.encodeBin(6, 1);
            i -= 12;
        }
        if (i < 4) {
            mEncoder.encodeBin(7, 0);
            mEncoder.encodeBin(9, i >> 1);
            mEncoder.encodeBin(10, i & 1);
            return;
        }
        i -= 4;
        mEncoder.encodeBin(7, 1);
        mEncoder.encodeBin(8, i >> 2);
        mEncoder.encodeBin(9, (i >> 1) & 1);
        mEncoder.encodeBin(10, i & 1);
    }

    public int readMBQpDelta(MDecoder mDecoder, MBType mBType) {
        int i = 0;
        if (!(mBType == null || mBType == MBType.I_PCM || (mBType != MBType.I_16x16 && this.prevCBP == null))) {
            if (this.prevMbQpDelta != null) {
                mBType = 1;
                if (mDecoder.decodeBin(60 + mBType) == 1) {
                    if (mDecoder.decodeBin(62) != 1) {
                        i = 2;
                        while (mDecoder.decodeBin(63) == 1) {
                            i++;
                        }
                    } else {
                        i = 1;
                    }
                }
                this.prevMbQpDelta = H264Utils.golomb2Signed(i);
                return this.prevMbQpDelta;
            }
        }
        mBType = null;
        if (mDecoder.decodeBin(60 + mBType) == 1) {
            if (mDecoder.decodeBin(62) != 1) {
                i = 1;
            } else {
                i = 2;
                while (mDecoder.decodeBin(63) == 1) {
                    i++;
                }
            }
        }
        this.prevMbQpDelta = H264Utils.golomb2Signed(i);
        return this.prevMbQpDelta;
    }

    public void writeMBQpDelta(MEncoder mEncoder, MBType mBType, int i) {
        int i2;
        if (!(mBType == null || mBType == MBType.I_PCM || (mBType != MBType.I_16x16 && this.prevCBP == null))) {
            if (this.prevMbQpDelta != null) {
                mBType = 1;
                i2 = 60 + mBType;
                this.prevMbQpDelta = i;
                mBType = i - 1;
                if (i != 0) {
                    mEncoder.encodeBin(i2, 0);
                }
                mEncoder.encodeBin(i2, 1);
                i = mBType - 1;
                if (mBType != null) {
                    mEncoder.encodeBin(62, 0);
                    return;
                }
                while (true) {
                    mBType = i - 1;
                    if (i <= 0) {
                        mEncoder.encodeBin(63, 1);
                        i = mBType;
                    } else {
                        mEncoder.encodeBin(63, 0);
                        return;
                    }
                }
            }
        }
        mBType = null;
        i2 = 60 + mBType;
        this.prevMbQpDelta = i;
        mBType = i - 1;
        if (i != 0) {
            mEncoder.encodeBin(i2, 1);
            i = mBType - 1;
            if (mBType != null) {
                while (true) {
                    mBType = i - 1;
                    if (i <= 0) {
                        mEncoder.encodeBin(63, 0);
                        return;
                    } else {
                        mEncoder.encodeBin(63, 1);
                        i = mBType;
                    }
                }
            } else {
                mEncoder.encodeBin(62, 0);
                return;
            }
        }
        mEncoder.encodeBin(i2, 0);
    }

    public int readIntraChromaPredMode(MDecoder mDecoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        int i2 = 0;
        if (!(!z || mBType == null || mBType.isIntra() == null)) {
            if (this.chromaPredModeLeft != null) {
                mBType = 1;
                z = true + mBType;
                if (!(!z2 || mBType2 == null || mBType2.isIntra() == null)) {
                    if (this.chromaPredModeTop[i] == null) {
                        mBType = 1;
                        if (mDecoder.decodeBin(z + mBType) != null) {
                            i2 = mDecoder.decodeBin(67) != null ? 1 : mDecoder.decodeBin(67) != null ? 2 : 3;
                        }
                        this.chromaPredModeTop[i] = i2;
                        this.chromaPredModeLeft = i2;
                        return i2;
                    }
                }
                mBType = null;
                if (mDecoder.decodeBin(z + mBType) != null) {
                    if (mDecoder.decodeBin(67) != null) {
                        if (mDecoder.decodeBin(67) != null) {
                        }
                    }
                }
                this.chromaPredModeTop[i] = i2;
                this.chromaPredModeLeft = i2;
                return i2;
            }
        }
        mBType = null;
        z = true + mBType;
        if (this.chromaPredModeTop[i] == null) {
            mBType = 1;
            if (mDecoder.decodeBin(z + mBType) != null) {
                if (mDecoder.decodeBin(67) != null) {
                }
            }
            this.chromaPredModeTop[i] = i2;
            this.chromaPredModeLeft = i2;
            return i2;
        }
        mBType = null;
        if (mDecoder.decodeBin(z + mBType) != null) {
            if (mDecoder.decodeBin(67) != null) {
                if (mDecoder.decodeBin(67) != null) {
                }
            }
        }
        this.chromaPredModeTop[i] = i2;
        this.chromaPredModeLeft = i2;
        return i2;
    }

    public void writeIntraChromaPredMode(MEncoder mEncoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2, int i2) {
        if (z && mBType.isIntra() != null) {
            if (this.chromaPredModeLeft != null) {
                mBType = 1;
                z = true + mBType;
                if (z2 && mBType2.isIntra() != null) {
                    if (this.chromaPredModeTop[i] == null) {
                        mBType = 1;
                        z += mBType;
                        mBType = i2 - 1;
                        mEncoder.encodeBin(z, i2 != 0 ? null : 1);
                        mBType2 = null;
                        while (mBType >= null && mBType2 < true) {
                            z2 = mBType - 1;
                            mEncoder.encodeBin(true, mBType != null ? null : 1);
                            mBType2++;
                            mBType = z2;
                        }
                        this.chromaPredModeTop[i] = mBType;
                        this.chromaPredModeLeft = mBType;
                    }
                }
                mBType = null;
                z += mBType;
                mBType = i2 - 1;
                if (i2 != 0) {
                }
                mEncoder.encodeBin(z, i2 != 0 ? null : 1);
                mBType2 = null;
                while (mBType >= null) {
                    z2 = mBType - 1;
                    if (mBType != null) {
                    }
                    mEncoder.encodeBin(true, mBType != null ? null : 1);
                    mBType2++;
                    mBType = z2;
                }
                this.chromaPredModeTop[i] = mBType;
                this.chromaPredModeLeft = mBType;
            }
        }
        mBType = null;
        z = true + mBType;
        if (this.chromaPredModeTop[i] == null) {
            mBType = 1;
            z += mBType;
            mBType = i2 - 1;
            if (i2 != 0) {
            }
            mEncoder.encodeBin(z, i2 != 0 ? null : 1);
            mBType2 = null;
            while (mBType >= null) {
                z2 = mBType - 1;
                if (mBType != null) {
                }
                mEncoder.encodeBin(true, mBType != null ? null : 1);
                mBType2++;
                mBType = z2;
            }
            this.chromaPredModeTop[i] = mBType;
            this.chromaPredModeLeft = mBType;
        }
        mBType = null;
        z += mBType;
        mBType = i2 - 1;
        if (i2 != 0) {
        }
        mEncoder.encodeBin(z, i2 != 0 ? null : 1);
        mBType2 = null;
        while (mBType >= null) {
            z2 = mBType - 1;
            if (mBType != null) {
            }
            mEncoder.encodeBin(true, mBType != null ? null : 1);
            mBType2++;
            mBType = z2;
        }
        this.chromaPredModeTop[i] = mBType;
        this.chromaPredModeLeft = mBType;
    }

    public int condTerm(MBType mBType, boolean z, MBType mBType2, boolean z2, int i) {
        if (!z) {
            return mBType.isIntra() != null ? 1 : 0;
        } else {
            if (mBType2 == MBType.I_PCM) {
                return 1;
            }
            if (z2) {
                return i;
            }
            return 0;
        }
    }

    public int readCodedBlockFlagLumaDC(MDecoder mDecoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2, MBType mBType3) {
        MBType mBType4 = mBType;
        int condTerm = condTerm(mBType3, z, mBType4, mBType4 == MBType.I_16x16, r6.codedBlkDCLeft[0]);
        mBType4 = mBType2;
        int decodeBin = mDecoder.decodeBin((BlockType.LUMA_16_DC.codedBlockCtxOff + condTerm) + (2 * condTerm(mBType3, z2, mBType4, mBType4 == MBType.I_16x16, r6.codedBlkDCTop[0][i])));
        r6.codedBlkDCLeft[0] = decodeBin;
        r6.codedBlkDCTop[0][i] = decodeBin;
        return decodeBin;
    }

    public int readCodedBlockFlagChromaDC(MDecoder mDecoder, int i, int i2, MBType mBType, MBType mBType2, boolean z, boolean z2, int i3, int i4, MBType mBType3) {
        CABAC cabac = this;
        boolean z3 = (mBType == null || i3 == 0) ? false : true;
        int condTerm = condTerm(mBType3, z, mBType, z3, cabac.codedBlkDCLeft[i2]);
        z3 = (mBType2 == null || i4 == 0) ? false : true;
        int decodeBin = mDecoder.decodeBin((BlockType.CHROMA_DC.codedBlockCtxOff + condTerm) + (2 * condTerm(mBType3, z2, mBType2, z3, cabac.codedBlkDCTop[i2][i])));
        cabac.codedBlkDCLeft[i2] = decodeBin;
        cabac.codedBlkDCTop[i2][i] = decodeBin;
        return decodeBin;
    }

    public int readCodedBlockFlagLumaAC(MDecoder mDecoder, BlockType blockType, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, int i6, MBType mBType3) {
        int condTerm;
        CABAC cabac = this;
        MBType mBType4 = mBType;
        MBType mBType5 = mBType2;
        int i7 = i6;
        int i8 = i & 3;
        int i9 = i2 & 3;
        if (i8 == 0) {
            boolean z3 = (mBType4 == null || mBType4 == MBType.I_PCM || !cbp(i4, 3, i9)) ? false : true;
            condTerm = condTerm(mBType3, z, mBType4, z3, cabac.codedBlkLeft[i3][i9]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, cbp(i7, i8 - 1, i9), cabac.codedBlkLeft[i3][i9]);
        }
        int i10 = condTerm;
        if (i9 == 0) {
            z3 = (mBType5 == null || mBType5 == MBType.I_PCM || !cbp(i5, i8, 3)) ? false : true;
            condTerm = condTerm(mBType3, z2, mBType5, z3, cabac.codedBlkTop[i3][i]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, cbp(i7, i8, i9 - 1), cabac.codedBlkTop[i3][i]);
        }
        condTerm = mDecoder.decodeBin((blockType.codedBlockCtxOff + i10) + (2 * condTerm));
        cabac.codedBlkLeft[i3][i9] = condTerm;
        cabac.codedBlkTop[i3][i] = condTerm;
        return condTerm;
    }

    public int readCodedBlockFlagLuma64(MDecoder mDecoder, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, int i6, MBType mBType3, boolean z3, boolean z4) {
        int condTerm;
        CABAC cabac = this;
        MBType mBType4 = mBType;
        MBType mBType5 = mBType2;
        int i7 = i6;
        int i8 = i & 3;
        int i9 = i2 & 3;
        if (i8 == 0) {
            boolean z5 = mBType4 != null && mBType4 != MBType.I_PCM && z3 && cbp(i4, 3, i9);
            condTerm = condTerm(mBType3, z, mBType4, z5, cabac.codedBlkLeft[i3][i9]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, cbp(i7, i8 - 1, i9), cabac.codedBlkLeft[i3][i9]);
        }
        int i10 = condTerm;
        if (i9 == 0) {
            z5 = mBType5 != null && mBType5 != MBType.I_PCM && z4 && cbp(i5, i8, 3);
            condTerm = condTerm(mBType3, z2, mBType5, z5, cabac.codedBlkTop[i3][i]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, cbp(i7, i8, i9 - 1), cabac.codedBlkTop[i3][i]);
        }
        condTerm = mDecoder.decodeBin((BlockType.LUMA_64.codedBlockCtxOff + i10) + (2 * condTerm));
        cabac.codedBlkLeft[i3][i9] = condTerm;
        cabac.codedBlkTop[i3][i] = condTerm;
        return condTerm;
    }

    public int readCodedBlockFlagChromaAC(MDecoder mDecoder, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, MBType mBType3) {
        int condTerm;
        CABAC cabac = this;
        MBType mBType4 = mBType;
        MBType mBType5 = mBType2;
        int i6 = i2 & 1;
        if ((i & 1) == 0) {
            boolean z3 = (mBType4 == null || mBType4 == MBType.I_PCM || (i4 & 2) == 0) ? false : true;
            condTerm = condTerm(mBType3, z, mBType4, z3, cabac.codedBlkLeft[i3][i6]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, true, cabac.codedBlkLeft[i3][i6]);
        }
        int i7 = condTerm;
        if (i6 == 0) {
            z3 = (mBType5 == null || mBType5 == MBType.I_PCM || (i5 & 2) == 0) ? false : true;
            condTerm = condTerm(mBType3, z2, mBType5, z3, cabac.codedBlkTop[i3][i]);
        } else {
            condTerm = condTerm(mBType3, true, mBType3, true, cabac.codedBlkTop[i3][i]);
        }
        condTerm = mDecoder.decodeBin((BlockType.CHROMA_AC.codedBlockCtxOff + i7) + (2 * condTerm));
        cabac.codedBlkLeft[i3][i6] = condTerm;
        cabac.codedBlkTop[i3][i] = condTerm;
        return condTerm;
    }

    public boolean prev4x4PredModeFlag(MDecoder mDecoder) {
        return mDecoder.decodeBin(68) == 1 ? true : null;
    }

    public int rem4x4PredMode(MDecoder mDecoder) {
        return (mDecoder.decodeBin(69) << 2) | (mDecoder.decodeBin(69) | (mDecoder.decodeBin(69) << 1));
    }

    public int codedBlockPatternIntra(MDecoder mDecoder, boolean z, boolean z2, int i, int i2, MBType mBType, MBType mBType2) {
        int decodeBin = mDecoder.decodeBin((condTerm(z, mBType, (i >> 1) & 1) + 73) + (condTerm(z2, mBType2, (i2 >> 2) & 1) * 2));
        int i3 = 1 - decodeBin;
        int decodeBin2 = mDecoder.decodeBin((73 + i3) + (condTerm(z2, mBType2, (i2 >> 3) & 1) * 2));
        i3 = mDecoder.decodeBin((condTerm(z, mBType, (i >> 3) & 1) + 73) + (i3 * 2));
        int decodeBin3 = mDecoder.decodeBin((73 + (1 - i3)) + ((1 - decodeBin2) * 2));
        i >>= 4;
        i2 >>= 4;
        int decodeBin4 = mDecoder.decodeBin((77 + condTermCr0(z, mBType, i)) + (condTermCr0(z2, mBType2, i2) * 2));
        return ((decodeBin4 != 0 ? mDecoder.decodeBin((81 + condTermCr1(z, mBType, i)) + (condTermCr1(z2, mBType2, i2) * true)) : null) << 5) | (((((decodeBin2 << 1) | decodeBin) | (i3 << 2)) | (decodeBin3 << 3)) | (decodeBin4 << 4));
    }

    private int condTermCr0(boolean z, MBType mBType, int i) {
        return z && (mBType == MBType.I_PCM || !(mBType == null || i == 0));
    }

    private int condTermCr1(boolean z, MBType mBType, int i) {
        return z && (mBType == MBType.I_PCM || (mBType != null && (i & 2)));
    }

    private int condTerm(boolean z, MBType mBType, int i) {
        if (z && mBType != MBType.I_PCM) {
            if (mBType == null || i != 1) {
                return 1;
            }
        }
        return false;
    }

    public void setPrevCBP(int i) {
        this.prevCBP = i;
    }

    public int readMVD(MDecoder mDecoder, int i, boolean z, boolean z2, MBType mBType, MBType mBType2, PartPred partPred, PartPred partPred2, PartPred partPred3, int i2, int i3, int i4, int i5, int i6, int i7) {
        int abs;
        int i8;
        CABAC cabac = this;
        MDecoder mDecoder2 = mDecoder;
        PartPred partPred4 = partPred;
        PartPred partPred5 = partPred2;
        PartPred partPred6 = partPred3;
        int i9 = i7;
        int i10 = i == 0 ? 40 : 47;
        int i11 = 2;
        int i12 = (i2 << 2) + i3;
        int i13 = 0;
        int i14 = (partPred4 == null || partPred4 == PartPred.Direct || !(partPred4 == PartPred.Bi || partPred4 == partPred6 || (partPred6 == PartPred.Bi && partPred4.usesList(i9)))) ? 0 : 1;
        int i15 = (partPred5 == null || partPred5 == PartPred.Direct || !(partPred5 == PartPred.Bi || partPred5 == partPred6 || (partPred6 == PartPred.Bi && partPred5.usesList(i9)))) ? 0 : 1;
        if (!(!z || mBType == null || mBType.isIntra())) {
            if (i14 != 0) {
                abs = Math.abs(cabac.mvdLeft[i9][i][i4]);
                if (!(!z2 || mBType2 == null || mBType2.isIntra())) {
                    if (i15 == 0) {
                        i14 = Math.abs(cabac.mvdTop[i9][i][i12]);
                        abs += i14;
                        abs = abs >= 3 ? 0 : abs <= 32 ? 2 : 1;
                        abs = mDecoder2.decodeBin(abs + i10);
                        i15 = 0;
                        while (abs != 0 && i15 < 8) {
                            abs = mDecoder2.decodeBin(Math.min((i10 + i15) + 3, i10 + 6));
                            i15++;
                        }
                        i15 += abs;
                        if (i15 != 0) {
                            if (i15 == 9) {
                                i14 = 0;
                                abs = i14;
                                while (true) {
                                    i14 += abs;
                                    i11++;
                                    i10 = 1 << i11;
                                    if (mDecoder2.decodeBinBypass() != 0) {
                                        break;
                                    }
                                    abs = i10;
                                }
                                abs = 0;
                                for (i11--; i11 >= 0; i11--) {
                                    abs |= mDecoder2.decodeBinBypass() << i11;
                                }
                                i15 += abs + i14;
                            }
                            i15 = MathUtil.toSigned(i15, -mDecoder2.decodeBinBypass());
                        }
                        i8 = i5;
                        for (i14 = 0; i14 < i8; i14++) {
                            cabac.mvdTop[i9][i][i12 + i14] = i15;
                        }
                        i8 = i6;
                        while (i13 < i8) {
                            cabac.mvdLeft[i9][i][i4 + i13] = i15;
                            i13++;
                        }
                        return i15;
                    }
                }
                i14 = 0;
                abs += i14;
                if (abs >= 3) {
                    if (abs <= 32) {
                    }
                }
                abs = mDecoder2.decodeBin(abs + i10);
                i15 = 0;
                while (abs != 0) {
                    abs = mDecoder2.decodeBin(Math.min((i10 + i15) + 3, i10 + 6));
                    i15++;
                }
                i15 += abs;
                if (i15 != 0) {
                    if (i15 == 9) {
                        i14 = 0;
                        abs = i14;
                        while (true) {
                            i14 += abs;
                            i11++;
                            i10 = 1 << i11;
                            if (mDecoder2.decodeBinBypass() != 0) {
                                break;
                            }
                            abs = i10;
                        }
                        abs = 0;
                        for (i11--; i11 >= 0; i11--) {
                            abs |= mDecoder2.decodeBinBypass() << i11;
                        }
                        i15 += abs + i14;
                    }
                    i15 = MathUtil.toSigned(i15, -mDecoder2.decodeBinBypass());
                }
                i8 = i5;
                for (i14 = 0; i14 < i8; i14++) {
                    cabac.mvdTop[i9][i][i12 + i14] = i15;
                }
                i8 = i6;
                while (i13 < i8) {
                    cabac.mvdLeft[i9][i][i4 + i13] = i15;
                    i13++;
                }
                return i15;
            }
        }
        abs = 0;
        if (i15 == 0) {
            i14 = Math.abs(cabac.mvdTop[i9][i][i12]);
            abs += i14;
            if (abs >= 3) {
            }
            abs = mDecoder2.decodeBin(abs + i10);
            i15 = 0;
            while (abs != 0) {
                abs = mDecoder2.decodeBin(Math.min((i10 + i15) + 3, i10 + 6));
                i15++;
            }
            i15 += abs;
            if (i15 != 0) {
                if (i15 == 9) {
                    i14 = 0;
                    abs = i14;
                    while (true) {
                        i14 += abs;
                        i11++;
                        i10 = 1 << i11;
                        if (mDecoder2.decodeBinBypass() != 0) {
                            break;
                        }
                        abs = i10;
                    }
                    abs = 0;
                    for (i11--; i11 >= 0; i11--) {
                        abs |= mDecoder2.decodeBinBypass() << i11;
                    }
                    i15 += abs + i14;
                }
                i15 = MathUtil.toSigned(i15, -mDecoder2.decodeBinBypass());
            }
            i8 = i5;
            for (i14 = 0; i14 < i8; i14++) {
                cabac.mvdTop[i9][i][i12 + i14] = i15;
            }
            i8 = i6;
            while (i13 < i8) {
                cabac.mvdLeft[i9][i][i4 + i13] = i15;
                i13++;
            }
            return i15;
        }
        i14 = 0;
        abs += i14;
        if (abs >= 3) {
            if (abs <= 32) {
            }
        }
        abs = mDecoder2.decodeBin(abs + i10);
        i15 = 0;
        while (abs != 0) {
            abs = mDecoder2.decodeBin(Math.min((i10 + i15) + 3, i10 + 6));
            i15++;
        }
        i15 += abs;
        if (i15 != 0) {
            if (i15 == 9) {
                i14 = 0;
                abs = i14;
                while (true) {
                    i14 += abs;
                    i11++;
                    i10 = 1 << i11;
                    if (mDecoder2.decodeBinBypass() != 0) {
                        break;
                    }
                    abs = i10;
                }
                abs = 0;
                for (i11--; i11 >= 0; i11--) {
                    abs |= mDecoder2.decodeBinBypass() << i11;
                }
                i15 += abs + i14;
            }
            i15 = MathUtil.toSigned(i15, -mDecoder2.decodeBinBypass());
        }
        i8 = i5;
        for (i14 = 0; i14 < i8; i14++) {
            cabac.mvdTop[i9][i][i12 + i14] = i15;
        }
        i8 = i6;
        while (i13 < i8) {
            cabac.mvdLeft[i9][i][i4 + i13] = i15;
            i13++;
        }
        return i15;
    }

    public int readRefIdx(MDecoder mDecoder, boolean z, boolean z2, MBType mBType, MBType mBType2, PartPred partPred, PartPred partPred2, PartPred partPred3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        CABAC cabac = this;
        MDecoder mDecoder2 = mDecoder;
        PartPred partPred4 = partPred;
        PartPred partPred5 = partPred2;
        PartPred partPred6 = partPred3;
        int i9 = i6;
        int i10 = 2;
        int i11 = (i << 2) + i2;
        int i12 = 0;
        int i13 = (partPred4 == null || partPred4 == PartPred.Direct || !(partPred4 == PartPred.Bi || partPred4 == partPred6 || (partPred6 == PartPred.Bi && partPred4.usesList(i9)))) ? 0 : 1;
        int i14 = (partPred5 == null || partPred5 == PartPred.Direct || !(partPred5 == PartPred.Bi || partPred5 == partPred6 || (partPred6 == PartPred.Bi && partPred5.usesList(i9)))) ? 0 : 1;
        if (!(!z || mBType == null || mBType.isIntra() || i13 == 0)) {
            if (cabac.refIdxLeft[i9][i3] != 0) {
                i7 = 1;
                if (!(!z2 || mBType2 == null || mBType2.isIntra() || i14 == 0)) {
                    if (cabac.refIdxTop[i9][i11] == 0) {
                        i13 = 1;
                        if (mDecoder2.decodeBin((54 + i7) + (i13 * 2)) != 0) {
                            i10 = 0;
                        } else if (mDecoder2.decodeBin(58) != 0) {
                            i10 = 1;
                        } else {
                            while (mDecoder2.decodeBin(59) == 1) {
                                i10++;
                            }
                        }
                        i8 = i4;
                        for (i13 = 0; i13 < i8; i13++) {
                            cabac.refIdxTop[i9][i11 + i13] = i10;
                        }
                        i8 = i5;
                        while (i12 < i8) {
                            cabac.refIdxLeft[i9][i3 + i12] = i10;
                            i12++;
                        }
                        return i10;
                    }
                }
                i13 = 0;
                if (mDecoder2.decodeBin((54 + i7) + (i13 * 2)) != 0) {
                    i10 = 0;
                } else if (mDecoder2.decodeBin(58) != 0) {
                    while (mDecoder2.decodeBin(59) == 1) {
                        i10++;
                    }
                } else {
                    i10 = 1;
                }
                i8 = i4;
                for (i13 = 0; i13 < i8; i13++) {
                    cabac.refIdxTop[i9][i11 + i13] = i10;
                }
                i8 = i5;
                while (i12 < i8) {
                    cabac.refIdxLeft[i9][i3 + i12] = i10;
                    i12++;
                }
                return i10;
            }
        }
        i7 = 0;
        if (cabac.refIdxTop[i9][i11] == 0) {
            i13 = 1;
            if (mDecoder2.decodeBin((54 + i7) + (i13 * 2)) != 0) {
                i10 = 0;
            } else if (mDecoder2.decodeBin(58) != 0) {
                i10 = 1;
            } else {
                while (mDecoder2.decodeBin(59) == 1) {
                    i10++;
                }
            }
            i8 = i4;
            for (i13 = 0; i13 < i8; i13++) {
                cabac.refIdxTop[i9][i11 + i13] = i10;
            }
            i8 = i5;
            while (i12 < i8) {
                cabac.refIdxLeft[i9][i3 + i12] = i10;
                i12++;
            }
            return i10;
        }
        i13 = 0;
        if (mDecoder2.decodeBin((54 + i7) + (i13 * 2)) != 0) {
            i10 = 0;
        } else if (mDecoder2.decodeBin(58) != 0) {
            while (mDecoder2.decodeBin(59) == 1) {
                i10++;
            }
        } else {
            i10 = 1;
        }
        i8 = i4;
        for (i13 = 0; i13 < i8; i13++) {
            cabac.refIdxTop[i9][i11 + i13] = i10;
        }
        i8 = i5;
        while (i12 < i8) {
            cabac.refIdxLeft[i9][i3 + i12] = i10;
            i12++;
        }
        return i10;
    }

    public boolean readMBSkipFlag(MDecoder mDecoder, SliceType sliceType, boolean z, boolean z2, int i) {
        sliceType = sliceType == SliceType.P ? 11 : 24;
        boolean z3 = false;
        z = z && !this.skipFlagLeft;
        sliceType += z;
        z = z2 && !this.skipFlagsTop[i];
        if (mDecoder.decodeBin(sliceType + z) == 1) {
            z3 = true;
        }
        this.skipFlagsTop[i] = z3;
        this.skipFlagLeft = z3;
        return z3;
    }

    public int readSubMbTypeP(MDecoder mDecoder) {
        if (mDecoder.decodeBin(21) == 1) {
            return null;
        }
        if (mDecoder.decodeBin(22) == 0) {
            return 1;
        }
        return mDecoder.decodeBin(23) == 1 ? 2 : 3;
    }

    public int readSubMbTypeB(MDecoder mDecoder) {
        if (mDecoder.decodeBin(36) == 0) {
            return null;
        }
        if (mDecoder.decodeBin(37) == 0) {
            return 1 + mDecoder.decodeBin(39);
        }
        if (mDecoder.decodeBin(38) == 0) {
            return (3 + (mDecoder.decodeBin(39) << 1)) + mDecoder.decodeBin(39);
        }
        if (mDecoder.decodeBin(39) == 0) {
            return (7 + (mDecoder.decodeBin(39) << 1)) + mDecoder.decodeBin(39);
        }
        return 11 + mDecoder.decodeBin(39);
    }

    public boolean readTransform8x8Flag(MDecoder mDecoder, boolean z, boolean z2, MBType mBType, MBType mBType2, boolean z3, boolean z4) {
        z = z && mBType != null && z3;
        mBType = 399 + z;
        z = z2 && mBType2 != null && z4;
        return mDecoder.decodeBin(mBType + z) == 1;
    }

    public void setCodedBlock(int i, int i2) {
        int[] iArr = this.codedBlkLeft[0];
        i2 &= 3;
        this.codedBlkTop[0][i] = 1;
        iArr[i2] = 1;
    }
}
