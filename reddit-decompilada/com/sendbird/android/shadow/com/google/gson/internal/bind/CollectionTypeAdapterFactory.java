package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor f30287a;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> f30285a;
        private final ObjectConstructor<? extends Collection<E>> f30286b;

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.mo5281e();
                return;
            }
            jsonWriter.mo5270a();
            for (Object a : collection) {
                this.f30285a.mo5242a(jsonWriter, a);
            }
            jsonWriter.mo5276b();
        }

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f30285a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f30286b = objectConstructor;
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            Collection collection = (Collection) this.f30286b.mo5249a();
            jsonReader.mo5252a();
            while (jsonReader.mo5257e()) {
                collection.add(this.f30285a.mo5241a(jsonReader));
            }
            jsonReader.mo5253b();
            return collection;
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f30287a = constructorConstructor;
    }

    public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.f22997b;
        Class cls = typeToken.f22996a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        type = C$Gson$Types.m25097a(type, cls);
        return new Adapter(gson, type, gson.m25062a(TypeToken.m25142a(type)), this.f30287a.m25110a((TypeToken) typeToken));
    }
}
