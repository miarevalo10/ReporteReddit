package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.IOException;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {
    private final BitmapPool f12638a;

    public final /* bridge */ /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return true;
    }

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        return BitmapResource.m11573a(((GifDecoder) obj).mo882h(), this.f12638a);
    }

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f12638a = bitmapPool;
    }
}
