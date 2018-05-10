package org.jcodec.codecs.prores;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.prores.ProresConsts.FrameHeader;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.dct.DCTRef;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.ImageOP;
import org.jcodec.common.tools.MathUtil;

public class ProresEncoder {
    private static final int DEFAULT_SLICE_MB_WIDTH = 8;
    private static final int LOG_DEFAULT_SLICE_MB_WIDTH = 3;
    protected Profile profile;
    private int[][] scaledChroma;
    private int[][] scaledLuma;

    public enum Profile {
        PROXY(ProresConsts.QMAT_LUMA_APCO, ProresConsts.QMAT_CHROMA_APCO, "apco", 1000, 4, 8),
        LT(ProresConsts.QMAT_LUMA_APCS, ProresConsts.QMAT_CHROMA_APCS, "apcs", 2100, 1, 9),
        STANDARD(ProresConsts.QMAT_LUMA_APCN, ProresConsts.QMAT_CHROMA_APCN, "apcn", 3500, 1, 6),
        HQ(ProresConsts.QMAT_LUMA_APCH, ProresConsts.QMAT_CHROMA_APCH, "apch", 5400, 1, 6);
        
        final int bitrate;
        final int firstQp;
        public final String fourcc;
        final int lastQp;
        final int[] qmatChroma;
        final int[] qmatLuma;

        private Profile(int[] iArr, int[] iArr2, String str, int i, int i2, int i3) {
            this.qmatLuma = iArr;
            this.qmatChroma = iArr2;
            this.fourcc = str;
            this.bitrate = i;
            this.firstQp = i2;
            this.lastQp = i3;
        }
    }

    private int calcNSlices(int i, int i2) {
        int i3 = i >> 3;
        for (int i4 = 0; i4 < 3; i4++) {
            i3 += (i >> i4) & 1;
        }
        return i3 * i2;
    }

    private static final int diffSign(int i, int i2) {
        return (i >> 31) ^ i2;
    }

    public static final int getLevel(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    private static final int toGolumb(int i) {
        return (i >> 31) ^ (i << 1);
    }

    private static final int toGolumb(int i, int i2) {
        return i == 0 ? 0 : (i << 1) + i2;
    }

    public ProresEncoder(Profile profile) {
        this.profile = profile;
        this.scaledLuma = scaleQMat(profile.qmatLuma, 1, 16);
        this.scaledChroma = scaleQMat(profile.qmatChroma, 1, 16);
    }

    private int[][] scaleQMat(int[] iArr, int i, int i2) {
        int[][] iArr2 = new int[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr2[i3][i4] = iArr[i4] * (i3 + i);
            }
        }
        return iArr2;
    }

    public static final void writeCodeword(BitWriter bitWriter, Codebook codebook, int i) {
        int i2 = (codebook.switchBits + 1) << codebook.riceOrder;
        if (i >= i2) {
            i = (i - i2) + (1 << codebook.expOrder);
            i2 = MathUtil.log2(i);
            int i3 = ((i2 - codebook.expOrder) + codebook.switchBits) + 1;
            for (codebook = null; codebook < i3; codebook++) {
                bitWriter.write1Bit(0);
            }
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(i, i2);
        } else if (codebook.riceOrder > 0) {
            for (i2 = 0; i2 < (i >> codebook.riceOrder); i2++) {
                bitWriter.write1Bit(0);
            }
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(i & ((1 << codebook.riceOrder) - 1), codebook.riceOrder);
        } else {
            for (codebook = null; codebook < i; codebook++) {
                bitWriter.write1Bit(0);
            }
            bitWriter.write1Bit(1);
        }
    }

    private static final int qScale(int[] iArr, int i, int i2) {
        return i2 / iArr[i];
    }

    static final void writeDCCoeffs(BitWriter bitWriter, int[] iArr, int[] iArr2, int i) {
        int qScale = qScale(iArr, 0, iArr2[0] - 16384);
        writeCodeword(bitWriter, ProresConsts.firstDCCodebook, toGolumb(qScale));
        int i2 = 1;
        int i3 = 0;
        int i4 = 5;
        int i5 = qScale;
        qScale = 64;
        while (i2 < i) {
            int qScale2 = qScale(iArr, 0, iArr2[qScale] - 16384);
            i5 = qScale2 - i5;
            i3 = toGolumb(getLevel(i5), diffSign(i5, i3));
            writeCodeword(bitWriter, ProresConsts.dcCodebooks[Math.min(i4, 6)], i3);
            i2++;
            qScale += 64;
            i4 = i3;
            i3 = i5 >> 31;
            i5 = qScale2;
        }
    }

    static final void writeACCoeffs(BitWriter bitWriter, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int i3 = 1;
        int i4 = 4;
        int i5 = 2;
        int i6 = 0;
        while (i3 < i2) {
            int i7 = iArr3[i3];
            int i8 = i5;
            i5 = i4;
            for (i4 = 0; i4 < i; i4++) {
                int qScale = qScale(iArr, i7, iArr2[(i4 << 6) + i7]);
                if (qScale == 0) {
                    i6++;
                } else {
                    writeCodeword(bitWriter, ProresConsts.runCodebooks[Math.min(i5, 15)], i6);
                    i5 = getLevel(qScale);
                    writeCodeword(bitWriter, ProresConsts.levCodebooks[Math.min(i8, 9)], i5 - 1);
                    bitWriter.write1Bit(MathUtil.sign(qScale));
                    i8 = i5;
                    i5 = i6;
                    i6 = 0;
                }
            }
            i3++;
            i4 = i5;
            i5 = i8;
        }
    }

    static final void encodeOnePlane(BitWriter bitWriter, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        writeDCCoeffs(bitWriter, iArr, iArr3, i);
        writeACCoeffs(bitWriter, iArr, iArr3, i, iArr2, 64);
    }

    private void dctOnePlane(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            DCTRef.fdct(iArr, i2 << 6);
        }
    }

    protected int encodeSlice(ByteBuffer byteBuffer, int[][] iArr, int[][] iArr2, int[] iArr3, int i, int i2, int i3, Picture picture, int i4, int i5, int i6, boolean z) {
        int[] iArr4;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i4;
        Picture splitSlice = splitSlice(picture, i2, i3, i, z);
        dctOnePlane(i << 2, splitSlice.getPlaneData(0));
        int i8 = i << 1;
        dctOnePlane(i8, splitSlice.getPlaneData(1));
        dctOnePlane(i8, splitSlice.getPlaneData(2));
        i8 = (i >> 2) * this.profile.bitrate;
        int i9 = i8 >> 3;
        int i10 = i8 - i9;
        i8 += i9;
        byteBuffer2.put((byte) 48);
        ByteBuffer duplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer2, 5);
        int position = byteBuffer.position();
        int[] iArr5 = new int[3];
        int i11 = i7 - 1;
        int i12 = position;
        position = i7;
        int i13 = i7;
        int[] iArr6 = iArr5;
        encodeSliceData(byteBuffer2, iArr[i11], iArr2[i11], iArr3, i, splitSlice, position, iArr6);
        if (bits(iArr6) <= i8 || i13 >= r6.profile.lastQp) {
            iArr4 = iArr6;
            if (bits(iArr4) < i10 && i13 > r6.profile.firstQp) {
                do {
                    i13--;
                    byteBuffer2.position(i12);
                    i11 = i13 - 1;
                    encodeSliceData(byteBuffer2, iArr[i11], iArr2[i11], iArr3, i, splitSlice, i13, iArr4);
                    if (bits(iArr4) >= i10) {
                        break;
                    }
                } while (i13 > r6.profile.firstQp);
            }
        } else {
            int[] iArr7;
            while (true) {
                i13++;
                byteBuffer2.position(i12);
                i10 = i13 - 1;
                iArr7 = iArr6;
                encodeSliceData(byteBuffer2, iArr[i10], iArr2[i10], iArr3, i, splitSlice, i13, iArr6);
                if (bits(iArr7) <= i8) {
                    break;
                } else if (i13 >= r6.profile.lastQp) {
                    break;
                } else {
                    iArr6 = iArr7;
                }
            }
            iArr4 = iArr7;
        }
        duplicate.put((byte) i13);
        duplicate.putShort((short) iArr4[0]);
        duplicate.putShort((short) iArr4[1]);
        return i13;
    }

    static final int bits(int[] iArr) {
        return ((iArr[0] + iArr[1]) + iArr[2]) << 3;
    }

    protected static final void encodeSliceData(ByteBuffer byteBuffer, int[] iArr, int[] iArr2, int[] iArr3, int i, Picture picture, int i2, int[] iArr4) {
        iArr4[0] = onePlane(byteBuffer, i << 2, iArr, iArr3, picture.getPlaneData(0));
        i <<= 1;
        iArr4[1] = onePlane(byteBuffer, i, iArr2, iArr3, picture.getPlaneData(1));
        iArr4[2] = onePlane(byteBuffer, i, iArr2, iArr3, picture.getPlaneData(2));
    }

    static final int onePlane(ByteBuffer byteBuffer, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int position = byteBuffer.position();
        BitWriter bitWriter = new BitWriter(byteBuffer);
        encodeOnePlane(bitWriter, i, iArr, iArr2, iArr3);
        bitWriter.flush();
        return byteBuffer.position() - position;
    }

    protected void encodePicture(ByteBuffer byteBuffer, int[][] iArr, int[][] iArr2, int[] iArr3, Picture picture) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int width = (picture.getWidth() + 15) >> 4;
        int height = (picture.getHeight() + 15) >> 4;
        int i = this.profile.firstQp;
        int calcNSlices = calcNSlices(width, height);
        writePictureHeader(3, calcNSlices, byteBuffer2);
        ByteBuffer duplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer2, calcNSlices << 1);
        int[] iArr4 = new int[calcNSlices];
        calcNSlices = 0;
        int i2 = calcNSlices;
        while (i2 < height) {
            int[] iArr5;
            ByteBuffer byteBuffer3;
            int i3;
            ProresEncoder proresEncoder;
            int i4 = 8;
            int i5 = i;
            int i6 = calcNSlices;
            int i7 = 0;
            while (i7 < width) {
                boolean z;
                int i8;
                int i9;
                int i10;
                int i11 = i4;
                while (width - i7 < i11) {
                    i11 >>= 1;
                }
                int position = byteBuffer.position();
                Object obj = (picture.getHeight() % 16 == 0 || i2 != height - 1) ? null : 1;
                Object obj2 = (picture.getWidth() % 16 == 0 || i7 + i11 != width) ? null : 1;
                if (obj == null) {
                    if (obj2 == null) {
                        z = false;
                        i8 = i11;
                        i9 = i7;
                        i10 = i2;
                        iArr5 = iArr4;
                        byteBuffer3 = duplicate;
                        i3 = height;
                        i5 = proresEncoder.encodeSlice(byteBuffer2, iArr, iArr2, iArr3, i11, i7, i2, picture, i5, width, height, z);
                        byteBuffer3.putShort((short) (byteBuffer.position() - position));
                        i = i6 + 1;
                        iArr5[i6] = (short) (byteBuffer.position() - position);
                        i7 = i9 + i8;
                        i6 = i;
                        duplicate = byteBuffer3;
                        i4 = i8;
                        i2 = i10;
                        iArr4 = iArr5;
                        height = i3;
                        proresEncoder = this;
                    }
                }
                z = true;
                i8 = i11;
                i9 = i7;
                i10 = i2;
                iArr5 = iArr4;
                byteBuffer3 = duplicate;
                i3 = height;
                i5 = proresEncoder.encodeSlice(byteBuffer2, iArr, iArr2, iArr3, i11, i7, i2, picture, i5, width, height, z);
                byteBuffer3.putShort((short) (byteBuffer.position() - position));
                i = i6 + 1;
                iArr5[i6] = (short) (byteBuffer.position() - position);
                i7 = i9 + i8;
                i6 = i;
                duplicate = byteBuffer3;
                i4 = i8;
                i2 = i10;
                iArr4 = iArr5;
                height = i3;
                proresEncoder = this;
            }
            iArr5 = iArr4;
            byteBuffer3 = duplicate;
            i3 = height;
            i2++;
            i = i5;
            calcNSlices = i6;
            proresEncoder = this;
        }
    }

    public static void writePictureHeader(int i, int i2, ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 64);
        byteBuffer.putInt(0);
        byteBuffer.putShort((short) i2);
        byteBuffer.put((byte) (i << 4));
    }

    private Picture splitSlice(Picture picture, int i, int i2, int i3, boolean z) {
        int i4 = i3 << 4;
        Picture create = Picture.create(i4, 16, ColorSpace.YUV422_10);
        if (z) {
            Picture create2 = Picture.create(i4, 16, ColorSpace.YUV422_10);
            ImageOP.subImageWithFill(picture, create2, new Rect(i << 4, i2 << 4, i4, 16));
            split(create2, create, 0, 0, i3);
        } else {
            split(picture, create, i, i2, i3);
        }
        return create;
    }

    private void split(Picture picture, Picture picture2, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        split(picture.getPlaneData(0), picture2.getPlaneData(0), picture.getPlaneWidth(0), i4, i5, i6, 0);
        split(picture.getPlaneData(1), picture2.getPlaneData(1), picture.getPlaneWidth(1), i4, i5, i6, 1);
        split(picture.getPlaneData(2), picture2.getPlaneData(2), picture.getPlaneWidth(2), i4, i5, i6, 1);
    }

    private int[] split(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5) {
        int i6 = i4;
        int i7 = ((i3 << 4) * i) + (i2 << (4 - i5));
        int i8 = 0;
        int i9 = i8;
        while (i8 < i6) {
            int[] iArr3 = iArr;
            int i10 = i;
            int[] iArr4 = iArr2;
            splitBlock(iArr3, i10, i7, iArr4, i9);
            int i11 = i7 + (i << 3);
            splitBlock(iArr3, i10, i11, iArr4, i9 + (128 >> i5));
            if (i5 == 0) {
                iArr3 = iArr;
                i10 = i;
                iArr4 = iArr2;
                splitBlock(iArr3, i10, i7 + 8, iArr4, i9 + 64);
                splitBlock(iArr3, i10, i11 + 8, iArr4, i9 + JpegConst.SOF0);
            }
            i9 += 256 >> i5;
            i7 += 16 >> i5;
            i8++;
        }
        return iArr2;
    }

    private void splitBlock(int[] iArr, int i, int i2, int[] iArr2, int i3) {
        int i4 = i3;
        i3 = i2;
        for (i2 = 0; i2 < 8; i2++) {
            int i5 = i3;
            i3 = 0;
            while (i3 < 8) {
                int i6 = i4 + 1;
                int i7 = i5 + 1;
                iArr2[i4] = iArr[i5];
                i3++;
                i4 = i6;
                i5 = i7;
            }
            i3 = (i - 8) + i5;
        }
    }

    public void encodeFrame(ByteBuffer byteBuffer, Picture... pictureArr) {
        ProresEncoder proresEncoder = this;
        Picture[] pictureArr2 = pictureArr;
        ByteBuffer duplicate = byteBuffer.duplicate();
        int[] iArr = pictureArr2.length > 1 ? ProresConsts.interlaced_scan : ProresConsts.progressive_scan;
        FrameHeader frameHeader = new FrameHeader(0, pictureArr2[0].getCroppedWidth(), pictureArr2[0].getCroppedHeight() * pictureArr2.length, pictureArr2.length == 1 ? 0 : 1, true, iArr, proresEncoder.profile.qmatLuma, proresEncoder.profile.qmatChroma, 2);
        ByteBuffer byteBuffer2 = byteBuffer;
        writeFrameHeader(byteBuffer2, frameHeader);
        encodePicture(byteBuffer2, proresEncoder.scaledLuma, proresEncoder.scaledChroma, iArr, pictureArr2[0]);
        if (pictureArr2.length > 1) {
            encodePicture(byteBuffer2, proresEncoder.scaledLuma, proresEncoder.scaledChroma, iArr, pictureArr2[1]);
        }
        byteBuffer.flip();
        duplicate.putInt(byteBuffer.remaining());
    }

    public static void writeFrameHeader(ByteBuffer byteBuffer, FrameHeader frameHeader) {
        byteBuffer.putInt(156 + frameHeader.payloadSize);
        byteBuffer.put(new byte[]{(byte) 105, (byte) 99, (byte) 112, (byte) 102});
        byteBuffer.putShort((short) 148);
        byteBuffer.putShort((short) 0);
        byteBuffer.put(new byte[]{(byte) 97, (byte) 112, (byte) 108, (byte) 48});
        byteBuffer.putShort((short) frameHeader.width);
        byteBuffer.putShort((short) frameHeader.height);
        byteBuffer.put((byte) (frameHeader.frameType == 0 ? 131 : 135));
        byteBuffer.put(new byte[]{(byte) 0, (byte) 2, (byte) 2, (byte) 6, (byte) 32, (byte) 0});
        byteBuffer.put((byte) 3);
        writeQMat(byteBuffer, frameHeader.qMatLuma);
        writeQMat(byteBuffer, frameHeader.qMatChroma);
    }

    static final void writeQMat(ByteBuffer byteBuffer, int[] iArr) {
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) iArr[i]);
        }
    }
}
