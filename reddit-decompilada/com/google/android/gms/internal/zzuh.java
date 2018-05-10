package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzuh {
    public final String f8046a;
    public final String f8047b;
    public final List<String> f8048c;
    public final String f8049d;
    public final String f8050e;
    public final List<String> f8051f;
    public final List<String> f8052g;
    public final List<String> f8053h;
    public final List<String> f8054i;
    public final String f8055j;
    public final List<String> f8056k;
    public final List<String> f8057l;
    public final String f8058m;
    public final String f8059n;
    public final String f8060o;
    public final List<String> f8061p;
    public final String f8062q;
    public final long f8063r;
    private String f8064s;

    public zzuh(String str, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str2, List<String> list5, List<String> list6, List<String> list7) {
        this.f8046a = str;
        this.f8047b = null;
        this.f8048c = list;
        this.f8049d = null;
        this.f8050e = null;
        this.f8051f = list2;
        this.f8052g = list3;
        this.f8053h = list4;
        this.f8055j = str2;
        this.f8056k = list5;
        this.f8057l = list6;
        this.f8058m = null;
        this.f8059n = null;
        this.f8060o = null;
        this.f8061p = null;
        this.f8062q = null;
        this.f8054i = list7;
        this.f8064s = null;
        this.f8063r = -1;
    }

    public zzuh(JSONObject jSONObject) throws JSONException {
        List a;
        this.f8047b = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f8048c = Collections.unmodifiableList(arrayList);
        this.f8049d = jSONObject.optString("allocation_id", null);
        zzbs.m4503v();
        this.f8051f = zzuq.m6685a(jSONObject, "clickurl");
        zzbs.m4503v();
        this.f8052g = zzuq.m6685a(jSONObject, "imp_urls");
        zzbs.m4503v();
        this.f8054i = zzuq.m6685a(jSONObject, "fill_urls");
        zzbs.m4503v();
        this.f8056k = zzuq.m6685a(jSONObject, "video_start_urls");
        zzbs.m4503v();
        this.f8057l = zzuq.m6685a(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzbs.m4503v();
            a = zzuq.m6685a(optJSONObject, "manual_impression_urls");
        } else {
            a = null;
        }
        this.f8053h = a;
        this.f8046a = optJSONObject != null ? optJSONObject.toString() : null;
        optJSONObject = jSONObject.optJSONObject("data");
        this.f8055j = optJSONObject != null ? optJSONObject.toString() : null;
        this.f8050e = optJSONObject != null ? optJSONObject.optString("class_name") : null;
        this.f8058m = jSONObject.optString("html_template", null);
        this.f8059n = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f8060o = optJSONObject != null ? optJSONObject.toString() : null;
        zzbs.m4503v();
        this.f8061p = zzuq.m6685a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        this.f8062q = optJSONObject != null ? optJSONObject.toString() : null;
        this.f8064s = jSONObject.optString("response_type", null);
        this.f8063r = jSONObject.optLong("ad_network_timeout_millis", -1);
    }

    public final boolean m6670a() {
        return "banner".equalsIgnoreCase(this.f8064s);
    }

    public final boolean m6671b() {
        return "native".equalsIgnoreCase(this.f8064s);
    }
}
