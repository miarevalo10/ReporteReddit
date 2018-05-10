package com.google.android.gms.internal;

import java.util.concurrent.Executor;

final /* synthetic */ class zzakx implements Runnable {
    private final Executor f6509a;
    private final Runnable f6510b;

    zzakx(Executor executor, Runnable runnable) {
        this.f6509a = executor;
        this.f6510b = runnable;
    }

    public final void run() {
        this.f6509a.execute(this.f6510b);
    }
}
