package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class SoundMediaHeaderBox extends FullBox {
    private short balance;

    public static String fourcc() {
        return com.coremedia.iso.boxes.SoundMediaHeaderBox.TYPE;
    }

    public SoundMediaHeaderBox(Header header) {
        super(header);
    }

    public SoundMediaHeaderBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.balance = byteBuffer.getShort();
        byteBuffer.getShort();
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putShort(this.balance);
        byteBuffer.putShort((short) 0);
    }

    public short getBalance() {
        return this.balance;
    }
}
