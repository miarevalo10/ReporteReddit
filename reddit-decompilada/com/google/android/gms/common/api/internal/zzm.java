package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzbz;

public abstract class zzm<R extends Result, A extends zzb> extends BasePendingResult<R> implements zzn<R> {
    final zzc<A> f17313d;
    final Api<?> f17314e;

    protected zzm(Api<?> api, GoogleApiClient googleApiClient) {
        super((GoogleApiClient) zzbq.m4809a((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
        zzbq.m4809a((Object) api, (Object) "Api must not be null");
        this.f17313d = api.zzagf();
        this.f17314e = api;
    }

    private final void m17670a(RemoteException remoteException) {
        m17674c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    public abstract void mo4021a(A a) throws RemoteException;

    public final void m17673b(A a) throws DeadObjectException {
        if (a instanceof zzbz) {
            zzb n = zzbz.m20203n();
        }
        try {
            mo4021a(n);
        } catch (RemoteException e) {
            m17670a(e);
            throw e;
        } catch (RemoteException e2) {
            m17670a(e2);
        }
    }

    public final void m17674c(Status status) {
        zzbq.m4818b(status.m17588b() ^ 1, "Failed result must not be success");
        m12826a(mo3409a(status));
    }
}
