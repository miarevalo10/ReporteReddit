package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    public final void mo928d() {
    }

    static Resource<Drawable> m17024a(Drawable drawable) {
        return drawable != null ? new NonOwnedDrawableResource(drawable) : null;
    }

    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    public final Class<Drawable> mo925a() {
        return this.a.getClass();
    }

    public final int mo927c() {
        return Math.max(1, (this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight()) * 4);
    }
}
