package com.google.android.gms.ads.internal.js;

import com.instabug.library.model.NetworkLog;

final class zzh implements Runnable {
    private /* synthetic */ String f5456a;
    private /* synthetic */ zze f5457b;

    zzh(zze com_google_android_gms_ads_internal_js_zze, String str) {
        this.f5457b = com_google_android_gms_ads_internal_js_zze;
        this.f5456a = str;
    }

    public final void run() {
        this.f5457b.f19075a.loadData(this.f5456a, NetworkLog.HTML, "UTF-8");
    }
}
