package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzui {
    public final List<zzuh> f8065a;
    public final long f8066b;
    public final List<String> f8067c;
    public final List<String> f8068d;
    public final List<String> f8069e;
    public final List<String> f8070f;
    public final boolean f8071g;
    public final String f8072h;
    public final long f8073i;
    public final String f8074j;
    public final int f8075k;
    public final int f8076l;
    public final long f8077m;
    public final boolean f8078n;
    public final boolean f8079o;
    public final boolean f8080p;
    public int f8081q;
    public int f8082r;
    public boolean f8083s;

    public zzui(String str) throws JSONException {
        this(new JSONObject(str));
    }

    public zzui(List<zzuh> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str) {
        this.f8065a = list;
        this.f8066b = j;
        this.f8067c = list2;
        this.f8068d = list3;
        this.f8069e = list4;
        this.f8070f = list5;
        this.f8071g = z;
        this.f8072h = str;
        this.f8073i = -1;
        this.f8081q = 0;
        this.f8082r = 1;
        this.f8074j = null;
        this.f8075k = 0;
        this.f8076l = -1;
        this.f8077m = -1;
        this.f8078n = false;
        this.f8079o = false;
        this.f8080p = false;
        this.f8083s = false;
    }

    public zzui(JSONObject jSONObject) throws JSONException {
        if (zzakb.m5365a(2)) {
            String str = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzagf.m13278a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzuh com_google_android_gms_internal_zzuh = new zzuh(jSONArray.getJSONObject(i2));
            if (com_google_android_gms_internal_zzuh.m6670a()) {
                this.f8083s = true;
            }
            arrayList.add(com_google_android_gms_internal_zzuh);
            if (i < 0 && m6672a(com_google_android_gms_internal_zzuh)) {
                i = i2;
            }
        }
        this.f8081q = i;
        this.f8082r = jSONArray.length();
        this.f8065a = Collections.unmodifiableList(arrayList);
        this.f8072h = jSONObject.optString("qdata");
        this.f8076l = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.f8077m = jSONObject.optLong("timeout_ms", -1);
        jSONObject = jSONObject.optJSONObject("settings");
        if (jSONObject != null) {
            this.f8066b = jSONObject.optLong("ad_network_timeout_millis", -1);
            zzbs.m4503v();
            this.f8067c = zzuq.m6685a(jSONObject, "click_urls");
            zzbs.m4503v();
            this.f8068d = zzuq.m6685a(jSONObject, "imp_urls");
            zzbs.m4503v();
            this.f8069e = zzuq.m6685a(jSONObject, "nofill_urls");
            zzbs.m4503v();
            this.f8070f = zzuq.m6685a(jSONObject, "remote_ping_urls");
            this.f8071g = jSONObject.optBoolean("render_in_browser", false);
            long optLong = jSONObject.optLong("refresh", -1);
            if (optLong > 0) {
                j = 1000 * optLong;
            }
            this.f8073i = j;
            zzaeq a = zzaeq.m17778a(jSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f8074j = null;
                this.f8075k = 0;
            } else {
                this.f8074j = a.f17534a;
                this.f8075k = a.f17535b;
            }
            this.f8078n = jSONObject.optBoolean("use_displayed_impression", false);
            this.f8079o = jSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.f8080p = jSONObject.optBoolean("allow_pub_owned_ad_view", false);
            return;
        }
        this.f8066b = -1;
        this.f8067c = null;
        this.f8068d = null;
        this.f8069e = null;
        this.f8070f = null;
        this.f8073i = -1;
        this.f8074j = null;
        this.f8075k = 0;
        this.f8078n = false;
        this.f8071g = false;
        this.f8079o = false;
        this.f8080p = false;
    }

    private static boolean m6672a(zzuh com_google_android_gms_internal_zzuh) {
        for (String equals : com_google_android_gms_internal_zzuh.f8048c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
