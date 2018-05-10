package com.google.android.gms.ads.internal.js;

import org.json.JSONObject;

final class zzg implements Runnable {
    private /* synthetic */ String f5453a;
    private /* synthetic */ JSONObject f5454b;
    private /* synthetic */ zze f5455c;

    zzg(zze com_google_android_gms_ads_internal_js_zze, String str, JSONObject jSONObject) {
        this.f5455c = com_google_android_gms_ads_internal_js_zze;
        this.f5453a = str;
        this.f5454b = jSONObject;
    }

    public final void run() {
        this.f5455c.f19075a.mo3465b(this.f5453a, this.f5454b);
    }
}
