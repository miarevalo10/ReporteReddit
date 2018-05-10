package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

final class zzad implements zzg {
    private /* synthetic */ OnConnectionFailedListener f13994a;

    zzad(OnConnectionFailedListener onConnectionFailedListener) {
        this.f13994a = onConnectionFailedListener;
    }

    public final void mo1622a(ConnectionResult connectionResult) {
        this.f13994a.mo1583a(connectionResult);
    }
}
