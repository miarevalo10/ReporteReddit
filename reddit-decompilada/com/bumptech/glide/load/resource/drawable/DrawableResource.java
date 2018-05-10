package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Initializable, Resource<T> {
    protected final T f12617a;

    public DrawableResource(T t) {
        this.f12617a = (Drawable) Preconditions.m3217a((Object) t);
    }

    public void mo981e() {
        if (this.f12617a instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f12617a).getBitmap().prepareToDraw();
            return;
        }
        if (this.f12617a instanceof GifDrawable) {
            ((GifDrawable) this.f12617a).m11674a().prepareToDraw();
        }
    }

    public final /* synthetic */ Object mo926b() {
        ConstantState constantState = this.f12617a.getConstantState();
        if (constantState == null) {
            return this.f12617a;
        }
        return constantState.newDrawable();
    }
}
