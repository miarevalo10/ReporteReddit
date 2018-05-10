package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> f16735b;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f16735b = (Transformation) Preconditions.m3217a((Object) transformation);
    }

    public final Resource<GifDrawable> mo3260a(Context context, Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable gifDrawable = (GifDrawable) resource.mo926b();
        Resource bitmapResource = new BitmapResource(gifDrawable.m11674a(), Glide.m2775a(context).f3192a);
        context = this.f16735b.mo3260a(context, bitmapResource, i, i2);
        if (bitmapResource.equals(context) == 0) {
            bitmapResource.mo928d();
        }
        Bitmap bitmap = (Bitmap) context.mo926b();
        gifDrawable.f12628a.f3556a.m3072a(this.f16735b, bitmap);
        return resource;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GifDrawableTransformation)) {
            return null;
        }
        return this.f16735b.equals(((GifDrawableTransformation) obj).f16735b);
    }

    public int hashCode() {
        return this.f16735b.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        this.f16735b.mo893a(messageDigest);
    }
}
