package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public class DrawableTransformation implements Transformation<Drawable> {
    private final Transformation<Bitmap> f16733b;
    private final boolean f16734c;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f16733b = transformation;
        this.f16734c = z;
    }

    public final Resource<Drawable> mo3260a(Context context, Resource<Drawable> resource, int i, int i2) {
        Drawable drawable = (Drawable) resource.mo926b();
        Resource a = DrawableToBitmapConverter.m3042a(Glide.m2775a(context).f3192a, drawable, i, i2);
        if (a != null) {
            i = this.f16733b.mo3260a(context, a, i, i2);
            if (i.equals(a) == 0) {
                return LazyBitmapDrawableResource.m11613a(context.getResources(), i);
            }
            i.mo928d();
            return resource;
        } else if (this.f16734c == null) {
            return resource;
        } else {
            resource = new StringBuilder("Unable to convert ");
            resource.append(drawable);
            resource.append(" to a Bitmap");
            throw new IllegalArgumentException(resource.toString());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DrawableTransformation)) {
            return null;
        }
        return this.f16733b.equals(((DrawableTransformation) obj).f16733b);
    }

    public int hashCode() {
        return this.f16733b.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        this.f16733b.mo893a(messageDigest);
    }
}
