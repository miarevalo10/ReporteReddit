package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.util.Mapper;
import java.io.IOException;
import java.util.Map;

public class WrapTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final Map<Class<T>, Mapper<T, String>> f31076a;

    private class WrapperTypeAdapter<T> extends TypeAdapter<T> {
        final /* synthetic */ WrapTypeAdapterFactory f31072a;
        private final Mapper<T, String> f31073b;
        private final Gson f31074c;
        private final TypeAdapter<T> f31075d;

        public WrapperTypeAdapter(WrapTypeAdapterFactory wrapTypeAdapterFactory, Mapper<T, String> mapper, Gson gson, TypeAdapter<T> typeAdapter) {
            this.f31072a = wrapTypeAdapterFactory;
            this.f31073b = mapper;
            this.f31074c = gson;
            this.f31075d = typeAdapter;
        }

        public final void m32045a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                this.f31075d.a(jsonWriter, t);
                return;
            }
            String str = (String) this.f31073b.m26461a();
            t = this.f31075d.a(t);
            JsonElement jsonObject = new JsonObject();
            jsonObject.a(str, t);
            this.f31074c.a(jsonObject, jsonWriter);
        }

        public final T m32044a(JsonReader jsonReader) throws IOException {
            jsonReader.c();
            jsonReader.h();
            T a = this.f31075d.a(jsonReader);
            jsonReader.d();
            return a;
        }
    }

    public WrapTypeAdapterFactory(Map<Class<T>, Mapper<T, String>> map) {
        this.f31076a = map;
    }

    public final <T> TypeAdapter<T> m32046a(Gson gson, TypeToken<T> typeToken) {
        Mapper mapper;
        TypeAdapter<T> a = gson.a(this, typeToken);
        for (typeToken = typeToken.a; typeToken != null; typeToken = typeToken.getSuperclass()) {
            mapper = (Mapper) this.f31076a.get(typeToken);
            if (mapper != null) {
                break;
            }
        }
        mapper = null;
        return mapper == null ? a : new NullableTypeAdapter(new WrapperTypeAdapter(this, mapper, gson, a));
    }
}
