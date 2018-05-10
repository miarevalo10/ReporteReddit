package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.js.zzaj;
import com.google.android.gms.ads.internal.zzbs;

final class zzgg implements zzalk<zzaj> {
    private /* synthetic */ zzgf f14485a;

    zzgg(zzgf com_google_android_gms_internal_zzgf) {
        this.f14485a = com_google_android_gms_internal_zzgf;
    }

    public final /* synthetic */ void mo1509a(Object obj) {
        zzaj com_google_android_gms_ads_internal_js_zzaj = (zzaj) obj;
        this.f14485a.f14484i = true;
        zzgf com_google_android_gms_internal_zzgf = this.f14485a;
        com_google_android_gms_ads_internal_js_zzaj.mo3934a("/updateActiveView", com_google_android_gms_internal_zzgf.f14477b);
        com_google_android_gms_ads_internal_js_zzaj.mo3934a("/untrackActiveViewUnit", com_google_android_gms_internal_zzgf.f14478c);
        com_google_android_gms_ads_internal_js_zzaj.mo3934a("/visibilityChanged", com_google_android_gms_internal_zzgf.f14479d);
        if (zzbs.m4507z().m5090a(com_google_android_gms_internal_zzgf.f14476a)) {
            com_google_android_gms_ads_internal_js_zzaj.mo3934a("/logScionEvent", com_google_android_gms_internal_zzgf.f14480e);
        }
    }
}
