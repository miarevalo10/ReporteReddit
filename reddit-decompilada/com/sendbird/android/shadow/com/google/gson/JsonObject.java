package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap;

public final class JsonObject extends JsonElement {
    public final LinkedTreeMap<String, JsonElement> f30235a = new LinkedTreeMap();

    public final void m31125a(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f30234a;
        }
        this.f30235a.put(str, jsonElement);
    }

    public final void m31128a(String str, String str2) {
        m31125a(str, m31124a((Object) str2));
    }

    public final void m31127a(String str, Number number) {
        m31125a(str, m31124a((Object) number));
    }

    public final void m31126a(String str, Boolean bool) {
        m31125a(str, m31124a((Object) bool));
    }

    private static JsonElement m31124a(Object obj) {
        return obj == null ? JsonNull.f30234a : new JsonPrimitive(obj);
    }

    public final boolean m31129a(String str) {
        return this.f30235a.containsKey(str);
    }

    public final JsonElement m31130b(String str) {
        return (JsonElement) this.f30235a.get(str);
    }

    public final JsonArray m31131c(String str) {
        return (JsonArray) this.f30235a.get(str);
    }

    public final JsonObject m31132d(String str) {
        return (JsonObject) this.f30235a.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof JsonObject) || ((JsonObject) obj).f30235a.equals(this.f30235a) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f30235a.hashCode();
    }
}
