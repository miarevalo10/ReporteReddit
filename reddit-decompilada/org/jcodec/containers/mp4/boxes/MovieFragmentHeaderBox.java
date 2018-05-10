package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class MovieFragmentHeaderBox extends FullBox {
    private int sequenceNumber;

    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox.TYPE;
    }

    public MovieFragmentHeaderBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.sequenceNumber = byteBuffer.getInt();
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.sequenceNumber);
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(int i) {
        this.sequenceNumber = i;
    }
}
