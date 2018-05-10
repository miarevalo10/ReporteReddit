package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.codecs.prores.ProresConsts.PictureHeader;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class ProresDecoder implements VideoDecoder {
    static final int[] mask = new int[]{0, 0, 0, 0, 0, 0, 0, 0, -1};
    static final int[] table = new int[]{8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static final int clip(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static final int golumbSign(int i) {
        return -(i & 1);
    }

    static final boolean hasQMatChroma(int i) {
        return (i & 1) != 0;
    }

    static final boolean hasQMatLuma(int i) {
        return (i & 2) != 0;
    }

    public static final int nZeros(int i) {
        int i2 = table[i & 255];
        i = table[i >> 8];
        return i + (i2 & mask[i]);
    }

    public static final int readCodeword(BitReader bitReader, Codebook codebook) {
        int nZeros = nZeros(bitReader.check16Bits());
        bitReader.skipFast(nZeros + 1);
        if (nZeros > codebook.switchBits) {
            int i = codebook.golombBits + nZeros;
            if (i > 16) {
                Logger.error("Broken prores slice");
            }
            return (bitReader.readFast16(i) | (1 << i)) - codebook.golombOffset;
        } else if (codebook.riceOrder <= 0) {
            return nZeros;
        } else {
            return bitReader.readFast16(codebook.riceOrder) | (nZeros << codebook.riceOrder);
        }
    }

    public static final int golumbToSigned(int i) {
        return golumbSign(i) ^ (i >> 1);
    }

    public static final void readDCCoeffs(BitReader bitReader, int[] iArr, int[] iArr2, int i, int i2) {
        int readCodeword = readCodeword(bitReader, ProresConsts.firstDCCodebook);
        if (readCodeword >= 0) {
            readCodeword = golumbToSigned(readCodeword);
            iArr2[0] = qScale(iArr, 0, readCodeword) + 4096;
            int i3 = 5;
            int i4 = i2;
            int i5 = readCodeword;
            int i6 = 0;
            readCodeword = 1;
            while (readCodeword < i) {
                i3 = readCodeword(bitReader, ProresConsts.dcCodebooks[Math.min(i3, 6)]);
                if (i3 >= 0) {
                    i6 = i3 != 0 ? i6 ^ golumbSign(i3) : 0;
                    i5 += MathUtil.toSigned((i3 + 1) >> 1, i6);
                    iArr2[i4] = qScale(iArr, 0, i5) + 4096;
                    readCodeword++;
                    i4 += i2;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final void readACCoeffs(org.jcodec.common.io.BitReader r9, int[] r10, int[] r11, int r12, int[] r13, int r14, int r15) {
        /*
        r0 = r12 + -1;
        r12 = org.jcodec.common.tools.MathUtil.log2(r12);
        r1 = 64;
        r1 = r1 << r12;
        r2 = 4;
        r3 = 2;
        r4 = r3;
        r3 = r0;
    L_0x000d:
        r5 = r9.remaining();
        r6 = 32;
        if (r5 > r6) goto L_0x001b;
    L_0x0015:
        r5 = r9.checkAllBits();
        if (r5 == 0) goto L_0x0067;
    L_0x001b:
        r5 = org.jcodec.codecs.prores.ProresConsts.runCodebooks;
        r6 = 15;
        r2 = java.lang.Math.min(r2, r6);
        r2 = r5[r2];
        r2 = readCodeword(r9, r2);
        if (r2 < 0) goto L_0x0069;
    L_0x002b:
        r5 = r1 - r3;
        r5 = r5 + -1;
        if (r2 < r5) goto L_0x0032;
    L_0x0031:
        goto L_0x0069;
    L_0x0032:
        r5 = r2 + 1;
        r3 = r3 + r5;
        r5 = org.jcodec.codecs.prores.ProresConsts.levCodebooks;
        r6 = 9;
        r4 = java.lang.Math.min(r4, r6);
        r4 = r5[r4];
        r4 = readCodeword(r9, r4);
        r4 = r4 + 1;
        if (r4 < 0) goto L_0x0068;
    L_0x0047:
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r4 <= r5) goto L_0x004d;
    L_0x004c:
        goto L_0x0068;
    L_0x004d:
        r5 = r9.read1Bit();
        r5 = -r5;
        r6 = r3 >> r12;
        if (r6 >= r14) goto L_0x0067;
    L_0x0056:
        r7 = r3 & r0;
        r7 = r7 << r15;
        r8 = r13[r6];
        r7 = r7 + r8;
        r5 = org.jcodec.common.tools.MathUtil.toSigned(r4, r5);
        r5 = qScale(r10, r6, r5);
        r11[r7] = r5;
        goto L_0x000d;
    L_0x0067:
        return;
    L_0x0068:
        return;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresDecoder.readACCoeffs(org.jcodec.common.io.BitReader, int[], int[], int, int[], int, int):void");
    }

    private static final int qScale(int[] iArr, int i, int i2) {
        return (i2 * iArr[i]) >> 2;
    }

    protected int[] decodeOnePlane(org.jcodec.common.io.BitReader r8, int r9, int[] r10, int[] r11, int r12, int r13, int r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r14 = r9 << 6;
        r14 = new int[r14];
        r0 = 64;
        readDCCoeffs(r8, r10, r14, r9, r0);	 Catch:{ RuntimeException -> 0x0015 }
        r5 = 64;	 Catch:{ RuntimeException -> 0x0015 }
        r6 = 6;	 Catch:{ RuntimeException -> 0x0015 }
        r0 = r8;	 Catch:{ RuntimeException -> 0x0015 }
        r1 = r10;	 Catch:{ RuntimeException -> 0x0015 }
        r2 = r14;	 Catch:{ RuntimeException -> 0x0015 }
        r3 = r9;	 Catch:{ RuntimeException -> 0x0015 }
        r4 = r11;	 Catch:{ RuntimeException -> 0x0015 }
        readACCoeffs(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ RuntimeException -> 0x0015 }
        goto L_0x0035;
    L_0x0015:
        r8 = java.lang.System.err;
        r10 = new java.lang.StringBuilder;
        r11 = "Suppressing slice error at [";
        r10.<init>(r11);
        r10.append(r12);
        r11 = ", ";
        r10.append(r11);
        r10.append(r13);
        r11 = "].";
        r10.append(r11);
        r10 = r10.toString();
        r8.println(r10);
    L_0x0035:
        r8 = 0;
    L_0x0036:
        if (r8 >= r9) goto L_0x0040;
    L_0x0038:
        r10 = r8 << 6;
        org.jcodec.common.dct.SimpleIDCT10Bit.idct10(r14, r10);
        r8 = r8 + 1;
        goto L_0x0036;
    L_0x0040:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresDecoder.decodeOnePlane(org.jcodec.common.io.BitReader, int, int[], int[], int, int, int):int[]");
    }

    public Picture decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        int[][] iArr2 = iArr;
        FrameHeader readFrameHeader = readFrameHeader(byteBuffer);
        int i = (readFrameHeader.width + 15) & -16;
        int i2 = (readFrameHeader.height + 15) & -16;
        int i3 = i * i2;
        int i4 = i3 >> (3 - readFrameHeader.chromaType);
        if (iArr2 != null && iArr2[0].length >= i3 && iArr2[1].length >= i4) {
            if (iArr2[2].length >= i4) {
                int i5;
                int[] iArr3;
                int[] iArr4;
                int i6;
                int[] iArr5;
                int[] iArr6;
                if (readFrameHeader.frameType == 0) {
                    i3 = readFrameHeader.width;
                    i4 = readFrameHeader.height;
                    int i7 = i >> 4;
                    iArr6 = readFrameHeader.qMatLuma;
                    i5 = 0;
                    iArr3 = readFrameHeader.qMatChroma;
                    iArr4 = readFrameHeader.scan;
                    i6 = i7;
                    iArr5 = iArr6;
                } else {
                    int i8 = i >> 4;
                    decodePicture(byteBuffer, iArr2, readFrameHeader.width, readFrameHeader.height >> 1, i8, readFrameHeader.qMatLuma, readFrameHeader.qMatChroma, readFrameHeader.scan, readFrameHeader.topFieldFirst ? 1 : 2, readFrameHeader.chromaType);
                    i3 = readFrameHeader.width;
                    i4 = readFrameHeader.height >> 1;
                    int[] iArr7 = readFrameHeader.qMatLuma;
                    int[] iArr8 = readFrameHeader.qMatChroma;
                    iArr6 = readFrameHeader.scan;
                    if (readFrameHeader.topFieldFirst) {
                        iArr5 = iArr7;
                        iArr3 = iArr8;
                        iArr4 = iArr6;
                        i6 = i8;
                        i5 = 2;
                    } else {
                        iArr5 = iArr7;
                        iArr3 = iArr8;
                        iArr4 = iArr6;
                        i5 = 1;
                        i6 = i8;
                    }
                }
                decodePicture(byteBuffer, iArr2, i3, i4, i6, iArr5, iArr3, iArr4, i5, readFrameHeader.chromaType);
                return new Picture(i, i2, iArr2, readFrameHeader.chromaType == 2 ? ColorSpace.YUV422_10 : ColorSpace.YUV444_10);
            }
        }
        throw new RuntimeException("Provided output picture won't fit into provided buffer");
    }

    public Picture[] decodeFields(ByteBuffer byteBuffer, int[][][] iArr) {
        FrameHeader readFrameHeader = readFrameHeader(byteBuffer);
        int i = (readFrameHeader.width + 15) & -16;
        int i2 = (readFrameHeader.height + 15) & -16;
        int i3 = i * i2;
        int i4 = i3 >> 1;
        if (readFrameHeader.frameType == 0) {
            if (iArr != null && iArr[0][0].length >= i3 && iArr[0][1].length >= i4) {
                if (iArr[0][2].length >= i4) {
                    decodePicture(byteBuffer, iArr[0], readFrameHeader.width, readFrameHeader.height, i >> 4, readFrameHeader.qMatLuma, readFrameHeader.qMatChroma, readFrameHeader.scan, 0, readFrameHeader.chromaType);
                    return new Picture[]{new Picture(i, i2, iArr[0], ColorSpace.YUV422_10)};
                }
            }
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        i3 = i4 >> 1;
        if (iArr != null && iArr[0][0].length >= i4 && iArr[0][1].length >= i3 && iArr[0][2].length >= i3 && iArr[1][0].length >= i4 && iArr[1][1].length >= i3) {
            if (iArr[1][2].length >= i3) {
                int[][] iArr2 = iArr[readFrameHeader.topFieldFirst ^ 1];
                int i5 = readFrameHeader.width;
                int i6 = readFrameHeader.height >> 1;
                i3 = i >> 4;
                int[] iArr3 = readFrameHeader.qMatLuma;
                int[] iArr4 = readFrameHeader.qMatChroma;
                int[] iArr5 = readFrameHeader.scan;
                int[] iArr6 = iArr5;
                decodePicture(byteBuffer, iArr2, i5, i6, i3, iArr3, iArr4, iArr6, 0, readFrameHeader.chromaType);
                decodePicture(byteBuffer, iArr[readFrameHeader.topFieldFirst], readFrameHeader.width, readFrameHeader.height >> 1, i3, readFrameHeader.qMatLuma, readFrameHeader.qMatChroma, readFrameHeader.scan, 0, readFrameHeader.chromaType);
                r1 = new Picture[2];
                i2 >>= 1;
                r1[0] = new Picture(i, i2, iArr[0], ColorSpace.YUV422_10);
                r1[1] = new Picture(i, i2, iArr[1], ColorSpace.YUV422_10);
                return r1;
            }
        }
        throw new RuntimeException("Provided output picture won't fit into provided buffer");
    }

    public static FrameHeader readFrameHeader(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i = byteBuffer.getInt();
        if ("icpf".equals(readSig(byteBuffer))) {
            int[] iArr;
            boolean z;
            int i2;
            int[] iArr2;
            int[] iArr3;
            int position;
            int i3;
            short s = byteBuffer.getShort();
            byteBuffer.getShort();
            byteBuffer.getInt();
            short s2 = byteBuffer.getShort();
            short s3 = byteBuffer.getShort();
            byte b = byteBuffer.get();
            int i4 = (b >> 2) & 3;
            int i5 = (b >> 6) & 3;
            int i6 = 0;
            if (i4 == 0) {
                iArr = ProresConsts.progressive_scan;
            } else {
                int[] iArr4 = ProresConsts.interlaced_scan;
                if (i4 == 1) {
                    iArr = iArr4;
                    z = true;
                    byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.get();
                    byteBuffer.get();
                    i2 = byteBuffer.get() & 255;
                    iArr2 = new int[64];
                    iArr3 = new int[64];
                    if (hasQMatLuma(i2)) {
                        Arrays.fill(iArr2, 4);
                    } else {
                        readQMat(byteBuffer2, iArr2, iArr);
                    }
                    if (hasQMatChroma(i2)) {
                        Arrays.fill(iArr3, 4);
                    } else {
                        readQMat(byteBuffer2, iArr3, iArr);
                    }
                    position = byteBuffer.position() + s;
                    i3 = 20 + (hasQMatLuma(i2) ? 64 : 0);
                    if (hasQMatChroma(i2)) {
                        i6 = 64;
                    }
                    byteBuffer2.position(position - (i3 + i6));
                    return new FrameHeader((i - s) - 8, s2, s3, i4, z, iArr, iArr2, iArr3, i5);
                }
                iArr = iArr4;
            }
            z = false;
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.get();
            i2 = byteBuffer.get() & 255;
            iArr2 = new int[64];
            iArr3 = new int[64];
            if (hasQMatLuma(i2)) {
                Arrays.fill(iArr2, 4);
            } else {
                readQMat(byteBuffer2, iArr2, iArr);
            }
            if (hasQMatChroma(i2)) {
                Arrays.fill(iArr3, 4);
            } else {
                readQMat(byteBuffer2, iArr3, iArr);
            }
            position = byteBuffer.position() + s;
            if (hasQMatLuma(i2)) {
            }
            i3 = 20 + (hasQMatLuma(i2) ? 64 : 0);
            if (hasQMatChroma(i2)) {
                i6 = 64;
            }
            byteBuffer2.position(position - (i3 + i6));
            return new FrameHeader((i - s) - 8, s2, s3, i4, z, iArr, iArr2, iArr3, i5);
        }
        throw new RuntimeException("Not a prores frame");
    }

    static final String readSig(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return new String(bArr);
    }

    protected void decodePicture(ByteBuffer byteBuffer, int[][] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int[] iArr4, int i4, int i5) {
        int i6 = i3;
        PictureHeader readPictureHeader = readPictureHeader(byteBuffer);
        int i7 = 1 << readPictureHeader.log2SliceMbWidth;
        int i8 = 0;
        int i9 = i8;
        int i10 = i9;
        while (i8 < readPictureHeader.sliceSizes.length) {
            int i11 = i7;
            while (i6 - i9 < i11) {
                i11 >>= 1;
            }
            int i12 = i11;
            decodeSlice(NIOUtils.read(byteBuffer, readPictureHeader.sliceSizes[i8]), iArr2, iArr3, iArr4, i11, i9, i10, readPictureHeader.sliceSizes[i8], iArr, i, i4, i5);
            i7 = i9 + i12;
            if (i7 == i6) {
                i7 = 1 << readPictureHeader.log2SliceMbWidth;
                i10++;
                i9 = 0;
            } else {
                i9 = i7;
                i7 = i12;
            }
            i8++;
        }
    }

    public static PictureHeader readPictureHeader(ByteBuffer byteBuffer) {
        byteBuffer.get();
        byteBuffer.getInt();
        short s = byteBuffer.getShort();
        int i = (byteBuffer.get() & 255) >> 4;
        short[] sArr = new short[s];
        for (short s2 = (short) 0; s2 < s; s2++) {
            sArr[s2] = byteBuffer.getShort();
        }
        return new PictureHeader(i, sArr);
    }

    private void decodeSlice(ByteBuffer byteBuffer, int[] iArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, short s, int[][] iArr4, int i4, int i5, int i6) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int[] iArr5 = iArr2;
        int i7 = i5;
        int i8 = (byteBuffer.get() & 255) >> 3;
        int clip = clip(byteBuffer.get() & 255, 1, JpegConst.APP0);
        if (clip > 128) {
            clip = (clip - 96) << 2;
        }
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        int[] iArr6 = iArr3;
        int i9 = i2;
        int i10 = i3;
        int i11 = (i << i6) >> 1;
        putSlice(iArr4, i4, i2, i3, decodeOnePlane(bitstream(byteBuffer2, s2), i << 2, scaleMat(iArr, clip), iArr6, i9, i10, 0), decodeOnePlane(bitstream(byteBuffer2, s3), i11, scaleMat(iArr5, clip), iArr6, i9, i10, 1), decodeOnePlane(bitstream(byteBuffer2, i8 > 7 ? byteBuffer.getShort() : ((s - s3) - s2) - i8), i11, scaleMat(iArr5, clip), iArr6, i9, i10, 2), i7 == 0 ? 0 : 1, i7 == 2 ? 1 : 0, i6);
    }

    public static final int[] scaleMat(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = iArr[i2] * i;
        }
        return iArr2;
    }

    static final BitReader bitstream(ByteBuffer byteBuffer, int i) {
        return new BitReader(NIOUtils.read(byteBuffer, i));
    }

    protected void putSlice(int[][] iArr, int i, int i2, int i3, int[] iArr2, int[] iArr3, int[] iArr4, int i4, int i5, int i6) {
        int[] iArr5 = iArr2;
        int length = iArr5.length >> 8;
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
        int i8 = i5;
        int i9 = i + ((i3 << 4) + ((i4 << 4) * i2));
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = i10 << 8;
            int[] iArr3 = iArr;
            int i12 = i2;
            int[] iArr4 = iArr2;
            int i13 = i6;
            int i14 = i7;
            putBlock(iArr3, i9, i12, iArr4, i11, i13, i14);
            putBlock(iArr3, i9 + 8, i12, iArr4, i11 + 64, i13, i14);
            int i15 = i9 + (8 * i2);
            putBlock(iArr3, i15, i12, iArr4, i11 + 128, i13, i14);
            putBlock(iArr3, i15 + 8, i12, iArr4, i11 + JpegConst.SOF0, i13, i14);
            i9 += 16;
        }
    }

    private void putChroma(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5, int i6, int i7) {
        int i8 = i5;
        int i9 = ((i3 << 3) + ((i4 << 4) * i2)) + i;
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = i10 << 7;
            int[] iArr3 = iArr;
            int i12 = i2;
            int[] iArr4 = iArr2;
            int i13 = i6;
            int i14 = i7;
            putBlock(iArr3, i9, i12, iArr4, i11, i13, i14);
            putBlock(iArr3, i9 + (8 * i2), i12, iArr4, i11 + 64, i13, i14);
            i9 += 8;
        }
    }

    private void putBlock(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5) {
        i5 = i3;
        i3 = i;
        for (i = 0; i < 8; i++) {
            for (int i6 = 0; i6 < 8; i6++) {
                iArr[i6 + i3] = clip(iArr2[i6 + i5], 4, 1019);
            }
            i3 += i2;
            i5 += 8;
        }
    }

    static final void readQMat(ByteBuffer byteBuffer, int[] iArr, int[] iArr2) {
        byte[] bArr = new byte[64];
        byteBuffer.get(bArr);
        for (byteBuffer = null; byteBuffer < 64; byteBuffer++) {
            iArr[byteBuffer] = bArr[iArr2[byteBuffer]] & 255;
        }
    }

    public boolean isProgressive(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(20) & 255) >> 2) & 3) == null ? true : null;
    }

    public int probe(ByteBuffer byteBuffer) {
        return (byteBuffer.get(4) == (byte) 105 && byteBuffer.get(5) == (byte) 99 && byteBuffer.get(6) == (byte) 112 && byteBuffer.get(7) == 102) ? 100 : null;
    }
}
