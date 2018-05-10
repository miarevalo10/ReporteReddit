package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;

public class EbmlFloat extends EbmlBin {
    public EbmlFloat(byte[] bArr) {
        super(bArr);
    }

    public void set(double d) {
        if (d < 3.4028234663852886E38d) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putFloat((float) d);
            allocate.flip();
            this.data = allocate;
            return;
        }
        if (d < Double.MAX_VALUE) {
            allocate = ByteBuffer.allocate(8);
            allocate.putDouble(d);
            allocate.flip();
            this.data = allocate;
        }
    }

    public double get() {
        if (this.data.limit() == 4) {
            return (double) this.data.duplicate().getFloat();
        }
        return this.data.duplicate().getDouble();
    }
}
