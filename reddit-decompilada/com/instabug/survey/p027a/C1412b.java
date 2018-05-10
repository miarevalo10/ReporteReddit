package com.instabug.survey.p027a;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Question */
public class C1412b implements Cacheable, Serializable {
    public long f15565a = -1;
    public String f15566b;
    public C0788a f15567c = C0788a.NOT_AVAILABLE;
    public ArrayList<String> f15568d;
    public String f15569e;
    public long f15570f;

    /* compiled from: Question */
    public enum C0788a {
        TEXT(0),
        MCQ(1),
        STAR_RATE(2),
        NPS(3),
        NOT_AVAILABLE(-1);
        
        int f9954f;

        private C0788a(int i) {
            this.f9954f = i;
        }
    }

    public static ArrayList<C1412b> m15473a(JSONArray jSONArray) throws JSONException {
        ArrayList<C1412b> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            C1412b c1412b = new C1412b();
            c1412b.fromJson(jSONArray.getJSONObject(i).toString());
            arrayList.add(c1412b);
        }
        return arrayList;
    }

    public static JSONArray m15474a(ArrayList<C1412b> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(new JSONObject(((C1412b) arrayList.get(i)).toJson()));
        }
        return jSONArray;
    }

    public final void m15475a(String str) {
        this.f15569e = str;
        this.f15570f = System.currentTimeMillis() / 1000;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15565a).put("title", this.f15566b).put("type", this.f15567c.f9954f).put("options", new JSONArray(this.f15568d)).put("answer", this.f15569e).put("answered_at", this.f15570f);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        InstabugSDKLogger.m8356d(this, str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15565a = jSONObject.getLong("id");
        }
        if (jSONObject.has("title") != null) {
            this.f15566b = jSONObject.getString("title");
        }
        if (jSONObject.has("type") != null) {
            switch (jSONObject.getInt("type")) {
                case null:
                    this.f15567c = C0788a.TEXT;
                    break;
                case 1:
                    this.f15567c = C0788a.MCQ;
                    break;
                case 2:
                    this.f15567c = C0788a.STAR_RATE;
                    break;
                case 3:
                    this.f15567c = C0788a.NPS;
                    break;
                default:
                    break;
            }
        }
        if (jSONObject.has("options") != null) {
            str = jSONObject.getJSONArray("options");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < str.length(); i++) {
                arrayList.add(str.getString(i));
            }
            this.f15568d = arrayList;
        }
        if (jSONObject.has("answer") != null) {
            m15475a(jSONObject.getString("answer"));
        }
        if (jSONObject.has("answered_at") != null) {
            this.f15570f = jSONObject.getLong("answered_at");
        }
    }
}
