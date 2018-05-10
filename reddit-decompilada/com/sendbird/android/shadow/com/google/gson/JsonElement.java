package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class JsonElement {
    public boolean mo5248g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number mo5243b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String mo5244c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double mo5245d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long mo5246e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int mo5247f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.f23030e = true;
            Streams.m25127a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonObject m25073h() {
        if (this instanceof JsonObject) {
            return (JsonObject) this;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a JSON Object: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final JsonArray m25074i() {
        if (this instanceof JsonArray) {
            return (JsonArray) this;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a JSON Array: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final JsonPrimitive m25075j() {
        if (this instanceof JsonPrimitive) {
            return (JsonPrimitive) this;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a JSON Primitive: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }
}
