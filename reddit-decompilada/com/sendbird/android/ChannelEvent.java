package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.Hashtable;
import java.util.Map.Entry;

class ChannelEvent {
    protected JsonObject f22567a;
    int f22568b;
    String f22569c;
    String f22570d;
    private Hashtable<String, JsonElement> f22571e;

    public ChannelEvent(JsonElement jsonElement) {
        this.f22567a = jsonElement.m25073h();
        this.f22568b = this.f22567a.m31129a("cat") != null ? this.f22567a.m31130b("cat").mo5247f() : null;
        this.f22571e = new Hashtable();
        jsonElement = this.f22567a.m31129a("data") != null ? this.f22567a.m31130b("data").m25073h() : null;
        if (jsonElement != null) {
            for (Entry entry : jsonElement.f30235a.entrySet()) {
                this.f22571e.put(entry.getKey(), entry.getValue());
            }
        }
        this.f22569c = this.f22567a.m31129a("channel_url") != null ? this.f22567a.m31130b("channel_url").mo5244c() : "";
        this.f22570d = this.f22567a.m31129a("channel_type") != null ? this.f22567a.m31130b("channel_type").mo5244c() : "group";
    }

    public final JsonElement m24882a() {
        return this.f22567a.m31129a("data") ? this.f22567a.m31130b("data").m25073h() : null;
    }

    public final boolean m24883b() {
        return this.f22570d.equals("open");
    }
}
