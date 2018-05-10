package org.jcodec.codecs.mpeg12;

import java.util.Arrays;
import org.jcodec.codecs.mpeg12.MPEGDecoder.Context;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

public class Mpeg2Thumb4x4 extends MPEGDecoder {
    public static int[] BLOCK_POS_X = new int[]{0, 4, 0, 4, 0, 0, 0, 0, 4, 4, 4, 4, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 4, 4, 4, 4};
    public static int[] BLOCK_POS_Y = new int[]{0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    public static int[][] scan4x4 = new int[][]{new int[]{0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 16, 13, 10, 7, 16, 16, 16, 11, 14, 16, 16, 16, 16, 16, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16}, new int[]{0, 4, 8, 12, 1, 5, 2, 6, 9, 13, 16, 16, 16, 16, 16, 16, 16, 16, 14, 10, 3, 7, 16, 16, 11, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16}};
    private MPEGPred localPred;
    private MPEGPred oldPred;

    protected void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        i = MPEGConst.BLOCK_TO_CC[i];
        int readVLC = (i == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        iArr2[i] = iArr2[i] + (readVLC != 0 ? MPEGDecoder.mpegSigned(bitReader, readVLC) : 0);
        Arrays.fill(iArr, 1, 16, 0);
        iArr[0] = iArr2[i] * i3;
        iArr2 = null;
        i = iArr2;
        while (true) {
            if (iArr2 >= 19 + (iArr3 == scan4x4[1] ? 7 : 0)) {
                break;
            }
            i = vlc.readVLC(bitReader);
            if (i == MPEGConst.CODE_END) {
                break;
            }
            if (i == MPEGConst.CODE_ESCAPE) {
                iArr2 += bitReader.readNBit(6) + 1;
                i3 = (MPEGDecoder.twosSigned(bitReader, i2) * i4) * iArr4[iArr2];
                i3 = i3 >= 0 ? i3 >> 4 : -((-i3) >> 4);
            } else {
                iArr2 += (i >> 6) + 1;
                i3 = MPEGDecoder.toSigned((((i & 63) * i4) * iArr4[iArr2]) >> 4, bitReader.read1Bit());
            }
            iArr[iArr3[iArr2]] = i3;
        }
        if (i != MPEGConst.CODE_END) {
            finishOff(bitReader, iArr2, vlc, i2);
        }
        IDCT4x4.idct(iArr, 0);
    }

    private void finishOff(BitReader bitReader, int i, VLC vlc, int i2) {
        while (i < 64) {
            int readVLC = vlc.readVLC(bitReader);
            if (readVLC == MPEGConst.CODE_END) {
                return;
            }
            if (readVLC == MPEGConst.CODE_ESCAPE) {
                i += bitReader.readNBit(6) + 1;
                bitReader.readNBit(i2);
            } else {
                bitReader.read1Bit();
            }
        }
    }

    protected void blockInter(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int i2, int[] iArr3) {
        int i3;
        Arrays.fill(iArr, 1, 16, 0);
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            iArr[0] = MPEGDecoder.toSigned(MPEGDecoder.quantInter(1, iArr3[0] * i2), bitReader.read1Bit());
            i3 = 0;
        } else {
            iArr[0] = 0;
            i3 = -1;
        }
        int i4 = 0;
        while (true) {
            if (i3 >= 19 + (iArr2 == scan4x4[1] ? 7 : 0)) {
                break;
            }
            i4 = vlc.readVLC(bitReader);
            if (i4 == MPEGConst.CODE_END) {
                break;
            }
            int quantInterSigned;
            if (i4 == MPEGConst.CODE_ESCAPE) {
                i3 += bitReader.readNBit(6) + 1;
                quantInterSigned = MPEGDecoder.quantInterSigned(MPEGDecoder.twosSigned(bitReader, i), iArr3[i3] * i2);
            } else {
                i3 += (i4 >> 6) + 1;
                quantInterSigned = MPEGDecoder.toSigned(MPEGDecoder.quantInter(i4 & 63, iArr3[i3] * i2), bitReader.read1Bit());
            }
            iArr[iArr2[i3]] = quantInterSigned;
        }
        if (i4 != MPEGConst.CODE_END) {
            finishOff(bitReader, i3, vlc, i);
        }
        IDCT4x4.idct(iArr, 0);
    }

    public int decodeMacroblock(PictureHeader pictureHeader, Context context, int i, int[] iArr, int[][] iArr2, int i2, BitReader bitReader, int i3, int i4, MPEGPred mPEGPred) {
        MPEGPred mPEGPred2 = mPEGPred;
        if (this.localPred == null || r11.oldPred != mPEGPred2) {
            r11.localPred = new MPEGPredQuad(mPEGPred2);
            r11.oldPred = mPEGPred2;
        }
        return super.decodeMacroblock(pictureHeader, context, i, iArr, iArr2, i2, bitReader, i3, i4, r11.localPred);
    }

    protected void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        int i6 = 3;
        if (i >= 4) {
            i6 = 3 - MPEGConst.SQUEEZE_X[i3];
        }
        i += i2 << 4;
        i = (BLOCK_POS_Y[i] << i6) + BLOCK_POS_X[i];
        i2 = 1 << (i6 + i5);
        while (i4 < 16) {
            iArr2[i] = iArr2[i] + iArr[i4];
            i3 = i + 1;
            iArr2[i3] = iArr2[i3] + iArr[i4 + 1];
            i3 = i + 2;
            iArr2[i3] = iArr2[i3] + iArr[i4 + 2];
            i3 = i + 3;
            iArr2[i3] = iArr2[i3] + iArr[i4 + 3];
            i4 += 4;
            i += i2;
        }
    }

    protected void put(int[][] iArr, int[][] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = ((i + (1 << MPEGConst.SQUEEZE_X[i2])) - 1) >> MPEGConst.SQUEEZE_X[i2];
        int i10 = 3 - MPEGConst.SQUEEZE_X[i2];
        int i11 = 3 - MPEGConst.SQUEEZE_Y[i2];
        int i12 = i << i8;
        putSub(iArr2[0], (((i4 << 3) * i12) + (i7 * i)) + (i3 << 3), i12, iArr[0], 3, 3);
        int i13 = i9 << i8;
        int i14 = (((i4 << i11) * i13) + (i7 * i9)) + (i3 << i10);
        putSub(iArr2[1], i14, i13, iArr[1], i10, i11);
        putSub(iArr2[2], i14, i13, iArr[2], i10, i11);
    }

    private final void putSub(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        int i5 = 0;
        if (i3 == 2) {
            i3 = 0;
            while (i5 < (1 << i4)) {
                iArr[i] = MPEGDecoder.clip(iArr2[i3]);
                iArr[i + 1] = MPEGDecoder.clip(iArr2[i3 + 1]);
                iArr[i + 2] = MPEGDecoder.clip(iArr2[i3 + 2]);
                iArr[i + 3] = MPEGDecoder.clip(iArr2[i3 + 3]);
                i3 += 4;
                i += i2;
                i5++;
            }
            return;
        }
        i3 = 0;
        while (i5 < (1 << i4)) {
            iArr[i] = MPEGDecoder.clip(iArr2[i3]);
            iArr[i + 1] = MPEGDecoder.clip(iArr2[i3 + 1]);
            iArr[i + 2] = MPEGDecoder.clip(iArr2[i3 + 2]);
            iArr[i + 3] = MPEGDecoder.clip(iArr2[i3 + 3]);
            iArr[i + 4] = MPEGDecoder.clip(iArr2[i3 + 4]);
            iArr[i + 5] = MPEGDecoder.clip(iArr2[i3 + 5]);
            iArr[i + 6] = MPEGDecoder.clip(iArr2[i3 + 6]);
            iArr[i + 7] = MPEGDecoder.clip(iArr2[i3 + 7]);
            i3 += 8;
            i += i2;
            i5++;
        }
    }

    protected Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        sequenceHeader = super.initContext(sequenceHeader, pictureHeader);
        sequenceHeader.codedWidth >>= 1;
        sequenceHeader.codedHeight >>= 1;
        sequenceHeader.picWidth >>= 1;
        sequenceHeader.picHeight >>= 1;
        sequenceHeader.scan = scan4x4[pictureHeader.pictureCodingExtension == null ? null : pictureHeader.pictureCodingExtension.alternate_scan];
        return sequenceHeader;
    }
}
