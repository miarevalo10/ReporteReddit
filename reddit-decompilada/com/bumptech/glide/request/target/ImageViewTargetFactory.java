package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageViewTargetFactory {
    public static <Z> ViewTarget<ImageView, Z> m3189a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        StringBuilder stringBuilder = new StringBuilder("Unhandled class: ");
        stringBuilder.append(cls);
        stringBuilder.append(", try .as*(Class).transcode(ResourceTranscoder)");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
