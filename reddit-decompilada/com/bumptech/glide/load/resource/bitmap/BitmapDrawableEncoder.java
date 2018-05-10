package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool f16729a;
    private final ResourceEncoder<Bitmap> f16730b;

    public final /* synthetic */ boolean mo969a(Object obj, File file, Options options) {
        return this.f16730b.mo969a(new BitmapResource(((BitmapDrawable) ((Resource) obj).mo926b()).getBitmap(), this.f16729a), file, options);
    }

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f16729a = bitmapPool;
        this.f16730b = resourceEncoder;
    }

    public final EncodeStrategy mo3265a(Options options) {
        return this.f16730b.mo3265a(options);
    }
}
