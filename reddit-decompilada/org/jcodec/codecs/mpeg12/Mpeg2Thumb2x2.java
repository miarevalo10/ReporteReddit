package org.jcodec.codecs.mpeg12;

import org.jcodec.codecs.mpeg12.MPEGDecoder.Context;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.common.dct.IDCT2x2;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

public class Mpeg2Thumb2x2 extends MPEGDecoder {
    public static int[] BLOCK_POS_X = new int[]{0, 2, 0, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 2, 2, 2};
    public static int[] BLOCK_POS_Y = new int[]{0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
    public static int[][] scan2x2 = new int[][]{new int[]{0, 1, 2, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, new int[]{0, 2, 4, 4, 1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}};
    private MPEGPred localPred;
    private MPEGPred oldPred;

    protected void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        i = MPEGConst.BLOCK_TO_CC[i];
        int readVLC = (i == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        iArr2[i] = iArr2[i] + (readVLC != 0 ? MPEGDecoder.mpegSigned(bitReader, readVLC) : 0);
        iArr[0] = iArr2[i] * i3;
        iArr[3] = 0;
        iArr[2] = 0;
        iArr[1] = 0;
        i = 0;
        i3 = i;
        while (i < 6) {
            i3 = vlc.readVLC(bitReader);
            if (i3 == MPEGConst.CODE_END) {
                break;
            }
            if (i3 == MPEGConst.CODE_ESCAPE) {
                i += bitReader.readNBit(6) + 1;
                readVLC = (MPEGDecoder.twosSigned(bitReader, i2) * i4) * iArr4[i];
                readVLC = readVLC >= 0 ? readVLC >> 4 : -((-readVLC) >> 4);
            } else {
                i += (i3 >> 6) + 1;
                readVLC = MPEGDecoder.toSigned((((i3 & 63) * i4) * iArr4[i]) >> 4, bitReader.read1Bit());
            }
            iArr[iArr3[i]] = readVLC;
        }
        if (i3 != MPEGConst.CODE_END) {
            finishOff(bitReader, i, vlc, i2);
        }
        IDCT2x2.idct(iArr, 0);
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
        iArr[3] = 0;
        iArr[2] = 0;
        iArr[1] = 0;
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            iArr[0] = MPEGDecoder.toSigned(MPEGDecoder.quantInter(1, iArr3[0] * i2), bitReader.read1Bit());
            i3 = 0;
        } else {
            iArr[0] = 0;
            i3 = -1;
        }
        int i4 = 0;
        while (i3 < 6) {
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
        IDCT2x2.idct(iArr, 0);
    }

    public int decodeMacroblock(PictureHeader pictureHeader, Context context, int i, int[] iArr, int[][] iArr2, int i2, BitReader bitReader, int i3, int i4, MPEGPred mPEGPred) {
        MPEGPred mPEGPred2 = mPEGPred;
        if (this.localPred == null || r11.oldPred != mPEGPred2) {
            r11.localPred = new MPEGPredOct(mPEGPred2);
            r11.oldPred = mPEGPred2;
        }
        return super.decodeMacroblock(pictureHeader, context, i, iArr, iArr2, i2, bitReader, i3, i4, r11.localPred);
    }

    protected void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        i3 = i < 4 ? 2 : 2 - MPEGConst.SQUEEZE_X[i3];
        i += i2 << 4;
        i = (BLOCK_POS_Y[i] << i3) + BLOCK_POS_X[i];
        i2 = 1 << (i3 + i4);
        iArr2[i] = iArr2[i] + iArr[0];
        i3 = i + 1;
        iArr2[i3] = iArr2[i3] + iArr[1];
        i += i2;
        iArr2[i] = iArr2[i] + iArr[2];
        i++;
        iArr2[i] = iArr2[i] + iArr[3];
    }

    protected void put(int[][] iArr, int[][] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = ((i + (1 << MPEGConst.SQUEEZE_X[i2])) - 1) >> MPEGConst.SQUEEZE_X[i2];
        int i10 = 2 - MPEGConst.SQUEEZE_X[i2];
        int i11 = 2 - MPEGConst.SQUEEZE_Y[i2];
        int i12 = i << i8;
        putSub(iArr2[0], (((i4 << 2) * i12) + (i7 * i)) + (i3 << 2), i12, iArr[0], 2, 2);
        int i13 = i9 << i8;
        int i14 = (((i4 << i11) * i13) + (i7 * i9)) + (i3 << i10);
        putSub(iArr2[1], i14, i13, iArr[1], i10, i11);
        putSub(iArr2[2], i14, i13, iArr[2], i10, i11);
    }

    private final void putSub(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        int i5 = 0;
        if (i3 == 1) {
            iArr[i] = MPEGDecoder.clip(iArr2[0]);
            iArr[i + 1] = MPEGDecoder.clip(iArr2[1]);
            i3 = i + i2;
            iArr[i3] = MPEGDecoder.clip(iArr2[2]);
            iArr[i3 + 1] = MPEGDecoder.clip(iArr2[3]);
            if (i4 == 2) {
                i += i2 << 1;
                iArr[i] = MPEGDecoder.clip(iArr2[4]);
                iArr[i + 1] = MPEGDecoder.clip(iArr2[5]);
                i += i2;
                iArr[i] = MPEGDecoder.clip(iArr2[6]);
                iArr[i + 1] = MPEGDecoder.clip(iArr2[7]);
                return;
            }
        }
        i3 = 0;
        while (i5 < 4) {
            iArr[i] = MPEGDecoder.clip(iArr2[i3]);
            iArr[i + 1] = MPEGDecoder.clip(iArr2[i3 + 1]);
            iArr[i + 2] = MPEGDecoder.clip(iArr2[i3 + 2]);
            iArr[i + 3] = MPEGDecoder.clip(iArr2[i3 + 3]);
            i += i2;
            i3 += 4;
            i5++;
        }
    }

    protected Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        sequenceHeader = super.initContext(sequenceHeader, pictureHeader);
        sequenceHeader.codedWidth >>= 2;
        sequenceHeader.codedHeight >>= 2;
        sequenceHeader.picWidth >>= 2;
        sequenceHeader.picHeight >>= 2;
        sequenceHeader.scan = scan2x2[pictureHeader.pictureCodingExtension == null ? null : pictureHeader.pictureCodingExtension.alternate_scan];
        return sequenceHeader;
    }
}
