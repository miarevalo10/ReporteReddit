package com.google.android.gms.internal;

import org.json.JSONObject;

final /* synthetic */ class zzzj implements zzakg {
    private final zzzf f14782a;
    private final JSONObject f14783b;

    zzzj(zzzf com_google_android_gms_internal_zzzf, JSONObject jSONObject) {
        this.f14782a = com_google_android_gms_internal_zzzf;
        this.f14783b = jSONObject;
    }

    public final zzakv mo1516a(Object obj) {
        zzzf com_google_android_gms_internal_zzzf = this.f14782a;
        JSONObject jSONObject = this.f14783b;
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        jSONObject.put("ads_id", com_google_android_gms_internal_zzzf.f18354a);
        com_google_android_gms_internal_zzanh.mo3465b("google.afma.nativeAds.handleImpressionPing", jSONObject);
        return zzakl.m5377a(new JSONObject());
    }
}
