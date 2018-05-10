package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonDeserializer;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonSerializer;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    final Gson f30328a;
    private final JsonSerializer<T> f30329b;
    private final JsonDeserializer<T> f30330c;
    private final TypeToken<T> f30331d;
    private final TypeAdapterFactory f30332e;
    private final GsonContextImpl f30333f = new GsonContextImpl();
    private TypeAdapter<T> f30334g;

    private final class GsonContextImpl {
        final /* synthetic */ TreeTypeAdapter f22941a;

        private GsonContextImpl(TreeTypeAdapter treeTypeAdapter) {
            this.f22941a = treeTypeAdapter;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken) {
        this.f30329b = jsonSerializer;
        this.f30330c = jsonDeserializer;
        this.f30328a = gson;
        this.f30331d = typeToken;
        this.f30332e = null;
    }

    public final T mo5241a(JsonReader jsonReader) throws IOException {
        if (this.f30330c == null) {
            return m31241b().mo5241a(jsonReader);
        }
        return (Streams.m25125a(jsonReader) instanceof JsonNull) != null ? null : this.f30330c.m25066a();
    }

    public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f30329b == null) {
            m31241b().mo5242a(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.mo5281e();
        } else {
            Streams.m25127a(this.f30329b.m25079a(), jsonWriter);
        }
    }

    private TypeAdapter<T> m31241b() {
        TypeAdapter<T> typeAdapter = this.f30334g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        typeAdapter = this.f30328a.m25061a(this.f30332e, this.f30331d);
        this.f30334g = typeAdapter;
        return typeAdapter;
    }
}
