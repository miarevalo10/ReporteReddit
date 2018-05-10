package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class ProresToThumb4x4 extends ProresDecoder {
    public static int[] interlaced_scan_4x4 = new int[]{0, 4, 1, 5, 8, 12, 9, 13, 2, 6, 3, 7, 10, 14, 11, 15};
    public static int[] progressive_scan_4x4 = new int[]{0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 11, 12, 14, 15};
    private static final int[] srcIncLuma = new int[]{4, 4, 4, 20, 4, 4, 4, 20};

    protected int[] decodeOnePlane(BitReader bitReader, int i, int[] iArr, int[] iArr2, int i2, int i3, int i4) {
        i2 = new int[(i << 4)];
        ProresDecoder.readDCCoeffs(bitReader, iArr, i2, i, 16);
        ProresDecoder.readACCoeffs(bitReader, iArr, i2, i, iArr2, 16, 4);
        for (bitReader = null; bitReader < i; bitReader++) {
            IDCT4x4.idct(i2, bitReader << 4);
        }
        return i2;
    }

    public Picture decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        int[][] iArr2 = iArr;
        FrameHeader readFrameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        int i = ((readFrameHeader.width + 15) & -16) >> 1;
        int i2 = ((readFrameHeader.height + 15) & -16) >> 1;
        int i3 = i * i2;
        int i4 = i3 >> 1;
        if (iArr2 != null && iArr2[0].length >= i3 && iArr2[1].length >= i4) {
            if (iArr2[2].length >= i4) {
                int i5;
                int[] iArr3;
                int i6;
                int[] iArr4;
                int[] iArr5;
                int i7;
                int i8;
                if (readFrameHeader.frameType == 0) {
                    i5 = i >> 3;
                    iArr3 = readFrameHeader.qMatLuma;
                    i6 = 0;
                    iArr4 = readFrameHeader.qMatChroma;
                    iArr5 = progressive_scan_4x4;
                    i7 = 2;
                    i8 = i2;
                } else {
                    int i9 = i2 >> 1;
                    int i10 = i >> 3;
                    i7 = 2;
                    decodePicture(byteBuffer, iArr2, i, i9, i10, readFrameHeader.qMatLuma, readFrameHeader.qMatChroma, interlaced_scan_4x4, readFrameHeader.topFieldFirst ? 1 : 2, readFrameHeader.chromaType);
                    int[] iArr6 = readFrameHeader.qMatLuma;
                    int[] iArr7 = readFrameHeader.qMatChroma;
                    int[] iArr8 = interlaced_scan_4x4;
                    if (readFrameHeader.topFieldFirst) {
                        iArr3 = iArr6;
                        iArr4 = iArr7;
                        iArr5 = iArr8;
                        i6 = i7;
                        i8 = i9;
                        i5 = i10;
                    } else {
                        iArr3 = iArr6;
                        iArr4 = iArr7;
                        iArr5 = iArr8;
                        i8 = i9;
                        i5 = i10;
                        i6 = 1;
                    }
                }
                decodePicture(byteBuffer, iArr2, i, i8, i5, iArr3, iArr4, iArr5, i6, readFrameHeader.chromaType);
                return new Picture(i, i2, iArr2, readFrameHeader.chromaType == i7 ? ColorSpace.YUV422_10 : ColorSpace.YUV444_10);
            }
        }
        throw new RuntimeException("Provided output picture won't fit into provided buffer");
    }

    protected void putSlice(int[][] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int[] iArr4, int i4, int i5, int i6) {
        int[] iArr5 = iArr2;
        int length = iArr5.length >> 6;
        int i7 = i >> 1;
        int i8 = i5 * i;
        int i9 = i << i4;
        putLuma(iArr[0], i8, i9, i2, i3, iArr5, length, i4, i5);
        if (i6 == 2) {
            int i10 = i5 * i7;
            i7 <<= i4;
            putChroma(iArr[1], i10, i7, i2, i3, iArr3, length, i4, i5);
            putChroma(iArr[2], i10, i7, i2, i3, iArr4, length, i4, i5);
            return;
        }
        putLuma(iArr[1], i8, i9, i2, i3, iArr3, length, i4, i5);
        putLuma(iArr[2], i8, i9, i2, i3, iArr4, length, i4, i5);
    }

    private void putLuma(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5, int i6, int i7) {
        i4 = i + ((i3 << 3) + ((i4 << 3) * i2));
        i = 0;
        i6 = i;
        while (i < i5) {
            i7 = i4;
            int i8 = i6;
            for (i6 = 0; i6 < 8; i6++) {
                iArr[i7] = ProresDecoder.clip(iArr2[i8], 4, 1019);
                iArr[i7 + 1] = ProresDecoder.clip(iArr2[i8 + 1], 4, 1019);
                iArr[i7 + 2] = ProresDecoder.clip(iArr2[i8 + 2], 4, 1019);
                iArr[i7 + 3] = ProresDecoder.clip(iArr2[i8 + 3], 4, 1019);
                iArr[i7 + 4] = ProresDecoder.clip(iArr2[i8 + 16], 4, 1019);
                iArr[i7 + 5] = ProresDecoder.clip(iArr2[i8 + 17], 4, 1019);
                iArr[i7 + 6] = ProresDecoder.clip(iArr2[i8 + 18], 4, 1019);
                iArr[i7 + 7] = ProresDecoder.clip(iArr2[i8 + 19], 4, 1019);
                i8 += srcIncLuma[i6];
                i7 += i2;
            }
            i++;
            i4 += 8;
            i6 = i8;
        }
    }

    private void putChroma(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5, int i6, int i7) {
        i4 = i + ((i3 << 2) + ((i4 << 3) * i2));
        i = 0;
        i6 = i;
        while (i < i5) {
            i7 = i4;
            int i8 = i6;
            for (i6 = 0; i6 < 8; i6++) {
                iArr[i7] = ProresDecoder.clip(iArr2[i8], 4, 1019);
                iArr[i7 + 1] = ProresDecoder.clip(iArr2[i8 + 1], 4, 1019);
                iArr[i7 + 2] = ProresDecoder.clip(iArr2[i8 + 2], 4, 1019);
                iArr[i7 + 3] = ProresDecoder.clip(iArr2[i8 + 3], 4, 1019);
                i8 += 4;
                i7 += i2;
            }
            i++;
            i4 += 4;
            i6 = i8;
        }
    }
}
