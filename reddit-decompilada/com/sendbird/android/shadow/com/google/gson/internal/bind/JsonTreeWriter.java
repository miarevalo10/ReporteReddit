package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
    private static final Writer f30298h = new C20331();
    private static final JsonPrimitive f30299i = new JsonPrimitive("closed");
    public final List<JsonElement> f30300a = new ArrayList();
    public JsonElement f30301b = JsonNull.f30234a;
    private String f30302j;

    static class C20331 extends Writer {
        C20331() {
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
        super(f30298h);
    }

    private JsonElement m31204f() {
        return (JsonElement) this.f30300a.get(this.f30300a.size() - 1);
    }

    private void m31203a(JsonElement jsonElement) {
        if (this.f30302j != null) {
            if (!(jsonElement instanceof JsonNull) || this.f23032g) {
                ((JsonObject) m31204f()).m31125a(this.f30302j, jsonElement);
            }
            this.f30302j = null;
        } else if (this.f30300a.isEmpty()) {
            this.f30301b = jsonElement;
        } else {
            JsonElement f = m31204f();
            if (f instanceof JsonArray) {
                ((JsonArray) f).m31117a(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final JsonWriter mo5270a() throws IOException {
        JsonElement jsonArray = new JsonArray();
        m31203a(jsonArray);
        this.f30300a.add(jsonArray);
        return this;
    }

    public final JsonWriter mo5276b() throws IOException {
        if (!this.f30300a.isEmpty()) {
            if (this.f30302j == null) {
                if (m31204f() instanceof JsonArray) {
                    this.f30300a.remove(this.f30300a.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo5278c() throws IOException {
        JsonElement jsonObject = new JsonObject();
        m31203a(jsonObject);
        this.f30300a.add(jsonObject);
        return this;
    }

    public final JsonWriter mo5280d() throws IOException {
        if (!this.f30300a.isEmpty()) {
            if (this.f30302j == null) {
                if (m31204f() instanceof JsonObject) {
                    this.f30300a.remove(this.f30300a.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo5274a(String str) throws IOException {
        if (!this.f30300a.isEmpty()) {
            if (this.f30302j == null) {
                if (m31204f() instanceof JsonObject) {
                    this.f30302j = str;
                    return this;
                }
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

    public final JsonWriter mo5277b(String str) throws IOException {
        if (str == null) {
            return mo5281e();
        }
        m31203a(new JsonPrimitive(str));
        return this;
    }

    public final JsonWriter mo5281e() throws IOException {
        m31203a(JsonNull.f30234a);
        return this;
    }

    public final JsonWriter mo5275a(boolean z) throws IOException {
        m31203a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public final JsonWriter mo5272a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo5281e();
        }
        m31203a(new JsonPrimitive(bool));
        return this;
    }

    public final JsonWriter mo5271a(long j) throws IOException {
        m31203a(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    public final JsonWriter mo5273a(Number number) throws IOException {
        if (number == null) {
            return mo5281e();
        }
        if (!this.f23030e) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
                stringBuilder.append(number);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        m31203a(new JsonPrimitive(number));
        return this;
    }

    public final void close() throws IOException {
        if (this.f30300a.isEmpty()) {
            this.f30300a.add(f30299i);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
