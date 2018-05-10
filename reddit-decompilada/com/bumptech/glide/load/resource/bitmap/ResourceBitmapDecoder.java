package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final ResourceDrawableDecoder f12600a;
    private final BitmapPool f12601b;

    public final /* synthetic */ Resource mo979a(Object obj, int i, int i2, Options options) throws IOException {
        obj = this.f12600a.m11653a((Uri) obj);
        if (obj == null) {
            return null;
        }
        return DrawableToBitmapConverter.m3042a(this.f12601b, (Drawable) obj.mo926b(), i, i2);
    }

    public final /* synthetic */ boolean mo980a(Object obj, Options options) throws IOException {
        return "android.resource".equals(((Uri) obj).getScheme());
    }

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f12600a = resourceDrawableDecoder;
        this.f12601b = bitmapPool;
    }
}
