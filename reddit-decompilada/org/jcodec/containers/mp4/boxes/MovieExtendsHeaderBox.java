package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class MovieExtendsHeaderBox extends FullBox {
    private int fragmentDuration;

    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox.TYPE;
    }

    public MovieExtendsHeaderBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.fragmentDuration = byteBuffer.getInt();
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.fragmentDuration);
    }

    public int getFragmentDuration() {
        return this.fragmentDuration;
    }

    public void setFragmentDuration(int i) {
        this.fragmentDuration = i;
    }
}
