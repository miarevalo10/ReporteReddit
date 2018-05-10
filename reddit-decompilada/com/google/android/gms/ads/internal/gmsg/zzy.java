package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzalf;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzy implements zzt<Object> {
    public HashMap<String, zzalf<JSONObject>> f13737a = new HashMap();

    public final void m12746a(String str) {
        zzalf com_google_android_gms_internal_zzalf = (zzalf) this.f13737a.get(str);
        if (com_google_android_gms_internal_zzalf == null) {
            zzakb.m5368c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!com_google_android_gms_internal_zzalf.isDone()) {
            com_google_android_gms_internal_zzalf.cancel(true);
        }
        this.f13737a.remove(str);
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("request_id");
        String str2 = (String) map.get("fetched_ad");
        zzakb.m5366b("Received ad from the cache.");
        zzalf com_google_android_gms_internal_zzalf = (zzalf) this.f13737a.get(str);
        if (com_google_android_gms_internal_zzalf == null) {
            zzakb.m5368c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            com_google_android_gms_internal_zzalf.m13330b(new JSONObject(str2));
        } catch (Throwable e) {
            zzakb.m5367b("Failed constructing JSON object from value passed from javascript", e);
            com_google_android_gms_internal_zzalf.m13330b(null);
        } finally {
            this.f13737a.remove(str);
        }
    }
}
