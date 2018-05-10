package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
    private static final byte[] f18887b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(a);
    private final int f18888c;

    public RoundedCorners(int i) {
        Preconditions.m3221a(i > 0, "roundingRadius must be greater than 0.");
        this.f18888c = i;
    }

    protected final Bitmap mo3856a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m3058b(bitmapPool, bitmap, this.f18888c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RoundedCorners)) {
            return false;
        }
        if (this.f18888c == ((RoundedCorners) obj).f18888c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Util.m3234b("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), Util.m3233b(this.f18888c));
    }

    public final void mo893a(MessageDigest messageDigest) {
        messageDigest.update(f18887b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18888c).array());
    }
}
