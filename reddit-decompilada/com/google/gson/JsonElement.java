package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class JsonElement {
    public boolean mo2465g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number mo2460b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String mo2461c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double mo2462d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long mo2463e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int mo2464f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.f8868c = true;
            Streams.m7555a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonObject m7500h() {
        if (this instanceof JsonObject) {
            return (JsonObject) this;
        }
        StringBuilder stringBuilder = new StringBuilder("Not a JSON Object: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final JsonArray m7501i() {
        if (this instanceof JsonArray) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public final JsonPrimitive m7502j() {
        if (this instanceof JsonPrimitive) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }
}
