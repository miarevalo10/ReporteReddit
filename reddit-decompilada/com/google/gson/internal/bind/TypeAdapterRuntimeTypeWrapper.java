package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson f15097a;
    private final TypeAdapter<T> f15098b;
    private final Type f15099c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f15097a = gson;
        this.f15098b = typeAdapter;
        this.f15099c = type;
    }

    public final T mo2458a(JsonReader jsonReader) throws IOException {
        return this.f15098b.mo2458a(jsonReader);
    }

    public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter typeAdapter = this.f15098b;
        Type type = this.f15099c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f15099c) {
            typeAdapter = this.f15097a.m7475a(TypeToken.m7571a(type));
            if ((typeAdapter instanceof Adapter) && !(this.f15098b instanceof Adapter)) {
                typeAdapter = this.f15098b;
            }
        }
        typeAdapter.mo2459a(jsonWriter, t);
    }
}
