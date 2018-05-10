package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzbr implements Runnable {
    private /* synthetic */ ConnectionResult f5793a;
    private /* synthetic */ zzbo f5794b;

    zzbr(zzbo com_google_android_gms_common_api_internal_zzbo, ConnectionResult connectionResult) {
        this.f5794b = com_google_android_gms_common_api_internal_zzbo;
        this.f5793a = connectionResult;
    }

    public final void run() {
        this.f5794b.mo1583a(this.f5793a);
    }
}
