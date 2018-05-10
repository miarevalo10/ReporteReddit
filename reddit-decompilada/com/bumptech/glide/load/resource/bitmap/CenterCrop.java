package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop extends BitmapTransformation {
    private static final byte[] f18883b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(a);

    protected final Bitmap mo3856a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m3054a(bitmapPool, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        messageDigest.update(f18883b);
    }
}
