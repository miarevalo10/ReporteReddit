package org.jcodec.filters.color;

import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jcodec.common.model.Picture;

public class CVTColorFilter {
    private static byte blue(int i, int i2) {
        i = (((1192 * i2) + (2064 * i)) + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10;
        if (i < 0) {
            i = 0;
        } else if (i > 1023) {
            i = 1023;
        }
        return (byte) ((i >> 2) & 255);
    }

    private static byte green(int i, int i2, int i3) {
        i = ((((1192 * i3) - (400 * i)) - (832 * i2)) + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10;
        if (i < 0) {
            i = 0;
        } else if (i > 1023) {
            i = 1023;
        }
        return (byte) ((i >> 2) & 255);
    }

    private static byte red(int i, int i2) {
        i = (((1192 * i2) + (1636 * i)) + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10;
        if (i < 0) {
            i = 0;
        } else if (i > 1023) {
            i = 1023;
        }
        return (byte) ((i >> 2) & 255);
    }

    public void yuv42210BitTObgr24(Picture picture, ByteBuffer byteBuffer) {
        IntBuffer wrap = IntBuffer.wrap(picture.getPlaneData(0));
        IntBuffer wrap2 = IntBuffer.wrap(picture.getPlaneData(1));
        picture = IntBuffer.wrap(picture.getPlaneData(2));
        while (wrap.hasRemaining()) {
            int i = wrap.get() - 64;
            int i2 = wrap.get() - 64;
            int i3 = wrap2.get() - 512;
            int i4 = picture.get() - 512;
            byteBuffer.put(blue(i3, i));
            byteBuffer.put(green(i3, i4, i));
            byteBuffer.put(red(i4, i));
            byteBuffer.put(blue(i3, i2));
            byteBuffer.put(green(i3, i4, i2));
            byteBuffer.put(red(i4, i2));
        }
    }
}
