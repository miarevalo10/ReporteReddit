package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final JsonSerializer<T> f15090a;
    private final JsonDeserializer<T> f15091b;
    private final Gson f15092c;
    private final TypeToken<T> f15093d;
    private final TypeAdapterFactory f15094e;
    private final GsonContextImpl f15095f = new GsonContextImpl();
    private TypeAdapter<T> f15096g;

    private final class GsonContextImpl implements JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter f15084a;

        private GsonContextImpl(TreeTypeAdapter treeTypeAdapter) {
            this.f15084a = treeTypeAdapter;
        }

        public final <R> R mo2504a(JsonElement jsonElement, Type type) throws JsonParseException {
            return this.f15084a.f15092c.m7479a(jsonElement, type);
        }
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {
        private final TypeToken<?> f15085a;
        private final boolean f15086b;
        private final Class<?> f15087c;
        private final JsonSerializer<?> f15088d;
        private final JsonDeserializer<?> f15089e;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z) {
            boolean z2;
            this.f15088d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f15089e = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            if (this.f15088d == null) {
                if (this.f15089e == null) {
                    z2 = null;
                    C$Gson$Preconditions.m7522a(z2);
                    this.f15085a = typeToken;
                    this.f15086b = z;
                    this.f15087c = null;
                }
            }
            z2 = true;
            C$Gson$Preconditions.m7522a(z2);
            this.f15085a = typeToken;
            this.f15086b = z;
            this.f15087c = null;
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            if (this.f15085a != null) {
                if (!this.f15085a.equals(typeToken)) {
                    if (!this.f15086b || this.f15085a.f8835b != typeToken.f8834a) {
                        z = false;
                    }
                }
                z = true;
            } else {
                z = this.f15087c.isAssignableFrom(typeToken.f8834a);
            }
            return z ? new TreeTypeAdapter(this.f15088d, this.f15089e, gson, typeToken, this) : null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f15090a = jsonSerializer;
        this.f15091b = jsonDeserializer;
        this.f15092c = gson;
        this.f15093d = typeToken;
        this.f15094e = typeAdapterFactory;
    }

    public final T mo2458a(JsonReader jsonReader) throws IOException {
        if (this.f15091b == null) {
            return m15049b().mo2458a(jsonReader);
        }
        jsonReader = Streams.m7553a(jsonReader);
        return jsonReader instanceof JsonNull ? null : this.f15091b.mo2457a(jsonReader, this.f15093d.f8835b, this.f15095f);
    }

    public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f15090a == null) {
            m15049b().mo2459a(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.mo2499f();
        } else {
            Streams.m7555a(this.f15090a.mo2456a(t), jsonWriter);
        }
    }

    private TypeAdapter<T> m15049b() {
        TypeAdapter<T> typeAdapter = this.f15096g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        typeAdapter = this.f15092c.m7474a(this.f15094e, this.f15093d);
        this.f15096g = typeAdapter;
        return typeAdapter;
    }

    public static TypeAdapterFactory m15048a(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, false);
    }

    public static TypeAdapterFactory m15050b(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.f8835b == typeToken.f8834a);
    }
}
