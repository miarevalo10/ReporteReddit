package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;

public final class ReadStatus {
    User f22703a;
    long f22704b;
    String f22705c;
    private String f22706d;

    ReadStatus(JsonElement jsonElement) {
        jsonElement = jsonElement.m25073h();
        this.f22703a = new User(jsonElement.m31130b("user"));
        this.f22704b = jsonElement.m31130b("ts").mo5246e();
        this.f22705c = jsonElement.m31129a("channel_url") ? jsonElement.m31130b("channel_url").mo5244c() : "";
        this.f22706d = jsonElement.m31129a("channel_type") ? jsonElement.m31130b("channel_type").mo5244c() : "group";
    }
}
