package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
    private static final Writer f15054f = new C04581();
    private static final JsonPrimitive f15055g = new JsonPrimitive("closed");
    private final List<JsonElement> f15056h = new ArrayList();
    private String f15057i;
    private JsonElement f15058j = JsonNull.f14990a;

    static class C04581 extends Writer {
        C04581() {
        }

        public final void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public final void flush() throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    }

    public final void flush() throws IOException {
    }

    public JsonTreeWriter() {
        super(f15054f);
    }

    public final JsonElement mo2487a() {
        if (this.f15056h.isEmpty()) {
            return this.f15058j;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected one JSON element but was ");
        stringBuilder.append(this.f15056h);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private JsonElement m15007g() {
        return (JsonElement) this.f15056h.get(this.f15056h.size() - 1);
    }

    private void m15006a(JsonElement jsonElement) {
        if (this.f15057i != null) {
            if (!(jsonElement instanceof JsonNull) || this.f8870e) {
                ((JsonObject) m15007g()).m14930a(this.f15057i, jsonElement);
            }
            this.f15057i = null;
        } else if (this.f15056h.isEmpty()) {
            this.f15058j = jsonElement;
        } else {
            JsonElement g = m15007g();
            if (g instanceof JsonArray) {
                ((JsonArray) g).m14921a(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final JsonWriter mo2493b() throws IOException {
        JsonElement jsonArray = new JsonArray();
        m15006a(jsonArray);
        this.f15056h.add(jsonArray);
        return this;
    }

    public final JsonWriter mo2495c() throws IOException {
        if (!this.f15056h.isEmpty()) {
            if (this.f15057i == null) {
                if (m15007g() instanceof JsonArray) {
                    this.f15056h.remove(this.f15056h.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo2497d() throws IOException {
        JsonElement jsonObject = new JsonObject();
        m15006a(jsonObject);
        this.f15056h.add(jsonObject);
        return this;
    }

    public final JsonWriter mo2498e() throws IOException {
        if (!this.f15056h.isEmpty()) {
            if (this.f15057i == null) {
                if (m15007g() instanceof JsonObject) {
                    this.f15056h.remove(this.f15056h.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo2491a(String str) throws IOException {
        if (!this.f15056h.isEmpty()) {
            if (this.f15057i == null) {
                if (m15007g() instanceof JsonObject) {
                    this.f15057i = str;
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo2494b(String str) throws IOException {
        if (str == null) {
            return mo2499f();
        }
        m15006a(new JsonPrimitive(str));
        return this;
    }

    public final JsonWriter mo2499f() throws IOException {
        m15006a(JsonNull.f14990a);
        return this;
    }

    public final JsonWriter mo2492a(boolean z) throws IOException {
        m15006a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public final JsonWriter mo2489a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo2499f();
        }
        m15006a(new JsonPrimitive(bool));
        return this;
    }

    public final JsonWriter mo2488a(long j) throws IOException {
        m15006a(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    public final JsonWriter mo2490a(Number number) throws IOException {
        if (number == null) {
            return mo2499f();
        }
        if (!this.f8868c) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
                stringBuilder.append(number);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        m15006a(new JsonPrimitive(number));
        return this;
    }

    public final void close() throws IOException {
        if (this.f15056h.isEmpty()) {
            this.f15056h.add(f15055g);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
