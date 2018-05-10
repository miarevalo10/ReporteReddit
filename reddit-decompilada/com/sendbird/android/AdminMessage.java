package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

public final class AdminMessage extends BaseMessage {
    boolean f30032a;
    private String f30033g = "";
    private String f30034h = "";
    private String f30035i = "";

    static JsonElement m30926a(long j, String str, String str2, String str3, String str4, String str5, long j2, long j3) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31127a("msg_id", Long.valueOf(j));
        jsonObject.m31128a("channel_url", str);
        jsonObject.m31128a("channel_type", str2);
        jsonObject.m31127a("ts", Long.valueOf(j2));
        jsonObject.m31127a("updated_at", Long.valueOf(j3));
        jsonObject.m31128a("message", str3);
        if (str4 != null) {
            jsonObject.m31128a("data", str4);
        }
        if (str5 != null) {
            jsonObject.m31128a("custom_type", str5);
        }
        return jsonObject;
    }

    AdminMessage(JsonElement jsonElement) {
        super(jsonElement);
        boolean z = false;
        this.f30032a = false;
        jsonElement = jsonElement.m25073h();
        this.f30033g = jsonElement.m31130b("message").mo5244c();
        this.f30034h = jsonElement.m31129a("data") ? jsonElement.m31130b("data").mo5244c() : "";
        this.f30035i = jsonElement.m31129a("custom_type") ? jsonElement.m31130b("custom_type").mo5244c() : "";
        if (jsonElement.m31129a("silent") && jsonElement.m31130b("silent").mo5248g() != null) {
            z = true;
        }
        this.f30032a = z;
    }

    final JsonElement mo5214a() {
        JsonElement h = super.mo5214a().m25073h();
        h.m31128a("type", "ADMM");
        h.m31128a("message", this.f30033g);
        h.m31128a("data", this.f30034h);
        h.m31128a("custom_type", this.f30035i);
        return h;
    }

    public final String m30928b() {
        return this.f30033g;
    }

    public final String m30929c() {
        return this.f30034h;
    }

    public final String m30930d() {
        return this.f30035i;
    }
}
