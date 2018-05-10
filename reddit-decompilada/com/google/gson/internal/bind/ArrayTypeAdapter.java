package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory f15038a = new C12351();
    private final Class<E> f15039b;
    private final TypeAdapter<E> f15040c;

    static class C12351 implements TypeAdapterFactory {
        C12351() {
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            typeToken = typeToken.f8835b;
            if (!(typeToken instanceof GenericArrayType) && (!(typeToken instanceof Class) || !((Class) typeToken).isArray())) {
                return null;
            }
            Type d = C$Gson$Types.m7533d(typeToken);
            return new ArrayTypeAdapter(gson, gson.m7475a(TypeToken.m7571a(d)), C$Gson$Types.m7529b(d));
        }
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f15040c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f15039b = cls;
    }

    public final Object mo2458a(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo2475f() == JsonToken.NULL) {
            jsonReader.mo2480k();
            return null;
        }
        List arrayList = new ArrayList();
        jsonReader.mo2469a();
        while (jsonReader.mo2474e()) {
            arrayList.add(this.f15040c.mo2458a(jsonReader));
        }
        jsonReader.mo2470b();
        jsonReader = Array.newInstance(this.f15039b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(jsonReader, i, arrayList.get(i));
        }
        return jsonReader;
    }

    public final void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo2499f();
            return;
        }
        jsonWriter.mo2493b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f15040c.mo2459a(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.mo2495c();
    }
}
