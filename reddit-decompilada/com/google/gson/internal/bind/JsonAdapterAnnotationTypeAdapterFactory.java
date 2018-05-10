package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f15047a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f15047a = constructorConstructor;
    }

    static TypeAdapter<?> m14984a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        constructorConstructor = constructorConstructor.m7537a(TypeToken.m7570a(jsonAdapter.m7515a())).mo2466a();
        if (constructorConstructor instanceof TypeAdapter) {
            constructorConstructor = (TypeAdapter) constructorConstructor;
        } else if (constructorConstructor instanceof TypeAdapterFactory) {
            constructorConstructor = ((TypeAdapterFactory) constructorConstructor).mo2467a(gson, typeToken);
        } else {
            boolean z = constructorConstructor instanceof JsonSerializer;
            if (!z) {
                if (!(constructorConstructor instanceof JsonDeserializer)) {
                    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
                }
            }
            JsonDeserializer jsonDeserializer = null;
            JsonSerializer jsonSerializer = z ? (JsonSerializer) constructorConstructor : null;
            if (constructorConstructor instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) constructorConstructor;
            }
            ConstructorConstructor treeTypeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, null);
        }
        return (constructorConstructor == null || jsonAdapter.m7516b() == null) ? constructorConstructor : constructorConstructor.m7508a();
    }

    public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.f8834a.getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return m14984a(this.f15047a, gson, typeToken, jsonAdapter);
    }
}
