package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;

public class NALUnit {
    public int nal_ref_idc;
    public NALUnitType type;

    public NALUnit(NALUnitType nALUnitType, int i) {
        this.type = nALUnitType;
        this.nal_ref_idc = i;
    }

    public static NALUnit read(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.get() & 255;
        return new NALUnit(NALUnitType.fromValue(byteBuffer & 31), (byteBuffer >> 5) & 3);
    }

    public void write(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) (this.type.getValue() | (this.nal_ref_idc << 5)));
    }
}
