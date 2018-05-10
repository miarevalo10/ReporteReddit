package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final Factory f30619a = new C25041();
    private final JsonAdapter<T> f30620b;

    class C25041 implements Factory {
        C25041() {
        }

        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class b = Types.m25728b(type);
            if (set.isEmpty() == null) {
                return null;
            }
            if (b != List.class) {
                if (b != Collection.class) {
                    if (b == Set.class) {
                        return CollectionJsonAdapter.m31589b(type, moshi).nullSafe();
                    }
                    return null;
                }
            }
            return CollectionJsonAdapter.m31588a(type, moshi).nullSafe();
        }
    }

    class C27172 extends CollectionJsonAdapter<Collection<T>, T> {
        C27172(JsonAdapter jsonAdapter) {
            super(jsonAdapter);
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return super.m31591a(jsonReader);
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            super.m31592a(jsonWriter, (Collection) obj);
        }

        final Collection<T> mo6582a() {
            return new ArrayList();
        }
    }

    class C27183 extends CollectionJsonAdapter<Set<T>, T> {
        C27183(JsonAdapter jsonAdapter) {
            super(jsonAdapter);
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return super.m31591a(jsonReader);
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            super.m31592a(jsonWriter, (Set) obj);
        }

        final /* synthetic */ Collection mo6582a() {
            return new LinkedHashSet();
        }
    }

    abstract C mo6582a();

    public /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
        return m31591a(jsonReader);
    }

    public /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        m31592a(jsonWriter, (Collection) obj);
    }

    private CollectionJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.f30620b = jsonAdapter;
    }

    static <T> JsonAdapter<Collection<T>> m31588a(Type type, Moshi moshi) {
        return new C27172(moshi.m25717a(Types.m25723a(type, Collection.class)));
    }

    static <T> JsonAdapter<Set<T>> m31589b(Type type, Moshi moshi) {
        return new C27183(moshi.m25717a(Types.m25723a(type, Collection.class)));
    }

    public final C m31591a(JsonReader jsonReader) throws IOException {
        C a = mo6582a();
        jsonReader.mo5417a();
        while (jsonReader.mo5422e()) {
            a.add(this.f30620b.fromJson(jsonReader));
        }
        jsonReader.mo5419b();
        return a;
    }

    public final void m31592a(JsonWriter jsonWriter, C c) throws IOException {
        jsonWriter.mo5433a();
        for (Object toJson : c) {
            this.f30620b.toJson(jsonWriter, toJson);
        }
        jsonWriter.mo5439b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f30620b);
        stringBuilder.append(".collection()");
        return stringBuilder.toString();
    }
}
