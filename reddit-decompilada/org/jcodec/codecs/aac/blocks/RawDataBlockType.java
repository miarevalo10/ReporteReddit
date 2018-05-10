package org.jcodec.codecs.aac.blocks;

import java.util.EnumSet;
import java.util.Iterator;

public enum RawDataBlockType {
    TYPE_SCE,
    TYPE_CPE,
    TYPE_CCE,
    TYPE_LFE,
    TYPE_DSE,
    TYPE_PCE,
    TYPE_FIL,
    TYPE_END;

    public static RawDataBlockType fromOrdinal(int i) {
        Iterator it = EnumSet.allOf(RawDataBlockType.class).iterator();
        while (it.hasNext()) {
            RawDataBlockType rawDataBlockType = (RawDataBlockType) it.next();
            if (rawDataBlockType.ordinal() == i) {
                return rawDataBlockType;
            }
        }
        return 0;
    }
}
