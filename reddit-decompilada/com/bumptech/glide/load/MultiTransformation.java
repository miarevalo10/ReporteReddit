package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> f16726b;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f16726b = Arrays.asList(transformationArr);
    }

    public final Resource<T> mo3260a(Context context, Resource<T> resource, int i, int i2) {
        Resource<T> resource2 = resource;
        for (Transformation a : this.f16726b) {
            Resource<T> a2 = a.mo3260a(context, resource2, i, i2);
            if (!(resource2 == null || resource2.equals(resource) || resource2.equals(a2))) {
                resource2.mo928d();
            }
            resource2 = a2;
        }
        return resource2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MultiTransformation)) {
            return null;
        }
        return this.f16726b.equals(((MultiTransformation) obj).f16726b);
    }

    public int hashCode() {
        return this.f16726b.hashCode();
    }

    public final void mo893a(MessageDigest messageDigest) {
        for (Transformation a : this.f16726b) {
            a.mo893a(messageDigest);
        }
    }
}
