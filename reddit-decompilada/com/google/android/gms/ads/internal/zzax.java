package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzahn;

final class zzax implements Runnable {
    final /* synthetic */ Runnable f5507a;
    final /* synthetic */ zzaw f5508b;

    zzax(zzaw com_google_android_gms_ads_internal_zzaw, Runnable runnable) {
        this.f5508b = com_google_android_gms_ads_internal_zzaw;
        this.f5507a = runnable;
    }

    public final void run() {
        zzbs.m4486e();
        zzahn.m5173a(new zzay(this));
    }
}
