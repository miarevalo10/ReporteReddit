package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzad implements zzt<Object> {
    public final Object f13728a = new Object();
    public final Map<String, zzae> f13729b = new HashMap();

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("result");
        synchronized (this.f13728a) {
            zzae com_google_android_gms_ads_internal_gmsg_zzae = (zzae) this.f13729b.remove(str);
            if (com_google_android_gms_ads_internal_gmsg_zzae == null) {
                str4 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                zzakb.m5371e(str.length() != 0 ? str4.concat(str) : new String(str4));
                return;
            } else if (!TextUtils.isEmpty(str2)) {
                com_google_android_gms_ads_internal_gmsg_zzae.mo2160a(str3);
                return;
            } else if (str4 == null) {
                com_google_android_gms_ads_internal_gmsg_zzae.mo2161a(null);
                return;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    if (zzagf.m13279a()) {
                        str4 = "Result GMSG: ";
                        str2 = String.valueOf(jSONObject.toString(2));
                        zzagf.m13278a(str2.length() != 0 ? str4.concat(str2) : new String(str4));
                    }
                    com_google_android_gms_ads_internal_gmsg_zzae.mo2161a(jSONObject);
                } catch (JSONException e) {
                    com_google_android_gms_ads_internal_gmsg_zzae.mo2160a(e.getMessage());
                }
            }
        }
    }
}
