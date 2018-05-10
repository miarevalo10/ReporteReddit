package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Initializable, Resource<Bitmap> {
    private final Bitmap f12591a;
    private final BitmapPool f12592b;

    public static BitmapResource m11573a(Bitmap bitmap, BitmapPool bitmapPool) {
        return bitmap == null ? null : new BitmapResource(bitmap, bitmapPool);
    }

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.f12591a = (Bitmap) Preconditions.m3218a((Object) bitmap, "Bitmap must not be null");
        this.f12592b = (BitmapPool) Preconditions.m3218a((Object) bitmapPool, "BitmapPool must not be null");
    }

    public final Class<Bitmap> mo925a() {
        return Bitmap.class;
    }

    public final int mo927c() {
        return Util.m3224a(this.f12591a);
    }

    public final void mo928d() {
        this.f12592b.mo940a(this.f12591a);
    }

    public final void mo981e() {
        this.f12591a.prepareToDraw();
    }

    public final /* bridge */ /* synthetic */ Object mo926b() {
        return this.f12591a;
    }
}
