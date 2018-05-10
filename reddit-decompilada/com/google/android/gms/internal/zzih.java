package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzg;

final class zzih implements zzg {
    private /* synthetic */ zzid f14513a;

    zzih(zzid com_google_android_gms_internal_zzid) {
        this.f14513a = com_google_android_gms_internal_zzid;
    }

    public final void mo1622a(ConnectionResult connectionResult) {
        synchronized (this.f14513a.f7722b) {
            this.f14513a.f7725e = null;
            if (this.f14513a.f7723c != null) {
                this.f14513a.f7723c = null;
            }
            this.f14513a.f7722b.notifyAll();
        }
    }
}
