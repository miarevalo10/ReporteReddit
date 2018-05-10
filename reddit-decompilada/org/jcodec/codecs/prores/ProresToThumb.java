package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class ProresToThumb extends ProresDecoder {
    protected int[] decodeOnePlane(org.jcodec.common.io.BitReader r1, int r2, int[] r3, int[] r4, int r5, int r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r4 = new int[r2];
        r7 = 1;
        org.jcodec.codecs.prores.ProresDecoder.readDCCoeffs(r1, r3, r4, r2, r7);	 Catch:{ RuntimeException -> 0x0007 }
        goto L_0x0027;
    L_0x0007:
        r1 = java.lang.System.err;
        r3 = new java.lang.StringBuilder;
        r7 = "Suppressing slice error at [";
        r3.<init>(r7);
        r3.append(r5);
        r5 = ", ";
        r3.append(r5);
        r3.append(r6);
        r5 = "].";
        r3.append(r5);
        r3 = r3.toString();
        r1.println(r3);
    L_0x0027:
        r1 = 0;
    L_0x0028:
        if (r1 >= r2) goto L_0x0033;
    L_0x002a:
        r3 = r4[r1];
        r3 = r3 >> 3;
        r4[r1] = r3;
        r1 = r1 + 1;
        goto L_0x0028;
    L_0x0033:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresToThumb.decodeOnePlane(org.jcodec.common.io.BitReader, int, int[], int[], int, int, int):int[]");
    }

    public Picture decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        int[][] iArr2 = iArr;
        FrameHeader readFrameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        int i = ((readFrameHeader.width + 15) & -16) >> 3;
        int i2 = ((readFrameHeader.height + 15) & -16) >> 3;
        int i3 = i * i2;
        int i4 = i3 >> 1;
        if (iArr2 != null && iArr2[0].length >= i3 && iArr2[1].length >= i4) {
            if (iArr2[2].length >= i4) {
                int i5;
                int[] iArr3;
                int[] iArr4;
                int[] iArr5;
                int i6;
                int i7;
                if (readFrameHeader.frameType == 0) {
                    i5 = i >> 1;
                    iArr3 = readFrameHeader.qMatLuma;
                    iArr4 = readFrameHeader.qMatChroma;
                    iArr5 = new int[]{0};
                    i6 = i2;
                    i7 = 0;
                } else {
                    int i8 = i2 >> 1;
                    int i9 = i >> 1;
                    int i10 = 1;
                    decodePicture(byteBuffer, iArr2, i, i8, i9, readFrameHeader.qMatLuma, readFrameHeader.qMatChroma, new int[]{0}, readFrameHeader.topFieldFirst ? 1 : 2, readFrameHeader.chromaType);
                    int[] iArr6 = readFrameHeader.qMatLuma;
                    int[] iArr7 = readFrameHeader.qMatChroma;
                    int[] iArr8 = new int[i10];
                    iArr8[0] = 0;
                    if (readFrameHeader.topFieldFirst) {
                        iArr3 = iArr6;
                        iArr4 = iArr7;
                        iArr5 = iArr8;
                        i6 = i8;
                        i5 = i9;
                        i7 = 2;
                    } else {
                        iArr3 = iArr6;
                        iArr4 = iArr7;
                        iArr5 = iArr8;
                        i7 = i10;
                        i6 = i8;
                        i5 = i9;
                    }
                }
                decodePicture(byteBuffer, iArr2, i, i6, i5, iArr3, iArr4, iArr5, i7, readFrameHeader.chromaType);
                return new Picture(i, i2, iArr2, readFrameHeader.chromaType == 2 ? ColorSpace.YUV422_10 : ColorSpace.YUV444_10);
            }
        }
        throw new RuntimeException("Provided output picture won't fit into provided buffer");
    }

    protected void putSlice(int[][] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int[] iArr4, int i4, int i5, int i6) {
        int[] iArr5 = iArr2;
        int length = iArr5.length >> 2;
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
        i += (i3 << 1) + ((i4 << 1) * i2);
        i3 = 0;
        i4 = 0;
        while (i3 < i5) {
            iArr[i] = ProresDecoder.clip(iArr2[i4], 4, 1019);
            iArr[i + 1] = ProresDecoder.clip(iArr2[i4 + 1], 4, 1019);
            i += i2;
            iArr[i] = ProresDecoder.clip(iArr2[i4 + 2], 4, 1019);
            iArr[i + 1] = ProresDecoder.clip(iArr2[i4 + 3], 4, 1019);
            i += 2 - i2;
            i4 += 4;
            i3++;
        }
    }

    private void putChroma(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5, int i6, int i7) {
        i += i3 + ((i4 << 1) * i2);
        i3 = 0;
        i4 = 0;
        while (i3 < i5) {
            iArr[i] = ProresDecoder.clip(iArr2[i4], 4, 1019);
            i += i2;
            iArr[i] = ProresDecoder.clip(iArr2[i4 + 1], 4, 1019);
            i += 1 - i2;
            i4 += 2;
            i3++;
        }
    }
}
