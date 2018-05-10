package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory f15065a = new C12371();
    private final Gson f15066b;

    static class C12371 implements TypeAdapterFactory {
        C12371() {
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f8834a == Object.class ? new ObjectTypeAdapter(gson) : null;
        }
    }

    ObjectTypeAdapter(Gson gson) {
        this.f15066b = gson;
    }

    public final Object mo2458a(JsonReader jsonReader) throws IOException {
        switch (jsonReader.mo2475f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                jsonReader.mo2469a();
                while (jsonReader.mo2474e()) {
                    arrayList.add(mo2458a(jsonReader));
                }
                jsonReader.mo2470b();
                return arrayList;
            case BEGIN_OBJECT:
                Map linkedTreeMap = new LinkedTreeMap();
                jsonReader.mo2471c();
                while (jsonReader.mo2474e()) {
                    linkedTreeMap.put(jsonReader.mo2477h(), mo2458a(jsonReader));
                }
                jsonReader.mo2473d();
                return linkedTreeMap;
            case STRING:
                return jsonReader.mo2478i();
            case NUMBER:
                return Double.valueOf(jsonReader.mo2481l());
            case BOOLEAN:
                return Boolean.valueOf(jsonReader.mo2479j());
            case NULL:
                jsonReader.mo2480k();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo2499f();
            return;
        }
        TypeAdapter a = this.f15066b.m7476a(obj.getClass());
        if (a instanceof ObjectTypeAdapter) {
            jsonWriter.mo2497d();
            jsonWriter.mo2498e();
            return;
        }
        a.mo2459a(jsonWriter, obj);
    }
}
