package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@zzzv
public final class zzafs {
    public final long f6338a;
    public final Map<String, zzui> f6339b = new HashMap();
    public String f6340c;
    public String f6341d;
    public boolean f6342e = false;
    private final List<String> f6343f = new ArrayList();
    private final List<String> f6344g = new ArrayList();

    public zzafs(String str, long j) {
        this.f6341d = str;
        this.f6338a = j;
        m5112a(str);
    }

    private final void m5112a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = 0;
                if (jSONObject.optInt("status", -1) != 1) {
                    this.f6342e = false;
                    zzakb.m5371e("App settings could not be fetched successfully.");
                    return;
                }
                this.f6342e = true;
                this.f6340c = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    while (i < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("format");
                        CharSequence optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.f6344g.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString)) {
                                    jSONObject2 = jSONObject2.optJSONObject("mediation_config");
                                    if (jSONObject2 != null) {
                                        this.f6339b.put(optString2, new zzui(jSONObject2));
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
                m5113a(jSONObject);
            } catch (Throwable e) {
                zzakb.m5369c("Exception occurred while processing app setting json", e);
                zzbs.m4490i().m13246a(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    private final void m5113a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("persistable_banner_ad_unit_ids");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f6343f.add(optJSONArray.optString(i));
            }
        }
    }
}
