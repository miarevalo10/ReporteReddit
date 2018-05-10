package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

final class zzanb implements Runnable {
    private /* synthetic */ String f6593a;
    private /* synthetic */ String f6594b;
    private /* synthetic */ int f6595c;
    private /* synthetic */ int f6596d;
    private /* synthetic */ boolean f6597e = false;
    private /* synthetic */ zzana f6598f;

    zzanb(zzana com_google_android_gms_internal_zzana, String str, String str2, int i, int i2) {
        this.f6598f = com_google_android_gms_internal_zzana;
        this.f6593a = str;
        this.f6594b = str2;
        this.f6595c = i;
        this.f6596d = i2;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f6593a);
        hashMap.put("cachedSrc", this.f6594b);
        hashMap.put("bytesLoaded", Integer.toString(this.f6595c));
        hashMap.put("totalBytes", Integer.toString(this.f6596d));
        hashMap.put("cacheReady", this.f6597e ? "1" : "0");
        zzana.m13399a(this.f6598f, "onPrecacheEvent", hashMap);
    }
}
