package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T> implements Resource<T> {
    protected final T f12588a;

    public final int mo927c() {
        return 1;
    }

    public final void mo928d() {
    }

    public SimpleResource(T t) {
        this.f12588a = Preconditions.m3217a((Object) t);
    }

    public final Class<T> mo925a() {
        return this.f12588a.getClass();
    }

    public final T mo926b() {
        return this.f12588a;
    }
}
