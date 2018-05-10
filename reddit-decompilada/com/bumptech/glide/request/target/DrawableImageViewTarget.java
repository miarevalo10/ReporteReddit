package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    protected final /* synthetic */ void mo4378a(Object obj) {
        ((ImageView) this.a).setImageDrawable((Drawable) obj);
    }

    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }
}
