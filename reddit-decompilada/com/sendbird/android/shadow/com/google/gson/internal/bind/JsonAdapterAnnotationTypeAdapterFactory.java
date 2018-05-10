package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonDeserializer;
import com.sendbird.android.shadow.com.google.gson.JsonSerializer;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.annotations.JsonAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f30291a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f30291a = constructorConstructor;
    }

    static TypeAdapter<?> m31181a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        constructorConstructor = constructorConstructor.m25110a(TypeToken.m25141a(jsonAdapter.m25087a())).mo5249a();
        if (constructorConstructor instanceof TypeAdapter) {
            constructorConstructor = (TypeAdapter) constructorConstructor;
        } else if (constructorConstructor instanceof TypeAdapterFactory) {
            constructorConstructor = ((TypeAdapterFactory) constructorConstructor).mo5250a(gson, typeToken);
        } else {
            boolean z = constructorConstructor instanceof JsonSerializer;
            if (!z) {
                if (!(constructorConstructor instanceof JsonDeserializer)) {
                    jsonAdapter = new StringBuilder("Invalid attempt to bind an instance of ");
                    jsonAdapter.append(constructorConstructor.getClass().getName());
                    jsonAdapter.append(" as a @JsonAdapter for ");
                    jsonAdapter.append(typeToken.toString());
                    jsonAdapter.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                    throw new IllegalArgumentException(jsonAdapter.toString());
                }
            }
            JsonDeserializer jsonDeserializer = null;
            JsonSerializer jsonSerializer = z ? (JsonSerializer) constructorConstructor : null;
            if (constructorConstructor instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) constructorConstructor;
            }
            constructorConstructor = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken);
        }
        return (constructorConstructor == null || jsonAdapter.m25088b() == null) ? constructorConstructor : constructorConstructor.m25081a();
    }

    public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.f22996a.getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return m31181a(this.f30291a, gson, typeToken, jsonAdapter);
    }
}
