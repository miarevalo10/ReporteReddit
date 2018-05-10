package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzoj;

final class zzbe implements Runnable {
    private /* synthetic */ zzoj f5524a;
    private /* synthetic */ zzba f5525b;

    zzbe(zzba com_google_android_gms_ads_internal_zzba, zzoj com_google_android_gms_internal_zzoj) {
        this.f5525b = com_google_android_gms_ads_internal_zzba;
        this.f5524a = com_google_android_gms_internal_zzoj;
    }

    public final void run() {
        try {
            if (this.f5525b.e.f5614q != null) {
                this.f5525b.e.f5614q.mo2151a(this.f5524a);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
