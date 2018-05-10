package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqz;

final class zzbh implements Runnable {
    private /* synthetic */ zzqm f5531a;
    private /* synthetic */ zzba f5532b;

    zzbh(zzba com_google_android_gms_ads_internal_zzba, zzqm com_google_android_gms_internal_zzqm) {
        this.f5532b = com_google_android_gms_ads_internal_zzba;
        this.f5531a = com_google_android_gms_internal_zzqm;
    }

    public final void run() {
        try {
            ((zzqz) this.f5532b.e.f5617t.get(this.f5531a.mo2149l())).mo2154a(this.f5531a);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
