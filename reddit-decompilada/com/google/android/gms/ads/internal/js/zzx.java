package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzali;

final class zzx implements zzali {
    private /* synthetic */ zzae f13757a;
    private /* synthetic */ zzn f13758b;

    zzx(zzn com_google_android_gms_ads_internal_js_zzn, zzae com_google_android_gms_ads_internal_js_zzae) {
        this.f13758b = com_google_android_gms_ads_internal_js_zzn;
        this.f13757a = com_google_android_gms_ads_internal_js_zzae;
    }

    public final void mo1510a() {
        synchronized (this.f13758b.f5462a) {
            this.f13758b.f5469h = 1;
            zzagf.m13278a("Failed loading new engine. Marking new engine destroyable.");
            this.f13757a.m17388c();
        }
    }
}
