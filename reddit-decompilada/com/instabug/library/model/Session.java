package com.instabug.library.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import org.json.JSONException;
import org.json.JSONObject;

public class Session implements Cacheable {
    public int f15524a;
    public long f15525b;
    public long f15526c;
    public String f15527d;
    public String f15528e;

    public enum SessionState {
        START,
        RESUME,
        FINISH
    }

    public Session(int i, long j, long j2, String str, String str2) {
        this.f15524a = i;
        this.f15525b = j;
        this.f15526c = j2;
        this.f15527d = str;
        this.f15528e = str2;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f15524a).put("started_at", this.f15525b).put(State.KEY_DURATION, this.f15526c).put(State.KEY_USER_EVENTS, this.f15527d).put(State.KEY_USER_ATTRIBUTES, this.f15528e);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id") != null) {
            this.f15524a = jSONObject.getInt("id");
        }
        if (jSONObject.has("started_at") != null) {
            this.f15525b = jSONObject.getLong("started_at");
        }
        if (jSONObject.has(State.KEY_DURATION) != null) {
            this.f15526c = jSONObject.getLong(State.KEY_DURATION);
        }
        if (jSONObject.has(State.KEY_USER_EVENTS) != null) {
            this.f15527d = jSONObject.getString(State.KEY_USER_EVENTS);
        }
        if (jSONObject.has(State.KEY_USER_ATTRIBUTES) != null) {
            this.f15528e = jSONObject.getString(State.KEY_USER_ATTRIBUTES);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("id: ");
        stringBuilder.append(this.f15524a);
        stringBuilder.append(", startedAt: ");
        stringBuilder.append(this.f15525b);
        stringBuilder.append(", duration: ");
        stringBuilder.append(this.f15526c);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if (session.f15524a == this.f15524a && session.f15525b == this.f15525b && session.f15526c == this.f15526c && String.valueOf(session.f15527d).equals(String.valueOf(this.f15527d)) && String.valueOf(session.f15528e).equals(String.valueOf(this.f15528e)) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f15524a;
    }
}
