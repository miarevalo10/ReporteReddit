package org.jcodec.codecs.h264.io.model;

public enum SliceType {
    P,
    B,
    I,
    SP,
    SI;

    public final boolean isIntra() {
        if (this != I) {
            if (this != SI) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInter() {
        return (this == I || this == SI) ? false : true;
    }

    public static SliceType fromValue(int i) {
        for (SliceType sliceType : values()) {
            if (sliceType.ordinal() == i) {
                return sliceType;
            }
        }
        return 0;
    }
}
