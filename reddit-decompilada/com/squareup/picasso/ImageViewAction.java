package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;

class ImageViewAction extends Action<ImageView> {
    Callback f30667m;

    ImageViewAction(Picasso picasso, ImageView imageView, Request request, int i, int i2, int i3, Drawable drawable, String str, Object obj, Callback callback, boolean z) {
        super(picasso, imageView, request, i, i2, i3, drawable, str, obj, z);
        this.f30667m = callback;
    }

    public final void mo5454a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            LoadedFrom loadedFrom2 = loadedFrom;
            PicassoDrawable.m25782a(imageView, this.a.f23831e, bitmap2, loadedFrom2, this.d, this.a.f23839m);
            if (this.f30667m != null) {
                this.f30667m.mo5492a();
            }
        }
    }

    public final void mo5453a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
                return;
            }
            if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
        }
    }

    final void mo5455b() {
        super.mo5455b();
        if (this.f30667m != null) {
            this.f30667m = null;
        }
    }
}
