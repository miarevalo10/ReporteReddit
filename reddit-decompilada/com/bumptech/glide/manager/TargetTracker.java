package com.bumptech.glide.manager;

import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements LifecycleListener {
    public final Set<Target<?>> f12654a = Collections.newSetFromMap(new WeakHashMap());

    public final void mo871a() {
        for (Target a : Util.m3228a(this.f12654a)) {
            a.mo871a();
        }
    }

    public final void mo872b() {
        for (Target b : Util.m3228a(this.f12654a)) {
            b.mo872b();
        }
    }

    public final void mo873c() {
        for (Target c : Util.m3228a(this.f12654a)) {
            c.mo873c();
        }
    }
}
