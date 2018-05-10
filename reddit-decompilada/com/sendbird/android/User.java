package com.sendbird.android;

import com.instabug.chat.model.Attachment;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private String f22856a;
    private String f22857b;
    String f22858c;
    String f22859d;
    String f22860e;
    private Map<String, String> f22861f;
    private ConnectionStatus f22862g;
    private long f22863h;
    private boolean f22864i = true;

    public enum ConnectionStatus {
        NON_AVAILABLE,
        ONLINE,
        OFFLINE
    }

    protected User(JsonElement jsonElement) {
        boolean z = true;
        if (!(jsonElement instanceof JsonNull)) {
            jsonElement = jsonElement.m25073h();
            if (jsonElement.m31129a("guest_id")) {
                this.f22858c = jsonElement.m31130b("guest_id").mo5244c();
            }
            if (jsonElement.m31129a("user_id")) {
                this.f22858c = jsonElement.m31130b("user_id").mo5244c();
            }
            if (jsonElement.m31129a("name")) {
                this.f22859d = jsonElement.m31130b("name").mo5244c();
            }
            if (jsonElement.m31129a("nickname")) {
                this.f22859d = jsonElement.m31130b("nickname").mo5244c();
            }
            if (jsonElement.m31129a(Attachment.TYPE_IMAGE)) {
                this.f22860e = jsonElement.m31130b(Attachment.TYPE_IMAGE).mo5244c();
            }
            if (jsonElement.m31129a("profile_url")) {
                this.f22860e = jsonElement.m31130b("profile_url").mo5244c();
            }
            if (jsonElement.m31129a("friend_discovery_key") && !(jsonElement.m31130b("friend_discovery_key") instanceof JsonNull)) {
                this.f22856a = jsonElement.m31130b("friend_discovery_key").mo5244c();
            }
            if (jsonElement.m31129a("friend_name") && !(jsonElement.m31130b("friend_name") instanceof JsonNull)) {
                this.f22857b = jsonElement.m31130b("friend_name").mo5244c();
            }
            this.f22861f = new ConcurrentHashMap();
            if (jsonElement.m31129a("metadata")) {
                for (Entry entry : jsonElement.m31130b("metadata").m25073h().f30235a.entrySet()) {
                    if (((JsonElement) entry.getValue()) instanceof JsonPrimitive) {
                        this.f22861f.put(entry.getKey(), ((JsonElement) entry.getValue()).mo5244c());
                    }
                }
            }
            ConnectionStatus connectionStatus = jsonElement.m31129a("is_online") ? jsonElement.m31130b("is_online").mo5248g() ? ConnectionStatus.ONLINE : ConnectionStatus.OFFLINE : ConnectionStatus.NON_AVAILABLE;
            this.f22862g = connectionStatus;
            this.f22863h = jsonElement.m31129a("last_seen_at") ? jsonElement.m31130b("last_seen_at").mo5246e() : 0;
            if (jsonElement.m31129a("is_active")) {
                if (jsonElement.m31130b("is_active").mo5248g() == null) {
                    z = false;
                }
            }
            this.f22864i = z;
        }
    }

    JsonElement mo5219a() {
        JsonElement jsonObject = new JsonObject();
        if (this.f22858c != null) {
            jsonObject.m31128a("user_id", this.f22858c);
        }
        if (this.f22859d != null) {
            jsonObject.m31128a("nickname", this.f22859d);
        }
        if (this.f22860e != null) {
            jsonObject.m31128a("profile_url", this.f22860e);
        }
        if (this.f22856a != null) {
            jsonObject.m31128a("friend_discovery_key", this.f22856a);
        }
        if (this.f22857b != null) {
            jsonObject.m31128a("friend_name", this.f22857b);
        }
        if (this.f22861f.size() > 0) {
            JsonElement jsonObject2 = new JsonObject();
            for (Entry entry : this.f22861f.entrySet()) {
                jsonObject2.m31128a((String) entry.getKey(), (String) entry.getValue());
            }
            jsonObject.m31125a("metadata", jsonObject2);
        }
        if (this.f22862g == ConnectionStatus.ONLINE) {
            jsonObject.m31126a("is_online", Boolean.valueOf(true));
        } else if (this.f22862g == ConnectionStatus.OFFLINE) {
            jsonObject.m31126a("is_online", Boolean.valueOf(false));
        }
        jsonObject.m31127a("last_seen_at", Long.valueOf(this.f22863h));
        jsonObject.m31126a("is_active", Boolean.valueOf(this.f22864i));
        return jsonObject;
    }

    public final String m25021d() {
        return this.f22858c;
    }

    public final String m25022e() {
        return this.f22859d;
    }

    public final String m25023f() {
        return this.f22860e;
    }
}
