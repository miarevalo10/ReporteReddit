package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqz;

final class zzu implements Runnable {
    private /* synthetic */ zzqm f5647a;
    private /* synthetic */ zzq f5648b;

    zzu(zzq com_google_android_gms_ads_internal_zzq, zzqm com_google_android_gms_internal_zzqm) {
        this.f5648b = com_google_android_gms_ads_internal_zzq;
        this.f5647a = com_google_android_gms_internal_zzqm;
    }

    public final void run() {
        try {
            ((zzqz) this.f5648b.e.f5617t.get(this.f5647a.mo2149l())).mo2154a(this.f5647a);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
