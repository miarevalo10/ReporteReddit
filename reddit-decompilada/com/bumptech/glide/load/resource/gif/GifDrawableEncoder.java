package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;

public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    public final /* bridge */ /* synthetic */ boolean mo969a(Object obj, File file, Options options) {
        return m17028a((Resource) obj, file);
    }

    public final EncodeStrategy mo3265a(Options options) {
        return EncodeStrategy.SOURCE;
    }

    private static boolean m17028a(Resource<GifDrawable> resource, File file) {
        try {
            ByteBufferUtil.m3205a(((GifDrawable) resource.mo926b()).m11675b(), file);
            return true;
        } catch (Resource<GifDrawable> resource2) {
            if (Log.isLoggable("GifEncoder", 5) != null) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", resource2);
            }
            return null;
        }
    }
}
