package com.twitter.sdk.android.core.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SafeListAdapter implements TypeAdapterFactory {
    public final <T> TypeAdapter<T> m31760a(Gson gson, final TypeToken<T> typeToken) {
        gson = gson.a(this, typeToken);
        return new TypeAdapter<T>(this) {
            final /* synthetic */ SafeListAdapter f30757c;

            public final void m31759a(JsonWriter jsonWriter, T t) throws IOException {
                gson.a(jsonWriter, t);
            }

            public final T m31758a(JsonReader jsonReader) throws IOException {
                jsonReader = gson.a(jsonReader);
                if (!List.class.isAssignableFrom(typeToken.a)) {
                    return jsonReader;
                }
                if (jsonReader == null) {
                    return Collections.EMPTY_LIST;
                }
                return Collections.unmodifiableList((List) jsonReader);
            }
        };
    }
}
