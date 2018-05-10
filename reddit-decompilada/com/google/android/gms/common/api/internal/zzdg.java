package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;

public final class zzdg<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    ResultTransform<? super R, ? extends Result> f13944a;
    volatile ResultCallbacks<? super R> f13945b;
    PendingResult<R> f13946c;
    final Object f13947d;
    Status f13948e;
    final WeakReference<GoogleApiClient> f13949f;
    boolean f13950g;
    private zzdg<? extends Result> f13951h;
    private final zzdi f13952i;

    private final boolean m13020a() {
        return (this.f13945b == null || ((GoogleApiClient) this.f13949f.get()) == null) ? false : true;
    }

    private final void m13022b(Status status) {
        synchronized (this.f13947d) {
            this.f13948e = status;
            m13027a(this.f13948e);
        }
    }

    public final void mo1602a(R r) {
        synchronized (this.f13947d) {
            if (!r.k_().m17588b()) {
                m13022b(r.k_());
            } else if (this.f13944a != null) {
                zzcs.m4758a().submit(new zzdh(this, r));
            } else if (m13020a()) {
                ResultCallbacks resultCallbacks = this.f13945b;
            }
        }
    }

    final void m13027a(Status status) {
        synchronized (this.f13947d) {
            if (this.f13944a != null) {
                status = ResultTransform.m4676a(status);
                zzbq.m4809a((Object) status, (Object) "onFailure must not return null");
                this.f13951h.m13022b(status);
            } else if (m13020a()) {
                ResultCallbacks resultCallbacks = this.f13945b;
            }
        }
    }
}
