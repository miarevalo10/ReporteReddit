package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONObject;

@zzzv
public final class zzacn {
    final List<String> f6149a;
    final String f6150b;
    final String f6151c;
    final String f6152d;
    final boolean f6153e;
    final String f6154f;
    final String f6155g;
    String f6156h;
    final int f6157i;
    final boolean f6158j;
    private final JSONObject f6159k;

    public zzacn(int i, Map<String, String> map) {
        this.f6156h = (String) map.get(UpdateFragment.FRAGMENT_URL);
        this.f6150b = (String) map.get("base_uri");
        this.f6151c = (String) map.get("post_parameters");
        this.f6153e = m5004a((String) map.get("drt_include"));
        this.f6154f = (String) map.get("request_id");
        this.f6152d = (String) map.get("type");
        this.f6149a = m5005b((String) map.get("errors"));
        this.f6157i = i;
        this.f6155g = (String) map.get("fetched_ad");
        this.f6158j = m5004a((String) map.get("render_test_ad_label"));
        this.f6159k = new JSONObject();
    }

    public zzacn(JSONObject jSONObject) {
        this.f6156h = jSONObject.optString(UpdateFragment.FRAGMENT_URL);
        this.f6150b = jSONObject.optString("base_uri");
        this.f6151c = jSONObject.optString("post_parameters");
        this.f6153e = m5004a(jSONObject.optString("drt_include"));
        this.f6154f = jSONObject.optString("request_id");
        this.f6152d = jSONObject.optString("type");
        this.f6149a = m5005b(jSONObject.optString("errors"));
        int i = 1;
        if (jSONObject.optInt("valid", 0) == 1) {
            i = -2;
        }
        this.f6157i = i;
        this.f6155g = jSONObject.optString("fetched_ad");
        this.f6158j = jSONObject.optBoolean("render_test_ad_label");
        jSONObject = jSONObject.optJSONObject("preprocessor_flags");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f6159k = jSONObject;
    }

    private static boolean m5004a(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private static List<String> m5005b(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }
}
