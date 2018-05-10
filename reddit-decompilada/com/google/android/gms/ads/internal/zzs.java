package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzoj;

final class zzs implements Runnable {
    private /* synthetic */ zzoj f5643a;
    private /* synthetic */ zzq f5644b;

    zzs(zzq com_google_android_gms_ads_internal_zzq, zzoj com_google_android_gms_internal_zzoj) {
        this.f5644b = com_google_android_gms_ads_internal_zzq;
        this.f5643a = com_google_android_gms_internal_zzoj;
    }

    public final void run() {
        try {
            if (this.f5644b.e.f5614q != null) {
                this.f5644b.e.f5614q.mo2151a(this.f5643a);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
