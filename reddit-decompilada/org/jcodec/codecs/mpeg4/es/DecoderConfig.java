package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;

public class DecoderConfig extends NodeDescriptor {
    private int avgBitrate;
    private int bufSize;
    private int maxBitrate;
    private int objectType;

    public static int tag() {
        return 4;
    }

    public DecoderConfig(int i, int i2) {
        super(i, i2);
    }

    public DecoderConfig(int i, int i2, int i3, int i4, Descriptor... descriptorArr) {
        super(tag(), descriptorArr);
        this.objectType = i;
        this.bufSize = i2;
        this.maxBitrate = i3;
        this.avgBitrate = i4;
    }

    protected void parse(ByteBuffer byteBuffer) {
        this.objectType = byteBuffer.get() & 255;
        byteBuffer.get();
        this.bufSize = ((byteBuffer.get() & 255) << 16) | (byteBuffer.getShort() & 65535);
        this.maxBitrate = byteBuffer.getInt();
        this.avgBitrate = byteBuffer.getInt();
        super.parse(byteBuffer);
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) this.objectType);
        byteBuffer.put((byte) 21);
        byteBuffer.put((byte) (this.bufSize >> 16));
        byteBuffer.putShort((short) this.bufSize);
        byteBuffer.putInt(this.maxBitrate);
        byteBuffer.putInt(this.avgBitrate);
        super.doWrite(byteBuffer);
    }

    public int getObjectType() {
        return this.objectType;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getAvgBitrate() {
        return this.avgBitrate;
    }
}
