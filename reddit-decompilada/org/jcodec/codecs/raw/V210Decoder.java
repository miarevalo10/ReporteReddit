package org.jcodec.codecs.raw;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;

public class V210Decoder {
    private int height;
    private int width;

    public V210Decoder(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public Picture decode(byte[] bArr) {
        bArr = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        IntBuffer wrap = IntBuffer.wrap(new int[(this.width * this.height)]);
        IntBuffer wrap2 = IntBuffer.wrap(new int[((this.width * this.height) / 2)]);
        IntBuffer wrap3 = IntBuffer.wrap(new int[((this.width * this.height) / 2)]);
        while (bArr.hasRemaining()) {
            int i = bArr.get();
            wrap3.put(i >> 20);
            wrap.put((i >> 10) & 1023);
            wrap2.put(i & 1023);
            i = bArr.get();
            wrap.put(i & 1023);
            wrap.put(i >> 20);
            wrap2.put((i >> 10) & 1023);
            i = bArr.get();
            wrap2.put(i >> 20);
            wrap.put((i >> 10) & 1023);
            wrap3.put(i & 1023);
            i = bArr.get();
            wrap.put(i & 1023);
            wrap.put(i >> 20);
            wrap3.put((i >> 10) & 1023);
        }
        return new Picture(this.width, this.height, new int[][]{wrap.array(), wrap2.array(), wrap3.array()}, ColorSpace.YUV422_10);
    }
}
