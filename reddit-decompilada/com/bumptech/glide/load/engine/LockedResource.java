package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools.Pool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z> implements Resource<Z>, Poolable {
    private static final Pool<LockedResource<?>> f12434a = FactoryPools.m3243a(20, new C10651());
    private final StateVerifier f12435b = StateVerifier.m3247a();
    private Resource<Z> f12436c;
    private boolean f12437d;
    private boolean f12438e;

    class C10651 implements Factory<LockedResource<?>> {
        C10651() {
        }

        public final /* synthetic */ Object mo916a() {
            return new LockedResource();
        }
    }

    static <Z> LockedResource<Z> m11345a(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.m3217a((LockedResource) f12434a.mo362a());
        lockedResource.f12438e = false;
        lockedResource.f12437d = true;
        lockedResource.f12436c = resource;
        return lockedResource;
    }

    LockedResource() {
    }

    final synchronized void m11350e() {
        this.f12435b.mo1031b();
        if (this.f12437d) {
            this.f12437d = false;
            if (this.f12438e) {
                mo928d();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public final Class<Z> mo925a() {
        return this.f12436c.mo925a();
    }

    public final Z mo926b() {
        return this.f12436c.mo926b();
    }

    public final int mo927c() {
        return this.f12436c.mo927c();
    }

    public final synchronized void mo928d() {
        this.f12435b.mo1031b();
        this.f12438e = true;
        if (!this.f12437d) {
            this.f12436c.mo928d();
            this.f12436c = null;
            f12434a.mo363a(this);
        }
    }

    public final StateVerifier getVerifier() {
        return this.f12435b;
    }
}
