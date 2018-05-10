package org.jcodec.codecs.h264;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.h264.decode.SliceDecoder;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.decode.deblock.DeblockingFilter;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

public class H264Decoder implements VideoDecoder {
    private boolean debug;
    private IntObjectMap<Frame> lRefs;
    private List<Frame> pictureBuffer = new ArrayList();
    private POCManager poc = new POCManager();
    private IntObjectMap<PictureParameterSet> pps = new IntObjectMap();
    private Frame[] sRefs;
    private IntObjectMap<SeqParameterSet> sps = new IntObjectMap();

    class FrameDecoder {
        final /* synthetic */ H264Decoder f26787a;
        private SliceHeaderReader f26788b;
        private PictureParameterSet f26789c;
        private SeqParameterSet f26790d;
        private DeblockingFilter f26791e;
        private SliceHeader f26792f;
        private NALUnit f26793g;
        private SliceDecoder f26794h;
        private int[][][][] f26795i;

        FrameDecoder(H264Decoder h264Decoder) {
            this.f26787a = h264Decoder;
        }

        public final Frame m28377a(List<ByteBuffer> list, int[][] iArr) {
            FrameDecoder frameDecoder = this;
            Iterator it = list.iterator();
            Picture picture = null;
            while (it.hasNext()) {
                Iterator it2;
                ByteBuffer byteBuffer = (ByteBuffer) it.next();
                NALUnit read = NALUnit.read(byteBuffer);
                H264Utils.unescapeNAL(byteBuffer);
                switch (read.type) {
                    case NON_IDR_SLICE:
                    case IDR_SLICE:
                        if (picture == null) {
                            frameDecoder.f26793g = read;
                            frameDecoder.f26788b = new SliceHeaderReader();
                            BitReader bitReader = new BitReader(byteBuffer.duplicate());
                            frameDecoder.f26792f = frameDecoder.f26788b.readPart1(bitReader);
                            frameDecoder.f26789c = (PictureParameterSet) frameDecoder.f26787a.pps.get(frameDecoder.f26792f.pic_parameter_set_id);
                            frameDecoder.f26790d = (SeqParameterSet) frameDecoder.f26787a.sps.get(frameDecoder.f26789c.seq_parameter_set_id);
                            frameDecoder.f26788b.readPart2(frameDecoder.f26792f, read, frameDecoder.f26790d, frameDecoder.f26789c, bitReader);
                            int i = frameDecoder.f26790d.pic_width_in_mbs_minus1 + 1;
                            int picHeightInMbs = H264Utils.getPicHeightInMbs(frameDecoder.f26790d);
                            int i2 = picHeightInMbs << 2;
                            int i3 = i << 2;
                            int[][] iArr2 = (int[][]) Array.newInstance(int.class, new int[]{i2, i3});
                            frameDecoder.f26795i = (int[][][][]) Array.newInstance(int.class, new int[]{2, i2, i3, 3});
                            picHeightInMbs *= i;
                            MBType[] mBTypeArr = new MBType[picHeightInMbs];
                            boolean[] zArr = new boolean[picHeightInMbs];
                            int[][] iArr3 = (int[][]) Array.newInstance(int.class, new int[]{3, picHeightInMbs});
                            SliceHeader[] sliceHeaderArr = new SliceHeader[picHeightInMbs];
                            Picture[][][] pictureArr = new Frame[picHeightInMbs][][];
                            if (frameDecoder.f26787a.sRefs == null) {
                                frameDecoder.f26787a.sRefs = new Frame[(1 << (frameDecoder.f26792f.sps.log2_max_frame_num_minus4 + 4))];
                                frameDecoder.f26787a.lRefs = new IntObjectMap();
                            }
                            it2 = it;
                            Picture createFrame = H264Decoder.createFrame(frameDecoder.f26790d, iArr, frameDecoder.f26792f.frame_num, frameDecoder.f26795i, pictureArr, frameDecoder.f26787a.poc.calcPOC(frameDecoder.f26792f, frameDecoder.f26793g));
                            frameDecoder.f26794h = new SliceDecoder(frameDecoder.f26790d, frameDecoder.f26789c, iArr2, frameDecoder.f26795i, mBTypeArr, iArr3, sliceHeaderArr, zArr, pictureArr, createFrame, frameDecoder.f26787a.sRefs, frameDecoder.f26787a.lRefs);
                            frameDecoder.f26794h.setDebug(frameDecoder.f26787a.debug);
                            frameDecoder.f26791e = new DeblockingFilter(i, frameDecoder.f26790d.bit_depth_chroma_minus8 + 8, iArr2, frameDecoder.f26795i, mBTypeArr, iArr3, sliceHeaderArr, zArr, pictureArr);
                            picture = createFrame;
                        } else {
                            it2 = it;
                        }
                        frameDecoder.f26794h.decode(byteBuffer, read);
                        continue;
                    case SPS:
                        SeqParameterSet read2 = SeqParameterSet.read(byteBuffer);
                        frameDecoder.f26787a.sps.put(read2.seq_parameter_set_id, read2);
                        break;
                    case PPS:
                        PictureParameterSet read3 = PictureParameterSet.read(byteBuffer);
                        frameDecoder.f26787a.pps.put(read3.pic_parameter_set_id, read3);
                        break;
                    default:
                        break;
                }
                it2 = it;
                it = it2;
            }
            frameDecoder.f26791e.deblockFrame(picture);
            if (frameDecoder.f26793g.nal_ref_idc != 0) {
                int i4 = 0;
                Frame a;
                if (frameDecoder.f26793g.type == NALUnitType.IDR_SLICE) {
                    RefPicMarkingIDR refPicMarkingIDR = frameDecoder.f26792f.refPicMarkingIDR;
                    m28375a();
                    frameDecoder.f26787a.pictureBuffer.clear();
                    a = m28374a(picture);
                    if (refPicMarkingIDR.isUseForlongTerm()) {
                        frameDecoder.f26787a.lRefs.put(0, a);
                        a.setShortTerm(false);
                    } else {
                        frameDecoder.f26787a.sRefs[frameDecoder.f26792f.frame_num] = a;
                    }
                } else {
                    int wrap;
                    RefPicMarking refPicMarking = frameDecoder.f26792f.refPicMarkingNonIDR;
                    a = m28374a(picture);
                    if (refPicMarking != null) {
                        Frame frame = a;
                        for (Instruction instruction : refPicMarking.getInstructions()) {
                            switch (instruction.getType()) {
                                case REMOVE_SHORT:
                                    wrap = MathUtil.wrap(frameDecoder.f26792f.frame_num - instruction.getArg1(), 1 << (frameDecoder.f26792f.sps.log2_max_frame_num_minus4 + 4));
                                    m28376b(frameDecoder.f26787a.sRefs[wrap]);
                                    frameDecoder.f26787a.sRefs[wrap] = null;
                                    break;
                                case REMOVE_LONG:
                                    wrap = instruction.getArg1();
                                    m28376b((Frame) frameDecoder.f26787a.lRefs.get(wrap));
                                    frameDecoder.f26787a.lRefs.remove(wrap);
                                    break;
                                case CONVERT_INTO_LONG:
                                    int arg1 = instruction.getArg1();
                                    wrap = instruction.getArg2();
                                    arg1 = MathUtil.wrap(frameDecoder.f26792f.frame_num - arg1, 1 << (frameDecoder.f26792f.sps.log2_max_frame_num_minus4 + 4));
                                    m28376b((Frame) frameDecoder.f26787a.lRefs.get(wrap));
                                    frameDecoder.f26787a.lRefs.put(wrap, frameDecoder.f26787a.sRefs[arg1]);
                                    frameDecoder.f26787a.sRefs[arg1] = null;
                                    ((Frame) frameDecoder.f26787a.lRefs.get(wrap)).setShortTerm(false);
                                    break;
                                case TRUNK_LONG:
                                    wrap = instruction.getArg1() - 1;
                                    int[] keys = frameDecoder.f26787a.lRefs.keys();
                                    for (int i5 = 0; i5 < keys.length; i5++) {
                                        if (keys[i5] > wrap) {
                                            m28376b((Frame) frameDecoder.f26787a.lRefs.get(keys[i5]));
                                            frameDecoder.f26787a.lRefs.remove(keys[i5]);
                                        }
                                    }
                                    break;
                                case CLEAR:
                                    m28375a();
                                    break;
                                case MARK_LONG:
                                    wrap = instruction.getArg1();
                                    Frame frame2 = (Frame) frameDecoder.f26787a.lRefs.get(wrap);
                                    if (frame2 != null) {
                                        m28376b(frame2);
                                    }
                                    frame.setShortTerm(false);
                                    frameDecoder.f26787a.lRefs.put(wrap, frame);
                                    frame = null;
                                    break;
                                default:
                                    break;
                            }
                        }
                        a = frame;
                    }
                    if (a != null) {
                        frameDecoder.f26787a.sRefs[frameDecoder.f26792f.frame_num] = a;
                    }
                    int i6 = 1 << (frameDecoder.f26790d.log2_max_frame_num_minus4 + 4);
                    if (refPicMarking == null) {
                        int max = Math.max(1, frameDecoder.f26790d.num_ref_frames - frameDecoder.f26787a.lRefs.size());
                        i2 = 0;
                        i3 = Integer.MAX_VALUE;
                        int i7 = i2;
                        while (i4 < frameDecoder.f26787a.sRefs.length) {
                            if (frameDecoder.f26787a.sRefs[i4] != null) {
                                int i8 = frameDecoder.f26792f.frame_num;
                                wrap = frameDecoder.f26787a.sRefs[i4].getFrameNo();
                                if (wrap > i8) {
                                    wrap -= i6;
                                }
                                if (wrap < i3) {
                                    i2 = frameDecoder.f26787a.sRefs[i4].getFrameNo();
                                    i3 = wrap;
                                }
                                i7++;
                            }
                            i4++;
                        }
                        if (i7 > max) {
                            m28376b(frameDecoder.f26787a.sRefs[i2]);
                            frameDecoder.f26787a.sRefs[i2] = null;
                        }
                    }
                }
            }
            return picture;
        }

        private Frame m28374a(Frame frame) {
            Frame createFrame = this.f26787a.pictureBuffer.size() > 0 ? (Frame) this.f26787a.pictureBuffer.remove(0) : Frame.createFrame(frame);
            createFrame.copyFrom(frame);
            return createFrame;
        }

        private void m28376b(Frame frame) {
            if (frame != null) {
                this.f26787a.pictureBuffer.add(frame);
            }
        }

        private void m28375a() {
            int i = 0;
            for (int i2 = 0; i2 < this.f26787a.sRefs.length; i2++) {
                m28376b(this.f26787a.sRefs[i2]);
                this.f26787a.sRefs[i2] = null;
            }
            int[] keys = this.f26787a.lRefs.keys();
            while (i < keys.length) {
                m28376b((Frame) this.f26787a.lRefs.get(keys[i]));
                i++;
            }
            this.f26787a.lRefs.clear();
        }
    }

    public Frame decodeFrame(ByteBuffer byteBuffer, int[][] iArr) {
        return new FrameDecoder(this).m28377a(H264Utils.splitFrame(byteBuffer), iArr);
    }

    public Frame decodeFrame(List<ByteBuffer> list, int[][] iArr) {
        return new FrameDecoder(this).m28377a(list, iArr);
    }

    public static Frame createFrame(SeqParameterSet seqParameterSet, int[][] iArr, int i, int[][][][] iArr2, Frame[][][] frameArr, int i2) {
        Rect rect;
        SeqParameterSet seqParameterSet2 = seqParameterSet;
        int i3 = (seqParameterSet2.pic_width_in_mbs_minus1 + 1) << 4;
        int picHeightInMbs = H264Utils.getPicHeightInMbs(seqParameterSet2) << 4;
        if (seqParameterSet2.frame_cropping_flag) {
            int i4 = seqParameterSet2.frame_crop_left_offset << 1;
            int i5 = seqParameterSet2.frame_crop_top_offset << 1;
            rect = new Rect(i4, i5, (i3 - (seqParameterSet2.frame_crop_right_offset << 1)) - i4, (picHeightInMbs - (seqParameterSet2.frame_crop_bottom_offset << 1)) - i5);
        } else {
            rect = null;
        }
        return new Frame(i3, picHeightInMbs, iArr, ColorSpace.YUV420, rect, i, iArr2, frameArr, i2);
    }

    public void addSps(List<ByteBuffer> list) {
        for (ByteBuffer duplicate : list) {
            ByteBuffer duplicate2 = duplicate2.duplicate();
            H264Utils.unescapeNAL(duplicate2);
            SeqParameterSet read = SeqParameterSet.read(duplicate2);
            this.sps.put(read.seq_parameter_set_id, read);
        }
    }

    public void addPps(List<ByteBuffer> list) {
        for (ByteBuffer duplicate : list) {
            ByteBuffer duplicate2 = duplicate2.duplicate();
            H264Utils.unescapeNAL(duplicate2);
            PictureParameterSet read = PictureParameterSet.read(duplicate2);
            this.pps.put(read.pic_parameter_set_id, read);
        }
    }

    public int probe(ByteBuffer byteBuffer) {
        int i = 0;
        boolean z = false;
        boolean z2 = z;
        for (ByteBuffer byteBuffer2 : H264Utils.splitFrame(byteBuffer.duplicate())) {
            NALUnit read = NALUnit.read(byteBuffer2);
            if (read.type != NALUnitType.IDR_SLICE) {
                if (read.type != NALUnitType.NON_IDR_SLICE) {
                    if (read.type == NALUnitType.SPS) {
                        z = validSps(SeqParameterSet.read(byteBuffer2));
                    } else if (read.type == NALUnitType.PPS) {
                        z2 = validPps(PictureParameterSet.read(byteBuffer2));
                    }
                }
            }
            byteBuffer = validSh(new SliceHeaderReader().readPart1(new BitReader(byteBuffer2)));
        }
        byteBuffer = null;
        byteBuffer = (byteBuffer != null ? 60 : null) + (z ? 20 : 0);
        if (z2) {
            i = 20;
        }
        return byteBuffer + i;
    }

    private boolean validSh(SliceHeader sliceHeader) {
        return (sliceHeader.first_mb_in_slice != 0 || sliceHeader.slice_type == null || sliceHeader.pic_parameter_set_id >= 2) ? null : true;
    }

    private boolean validSps(SeqParameterSet seqParameterSet) {
        return (seqParameterSet.bit_depth_chroma_minus8 >= 4 || seqParameterSet.bit_depth_luma_minus8 >= 4 || seqParameterSet.chroma_format_idc == null || seqParameterSet.seq_parameter_set_id >= 2 || seqParameterSet.pic_order_cnt_type > 2) ? null : true;
    }

    private boolean validPps(PictureParameterSet pictureParameterSet) {
        return (pictureParameterSet.pic_init_qp_minus26 > 26 || pictureParameterSet.seq_parameter_set_id > 2 || pictureParameterSet.pic_parameter_set_id > 2) ? null : true;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }
}
