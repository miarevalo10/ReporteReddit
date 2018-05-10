package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {
    private final Set<LifecycleListener> f12649a = Collections.newSetFromMap(new WeakHashMap());
    private boolean f12650b;
    private boolean f12651c;

    ActivityFragmentLifecycle() {
    }

    public final void mo1003a(LifecycleListener lifecycleListener) {
        this.f12649a.add(lifecycleListener);
        if (this.f12651c) {
            lifecycleListener.mo873c();
        } else if (this.f12650b) {
            lifecycleListener.mo871a();
        } else {
            lifecycleListener.mo872b();
        }
    }

    public final void mo1004b(LifecycleListener lifecycleListener) {
        this.f12649a.remove(lifecycleListener);
    }

    final void m11688a() {
        this.f12650b = true;
        for (LifecycleListener a : Util.m3228a(this.f12649a)) {
            a.mo871a();
        }
    }

    final void m11690b() {
        this.f12650b = false;
        for (LifecycleListener b : Util.m3228a(this.f12649a)) {
            b.mo872b();
        }
    }

    final void m11692c() {
        this.f12651c = true;
        for (LifecycleListener c : Util.m3228a(this.f12649a)) {
            c.mo873c();
        }
    }
}
