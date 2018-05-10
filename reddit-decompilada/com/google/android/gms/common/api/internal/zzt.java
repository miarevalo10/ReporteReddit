package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzbq;

public final class zzt implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> f13970a;
    zzu f13971b;
    private final boolean f13972c;

    public zzt(Api<?> api, boolean z) {
        this.f13970a = api;
        this.f13972c = z;
    }

    private final void m13047a() {
        zzbq.m4809a(this.f13971b, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void mo1581a(int i) {
        m13047a();
        this.f13971b.mo1581a(i);
    }

    public final void mo1582a(Bundle bundle) {
        m13047a();
        this.f13971b.mo1582a(bundle);
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        m13047a();
        this.f13971b.mo3413a(connectionResult, this.f13970a, this.f13972c);
    }
}
