package com.google.android.gms.internal;

import org.json.JSONObject;

final /* synthetic */ class zzzi implements zzakg {
    private final zzzf f14780a;
    private final JSONObject f14781b;

    zzzi(zzzf com_google_android_gms_internal_zzzf, JSONObject jSONObject) {
        this.f14780a = com_google_android_gms_internal_zzzf;
        this.f14781b = jSONObject;
    }

    public final zzakv mo1516a(Object obj) {
        zzzf com_google_android_gms_internal_zzzf = this.f14780a;
        JSONObject jSONObject = this.f14781b;
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        jSONObject.put("ads_id", com_google_android_gms_internal_zzzf.f18354a);
        com_google_android_gms_internal_zzanh.mo3465b("google.afma.nativeAds.handleClickGmsg", jSONObject);
        return zzakl.m5377a(new JSONObject());
    }
}
