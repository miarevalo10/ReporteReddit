package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class FullBox extends Box {
    protected int flags;
    protected byte version;

    public FullBox(Header header) {
        super(header);
    }

    public void parse(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.getInt();
        this.version = (byte) ((byteBuffer >> 24) & 255);
        this.flags = byteBuffer & 16777215;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt((this.version << 24) | (this.flags & 16777215));
    }

    public byte getVersion() {
        return this.version;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setVersion(byte b) {
        this.version = b;
    }

    public void setFlags(int i) {
        this.flags = i;
    }
}
