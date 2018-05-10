package com.google.android.gms.ads.internal.js;

import com.instabug.library.model.NetworkLog;

final class zzi implements Runnable {
    private /* synthetic */ String f5458a;
    private /* synthetic */ zze f5459b;

    zzi(zze com_google_android_gms_ads_internal_js_zze, String str) {
        this.f5459b = com_google_android_gms_ads_internal_js_zze;
        this.f5458a = str;
    }

    public final void run() {
        this.f5459b.f19075a.loadData(this.f5458a, NetworkLog.HTML, "UTF-8");
    }
}
