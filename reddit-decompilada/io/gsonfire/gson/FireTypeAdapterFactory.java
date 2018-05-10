package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import io.gsonfire.ClassConfig;

public final class FireTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final ClassConfig<T> f31060a;

    public FireTypeAdapterFactory(ClassConfig<T> classConfig) {
        this.f31060a = classConfig;
    }

    public final <T> TypeAdapter<T> m32033a(Gson gson, TypeToken<T> typeToken) {
        if (!this.f31060a.f24934a.isAssignableFrom(typeToken.a)) {
            return null;
        }
        return new FireTypeAdapter(typeToken.a, this.f31060a, gson.a(this, typeToken), gson);
    }
}
