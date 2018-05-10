package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzawy extends zzaww {
    private /* synthetic */ ProxyRequest f19567a;

    zzawy(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        this.f19567a = proxyRequest;
        super(googleApiClient);
    }

    protected final void mo4291a(zzawl com_google_android_gms_internal_zzawl) throws RemoteException {
        com_google_android_gms_internal_zzawl.mo1766a(new zzawz(this), this.f19567a);
    }
}
