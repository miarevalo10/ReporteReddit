package com.twitter.sdk.android.core.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class SafeMapAdapter implements TypeAdapterFactory {
    public final <T> TypeAdapter<T> m31763a(Gson gson, final TypeToken<T> typeToken) {
        gson = gson.a(this, typeToken);
        return new TypeAdapter<T>(this) {
            final /* synthetic */ SafeMapAdapter f30760c;

            public final void m31762a(JsonWriter jsonWriter, T t) throws IOException {
                gson.a(jsonWriter, t);
            }

            public final T m31761a(JsonReader jsonReader) throws IOException {
                jsonReader = gson.a(jsonReader);
                if (!Map.class.isAssignableFrom(typeToken.a)) {
                    return jsonReader;
                }
                if (jsonReader == null) {
                    return Collections.EMPTY_MAP;
                }
                return Collections.unmodifiableMap((Map) jsonReader);
            }
        };
    }
}
