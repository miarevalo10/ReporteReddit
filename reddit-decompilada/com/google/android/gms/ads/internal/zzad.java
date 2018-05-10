package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakg;
import com.google.android.gms.internal.zzakl;
import com.google.android.gms.internal.zzakv;
import org.json.JSONObject;

final /* synthetic */ class zzad implements zzakg {
    private final zzac f13761a;

    zzad(zzac com_google_android_gms_ads_internal_zzac) {
        this.f13761a = com_google_android_gms_ads_internal_zzac;
    }

    public final zzakv mo1516a(Object obj) {
        zzac com_google_android_gms_ads_internal_zzac = this.f13761a;
        JSONObject jSONObject = (JSONObject) obj;
        if (!jSONObject.optBoolean("isSuccessful", false)) {
            return zzakl.m5377a(null);
        }
        return zzbs.m4490i().m13236a(com_google_android_gms_ads_internal_zzac.f5497a, jSONObject.getString("appSettingsJson"));
    }
}
