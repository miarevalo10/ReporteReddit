package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzajj;
import com.google.android.gms.internal.zzakb;
import java.util.Map;

final class zzt implements com.google.android.gms.ads.internal.gmsg.zzt<zzaj> {
    private /* synthetic */ zzc f13752a;
    private /* synthetic */ zzajj f13753b;
    private /* synthetic */ zzo f13754c;

    zzt(zzo com_google_android_gms_ads_internal_js_zzo, zzc com_google_android_gms_ads_internal_js_zzc, zzajj com_google_android_gms_internal_zzajj) {
        this.f13754c = com_google_android_gms_ads_internal_js_zzo;
        this.f13752a = com_google_android_gms_ads_internal_js_zzc;
        this.f13753b = com_google_android_gms_internal_zzajj;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.f13754c.f5472c.f5462a) {
            zzakb.m5370d("JS Engine is requesting an update");
            if (this.f13754c.f5472c.f5469h == null) {
                zzakb.m5370d("Starting reload.");
                this.f13754c.f5472c.f5469h = 2;
                this.f13754c.f5472c.m4447a(this.f13754c.f5470a);
            }
            this.f13752a.mo3935b("/requestReload", (com.google.android.gms.ads.internal.gmsg.zzt) this.f13753b.f6452a);
        }
    }
}
