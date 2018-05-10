package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f15043a;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> f15041a;
        private final ObjectConstructor<? extends Collection<E>> f15042b;

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.mo2499f();
                return;
            }
            jsonWriter.mo2493b();
            for (Object a : collection) {
                this.f15041a.mo2459a(jsonWriter, a);
            }
            jsonWriter.mo2495c();
        }

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f15041a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f15042b = objectConstructor;
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            Collection collection = (Collection) this.f15042b.mo2466a();
            jsonReader.mo2469a();
            while (jsonReader.mo2474e()) {
                collection.add(this.f15041a.mo2458a(jsonReader));
            }
            jsonReader.mo2470b();
            return collection;
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f15043a = constructorConstructor;
    }

    public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.f8835b;
        Class cls = typeToken.f8834a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        type = C$Gson$Types.m7525a(type, cls);
        return new Adapter(gson, type, gson.m7475a(TypeToken.m7571a(type)), this.f15043a.m7537a((TypeToken) typeToken));
    }
}
