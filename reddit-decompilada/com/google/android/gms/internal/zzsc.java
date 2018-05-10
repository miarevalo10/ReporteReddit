package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzg;

final class zzsc implements zzg {
    private /* synthetic */ zzalf f14620a;
    private /* synthetic */ zzrx f14621b;

    zzsc(zzrx com_google_android_gms_internal_zzrx, zzalf com_google_android_gms_internal_zzalf) {
        this.f14621b = com_google_android_gms_internal_zzrx;
        this.f14620a = com_google_android_gms_internal_zzalf;
    }

    public final void mo1622a(ConnectionResult connectionResult) {
        synchronized (this.f14621b.f14616d) {
            this.f14620a.m13329a(new RuntimeException("Connection failed."));
        }
    }
}
