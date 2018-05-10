package com.instabug.survey.p027a;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Survey */
public class C1413c implements Cacheable, Serializable {
    public long f15571a;
    public String f15572b;
    public ArrayList<C1412b> f15573c;
    public ArrayList<C1411a> f15574d = new ArrayList();
    public ArrayList<C1411a> f15575e = new ArrayList();
    public ArrayList<C1411a> f15576f;
    public String f15577g = "and";
    public boolean f15578h = false;
    public boolean f15579i = false;
    public long f15580j;
    public boolean f15581k = false;
    private String f15582l;

    public static List<C1413c> m15476a(JSONArray jSONArray) throws JSONException {
        List<C1413c> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            C1413c c1413c = new C1413c();
            c1413c.fromJson(jSONObject.toString());
            arrayList.add(c1413c);
        }
        return arrayList;
    }

    public final void m15477a() {
        this.f15580j = System.currentTimeMillis();
        this.f15581k = true;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15571a).put("title", this.f15582l).put("token", this.f15572b).put("questions", C1412b.m15474a(this.f15573c)).put("target", new JSONObject().put("primitive_types", C1411a.m15472a(this.f15574d)).put("custom_attributes", C1411a.m15472a(this.f15575e)).put(State.KEY_USER_EVENTS, C1411a.m15472a(this.f15576f)).put("operator", this.f15577g)).put("answered", this.f15578h).put("submitted", this.f15579i).put("dismissed_at", this.f15580j).put("submitted", this.f15579i).put("is_cancelled", this.f15581k);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15571a = jSONObject.getLong("id");
        }
        if (jSONObject.has("title") != null) {
            this.f15582l = jSONObject.getString("title");
        }
        if (jSONObject.has("token") != null) {
            this.f15572b = jSONObject.getString("token");
        }
        if (jSONObject.has("questions") != null) {
            this.f15573c = C1412b.m15473a(jSONObject.getJSONArray("questions"));
        } else if (jSONObject.has("question") != null) {
            InstabugSDKLogger.m8356d(this, "Migrating old surveys");
            str = new C1412b();
            str.f15565a = this.f15571a;
            str.fromJson(jSONObject.get("question").toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.f15573c = arrayList;
        }
        if (jSONObject.has("target") != null) {
            str = jSONObject.getJSONObject("target");
            if (str.has("primitive_types")) {
                this.f15574d = C1411a.m15471a(str.getJSONArray("primitive_types"));
            }
            if (str.has("custom_attributes")) {
                this.f15575e = C1411a.m15471a(str.getJSONArray("custom_attributes"));
            }
            if (str.has(State.KEY_USER_EVENTS)) {
                this.f15576f = C1411a.m15471a(str.getJSONArray(State.KEY_USER_EVENTS));
            }
            if (str.has("operator")) {
                this.f15577g = str.getString("operator");
            }
        }
        if (jSONObject.has("answered") != null) {
            this.f15578h = jSONObject.getBoolean("answered");
        }
        if (jSONObject.has("submitted") != null) {
            this.f15579i = jSONObject.getBoolean("submitted");
        }
        if (jSONObject.has("is_cancelled") != null) {
            this.f15581k = jSONObject.getBoolean("is_cancelled");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0014;
    L_0x0003:
        r1 = r6 instanceof com.instabug.survey.p027a.C1413c;
        if (r1 == 0) goto L_0x0014;
    L_0x0007:
        r6 = (com.instabug.survey.p027a.C1413c) r6;
        r1 = r6.f15571a;
        r3 = r5.f15571a;
        r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r6 != 0) goto L_0x0013;
    L_0x0011:
        r6 = 1;
        return r6;
    L_0x0013:
        return r0;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.a.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return String.valueOf(this.f15571a).hashCode();
    }
}
