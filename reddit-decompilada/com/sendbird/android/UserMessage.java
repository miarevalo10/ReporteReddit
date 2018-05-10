package com.sendbird.android;

import com.sendbird.android.SendBird.Options;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map.Entry;

public final class UserMessage extends BaseMessage {
    User f30210a;
    private String f30211g = "";
    private String f30212h = "";
    private String f30213i = "";
    private String f30214j = "";
    private HashMap<String, String> f30215k;

    static JsonElement m31079a(String str, long j, User user, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3) {
        JsonElement jsonObject = new JsonObject();
        jsonObject.m31128a("req_id", str);
        jsonObject.m31127a("msg_id", Long.valueOf(j));
        jsonObject.m31128a("channel_url", str2);
        jsonObject.m31128a("channel_type", str3);
        jsonObject.m31127a("ts", Long.valueOf(j2));
        jsonObject.m31127a("updated_at", Long.valueOf(j3));
        jsonObject.m31128a("message", str4);
        if (str5 != null) {
            jsonObject.m31128a("data", str5);
        }
        if (str6 != null) {
            jsonObject.m31128a("custom_type", str6);
        }
        if (str7 != null) {
            j = new JsonParser();
            jsonObject.m31125a("translations", JsonParser.m25078a(str7));
        }
        JsonElement jsonObject2 = new JsonObject();
        jsonObject2.m31128a("user_id", user.f22858c);
        jsonObject2.m31128a("nickname", user.f22859d);
        jsonObject2.m31128a("profile_url", user.f22860e);
        jsonObject.m31125a("user", jsonObject2);
        return jsonObject;
    }

    UserMessage(JsonElement jsonElement) {
        super(jsonElement);
        jsonElement = jsonElement.m25073h();
        this.f30211g = jsonElement.m31130b("message").mo5244c();
        this.f30212h = jsonElement.m31129a("data") ? jsonElement.m31130b("data").mo5244c() : "";
        this.f30210a = new User(jsonElement.m31130b("user"));
        this.f30213i = jsonElement.m31129a("req_id") ? jsonElement.m31130b("req_id").mo5244c() : "";
        this.f30214j = jsonElement.m31129a("custom_type") ? jsonElement.m31130b("custom_type").mo5244c() : "";
        this.f30215k = new HashMap();
        if (jsonElement.m31129a("translations")) {
            for (Entry entry : jsonElement.m31130b("translations").m25073h().f30235a.entrySet()) {
                this.f30215k.put(entry.getKey(), ((JsonElement) entry.getValue()).mo5244c());
            }
        }
    }

    final JsonElement mo5214a() {
        JsonElement h = super.mo5214a().m25073h();
        h.m31128a("type", "MESG");
        h.m31128a("req_id", this.f30213i);
        h.m31128a("message", this.f30211g);
        h.m31128a("data", this.f30212h);
        h.m31128a("custom_type", this.f30214j);
        h.m31125a("user", this.f30210a.mo5219a());
        JsonElement jsonObject = new JsonObject();
        for (Entry entry : this.f30215k.entrySet()) {
            jsonObject.m31128a((String) entry.getKey(), (String) entry.getValue());
        }
        h.m31125a("translations", jsonObject);
        return h;
    }

    public final String m31081b() {
        return this.f30211g;
    }

    public final String m31082c() {
        return this.f30212h;
    }

    public final User m31083d() {
        if (Options.f22815a && GroupChannel.f30084g.containsKey(this.c)) {
            User user = (User) ((GroupChannel) GroupChannel.f30084g.get(this.c)).f30092o.get(this.f30210a.f22858c);
            if (user != null) {
                if (!user.f22859d.equals(this.f30210a.f22859d)) {
                    this.f30210a.f22859d = user.f22859d;
                }
                if (!user.f22860e.equals(this.f30210a.f22860e)) {
                    this.f30210a.f22860e = user.f22860e;
                }
            }
        }
        return this.f30210a;
    }

    public final String m31084j() {
        return this.f30213i;
    }

    public final String m31085k() {
        return this.f30214j;
    }
}
