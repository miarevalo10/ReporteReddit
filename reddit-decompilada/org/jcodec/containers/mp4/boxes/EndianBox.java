package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class EndianBox extends Box {
    private Endian endian;

    public enum Endian {
        LITTLE_ENDIAN,
        BIG_ENDIAN
    }

    public static String fourcc() {
        return "enda";
    }

    protected int calcSize() {
        return 2;
    }

    public EndianBox(Box box) {
        super(box);
    }

    public EndianBox(Header header) {
        super(header);
    }

    public EndianBox(Endian endian) {
        super(new Header(fourcc()));
        this.endian = endian;
    }

    public void parse(ByteBuffer byteBuffer) {
        if (((long) byteBuffer.getShort()) == 1) {
            this.endian = Endian.LITTLE_ENDIAN;
        } else {
            this.endian = Endian.BIG_ENDIAN;
        }
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) (this.endian == Endian.LITTLE_ENDIAN ? 1 : 0));
    }

    public Endian getEndian() {
        return this.endian;
    }
}
