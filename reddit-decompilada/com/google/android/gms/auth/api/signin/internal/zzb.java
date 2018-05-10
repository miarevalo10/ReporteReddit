package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcu;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzb extends AsyncTaskLoader<Void> implements zzcu {
    private Semaphore f17250o = new Semaphore(0);
    private Set<GoogleApiClient> f17251p;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f17251p = set;
    }

    private final Void m17570n() {
        int i = 0;
        for (GoogleApiClient a : this.f17251p) {
            if (a.mo1595a((zzcu) this)) {
                i++;
            }
        }
        try {
            this.f17250o.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public final /* synthetic */ Object mo3402d() {
        return m17570n();
    }

    protected final void mo3403f() {
        this.f17250o.drainPermits();
        m739h();
    }

    public final void mo3404m() {
        this.f17250o.release();
    }
}
