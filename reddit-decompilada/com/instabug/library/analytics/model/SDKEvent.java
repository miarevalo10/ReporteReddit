package com.instabug.library.analytics.model;

import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SDKEvent {
    private static final String KEY_EVENT_NAME = "event_name";
    private static final String KEY_EXTRA_ATTRIBUTES = "extra_attributes";
    private static final String KEY_TIME_STAMP = "time_stamp";
    private String eventName;
    private ArrayList<ExtraAttribute> extraAttributes;
    private long timeStamp;

    public static class ExtraAttribute {
        private static final String KEY_KEY = "key";
        private static final String KEY_VALUE = "value";
        private String key;
        private String value;

        public String getKey() {
            return this.key;
        }

        public ExtraAttribute setKey(String str) {
            this.key = str;
            return this;
        }

        public String getValue() {
            return this.value;
        }

        public ExtraAttribute setValue(String str) {
            this.value = str;
            return this;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_KEY, getKey()).put(KEY_VALUE, getValue());
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(SDKEvent.class, e.getMessage(), e);
            }
            return jSONObject;
        }

        public static ExtraAttribute fromJson(JSONObject jSONObject) {
            ExtraAttribute extraAttribute = new ExtraAttribute();
            try {
                if (jSONObject.has(KEY_KEY)) {
                    extraAttribute.setKey(jSONObject.getString(KEY_KEY));
                }
                if (jSONObject.has(KEY_VALUE)) {
                    extraAttribute.setValue(jSONObject.getString(KEY_VALUE));
                }
            } catch (JSONObject jSONObject2) {
                InstabugSDKLogger.m8358e(SDKEvent.class, jSONObject2.getMessage(), jSONObject2);
            }
            return extraAttribute;
        }

        public static JSONArray toJson(ArrayList<ExtraAttribute> arrayList) {
            JSONArray jSONArray = new JSONArray();
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                jSONArray.put(((ExtraAttribute) arrayList.next()).toJson());
            }
            return jSONArray;
        }

        public static ArrayList<ExtraAttribute> fromJson(JSONArray jSONArray) {
            ArrayList<ExtraAttribute> arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(fromJson(jSONArray.getJSONObject(i)));
                } catch (Throwable e) {
                    InstabugSDKLogger.m8358e(SDKEvent.class, e.getMessage(), e);
                }
            }
            return arrayList;
        }
    }

    public String getEventName() {
        return this.eventName;
    }

    public SDKEvent setEventName(String str) {
        this.eventName = str;
        return this;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public SDKEvent setTimeStamp(long j) {
        this.timeStamp = j;
        return this;
    }

    public ArrayList<ExtraAttribute> getExtraAttributes() {
        return this.extraAttributes;
    }

    public SDKEvent setExtraAttributes(ArrayList<ExtraAttribute> arrayList) {
        this.extraAttributes = arrayList;
        return this;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_TIME_STAMP, getTimeStamp()).put(KEY_EVENT_NAME, getEventName()).put(KEY_EXTRA_ATTRIBUTES, ExtraAttribute.toJson(getExtraAttributes()));
        } catch (Throwable e) {
            InstabugSDKLogger.m8358e(SDKEvent.class, e.getMessage(), e);
        }
        return jSONObject;
    }

    public static JSONArray toJson(ArrayList<SDKEvent> arrayList) {
        JSONArray jSONArray = new JSONArray();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            jSONArray.put(((SDKEvent) arrayList.next()).toJson());
        }
        return jSONArray;
    }
}
