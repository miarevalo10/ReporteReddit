package org.jcodec.codecs.h264.io;

import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.tools.MathUtil;

public class CAVLC {
    public static int[] NO_ZIGZAG = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private VLC chromaDCVLC = codeTableChromaDC();
    private ColorSpace color;
    private int mbMask;
    private int mbWidth;
    private int[] tokensLeft;
    private int[] tokensTop;

    private static int Abs(int i) {
        return i < 0 ? -i : i;
    }

    private static int Min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static final int coeffToken(int i, int i2) {
        return (i << 4) | i2;
    }

    public static final int totalCoeff(int i) {
        return i >> 4;
    }

    public static final int trailingOnes(int i) {
        return i & 15;
    }

    private final int unsigned(int i) {
        int i2 = i >> 31;
        return ((((i ^ i2) - i2) << 1) + (i >>> 31)) - 2;
    }

    public CAVLC(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i, int i2) {
        this.color = seqParameterSet.chroma_format_idc;
        this.mbWidth = seqParameterSet.pic_width_in_mbs_minus1 + 1;
        this.mbMask = (1 << i2) - 1;
        this.tokensLeft = new int[4];
        this.tokensTop = new int[(this.mbWidth << i)];
    }

    public void writeACBlock(BitWriter bitWriter, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, VLC[] vlcArr, int i3, int i4, int[] iArr2) {
        int writeBlockGen = writeBlockGen(bitWriter, iArr, vlcArr, i3, i4, iArr2, getCoeffTokenVLCForLuma(i != 0, mBType, r8.tokensLeft[r8.mbMask & i2], i2 != 0, mBType2, r8.tokensTop[i]));
        r8.tokensLeft[r8.mbMask & i2] = writeBlockGen;
        r8.tokensTop[i] = writeBlockGen;
    }

    public void writeChrDCBlock(BitWriter bitWriter, int[] iArr, VLC[] vlcArr, int i, int i2, int[] iArr2) {
        writeBlockGen(bitWriter, iArr, vlcArr, i, i2, iArr2, getCoeffTokenVLCForChromaDC());
    }

    public void writeLumaDCBlock(BitWriter bitWriter, int i, int i2, MBType mBType, MBType mBType2, int[] iArr, VLC[] vlcArr, int i3, int i4, int[] iArr2) {
        writeBlockGen(bitWriter, iArr, vlcArr, i3, i4, iArr2, getCoeffTokenVLCForLuma(i != 0, mBType, r8.tokensLeft[r8.mbMask & i2], i2 != 0, mBType2, r8.tokensTop[i]));
    }

    private int writeBlockGen(BitWriter bitWriter, int[] iArr, VLC[] vlcArr, int i, int i2, int[] iArr2, VLC vlc) {
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        while (i4 < i2) {
            int i7 = iArr[iArr2[i4 + i]];
            if (i7 == 0) {
                iArr3[i5] = iArr3[i5] + 1;
                i6++;
            } else {
                int i8 = i5 + 1;
                iArr4[i5] = i7;
                i5 = i8;
            }
            i4++;
        }
        if (i5 < i2) {
            i6 -= iArr3[i5];
        }
        while (i3 < i5 && i3 < 3 && Math.abs(iArr4[(i5 - i3) - 1]) == 1) {
            i3++;
        }
        iArr = coeffToken(i5, i3);
        vlc.writeVLC(bitWriter, iArr);
        if (i5 > 0) {
            writeTrailingOnes(bitWriter, iArr4, i5, i3);
            writeLevels(bitWriter, iArr4, i5, i3);
            if (i5 < i2) {
                vlcArr[i5 - 1].writeVLC(bitWriter, i6);
                writeRuns(bitWriter, iArr3, i5, i6);
            }
        }
        return iArr;
    }

    private void writeTrailingOnes(BitWriter bitWriter, int[] iArr, int i, int i2) {
        for (int i3 = i - 1; i3 >= i - i2; i3--) {
            bitWriter.write1Bit(iArr[i3] >>> 31);
        }
    }

    private void writeLevels(BitWriter bitWriter, int[] iArr, int i, int i2) {
        int i3 = (i <= 10 || i2 >= 3) ? 0 : 1;
        i = (i - i2) - 1;
        int i4 = i3;
        for (i3 = i; i3 >= 0; i3--) {
            int unsigned = unsigned(iArr[i3]);
            if (i3 == i && i2 < 3) {
                unsigned -= 2;
            }
            int i5 = unsigned >> i4;
            if ((i4 == 0 && i5 < 14) || (i4 > 0 && i5 < 15)) {
                bitWriter.writeNBit(1, i5 + 1);
                bitWriter.writeNBit(unsigned, i4);
            } else if (i4 != 0 || unsigned >= 30) {
                int i6;
                if (i4 == 0) {
                    unsigned -= 15;
                }
                i5 = 12;
                while (true) {
                    int i7 = 1 << i5;
                    i6 = ((unsigned - ((i5 + 3) << i4)) - i7) + 4096;
                    if (i6 < i7) {
                        break;
                    }
                    i5++;
                }
                bitWriter.writeNBit(1, i5 + 4);
                bitWriter.writeNBit(i6, i5);
            } else {
                bitWriter.writeNBit(1, 15);
                bitWriter.writeNBit(unsigned - 14, 4);
            }
            if (i4 == 0) {
                i4 = 1;
            }
            if (MathUtil.abs(iArr[i3]) > (3 << (i4 - 1)) && i4 < 6) {
                i4++;
            }
        }
    }

    private void writeRuns(BitWriter bitWriter, int[] iArr, int i, int i2) {
        for (i--; i > 0 && i2 > 0; i--) {
            H264Const.run[Math.min(6, i2 - 1)].writeVLC(bitWriter, iArr[i]);
            i2 -= iArr[i];
        }
    }

    public VLC getCoeffTokenVLCForLuma(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        return H264Const.coeffToken[Math.min(codeTableLuma(z, mBType, i, z2, mBType2, i2), 8)];
    }

    public VLC getCoeffTokenVLCForChromaDC() {
        return this.chromaDCVLC;
    }

    protected int codeTableLuma(boolean z, MBType mBType, int i, boolean z2, MBType mBType2, int i2) {
        mBType = mBType == null ? null : totalCoeff(i);
        if (mBType2 == null) {
            i = 0;
        } else {
            i = totalCoeff(i2);
        }
        if (z && z2) {
            return ((mBType + i) + 1) >> 1;
        }
        if (z) {
            return mBType;
        }
        if (z2) {
            return i;
        }
        return 0;
    }

    protected VLC codeTableChromaDC() {
        if (this.color == ColorSpace.YUV420) {
            return H264Const.coeffTokenChromaDCY420;
        }
        if (this.color == ColorSpace.YUV422) {
            return H264Const.coeffTokenChromaDCY422;
        }
        return this.color == ColorSpace.YUV444 ? H264Const.coeffToken[0] : null;
    }

    public int readCoeffs(BitReader bitReader, VLC vlc, VLC[] vlcArr, int[] iArr, int i, int i2, int[] iArr2) {
        BitReader bitReader2 = bitReader;
        int[] iArr3 = iArr;
        int i3 = i2;
        int readVLC = vlc.readVLC(bitReader2);
        int totalCoeff = totalCoeff(readVLC);
        int trailingOnes = trailingOnes(readVLC);
        if (totalCoeff > 0) {
            int i4;
            int i5;
            int i6;
            int i7 = (totalCoeff <= 10 || trailingOnes >= 3) ? 0 : 1;
            int[] iArr4 = new int[totalCoeff];
            int i8 = 0;
            while (i8 < trailingOnes) {
                iArr4[i8] = 1 - (2 * bitReader.read1Bit());
                i8++;
            }
            while (true) {
                int i9 = 4;
                if (i8 >= totalCoeff) {
                    break;
                }
                int readZeroBitCount = CAVLCReader.readZeroBitCount(bitReader2, "");
                if (readZeroBitCount != 14 || i7 != 0) {
                    i9 = i7;
                }
                if (readZeroBitCount >= 15) {
                    i9 = readZeroBitCount - 3;
                }
                int Min = Min(15, readZeroBitCount) << i7;
                if (i9 > 0) {
                    Min += CAVLCReader.readU(bitReader2, i9, "RB: level_suffix");
                }
                if (readZeroBitCount >= 15 && i7 == 0) {
                    Min += 15;
                }
                if (readZeroBitCount >= 16) {
                    Min += (1 << (readZeroBitCount - 3)) - 4096;
                }
                if (i8 == trailingOnes && trailingOnes < 3) {
                    Min += 2;
                }
                i4 = Min;
                if (i4 % 2 == 0) {
                    iArr4[i8] = (i4 + 2) >> 1;
                } else {
                    iArr4[i8] = ((-i4) - 1) >> 1;
                }
                if (i7 == 0) {
                    i7 = 1;
                }
                if (Abs(iArr4[i8]) > (3 << (i7 - 1)) && i7 < 6) {
                    i7++;
                }
                i8++;
            }
            i4 = totalCoeff < i3 ? iArr3.length == 4 ? H264Const.totalZeros4[totalCoeff - 1].readVLC(bitReader2) : iArr3.length == 8 ? H264Const.totalZeros8[totalCoeff - 1].readVLC(bitReader2) : H264Const.totalZeros16[totalCoeff - 1].readVLC(bitReader2) : 0;
            int[] iArr5 = new int[totalCoeff];
            i7 = 0;
            while (true) {
                i5 = totalCoeff - 1;
                if (i7 >= i5 || i4 <= 0) {
                    iArr5[i7] = i4;
                    i6 = 0;
                } else {
                    i5 = H264Const.run[Math.min(6, i4 - 1)].readVLC(bitReader2);
                    i4 -= i5;
                    iArr5[i7] = i5;
                    i7++;
                }
            }
            iArr5[i7] = i4;
            i6 = 0;
            while (i5 >= 0 && i6 < i3) {
                i6 += iArr5[i5];
                iArr3[iArr2[i6 + i]] = iArr4[i5];
                i5--;
                i6++;
            }
        }
        return readVLC;
    }

    public void readChromaDCBlock(BitReader bitReader, int[] iArr, boolean z, boolean z2) {
        VLC coeffTokenVLCForChromaDC = getCoeffTokenVLCForChromaDC();
        z = iArr.length ? H264Const.totalZeros16 : iArr.length ? H264Const.totalZeros8 : H264Const.totalZeros4;
        readCoeffs(bitReader, coeffTokenVLCForChromaDC, z, iArr, 0, iArr.length, NO_ZIGZAG);
    }

    public void readLumaDCBlock(BitReader bitReader, int[] iArr, int i, boolean z, MBType mBType, boolean z2, MBType mBType2, int[] iArr2) {
        BitReader bitReader2 = bitReader;
        readCoeffs(bitReader2, getCoeffTokenVLCForLuma(z, mBType, this.tokensLeft[0], z2, mBType2, this.tokensTop[i << 2]), H264Const.totalZeros16, iArr, 0, 16, iArr2);
    }

    public int readACBlock(BitReader bitReader, int[] iArr, int i, int i2, boolean z, MBType mBType, boolean z2, MBType mBType2, int i3, int i4, int[] iArr2) {
        BitReader bitReader2 = bitReader;
        int readCoeffs = readCoeffs(bitReader2, getCoeffTokenVLCForLuma(z, mBType, this.tokensLeft[this.mbMask & i2], z2, mBType2, this.tokensTop[i]), H264Const.totalZeros16, iArr, i3, i4, iArr2);
        int[] iArr3 = this.tokensLeft;
        int i5 = this.mbMask & i2;
        this.tokensTop[i] = readCoeffs;
        iArr3[i5] = readCoeffs;
        return totalCoeff(readCoeffs);
    }

    public void setZeroCoeff(int i, int i2) {
        int[] iArr = this.tokensLeft;
        i2 &= this.mbMask;
        this.tokensTop[i] = 0;
        iArr[i2] = 0;
    }
}
