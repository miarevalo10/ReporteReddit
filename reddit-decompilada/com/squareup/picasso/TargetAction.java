package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;

public final class TargetAction extends Action<Target> {
    public TargetAction(Picasso picasso, Target target, Request request, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(picasso, target, request, i, i2, i3, drawable, str, obj, false);
    }

    final void mo5454a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        Target target = (Target) m25743c();
        if (target != null) {
            target.mo5512a(bitmap);
            if (bitmap.isRecycled() != null) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    final void mo5453a() {
        if (((Target) m25743c()) != null && this.g != 0) {
            this.a.f23831e.getResources().getDrawable(this.g);
        }
    }
}
