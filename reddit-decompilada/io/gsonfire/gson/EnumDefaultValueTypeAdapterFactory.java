package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class EnumDefaultValueTypeAdapterFactory<T extends Enum> implements TypeAdapterFactory {
    private final Class<T> f31046a;
    private final T f31047b;

    public EnumDefaultValueTypeAdapterFactory(Class<T> cls, T t) {
        this.f31046a = cls;
        this.f31047b = t;
    }

    public final <T> TypeAdapter<T> m32022a(Gson gson, TypeToken<T> typeToken) {
        if (!this.f31046a.isAssignableFrom(typeToken.a)) {
            return null;
        }
        gson = gson.a(this, typeToken);
        return new NullableTypeAdapter(new TypeAdapter<T>(this) {
            final /* synthetic */ EnumDefaultValueTypeAdapterFactory f31045b;

            public final void m32020a(JsonWriter jsonWriter, T t) throws IOException {
                gson.a(jsonWriter, t);
            }

            public final T m32019a(JsonReader jsonReader) throws IOException {
                jsonReader = gson.a(jsonReader);
                return jsonReader == null ? this.f31045b.f31047b : jsonReader;
            }
        });
    }
}
