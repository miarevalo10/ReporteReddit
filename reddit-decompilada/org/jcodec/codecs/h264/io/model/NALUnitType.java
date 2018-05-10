package org.jcodec.codecs.h264.io.model;

import java.util.EnumSet;
import java.util.Iterator;

public enum NALUnitType {
    NON_IDR_SLICE(1, "non IDR slice"),
    SLICE_PART_A(2, "slice part a"),
    SLICE_PART_B(3, "slice part b"),
    SLICE_PART_C(4, "slice part c"),
    IDR_SLICE(5, "idr slice"),
    SEI(6, "sei"),
    SPS(7, "sequence parameter set"),
    PPS(8, "picture parameter set"),
    ACC_UNIT_DELIM(9, "access unit delimiter"),
    END_OF_SEQ(10, "end of sequence"),
    END_OF_STREAM(11, "end of stream"),
    FILLER_DATA(12, "filter data"),
    SEQ_PAR_SET_EXT(13, "sequence parameter set extension"),
    AUX_SLICE(19, "auxilary slice");
    
    private static final NALUnitType[] lut = null;
    private final String name;
    private final int value;

    static {
        lut = new NALUnitType[256];
        Iterator it = EnumSet.allOf(NALUnitType.class).iterator();
        while (it.hasNext()) {
            NALUnitType nALUnitType = (NALUnitType) it.next();
            lut[nALUnitType.value] = nALUnitType;
        }
    }

    private NALUnitType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final int getValue() {
        return this.value;
    }

    public static NALUnitType fromValue(int i) {
        return i < lut.length ? lut[i] : 0;
    }
}
