package com.instabug.chat.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReadMessage */
public class C1309d implements Cacheable {
    public String f15392a;
    public long f15393b;
    public String f15394c;

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("chat_number", this.f15392a).put("message_id", this.f15394c).put("read_at", this.f15393b);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("chat_number") != null) {
            this.f15392a = jSONObject.getString("chat_number");
        }
        if (jSONObject.has("message_id") != null) {
            this.f15394c = jSONObject.getString("message_id");
        }
        if (jSONObject.has("read_at") != null) {
            this.f15393b = jSONObject.getLong("read_at");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1309d)) {
            return false;
        }
        C1309d c1309d = (C1309d) obj;
        if (String.valueOf(c1309d.f15392a).equals(String.valueOf(this.f15392a)) && String.valueOf(c1309d.f15394c).equals(String.valueOf(this.f15394c)) && c1309d.f15393b == this.f15393b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f15392a.hashCode();
    }
}
