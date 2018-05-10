package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzm implements zzj {
    private /* synthetic */ zzd f14005a;

    public zzm(zzd com_google_android_gms_common_internal_zzd) {
        this.f14005a = com_google_android_gms_common_internal_zzd;
    }

    public final void mo1579a(ConnectionResult connectionResult) {
        if (connectionResult.m17584b()) {
            this.f14005a.m4845a(null, this.f14005a.n_());
            return;
        }
        if (this.f14005a.f5930v != null) {
            this.f14005a.f5930v.mo1622a(connectionResult);
        }
    }
}
