package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CircleCrop extends BitmapTransformation {
    private static final byte[] f18885b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(a);

    protected final Bitmap mo3856a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m3062d(bitmapPool, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        messageDigest.update(f18885b);
    }
}
