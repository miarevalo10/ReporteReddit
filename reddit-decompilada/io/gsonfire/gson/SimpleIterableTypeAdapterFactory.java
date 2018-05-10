package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import io.gsonfire.util.SimpleIterable;
import java.lang.reflect.ParameterizedType;

public final class SimpleIterableTypeAdapterFactory implements TypeAdapterFactory {
    public final TypeAdapter m32039a(Gson gson, TypeToken typeToken) {
        if (typeToken.a != SimpleIterable.class) {
            return null;
        }
        if (typeToken.b instanceof ParameterizedType) {
            return new SimpleIterableTypeAdapter(gson, ((ParameterizedType) typeToken.b).getActualTypeArguments()[0]);
        }
        return new SimpleIterableTypeAdapter(gson, Object.class);
    }
}
