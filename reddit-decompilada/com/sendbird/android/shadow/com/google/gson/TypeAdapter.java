package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.bind.JsonTreeWriter;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;

public abstract class TypeAdapter<T> {

    class C24261 extends TypeAdapter<T> {
        final /* synthetic */ TypeAdapter f30238a;

        C24261(TypeAdapter typeAdapter) {
            this.f30238a = typeAdapter;
        }

        public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo5281e();
            } else {
                this.f30238a.mo5242a(jsonWriter, t);
            }
        }

        public final T mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return this.f30238a.mo5241a(jsonReader);
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    public abstract T mo5241a(JsonReader jsonReader) throws IOException;

    public abstract void mo5242a(JsonWriter jsonWriter, T t) throws IOException;

    public final TypeAdapter<T> m25081a() {
        return new C24261(this);
    }

    public final JsonElement m25080a(T t) {
        try {
            JsonWriter jsonTreeWriter = new JsonTreeWriter();
            mo5242a(jsonTreeWriter, t);
            if (jsonTreeWriter.f30300a.isEmpty() != null) {
                return jsonTreeWriter.f30301b;
            }
            StringBuilder stringBuilder = new StringBuilder("Expected one JSON element but was ");
            stringBuilder.append(jsonTreeWriter.f30300a);
            throw new IllegalStateException(stringBuilder.toString());
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }
}
