package com.sendbird.android.shadow.com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    public final List<JsonElement> f30233a = new ArrayList();

    public final void m31117a(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f30234a;
        }
        this.f30233a.add(jsonElement);
    }

    public final int m31115a() {
        return this.f30233a.size();
    }

    public final Iterator<JsonElement> iterator() {
        return this.f30233a.iterator();
    }

    public final JsonElement m31116a(int i) {
        return (JsonElement) this.f30233a.get(i);
    }

    public final Number mo5243b() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5243b();
        }
        throw new IllegalStateException();
    }

    public final String mo5244c() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5244c();
        }
        throw new IllegalStateException();
    }

    public final double mo5245d() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5245d();
        }
        throw new IllegalStateException();
    }

    public final long mo5246e() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5246e();
        }
        throw new IllegalStateException();
    }

    public final int mo5247f() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5247f();
        }
        throw new IllegalStateException();
    }

    public final boolean mo5248g() {
        if (this.f30233a.size() == 1) {
            return ((JsonElement) this.f30233a.get(0)).mo5248g();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof JsonArray) || ((JsonArray) obj).f30233a.equals(this.f30233a) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f30233a.hashCode();
    }
}
