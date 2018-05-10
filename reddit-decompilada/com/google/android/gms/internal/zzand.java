package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

final class zzand implements Runnable {
    private /* synthetic */ String f6603a;
    private /* synthetic */ String f6604b;
    private /* synthetic */ String f6605c;
    private /* synthetic */ String f6606d;
    private /* synthetic */ zzana f6607e;

    zzand(zzana com_google_android_gms_internal_zzana, String str, String str2, String str3, String str4) {
        this.f6607e = com_google_android_gms_internal_zzana;
        this.f6603a = str;
        this.f6604b = str2;
        this.f6605c = str3;
        this.f6606d = str4;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f6603a);
        if (!TextUtils.isEmpty(this.f6604b)) {
            hashMap.put("cachedSrc", this.f6604b);
        }
        hashMap.put("type", zzana.m13400b(this.f6605c));
        hashMap.put("reason", this.f6605c);
        if (!TextUtils.isEmpty(this.f6606d)) {
            hashMap.put("message", this.f6606d);
        }
        zzana.m13399a(this.f6607e, "onPrecacheEvent", hashMap);
    }
}
