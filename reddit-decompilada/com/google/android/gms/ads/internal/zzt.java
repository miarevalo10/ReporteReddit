package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzol;

final class zzt implements Runnable {
    private /* synthetic */ zzol f5645a;
    private /* synthetic */ zzq f5646b;

    zzt(zzq com_google_android_gms_ads_internal_zzq, zzol com_google_android_gms_internal_zzol) {
        this.f5646b = com_google_android_gms_ads_internal_zzq;
        this.f5645a = com_google_android_gms_internal_zzol;
    }

    public final void run() {
        try {
            if (this.f5646b.e.f5615r != null) {
                this.f5646b.e.f5615r.mo2152a(this.f5645a);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
