package org.jcodec.codecs.h264;

import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType;
import org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.Packet;

public class MappedH264ES implements DemuxerTrack {
    private ByteBuffer bb;
    private int frameNo;
    private IntObjectMap<PictureParameterSet> pps = new IntObjectMap();
    private int prevFrameNum;
    private int prevFrameNumOffset;
    private int prevPicOrderCntLsb;
    private int prevPicOrderCntMsb;
    private SliceHeaderReader shr;
    private IntObjectMap<SeqParameterSet> sps = new IntObjectMap();

    public MappedH264ES(ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        this.shr = new SliceHeaderReader();
        this.frameNo = null;
    }

    public Packet nextFrame() {
        ByteBuffer duplicate = this.bb.duplicate();
        NALUnit nALUnit = null;
        SliceHeader sliceHeader = nALUnit;
        while (true) {
            this.bb.mark();
            ByteBuffer nextNALUnit = H264Utils.nextNALUnit(this.bb);
            if (nextNALUnit == null) {
                break;
            }
            NALUnit read = NALUnit.read(nextNALUnit);
            if (read.type != NALUnitType.IDR_SLICE) {
                if (read.type != NALUnitType.NON_IDR_SLICE) {
                    if (read.type == NALUnitType.PPS) {
                        PictureParameterSet read2 = PictureParameterSet.read(nextNALUnit);
                        this.pps.put(read2.pic_parameter_set_id, read2);
                    } else if (read.type == NALUnitType.SPS) {
                        SeqParameterSet read3 = SeqParameterSet.read(nextNALUnit);
                        this.sps.put(read3.seq_parameter_set_id, read3);
                    }
                }
            }
            SliceHeader readSliceHeader = readSliceHeader(nextNALUnit, read);
            if (nALUnit != null && sliceHeader != null && !sameFrame(nALUnit, read, sliceHeader, readSliceHeader)) {
                break;
            }
            sliceHeader = readSliceHeader;
            nALUnit = read;
        }
        this.bb.reset();
        duplicate.limit(this.bb.position());
        if (sliceHeader == null) {
            return null;
        }
        return detectPoc(duplicate, nALUnit, sliceHeader);
    }

    private SliceHeader readSliceHeader(ByteBuffer byteBuffer, NALUnit nALUnit) {
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = this.shr.readPart1(bitReader);
        PictureParameterSet pictureParameterSet = (PictureParameterSet) this.pps.get(byteBuffer.pic_parameter_set_id);
        this.shr.readPart2(byteBuffer, nALUnit, (SeqParameterSet) this.sps.get(pictureParameterSet.seq_parameter_set_id), pictureParameterSet, bitReader);
        return byteBuffer;
    }

    private boolean sameFrame(NALUnit nALUnit, NALUnit nALUnit2, SliceHeader sliceHeader, SliceHeader sliceHeader2) {
        if (sliceHeader.pic_parameter_set_id != sliceHeader2.pic_parameter_set_id || sliceHeader.frame_num != sliceHeader2.frame_num) {
            return false;
        }
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        if (seqParameterSet.pic_order_cnt_type == 0 && sliceHeader.pic_order_cnt_lsb != sliceHeader2.pic_order_cnt_lsb) {
            return false;
        }
        if (seqParameterSet.pic_order_cnt_type == 1 && (sliceHeader.delta_pic_order_cnt[0] != sliceHeader2.delta_pic_order_cnt[0] || sliceHeader.delta_pic_order_cnt[1] != sliceHeader2.delta_pic_order_cnt[1])) {
            return false;
        }
        if ((nALUnit.nal_ref_idc == 0 || nALUnit2.nal_ref_idc == 0) && nALUnit.nal_ref_idc != nALUnit2.nal_ref_idc) {
            return false;
        }
        if ((nALUnit.type == NALUnitType.IDR_SLICE ? 1 : null) == (nALUnit2.type == NALUnitType.IDR_SLICE ? 1 : null) && sliceHeader.idr_pic_id == sliceHeader2.idr_pic_id) {
            return true;
        }
        return false;
    }

    private Packet detectPoc(ByteBuffer byteBuffer, NALUnit nALUnit, SliceHeader sliceHeader) {
        NALUnit nALUnit2 = nALUnit;
        SliceHeader sliceHeader2 = sliceHeader;
        int i = 1 << (sliceHeader2.sps.log2_max_frame_num_minus4 + 4);
        if (detectGap(sliceHeader2, i)) {
            issueNonExistingPic(sliceHeader2, i);
        }
        i = updateFrameNumber(sliceHeader2.frame_num, i, detectMMCO5(sliceHeader2.refPicMarkingNonIDR));
        int calcPoc = nALUnit2.type == NALUnitType.NON_IDR_SLICE ? calcPoc(i, nALUnit2, sliceHeader2) : 0;
        long j = (long) i;
        i = r0.frameNo;
        r0.frameNo = i + 1;
        return new Packet(byteBuffer, j, 1, 1, (long) i, nALUnit2.type == NALUnitType.IDR_SLICE, null, calcPoc);
    }

    private int updateFrameNumber(int i, int i2, boolean z) {
        int i3;
        if (this.prevFrameNum > i) {
            i3 = this.prevFrameNumOffset + i2;
        } else {
            i3 = this.prevFrameNumOffset;
        }
        i2 = i3 + i;
        if (z) {
            i = 0;
        }
        this.prevFrameNum = i;
        this.prevFrameNumOffset = i3;
        return i2;
    }

    private void issueNonExistingPic(SliceHeader sliceHeader, int i) {
        this.prevFrameNum = (this.prevFrameNum + 1) % i;
    }

    private boolean detectGap(SliceHeader sliceHeader, int i) {
        return (sliceHeader.frame_num == this.prevFrameNum || sliceHeader.frame_num == (this.prevFrameNum + 1) % i) ? null : true;
    }

    private int calcPoc(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        if (sliceHeader.sps.pic_order_cnt_type == 0) {
            return calcPOC0(nALUnit, sliceHeader);
        }
        if (sliceHeader.sps.pic_order_cnt_type == 1) {
            return calcPOC1(i, nALUnit, sliceHeader);
        }
        return calcPOC2(i, nALUnit, sliceHeader);
    }

    private int calcPOC2(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        return nALUnit.nal_ref_idc == null ? (2 * i) - 1 : 2 * i;
    }

    private int calcPOC1(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        if (sliceHeader.sps.num_ref_frames_in_pic_order_cnt_cycle == 0) {
            i = 0;
        }
        if (nALUnit.nal_ref_idc == 0 && i > 0) {
            i--;
        }
        int i2 = 0;
        int i3 = i2;
        while (i2 < sliceHeader.sps.num_ref_frames_in_pic_order_cnt_cycle) {
            i3 += sliceHeader.sps.offsetForRefFrame[i2];
            i2++;
        }
        if (i > 0) {
            i--;
            i2 = i / sliceHeader.sps.num_ref_frames_in_pic_order_cnt_cycle;
            i3 = i2 * i3;
            for (i2 = 0; i2 <= i % sliceHeader.sps.num_ref_frames_in_pic_order_cnt_cycle; i2++) {
                i3 += sliceHeader.sps.offsetForRefFrame[i2];
            }
        } else {
            i3 = 0;
        }
        if (nALUnit.nal_ref_idc == 0) {
            i3 += sliceHeader.sps.offset_for_non_ref_pic;
        }
        return i3 + sliceHeader.delta_pic_order_cnt[0];
    }

    private int calcPOC0(NALUnit nALUnit, SliceHeader sliceHeader) {
        int i;
        int i2 = sliceHeader.pic_order_cnt_lsb;
        sliceHeader = 1 << (sliceHeader.sps.log2_max_pic_order_cnt_lsb_minus4 + 4);
        if (i2 < this.prevPicOrderCntLsb && this.prevPicOrderCntLsb - i2 >= sliceHeader / 2) {
            i = this.prevPicOrderCntMsb + sliceHeader;
        } else if (i2 <= this.prevPicOrderCntLsb || i2 - this.prevPicOrderCntLsb <= sliceHeader / 2) {
            i = this.prevPicOrderCntMsb;
        } else {
            i = this.prevPicOrderCntMsb - sliceHeader;
        }
        if (nALUnit.nal_ref_idc != null) {
            this.prevPicOrderCntMsb = i;
            this.prevPicOrderCntLsb = i2;
        }
        return i + i2;
    }

    private boolean detectMMCO5(RefPicMarking refPicMarking) {
        if (refPicMarking == null) {
            return false;
        }
        for (Instruction type : refPicMarking.getInstructions()) {
            if (type.getType() == InstrType.CLEAR) {
                return true;
            }
        }
        return false;
    }

    public SeqParameterSet[] getSps() {
        return (SeqParameterSet[]) this.sps.values(new SeqParameterSet[0]);
    }

    public PictureParameterSet[] getPps() {
        return (PictureParameterSet[]) this.pps.values(new PictureParameterSet[0]);
    }

    public DemuxerTrackMeta getMeta() {
        throw new UnsupportedOperationException();
    }
}
