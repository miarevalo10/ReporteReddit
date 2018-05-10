package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@zzzv
final class zzaky<V> extends FutureTask<V> implements zzakv<V> {
    private final zzakw f14130a = new zzakw();

    zzaky(Runnable runnable, V v) {
        super(runnable, v);
    }

    zzaky(Callable<V> callable) {
        super(callable);
    }

    public final void mo1732a(Runnable runnable, Executor executor) {
        this.f14130a.m5391a(runnable, executor);
    }

    protected final void done() {
        this.f14130a.m5390a();
    }
}
