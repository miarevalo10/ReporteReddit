package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;
import org.json.JSONObject;

final class zzpd implements zzt<Object> {
    private /* synthetic */ zzzb f14596a;
    private /* synthetic */ zzoy f14597b;

    zzpd(zzoy com_google_android_gms_internal_zzoy, zzzb com_google_android_gms_internal_zzzb) {
        this.f14597b = com_google_android_gms_internal_zzoy;
        this.f14596a = com_google_android_gms_internal_zzzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            jSONObject.put("id", this.f14597b.f7955b);
            this.f14596a.mo3577a("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            zzakb.m5367b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
