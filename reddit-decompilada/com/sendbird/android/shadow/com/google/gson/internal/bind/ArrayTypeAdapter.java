package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory f30282a = new C24431();
    private final Class<E> f30283b;
    private final TypeAdapter<E> f30284c;

    static class C24431 implements TypeAdapterFactory {
        C24431() {
        }

        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            typeToken = typeToken.f22997b;
            if (!(typeToken instanceof GenericArrayType) && (!(typeToken instanceof Class) || !((Class) typeToken).isArray())) {
                return null;
            }
            Type d = C$Gson$Types.m25106d(typeToken);
            return new ArrayTypeAdapter(gson, gson.m25062a(TypeToken.m25142a(d)), C$Gson$Types.m25102b(d));
        }
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f30284c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f30283b = cls;
    }

    public final Object mo5241a(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo5258f() == JsonToken.NULL) {
            jsonReader.mo5263k();
            return null;
        }
        List arrayList = new ArrayList();
        jsonReader.mo5252a();
        while (jsonReader.mo5257e()) {
            arrayList.add(this.f30284c.mo5241a(jsonReader));
        }
        jsonReader.mo5253b();
        jsonReader = arrayList.size();
        Object newInstance = Array.newInstance(this.f30283b, jsonReader);
        for (int i = 0; i < jsonReader; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public final void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo5281e();
            return;
        }
        jsonWriter.mo5270a();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f30284c.mo5242a(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.mo5276b();
    }
}
