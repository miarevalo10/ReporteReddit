package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

class UserEvent {
    int f22865a;
    private JsonObject f22866b;

    UserEvent(JsonElement jsonElement) {
        this.f22866b = jsonElement.m25073h();
        this.f22865a = this.f22866b.m31129a("cat") != null ? this.f22866b.m31130b("cat").mo5247f() : null;
    }

    final JsonElement m25024a() {
        return this.f22866b.m31129a("data") ? this.f22866b.m31130b("data").m25073h() : null;
    }
}
