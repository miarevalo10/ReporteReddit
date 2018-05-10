package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.codecs.prores.ProresConsts.PictureHeader;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class ProresToProxy {
    private static final int START_QP = 6;
    private int bitsPer1024;
    private int bitsPer1024High;
    private int bitsPer1024Low;
    private int frameSize;
    private int nCoeffs;
    private int[] qMatChromaTo = ProresConsts.QMAT_CHROMA_APCO;
    private int[] qMatLumaTo = ProresConsts.QMAT_LUMA_APCO;

    public ProresToProxy(int i, int i2, int i3) {
        this.frameSize = i3;
        i *= i2;
        this.bitsPer1024 = (((i3 - ((((i2 >> 4) * (((i >> 4) + 7) >> 3)) * 8) + 148)) << 3) << 10) / i;
        this.bitsPer1024High = this.bitsPer1024 - (this.bitsPer1024 / 10);
        this.bitsPer1024Low = this.bitsPer1024 - (this.bitsPer1024 / 20);
        this.nCoeffs = Math.max(Math.min(33000 / (i >> 8), 64), 4);
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    void requant(org.jcodec.common.io.BitReader r11, org.jcodec.common.io.BitWriter r12, int r13, int[] r14, int[] r15, int[] r16, int r17, int r18, int r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10;
        r8 = r13;
        r1 = r8 << 6;
        r9 = new int[r1];
        r1 = 64;
        r2 = r11;
        r3 = r14;
        org.jcodec.codecs.prores.ProresDecoder.readDCCoeffs(r2, r3, r9, r8, r1);	 Catch:{ RuntimeException -> 0x0019 }
        r6 = r0.nCoeffs;	 Catch:{ RuntimeException -> 0x0019 }
        r7 = 6;	 Catch:{ RuntimeException -> 0x0019 }
        r1 = r2;	 Catch:{ RuntimeException -> 0x0019 }
        r2 = r3;	 Catch:{ RuntimeException -> 0x0019 }
        r3 = r9;	 Catch:{ RuntimeException -> 0x0019 }
        r4 = r8;	 Catch:{ RuntimeException -> 0x0019 }
        r5 = r16;	 Catch:{ RuntimeException -> 0x0019 }
        org.jcodec.codecs.prores.ProresDecoder.readACCoeffs(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ RuntimeException -> 0x0019 }
    L_0x0019:
        r1 = 0;
    L_0x001a:
        r2 = r9.length;
        if (r1 >= r2) goto L_0x0026;
    L_0x001d:
        r2 = r9[r1];
        r2 = r2 << 2;
        r9[r1] = r2;
        r1 = r1 + 1;
        goto L_0x001a;
    L_0x0026:
        r7 = r12;
        r2 = r15;
        org.jcodec.codecs.prores.ProresEncoder.writeDCCoeffs(r7, r2, r9, r8);
        r6 = r0.nCoeffs;
        r1 = r7;
        r3 = r9;
        r4 = r8;
        r5 = r16;
        org.jcodec.codecs.prores.ProresEncoder.writeACCoeffs(r1, r2, r3, r4, r5, r6);
        r7.flush();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresToProxy.requant(org.jcodec.common.io.BitReader, org.jcodec.common.io.BitWriter, int, int[], int[], int[], int, int, int):void");
    }

    public void transcode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer duplicate = byteBuffer2.duplicate();
        FrameHeader readFrameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        ProresEncoder.writeFrameHeader(byteBuffer2, readFrameHeader);
        int position = byteBuffer2.position();
        if (readFrameHeader.frameType == 0) {
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
        } else {
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
        }
        readFrameHeader.qMatLuma = this.qMatLumaTo;
        readFrameHeader.qMatChroma = this.qMatChromaTo;
        readFrameHeader.payloadSize = byteBuffer2.position() - position;
        ProresEncoder.writeFrameHeader(duplicate, readFrameHeader);
    }

    private void transcodePicture(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, FrameHeader frameHeader) {
        ProresToProxy proresToProxy = this;
        ByteBuffer byteBuffer3 = byteBuffer2;
        FrameHeader frameHeader2 = frameHeader;
        PictureHeader readPictureHeader = ProresDecoder.readPictureHeader(byteBuffer);
        ProresEncoder.writePictureHeader(readPictureHeader.log2SliceMbWidth, readPictureHeader.sliceSizes.length, byteBuffer3);
        ByteBuffer duplicate = byteBuffer2.duplicate();
        byteBuffer3.position(byteBuffer2.position() + (readPictureHeader.sliceSizes.length << 1));
        int i = (frameHeader2.width + 15) >> 4;
        int i2 = 1 << readPictureHeader.log2SliceMbWidth;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        int i7 = 6;
        while (i3 < readPictureHeader.sliceSizes.length) {
            int i8;
            int i9;
            int i10 = i2;
            while (i - i4 < i10) {
                i10 >>= 1;
            }
            int position = byteBuffer2.position();
            int i11 = i10;
            int i12 = i7;
            int i13 = i3;
            int i14 = i;
            ByteBuffer byteBuffer4 = duplicate;
            transcodeSlice(byteBuffer, byteBuffer3, frameHeader2.qMatLuma, frameHeader2.qMatChroma, frameHeader2.scan, i10, i4, i5, readPictureHeader.sliceSizes[i3], i12);
            short position2 = (short) (byteBuffer2.position() - position);
            byteBuffer4.putShort(position2);
            short s = ((i11 * proresToProxy.bitsPer1024High) >> 5) + 6;
            short s2 = ((i11 * proresToProxy.bitsPer1024Low) >> 5) + 6;
            if (position2 > s) {
                i8 = i12;
                if (i8 < 128) {
                    i7 = i8 + 1;
                    if (position2 > s + i6 && i7 < 128) {
                        i7++;
                    }
                    i6 += s - position2;
                    i2 = i4 + i11;
                    i9 = i14;
                    if (i2 != i9) {
                        i2 = 1 << readPictureHeader.log2SliceMbWidth;
                        i5++;
                        i4 = 0;
                    } else {
                        i4 = i2;
                        i2 = i11;
                    }
                    i3 = i13 + 1;
                    i = i9;
                    duplicate = byteBuffer4;
                }
            } else {
                i8 = i12;
            }
            i7 = (position2 >= s2 || i8 <= 2 || i6 <= 0) ? i8 : i8 - 1;
            i6 += s - position2;
            i2 = i4 + i11;
            i9 = i14;
            if (i2 != i9) {
                i4 = i2;
                i2 = i11;
            } else {
                i2 = 1 << readPictureHeader.log2SliceMbWidth;
                i5++;
                i4 = 0;
            }
            i3 = i13 + 1;
            i = i9;
            duplicate = byteBuffer4;
        }
    }

    private void transcodeSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int[] iArr, int[] iArr2, int[] iArr3, int i, int i2, int i3, short s, int i4) {
        ProresToProxy proresToProxy = this;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        int[] iArr4 = iArr2;
        int i5 = i4;
        int i6 = (byteBuffer.get() & 255) >> 3;
        int clip = ProresDecoder.clip(byteBuffer.get() & 255, 1, JpegConst.APP0);
        if (clip > 128) {
            clip = (clip - 96) << 2;
        }
        int i7 = clip;
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        int i8 = ((s - s3) - s2) - i6;
        byteBuffer4.put((byte) 48);
        byteBuffer4.put((byte) i5);
        ByteBuffer duplicate = byteBuffer2.duplicate();
        byteBuffer4.putInt(0);
        int position = byteBuffer2.position();
        BitReader bitstream = ProresDecoder.bitstream(byteBuffer3, s2);
        BitWriter bitWriter = new BitWriter(byteBuffer4);
        int i9 = i << 2;
        int[] scaleMat = ProresDecoder.scaleMat(iArr, i7);
        ByteBuffer byteBuffer5 = duplicate;
        int[] scaleMat2 = ProresDecoder.scaleMat(proresToProxy.qMatLumaTo, i5);
        int i10 = i8;
        int[] iArr5 = iArr3;
        short s4 = s3;
        int i11 = i2;
        i5 = i7;
        i7 = i3;
        int i12 = 1;
        requant(bitstream, bitWriter, i9, scaleMat, scaleMat2, iArr5, i11, i7, 0);
        int position2 = byteBuffer2.position();
        bitstream = ProresDecoder.bitstream(byteBuffer3, s4);
        bitWriter = new BitWriter(byteBuffer4);
        int i13 = i << 1;
        scaleMat = ProresDecoder.scaleMat(iArr4, i5);
        int i14 = i5;
        i5 = i4;
        i9 = i13;
        int i15 = i13;
        i13 = i14;
        requant(bitstream, bitWriter, i9, scaleMat, ProresDecoder.scaleMat(proresToProxy.qMatChromaTo, i5), iArr5, i11, i7, 1);
        i12 = byteBuffer2.position();
        requant(ProresDecoder.bitstream(byteBuffer3, i10), new BitWriter(byteBuffer4), i15, ProresDecoder.scaleMat(iArr4, i13), ProresDecoder.scaleMat(proresToProxy.qMatChromaTo, i5), iArr5, i11, i7, 2);
        ByteBuffer byteBuffer6 = byteBuffer5;
        byteBuffer6.putShort((short) (position2 - position));
        byteBuffer6.putShort((short) (i12 - position2));
    }
}
