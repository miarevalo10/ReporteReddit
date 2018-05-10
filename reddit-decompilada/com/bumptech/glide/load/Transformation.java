package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;

public interface Transformation<T> extends Key {
    Resource<T> mo3260a(Context context, Resource<T> resource, int i, int i2);

    boolean equals(Object obj);

    int hashCode();
}
