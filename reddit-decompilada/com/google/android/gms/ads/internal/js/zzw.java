package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzalk;

final class zzw implements zzalk<zzc> {
    private /* synthetic */ zzae f13755a;
    private /* synthetic */ zzn f13756b;

    zzw(zzn com_google_android_gms_ads_internal_js_zzn, zzae com_google_android_gms_ads_internal_js_zzae) {
        this.f13756b = com_google_android_gms_ads_internal_js_zzn;
        this.f13755a = com_google_android_gms_ads_internal_js_zzae;
    }

    public final /* synthetic */ void mo1509a(Object obj) {
        synchronized (this.f13756b.f5462a) {
            this.f13756b.f5469h = 0;
            if (!(this.f13756b.f5468g == null || this.f13755a == this.f13756b.f5468g)) {
                zzagf.m13278a("New JS engine is loaded, marking previous one as destroyable.");
                this.f13756b.f5468g.m17388c();
            }
            this.f13756b.f5468g = this.f13755a;
        }
    }
}
