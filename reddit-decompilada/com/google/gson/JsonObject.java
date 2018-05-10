package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> f14991a = new LinkedTreeMap();

    public final void m14930a(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f14990a;
        }
        this.f14991a.put(str, jsonElement);
    }

    public final JsonElement m14929a(String str) {
        return (JsonElement) this.f14991a.remove(str);
    }

    public final void m14931a(String str, String str2) {
        m14930a(str, m14928a((Object) str2));
    }

    public static JsonElement m14928a(Object obj) {
        return obj == null ? JsonNull.f14990a : new JsonPrimitive(obj);
    }

    public final boolean m14932b(String str) {
        return this.f14991a.containsKey(str);
    }

    public final JsonElement m14933c(String str) {
        return (JsonElement) this.f14991a.get(str);
    }

    public final JsonPrimitive m14934d(String str) {
        return (JsonPrimitive) this.f14991a.get(str);
    }

    public final JsonObject m14935e(String str) {
        return (JsonObject) this.f14991a.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof JsonObject) || ((JsonObject) obj).f14991a.equals(this.f14991a) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f14991a.hashCode();
    }
}
