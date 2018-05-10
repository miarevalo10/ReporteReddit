package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

public class EngineResource<Z> implements Resource<Z> {
    final boolean f12427a;
    final Resource<Z> f12428b;
    private final boolean f12429c;
    private ResourceListener f12430d;
    private Key f12431e;
    private int f12432f;
    private boolean f12433g;

    interface ResourceListener {
        void mo918a(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource, boolean z, boolean z2) {
        this.f12428b = (Resource) Preconditions.m3217a((Object) resource);
        this.f12427a = z;
        this.f12429c = z2;
    }

    final void m11338a(Key key, ResourceListener resourceListener) {
        this.f12431e = key;
        this.f12430d = resourceListener;
    }

    public final Class<Z> mo925a() {
        return this.f12428b.mo925a();
    }

    public final Z mo926b() {
        return this.f12428b.mo926b();
    }

    public final int mo927c() {
        return this.f12428b.mo927c();
    }

    public final void mo928d() {
        if (this.f12432f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.f12433g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.f12433g = true;
            if (this.f12429c) {
                this.f12428b.mo928d();
            }
        }
    }

    public final void m11342e() {
        if (this.f12433g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f12432f++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    final void m11343f() {
        if (this.f12432f <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f12432f - 1;
            this.f12432f = i;
            if (i == 0) {
                this.f12430d.mo918a(this.f12431e, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EngineResource{isCacheable=");
        stringBuilder.append(this.f12427a);
        stringBuilder.append(", listener=");
        stringBuilder.append(this.f12430d);
        stringBuilder.append(", key=");
        stringBuilder.append(this.f12431e);
        stringBuilder.append(", acquired=");
        stringBuilder.append(this.f12432f);
        stringBuilder.append(", isRecycled=");
        stringBuilder.append(this.f12433g);
        stringBuilder.append(", resource=");
        stringBuilder.append(this.f12428b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
