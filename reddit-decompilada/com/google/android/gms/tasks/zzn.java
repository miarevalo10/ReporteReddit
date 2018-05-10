package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executor;

public final class zzn<TResult> extends Task<TResult> {
    private final Object f14821a = new Object();
    private final zzl<TResult> f14822b = new zzl();
    private boolean f14823c;
    private TResult f14824d;
    private Exception f14825e;

    zzn() {
    }

    private final void m14521e() {
        zzbq.m4814a(this.f14823c ^ 1, (Object) "Task is already complete");
    }

    private final void m14522f() {
        synchronized (this.f14821a) {
            if (this.f14823c) {
                this.f14822b.m6869a((Task) this);
                return;
            }
        }
    }

    public final Task<TResult> mo2306a(OnCompleteListener<TResult> onCompleteListener) {
        return mo2307a(TaskExecutors.f8213a, (OnCompleteListener) onCompleteListener);
    }

    public final Task<TResult> mo2307a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f14822b.m6870a(new zze(executor, onCompleteListener));
        m14522f();
        return this;
    }

    public final Task<TResult> mo2308a(Executor executor, OnFailureListener onFailureListener) {
        this.f14822b.m6870a(new zzg(executor, onFailureListener));
        m14522f();
        return this;
    }

    public final Task<TResult> mo2309a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f14822b.m6870a(new zzi(executor, onSuccessListener));
        m14522f();
        return this;
    }

    public final void m14527a(Exception exception) {
        zzbq.m4809a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f14821a) {
            m14521e();
            this.f14823c = true;
            this.f14825e = exception;
        }
        this.f14822b.m6869a((Task) this);
    }

    public final void m14528a(TResult tResult) {
        synchronized (this.f14821a) {
            m14521e();
            this.f14823c = true;
            this.f14824d = tResult;
        }
        this.f14822b.m6869a((Task) this);
    }

    public final boolean mo2310a() {
        boolean z;
        synchronized (this.f14821a) {
            z = this.f14823c;
        }
        return z;
    }

    public final boolean mo2311b() {
        boolean z;
        synchronized (this.f14821a) {
            z = this.f14823c && this.f14825e == null;
        }
        return z;
    }

    public final boolean m14531b(Exception exception) {
        zzbq.m4809a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f14821a) {
            if (this.f14823c) {
                return false;
            }
            this.f14823c = true;
            this.f14825e = exception;
            this.f14822b.m6869a((Task) this);
            return true;
        }
    }

    public final boolean m14532b(TResult tResult) {
        synchronized (this.f14821a) {
            if (this.f14823c) {
                return false;
            }
            this.f14823c = true;
            this.f14824d = tResult;
            this.f14822b.m6869a((Task) this);
            return true;
        }
    }

    public final Exception mo2313d() {
        Exception exception;
        synchronized (this.f14821a) {
            exception = this.f14825e;
        }
        return exception;
    }

    public final TResult mo2312c() {
        TResult tResult;
        synchronized (this.f14821a) {
            zzbq.m4814a(this.f14823c, (Object) "Task is not yet complete");
            if (this.f14825e != null) {
                throw new RuntimeExecutionException(this.f14825e);
            }
            tResult = this.f14824d;
        }
        return tResult;
    }
}
