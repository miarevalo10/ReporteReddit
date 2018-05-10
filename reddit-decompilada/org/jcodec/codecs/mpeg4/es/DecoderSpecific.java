package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;
import org.jcodec.common.NIOUtils;

public class DecoderSpecific extends Descriptor {
    private ByteBuffer data;

    public static int tag() {
        return 5;
    }

    public DecoderSpecific(int i, int i2) {
        super(i, i2);
    }

    public DecoderSpecific(ByteBuffer byteBuffer) {
        super(tag());
        this.data = byteBuffer;
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        NIOUtils.write(byteBuffer, this.data);
    }

    public ByteBuffer getData() {
        return this.data;
    }

    protected void parse(ByteBuffer byteBuffer) {
        this.data = NIOUtils.read(byteBuffer);
    }
}
