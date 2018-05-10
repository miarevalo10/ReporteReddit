package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.js.zzaj;
import com.google.android.gms.ads.internal.zzbs;

final class zzgj implements zzalk<zzaj> {
    private /* synthetic */ zzgf f14488a;

    zzgj(zzgf com_google_android_gms_internal_zzgf) {
        this.f14488a = com_google_android_gms_internal_zzgf;
    }

    public final /* synthetic */ void mo1509a(Object obj) {
        zzaj com_google_android_gms_ads_internal_js_zzaj = (zzaj) obj;
        zzgf com_google_android_gms_internal_zzgf = this.f14488a;
        com_google_android_gms_ads_internal_js_zzaj.mo3935b("/visibilityChanged", com_google_android_gms_internal_zzgf.f14479d);
        com_google_android_gms_ads_internal_js_zzaj.mo3935b("/untrackActiveViewUnit", com_google_android_gms_internal_zzgf.f14478c);
        com_google_android_gms_ads_internal_js_zzaj.mo3935b("/updateActiveView", com_google_android_gms_internal_zzgf.f14477b);
        if (zzbs.m4507z().m5090a(com_google_android_gms_internal_zzgf.f14476a)) {
            com_google_android_gms_ads_internal_js_zzaj.mo3935b("/logScionEvent", com_google_android_gms_internal_zzgf.f14480e);
        }
    }
}
