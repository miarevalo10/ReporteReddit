package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;
import org.json.JSONObject;

final /* synthetic */ class zzzk implements zzt {
    private final zzzf f14784a;
    private final zzanh f14785b;
    private final zzyl f14786c;
    private final zzalf f14787d;

    zzzk(zzzf com_google_android_gms_internal_zzzf, zzanh com_google_android_gms_internal_zzanh, zzyl com_google_android_gms_internal_zzyl, zzalf com_google_android_gms_internal_zzalf) {
        this.f14784a = com_google_android_gms_internal_zzzf;
        this.f14785b = com_google_android_gms_internal_zzanh;
        this.f14786c = com_google_android_gms_internal_zzyl;
        this.f14787d = com_google_android_gms_internal_zzalf;
    }

    public final void zza(Object obj, Map map) {
        obj = this.f14784a;
        zzanh com_google_android_gms_internal_zzanh = this.f14785b;
        zzyl com_google_android_gms_internal_zzyl = this.f14786c;
        zzalf com_google_android_gms_internal_zzalf = this.f14787d;
        try {
            boolean z;
            String str = (String) map.get("success");
            String str2 = (String) map.get("failure");
            if (TextUtils.isEmpty(str2)) {
                map = new JSONObject(str);
                z = true;
            } else {
                JSONObject jSONObject = new JSONObject(str2);
                z = null;
                map = jSONObject;
            }
            if (obj.f18354a.equals(map.optString("ads_id", "")) != null) {
                com_google_android_gms_internal_zzanh.mo3992b("/nativeAdPreProcess", com_google_android_gms_internal_zzyl.f8153a);
                obj = new JSONObject();
                obj.put("success", z);
                obj.put("json", map);
                com_google_android_gms_internal_zzalf.m13330b(obj);
            }
        } catch (Object obj2) {
            zzakb.m5367b("Error while preprocessing json.", obj2);
            com_google_android_gms_internal_zzalf.m13329a(obj2);
        }
    }
}
