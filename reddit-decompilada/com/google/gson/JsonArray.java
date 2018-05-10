package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> f14989a = new ArrayList();

    public final void m14921a(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f14990a;
        }
        this.f14989a.add(jsonElement);
    }

    public final int m14919a() {
        return this.f14989a.size();
    }

    public final Iterator<JsonElement> iterator() {
        return this.f14989a.iterator();
    }

    public final JsonElement m14920a(int i) {
        return (JsonElement) this.f14989a.get(i);
    }

    public final Number mo2460b() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2460b();
        }
        throw new IllegalStateException();
    }

    public final String mo2461c() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2461c();
        }
        throw new IllegalStateException();
    }

    public final double mo2462d() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2462d();
        }
        throw new IllegalStateException();
    }

    public final long mo2463e() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2463e();
        }
        throw new IllegalStateException();
    }

    public final int mo2464f() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2464f();
        }
        throw new IllegalStateException();
    }

    public final boolean mo2465g() {
        if (this.f14989a.size() == 1) {
            return ((JsonElement) this.f14989a.get(0)).mo2465g();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof JsonArray) || ((JsonArray) obj).f14989a.equals(this.f14989a) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f14989a.hashCode();
    }
}
