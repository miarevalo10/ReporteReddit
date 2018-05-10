package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.codecs.prores.ProresConsts.PictureHeader;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.tools.MathUtil;

public class ProresFix {
    static final void readDCCoeffs(BitReader bitReader, int[] iArr, int i) {
        iArr[0] = ProresDecoder.readCodeword(bitReader, ProresConsts.firstDCCodebook);
        if (iArr[0] < 0) {
            throw new RuntimeException("First DC coeff damaged");
        }
        int i2 = 5;
        int i3 = 1;
        int i4 = 64;
        while (i3 < i) {
            i2 = ProresDecoder.readCodeword(bitReader, ProresConsts.dcCodebooks[Math.min(i2, 6)]);
            if (i2 < 0) {
                throw new RuntimeException("DC coeff damaged");
            }
            iArr[i4] = i2;
            i3++;
            i4 += 64;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final void readACCoeffs(org.jcodec.common.io.BitReader r8, int[] r9, int r10, int[] r11) {
        /*
        r0 = r10 + -1;
        r10 = org.jcodec.common.tools.MathUtil.log2(r10);
        r1 = 64;
        r1 = r1 << r10;
        r2 = 4;
        r3 = 2;
        r4 = r3;
        r3 = r0;
    L_0x000d:
        r5 = r8.remaining();
        r6 = 32;
        if (r5 > r6) goto L_0x001f;
    L_0x0015:
        r5 = 24;
        r5 = r8.checkNBit(r5);
        if (r5 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r5 = org.jcodec.codecs.prores.ProresConsts.runCodebooks;
        r6 = 15;
        r2 = java.lang.Math.min(r2, r6);
        r2 = r5[r2];
        r2 = org.jcodec.codecs.prores.ProresDecoder.readCodeword(r8, r2);
        if (r2 < 0) goto L_0x006e;
    L_0x002f:
        r5 = r1 - r3;
        r5 = r5 + -1;
        if (r2 < r5) goto L_0x0036;
    L_0x0035:
        goto L_0x006e;
    L_0x0036:
        r5 = r2 + 1;
        r3 = r3 + r5;
        r5 = org.jcodec.codecs.prores.ProresConsts.levCodebooks;
        r6 = 9;
        r4 = java.lang.Math.min(r4, r6);
        r4 = r5[r4];
        r4 = org.jcodec.codecs.prores.ProresDecoder.readCodeword(r8, r4);
        r4 = r4 + 1;
        if (r4 < 0) goto L_0x0066;
    L_0x004b:
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r4 <= r5) goto L_0x0051;
    L_0x0050:
        goto L_0x0066;
    L_0x0051:
        r5 = r8.read1Bit();
        r5 = -r5;
        r6 = r3 >> r10;
        r7 = r3 & r0;
        r7 = r7 << 6;
        r6 = r11[r6];
        r7 = r7 + r6;
        r5 = org.jcodec.common.tools.MathUtil.toSigned(r4, r5);
        r9[r7] = r5;
        goto L_0x000d;
    L_0x0066:
        r8 = new java.lang.RuntimeException;
        r9 = "Level codeword damaged";
        r8.<init>(r9);
        throw r8;
    L_0x006e:
        r8 = new java.lang.RuntimeException;
        r9 = "Run codeword damaged";
        r8.<init>(r9);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresFix.readACCoeffs(org.jcodec.common.io.BitReader, int[], int, int[]):void");
    }

    static final void writeDCCoeffs(BitWriter bitWriter, int[] iArr, int i) {
        ProresEncoder.writeCodeword(bitWriter, ProresConsts.firstDCCodebook, iArr[0]);
        int i2 = 1;
        int i3 = 5;
        int i4 = 64;
        while (i2 < i) {
            ProresEncoder.writeCodeword(bitWriter, ProresConsts.dcCodebooks[Math.min(i3, 6)], iArr[i4]);
            i3 = iArr[i4];
            i2++;
            i4 += 64;
        }
    }

    static final void writeACCoeffs(BitWriter bitWriter, int[] iArr, int i, int[] iArr2) {
        int i2 = 1;
        int i3 = 4;
        int i4 = 2;
        int i5 = 0;
        while (i2 < 64) {
            int i6 = iArr2[i2];
            int i7 = i4;
            i4 = i3;
            for (i3 = 0; i3 < i; i3++) {
                int i8 = iArr[(i3 << 6) + i6];
                if (i8 == 0) {
                    i5++;
                } else {
                    ProresEncoder.writeCodeword(bitWriter, ProresConsts.runCodebooks[Math.min(i4, 15)], i5);
                    i4 = ProresEncoder.getLevel(i8);
                    ProresEncoder.writeCodeword(bitWriter, ProresConsts.levCodebooks[Math.min(i7, 9)], i4 - 1);
                    bitWriter.write1Bit(MathUtil.sign(i8));
                    i7 = i4;
                    i4 = i5;
                    i5 = 0;
                }
            }
            i2++;
            i3 = i4;
            i4 = i7;
        }
    }

    static void copyCoeff(org.jcodec.common.io.BitReader r1, org.jcodec.common.io.BitWriter r2, int r3, int[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3 << 6;
        r0 = new int[r0];
        readDCCoeffs(r1, r0, r3);	 Catch:{ RuntimeException -> 0x000a }
        readACCoeffs(r1, r0, r3, r4);	 Catch:{ RuntimeException -> 0x000a }
    L_0x000a:
        writeDCCoeffs(r2, r0, r3);
        writeACCoeffs(r2, r0, r3, r4);
        r2.flush();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.prores.ProresFix.copyCoeff(org.jcodec.common.io.BitReader, org.jcodec.common.io.BitWriter, int, int[]):void");
    }

    public static ByteBuffer transcode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer2 = byteBuffer2.slice();
        ByteBuffer duplicate = byteBuffer2.duplicate();
        FrameHeader readFrameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        ProresEncoder.writeFrameHeader(byteBuffer2, readFrameHeader);
        if (readFrameHeader.frameType == 0) {
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
        } else {
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
            transcodePicture(byteBuffer, byteBuffer2, readFrameHeader);
        }
        ProresEncoder.writeFrameHeader(duplicate, readFrameHeader);
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private static void transcodePicture(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, FrameHeader frameHeader) {
        PictureHeader readPictureHeader = ProresDecoder.readPictureHeader(byteBuffer);
        ProresEncoder.writePictureHeader(readPictureHeader.log2SliceMbWidth, readPictureHeader.sliceSizes.length, byteBuffer2);
        ByteBuffer duplicate = byteBuffer2.duplicate();
        byteBuffer2.position(byteBuffer2.position() + (readPictureHeader.sliceSizes.length << 1));
        int i = (frameHeader.width + 15) >> 4;
        int i2 = 0;
        int i3 = 1 << readPictureHeader.log2SliceMbWidth;
        for (int i4 = i2; i4 < readPictureHeader.sliceSizes.length; i4++) {
            while (i - i2 < i3) {
                i3 >>= 1;
            }
            int position = byteBuffer2.position();
            transcodeSlice(byteBuffer, byteBuffer2, i3, readPictureHeader.sliceSizes[i4], frameHeader);
            duplicate.putShort((short) (byteBuffer2.position() - position));
            i2 += i3;
            if (i2 == i) {
                i3 = 1 << readPictureHeader.log2SliceMbWidth;
                i2 = 0;
            }
        }
    }

    private static void transcodeSlice(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, short s, FrameHeader frameHeader) {
        int i2 = (byteBuffer.get() & 255) >> 3;
        int i3 = byteBuffer.get() & 255;
        short s2 = byteBuffer.getShort();
        short s3 = byteBuffer.getShort();
        s = ((s - s3) - s2) - i2;
        byteBuffer2.put((byte) 48);
        byteBuffer2.put((byte) i3);
        ByteBuffer duplicate = byteBuffer2.duplicate();
        byteBuffer2.putInt(0);
        i3 = byteBuffer2.position();
        copyCoeff(ProresDecoder.bitstream(byteBuffer, s2), new BitWriter(byteBuffer2), i << 2, frameHeader.scan);
        int position = byteBuffer2.position();
        i <<= 1;
        copyCoeff(ProresDecoder.bitstream(byteBuffer, s3), new BitWriter(byteBuffer2), i, frameHeader.scan);
        int position2 = byteBuffer2.position();
        copyCoeff(ProresDecoder.bitstream(byteBuffer, s), new BitWriter(byteBuffer2), i, frameHeader.scan);
        duplicate.putShort((short) (position - i3));
        duplicate.putShort((short) (position2 - position));
    }

    public static List<String> check(ByteBuffer byteBuffer) {
        List<String> arrayList = new ArrayList();
        byteBuffer.getInt();
        if ("icpf".equals(ProresDecoder.readSig(byteBuffer))) {
            short s = byteBuffer.getShort();
            if (s > (short) 148) {
                arrayList.add("[ERROR] Wrong ProRes frame header.");
                return arrayList;
            }
            byteBuffer.getShort();
            byteBuffer.getInt();
            short s2 = byteBuffer.getShort();
            short s3 = byteBuffer.getShort();
            if (s2 >= (short) 0 && s2 <= (short) 10000 && s3 >= (short) 0) {
                if (s3 <= (short) 10000) {
                    byte b = byteBuffer.get();
                    byteBuffer.position((byteBuffer.position() + s) - 13);
                    if (((b >> 2) & 3) == 0) {
                        checkPicture(byteBuffer, s2, s3, arrayList);
                    } else {
                        int i = s3 / 2;
                        checkPicture(byteBuffer, s2, i, arrayList);
                        checkPicture(byteBuffer, s2, i, arrayList);
                    }
                    return arrayList;
                }
            }
            byteBuffer = new StringBuilder("[ERROR] Wrong ProRes frame header, invalid image size [");
            byteBuffer.append(s2);
            byteBuffer.append("x");
            byteBuffer.append(s3);
            byteBuffer.append("].");
            arrayList.add(byteBuffer.toString());
            return arrayList;
        }
        arrayList.add("[ERROR] Missing ProRes signature (icpf).");
        return arrayList;
    }

    private static void checkPicture(ByteBuffer byteBuffer, int i, int i2, List<String> list) {
        i2 = ProresDecoder.readPictureHeader(byteBuffer);
        i = (i + 15) >> 4;
        int i3 = 1 << i2.log2SliceMbWidth;
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        while (i4 < i2.sliceSizes.length) {
            while (i - i5 < i3) {
                i3 >>= 1;
            }
            try {
                checkSlice(NIOUtils.read(byteBuffer, i2.sliceSizes[i4]), i3);
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("[ERROR] Slice data corrupt: mbX = ");
                stringBuilder.append(i5);
                stringBuilder.append(", mbY = ");
                stringBuilder.append(i6);
                stringBuilder.append(". ");
                stringBuilder.append(e.getMessage());
                list.add(stringBuilder.toString());
            }
            i5 += i3;
            if (i5 == i) {
                i3 = 1 << i2.log2SliceMbWidth;
                i6++;
                i5 = 0;
            }
            i4++;
        }
    }

    private static void checkSlice(ByteBuffer byteBuffer, int i) {
        int remaining = byteBuffer.remaining();
        int i2 = (byteBuffer.get() & 255) >> 3;
        byteBuffer.get();
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        remaining = ((remaining - s2) - s) - i2;
        checkCoeff(ProresDecoder.bitstream(byteBuffer, s), i << 2);
        i <<= 1;
        checkCoeff(ProresDecoder.bitstream(byteBuffer, s2), i);
        checkCoeff(ProresDecoder.bitstream(byteBuffer, remaining), i);
    }

    private static void checkCoeff(BitReader bitReader, int i) {
        int[] iArr = new int[64];
        int[] iArr2 = new int[(i << 6)];
        readDCCoeffs(bitReader, iArr2, i);
        readACCoeffs(bitReader, iArr2, i, iArr);
    }
}
