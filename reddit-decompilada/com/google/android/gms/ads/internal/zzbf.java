package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzol;

final class zzbf implements Runnable {
    private /* synthetic */ zzol f5526a;
    private /* synthetic */ zzba f5527b;

    zzbf(zzba com_google_android_gms_ads_internal_zzba, zzol com_google_android_gms_internal_zzol) {
        this.f5527b = com_google_android_gms_ads_internal_zzba;
        this.f5526a = com_google_android_gms_internal_zzol;
    }

    public final void run() {
        try {
            if (this.f5527b.e.f5615r != null) {
                this.f5527b.e.f5615r.mo2152a(this.f5526a);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
