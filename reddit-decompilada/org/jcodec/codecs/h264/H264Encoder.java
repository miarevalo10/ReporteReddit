package org.jcodec.codecs.h264;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.decode.CoeffTransformer;
import org.jcodec.codecs.h264.encode.DumbRateControl;
import org.jcodec.codecs.h264.encode.RateControl;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.codecs.h264.io.write.SliceHeaderWriter;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;

public class H264Encoder implements VideoEncoder {
    private CAVLC[] cavlc;
    private int[][] leftRow;
    private RateControl rc;
    private int[][] topLine;

    public H264Encoder() {
        this(new DumbRateControl());
    }

    public H264Encoder(RateControl rateControl) {
        this.rc = rateControl;
    }

    public ByteBuffer encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        return encodeFrame(picture, byteBuffer, true, 0);
    }

    public ByteBuffer encodeFrame(Picture picture, ByteBuffer byteBuffer, boolean z, int i) {
        byteBuffer = byteBuffer.duplicate();
        SeqParameterSet initSPS = initSPS(new Size(picture.getCroppedWidth(), picture.getCroppedHeight()));
        PictureParameterSet initPPS = initPPS();
        if (z) {
            byteBuffer.putInt(1);
            new NALUnit(NALUnitType.SPS, 3).write(byteBuffer);
            writeSPS(byteBuffer, initSPS);
            byteBuffer.putInt(1);
            new NALUnit(NALUnitType.PPS, 3).write(byteBuffer);
            writePPS(byteBuffer, initPPS);
        }
        int i2 = initSPS.pic_width_in_mbs_minus1 + 1;
        this.leftRow = new int[][]{new int[16], new int[8], new int[8]};
        r5 = new int[3][];
        int i3 = i2 << 3;
        r5[1] = new int[i3];
        r5[2] = new int[i3];
        this.topLine = r5;
        encodeSlice(initSPS, initPPS, picture, byteBuffer, z, i);
        byteBuffer.flip();
        return byteBuffer;
    }

    private void writePPS(ByteBuffer byteBuffer, PictureParameterSet pictureParameterSet) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        pictureParameterSet.write(allocate);
        allocate.flip();
        H264Utils.escapeNAL(allocate, byteBuffer);
    }

    private void writeSPS(ByteBuffer byteBuffer, SeqParameterSet seqParameterSet) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        seqParameterSet.write(allocate);
        allocate.flip();
        H264Utils.escapeNAL(allocate, byteBuffer);
    }

    public PictureParameterSet initPPS() {
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.pic_init_qp_minus26 = this.rc.getInitQp() - 26;
        return pictureParameterSet;
    }

    public SeqParameterSet initSPS(Size size) {
        boolean z;
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.pic_width_in_mbs_minus1 = ((size.getWidth() + 15) >> 4) - 1;
        seqParameterSet.pic_height_in_map_units_minus1 = ((size.getHeight() + 15) >> 4) - 1;
        seqParameterSet.chroma_format_idc = ColorSpace.YUV420;
        seqParameterSet.profile_idc = 66;
        seqParameterSet.level_idc = 40;
        seqParameterSet.frame_mbs_only_flag = true;
        int i = (seqParameterSet.pic_width_in_mbs_minus1 + 1) << 4;
        int i2 = (seqParameterSet.pic_height_in_map_units_minus1 + 1) << 4;
        if (i == size.getWidth()) {
            if (i2 == size.getHeight()) {
                z = false;
                seqParameterSet.frame_cropping_flag = z;
                seqParameterSet.frame_crop_right_offset = ((i - size.getWidth()) + 1) >> 1;
                seqParameterSet.frame_crop_bottom_offset = ((i2 - size.getHeight()) + 1) >> 1;
                return seqParameterSet;
            }
        }
        z = true;
        seqParameterSet.frame_cropping_flag = z;
        seqParameterSet.frame_crop_right_offset = ((i - size.getWidth()) + 1) >> 1;
        seqParameterSet.frame_crop_bottom_offset = ((i2 - size.getHeight()) + 1) >> 1;
        return seqParameterSet;
    }

    private void encodeSlice(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, Picture picture, ByteBuffer byteBuffer, boolean z, int i) {
        SeqParameterSet seqParameterSet2 = seqParameterSet;
        PictureParameterSet pictureParameterSet2 = pictureParameterSet;
        ByteBuffer byteBuffer2 = byteBuffer;
        boolean z2 = z;
        CAVLC[] cavlcArr = new CAVLC[3];
        boolean z3 = false;
        cavlcArr[0] = new CAVLC(seqParameterSet2, pictureParameterSet2, 2, 2);
        int i2 = 1;
        cavlcArr[1] = new CAVLC(seqParameterSet2, pictureParameterSet2, 1, 1);
        cavlcArr[2] = new CAVLC(seqParameterSet2, pictureParameterSet2, 1, 1);
        this.cavlc = cavlcArr;
        this.rc.reset();
        int initQp = this.rc.getInitQp();
        byteBuffer2.putInt(1);
        new NALUnit(z2 ? NALUnitType.IDR_SLICE : NALUnitType.NON_IDR_SLICE, 2).write(byteBuffer2);
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.slice_type = SliceType.I;
        if (z2) {
            sliceHeader.refPicMarkingIDR = new RefPicMarkingIDR(false, false);
        }
        sliceHeader.pps = pictureParameterSet2;
        sliceHeader.sps = seqParameterSet2;
        sliceHeader.pic_order_cnt_lsb = i << 1;
        BitWriter bitWriter = new BitWriter(ByteBuffer.allocate(picture.getWidth() * picture.getHeight()));
        new SliceHeaderWriter().write(sliceHeader, z2, 2, bitWriter);
        Picture create = Picture.create(16, 16, ColorSpace.YUV420);
        int i3 = 0;
        while (i3 < seqParameterSet2.pic_height_in_map_units_minus1 + i2) {
            int i4 = initQp;
            BitWriter bitWriter2 = bitWriter;
            int i5 = z3;
            while (i5 < seqParameterSet2.pic_width_in_mbs_minus1 + i2) {
                int i6;
                BitWriter bitWriter3;
                CAVLCWriter.writeUE(bitWriter2, 23);
                while (true) {
                    BitWriter fork = bitWriter2.fork();
                    int qpDelta = r8.rc.getQpDelta();
                    i6 = i4 + qpDelta;
                    bitWriter3 = fork;
                    BitWriter bitWriter4 = bitWriter2;
                    encodeMacroblock(picture, i5, i3, fork, create, i6, qpDelta);
                    if (r8.rc.accept(bitWriter3.position() - bitWriter4.position())) {
                        break;
                    }
                    bitWriter2 = bitWriter4;
                }
                collectPredictors(create, i5);
                i5++;
                bitWriter2 = bitWriter3;
                i4 = i6;
                i2 = 1;
            }
            i3++;
            bitWriter = bitWriter2;
            initQp = i4;
            z3 = false;
            i2 = 1;
        }
        bitWriter.write1Bit(i2);
        bitWriter.flush();
        ByteBuffer buffer = bitWriter.getBuffer();
        buffer.flip();
        H264Utils.escapeNAL(buffer, byteBuffer2);
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

    private void encodeMacroblock(Picture picture, int i, int i2, BitWriter bitWriter, Picture picture2, int i3, int i4) {
        CAVLCWriter.writeUE(bitWriter, 0);
        CAVLCWriter.writeSE(bitWriter, i4);
        Picture picture3 = picture;
        int i5 = i;
        int i6 = i2;
        BitWriter bitWriter2 = bitWriter;
        int i7 = i3;
        Picture picture4 = picture2;
        luma(picture3, i5, i6, bitWriter2, i7, picture4);
        chroma(picture3, i5, i6, bitWriter2, i7, picture4);
    }

    private void chroma(Picture picture, int i, int i2, BitWriter bitWriter, int i3, Picture picture2) {
        int i4 = i3;
        int i5 = picture.getColor().compWidth[1];
        int i6 = picture.getColor().compHeight[1];
        int i7 = i << (4 - i5);
        int i8 = i2 << (4 - i6);
        Picture picture3 = picture;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        int i12 = i7;
        int i13 = i8;
        int[][] transformChroma = transformChroma(picture3, 1, i9, i10, i11, i12, i13, picture2);
        int[][] transformChroma2 = transformChroma(picture3, 2, i9, i10, i11, i12, i13, picture2);
        int[] extractDC = extractDC(transformChroma);
        int i14 = i << 1;
        int i15 = i2 << 1;
        int i16 = i;
        i9 = i2;
        BitWriter bitWriter2 = bitWriter;
        i11 = i4;
        i12 = i14;
        int[] extractDC2 = extractDC(transformChroma2);
        i13 = i15;
        int[] iArr = extractDC;
        writeDC(1, i16, i9, bitWriter2, i11, i12, i13, extractDC);
        writeDC(2, i16, i9, bitWriter2, i11, i12, i13, extractDC2);
        i11 = i14;
        i12 = i15;
        int i17 = i4;
        writeAC(1, i16, i9, bitWriter2, i11, i12, transformChroma, i17);
        writeAC(2, i16, i9, bitWriter2, i11, i12, transformChroma2, i17);
        restorePlane(iArr, transformChroma, i4);
        i9 = i7;
        i10 = i8;
        putChroma(picture2.getData()[1], 1, i9, i10, transformChroma);
        restorePlane(extractDC2, transformChroma2, i4);
        putChroma(picture2.getData()[2], 2, i9, i10, transformChroma2);
    }

    private void luma(Picture picture, int i, int i2, BitWriter bitWriter, int i3, Picture picture2) {
        int i4 = i << 4;
        int i5 = i2 << 4;
        int[][] transform = transform(picture, 0, i3, 0, 0, i4, i5);
        int[] extractDC = extractDC(transform);
        int i6 = i << 2;
        int i7 = i2 << 2;
        int i8 = i;
        int i9 = i2;
        BitWriter bitWriter2 = bitWriter;
        writeDC(0, i8, i9, bitWriter2, i3, i6, i7, extractDC);
        writeAC(0, i8, i9, bitWriter2, i6, i7, transform, i3);
        restorePlane(extractDC, transform, i3);
        putLuma(picture2.getPlaneData(0), lumaDCPred(i4, i5), transform, 4);
    }

    private void putChroma(int[] iArr, int i, int i2, int i3, int[][] iArr2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int[] iArr3 = iArr;
        putBlk(iArr3, chromaPredBlk0(i4, i5, i6), iArr2[0], 3, 0, 0);
        putBlk(iArr3, chromaPredBlk1(i4, i5, i6), iArr2[1], 3, 4, 0);
        putBlk(iArr3, chromaPredBlk2(i4, i5, i6), iArr2[2], 3, 0, 4);
        putBlk(iArr3, chromaPredBlk3(i4, i5, i6), iArr2[3], 3, 4, 4);
    }

    private void putLuma(int[] iArr, int i, int[][] iArr2, int i2) {
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            putBlk(iArr, i, iArr2[i3], i2, H264Const.BLK_X[i3], H264Const.BLK_Y[i3]);
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

    private void restorePlane(int[] iArr, int[][] iArr2, int i) {
        if (iArr.length == 4) {
            CoeffTransformer.invDC2x2(iArr);
            CoeffTransformer.dequantizeDC2x2(iArr, i);
        } else if (iArr.length == 8) {
            CoeffTransformer.invDC4x2(iArr);
            CoeffTransformer.dequantizeDC4x2(iArr, i);
        } else {
            CoeffTransformer.invDC4x4(iArr);
            CoeffTransformer.dequantizeDC4x4(iArr, i);
            CoeffTransformer.reorderDC4x4(iArr);
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            CoeffTransformer.dequantizeAC(iArr2[i2], i);
            iArr2[i2][0] = iArr[i2];
            CoeffTransformer.idct4x4(iArr2[i2]);
        }
    }

    private int[] extractDC(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i][0];
            iArr[i][0] = 0;
        }
        return iArr2;
    }

    private void writeAC(int i, int i2, int i3, BitWriter bitWriter, int i4, int i5, int[][] iArr, int i6) {
        int[][] iArr2 = iArr;
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            CoeffTransformer.quantizeAC(iArr2[i7], i6);
            this.cavlc[i].writeACBlock(bitWriter, i4 + H264Const.MB_BLK_OFF_LEFT[i7], i5 + H264Const.MB_BLK_OFF_TOP[i7], MBType.I_16x16, MBType.I_16x16, iArr2[i7], H264Const.totalZeros16, 1, 15, CoeffTransformer.zigzag4x4);
        }
        H264Encoder h264Encoder = this;
    }

    private void writeDC(int i, int i2, int i3, BitWriter bitWriter, int i4, int i5, int i6, int[] iArr) {
        H264Encoder h264Encoder = this;
        int i7 = i4;
        int[] iArr2 = iArr;
        if (iArr2.length == 4) {
            CoeffTransformer.quantizeDC2x2(iArr2, i7);
            CoeffTransformer.fvdDC2x2(iArr);
            h264Encoder.cavlc[i].writeChrDCBlock(bitWriter, iArr2, H264Const.totalZeros4, 0, iArr2.length, new int[]{0, 1, 2, 3});
        } else if (iArr2.length == 8) {
            CoeffTransformer.quantizeDC4x2(iArr2, i7);
            CoeffTransformer.fvdDC4x2(iArr);
            h264Encoder.cavlc[i].writeChrDCBlock(bitWriter, iArr2, H264Const.totalZeros8, 0, iArr2.length, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        } else {
            CoeffTransformer.reorderDC4x4(iArr);
            CoeffTransformer.quantizeDC4x4(iArr2, i7);
            CoeffTransformer.fvdDC4x4(iArr);
            h264Encoder.cavlc[i].writeLumaDCBlock(bitWriter, i5, i6, MBType.I_16x16, MBType.I_16x16, iArr2, H264Const.totalZeros16, 0, 16, CoeffTransformer.zigzag4x4);
        }
    }

    private int[][] transformChroma(Picture picture, int i, int i2, int i3, int i4, int i5, int i6, Picture picture2) {
        int i7 = i;
        int i8 = i5;
        int i9 = i6;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{16 >> (i3 + i4), 16});
        int i10 = i9;
        takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i8, i10, iArr[0], chromaPredBlk0(i7, i8, i9));
        CoeffTransformer.fdct4x4(iArr[0]);
        int i11 = i8 + 4;
        takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i11, i10, iArr[1], chromaPredBlk1(i7, i8, i9));
        CoeffTransformer.fdct4x4(iArr[1]);
        i10 = i9 + 4;
        takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i8, i10, iArr[2], chromaPredBlk2(i7, i8, i9));
        CoeffTransformer.fdct4x4(iArr[2]);
        takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i11, i10, iArr[3], chromaPredBlk3(i7, i8, i9));
        CoeffTransformer.fdct4x4(iArr[3]);
        return iArr;
    }

    private final int chromaPredOne(int[] iArr, int i) {
        return ((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + 2) >> 2;
    }

    private final int chromaPredTwo(int[] iArr, int[] iArr2, int i, int i2) {
        return ((((((((iArr[i] + iArr[i + 1]) + iArr[i + 2]) + iArr[i + 3]) + iArr2[i2]) + iArr2[i2 + 1]) + iArr2[i2 + 2]) + iArr2[i2 + 3]) + 4) >> 3;
    }

    private int chromaPredBlk0(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return chromaPredTwo(this.leftRow[i], this.topLine[i], i4, i2);
        }
        if (i2 != 0) {
            return chromaPredOne(this.leftRow[i], i4);
        }
        return i3 != 0 ? chromaPredOne(this.topLine[i], i2) : 128;
    }

    private int chromaPredBlk1(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i3 != 0) {
            return chromaPredOne(this.topLine[i], i2 + 4);
        }
        return i2 != 0 ? chromaPredOne(this.leftRow[i], i4) : 128;
    }

    private int chromaPredBlk2(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0) {
            return chromaPredOne(this.leftRow[i], i4 + 4);
        }
        return i3 != 0 ? chromaPredOne(this.topLine[i], i2) : 128;
    }

    private int chromaPredBlk3(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return chromaPredTwo(this.leftRow[i], this.topLine[i], i4 + 4, i2 + 4);
        }
        if (i2 != 0) {
            return chromaPredOne(this.leftRow[i], i4 + 4);
        }
        return i3 != 0 ? chromaPredOne(this.topLine[i], i2 + 4) : 128;
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

    private int[][] transform(Picture picture, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i5;
        int i8 = i6;
        int lumaDCPred = lumaDCPred(i7, i8);
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{16 >> (i3 + i4), 16});
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int[] iArr2 = iArr[i9];
            takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i7 + H264Const.BLK_X[i9], i8 + H264Const.BLK_Y[i9], iArr2, lumaDCPred);
            CoeffTransformer.fdct4x4(iArr2);
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
