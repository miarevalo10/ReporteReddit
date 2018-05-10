package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public abstract class TypeAdapter<T> {

    class C12181 extends TypeAdapter<T> {
        final /* synthetic */ TypeAdapter f14994a;

        C12181(TypeAdapter typeAdapter) {
            this.f14994a = typeAdapter;
        }

        public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo2499f();
            } else {
                this.f14994a.mo2459a(jsonWriter, t);
            }
        }

        public final T mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return this.f14994a.mo2458a(jsonReader);
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    public abstract T mo2458a(JsonReader jsonReader) throws IOException;

    public abstract void mo2459a(JsonWriter jsonWriter, T t) throws IOException;

    public final TypeAdapter<T> m7508a() {
        return new C12181(this);
    }

    public final JsonElement m7507a(T t) {
        try {
            JsonWriter jsonTreeWriter = new JsonTreeWriter();
            mo2459a(jsonTreeWriter, t);
            return jsonTreeWriter.mo2487a();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public final T m7509a(JsonElement jsonElement) {
        try {
            return mo2458a(new JsonTreeReader(jsonElement));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }
}
