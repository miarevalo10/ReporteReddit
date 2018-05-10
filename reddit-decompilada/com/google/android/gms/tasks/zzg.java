package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzg<TResult> implements zzk<TResult> {
    private final Executor f14815a;
    private final Object f14816b = new Object();
    private OnFailureListener f14817c;

    public zzg(Executor executor, OnFailureListener onFailureListener) {
        this.f14815a = executor;
        this.f14817c = onFailureListener;
    }

    public final void mo2305a(Task<TResult> task) {
        if (!task.mo2311b()) {
            synchronized (this.f14816b) {
                if (this.f14817c == null) {
                    return;
                }
                this.f14815a.execute(new zzh(this, task));
            }
        }
    }
}
