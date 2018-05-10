package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafp;

final class zzbb implements Runnable {
    private /* synthetic */ zzafp f5513a;
    private /* synthetic */ zzba f5514b;

    zzbb(zzba com_google_android_gms_ads_internal_zzba, zzafp com_google_android_gms_internal_zzafp) {
        this.f5514b = com_google_android_gms_ads_internal_zzba;
        this.f5513a = com_google_android_gms_internal_zzafp;
    }

    public final void run() {
        this.f5514b.mo3389b(new zzafo(this.f5513a));
    }
}
