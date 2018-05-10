package io.gsonfire.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class NullableTypeAdapter<T> extends TypeAdapter<T> {
    private final TypeAdapter<T> f31063a;

    public NullableTypeAdapter(TypeAdapter<T> typeAdapter) {
        this.f31063a = typeAdapter;
    }

    public final void m32036a(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.f();
        } else {
            this.f31063a.a(jsonWriter, t);
        }
    }

    public final T m32035a(JsonReader jsonReader) throws IOException {
        if (jsonReader.f() != JsonToken.i) {
            return this.f31063a.a(jsonReader);
        }
        jsonReader.k();
        return null;
    }
}
