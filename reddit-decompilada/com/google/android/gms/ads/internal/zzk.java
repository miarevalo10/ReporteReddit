package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;

final class zzk implements Runnable {
    private /* synthetic */ zzafp f5631a;
    private /* synthetic */ zzi f5632b;

    zzk(zzi com_google_android_gms_ads_internal_zzi, zzafp com_google_android_gms_internal_zzafp) {
        this.f5632b = com_google_android_gms_ads_internal_zzi;
        this.f5631a = com_google_android_gms_internal_zzafp;
    }

    public final void run() {
        this.f5632b.mo3389b(new zzafo(this.f5631a));
    }
}
