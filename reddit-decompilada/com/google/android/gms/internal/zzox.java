package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class zzox implements zzt<Object> {
    private final WeakReference<zzot> f14586a;
    private final String f14587b;

    public zzox(zzot com_google_android_gms_internal_zzot, String str) {
        this.f14586a = new WeakReference(com_google_android_gms_internal_zzot);
        this.f14587b = str;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("ads_id");
        String str2 = (String) map.get("eventName");
        if (!TextUtils.isEmpty(str) && this.f14587b.equals(str)) {
            try {
                Integer.parseInt((String) map.get("eventType"));
            } catch (Throwable e) {
                zzakb.m5367b("Parse Scion log event type error", e);
            }
            zzot com_google_android_gms_internal_zzot;
            if ("_ai".equals(str2)) {
                com_google_android_gms_internal_zzot = (zzot) this.f14586a.get();
                if (com_google_android_gms_internal_zzot != null) {
                    com_google_android_gms_internal_zzot.m6547w();
                }
                return;
            }
            if ("_ac".equals(str2)) {
                com_google_android_gms_internal_zzot = (zzot) this.f14586a.get();
                if (com_google_android_gms_internal_zzot != null) {
                    com_google_android_gms_internal_zzot.m6548x();
                }
            }
        }
    }
}
