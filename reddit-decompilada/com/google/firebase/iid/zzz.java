package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class zzz {
    private static final long f8691b = TimeUnit.DAYS.toMillis(7);
    final String f8692a;
    private String f8693c;
    private long f8694d;

    private zzz(String str, String str2, long j) {
        this.f8692a = str;
        this.f8693c = str2;
        this.f8694d = j;
    }

    static zzz m7431a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzz(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzz(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(str).length());
            stringBuilder.append("Failed to parse token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    static String m7432a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(24 + String.valueOf(str).length());
            stringBuilder.append("Failed to encode token: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    final boolean m7433b(String str) {
        if (System.currentTimeMillis() <= this.f8694d + f8691b) {
            if (str.equals(this.f8693c)) {
                return false;
            }
        }
        return true;
    }
}
