package com.google.android.gms.ads.internal.js;

final class zzj implements Runnable {
    private /* synthetic */ String f5460a;
    private /* synthetic */ zze f5461b;

    zzj(zze com_google_android_gms_ads_internal_js_zze, String str) {
        this.f5461b = com_google_android_gms_ads_internal_js_zze;
        this.f5460a = str;
    }

    public final void run() {
        this.f5461b.f19075a.loadUrl(this.f5460a);
    }
}
