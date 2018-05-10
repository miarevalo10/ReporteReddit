package org.jcodec.codecs.vpx;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.jcodec.codecs.common.biari.VPxBooleanEncoder;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

public class VP8Encoder implements VideoEncoder {
    private VPXBitstream bitstream;
    private ByteBuffer dataBuffer;
    private ByteBuffer headerBuffer;
    private int[][] leftRow;
    private VPXQuantizer quantizer;
    private RateControl rc;
    private int[] tmp;
    private int[][] topLine;

    public VP8Encoder(int i) {
        this(new NopRateControl(i));
    }

    public VP8Encoder(RateControl rateControl) {
        this.tmp = new int[16];
        this.rc = rateControl;
    }

    public ByteBuffer encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        int i;
        int[] iArr;
        ByteBuffer duplicate = byteBuffer.duplicate();
        int width = (picture.getWidth() + 15) >> 4;
        int height = (picture.getHeight() + 15) >> 4;
        prepareBuffers(width, height);
        this.bitstream = new VPXBitstream(VPXConst.tokenDefaultBinProbs, width);
        this.leftRow = new int[][]{new int[16], new int[8], new int[8]};
        r0 = new int[3][];
        int i2 = width << 3;
        r0[1] = new int[i2];
        r0[2] = new int[i2];
        this.topLine = r0;
        int i3 = 129;
        initValue(this.leftRow, 129);
        initValue(this.topLine, 127);
        this.quantizer = new VPXQuantizer();
        Picture create = Picture.create(16, 16, ColorSpace.YUV420);
        int[] segmentQps = this.rc.getSegmentQps();
        VPxBooleanEncoder vPxBooleanEncoder = new VPxBooleanEncoder(this.dataBuffer);
        int[] iArr2 = new int[(width * height)];
        int i4 = 0;
        int i5 = i4;
        while (i5 < height) {
            VPxBooleanEncoder vPxBooleanEncoder2;
            initValue(r7.leftRow, i3);
            int i6 = i4;
            i = 0;
            while (i < width) {
                int position = vPxBooleanEncoder.position();
                int segment = r7.rc.getSegment();
                iArr2[i6] = segment;
                Picture picture2 = picture;
                int i7 = i;
                int i8 = i5;
                iArr = iArr2;
                VPxBooleanEncoder vPxBooleanEncoder3 = vPxBooleanEncoder;
                Picture picture3 = create;
                luma(picture2, i, i5, vPxBooleanEncoder, segmentQps[segment], picture3);
                chroma(picture2, i7, i8, vPxBooleanEncoder3, segmentQps[segment], picture3);
                vPxBooleanEncoder2 = vPxBooleanEncoder3;
                r7.rc.report(vPxBooleanEncoder2.position() - position);
                i4 = i7;
                collectPredictors(create, i4);
                i = i4 + 1;
                i6++;
                vPxBooleanEncoder = vPxBooleanEncoder2;
                iArr2 = iArr;
                i5 = i8;
            }
            iArr = iArr2;
            vPxBooleanEncoder2 = vPxBooleanEncoder;
            i5++;
            i4 = i6;
            i3 = 129;
        }
        iArr = iArr2;
        vPxBooleanEncoder.stop();
        r7.dataBuffer.flip();
        VPxBooleanEncoder vPxBooleanEncoder4 = new VPxBooleanEncoder(r7.headerBuffer);
        int[] calcSegmentProbs = calcSegmentProbs(iArr);
        writeHeader2(vPxBooleanEncoder4, segmentQps, calcSegmentProbs);
        int i9 = 0;
        i = i9;
        while (i9 < height) {
            i5 = i;
            i = 0;
            while (i < width) {
                writeSegmetId(vPxBooleanEncoder4, iArr[i5], calcSegmentProbs);
                vPxBooleanEncoder4.writeBit(145, 1);
                vPxBooleanEncoder4.writeBit(156, 0);
                vPxBooleanEncoder4.writeBit(163, 0);
                vPxBooleanEncoder4.writeBit(142, 0);
                i++;
                i5++;
            }
            i9++;
            i = i5;
        }
        vPxBooleanEncoder4.stop();
        r7.headerBuffer.flip();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        writeHeader(duplicate, picture.getWidth(), picture.getHeight(), r7.headerBuffer.remaining());
        duplicate.put(r7.headerBuffer);
        duplicate.put(r7.dataBuffer);
        duplicate.flip();
        return duplicate;
    }

    private void prepareBuffers(int i, int i2) {
        int i3 = (i2 * i2) << 10;
        i2 = 256 + (i * i2);
        if (this.headerBuffer != 0) {
            if (this.headerBuffer.capacity() >= i2) {
                this.headerBuffer.clear();
                if (this.dataBuffer != 0) {
                    if (this.dataBuffer.capacity() < i3) {
                        this.dataBuffer.clear();
                        return;
                    }
                }
                this.dataBuffer = ByteBuffer.allocate(i3);
            }
        }
        this.headerBuffer = ByteBuffer.allocate(i2);
        if (this.dataBuffer != 0) {
            if (this.dataBuffer.capacity() < i3) {
                this.dataBuffer.clear();
                return;
            }
        }
        this.dataBuffer = ByteBuffer.allocate(i3);
    }

    private void writeSegmetId(VPxBooleanEncoder vPxBooleanEncoder, int i, int[] iArr) {
        int i2 = (i >> 1) & 1;
        vPxBooleanEncoder.writeBit(iArr[0], i2);
        vPxBooleanEncoder.writeBit(iArr[i2 + 1], i & 1);
    }

    private int[] calcSegmentProbs(int[] iArr) {
        int[] iArr2 = new int[3];
        int i = 0;
        for (int i2 : iArr) {
            switch (i2) {
                case 0:
                    iArr2[0] = iArr2[0] + 1;
                    iArr2[1] = iArr2[1] + 1;
                    break;
                case 1:
                    iArr2[0] = iArr2[0] + 1;
                    break;
                case 2:
                    iArr2[2] = iArr2[2] + 1;
                    break;
                default:
                    break;
            }
        }
        while (i < 3) {
            iArr2[i] = MathUtil.clip((iArr2[i] << 8) / iArr.length, 1, 255);
            i++;
        }
        return iArr2;
    }

    private void initValue(int[][] iArr, int i) {
        Arrays.fill(iArr[0], i);
        Arrays.fill(iArr[1], i);
        Arrays.fill(iArr[2], i);
    }

    private void writeHeader2(VPxBooleanEncoder vPxBooleanEncoder, int[] iArr, int[] iArr2) {
        int length;
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 1);
        vPxBooleanEncoder.writeBit(128, 1);
        vPxBooleanEncoder.writeBit(128, 1);
        vPxBooleanEncoder.writeBit(128, 1);
        for (int writeInt : iArr) {
            vPxBooleanEncoder.writeBit(128, 1);
            writeInt(vPxBooleanEncoder, writeInt, 7);
            vPxBooleanEncoder.writeBit(128, 0);
        }
        for (length = iArr.length; length < 4; length++) {
            vPxBooleanEncoder.writeBit(128, 0);
        }
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        for (length = 0; length < 3; length++) {
            vPxBooleanEncoder.writeBit(128, 1);
            writeInt(vPxBooleanEncoder, iArr2[length], 8);
        }
        vPxBooleanEncoder.writeBit(128, 0);
        writeInt(vPxBooleanEncoder, 1, 6);
        writeInt(vPxBooleanEncoder, 0, 3);
        vPxBooleanEncoder.writeBit(128, 0);
        writeInt(vPxBooleanEncoder, 0, 2);
        writeInt(vPxBooleanEncoder, iArr[0], 7);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        vPxBooleanEncoder.writeBit(128, 0);
        iArr = VPXConst.tokenProbUpdateFlagProbs;
        for (iArr2 = null; iArr2 < iArr.length; iArr2++) {
            for (int i = 0; i < iArr[iArr2].length; i++) {
                for (length = 0; length < iArr[iArr2][i].length; length++) {
                    for (int writeInt2 : iArr[iArr2][i][length]) {
                        vPxBooleanEncoder.writeBit(writeInt2, 0);
                    }
                }
            }
        }
        vPxBooleanEncoder.writeBit(128, 0);
    }

    void writeInt(VPxBooleanEncoder vPxBooleanEncoder, int i, int i2) {
        for (i2--; i2 >= 0; i2--) {
            vPxBooleanEncoder.writeBit(128, (i >> i2) & 1);
        }
    }

    private void writeHeader(ByteBuffer byteBuffer, int i, int i2, int i3) {
        i3 = (((i3 << 5) | 16) | 0) | 0;
        byteBuffer.put((byte) (i3 & 255));
        byteBuffer.put((byte) ((i3 >> 8) & 255));
        byteBuffer.put((byte) ((i3 >> 16) & 255));
        byteBuffer.put(-99);
        byteBuffer.put(1);
        byteBuffer.put(42);
        byteBuffer.putShort((short) i);
        byteBuffer.putShort((short) i2);
    }

    private void collectPredictors(Picture picture, int i) {
        System.arraycopy(picture.getPlaneData(0), 240, this.topLine[0], i << 4, 16);
        i <<= 3;
        System.arraycopy(picture.getPlaneData(1), 56, this.topLine[1], i, 8);
        System.arraycopy(picture.getPlaneData(2), 56, this.topLine[2], i, 8);
        copyCol(picture.getPlaneData(0), 15, 16, this.leftRow[0]);
        copyCol(picture.getPlaneData(1), 7, 8, this.leftRow[1]);
        copyCol(picture.getPlaneData(2), 7, 8, this.leftRow[2]);
    }

    private void copyCol(int[] iArr, int i, int i2, int[] iArr2) {
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            iArr2[i3] = iArr[i];
            i += i2;
        }
    }

    private void luma(Picture picture, int i, int i2, VPxBooleanEncoder vPxBooleanEncoder, int i3, Picture picture2) {
        int i4 = i << 4;
        int i5 = i2 << 4;
        int[][] transform = transform(picture, 0, i3, i4, i5);
        int[] extractDC = extractDC(transform);
        int i6 = i;
        int i7 = i2;
        VPxBooleanEncoder vPxBooleanEncoder2 = vPxBooleanEncoder;
        writeLumaDC(i6, i7, vPxBooleanEncoder2, i3, extractDC);
        writeLumaAC(i6, i7, vPxBooleanEncoder2, transform, i3);
        restorePlaneLuma(extractDC, transform, i3);
        putLuma(picture2.getPlaneData(0), lumaDCPred(i4, i5), transform, 4);
    }

    private void writeLumaAC(int i, int i2, VPxBooleanEncoder vPxBooleanEncoder, int[][] iArr, int i3) {
        for (i2 = 0; i2 < 16; i2++) {
            this.quantizer.quantizeY(iArr[i2], i3);
            this.bitstream.encodeCoeffsDCT15(vPxBooleanEncoder, zigzag(iArr[i2], this.tmp), i, i2 & 3, i2 >> 2);
        }
    }

    private void writeLumaDC(int i, int i2, VPxBooleanEncoder vPxBooleanEncoder, int i3, int[] iArr) {
        VPXDCT.walsh4x4(iArr);
        this.quantizer.quantizeY2(iArr, i3);
        this.bitstream.encodeCoeffsWHT(vPxBooleanEncoder, zigzag(iArr, this.tmp), i);
    }

    private void writeChroma(int i, int i2, int i3, VPxBooleanEncoder vPxBooleanEncoder, int[][] iArr, int i4) {
        for (i3 = 0; i3 < 4; i3++) {
            this.quantizer.quantizeUV(iArr[i3], i4);
            this.bitstream.encodeCoeffsDCTUV(vPxBooleanEncoder, zigzag(iArr[i3], this.tmp), i, i2, i3 & 1, i3 >> 1);
        }
    }

    private int[] zigzag(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 16; i++) {
            iArr2[i] = iArr[VPXConst.zigzag[i]];
        }
        return iArr2;
    }

    private void chroma(Picture picture, int i, int i2, VPxBooleanEncoder vPxBooleanEncoder, int i3, Picture picture2) {
        int i4 = i3;
        int i5 = i << 3;
        int i6 = i2 << 3;
        int chromaPredBlk = chromaPredBlk(1, i5, i6);
        int chromaPredBlk2 = chromaPredBlk(2, i5, i6);
        Picture picture3 = picture;
        int i7 = i4;
        int i8 = i5;
        int i9 = i6;
        Picture picture4 = picture2;
        int i10 = 2;
        int[][] transformChroma = transformChroma(picture3, 1, i7, i8, i9, picture4, chromaPredBlk);
        int[][] transformChroma2 = transformChroma(picture3, 2, i7, i8, i9, picture4, chromaPredBlk2);
        int i11 = i;
        i7 = i2;
        VPxBooleanEncoder vPxBooleanEncoder2 = vPxBooleanEncoder;
        int i12 = i4;
        writeChroma(1, i11, i7, vPxBooleanEncoder2, transformChroma, i12);
        writeChroma(2, i11, i7, vPxBooleanEncoder2, transformChroma2, i12);
        int[][] iArr = transformChroma;
        restorePlaneChroma(iArr, i4);
        i7 = i5;
        i8 = i6;
        putChroma(picture2.getData()[1], 1, i7, i8, iArr, chromaPredBlk);
        restorePlaneChroma(transformChroma2, i4);
        putChroma(picture2.getData()[i10], 2, i7, i8, transformChroma2, chromaPredBlk2);
    }

    private int[][] transformChroma(Picture picture, int i, int i2, int i3, int i4, Picture picture2, int i5) {
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{4, 16});
        for (int i6 = 0; i6 < iArr.length; i6++) {
            takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i3 + ((i6 & 1) << 2), i4 + ((i6 >> 1) << 2), iArr[i6], i5);
            VPXDCT.fdct4x4(iArr[i6]);
        }
        return iArr;
    }

    private void putChroma(int[] iArr, int i, int i2, int i3, int[][] iArr2, int i4) {
        for (i = 0; i < 4; i++) {
            putBlk(iArr, i4, iArr2[i], 3, (i & 1) << 2, (i >> 1) << 2);
        }
    }

    private final int chromaPredOne(int[] iArr, int i) {
        return ((((((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + iArr[i + 4]) + iArr[i + 5]) + iArr[i + 6]) + iArr[i + 7]) + 4) >> 3;
    }

    private final int chromaPredTwo(int[] iArr, int[] iArr2, int i, int i2) {
        return ((((((((((((((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + iArr[i + 4]) + iArr[i + 5]) + iArr[i + 6]) + iArr[i + 7]) + iArr2[i2]) + iArr2[i2 + 1]) + iArr2[i2 + 2]) + iArr2[i2 + 3]) + iArr2[i2 + 4]) + iArr2[i2 + 5]) + iArr2[i2 + 6]) + iArr2[i2 + 7]) + 8) >> 4;
    }

    private int chromaPredBlk(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return chromaPredTwo(this.leftRow[i], this.topLine[i], i4, i2);
        }
        if (i2 != 0) {
            return chromaPredOne(this.leftRow[i], i4);
        }
        return i3 != 0 ? chromaPredOne(this.topLine[i], i2) : 128;
    }

    private void putLuma(int[] iArr, int i, int[][] iArr2, int i2) {
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            int[] iArr3 = iArr;
            int i4 = i;
            putBlk(iArr3, i4, iArr2[i3], i2, (i3 & 3) << 2, i3 & -4);
        }
    }

    private void putBlk(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = 1 << i2;
        i4 = (i4 << i2) + i3;
        i2 = 0;
        int i6 = i2;
        while (i2 < 4) {
            iArr[i4] = MathUtil.clip(iArr2[i6] + i, 0, 255);
            iArr[i4 + 1] = MathUtil.clip(iArr2[i6 + 1] + i, 0, 255);
            iArr[i4 + 2] = MathUtil.clip(iArr2[i6 + 2] + i, 0, 255);
            iArr[i4 + 3] = MathUtil.clip(iArr2[i6 + 3] + i, 0, 255);
            i6 += 4;
            i4 += i5;
            i2++;
        }
    }

    private void restorePlaneChroma(int[][] iArr, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.quantizer.dequantizeUV(iArr[i2], i);
            VPXDCT.idct4x4(iArr[i2]);
        }
    }

    private void restorePlaneLuma(int[] iArr, int[][] iArr2, int i) {
        this.quantizer.dequantizeY2(iArr, i);
        VPXDCT.iwalsh4x4(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            this.quantizer.dequantizeY(iArr2[i2], i);
            iArr2[i2][0] = iArr[i2];
            VPXDCT.idct4x4(iArr2[i2]);
        }
    }

    private int[] extractDC(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i][0];
        }
        return iArr2;
    }

    private int lumaDCPred(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return 128;
        }
        if (i2 == 0) {
            return (ArrayUtil.sum(this.leftRow[0]) + 8) >> 4;
        }
        if (i == 0) {
            return (ArrayUtil.sum(this.topLine[0], i, 16) + 8) >> 4;
        }
        return ((ArrayUtil.sum(this.leftRow[0]) + ArrayUtil.sum(this.topLine[0], i, 16)) + 16) >> 5;
    }

    private int[][] transform(Picture picture, int i, int i2, int i3, int i4) {
        int i5 = i3;
        int i6 = i4;
        int lumaDCPred = lumaDCPred(i5, i6);
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{16, 16});
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int[] iArr2 = iArr[i7];
            int i8 = (i7 & 3) << 2;
            int i9 = i7 & -4;
            takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i5 + i8, i6 + i9, iArr2, lumaDCPred);
            VPXDCT.fdct4x4(iArr2);
        }
        return iArr;
    }

    private final void takeSubtract(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5) {
        if (i3 + 4 >= i || i4 + 4 >= i2) {
            takeSubtractUnsafe(iArr, i, i2, i3, i4, iArr2, i5);
        } else {
            takeSubtractSafe(iArr, i, i2, i3, i4, iArr2, i5);
        }
    }

    private final void takeSubtractSafe(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5) {
        i4 = (i4 * i) + i3;
        i2 = 0;
        i3 = 0;
        while (i2 < 4) {
            iArr2[i3] = iArr[i4] - i5;
            iArr2[i3 + 1] = iArr[i4 + 1] - i5;
            iArr2[i3 + 2] = iArr[i4 + 2] - i5;
            iArr2[i3 + 3] = iArr[i4 + 3] - i5;
            i2++;
            i4 += i;
            i3 += 4;
        }
    }

    private final void takeSubtractUnsafe(int[] iArr, int i, int i2, int i3, int i4, int[] iArr2, int i5) {
        int i6 = 0;
        int i7 = i4;
        while (true) {
            int i8 = i4 + 4;
            if (i7 >= Math.min(i8, i2)) {
                break;
            }
            int min = (i7 * i) + Math.min(i3, i);
            i8 = i6;
            i6 = i3;
            while (true) {
                int i9 = i3 + 4;
                if (i6 >= Math.min(i9, i)) {
                    break;
                }
                i9 = i8 + 1;
                int i10 = min + 1;
                iArr2[i8] = iArr[min] - i5;
                i6++;
                i8 = i9;
                min = i10;
            }
            min--;
            while (i6 < i9) {
                i10 = i8 + 1;
                iArr2[i8] = iArr[min] - i5;
                i6++;
                i8 = i10;
            }
            i7++;
            i6 = i8;
        }
        while (i7 < i8) {
            min = ((i2 * i) - i) + Math.min(i3, i);
            i4 = i3;
            while (true) {
                i9 = i3 + 4;
                if (i4 >= Math.min(i9, i)) {
                    break;
                }
                i9 = i6 + 1;
                i10 = min + 1;
                iArr2[i6] = iArr[min] - i5;
                i4++;
                i6 = i9;
                min = i10;
            }
            min--;
            while (i4 < i9) {
                i10 = i6 + 1;
                iArr2[i6] = iArr[min] - i5;
                i4++;
                i6 = i10;
            }
            i7++;
        }
    }

    public ColorSpace[] getSupportedColorSpaces() {
        return new ColorSpace[]{ColorSpace.YUV420J};
    }
}
