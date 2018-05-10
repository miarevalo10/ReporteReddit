package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.util.SimpleIterable;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class SimpleIterableTypeAdapter extends TypeAdapter<SimpleIterable<?>> {
    private final Gson f31064a;
    private final Type f31065b;

    public final /* synthetic */ void m32038a(JsonWriter jsonWriter, Object obj) throws IOException {
        SimpleIterable simpleIterable = (SimpleIterable) obj;
        if (simpleIterable != null) {
            jsonWriter.b();
            obj = simpleIterable.iterator();
            while (obj.hasNext()) {
                Object next = obj.next();
                this.f31064a.a(next, next.getClass(), jsonWriter);
            }
            jsonWriter.c();
            return;
        }
        jsonWriter.f();
    }

    public SimpleIterableTypeAdapter(Gson gson, Type type) {
        this.f31064a = gson;
        this.f31065b = type;
    }

    public final /* synthetic */ Object m32037a(JsonReader jsonReader) throws IOException {
        if (jsonReader.f() == JsonToken.i) {
            return null;
        }
        Iterable arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.e()) {
            arrayList.add(this.f31064a.a(jsonReader, this.f31065b));
        }
        jsonReader.b();
        return SimpleIterable.m26462a(arrayList);
    }
}
