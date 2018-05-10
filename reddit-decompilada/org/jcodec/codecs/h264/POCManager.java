package org.jcodec.codecs.h264;

import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType;
import org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction;
import org.jcodec.codecs.h264.io.model.SliceHeader;

public class POCManager {
    private int prevPOCLsb;
    private int prevPOCMsb;

    public int calcPOC(SliceHeader sliceHeader, NALUnit nALUnit) {
        switch (sliceHeader.sps.pic_order_cnt_type) {
            case 0:
                return calcPOC0(sliceHeader, nALUnit);
            case 1:
                return calcPOC1(sliceHeader, nALUnit);
            case 2:
                return calcPOC2(sliceHeader, nALUnit);
            default:
                throw new RuntimeException("POC no!!!");
        }
    }

    private int calcPOC2(SliceHeader sliceHeader, NALUnit nALUnit) {
        return sliceHeader.frame_num << 1;
    }

    private int calcPOC1(SliceHeader sliceHeader, NALUnit nALUnit) {
        return sliceHeader.frame_num << 1;
    }

    private int calcPOC0(SliceHeader sliceHeader, NALUnit nALUnit) {
        if (nALUnit.type == NALUnitType.IDR_SLICE) {
            this.prevPOCLsb = 0;
            this.prevPOCMsb = 0;
        }
        int i = 1 << (sliceHeader.sps.log2_max_pic_order_cnt_lsb_minus4 + 3);
        int i2 = i << 1;
        int i3 = sliceHeader.pic_order_cnt_lsb;
        if (i3 < this.prevPOCLsb && this.prevPOCLsb - i3 >= i) {
            i = this.prevPOCMsb + i2;
        } else if (i3 <= this.prevPOCLsb || i3 - this.prevPOCLsb <= i) {
            i = this.prevPOCMsb;
        } else {
            i = this.prevPOCMsb - i2;
        }
        i2 = i + i3;
        if (nALUnit.nal_ref_idc > 0) {
            if (hasMMCO5(sliceHeader, nALUnit) != null) {
                this.prevPOCMsb = 0;
                this.prevPOCLsb = i2;
            } else {
                this.prevPOCMsb = i;
                this.prevPOCLsb = i3;
            }
        }
        return i2;
    }

    private boolean hasMMCO5(SliceHeader sliceHeader, NALUnit nALUnit) {
        if (!(nALUnit.type == NALUnitType.IDR_SLICE || sliceHeader.refPicMarkingNonIDR == null)) {
            for (Instruction type : sliceHeader.refPicMarkingNonIDR.getInstructions()) {
                if (type.getType() == InstrType.CLEAR) {
                    return true;
                }
            }
        }
        return false;
    }
}
