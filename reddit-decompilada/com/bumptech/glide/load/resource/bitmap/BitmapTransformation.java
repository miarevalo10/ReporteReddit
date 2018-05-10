package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public abstract Bitmap mo3856a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    public final Resource<Bitmap> mo3260a(Context context, Resource<Bitmap> resource, int i, int i2) {
        if (Util.m3231a(i, i2)) {
            BitmapPool bitmapPool = Glide.m2775a(context).f3192a;
            Bitmap bitmap = (Bitmap) resource.mo926b();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            i = mo3856a(bitmapPool, bitmap, i, i2);
            return bitmap.equals(i) != 0 ? resource : BitmapResource.m11573a(i, bitmapPool);
        } else {
            resource = new StringBuilder("Cannot apply transformation on width: ");
            resource.append(i);
            resource.append(" or height: ");
            resource.append(i2);
            resource.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
            throw new IllegalArgumentException(resource.toString());
        }
    }
}
