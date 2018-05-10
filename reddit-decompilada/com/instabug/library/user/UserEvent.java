package com.instabug.library.user;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserEvent {
    private static final String EVENT = "event";
    private static final String PARAMS = "params";
    private static final String TIMESTAMP = "timestamp";
    private long date;
    private String eventIdentifier;
    private List<UserEventParam> params = new ArrayList();

    public String getEventIdentifier() {
        return this.eventIdentifier;
    }

    public UserEvent setEventIdentifier(String str) {
        this.eventIdentifier = str;
        return this;
    }

    public long getDate() {
        return this.date;
    }

    public UserEvent setDate(long j) {
        this.date = j;
        return this;
    }

    public List<UserEventParam> getParams() {
        return this.params;
    }

    public UserEvent addParam(UserEventParam userEventParam) {
        this.params.add(userEventParam);
        return this;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(EVENT, getEventIdentifier());
        jSONObject.put(TIMESTAMP, getDate());
        JSONObject jSONObject2 = new JSONObject();
        for (UserEventParam userEventParam : getParams()) {
            jSONObject2.put(userEventParam.getKey(), userEventParam.getValue());
        }
        jSONObject.put(PARAMS, jSONObject2);
        return jSONObject;
    }

    public static JSONArray toJson(List<UserEvent> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (UserEvent toJson : list) {
            jSONArray.put(toJson.toJson());
        }
        return jSONArray;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0070;
    L_0x0003:
        r1 = r5 instanceof com.instabug.library.user.UserEvent;
        if (r1 == 0) goto L_0x0070;
    L_0x0007:
        r5 = (com.instabug.library.user.UserEvent) r5;
        r1 = r5.getEventIdentifier();
        r1 = java.lang.String.valueOf(r1);
        r2 = r4.getEventIdentifier();
        r2 = java.lang.String.valueOf(r2);
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x006f;
    L_0x001f:
        r1 = r5.getDate();
        r1 = java.lang.String.valueOf(r1);
        r2 = r4.getDate();
        r2 = java.lang.String.valueOf(r2);
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x006f;
    L_0x0035:
        r1 = r5.getParams();
        r1 = r1.size();
        r2 = r4.getParams();
        r2 = r2.size();
        if (r1 != r2) goto L_0x006e;
    L_0x0047:
        r1 = r0;
    L_0x0048:
        r2 = r4.params;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x006c;
    L_0x0050:
        r2 = r5.getParams();
        r2 = r2.get(r1);
        r2 = (com.instabug.library.user.UserEventParam) r2;
        r3 = r4.getParams();
        r3 = r3.get(r1);
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0069;
    L_0x0068:
        return r0;
    L_0x0069:
        r1 = r1 + 1;
        goto L_0x0048;
    L_0x006c:
        r5 = 1;
        return r5;
    L_0x006e:
        return r0;
    L_0x006f:
        return r0;
    L_0x0070:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.user.UserEvent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (getEventIdentifier() == null) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDate());
        stringBuilder.append(": ");
        stringBuilder.append(getEventIdentifier());
        return String.valueOf(stringBuilder.toString()).hashCode();
    }
}
