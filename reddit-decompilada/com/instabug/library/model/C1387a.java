package com.instabug.library.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConsoleLog */
public class C1387a implements Cacheable, Serializable {
    String f15529a;
    long f15530b;

    public static ArrayList<C1387a> m15444a(JSONArray jSONArray) throws JSONException {
        ArrayList<C1387a> arrayList = new ArrayList();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                C1387a c1387a = new C1387a();
                c1387a.fromJson(jSONArray.getJSONObject(i).toString());
                arrayList.add(c1387a);
            }
        }
        return arrayList;
    }

    public static JSONArray m15445a(ArrayList<C1387a> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                try {
                    jSONArray.put(new JSONObject(((C1387a) arrayList.next()).toJson()));
                } catch (JSONException e) {
                    InstabugSDKLogger.m8360v(C1387a.class, e.toString());
                }
            }
        }
        return jSONArray;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", this.f15530b);
        jSONObject.put("message", this.f15529a);
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("timestamp") != null) {
            if (StringUtility.isNumeric(jSONObject.getString("timestamp")) != null) {
                this.f15530b = jSONObject.getLong("timestamp");
            } else {
                this.f15530b = C1387a.m15443a(jSONObject.getString("timestamp"));
            }
        }
        if (jSONObject.has("message") != null) {
            this.f15529a = jSONObject.getString("message");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConsoleLog{timeStamp='");
        stringBuilder.append(this.f15530b);
        stringBuilder.append('\'');
        stringBuilder.append(", message='");
        stringBuilder.append(this.f15529a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static long m15443a(String str) {
        try {
            Date parse = new SimpleDateFormat(InstabugLog.LOG_MESSAGE_DATE_FORMAT, Locale.US).parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            Calendar instance2 = Calendar.getInstance();
            instance2.set(2, instance.get(2));
            instance2.set(5, instance.get(5));
            instance2.set(11, instance.get(11));
            instance2.set(12, instance.get(12));
            instance2.set(13, instance.get(13));
            instance2.set(14, instance.get(14));
            return instance2.getTimeInMillis();
        } catch (ParseException e) {
            StringBuilder stringBuilder = new StringBuilder("parsing error happened when trying to parse Console log message date: ");
            stringBuilder.append(str);
            stringBuilder.append(", error message: ");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8361w(C1387a.class, stringBuilder.toString());
            return 0;
        }
    }
}
