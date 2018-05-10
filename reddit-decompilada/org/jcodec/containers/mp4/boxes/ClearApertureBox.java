package org.jcodec.containers.mp4.boxes;

import com.googlecode.mp4parser.boxes.apple.CleanApertureAtom;
import java.nio.ByteBuffer;

public class ClearApertureBox extends FullBox {
    private float height;
    private float width;

    public static String fourcc() {
        return CleanApertureAtom.TYPE;
    }

    public ClearApertureBox(Header header) {
        super(header);
    }

    public ClearApertureBox() {
        super(new Header(fourcc()));
    }

    public ClearApertureBox(int i, int i2) {
        this();
        this.width = (float) i;
        this.height = (float) i2;
    }

    public ClearApertureBox(Header header, int i, int i2) {
        super(header);
        this.width = (float) i;
        this.height = (float) i2;
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.width = ((float) byteBuffer.getInt()) / 65536.0f;
        this.height = ((float) byteBuffer.getInt()) / 1199570944;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt((int) (this.width * 65536.0f));
        byteBuffer.putInt((int) (this.height * 65536.0f));
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}
