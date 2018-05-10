package org.jcodec.codecs.mpeg4.es;

import java.nio.ByteBuffer;
import org.jcodec.common.Assert;

public class SL extends Descriptor {
    public static int tag() {
        return 6;
    }

    public SL(int i, int i2) {
        super(i, i2);
    }

    public SL() {
        super(tag());
    }

    protected void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 2);
    }

    protected void parse(ByteBuffer byteBuffer) {
        Assert.assertEquals(2, byteBuffer.get() & 255);
    }
}
