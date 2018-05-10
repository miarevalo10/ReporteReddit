package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;

public class ES extends NodeDescriptor {
    private int trackId;

    public static int tag() {
        return 3;
    }

    public ES(int i, int i2) {
        super(i, i2);
    }

    public ES(int i, Descriptor... descriptorArr) {
        super(tag(), descriptorArr);
        this.trackId = i;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) this.trackId);
        byteBuffer.put((byte) 0);
        super.doWrite(byteBuffer);
    }

    protected void parse(ByteBuffer byteBuffer) {
        this.trackId = byteBuffer.getShort();
        byteBuffer.get();
        super.parse(byteBuffer);
    }

    public int getTrackId() {
        return this.trackId;
    }
}
