package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

final class zzanc implements Runnable {
    private /* synthetic */ String f6599a;
    private /* synthetic */ String f6600b;
    private /* synthetic */ int f6601c;
    private /* synthetic */ zzana f6602d;

    zzanc(zzana com_google_android_gms_internal_zzana, String str, String str2, int i) {
        this.f6602d = com_google_android_gms_internal_zzana;
        this.f6599a = str;
        this.f6600b = str2;
        this.f6601c = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f6599a);
        hashMap.put("cachedSrc", this.f6600b);
        hashMap.put("totalBytes", Integer.toString(this.f6601c));
        zzana.m13399a(this.f6602d, "onPrecacheEvent", hashMap);
    }
}
