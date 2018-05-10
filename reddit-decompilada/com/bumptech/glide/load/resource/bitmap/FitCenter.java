package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class FitCenter extends BitmapTransformation {
    private static final byte[] f18886b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(a);

    protected final Bitmap mo3856a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m3059b(bitmapPool, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        messageDigest.update(f18886b);
    }
}
