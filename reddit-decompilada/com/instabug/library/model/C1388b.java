package com.instabug.library.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserAttributes */
public class C1388b implements Cacheable, Serializable {
    public HashMap<String, String> f15531a;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.f15531a.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        str = jSONObject.keys();
        this.f15531a = new HashMap();
        while (str.hasNext()) {
            String str2 = (String) str.next();
            this.f15531a.put(str2, jSONObject.optString(str2));
        }
    }

    public String toString() {
        try {
            StringBuilder stringBuilder = new StringBuilder("userAttributesMap = ");
            stringBuilder.append(toJson());
            return stringBuilder.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
