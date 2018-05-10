package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class GamaExtension extends Box {
    private float gamma;

    public static String fourcc() {
        return "gama";
    }

    public GamaExtension(float f) {
        super(new Header(fourcc(), 0));
        this.gamma = f;
    }

    public GamaExtension(Header header) {
        super(header);
    }

    public GamaExtension(Box box) {
        super(box);
    }

    public void parse(ByteBuffer byteBuffer) {
        this.gamma = ((float) byteBuffer.getInt()) / 65536.0f;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt((int) (this.gamma * 65536.0f));
    }

    public float getGamma() {
        return this.gamma;
    }
}
