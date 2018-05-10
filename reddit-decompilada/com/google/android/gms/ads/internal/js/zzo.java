package com.google.android.gms.ads.internal.js;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajj;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzcv;

final class zzo implements Runnable {
    final /* synthetic */ zzcv f5470a;
    final /* synthetic */ zzae f5471b;
    final /* synthetic */ zzn f5472c;

    zzo(zzn com_google_android_gms_ads_internal_js_zzn, zzcv com_google_android_gms_internal_zzcv, zzae com_google_android_gms_ads_internal_js_zzae) {
        this.f5472c = com_google_android_gms_ads_internal_js_zzn;
        this.f5470a = com_google_android_gms_internal_zzcv;
        this.f5471b = com_google_android_gms_ads_internal_js_zzae;
    }

    public final void run() {
        try {
            zzc com_google_android_gms_ads_internal_js_zze = new zze(this.f5472c.f5463b, this.f5472c.f5465d, this.f5470a);
            com_google_android_gms_ads_internal_js_zze.mo3937a(new zzp(this, com_google_android_gms_ads_internal_js_zze));
            com_google_android_gms_ads_internal_js_zze.mo3934a("/jsLoaded", new zzs(this, com_google_android_gms_ads_internal_js_zze));
            zzajj com_google_android_gms_internal_zzajj = new zzajj();
            zzt com_google_android_gms_ads_internal_js_zzt = new zzt(this, com_google_android_gms_ads_internal_js_zze, com_google_android_gms_internal_zzajj);
            com_google_android_gms_internal_zzajj.f6452a = com_google_android_gms_ads_internal_js_zzt;
            com_google_android_gms_ads_internal_js_zze.mo3934a("/requestReload", com_google_android_gms_ads_internal_js_zzt);
            if (this.f5472c.f5464c.endsWith(".js")) {
                com_google_android_gms_ads_internal_js_zze.mo3938a(this.f5472c.f5464c);
            } else if (this.f5472c.f5464c.startsWith("<html>")) {
                com_google_android_gms_ads_internal_js_zze.mo3941c(this.f5472c.f5464c);
            } else {
                com_google_android_gms_ads_internal_js_zze.mo3940b(this.f5472c.f5464c);
            }
            zzahn.f6379a.postDelayed(new zzu(this, com_google_android_gms_ads_internal_js_zze), (long) zzy.f5478a);
        } catch (Throwable th) {
            zzakb.m5367b("Error creating webview.", th);
            zzbs.m4490i().m13246a(th, "SdkJavascriptFactory.loadJavascriptEngine");
            this.f5471b.m13334d();
        }
    }
}
