package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
    private final Queue<T> f3442a = Util.m3229a(20);

    abstract T mo930a();

    BaseKeyPool() {
    }

    final T m2946b() {
        Poolable poolable = (Poolable) this.f3442a.poll();
        return poolable == null ? mo930a() : poolable;
    }

    public final void m2945a(T t) {
        if (this.f3442a.size() < 20) {
            this.f3442a.offer(t);
        }
    }
}
