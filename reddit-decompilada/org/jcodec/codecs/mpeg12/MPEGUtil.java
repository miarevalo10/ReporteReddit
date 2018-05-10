package org.jcodec.codecs.mpeg12;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MPEGUtil {
    public static final ByteBuffer gotoNextMarker(ByteBuffer byteBuffer) {
        return gotoMarker(byteBuffer, 0, 256, 511);
    }

    public static final ByteBuffer gotoMarker(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int position = byteBuffer.position();
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.BIG_ENDIAN);
        int i4 = -1;
        while (byteBuffer.hasRemaining()) {
            i4 = (i4 << 8) | (byteBuffer.get() & 255);
            if (i4 >= i2 && i4 <= i3) {
                if (i == 0) {
                    byteBuffer.position(byteBuffer.position() - 4);
                    slice.limit(byteBuffer.position() - position);
                    break;
                }
                i--;
            }
        }
        return slice;
    }

    public static final ByteBuffer nextSegment(ByteBuffer byteBuffer) {
        gotoMarker(byteBuffer, 0, 256, 511);
        return gotoMarker(byteBuffer, 1, 256, 511);
    }
}
