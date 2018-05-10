package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzqz;

final class zzbg implements Runnable {
    private /* synthetic */ String f5528a;
    private /* synthetic */ zzafo f5529b;
    private /* synthetic */ zzba f5530c;

    zzbg(zzba com_google_android_gms_ads_internal_zzba, String str, zzafo com_google_android_gms_internal_zzafo) {
        this.f5530c = com_google_android_gms_ads_internal_zzba;
        this.f5528a = str;
        this.f5529b = com_google_android_gms_internal_zzafo;
    }

    public final void run() {
        try {
            ((zzqz) this.f5530c.e.f5617t.get(this.f5528a)).mo2154a((zzon) this.f5529b.f6276B);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
