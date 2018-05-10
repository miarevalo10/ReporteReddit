package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> f16728b = new UnitTransformation();

    public final Resource<T> mo3260a(Context context, Resource<T> resource, int i, int i2) {
        return resource;
    }

    public final void mo893a(MessageDigest messageDigest) {
    }

    public static <T> UnitTransformation<T> m17011a() {
        return (UnitTransformation) f16728b;
    }

    private UnitTransformation() {
    }
}
