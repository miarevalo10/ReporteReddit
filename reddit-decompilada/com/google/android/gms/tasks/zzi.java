package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult> implements zzk<TResult> {
    private final Executor f14818a;
    private final Object f14819b = new Object();
    private OnSuccessListener<? super TResult> f14820c;

    public zzi(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f14818a = executor;
        this.f14820c = onSuccessListener;
    }

    public final void mo2305a(Task<TResult> task) {
        if (task.mo2311b()) {
            synchronized (this.f14819b) {
                if (this.f14820c == null) {
                    return;
                }
                this.f14818a.execute(new zzj(this, task));
            }
        }
    }
}
