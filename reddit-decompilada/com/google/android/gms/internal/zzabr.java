package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.js.zzaj;

final class zzabr implements zzalk<zzaj> {
    private /* synthetic */ zzabq f14034a;

    zzabr(zzabq com_google_android_gms_internal_zzabq) {
        this.f14034a = com_google_android_gms_internal_zzabq;
    }

    public final /* synthetic */ void mo1509a(Object obj) {
        try {
            ((zzaj) obj).mo3465b("AFMA_getAdapterLessMediationAd", this.f14034a.f6072a);
        } catch (Throwable e) {
            zzakb.m5367b("Error requesting an ad url", e);
            zzabo.f17486f.m12746a(this.f14034a.f6073b);
        }
    }
}
