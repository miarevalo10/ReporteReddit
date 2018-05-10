package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final BitmapPool f12645a;
    private final ResourceTranscoder<Bitmap, byte[]> f12646b;
    private final ResourceTranscoder<GifDrawable, byte[]> f12647c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f12645a = bitmapPool;
        this.f12646b = resourceTranscoder;
        this.f12647c = resourceTranscoder2;
    }

    public final Resource<byte[]> mo1002a(Resource<Drawable> resource, Options options) {
        Drawable drawable = (Drawable) resource.mo926b();
        if (drawable instanceof BitmapDrawable) {
            return this.f12646b.mo1002a(BitmapResource.m11573a(((BitmapDrawable) drawable).getBitmap(), this.f12645a), options);
        }
        return drawable instanceof GifDrawable ? this.f12647c.mo1002a(resource, options) : null;
    }
}
