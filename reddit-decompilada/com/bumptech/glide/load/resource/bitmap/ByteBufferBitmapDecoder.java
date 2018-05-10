package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final Downsampler f12593a;

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return this.f12593a.m3041a(ByteBufferUtil.m3207b((ByteBuffer) obj), i, i2, options, Downsampler.f3529e);
    }

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f12593a = downsampler;
    }

    public final /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return Downsampler.m3038b();
    }
}
