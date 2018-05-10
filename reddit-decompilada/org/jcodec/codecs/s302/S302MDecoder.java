package org.jcodec.codecs.s302;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.AudioDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.model.AudioBuffer;
import org.jcodec.common.tools.MathUtil;

public class S302MDecoder implements AudioDecoder {
    public static int SAMPLE_RATE = 48000;

    public AudioBuffer decodeFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        ByteBuffer duplicate = byteBuffer2.duplicate();
        int i = byteBuffer.getInt();
        if (byteBuffer.remaining() != ((i >> 16) & 65535)) {
            throw new IllegalArgumentException("Wrong s302m frame");
        }
        int i2 = (((i >> 14) & 3) * 2) + 2;
        i = (((i >> 4) & 3) * 4) + 16;
        byte reverse;
        int reverse2;
        int reverse3;
        if (i == 24) {
            byteBuffer2 = (byteBuffer.remaining() / 7) * 2;
            while (byteBuffer.remaining() > 6) {
                byte reverse4 = (byte) MathUtil.reverse(byteBuffer.get() & 255);
                reverse = (byte) MathUtil.reverse(byteBuffer.get() & 255);
                byte reverse5 = (byte) MathUtil.reverse(byteBuffer.get() & 255);
                reverse2 = MathUtil.reverse(byteBuffer.get() & 15);
                reverse3 = MathUtil.reverse(byteBuffer.get() & 255);
                int reverse6 = MathUtil.reverse(byteBuffer.get() & 255);
                int reverse7 = MathUtil.reverse(byteBuffer.get() & 240);
                duplicate.put(reverse5);
                duplicate.put(reverse);
                duplicate.put(reverse4);
                duplicate.put((byte) ((reverse7 << 4) | (reverse6 >> 4)));
                duplicate.put((byte) ((reverse6 << 4) | (reverse3 >> 4)));
                duplicate.put((byte) ((reverse3 << 4) | (reverse2 >> 4)));
            }
            duplicate.flip();
            return new AudioBuffer(duplicate, new AudioFormat(SAMPLE_RATE, 24, i2, true, true), byteBuffer2 / i2);
        } else if (i == 20) {
            byteBuffer2 = (byteBuffer.remaining() / 6) * 2;
            while (byteBuffer.remaining() > 5) {
                i = MathUtil.reverse(byteBuffer.get() & 255);
                int reverse8 = MathUtil.reverse(byteBuffer.get() & 255);
                duplicate.put((byte) ((MathUtil.reverse(byteBuffer.get() & 240) << 4) | (reverse8 >> 4)));
                duplicate.put((byte) ((reverse8 << 4) | (i >> 4)));
                duplicate.put((byte) (i << 4));
                i = MathUtil.reverse(byteBuffer.get() & 255);
                reverse8 = MathUtil.reverse(byteBuffer.get() & 255);
                duplicate.put((byte) ((MathUtil.reverse(byteBuffer.get() & 240) << 4) | (reverse8 >> 4)));
                duplicate.put((byte) ((reverse8 << 4) | (i >> 4)));
                duplicate.put((byte) (i << 4));
            }
            duplicate.flip();
            return new AudioBuffer(duplicate, new AudioFormat(SAMPLE_RATE, 24, i2, true, true), byteBuffer2 / i2);
        } else {
            i = (byteBuffer.remaining() / 5) * 2;
            while (byteBuffer.remaining() > 4) {
                reverse = (byte) MathUtil.reverse(byteBuffer.get() & 255);
                byte reverse9 = (byte) MathUtil.reverse(byteBuffer.get() & 255);
                int reverse10 = MathUtil.reverse(byteBuffer.get() & 255);
                reverse2 = MathUtil.reverse(byteBuffer.get() & 255);
                reverse3 = MathUtil.reverse(byteBuffer.get() & 240);
                byteBuffer2.put(reverse9);
                byteBuffer2.put(reverse);
                byteBuffer2.put((byte) ((reverse3 << 4) | (reverse2 >> 4)));
                byteBuffer2.put((byte) ((reverse2 << 4) | (reverse10 >> 4)));
            }
            duplicate.flip();
            return new AudioBuffer(duplicate, new AudioFormat(SAMPLE_RATE, 16, i2, true, true), i / i2);
        }
    }
}
