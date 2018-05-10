package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Initializable, Resource<BitmapDrawable> {
    private final Resources f12598a;
    private final Resource<Bitmap> f12599b;

    public static Resource<BitmapDrawable> m11613a(Resources resources, Resource<Bitmap> resource) {
        return resource == null ? null : new LazyBitmapDrawableResource(resources, resource);
    }

    private LazyBitmapDrawableResource(Resources resources, Resource<Bitmap> resource) {
        this.f12598a = (Resources) Preconditions.m3217a((Object) resources);
        this.f12599b = (Resource) Preconditions.m3217a((Object) resource);
    }

    public final Class<BitmapDrawable> mo925a() {
        return BitmapDrawable.class;
    }

    public final int mo927c() {
        return this.f12599b.mo927c();
    }

    public final void mo928d() {
        this.f12599b.mo928d();
    }

    public final void mo981e() {
        if (this.f12599b instanceof Initializable) {
            ((Initializable) this.f12599b).mo981e();
        }
    }

    public final /* synthetic */ Object mo926b() {
        return new BitmapDrawable(this.f12598a, (Bitmap) this.f12599b.mo926b());
    }
}
