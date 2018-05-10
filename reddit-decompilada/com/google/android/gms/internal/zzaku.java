package com.google.android.gms.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@zzzv
final class zzaku<T> implements zzakv<T> {
    private final T f14128a;
    private final zzakw f14129b = new zzakw();

    zzaku(T t) {
        this.f14128a = t;
        this.f14129b.m5390a();
    }

    public final void mo1732a(Runnable runnable, Executor executor) {
        this.f14129b.m5391a(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        return this.f14128a;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.f14128a;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }
}
