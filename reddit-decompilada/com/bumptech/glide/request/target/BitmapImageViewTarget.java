package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    protected final /* synthetic */ void mo4378a(Object obj) {
        ((ImageView) this.a).setImageBitmap((Bitmap) obj);
    }

    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }
}
