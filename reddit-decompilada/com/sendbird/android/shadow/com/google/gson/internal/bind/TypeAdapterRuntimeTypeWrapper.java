package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson f30335a;
    private final TypeAdapter<T> f30336b;
    private final Type f30337c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f30335a = gson;
        this.f30336b = typeAdapter;
        this.f30337c = type;
    }

    public final T mo5241a(JsonReader jsonReader) throws IOException {
        return this.f30336b.mo5241a(jsonReader);
    }

    public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter typeAdapter = this.f30336b;
        Type type = this.f30337c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f30337c) {
            typeAdapter = this.f30335a.m25062a(TypeToken.m25142a(type));
            if ((typeAdapter instanceof Adapter) && !(this.f30336b instanceof Adapter)) {
                typeAdapter = this.f30336b;
            }
        }
        typeAdapter.mo5242a(jsonWriter, t);
    }
}
