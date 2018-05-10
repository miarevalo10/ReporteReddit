package org.jcodec.codecs.mpeg12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.codecs.mpeg12.MPEGConst.MBType;
import org.jcodec.codecs.mpeg12.bitstream.GOPHeader;
import org.jcodec.codecs.mpeg12.bitstream.PictureHeader;
import org.jcodec.codecs.mpeg12.bitstream.SequenceHeader;
import org.jcodec.common.Assert;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.dct.SparseIDCT;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.model.Size;

public class MPEGDecoder implements VideoDecoder {
    protected GOPHeader gh;
    private Picture[] refFields;
    private Picture[] refFrames;
    protected SequenceHeader sh;

    public class Context {
        public int codedHeight;
        public int codedWidth;
        public ColorSpace color;
        int[] intra_dc_predictor = new int[3];
        public MBType lastPredB;
        public int mbHeight;
        int mbNo;
        public int mbWidth;
        public int picHeight;
        public int picWidth;
        public int[][] qMats;
        public int[] scan;
    }

    protected static final int clip(int i) {
        return i < 0 ? 0 : i > 255 ? 255 : i;
    }

    protected static final int quantInter(int i, int i2) {
        return (((i << 1) + 1) * i2) >> 5;
    }

    public static final int toSigned(int i, int i2) {
        i2 = (i2 << 31) >> 31;
        return (i ^ i2) - i2;
    }

    public MPEGDecoder(SequenceHeader sequenceHeader, GOPHeader gOPHeader) {
        this.refFrames = new Picture[2];
        this.refFields = new Picture[2];
        this.sh = sequenceHeader;
        this.gh = gOPHeader;
    }

    public MPEGDecoder() {
        this.refFrames = new Picture[2];
        this.refFields = new Picture[2];
    }

    public Picture decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        PictureHeader readHeader = readHeader(byteBuffer);
        if ((this.refFrames[0] != null || readHeader.picture_coding_type <= 1) && (r7.refFrames[1] != null || readHeader.picture_coding_type <= 2)) {
            Picture picture;
            Context initContext = initContext(r7.sh, readHeader);
            Picture picture2 = new Picture(initContext.codedWidth, initContext.codedHeight, iArr, initContext.color, new Rect(0, 0, initContext.picWidth, initContext.picHeight));
            if (readHeader.pictureCodingExtension == null || readHeader.pictureCodingExtension.picture_structure == 3) {
                picture = picture2;
                decodePicture(initContext, readHeader, byteBuffer, iArr, 0, 0);
            } else {
                ByteBuffer byteBuffer2 = byteBuffer;
                int[][] iArr2 = iArr;
                picture = picture2;
                decodePicture(initContext, readHeader, byteBuffer2, iArr2, readHeader.pictureCodingExtension.picture_structure - 1, 1);
                readHeader = readHeader(byteBuffer);
                decodePicture(initContext(r7.sh, readHeader), readHeader, byteBuffer2, iArr2, readHeader.pictureCodingExtension.picture_structure - 1, 1);
            }
            if (readHeader.picture_coding_type == 1 || readHeader.picture_coding_type == 2) {
                Picture picture3 = r7.refFrames[1];
                r7.refFrames[1] = r7.refFrames[0];
                r7.refFrames[0] = copyAndCreateIfNeeded(picture, picture3);
            }
            return picture;
        }
        StringBuilder stringBuilder = new StringBuilder("Not enough references to decode ");
        stringBuilder.append(readHeader.picture_coding_type == 1 ? "P" : "B");
        stringBuilder.append(" frame");
        throw new RuntimeException(stringBuilder.toString());
    }

    private Picture copyAndCreateIfNeeded(Picture picture, Picture picture2) {
        if (picture2 == null || !picture2.compatible(picture)) {
            picture2 = picture.createCompatible();
        }
        picture2.copyFrom(picture);
        return picture2;
    }

    private PictureHeader readHeader(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        PictureHeader pictureHeader = null;
        while (true) {
            ByteBuffer nextSegment = MPEGUtil.nextSegment(duplicate);
            if (nextSegment == null) {
                break;
            }
            int i = nextSegment.getInt() & 255;
            if (i != MPEGConst.SEQUENCE_HEADER_CODE) {
                if (i != MPEGConst.GROUP_START_CODE) {
                    if (i != 0) {
                        if (i != MPEGConst.EXTENSION_START_CODE) {
                            if (i != MPEGConst.USER_DATA_START_CODE) {
                                break;
                            }
                        } else {
                            i = nextSegment.get(4) >> 4;
                            if (!(i == 1 || i == 5)) {
                                if (i != 2) {
                                    PictureHeader.readExtension(nextSegment, pictureHeader, this.sh);
                                }
                            }
                            SequenceHeader.readExtension(nextSegment, this.sh);
                        }
                    } else {
                        pictureHeader = PictureHeader.read(nextSegment);
                    }
                } else {
                    this.gh = GOPHeader.read(nextSegment);
                }
            } else {
                SequenceHeader read = SequenceHeader.read(nextSegment);
                if (this.sh != null) {
                    read.copyExtensions(this.sh);
                }
                this.sh = read;
            }
            byteBuffer.position(duplicate.position());
        }
        return pictureHeader;
    }

    protected Context initContext(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        Context context = new Context();
        context.codedWidth = (sequenceHeader.horizontal_size + 15) & -16;
        context.codedHeight = getCodedHeight(sequenceHeader, pictureHeader);
        context.mbWidth = (sequenceHeader.horizontal_size + 15) >> 4;
        context.mbHeight = (sequenceHeader.vertical_size + 15) >> 4;
        context.picWidth = sequenceHeader.horizontal_size;
        context.picHeight = sequenceHeader.vertical_size;
        context.color = getColor(sequenceHeader.sequenceExtension != null ? sequenceHeader.sequenceExtension.chroma_format : 1);
        context.scan = MPEGConst.scan[pictureHeader.pictureCodingExtension == null ? 0 : pictureHeader.pictureCodingExtension.alternate_scan];
        int[] zigzag = sequenceHeader.non_intra_quantiser_matrix == null ? zigzag(MPEGConst.defaultQMatInter, context.scan) : sequenceHeader.non_intra_quantiser_matrix;
        sequenceHeader = sequenceHeader.intra_quantiser_matrix == null ? zigzag(MPEGConst.defaultQMatIntra, context.scan) : sequenceHeader.intra_quantiser_matrix;
        context.qMats = new int[][]{zigzag, zigzag, sequenceHeader, sequenceHeader};
        if (pictureHeader.quantMatrixExtension != null) {
            if (pictureHeader.quantMatrixExtension.non_intra_quantiser_matrix != null) {
                context.qMats[0] = pictureHeader.quantMatrixExtension.non_intra_quantiser_matrix;
            }
            if (pictureHeader.quantMatrixExtension.chroma_non_intra_quantiser_matrix != null) {
                context.qMats[1] = pictureHeader.quantMatrixExtension.chroma_non_intra_quantiser_matrix;
            }
            if (pictureHeader.quantMatrixExtension.intra_quantiser_matrix != null) {
                context.qMats[2] = pictureHeader.quantMatrixExtension.intra_quantiser_matrix;
            }
            if (pictureHeader.quantMatrixExtension.chroma_intra_quantiser_matrix != null) {
                context.qMats[3] = pictureHeader.quantMatrixExtension.chroma_intra_quantiser_matrix;
            }
        }
        return context;
    }

    private int[] zigzag(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[64];
        for (int i = 0; i < iArr2.length; i++) {
            iArr3[i] = iArr[iArr2[i]];
        }
        return iArr3;
    }

    public static int getCodedHeight(SequenceHeader sequenceHeader, PictureHeader pictureHeader) {
        pictureHeader = (pictureHeader.pictureCodingExtension == null || pictureHeader.pictureCodingExtension.picture_structure == 3) ? null : true;
        return (((sequenceHeader.vertical_size >> pictureHeader) + 15) & -16) << pictureHeader;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jcodec.common.model.Picture decodePicture(org.jcodec.codecs.mpeg12.MPEGDecoder.Context r17, org.jcodec.codecs.mpeg12.bitstream.PictureHeader r18, java.nio.ByteBuffer r19, int[][] r20, int r21, int r22) {
        /*
        r16 = this;
        r9 = r16;
        r10 = r17;
        r11 = r18;
        r12 = r20;
        r1 = r10.codedWidth;
        r2 = r10.codedHeight;
        r1 = r1 * r2;
        r13 = 3;
        r2 = r12.length;
        if (r2 < r13) goto L_0x00cf;
    L_0x0011:
        r2 = 0;
        r2 = r12[r2];
        r2 = r2.length;
        if (r2 < r1) goto L_0x00cf;
    L_0x0017:
        r14 = 1;
        r2 = r12[r14];
        r2 = r2.length;
        if (r2 < r1) goto L_0x00cf;
    L_0x001d:
        r15 = 2;
        r2 = r12[r15];
        r2 = r2.length;
        if (r2 >= r1) goto L_0x0025;
    L_0x0023:
        goto L_0x00cf;
    L_0x0025:
        r1 = org.jcodec.codecs.mpeg12.MPEGUtil.nextSegment(r19);	 Catch:{ IOException -> 0x00c7 }
        if (r1 == 0) goto L_0x0093;
    L_0x002b:
        r2 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        if (r2 <= 0) goto L_0x005a;
    L_0x0031:
        r2 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        r3 = 175; // 0xaf float:2.45E-43 double:8.65E-322;
        if (r2 > r3) goto L_0x005a;
    L_0x0039:
        r2 = 4;
        r1.position(r2);	 Catch:{ IOException -> 0x00c7 }
        r2 = r1.get(r13);	 Catch:{ RuntimeException -> 0x0054 }
        r3 = r2 & 255;
        r6 = new org.jcodec.common.io.BitReader;	 Catch:{ RuntimeException -> 0x0054 }
        r6.<init>(r1);	 Catch:{ RuntimeException -> 0x0054 }
        r1 = r9;
        r2 = r11;
        r4 = r10;
        r5 = r12;
        r7 = r21;
        r8 = r22;
        r1.decodeSlice(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ RuntimeException -> 0x0054 }
        goto L_0x0025;
    L_0x0054:
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();	 Catch:{ IOException -> 0x00c7 }
        goto L_0x0025;
    L_0x005a:
        r2 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        r3 = 179; // 0xb3 float:2.51E-43 double:8.84E-322;
        if (r2 < r3) goto L_0x008a;
    L_0x0062:
        r2 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        r3 = 182; // 0xb6 float:2.55E-43 double:9.0E-322;
        if (r2 == r3) goto L_0x008a;
    L_0x006a:
        r2 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        r3 = 183; // 0xb7 float:2.56E-43 double:9.04E-322;
        if (r2 == r3) goto L_0x008a;
    L_0x0072:
        r2 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x00c7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00c7 }
        r4 = "Unexpected start code ";
        r3.<init>(r4);	 Catch:{ IOException -> 0x00c7 }
        r1 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        r3.append(r1);	 Catch:{ IOException -> 0x00c7 }
        r1 = r3.toString();	 Catch:{ IOException -> 0x00c7 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x00c7 }
        throw r2;	 Catch:{ IOException -> 0x00c7 }
    L_0x008a:
        r1 = r1.get(r13);	 Catch:{ IOException -> 0x00c7 }
        if (r1 != 0) goto L_0x0025;
    L_0x0090:
        r19.reset();	 Catch:{ IOException -> 0x00c7 }
    L_0x0093:
        r1 = new org.jcodec.common.model.Picture;	 Catch:{ IOException -> 0x00c7 }
        r2 = r10.codedWidth;	 Catch:{ IOException -> 0x00c7 }
        r3 = r10.codedHeight;	 Catch:{ IOException -> 0x00c7 }
        r4 = r10.color;	 Catch:{ IOException -> 0x00c7 }
        r1.<init>(r2, r3, r12, r4);	 Catch:{ IOException -> 0x00c7 }
        r2 = r11.picture_coding_type;	 Catch:{ IOException -> 0x00c7 }
        if (r2 == r14) goto L_0x00a6;
    L_0x00a2:
        r2 = r11.picture_coding_type;	 Catch:{ IOException -> 0x00c7 }
        if (r2 != r15) goto L_0x00c6;
    L_0x00a6:
        r2 = r11.pictureCodingExtension;	 Catch:{ IOException -> 0x00c7 }
        if (r2 == 0) goto L_0x00c6;
    L_0x00aa:
        r2 = r11.pictureCodingExtension;	 Catch:{ IOException -> 0x00c7 }
        r2 = r2.picture_structure;	 Catch:{ IOException -> 0x00c7 }
        if (r2 == r13) goto L_0x00c6;
    L_0x00b0:
        r2 = r9.refFields;	 Catch:{ IOException -> 0x00c7 }
        r3 = r11.pictureCodingExtension;	 Catch:{ IOException -> 0x00c7 }
        r3 = r3.picture_structure;	 Catch:{ IOException -> 0x00c7 }
        r3 = r3 - r14;
        r4 = r9.refFields;	 Catch:{ IOException -> 0x00c7 }
        r5 = r11.pictureCodingExtension;	 Catch:{ IOException -> 0x00c7 }
        r5 = r5.picture_structure;	 Catch:{ IOException -> 0x00c7 }
        r5 = r5 - r14;
        r4 = r4[r5];	 Catch:{ IOException -> 0x00c7 }
        r4 = r9.copyAndCreateIfNeeded(r1, r4);	 Catch:{ IOException -> 0x00c7 }
        r2[r3] = r4;	 Catch:{ IOException -> 0x00c7 }
    L_0x00c6:
        return r1;
    L_0x00c7:
        r0 = move-exception;
        r1 = r0;
        r2 = new java.lang.RuntimeException;
        r2.<init>(r1);
        throw r2;
    L_0x00cf:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "ByteBuffer too small to hold output picture [";
        r2.<init>(r3);
        r3 = r10.codedWidth;
        r2.append(r3);
        r3 = "x";
        r2.append(r3);
        r3 = r10.codedHeight;
        r2.append(r3);
        r3 = "]";
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.mpeg12.MPEGDecoder.decodePicture(org.jcodec.codecs.mpeg12.MPEGDecoder$Context, org.jcodec.codecs.mpeg12.bitstream.PictureHeader, java.nio.ByteBuffer, int[][], int, int):org.jcodec.common.model.Picture");
    }

    private ColorSpace getColor(int i) {
        switch (i) {
            case 1:
                return ColorSpace.YUV420;
            case 2:
                return ColorSpace.YUV422;
            case 3:
                return ColorSpace.YUV444;
            default:
                return 0;
        }
    }

    public void decodeSlice(PictureHeader pictureHeader, int i, Context context, int[][] iArr, BitReader bitReader, int i2, int i3) throws IOException {
        int[][] iArr2;
        PictureHeader pictureHeader2 = pictureHeader;
        Context context2 = context;
        BitReader bitReader2 = bitReader;
        int i4 = context2.codedWidth;
        resetDCPredictors(context2, pictureHeader2);
        int i5 = 1;
        int i6 = i - 1;
        if (this.sh.vertical_size > 2800) {
            i6 += bitReader2.readNBit(3) << 7;
        }
        if (r11.sh.sequenceScalableExtension != null && r11.sh.sequenceScalableExtension.scalable_mode == 0) {
            bitReader2.readNBit(7);
        }
        int readNBit = bitReader2.readNBit(5);
        if (bitReader.read1Bit() == 1) {
            bitReader.read1Bit();
            bitReader2.skip(7);
            while (bitReader.read1Bit() == 1) {
                bitReader2.readNBit(8);
            }
        }
        if (pictureHeader2.pictureCodingExtension != null) {
            iArr2 = pictureHeader2.pictureCodingExtension.f_code;
        } else {
            r4 = new int[2][];
            r4[0] = new int[]{pictureHeader2.forward_f_code, pictureHeader2.forward_f_code};
            r4[1] = new int[]{pictureHeader2.backward_f_code, pictureHeader2.backward_f_code};
            iArr2 = r4;
        }
        int i7 = r11.sh.sequenceExtension != null ? r11.sh.sequenceExtension.chroma_format : 1;
        boolean z = pictureHeader2.pictureCodingExtension == null || pictureHeader2.pictureCodingExtension.top_field_first != 0;
        MPEGPred mPEGPred = new MPEGPred(iArr2, i7, z);
        int[] iArr3 = new int[]{readNBit};
        int i8 = (i6 * context2.mbWidth) - 1;
        while (bitReader2.checkNBit(23) != 0) {
            int[] iArr4 = iArr3;
            MPEGPred mPEGPred2 = mPEGPred;
            int i9 = i5;
            i8 = decodeMacroblock(pictureHeader2, context2, i8, iArr3, iArr, i4, bitReader2, i2, i3, mPEGPred2);
            context2.mbNo++;
            iArr3 = iArr4;
            mPEGPred = mPEGPred2;
            i5 = i9;
        }
    }

    private void resetDCPredictors(Context context, PictureHeader pictureHeader) {
        pictureHeader = pictureHeader.pictureCodingExtension != null ? 1 << (7 + pictureHeader.pictureCodingExtension.intra_dc_precision) : 128;
        int[] iArr = context.intra_dc_predictor;
        int[] iArr2 = context.intra_dc_predictor;
        context.intra_dc_predictor[2] = pictureHeader;
        iArr2[1] = pictureHeader;
        iArr[0] = pictureHeader;
    }

    public int decodeMacroblock(PictureHeader pictureHeader, Context context, int i, int[] iArr, int[][] iArr2, int i2, BitReader bitReader, int i3, int i4, MPEGPred mPEGPred) {
        int i5;
        int i6;
        int i7;
        int i8;
        BitReader bitReader2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        MBType mBType;
        int i14;
        int[][] iArr3;
        int i15;
        int[][] iArr4;
        int[][] iArr5;
        MBType mBType2;
        int[][] iArr6;
        int i16;
        int[][] iArr7;
        int[][] iArr8;
        MBType mBType3;
        int[][] iArr9;
        int i17;
        int[][] iArr10;
        VLC vlc;
        PictureHeader pictureHeader2;
        int i18;
        VLC vlc2;
        int[] iArr11;
        int i19;
        int[] iArr12;
        int i20;
        int[] iArr13;
        int[] iArr14;
        int[] iArr15;
        int i21;
        int[] iArr16;
        int i22;
        int[] iArr17;
        int i23;
        int i24;
        MPEGDecoder mPEGDecoder = this;
        PictureHeader pictureHeader3 = pictureHeader;
        Context context2 = context;
        BitReader bitReader3 = bitReader;
        int i25 = i;
        while (true) {
            i5 = 8;
            if (bitReader3.checkNBit(11) != 8) {
                break;
            }
            bitReader3.skip(11);
            i25 += 33;
        }
        int i26 = 1;
        int readVLC = i25 + (MPEGConst.vlcAddressIncrement.readVLC(bitReader3) + 1);
        int i27 = mPEGDecoder.sh.sequenceExtension != null ? mPEGDecoder.sh.sequenceExtension.chroma_format : 1;
        int i28 = i + 1;
        while (i28 < readVLC) {
            r3 = new int[3][];
            i25 = i26 << (i27 + 5);
            r3[i26] = new int[i25];
            r3[2] = new int[i25];
            int i29 = i28 % context2.mbWidth;
            i6 = i28 / context2.mbWidth;
            if (pictureHeader3.picture_coding_type == 2) {
                mPEGPred.reset();
            }
            int[][] iArr18 = r3;
            int i30 = i28;
            i7 = i27;
            mvZero(context2, pictureHeader3, mPEGPred, i29, i6, iArr18);
            i27 = i6;
            i6 = readVLC;
            int i31 = i26;
            i8 = i5;
            bitReader2 = bitReader3;
            put(iArr18, iArr2, i2, i7, i29, i27, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
            i28 = i30 + 1;
            bitReader3 = bitReader2;
            readVLC = i6;
            i5 = i8;
            i27 = i7;
            i26 = 1;
        }
        i7 = i27;
        i6 = readVLC;
        i8 = i5;
        bitReader2 = bitReader3;
        MBType mBType4 = MPEGConst.mbTypeVal(pictureHeader3.picture_coding_type, mPEGDecoder.sh.sequenceScalableExtension)[MPEGConst.vlcMBType(pictureHeader3.picture_coding_type, mPEGDecoder.sh.sequenceScalableExtension).readVLC(bitReader2)];
        if (mBType4.macroblock_intra != 1 || i6 - i > 1) {
            resetDCPredictors(context2, pictureHeader3);
        }
        i5 = (mBType4.spatial_temporal_weight_code_flag != 1 || pictureHeader3.pictureSpatialScalableExtension == null || pictureHeader3.pictureSpatialScalableExtension.spatial_temporal_weight_code_table_index == 0) ? 0 : bitReader2.readNBit(2);
        if (mBType4.macroblock_motion_forward == 0) {
            if (mBType4.macroblock_motion_backward == 0) {
                i9 = -1;
                i10 = 1;
                i30 = (pictureHeader3.pictureCodingExtension == null && pictureHeader3.pictureCodingExtension.picture_structure == 3 && pictureHeader3.pictureCodingExtension.frame_pred_frame_dct == 0 && (mBType4.macroblock_intra != 0 || mBType4.macroblock_pattern != 0)) ? bitReader.read1Bit() : 0;
                if (mBType4.macroblock_quant != 0) {
                    i26 = i10;
                    iArr[0] = bitReader2.readNBit(5);
                } else {
                    i26 = i10;
                }
                i11 = (pictureHeader3.pictureCodingExtension != null || pictureHeader3.pictureCodingExtension.concealment_motion_vectors == 0) ? 0 : i26;
                i12 = i6 % context2.mbWidth;
                i13 = i6 / context2.mbWidth;
                if (mBType4.macroblock_intra != i26) {
                    if (i11 == 0) {
                        mPEGPred.reset();
                    }
                    i26 = 3;
                    mBType = mBType4;
                    i14 = i7;
                } else if (mBType4.macroblock_motion_forward != 0) {
                    i25 = pictureHeader3.picture_coding_type == 2 ? 0 : i26;
                    iArr3 = new int[3][];
                    iArr3[0] = new int[256];
                    i27 = i7;
                    i10 = i26 << (i27 + 5);
                    iArr3[i26] = new int[i10];
                    iArr3[2] = new int[i10];
                    if (pictureHeader3.pictureCodingExtension != null) {
                        if (pictureHeader3.pictureCodingExtension.picture_structure == 3) {
                            if (pictureHeader3.picture_coding_type == 2) {
                                mBType = mBType4;
                                i14 = 2;
                                i28 = 3;
                                i15 = i27;
                                iArr4 = iArr3;
                                mPEGPred.predictInField(mPEGDecoder.refFields, i12 << 4, i13 << 4, iArr3, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                            } else {
                                i15 = i27;
                                iArr4 = iArr3;
                                mBType = mBType4;
                                mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[i25], mPEGDecoder.refFrames[i25]}, i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                            }
                            iArr5 = iArr4;
                            mBType2 = mBType;
                            i14 = i15;
                            i26 = 3;
                            if (mBType2.macroblock_motion_backward == 0) {
                                iArr6 = new int[i26][];
                                iArr6[0] = new int[256];
                                i25 = 1 << (i14 + 5);
                                iArr6[1] = new int[i25];
                                iArr6[2] = new int[i25];
                                if (pictureHeader3.pictureCodingExtension != null) {
                                    if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                        i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                        i5 = 256;
                                        iArr7 = iArr6;
                                        iArr8 = iArr5;
                                        i27 = i9;
                                        mBType3 = mBType2;
                                        iArr9 = iArr8;
                                        i17 = i26;
                                        mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                        iArr10 = iArr7;
                                    }
                                }
                                iArr7 = iArr6;
                                iArr9 = iArr5;
                                i17 = i26;
                                i27 = i9;
                                i9 = 256;
                                mBType3 = mBType2;
                                mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                                iArr10 = iArr7;
                            } else {
                                iArr9 = iArr5;
                                mBType3 = mBType2;
                                i17 = i26;
                                iArr10 = null;
                            }
                            context2.lastPredB = mBType3;
                            if (mBType3.macroblock_intra != 1) {
                                iArr10 = new int[i17][];
                                iArr10[0] = new int[256];
                                i10 = 1 << (i14 + 5);
                                iArr10[1] = new int[i10];
                                iArr10[2] = new int[i10];
                            } else {
                                iArr10 = buildPred(iArr9, iArr10);
                            }
                            iArr8 = iArr10;
                            if (!(mBType3.macroblock_intra == 0 || i11 == 0)) {
                                Assert.assertEquals(1, bitReader.read1Bit());
                            }
                            i25 = mBType3.macroblock_intra != 1 ? 4095 : 0;
                            if (mBType3.macroblock_pattern != 0) {
                                i25 = readCbPattern(bitReader2);
                            }
                            i7 = i25;
                            vlc = MPEGConst.vlcCoeff0;
                            pictureHeader2 = pictureHeader;
                            if (pictureHeader2.pictureCodingExtension == null) {
                                i18 = 1;
                                if (mBType3.macroblock_intra == 1 && pictureHeader2.pictureCodingExtension.intra_vlc_format == 1) {
                                    vlc = MPEGConst.vlcCoeff1;
                                }
                            } else {
                                i18 = 1;
                            }
                            vlc2 = vlc;
                            iArr11 = (pictureHeader2.pictureCodingExtension == null && pictureHeader2.pictureCodingExtension.q_scale_type == i18) ? MPEGConst.qScaleTab2 : MPEGConst.qScaleTab1;
                            i19 = iArr11[iArr[0]];
                            i16 = pictureHeader2.pictureCodingExtension == null ? i8 >> pictureHeader2.pictureCodingExtension.intra_dc_precision : i8;
                            i26 = 1;
                            if (i14 != 1) {
                                i10 = 0;
                            } else {
                                i10 = 2;
                                if (i14 != 2) {
                                    i10 = 6;
                                }
                            }
                            readVLC = 6 + i10;
                            iArr12 = new int[64];
                            i20 = 1 << (readVLC - 1);
                            i28 = 0;
                            while (i28 < readVLC) {
                                if ((i7 & i20) == 0) {
                                    iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                                    if (mBType3.macroblock_intra != i26) {
                                        iArr14 = context2.intra_dc_predictor;
                                        iArr15 = context2.scan;
                                        if (!mPEGDecoder.sh.hasExtensions()) {
                                            if (!pictureHeader.hasExtensions()) {
                                                i21 = i8;
                                                iArr16 = iArr15;
                                                iArr15 = iArr12;
                                                i22 = i28;
                                                iArr17 = iArr12;
                                                iArr12 = iArr16;
                                                i23 = readVLC;
                                                readVLC = i21;
                                                i24 = i26;
                                                i21 = i14;
                                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                            }
                                        }
                                        i21 = 12;
                                        iArr16 = iArr15;
                                        iArr15 = iArr12;
                                        i22 = i28;
                                        iArr17 = iArr12;
                                        iArr12 = iArr16;
                                        i23 = readVLC;
                                        readVLC = i21;
                                        i24 = i26;
                                        i21 = i14;
                                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                    } else {
                                        i22 = i28;
                                        iArr17 = iArr12;
                                        i23 = readVLC;
                                        i24 = i26;
                                        i21 = i14;
                                        iArr14 = context2.scan;
                                        if (!mPEGDecoder.sh.hasExtensions()) {
                                            if (!pictureHeader.hasExtensions()) {
                                                i28 = i8;
                                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                            }
                                        }
                                        i28 = 12;
                                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                    }
                                    mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                                } else {
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    i23 = readVLC;
                                    i24 = i26;
                                    i21 = i14;
                                }
                                i28 = i22 + 1;
                                i20 >>= 1;
                                pictureHeader2 = pictureHeader;
                                i14 = i21;
                                readVLC = i23;
                                iArr12 = iArr17;
                                i26 = i24;
                            }
                            put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                            return i6;
                        }
                    }
                    i15 = i27;
                    iArr4 = iArr3;
                    mBType = mBType4;
                    i14 = 2;
                    mPEGPred.predictInFrame(mPEGDecoder.refFrames[i25], i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, i5);
                    iArr5 = iArr4;
                    mBType2 = mBType;
                    i14 = i15;
                    i26 = 3;
                    if (mBType2.macroblock_motion_backward == 0) {
                        iArr9 = iArr5;
                        mBType3 = mBType2;
                        i17 = i26;
                        iArr10 = null;
                    } else {
                        iArr6 = new int[i26][];
                        iArr6[0] = new int[256];
                        i25 = 1 << (i14 + 5);
                        iArr6[1] = new int[i25];
                        iArr6[2] = new int[i25];
                        if (pictureHeader3.pictureCodingExtension != null) {
                            if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                i5 = 256;
                                iArr7 = iArr6;
                                iArr8 = iArr5;
                                i27 = i9;
                                mBType3 = mBType2;
                                iArr9 = iArr8;
                                i17 = i26;
                                mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                iArr10 = iArr7;
                            }
                        }
                        iArr7 = iArr6;
                        iArr9 = iArr5;
                        i17 = i26;
                        i27 = i9;
                        i9 = 256;
                        mBType3 = mBType2;
                        mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                        iArr10 = iArr7;
                    }
                    context2.lastPredB = mBType3;
                    if (mBType3.macroblock_intra != 1) {
                        iArr10 = buildPred(iArr9, iArr10);
                    } else {
                        iArr10 = new int[i17][];
                        iArr10[0] = new int[256];
                        i10 = 1 << (i14 + 5);
                        iArr10[1] = new int[i10];
                        iArr10[2] = new int[i10];
                    }
                    iArr8 = iArr10;
                    Assert.assertEquals(1, bitReader.read1Bit());
                    if (mBType3.macroblock_intra != 1) {
                    }
                    if (mBType3.macroblock_pattern != 0) {
                        i25 = readCbPattern(bitReader2);
                    }
                    i7 = i25;
                    vlc = MPEGConst.vlcCoeff0;
                    pictureHeader2 = pictureHeader;
                    if (pictureHeader2.pictureCodingExtension == null) {
                        i18 = 1;
                    } else {
                        i18 = 1;
                        vlc = MPEGConst.vlcCoeff1;
                    }
                    vlc2 = vlc;
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i19 = iArr11[iArr[0]];
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i26 = 1;
                    if (i14 != 1) {
                        i10 = 2;
                        if (i14 != 2) {
                            i10 = 6;
                        }
                    } else {
                        i10 = 0;
                    }
                    readVLC = 6 + i10;
                    iArr12 = new int[64];
                    i20 = 1 << (readVLC - 1);
                    i28 = 0;
                    while (i28 < readVLC) {
                        if ((i7 & i20) == 0) {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                        } else {
                            if (i28 < 4) {
                            }
                            iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                            if (mBType3.macroblock_intra != i26) {
                                i22 = i28;
                                iArr17 = iArr12;
                                i23 = readVLC;
                                i24 = i26;
                                i21 = i14;
                                iArr14 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i28 = i8;
                                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                    }
                                }
                                i28 = 12;
                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                            } else {
                                iArr14 = context2.intra_dc_predictor;
                                iArr15 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i21 = i8;
                                        iArr16 = iArr15;
                                        iArr15 = iArr12;
                                        i22 = i28;
                                        iArr17 = iArr12;
                                        iArr12 = iArr16;
                                        i23 = readVLC;
                                        readVLC = i21;
                                        i24 = i26;
                                        i21 = i14;
                                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                    }
                                }
                                i21 = 12;
                                iArr16 = iArr15;
                                iArr15 = iArr12;
                                i22 = i28;
                                iArr17 = iArr12;
                                iArr12 = iArr16;
                                i23 = readVLC;
                                readVLC = i21;
                                i24 = i26;
                                i21 = i14;
                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                            }
                            mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                        }
                        i28 = i22 + 1;
                        i20 >>= 1;
                        pictureHeader2 = pictureHeader;
                        i14 = i21;
                        readVLC = i23;
                        iArr12 = iArr17;
                        i26 = i24;
                    }
                    put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                    return i6;
                } else {
                    mBType = mBType4;
                    i15 = i7;
                    i14 = 2;
                    if (pictureHeader3.picture_coding_type == i14) {
                        i26 = 3;
                        iArr3 = new int[3][];
                        iArr3[0] = new int[256];
                        i28 = i15;
                        i25 = 1 << (i28 + 5);
                        iArr3[1] = new int[i25];
                        iArr3[i14] = new int[i25];
                        mPEGPred.reset();
                        i14 = 1;
                        i14 = i28;
                        iArr5 = iArr3;
                        mvZero(context2, pictureHeader3, mPEGPred, i12, i13, iArr5);
                        mBType2 = mBType;
                        if (mBType2.macroblock_motion_backward == 0) {
                            iArr6 = new int[i26][];
                            iArr6[0] = new int[256];
                            i25 = 1 << (i14 + 5);
                            iArr6[1] = new int[i25];
                            iArr6[2] = new int[i25];
                            if (pictureHeader3.pictureCodingExtension != null) {
                                if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                    i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                    i5 = 256;
                                    iArr7 = iArr6;
                                    iArr8 = iArr5;
                                    i27 = i9;
                                    mBType3 = mBType2;
                                    iArr9 = iArr8;
                                    i17 = i26;
                                    mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                    iArr10 = iArr7;
                                }
                            }
                            iArr7 = iArr6;
                            iArr9 = iArr5;
                            i17 = i26;
                            i27 = i9;
                            i9 = 256;
                            mBType3 = mBType2;
                            mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                            iArr10 = iArr7;
                        } else {
                            iArr9 = iArr5;
                            mBType3 = mBType2;
                            i17 = i26;
                            iArr10 = null;
                        }
                        context2.lastPredB = mBType3;
                        if (mBType3.macroblock_intra != 1) {
                            iArr10 = new int[i17][];
                            iArr10[0] = new int[256];
                            i10 = 1 << (i14 + 5);
                            iArr10[1] = new int[i10];
                            iArr10[2] = new int[i10];
                        } else {
                            iArr10 = buildPred(iArr9, iArr10);
                        }
                        iArr8 = iArr10;
                        Assert.assertEquals(1, bitReader.read1Bit());
                        if (mBType3.macroblock_intra != 1) {
                        }
                        if (mBType3.macroblock_pattern != 0) {
                            i25 = readCbPattern(bitReader2);
                        }
                        i7 = i25;
                        vlc = MPEGConst.vlcCoeff0;
                        pictureHeader2 = pictureHeader;
                        if (pictureHeader2.pictureCodingExtension == null) {
                            i18 = 1;
                            vlc = MPEGConst.vlcCoeff1;
                        } else {
                            i18 = 1;
                        }
                        vlc2 = vlc;
                        if (pictureHeader2.pictureCodingExtension == null) {
                        }
                        i19 = iArr11[iArr[0]];
                        if (pictureHeader2.pictureCodingExtension == null) {
                        }
                        i26 = 1;
                        if (i14 != 1) {
                            i10 = 0;
                        } else {
                            i10 = 2;
                            if (i14 != 2) {
                                i10 = 6;
                            }
                        }
                        readVLC = 6 + i10;
                        iArr12 = new int[64];
                        i20 = 1 << (readVLC - 1);
                        i28 = 0;
                        while (i28 < readVLC) {
                            if ((i7 & i20) == 0) {
                                if (i28 < 4) {
                                }
                                iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                                if (mBType3.macroblock_intra != i26) {
                                    iArr14 = context2.intra_dc_predictor;
                                    iArr15 = context2.scan;
                                    if (mPEGDecoder.sh.hasExtensions()) {
                                        if (!pictureHeader.hasExtensions()) {
                                            i21 = i8;
                                            iArr16 = iArr15;
                                            iArr15 = iArr12;
                                            i22 = i28;
                                            iArr17 = iArr12;
                                            iArr12 = iArr16;
                                            i23 = readVLC;
                                            readVLC = i21;
                                            i24 = i26;
                                            i21 = i14;
                                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                        }
                                    }
                                    i21 = 12;
                                    iArr16 = iArr15;
                                    iArr15 = iArr12;
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    iArr12 = iArr16;
                                    i23 = readVLC;
                                    readVLC = i21;
                                    i24 = i26;
                                    i21 = i14;
                                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                } else {
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    i23 = readVLC;
                                    i24 = i26;
                                    i21 = i14;
                                    iArr14 = context2.scan;
                                    if (mPEGDecoder.sh.hasExtensions()) {
                                        if (!pictureHeader.hasExtensions()) {
                                            i28 = i8;
                                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                        }
                                    }
                                    i28 = 12;
                                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                }
                                mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                            } else {
                                i22 = i28;
                                iArr17 = iArr12;
                                i23 = readVLC;
                                i24 = i26;
                                i21 = i14;
                            }
                            i28 = i22 + 1;
                            i20 >>= 1;
                            pictureHeader2 = pictureHeader;
                            i14 = i21;
                            readVLC = i23;
                            iArr12 = iArr17;
                            i26 = i24;
                        }
                        put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                        return i6;
                    }
                    i14 = i15;
                    i26 = 3;
                }
                iArr5 = null;
                mBType2 = mBType;
                if (mBType2.macroblock_motion_backward == 0) {
                    iArr9 = iArr5;
                    mBType3 = mBType2;
                    i17 = i26;
                    iArr10 = null;
                } else {
                    iArr6 = new int[i26][];
                    iArr6[0] = new int[256];
                    i25 = 1 << (i14 + 5);
                    iArr6[1] = new int[i25];
                    iArr6[2] = new int[i25];
                    if (pictureHeader3.pictureCodingExtension != null) {
                        if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                            i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                            i5 = 256;
                            iArr7 = iArr6;
                            iArr8 = iArr5;
                            i27 = i9;
                            mBType3 = mBType2;
                            iArr9 = iArr8;
                            i17 = i26;
                            mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                            iArr10 = iArr7;
                        }
                    }
                    iArr7 = iArr6;
                    iArr9 = iArr5;
                    i17 = i26;
                    i27 = i9;
                    i9 = 256;
                    mBType3 = mBType2;
                    mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                    iArr10 = iArr7;
                }
                context2.lastPredB = mBType3;
                if (mBType3.macroblock_intra != 1) {
                    iArr10 = buildPred(iArr9, iArr10);
                } else {
                    iArr10 = new int[i17][];
                    iArr10[0] = new int[256];
                    i10 = 1 << (i14 + 5);
                    iArr10[1] = new int[i10];
                    iArr10[2] = new int[i10];
                }
                iArr8 = iArr10;
                Assert.assertEquals(1, bitReader.read1Bit());
                if (mBType3.macroblock_intra != 1) {
                }
                if (mBType3.macroblock_pattern != 0) {
                    i25 = readCbPattern(bitReader2);
                }
                i7 = i25;
                vlc = MPEGConst.vlcCoeff0;
                pictureHeader2 = pictureHeader;
                if (pictureHeader2.pictureCodingExtension == null) {
                    i18 = 1;
                } else {
                    i18 = 1;
                    vlc = MPEGConst.vlcCoeff1;
                }
                vlc2 = vlc;
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i19 = iArr11[iArr[0]];
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i26 = 1;
                if (i14 != 1) {
                    i10 = 2;
                    if (i14 != 2) {
                        i10 = 6;
                    }
                } else {
                    i10 = 0;
                }
                readVLC = 6 + i10;
                iArr12 = new int[64];
                i20 = 1 << (readVLC - 1);
                i28 = 0;
                while (i28 < readVLC) {
                    if ((i7 & i20) == 0) {
                        i22 = i28;
                        iArr17 = iArr12;
                        i23 = readVLC;
                        i24 = i26;
                        i21 = i14;
                    } else {
                        if (i28 < 4) {
                        }
                        iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                        if (mBType3.macroblock_intra != i26) {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                            iArr14 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i28 = i8;
                                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                }
                            }
                            i28 = 12;
                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                        } else {
                            iArr14 = context2.intra_dc_predictor;
                            iArr15 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i21 = i8;
                                    iArr16 = iArr15;
                                    iArr15 = iArr12;
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    iArr12 = iArr16;
                                    i23 = readVLC;
                                    readVLC = i21;
                                    i24 = i26;
                                    i21 = i14;
                                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                }
                            }
                            i21 = 12;
                            iArr16 = iArr15;
                            iArr15 = iArr12;
                            i22 = i28;
                            iArr17 = iArr12;
                            iArr12 = iArr16;
                            i23 = readVLC;
                            readVLC = i21;
                            i24 = i26;
                            i21 = i14;
                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                        }
                        mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                    }
                    i28 = i22 + 1;
                    i20 >>= 1;
                    pictureHeader2 = pictureHeader;
                    i14 = i21;
                    readVLC = i23;
                    iArr12 = iArr17;
                    i26 = i24;
                }
                put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                return i6;
            }
        }
        if (pictureHeader3.pictureCodingExtension != null) {
            if (pictureHeader3.pictureCodingExtension.picture_structure == 3) {
                i10 = 1;
                if (pictureHeader3.pictureCodingExtension.frame_pred_frame_dct == 1) {
                }
            } else {
                i10 = 1;
            }
            i9 = bitReader2.readNBit(2);
            if (pictureHeader3.pictureCodingExtension == null) {
            }
            if (mBType4.macroblock_quant != 0) {
                i26 = i10;
            } else {
                i26 = i10;
                iArr[0] = bitReader2.readNBit(5);
            }
            if (pictureHeader3.pictureCodingExtension != null) {
            }
            i12 = i6 % context2.mbWidth;
            i13 = i6 / context2.mbWidth;
            if (mBType4.macroblock_intra != i26) {
                if (i11 == 0) {
                    mPEGPred.reset();
                }
                i26 = 3;
                mBType = mBType4;
                i14 = i7;
            } else if (mBType4.macroblock_motion_forward != 0) {
                mBType = mBType4;
                i15 = i7;
                i14 = 2;
                if (pictureHeader3.picture_coding_type == i14) {
                    i14 = i15;
                    i26 = 3;
                } else {
                    i26 = 3;
                    iArr3 = new int[3][];
                    iArr3[0] = new int[256];
                    i28 = i15;
                    i25 = 1 << (i28 + 5);
                    iArr3[1] = new int[i25];
                    iArr3[i14] = new int[i25];
                    mPEGPred.reset();
                    i14 = 1;
                    i14 = i28;
                    iArr5 = iArr3;
                    mvZero(context2, pictureHeader3, mPEGPred, i12, i13, iArr5);
                    mBType2 = mBType;
                    if (mBType2.macroblock_motion_backward == 0) {
                        iArr6 = new int[i26][];
                        iArr6[0] = new int[256];
                        i25 = 1 << (i14 + 5);
                        iArr6[1] = new int[i25];
                        iArr6[2] = new int[i25];
                        if (pictureHeader3.pictureCodingExtension != null) {
                            if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                i5 = 256;
                                iArr7 = iArr6;
                                iArr8 = iArr5;
                                i27 = i9;
                                mBType3 = mBType2;
                                iArr9 = iArr8;
                                i17 = i26;
                                mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                iArr10 = iArr7;
                            }
                        }
                        iArr7 = iArr6;
                        iArr9 = iArr5;
                        i17 = i26;
                        i27 = i9;
                        i9 = 256;
                        mBType3 = mBType2;
                        mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                        iArr10 = iArr7;
                    } else {
                        iArr9 = iArr5;
                        mBType3 = mBType2;
                        i17 = i26;
                        iArr10 = null;
                    }
                    context2.lastPredB = mBType3;
                    if (mBType3.macroblock_intra != 1) {
                        iArr10 = new int[i17][];
                        iArr10[0] = new int[256];
                        i10 = 1 << (i14 + 5);
                        iArr10[1] = new int[i10];
                        iArr10[2] = new int[i10];
                    } else {
                        iArr10 = buildPred(iArr9, iArr10);
                    }
                    iArr8 = iArr10;
                    Assert.assertEquals(1, bitReader.read1Bit());
                    if (mBType3.macroblock_intra != 1) {
                    }
                    if (mBType3.macroblock_pattern != 0) {
                        i25 = readCbPattern(bitReader2);
                    }
                    i7 = i25;
                    vlc = MPEGConst.vlcCoeff0;
                    pictureHeader2 = pictureHeader;
                    if (pictureHeader2.pictureCodingExtension == null) {
                        i18 = 1;
                        vlc = MPEGConst.vlcCoeff1;
                    } else {
                        i18 = 1;
                    }
                    vlc2 = vlc;
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i19 = iArr11[iArr[0]];
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i26 = 1;
                    if (i14 != 1) {
                        i10 = 0;
                    } else {
                        i10 = 2;
                        if (i14 != 2) {
                            i10 = 6;
                        }
                    }
                    readVLC = 6 + i10;
                    iArr12 = new int[64];
                    i20 = 1 << (readVLC - 1);
                    i28 = 0;
                    while (i28 < readVLC) {
                        if ((i7 & i20) == 0) {
                            if (i28 < 4) {
                            }
                            iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                            if (mBType3.macroblock_intra != i26) {
                                iArr14 = context2.intra_dc_predictor;
                                iArr15 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i21 = i8;
                                        iArr16 = iArr15;
                                        iArr15 = iArr12;
                                        i22 = i28;
                                        iArr17 = iArr12;
                                        iArr12 = iArr16;
                                        i23 = readVLC;
                                        readVLC = i21;
                                        i24 = i26;
                                        i21 = i14;
                                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                    }
                                }
                                i21 = 12;
                                iArr16 = iArr15;
                                iArr15 = iArr12;
                                i22 = i28;
                                iArr17 = iArr12;
                                iArr12 = iArr16;
                                i23 = readVLC;
                                readVLC = i21;
                                i24 = i26;
                                i21 = i14;
                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                            } else {
                                i22 = i28;
                                iArr17 = iArr12;
                                i23 = readVLC;
                                i24 = i26;
                                i21 = i14;
                                iArr14 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i28 = i8;
                                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                    }
                                }
                                i28 = 12;
                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                            }
                            mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                        } else {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                        }
                        i28 = i22 + 1;
                        i20 >>= 1;
                        pictureHeader2 = pictureHeader;
                        i14 = i21;
                        readVLC = i23;
                        iArr12 = iArr17;
                        i26 = i24;
                    }
                    put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                    return i6;
                }
            } else {
                if (pictureHeader3.picture_coding_type == 2) {
                }
                iArr3 = new int[3][];
                iArr3[0] = new int[256];
                i27 = i7;
                i10 = i26 << (i27 + 5);
                iArr3[i26] = new int[i10];
                iArr3[2] = new int[i10];
                if (pictureHeader3.pictureCodingExtension != null) {
                    if (pictureHeader3.pictureCodingExtension.picture_structure == 3) {
                        if (pictureHeader3.picture_coding_type == 2) {
                            i15 = i27;
                            iArr4 = iArr3;
                            mBType = mBType4;
                            mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[i25], mPEGDecoder.refFrames[i25]}, i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                        } else {
                            mBType = mBType4;
                            i14 = 2;
                            i28 = 3;
                            i15 = i27;
                            iArr4 = iArr3;
                            mPEGPred.predictInField(mPEGDecoder.refFields, i12 << 4, i13 << 4, iArr3, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                        }
                        iArr5 = iArr4;
                        mBType2 = mBType;
                        i14 = i15;
                        i26 = 3;
                        if (mBType2.macroblock_motion_backward == 0) {
                            iArr9 = iArr5;
                            mBType3 = mBType2;
                            i17 = i26;
                            iArr10 = null;
                        } else {
                            iArr6 = new int[i26][];
                            iArr6[0] = new int[256];
                            i25 = 1 << (i14 + 5);
                            iArr6[1] = new int[i25];
                            iArr6[2] = new int[i25];
                            if (pictureHeader3.pictureCodingExtension != null) {
                                if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                    i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                    i5 = 256;
                                    iArr7 = iArr6;
                                    iArr8 = iArr5;
                                    i27 = i9;
                                    mBType3 = mBType2;
                                    iArr9 = iArr8;
                                    i17 = i26;
                                    mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                    iArr10 = iArr7;
                                }
                            }
                            iArr7 = iArr6;
                            iArr9 = iArr5;
                            i17 = i26;
                            i27 = i9;
                            i9 = 256;
                            mBType3 = mBType2;
                            mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                            iArr10 = iArr7;
                        }
                        context2.lastPredB = mBType3;
                        if (mBType3.macroblock_intra != 1) {
                            iArr10 = buildPred(iArr9, iArr10);
                        } else {
                            iArr10 = new int[i17][];
                            iArr10[0] = new int[256];
                            i10 = 1 << (i14 + 5);
                            iArr10[1] = new int[i10];
                            iArr10[2] = new int[i10];
                        }
                        iArr8 = iArr10;
                        Assert.assertEquals(1, bitReader.read1Bit());
                        if (mBType3.macroblock_intra != 1) {
                        }
                        if (mBType3.macroblock_pattern != 0) {
                            i25 = readCbPattern(bitReader2);
                        }
                        i7 = i25;
                        vlc = MPEGConst.vlcCoeff0;
                        pictureHeader2 = pictureHeader;
                        if (pictureHeader2.pictureCodingExtension == null) {
                            i18 = 1;
                        } else {
                            i18 = 1;
                            vlc = MPEGConst.vlcCoeff1;
                        }
                        vlc2 = vlc;
                        if (pictureHeader2.pictureCodingExtension == null) {
                        }
                        i19 = iArr11[iArr[0]];
                        if (pictureHeader2.pictureCodingExtension == null) {
                        }
                        i26 = 1;
                        if (i14 != 1) {
                            i10 = 2;
                            if (i14 != 2) {
                                i10 = 6;
                            }
                        } else {
                            i10 = 0;
                        }
                        readVLC = 6 + i10;
                        iArr12 = new int[64];
                        i20 = 1 << (readVLC - 1);
                        i28 = 0;
                        while (i28 < readVLC) {
                            if ((i7 & i20) == 0) {
                                i22 = i28;
                                iArr17 = iArr12;
                                i23 = readVLC;
                                i24 = i26;
                                i21 = i14;
                            } else {
                                if (i28 < 4) {
                                }
                                iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                                if (mBType3.macroblock_intra != i26) {
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    i23 = readVLC;
                                    i24 = i26;
                                    i21 = i14;
                                    iArr14 = context2.scan;
                                    if (mPEGDecoder.sh.hasExtensions()) {
                                        if (!pictureHeader.hasExtensions()) {
                                            i28 = i8;
                                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                        }
                                    }
                                    i28 = 12;
                                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                } else {
                                    iArr14 = context2.intra_dc_predictor;
                                    iArr15 = context2.scan;
                                    if (mPEGDecoder.sh.hasExtensions()) {
                                        if (!pictureHeader.hasExtensions()) {
                                            i21 = i8;
                                            iArr16 = iArr15;
                                            iArr15 = iArr12;
                                            i22 = i28;
                                            iArr17 = iArr12;
                                            iArr12 = iArr16;
                                            i23 = readVLC;
                                            readVLC = i21;
                                            i24 = i26;
                                            i21 = i14;
                                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                        }
                                    }
                                    i21 = 12;
                                    iArr16 = iArr15;
                                    iArr15 = iArr12;
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    iArr12 = iArr16;
                                    i23 = readVLC;
                                    readVLC = i21;
                                    i24 = i26;
                                    i21 = i14;
                                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                }
                                mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                            }
                            i28 = i22 + 1;
                            i20 >>= 1;
                            pictureHeader2 = pictureHeader;
                            i14 = i21;
                            readVLC = i23;
                            iArr12 = iArr17;
                            i26 = i24;
                        }
                        put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                        return i6;
                    }
                }
                i15 = i27;
                iArr4 = iArr3;
                mBType = mBType4;
                i14 = 2;
                mPEGPred.predictInFrame(mPEGDecoder.refFrames[i25], i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, i5);
                iArr5 = iArr4;
                mBType2 = mBType;
                i14 = i15;
                i26 = 3;
                if (mBType2.macroblock_motion_backward == 0) {
                    iArr6 = new int[i26][];
                    iArr6[0] = new int[256];
                    i25 = 1 << (i14 + 5);
                    iArr6[1] = new int[i25];
                    iArr6[2] = new int[i25];
                    if (pictureHeader3.pictureCodingExtension != null) {
                        if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                            i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                            i5 = 256;
                            iArr7 = iArr6;
                            iArr8 = iArr5;
                            i27 = i9;
                            mBType3 = mBType2;
                            iArr9 = iArr8;
                            i17 = i26;
                            mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                            iArr10 = iArr7;
                        }
                    }
                    iArr7 = iArr6;
                    iArr9 = iArr5;
                    i17 = i26;
                    i27 = i9;
                    i9 = 256;
                    mBType3 = mBType2;
                    mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                    iArr10 = iArr7;
                } else {
                    iArr9 = iArr5;
                    mBType3 = mBType2;
                    i17 = i26;
                    iArr10 = null;
                }
                context2.lastPredB = mBType3;
                if (mBType3.macroblock_intra != 1) {
                    iArr10 = new int[i17][];
                    iArr10[0] = new int[256];
                    i10 = 1 << (i14 + 5);
                    iArr10[1] = new int[i10];
                    iArr10[2] = new int[i10];
                } else {
                    iArr10 = buildPred(iArr9, iArr10);
                }
                iArr8 = iArr10;
                Assert.assertEquals(1, bitReader.read1Bit());
                if (mBType3.macroblock_intra != 1) {
                }
                if (mBType3.macroblock_pattern != 0) {
                    i25 = readCbPattern(bitReader2);
                }
                i7 = i25;
                vlc = MPEGConst.vlcCoeff0;
                pictureHeader2 = pictureHeader;
                if (pictureHeader2.pictureCodingExtension == null) {
                    i18 = 1;
                    vlc = MPEGConst.vlcCoeff1;
                } else {
                    i18 = 1;
                }
                vlc2 = vlc;
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i19 = iArr11[iArr[0]];
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i26 = 1;
                if (i14 != 1) {
                    i10 = 0;
                } else {
                    i10 = 2;
                    if (i14 != 2) {
                        i10 = 6;
                    }
                }
                readVLC = 6 + i10;
                iArr12 = new int[64];
                i20 = 1 << (readVLC - 1);
                i28 = 0;
                while (i28 < readVLC) {
                    if ((i7 & i20) == 0) {
                        if (i28 < 4) {
                        }
                        iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                        if (mBType3.macroblock_intra != i26) {
                            iArr14 = context2.intra_dc_predictor;
                            iArr15 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i21 = i8;
                                    iArr16 = iArr15;
                                    iArr15 = iArr12;
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    iArr12 = iArr16;
                                    i23 = readVLC;
                                    readVLC = i21;
                                    i24 = i26;
                                    i21 = i14;
                                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                }
                            }
                            i21 = 12;
                            iArr16 = iArr15;
                            iArr15 = iArr12;
                            i22 = i28;
                            iArr17 = iArr12;
                            iArr12 = iArr16;
                            i23 = readVLC;
                            readVLC = i21;
                            i24 = i26;
                            i21 = i14;
                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                        } else {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                            iArr14 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i28 = i8;
                                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                }
                            }
                            i28 = 12;
                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                        }
                        mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                    } else {
                        i22 = i28;
                        iArr17 = iArr12;
                        i23 = readVLC;
                        i24 = i26;
                        i21 = i14;
                    }
                    i28 = i22 + 1;
                    i20 >>= 1;
                    pictureHeader2 = pictureHeader;
                    i14 = i21;
                    readVLC = i23;
                    iArr12 = iArr17;
                    i26 = i24;
                }
                put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                return i6;
            }
            iArr5 = null;
            mBType2 = mBType;
            if (mBType2.macroblock_motion_backward == 0) {
                iArr9 = iArr5;
                mBType3 = mBType2;
                i17 = i26;
                iArr10 = null;
            } else {
                iArr6 = new int[i26][];
                iArr6[0] = new int[256];
                i25 = 1 << (i14 + 5);
                iArr6[1] = new int[i25];
                iArr6[2] = new int[i25];
                if (pictureHeader3.pictureCodingExtension != null) {
                    if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                        i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                        i5 = 256;
                        iArr7 = iArr6;
                        iArr8 = iArr5;
                        i27 = i9;
                        mBType3 = mBType2;
                        iArr9 = iArr8;
                        i17 = i26;
                        mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                        iArr10 = iArr7;
                    }
                }
                iArr7 = iArr6;
                iArr9 = iArr5;
                i17 = i26;
                i27 = i9;
                i9 = 256;
                mBType3 = mBType2;
                mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                iArr10 = iArr7;
            }
            context2.lastPredB = mBType3;
            if (mBType3.macroblock_intra != 1) {
                iArr10 = buildPred(iArr9, iArr10);
            } else {
                iArr10 = new int[i17][];
                iArr10[0] = new int[256];
                i10 = 1 << (i14 + 5);
                iArr10[1] = new int[i10];
                iArr10[2] = new int[i10];
            }
            iArr8 = iArr10;
            Assert.assertEquals(1, bitReader.read1Bit());
            if (mBType3.macroblock_intra != 1) {
            }
            if (mBType3.macroblock_pattern != 0) {
                i25 = readCbPattern(bitReader2);
            }
            i7 = i25;
            vlc = MPEGConst.vlcCoeff0;
            pictureHeader2 = pictureHeader;
            if (pictureHeader2.pictureCodingExtension == null) {
                i18 = 1;
            } else {
                i18 = 1;
                vlc = MPEGConst.vlcCoeff1;
            }
            vlc2 = vlc;
            if (pictureHeader2.pictureCodingExtension == null) {
            }
            i19 = iArr11[iArr[0]];
            if (pictureHeader2.pictureCodingExtension == null) {
            }
            i26 = 1;
            if (i14 != 1) {
                i10 = 2;
                if (i14 != 2) {
                    i10 = 6;
                }
            } else {
                i10 = 0;
            }
            readVLC = 6 + i10;
            iArr12 = new int[64];
            i20 = 1 << (readVLC - 1);
            i28 = 0;
            while (i28 < readVLC) {
                if ((i7 & i20) == 0) {
                    i22 = i28;
                    iArr17 = iArr12;
                    i23 = readVLC;
                    i24 = i26;
                    i21 = i14;
                } else {
                    if (i28 < 4) {
                    }
                    iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                    if (mBType3.macroblock_intra != i26) {
                        i22 = i28;
                        iArr17 = iArr12;
                        i23 = readVLC;
                        i24 = i26;
                        i21 = i14;
                        iArr14 = context2.scan;
                        if (mPEGDecoder.sh.hasExtensions()) {
                            if (!pictureHeader.hasExtensions()) {
                                i28 = i8;
                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                            }
                        }
                        i28 = 12;
                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                    } else {
                        iArr14 = context2.intra_dc_predictor;
                        iArr15 = context2.scan;
                        if (mPEGDecoder.sh.hasExtensions()) {
                            if (!pictureHeader.hasExtensions()) {
                                i21 = i8;
                                iArr16 = iArr15;
                                iArr15 = iArr12;
                                i22 = i28;
                                iArr17 = iArr12;
                                iArr12 = iArr16;
                                i23 = readVLC;
                                readVLC = i21;
                                i24 = i26;
                                i21 = i14;
                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                            }
                        }
                        i21 = 12;
                        iArr16 = iArr15;
                        iArr15 = iArr12;
                        i22 = i28;
                        iArr17 = iArr12;
                        iArr12 = iArr16;
                        i23 = readVLC;
                        readVLC = i21;
                        i24 = i26;
                        i21 = i14;
                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                    }
                    mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                }
                i28 = i22 + 1;
                i20 >>= 1;
                pictureHeader2 = pictureHeader;
                i14 = i21;
                readVLC = i23;
                iArr12 = iArr17;
                i26 = i24;
            }
            put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
            return i6;
        }
        i10 = 1;
        i9 = 2;
        if (pictureHeader3.pictureCodingExtension == null) {
        }
        if (mBType4.macroblock_quant != 0) {
            i26 = i10;
            iArr[0] = bitReader2.readNBit(5);
        } else {
            i26 = i10;
        }
        if (pictureHeader3.pictureCodingExtension != null) {
        }
        i12 = i6 % context2.mbWidth;
        i13 = i6 / context2.mbWidth;
        if (mBType4.macroblock_intra != i26) {
            if (i11 == 0) {
                mPEGPred.reset();
            }
            i26 = 3;
            mBType = mBType4;
            i14 = i7;
        } else if (mBType4.macroblock_motion_forward != 0) {
            if (pictureHeader3.picture_coding_type == 2) {
            }
            iArr3 = new int[3][];
            iArr3[0] = new int[256];
            i27 = i7;
            i10 = i26 << (i27 + 5);
            iArr3[i26] = new int[i10];
            iArr3[2] = new int[i10];
            if (pictureHeader3.pictureCodingExtension != null) {
                if (pictureHeader3.pictureCodingExtension.picture_structure == 3) {
                    if (pictureHeader3.picture_coding_type == 2) {
                        mBType = mBType4;
                        i14 = 2;
                        i28 = 3;
                        i15 = i27;
                        iArr4 = iArr3;
                        mPEGPred.predictInField(mPEGDecoder.refFields, i12 << 4, i13 << 4, iArr3, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                    } else {
                        i15 = i27;
                        iArr4 = iArr3;
                        mBType = mBType4;
                        mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[i25], mPEGDecoder.refFrames[i25]}, i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, pictureHeader3.pictureCodingExtension.picture_structure - 1);
                    }
                    iArr5 = iArr4;
                    mBType2 = mBType;
                    i14 = i15;
                    i26 = 3;
                    if (mBType2.macroblock_motion_backward == 0) {
                        iArr6 = new int[i26][];
                        iArr6[0] = new int[256];
                        i25 = 1 << (i14 + 5);
                        iArr6[1] = new int[i25];
                        iArr6[2] = new int[i25];
                        if (pictureHeader3.pictureCodingExtension != null) {
                            if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                                i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                                i5 = 256;
                                iArr7 = iArr6;
                                iArr8 = iArr5;
                                i27 = i9;
                                mBType3 = mBType2;
                                iArr9 = iArr8;
                                i17 = i26;
                                mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                                iArr10 = iArr7;
                            }
                        }
                        iArr7 = iArr6;
                        iArr9 = iArr5;
                        i17 = i26;
                        i27 = i9;
                        i9 = 256;
                        mBType3 = mBType2;
                        mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                        iArr10 = iArr7;
                    } else {
                        iArr9 = iArr5;
                        mBType3 = mBType2;
                        i17 = i26;
                        iArr10 = null;
                    }
                    context2.lastPredB = mBType3;
                    if (mBType3.macroblock_intra != 1) {
                        iArr10 = new int[i17][];
                        iArr10[0] = new int[256];
                        i10 = 1 << (i14 + 5);
                        iArr10[1] = new int[i10];
                        iArr10[2] = new int[i10];
                    } else {
                        iArr10 = buildPred(iArr9, iArr10);
                    }
                    iArr8 = iArr10;
                    Assert.assertEquals(1, bitReader.read1Bit());
                    if (mBType3.macroblock_intra != 1) {
                    }
                    if (mBType3.macroblock_pattern != 0) {
                        i25 = readCbPattern(bitReader2);
                    }
                    i7 = i25;
                    vlc = MPEGConst.vlcCoeff0;
                    pictureHeader2 = pictureHeader;
                    if (pictureHeader2.pictureCodingExtension == null) {
                        i18 = 1;
                        vlc = MPEGConst.vlcCoeff1;
                    } else {
                        i18 = 1;
                    }
                    vlc2 = vlc;
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i19 = iArr11[iArr[0]];
                    if (pictureHeader2.pictureCodingExtension == null) {
                    }
                    i26 = 1;
                    if (i14 != 1) {
                        i10 = 0;
                    } else {
                        i10 = 2;
                        if (i14 != 2) {
                            i10 = 6;
                        }
                    }
                    readVLC = 6 + i10;
                    iArr12 = new int[64];
                    i20 = 1 << (readVLC - 1);
                    i28 = 0;
                    while (i28 < readVLC) {
                        if ((i7 & i20) == 0) {
                            if (i28 < 4) {
                            }
                            iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                            if (mBType3.macroblock_intra != i26) {
                                iArr14 = context2.intra_dc_predictor;
                                iArr15 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i21 = i8;
                                        iArr16 = iArr15;
                                        iArr15 = iArr12;
                                        i22 = i28;
                                        iArr17 = iArr12;
                                        iArr12 = iArr16;
                                        i23 = readVLC;
                                        readVLC = i21;
                                        i24 = i26;
                                        i21 = i14;
                                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                    }
                                }
                                i21 = 12;
                                iArr16 = iArr15;
                                iArr15 = iArr12;
                                i22 = i28;
                                iArr17 = iArr12;
                                iArr12 = iArr16;
                                i23 = readVLC;
                                readVLC = i21;
                                i24 = i26;
                                i21 = i14;
                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                            } else {
                                i22 = i28;
                                iArr17 = iArr12;
                                i23 = readVLC;
                                i24 = i26;
                                i21 = i14;
                                iArr14 = context2.scan;
                                if (mPEGDecoder.sh.hasExtensions()) {
                                    if (!pictureHeader.hasExtensions()) {
                                        i28 = i8;
                                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                    }
                                }
                                i28 = 12;
                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                            }
                            mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                        } else {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                        }
                        i28 = i22 + 1;
                        i20 >>= 1;
                        pictureHeader2 = pictureHeader;
                        i14 = i21;
                        readVLC = i23;
                        iArr12 = iArr17;
                        i26 = i24;
                    }
                    put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                    return i6;
                }
            }
            i15 = i27;
            iArr4 = iArr3;
            mBType = mBType4;
            i14 = 2;
            mPEGPred.predictInFrame(mPEGDecoder.refFrames[i25], i12 << 4, i13 << 4, iArr4, bitReader2, i9, 0, i5);
            iArr5 = iArr4;
            mBType2 = mBType;
            i14 = i15;
            i26 = 3;
            if (mBType2.macroblock_motion_backward == 0) {
                iArr9 = iArr5;
                mBType3 = mBType2;
                i17 = i26;
                iArr10 = null;
            } else {
                iArr6 = new int[i26][];
                iArr6[0] = new int[256];
                i25 = 1 << (i14 + 5);
                iArr6[1] = new int[i25];
                iArr6[2] = new int[i25];
                if (pictureHeader3.pictureCodingExtension != null) {
                    if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                        i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                        i5 = 256;
                        iArr7 = iArr6;
                        iArr8 = iArr5;
                        i27 = i9;
                        mBType3 = mBType2;
                        iArr9 = iArr8;
                        i17 = i26;
                        mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                        iArr10 = iArr7;
                    }
                }
                iArr7 = iArr6;
                iArr9 = iArr5;
                i17 = i26;
                i27 = i9;
                i9 = 256;
                mBType3 = mBType2;
                mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                iArr10 = iArr7;
            }
            context2.lastPredB = mBType3;
            if (mBType3.macroblock_intra != 1) {
                iArr10 = buildPred(iArr9, iArr10);
            } else {
                iArr10 = new int[i17][];
                iArr10[0] = new int[256];
                i10 = 1 << (i14 + 5);
                iArr10[1] = new int[i10];
                iArr10[2] = new int[i10];
            }
            iArr8 = iArr10;
            Assert.assertEquals(1, bitReader.read1Bit());
            if (mBType3.macroblock_intra != 1) {
            }
            if (mBType3.macroblock_pattern != 0) {
                i25 = readCbPattern(bitReader2);
            }
            i7 = i25;
            vlc = MPEGConst.vlcCoeff0;
            pictureHeader2 = pictureHeader;
            if (pictureHeader2.pictureCodingExtension == null) {
                i18 = 1;
            } else {
                i18 = 1;
                vlc = MPEGConst.vlcCoeff1;
            }
            vlc2 = vlc;
            if (pictureHeader2.pictureCodingExtension == null) {
            }
            i19 = iArr11[iArr[0]];
            if (pictureHeader2.pictureCodingExtension == null) {
            }
            i26 = 1;
            if (i14 != 1) {
                i10 = 2;
                if (i14 != 2) {
                    i10 = 6;
                }
            } else {
                i10 = 0;
            }
            readVLC = 6 + i10;
            iArr12 = new int[64];
            i20 = 1 << (readVLC - 1);
            i28 = 0;
            while (i28 < readVLC) {
                if ((i7 & i20) == 0) {
                    i22 = i28;
                    iArr17 = iArr12;
                    i23 = readVLC;
                    i24 = i26;
                    i21 = i14;
                } else {
                    if (i28 < 4) {
                    }
                    iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                    if (mBType3.macroblock_intra != i26) {
                        i22 = i28;
                        iArr17 = iArr12;
                        i23 = readVLC;
                        i24 = i26;
                        i21 = i14;
                        iArr14 = context2.scan;
                        if (mPEGDecoder.sh.hasExtensions()) {
                            if (!pictureHeader.hasExtensions()) {
                                i28 = i8;
                                blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                            }
                        }
                        i28 = 12;
                        blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                    } else {
                        iArr14 = context2.intra_dc_predictor;
                        iArr15 = context2.scan;
                        if (mPEGDecoder.sh.hasExtensions()) {
                            if (!pictureHeader.hasExtensions()) {
                                i21 = i8;
                                iArr16 = iArr15;
                                iArr15 = iArr12;
                                i22 = i28;
                                iArr17 = iArr12;
                                iArr12 = iArr16;
                                i23 = readVLC;
                                readVLC = i21;
                                i24 = i26;
                                i21 = i14;
                                blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                            }
                        }
                        i21 = 12;
                        iArr16 = iArr15;
                        iArr15 = iArr12;
                        i22 = i28;
                        iArr17 = iArr12;
                        iArr12 = iArr16;
                        i23 = readVLC;
                        readVLC = i21;
                        i24 = i26;
                        i21 = i14;
                        blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                    }
                    mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                }
                i28 = i22 + 1;
                i20 >>= 1;
                pictureHeader2 = pictureHeader;
                i14 = i21;
                readVLC = i23;
                iArr12 = iArr17;
                i26 = i24;
            }
            put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
            return i6;
        } else {
            mBType = mBType4;
            i15 = i7;
            i14 = 2;
            if (pictureHeader3.picture_coding_type == i14) {
                i26 = 3;
                iArr3 = new int[3][];
                iArr3[0] = new int[256];
                i28 = i15;
                i25 = 1 << (i28 + 5);
                iArr3[1] = new int[i25];
                iArr3[i14] = new int[i25];
                mPEGPred.reset();
                i14 = 1;
                i14 = i28;
                iArr5 = iArr3;
                mvZero(context2, pictureHeader3, mPEGPred, i12, i13, iArr5);
                mBType2 = mBType;
                if (mBType2.macroblock_motion_backward == 0) {
                    iArr6 = new int[i26][];
                    iArr6[0] = new int[256];
                    i25 = 1 << (i14 + 5);
                    iArr6[1] = new int[i25];
                    iArr6[2] = new int[i25];
                    if (pictureHeader3.pictureCodingExtension != null) {
                        if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                            i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                            i5 = 256;
                            iArr7 = iArr6;
                            iArr8 = iArr5;
                            i27 = i9;
                            mBType3 = mBType2;
                            iArr9 = iArr8;
                            i17 = i26;
                            mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                            iArr10 = iArr7;
                        }
                    }
                    iArr7 = iArr6;
                    iArr9 = iArr5;
                    i17 = i26;
                    i27 = i9;
                    i9 = 256;
                    mBType3 = mBType2;
                    mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
                    iArr10 = iArr7;
                } else {
                    iArr9 = iArr5;
                    mBType3 = mBType2;
                    i17 = i26;
                    iArr10 = null;
                }
                context2.lastPredB = mBType3;
                if (mBType3.macroblock_intra != 1) {
                    iArr10 = new int[i17][];
                    iArr10[0] = new int[256];
                    i10 = 1 << (i14 + 5);
                    iArr10[1] = new int[i10];
                    iArr10[2] = new int[i10];
                } else {
                    iArr10 = buildPred(iArr9, iArr10);
                }
                iArr8 = iArr10;
                Assert.assertEquals(1, bitReader.read1Bit());
                if (mBType3.macroblock_intra != 1) {
                }
                if (mBType3.macroblock_pattern != 0) {
                    i25 = readCbPattern(bitReader2);
                }
                i7 = i25;
                vlc = MPEGConst.vlcCoeff0;
                pictureHeader2 = pictureHeader;
                if (pictureHeader2.pictureCodingExtension == null) {
                    i18 = 1;
                    vlc = MPEGConst.vlcCoeff1;
                } else {
                    i18 = 1;
                }
                vlc2 = vlc;
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i19 = iArr11[iArr[0]];
                if (pictureHeader2.pictureCodingExtension == null) {
                }
                i26 = 1;
                if (i14 != 1) {
                    i10 = 0;
                } else {
                    i10 = 2;
                    if (i14 != 2) {
                        i10 = 6;
                    }
                }
                readVLC = 6 + i10;
                iArr12 = new int[64];
                i20 = 1 << (readVLC - 1);
                i28 = 0;
                while (i28 < readVLC) {
                    if ((i7 & i20) == 0) {
                        if (i28 < 4) {
                        }
                        iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                        if (mBType3.macroblock_intra != i26) {
                            iArr14 = context2.intra_dc_predictor;
                            iArr15 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i21 = i8;
                                    iArr16 = iArr15;
                                    iArr15 = iArr12;
                                    i22 = i28;
                                    iArr17 = iArr12;
                                    iArr12 = iArr16;
                                    i23 = readVLC;
                                    readVLC = i21;
                                    i24 = i26;
                                    i21 = i14;
                                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                                }
                            }
                            i21 = 12;
                            iArr16 = iArr15;
                            iArr15 = iArr12;
                            i22 = i28;
                            iArr17 = iArr12;
                            iArr12 = iArr16;
                            i23 = readVLC;
                            readVLC = i21;
                            i24 = i26;
                            i21 = i14;
                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                        } else {
                            i22 = i28;
                            iArr17 = iArr12;
                            i23 = readVLC;
                            i24 = i26;
                            i21 = i14;
                            iArr14 = context2.scan;
                            if (mPEGDecoder.sh.hasExtensions()) {
                                if (!pictureHeader.hasExtensions()) {
                                    i28 = i8;
                                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                                }
                            }
                            i28 = 12;
                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                        }
                        mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
                    } else {
                        i22 = i28;
                        iArr17 = iArr12;
                        i23 = readVLC;
                        i24 = i26;
                        i21 = i14;
                    }
                    i28 = i22 + 1;
                    i20 >>= 1;
                    pictureHeader2 = pictureHeader;
                    i14 = i21;
                    readVLC = i23;
                    iArr12 = iArr17;
                    i26 = i24;
                }
                put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
                return i6;
            }
            i14 = i15;
            i26 = 3;
        }
        iArr5 = null;
        mBType2 = mBType;
        if (mBType2.macroblock_motion_backward == 0) {
            iArr9 = iArr5;
            mBType3 = mBType2;
            i17 = i26;
            iArr10 = null;
        } else {
            iArr6 = new int[i26][];
            iArr6[0] = new int[256];
            i25 = 1 << (i14 + 5);
            iArr6[1] = new int[i25];
            iArr6[2] = new int[i25];
            if (pictureHeader3.pictureCodingExtension != null) {
                if (pictureHeader3.pictureCodingExtension.picture_structure != i26) {
                    i16 = pictureHeader3.pictureCodingExtension.picture_structure - 1;
                    i5 = 256;
                    iArr7 = iArr6;
                    iArr8 = iArr5;
                    i27 = i9;
                    mBType3 = mBType2;
                    iArr9 = iArr8;
                    i17 = i26;
                    mPEGPred.predictInField(new Picture[]{mPEGDecoder.refFrames[0], mPEGDecoder.refFrames[0]}, i12 << 4, i13 << 4, iArr6, bitReader2, i27, 1, i16);
                    iArr10 = iArr7;
                }
            }
            iArr7 = iArr6;
            iArr9 = iArr5;
            i17 = i26;
            i27 = i9;
            i9 = 256;
            mBType3 = mBType2;
            mPEGPred.predictInFrame(mPEGDecoder.refFrames[0], i12 << 4, i13 << 4, iArr7, bitReader2, i27, 1, i5);
            iArr10 = iArr7;
        }
        context2.lastPredB = mBType3;
        if (mBType3.macroblock_intra != 1) {
            iArr10 = buildPred(iArr9, iArr10);
        } else {
            iArr10 = new int[i17][];
            iArr10[0] = new int[256];
            i10 = 1 << (i14 + 5);
            iArr10[1] = new int[i10];
            iArr10[2] = new int[i10];
        }
        iArr8 = iArr10;
        Assert.assertEquals(1, bitReader.read1Bit());
        if (mBType3.macroblock_intra != 1) {
        }
        if (mBType3.macroblock_pattern != 0) {
            i25 = readCbPattern(bitReader2);
        }
        i7 = i25;
        vlc = MPEGConst.vlcCoeff0;
        pictureHeader2 = pictureHeader;
        if (pictureHeader2.pictureCodingExtension == null) {
            i18 = 1;
        } else {
            i18 = 1;
            vlc = MPEGConst.vlcCoeff1;
        }
        vlc2 = vlc;
        if (pictureHeader2.pictureCodingExtension == null) {
        }
        i19 = iArr11[iArr[0]];
        if (pictureHeader2.pictureCodingExtension == null) {
        }
        i26 = 1;
        if (i14 != 1) {
            i10 = 2;
            if (i14 != 2) {
                i10 = 6;
            }
        } else {
            i10 = 0;
        }
        readVLC = 6 + i10;
        iArr12 = new int[64];
        i20 = 1 << (readVLC - 1);
        i28 = 0;
        while (i28 < readVLC) {
            if ((i7 & i20) == 0) {
                i22 = i28;
                iArr17 = iArr12;
                i23 = readVLC;
                i24 = i26;
                i21 = i14;
            } else {
                if (i28 < 4) {
                }
                iArr13 = context2.qMats[(i28 < 4 ? i26 : 0) + (mBType3.macroblock_intra << i26)];
                if (mBType3.macroblock_intra != i26) {
                    i22 = i28;
                    iArr17 = iArr12;
                    i23 = readVLC;
                    i24 = i26;
                    i21 = i14;
                    iArr14 = context2.scan;
                    if (mPEGDecoder.sh.hasExtensions()) {
                        if (!pictureHeader.hasExtensions()) {
                            i28 = i8;
                            blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                        }
                    }
                    i28 = 12;
                    blockInter(bitReader2, vlc2, iArr17, iArr14, i28, i19, iArr13);
                } else {
                    iArr14 = context2.intra_dc_predictor;
                    iArr15 = context2.scan;
                    if (mPEGDecoder.sh.hasExtensions()) {
                        if (!pictureHeader.hasExtensions()) {
                            i21 = i8;
                            iArr16 = iArr15;
                            iArr15 = iArr12;
                            i22 = i28;
                            iArr17 = iArr12;
                            iArr12 = iArr16;
                            i23 = readVLC;
                            readVLC = i21;
                            i24 = i26;
                            i21 = i14;
                            blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                        }
                    }
                    i21 = 12;
                    iArr16 = iArr15;
                    iArr15 = iArr12;
                    i22 = i28;
                    iArr17 = iArr12;
                    iArr12 = iArr16;
                    i23 = readVLC;
                    readVLC = i21;
                    i24 = i26;
                    i21 = i14;
                    blockIntra(bitReader2, vlc2, iArr15, iArr14, i28, iArr12, readVLC, i16, i19, iArr13);
                }
                mapBlock(iArr17, iArr8[MPEGConst.BLOCK_TO_CC[i22]], i22, i30, i21);
            }
            i28 = i22 + 1;
            i20 >>= 1;
            pictureHeader2 = pictureHeader;
            i14 = i21;
            readVLC = i23;
            iArr12 = iArr17;
            i26 = i24;
        }
        put(iArr8, iArr2, i2, i14, i12, i13, context2.codedWidth, context2.codedHeight >> i4, i3, i4);
        return i6;
    }

    protected void mapBlock(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = (i3 == 1 && (i == 4 || i == 5)) ? 0 : i2;
        i3 = i < 4 ? 4 : 4 - MPEGConst.SQUEEZE_X[i3];
        i += i2 << 4;
        i = (MPEGConst.BLOCK_POS_Y[i] << i3) + MPEGConst.BLOCK_POS_X[i];
        i2 = 1 << (i3 + i5);
        i3 = 0;
        while (i4 < 8) {
            iArr2[i] = iArr2[i] + iArr[i3];
            int i6 = i + 1;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 1];
            i6 = i + 2;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 2];
            i6 = i + 3;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 3];
            i6 = i + 4;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 4];
            i6 = i + 5;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 5];
            i6 = i + 6;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 6];
            i6 = i + 7;
            iArr2[i6] = iArr2[i6] + iArr[i3 + 7];
            i += i2;
            i4++;
            i3 += 8;
        }
    }

    private static final int[][] buildPred(int[][] iArr, int[][] iArr2) {
        if (iArr != null && iArr2 != null) {
            avgPred(iArr, iArr2);
            return iArr;
        } else if (iArr != null) {
            return iArr;
        } else {
            if (iArr2 != null) {
                return iArr2;
            }
            throw new RuntimeException("Omited pred in B-frames --> invalid");
        }
    }

    private static final void avgPred(int[][] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i].length; i2 += 4) {
                iArr[i][i2] = ((iArr[i][i2] + iArr2[i][i2]) + 1) >> 1;
                int i3 = i2 + 1;
                iArr[i][i3] = ((iArr[i][i3] + iArr2[i][i3]) + 1) >> 1;
                i3 = i2 + 2;
                iArr[i][i3] = ((iArr[i][i3] + iArr2[i][i3]) + 1) >> 1;
                i3 = i2 + 3;
                iArr[i][i3] = ((iArr[i][i3] + iArr2[i][i3]) + 1) >> 1;
            }
        }
    }

    private void mvZero(Context context, PictureHeader pictureHeader, MPEGPred mPEGPred, int i, int i2, int[][] iArr) {
        MPEGDecoder mPEGDecoder = this;
        Context context2 = context;
        PictureHeader pictureHeader2 = pictureHeader;
        int[][] iArr2 = iArr;
        int i3 = 3;
        if (pictureHeader2.picture_coding_type == 2) {
            Picture picture = mPEGDecoder.refFrames[0];
            int i4 = i << 4;
            int i5 = i2 << 4;
            if (pictureHeader2.pictureCodingExtension != null) {
                i3 = pictureHeader2.pictureCodingExtension.picture_structure;
            }
            mPEGPred.predict16x16NoMV(picture, i4, i5, i3, 0, iArr2);
            return;
        }
        int i6;
        int[][] iArr3;
        if (context2.lastPredB.macroblock_motion_backward == 1) {
            i6 = 1;
            mPEGPred.predict16x16NoMV(mPEGDecoder.refFrames[0], i << 4, i2 << 4, pictureHeader2.pictureCodingExtension == null ? 3 : pictureHeader2.pictureCodingExtension.picture_structure, 1, iArr2);
            iArr3 = new int[][]{new int[iArr2[0].length], new int[iArr2[i6].length], new int[iArr2[2].length]};
        } else {
            i6 = 1;
            iArr3 = iArr2;
        }
        if (context2.lastPredB.macroblock_motion_forward == i6) {
            Picture picture2 = mPEGDecoder.refFrames[i6];
            int i7 = i << 4;
            int i8 = i2 << 4;
            if (pictureHeader2.pictureCodingExtension != null) {
                i3 = pictureHeader2.pictureCodingExtension.picture_structure;
            }
            mPEGPred.predict16x16NoMV(picture2, i7, i8, i3, 0, iArr3);
            if (iArr2 != iArr3) {
                avgPred(iArr2, iArr3);
            }
        }
    }

    protected void put(int[][] iArr, int[][] iArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = ((i + (1 << MPEGConst.SQUEEZE_X[i2])) - 1) >> MPEGConst.SQUEEZE_X[i2];
        int i10 = 4 - MPEGConst.SQUEEZE_X[i2];
        int i11 = 4 - MPEGConst.SQUEEZE_Y[i2];
        int i12 = i << i8;
        putSub(iArr2[0], (((i4 << 4) * i12) + (i7 * i)) + (i3 << 4), i12, iArr[0], 4, 4);
        int i13 = i9 << i8;
        int i14 = (((i4 << i11) * i13) + (i7 * i9)) + (i3 << i10);
        putSub(iArr2[1], i14, i13, iArr[1], i10, i11);
        putSub(iArr2[2], i14, i13, iArr[2], i10, i11);
    }

    private final void putSub(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        int i5 = 0;
        if (i3 == 3) {
            i3 = 0;
            while (i5 < (1 << i4)) {
                iArr[i] = clip(iArr2[i3]);
                iArr[i + 1] = clip(iArr2[i3 + 1]);
                iArr[i + 2] = clip(iArr2[i3 + 2]);
                iArr[i + 3] = clip(iArr2[i3 + 3]);
                iArr[i + 4] = clip(iArr2[i3 + 4]);
                iArr[i + 5] = clip(iArr2[i3 + 5]);
                iArr[i + 6] = clip(iArr2[i3 + 6]);
                iArr[i + 7] = clip(iArr2[i3 + 7]);
                i3 += 8;
                i += i2;
                i5++;
            }
            return;
        }
        i3 = 0;
        while (i5 < (1 << i4)) {
            iArr[i] = clip(iArr2[i3]);
            iArr[i + 1] = clip(iArr2[i3 + 1]);
            iArr[i + 2] = clip(iArr2[i3 + 2]);
            iArr[i + 3] = clip(iArr2[i3 + 3]);
            iArr[i + 4] = clip(iArr2[i3 + 4]);
            iArr[i + 5] = clip(iArr2[i3 + 5]);
            iArr[i + 6] = clip(iArr2[i3 + 6]);
            iArr[i + 7] = clip(iArr2[i3 + 7]);
            iArr[i + 8] = clip(iArr2[i3 + 8]);
            iArr[i + 9] = clip(iArr2[i3 + 9]);
            iArr[i + 10] = clip(iArr2[i3 + 10]);
            iArr[i + 11] = clip(iArr2[i3 + 11]);
            iArr[i + 12] = clip(iArr2[i3 + 12]);
            iArr[i + 13] = clip(iArr2[i3 + 13]);
            iArr[i + 14] = clip(iArr2[i3 + 14]);
            iArr[i + 15] = clip(iArr2[i3 + 15]);
            i3 += 16;
            i += i2;
            i5++;
        }
    }

    protected static final int quantInterSigned(int i, int i2) {
        return i >= 0 ? quantInter(i, i2) : -quantInter(-i, i2);
    }

    protected void blockIntra(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int[] iArr3, int i2, int i3, int i4, int[] iArr4) {
        i = MPEGConst.BLOCK_TO_CC[i];
        int readVLC = (i == 0 ? MPEGConst.vlcDCSizeLuma : MPEGConst.vlcDCSizeChroma).readVLC(bitReader);
        int i5 = 0;
        iArr2[i] = iArr2[i] + (readVLC != 0 ? mpegSigned(bitReader, readVLC) : 0);
        SparseIDCT.start(iArr, iArr2[i] * i3);
        while (i5 < 64) {
            iArr2 = vlc.readVLC(bitReader);
            if (iArr2 == MPEGConst.CODE_END) {
                break;
            }
            if (iArr2 == MPEGConst.CODE_ESCAPE) {
                i5 += bitReader.readNBit(6) + 1;
                iArr2 = (twosSigned(bitReader, i2) * i4) * iArr4[i5];
                iArr2 = iArr2 >= null ? iArr2 >> 4 : -((-iArr2) >> 4);
            } else {
                i5 += (iArr2 >> 6) + 1;
                iArr2 = toSigned((((iArr2 & 63) * i4) * iArr4[i5]) >> 4, bitReader.read1Bit());
            }
            SparseIDCT.coeff(iArr, iArr3[i5], iArr2);
        }
        SparseIDCT.finish(iArr);
    }

    protected void blockInter(BitReader bitReader, VLC vlc, int[] iArr, int[] iArr2, int i, int i2, int[] iArr3) {
        int i3 = 0;
        if (vlc == MPEGConst.vlcCoeff0 && bitReader.checkNBit(1) == 1) {
            bitReader.read1Bit();
            SparseIDCT.start(iArr, toSigned(quantInter(1, iArr3[0] * i2), bitReader.read1Bit()));
        } else {
            SparseIDCT.start(iArr, 0);
            i3 = -1;
        }
        while (i3 < 64) {
            int readVLC = vlc.readVLC(bitReader);
            if (readVLC == MPEGConst.CODE_END) {
                break;
            }
            if (readVLC == MPEGConst.CODE_ESCAPE) {
                i3 += bitReader.readNBit(6) + 1;
                readVLC = quantInterSigned(twosSigned(bitReader, i), iArr3[i3] * i2);
            } else {
                i3 += (readVLC >> 6) + 1;
                readVLC = toSigned(quantInter(readVLC & 63, iArr3[i3] * i2), bitReader.read1Bit());
            }
            SparseIDCT.coeff(iArr, iArr2[i3], readVLC);
        }
        SparseIDCT.finish(iArr);
    }

    public static final int twosSigned(BitReader bitReader, int i) {
        int i2 = 32 - i;
        return (bitReader.readNBit(i) << i2) >> i2;
    }

    public static final int mpegSigned(BitReader bitReader, int i) {
        bitReader = bitReader.readNBit(i);
        int i2 = (bitReader >>> (i - 1)) ^ 1;
        return (bitReader + i2) - (i2 << i);
    }

    private final int readCbPattern(BitReader bitReader) {
        int readVLC = MPEGConst.vlcCBP.readVLC(bitReader);
        if (this.sh.sequenceExtension != null) {
            if (this.sh.sequenceExtension.chroma_format != 1) {
                if (this.sh.sequenceExtension.chroma_format == 2) {
                    return bitReader.readNBit(2) | (readVLC << 2);
                } else if (this.sh.sequenceExtension.chroma_format == 3) {
                    return bitReader.readNBit(6) | (readVLC << 6);
                } else {
                    StringBuilder stringBuilder = new StringBuilder("Unsupported chroma format: ");
                    stringBuilder.append(this.sh.sequenceExtension.chroma_format);
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
        }
        return readVLC;
    }

    public int probe(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int i = 0;
        while (i < 2 && MPEGUtil.gotoNextMarker(byteBuffer) != null && byteBuffer.hasRemaining()) {
            int i2 = byteBuffer.getInt();
            if (i2 != 256) {
                if (i2 < 432 || i2 > 440) {
                    if (i2 > 256 && i2 < 432) {
                        return 20 - (i * 10);
                    }
                    i++;
                }
            }
            return 50 - (i * 10);
        }
        return 0;
    }

    public static Size getSize(ByteBuffer byteBuffer) {
        byteBuffer = getSequenceHeader(byteBuffer.duplicate());
        return new Size(byteBuffer.horizontal_size, byteBuffer.vertical_size);
    }

    private static SequenceHeader getSequenceHeader(ByteBuffer byteBuffer) {
        ByteBuffer nextSegment = MPEGUtil.nextSegment(byteBuffer);
        while (nextSegment != null) {
            if (nextSegment.getInt() == 435) {
                return SequenceHeader.read(nextSegment);
            }
            nextSegment = MPEGUtil.nextSegment(byteBuffer);
        }
        return null;
    }
}
