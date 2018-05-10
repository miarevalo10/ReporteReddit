package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ClipRegionBox extends Box {
    private short height;
    private short rgnSize;
    private short width;
    private short f33282x;
    private short f33283y;

    public static String fourcc() {
        return "crgn";
    }

    public ClipRegionBox(Header header) {
        super(header);
    }

    public ClipRegionBox() {
        super(new Header(fourcc()));
    }

    public ClipRegionBox(short s, short s2, short s3, short s4) {
        this();
        this.rgnSize = (short) 10;
        this.f33282x = s;
        this.f33283y = s2;
        this.width = s3;
        this.height = s4;
    }

    public void parse(ByteBuffer byteBuffer) {
        this.rgnSize = byteBuffer.getShort();
        this.f33283y = byteBuffer.getShort();
        this.f33282x = byteBuffer.getShort();
        this.height = byteBuffer.getShort();
        this.width = byteBuffer.getShort();
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.rgnSize);
        byteBuffer.putShort(this.f33283y);
        byteBuffer.putShort(this.f33282x);
        byteBuffer.putShort(this.height);
        byteBuffer.putShort(this.width);
    }

    public short getRgnSize() {
        return this.rgnSize;
    }

    public short getY() {
        return this.f33283y;
    }

    public short getX() {
        return this.f33282x;
    }

    public short getHeight() {
        return this.height;
    }

    public short getWidth() {
        return this.width;
    }
}
