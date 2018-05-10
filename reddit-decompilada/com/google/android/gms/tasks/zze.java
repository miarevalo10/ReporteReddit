package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze<TResult> implements zzk<TResult> {
    private final Executor f14812a;
    private final Object f14813b = new Object();
    private OnCompleteListener<TResult> f14814c;

    public zze(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f14812a = executor;
        this.f14814c = onCompleteListener;
    }

    public final void mo2305a(Task<TResult> task) {
        synchronized (this.f14813b) {
            if (this.f14814c == null) {
                return;
            }
            this.f14812a.execute(new zzf(this, task));
        }
    }
}
