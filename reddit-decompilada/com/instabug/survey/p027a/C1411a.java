package com.instabug.survey.p027a;

import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Condition */
public class C1411a implements Cacheable, Serializable {
    public String f15562a;
    public String f15563b;
    public String f15564c;

    public static JSONArray m15472a(ArrayList<C1411a> arrayList) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(new JSONObject(((C1411a) arrayList.get(i)).toJson()));
        }
        return jSONArray;
    }

    public static ArrayList<C1411a> m15471a(JSONArray jSONArray) throws JSONException {
        ArrayList<C1411a> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            C1411a c1411a = new C1411a();
            c1411a.fromJson(jSONArray.getJSONObject(i).toString());
            arrayList.add(c1411a);
        }
        return arrayList;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.f15562a).put("value", this.f15563b).put("operator", this.f15564c);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("key") != null) {
            this.f15562a = jSONObject.getString("key");
        }
        if (jSONObject.has("value") != null) {
            this.f15563b = jSONObject.getString("value");
        }
        if (jSONObject.has("operator") != null) {
            this.f15564c = jSONObject.getString("operator");
        }
    }
}
