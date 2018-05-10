package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import org.json.JSONObject;

final /* synthetic */ class zzzh implements zzakg {
    private final zzzf f14778a;
    private final JSONObject f14779b;

    zzzh(zzzf com_google_android_gms_internal_zzzf, JSONObject jSONObject) {
        this.f14778a = com_google_android_gms_internal_zzzf;
        this.f14779b = jSONObject;
    }

    public final zzakv mo1516a(Object obj) {
        zzzf com_google_android_gms_internal_zzzf = this.f14778a;
        JSONObject jSONObject = this.f14779b;
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        jSONObject.put("ads_id", com_google_android_gms_internal_zzzf.f18354a);
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        zzyl com_google_android_gms_internal_zzyl = new zzyl();
        zzt com_google_android_gms_internal_zzzk = new zzzk(com_google_android_gms_internal_zzzf, com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzyl, com_google_android_gms_internal_zzalf);
        com_google_android_gms_internal_zzyl.f8153a = com_google_android_gms_internal_zzzk;
        com_google_android_gms_internal_zzanh.mo3984a("/nativeAdPreProcess", com_google_android_gms_internal_zzzk);
        com_google_android_gms_internal_zzanh.mo3465b("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
        return com_google_android_gms_internal_zzalf;
    }
}
