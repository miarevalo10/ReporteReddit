package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class ArrayJsonAdapter extends JsonAdapter<Object> {
    public static final Factory f30602a = new C24981();
    private final Class<?> f30603b;
    private final JsonAdapter<Object> f30604c;

    class C24981 implements Factory {
        C24981() {
        }

        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            type = Types.m25733e(type);
            if (type == null || set.isEmpty() == null) {
                return null;
            }
            return new ArrayJsonAdapter(Types.m25728b(type), moshi.m25717a(type)).nullSafe();
        }
    }

    ArrayJsonAdapter(Class<?> cls, JsonAdapter<Object> jsonAdapter) {
        this.f30603b = cls;
        this.f30604c = jsonAdapter;
    }

    public final Object fromJson(JsonReader jsonReader) throws IOException {
        List arrayList = new ArrayList();
        jsonReader.mo5417a();
        while (jsonReader.mo5422e()) {
            arrayList.add(this.f30604c.fromJson(jsonReader));
        }
        jsonReader.mo5419b();
        jsonReader = Array.newInstance(this.f30603b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(jsonReader, i, arrayList.get(i));
        }
        return jsonReader;
    }

    public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.mo5433a();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f30604c.toJson(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.mo5439b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f30604c);
        stringBuilder.append(".array()");
        return stringBuilder.toString();
    }
}
