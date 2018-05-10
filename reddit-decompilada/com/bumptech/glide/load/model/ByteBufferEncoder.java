package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.nio.ByteBuffer;

public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    public final /* bridge */ /* synthetic */ boolean mo969a(Object obj, File file, Options options) {
        return m11453a((ByteBuffer) obj, file);
    }

    private static boolean m11453a(ByteBuffer byteBuffer, File file) {
        try {
            ByteBufferUtil.m3205a(byteBuffer, file);
            return true;
        } catch (ByteBuffer byteBuffer2) {
            if (Log.isLoggable("ByteBufferEncoder", 3) != null) {
                Log.d("ByteBufferEncoder", "Failed to write data", byteBuffer2);
            }
            return null;
        }
    }
}
