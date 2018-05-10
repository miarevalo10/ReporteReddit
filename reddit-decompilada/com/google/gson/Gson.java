package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
    private static final TypeToken<?> f8709b = new C12101();
    public final FieldNamingStrategy f8710a;
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> f8711c;
    private final Map<TypeToken<?>, TypeAdapter<?>> f8712d;
    private final List<TypeAdapterFactory> f8713e;
    private final ConstructorConstructor f8714f;
    private final Excluder f8715g;
    private final boolean f8716h;
    private final boolean f8717i;
    private final boolean f8718j;
    private final boolean f8719k;
    private final boolean f8720l;
    private final JsonAdapterAnnotationTypeAdapterFactory f8721m;

    static class C12101 extends TypeToken<Object> {
        C12101() {
        }
    }

    class C12112 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f14984a;

        C12112(Gson gson) {
            this.f14984a = gson;
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo2499f();
                return;
            }
            Gson.m7471a(number.doubleValue());
            jsonWriter.mo2490a(number);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.mo2481l());
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    class C12123 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f14985a;

        C12123(Gson gson) {
            this.f14985a = gson;
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo2499f();
                return;
            }
            Gson.m7471a((double) number.floatValue());
            jsonWriter.mo2490a(number);
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.mo2481l());
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    static class C12134 extends TypeAdapter<Number> {
        C12134() {
        }

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo2499f();
            } else {
                jsonWriter.mo2494b(number.toString());
            }
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo2475f() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.mo2482m());
            }
            jsonReader.mo2480k();
            return null;
        }
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        TypeAdapter<T> f14988a;

        FutureTypeAdapter() {
        }

        public final T mo2458a(JsonReader jsonReader) throws IOException {
            if (this.f14988a != null) {
                return this.f14988a.mo2458a(jsonReader);
            }
            throw new IllegalStateException();
        }

        public final void mo2459a(JsonWriter jsonWriter, T t) throws IOException {
            if (this.f14988a == null) {
                throw new IllegalStateException();
            }
            this.f14988a.mo2459a(jsonWriter, t);
        }
    }

    public Gson() {
        this(Excluder.f15024a, FieldNamingPolicy.f14978a, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.f8738a, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.f8711c = new ThreadLocal();
        this.f8712d = new ConcurrentHashMap();
        this.f8714f = new ConstructorConstructor(map);
        this.f8715g = excluder;
        this.f8710a = fieldNamingStrategy;
        this.f8716h = z;
        this.f8718j = z3;
        this.f8717i = z4;
        this.f8719k = z5;
        this.f8720l = z6;
        map = new ArrayList();
        map.add(TypeAdapters.f8805Y);
        map.add(ObjectTypeAdapter.f15065a);
        map.add(excluder);
        map.addAll(list);
        map.add(TypeAdapters.f8784D);
        map.add(TypeAdapters.f8819m);
        map.add(TypeAdapters.f8813g);
        map.add(TypeAdapters.f8815i);
        map.add(TypeAdapters.f8817k);
        if (longSerializationPolicy == LongSerializationPolicy.f8738a) {
            z = TypeAdapters.f8826t;
        } else {
            z = new C12134();
        }
        map.add(TypeAdapters.m7564a(Long.TYPE, Long.class, z));
        z3 = Double.TYPE;
        z4 = Double.class;
        if (z7) {
            z5 = TypeAdapters.f8828v;
        } else {
            z5 = new C12112(this);
        }
        map.add(TypeAdapters.m7564a(z3, z4, z5));
        z3 = Float.TYPE;
        z4 = Float.class;
        if (z7) {
            z5 = TypeAdapters.f8827u;
        } else {
            z5 = new C12123(this);
        }
        map.add(TypeAdapters.m7564a(z3, z4, z5));
        map.add(TypeAdapters.f8830x);
        map.add(TypeAdapters.f8821o);
        map.add(TypeAdapters.f8823q);
        map.add(TypeAdapters.m7563a(AtomicLong.class, new TypeAdapter<AtomicLong>() {
            public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
                z.mo2459a(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
            }

            public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) z.mo2458a(jsonReader)).longValue());
            }
        }.m7508a()));
        map.add(TypeAdapters.m7563a(AtomicLongArray.class, new TypeAdapter<AtomicLongArray>() {
            public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.mo2493b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    z.mo2459a(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.mo2495c();
            }

            public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
                List arrayList = new ArrayList();
                jsonReader.mo2469a();
                while (jsonReader.mo2474e()) {
                    arrayList.add(Long.valueOf(((Number) z.mo2458a(jsonReader)).longValue()));
                }
                jsonReader.mo2470b();
                jsonReader = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(jsonReader);
                for (int i = 0; i < jsonReader; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.m7508a()));
        map.add(TypeAdapters.f8825s);
        map.add(TypeAdapters.f8832z);
        map.add(TypeAdapters.f8786F);
        map.add(TypeAdapters.f8788H);
        map.add(TypeAdapters.m7563a(BigDecimal.class, TypeAdapters.f8782B));
        map.add(TypeAdapters.m7563a(BigInteger.class, TypeAdapters.f8783C));
        map.add(TypeAdapters.f8790J);
        map.add(TypeAdapters.f8792L);
        map.add(TypeAdapters.f8796P);
        map.add(TypeAdapters.f8798R);
        map.add(TypeAdapters.f8803W);
        map.add(TypeAdapters.f8794N);
        map.add(TypeAdapters.f8810d);
        map.add(DateTypeAdapter.f15044a);
        map.add(TypeAdapters.f8801U);
        map.add(TimeTypeAdapter.f15082a);
        map.add(SqlDateTypeAdapter.f15080a);
        map.add(TypeAdapters.f8799S);
        map.add(ArrayTypeAdapter.f15038a);
        map.add(TypeAdapters.f8808b);
        map.add(new CollectionTypeAdapterFactory(this.f8714f));
        map.add(new MapTypeAdapterFactory(this.f8714f, z2));
        this.f8721m = new JsonAdapterAnnotationTypeAdapterFactory(this.f8714f);
        map.add(this.f8721m);
        map.add(TypeAdapters.f8806Z);
        map.add(new ReflectiveTypeAdapterFactory(this.f8714f, fieldNamingStrategy, excluder, this.f8721m));
        this.f8713e = Collections.unmodifiableList(map);
    }

    static void m7471a(double d) {
        if (!Double.isNaN(d)) {
            if (!Double.isInfinite(d)) {
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final <T> TypeAdapter<T> m7475a(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.f8712d.get(typeToken == null ? f8709b : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = (Map) this.f8711c.get();
        Object obj = null;
        if (map == null) {
            map = new HashMap();
            this.f8711c.set(map);
            obj = 1;
        }
        FutureTypeAdapter futureTypeAdapter = (FutureTypeAdapter) map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            TypeAdapter<T> hasNext;
            futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator it = this.f8713e.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext != null) {
                    hasNext = ((TypeAdapterFactory) it.next()).mo2467a(this, typeToken);
                    if (hasNext != null) {
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("GSON cannot handle ");
                stringBuilder.append(typeToken);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (futureTypeAdapter.f14988a != null) {
                throw new AssertionError();
            }
            futureTypeAdapter.f14988a = hasNext;
            this.f8712d.put(typeToken, hasNext);
            return hasNext;
        } finally {
            map.remove(typeToken);
            if (obj != null) {
                this.f8711c.remove();
            }
        }
    }

    public final <T> TypeAdapter<T> m7474a(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f8713e.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f8721m;
        }
        Object obj = null;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f8713e) {
            if (obj != null) {
                TypeAdapter<T> a = typeAdapterFactory2.mo2467a(this, typeToken);
                if (a != null) {
                    return a;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                obj = 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("GSON cannot serialize ");
        stringBuilder.append(typeToken);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final <T> TypeAdapter<T> m7476a(Class<T> cls) {
        return m7475a(TypeToken.m7570a((Class) cls));
    }

    public final JsonElement m7473a(Object obj) {
        if (obj == null) {
            return JsonNull.f14990a;
        }
        Type type = obj.getClass();
        JsonWriter jsonTreeWriter = new JsonTreeWriter();
        m7486a(obj, type, jsonTreeWriter);
        return jsonTreeWriter.mo2487a();
    }

    public final String m7487b(Object obj) {
        if (obj == null) {
            return m7484a(JsonNull.f14990a);
        }
        Type type = obj.getClass();
        Appendable stringWriter = new StringWriter();
        try {
            m7486a(obj, type, m7478a(Streams.m7554a(stringWriter)));
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public final void m7486a(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        type = m7475a(TypeToken.m7571a(type));
        boolean z = jsonWriter.f8868c;
        jsonWriter.f8868c = true;
        boolean z2 = jsonWriter.f8869d;
        jsonWriter.f8869d = this.f8717i;
        boolean z3 = jsonWriter.f8870e;
        jsonWriter.f8870e = this.f8716h;
        try {
            type.mo2459a(jsonWriter, obj);
            jsonWriter.f8868c = z;
            jsonWriter.f8869d = z2;
            jsonWriter.f8870e = z3;
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.f8868c = z;
            jsonWriter.f8869d = z2;
            jsonWriter.f8870e = z3;
        }
    }

    public final String m7484a(JsonElement jsonElement) {
        Appendable stringWriter = new StringWriter();
        try {
            m7485a(jsonElement, m7478a(Streams.m7554a(stringWriter)));
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public final JsonWriter m7478a(Writer writer) throws IOException {
        if (this.f8718j) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f8719k != null) {
            writer = "  ";
            if (writer.length() == 0) {
                jsonWriter.f8866a = null;
                jsonWriter.f8867b = ":";
            } else {
                jsonWriter.f8866a = writer;
                jsonWriter.f8867b = ": ";
            }
        }
        jsonWriter.f8870e = this.f8716h;
        return jsonWriter;
    }

    public final JsonReader m7477a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.f8838a = this.f8720l;
        return jsonReader;
    }

    public final <T> T m7482a(String str, Class<T> cls) throws JsonSyntaxException {
        return Primitives.m7550a((Class) cls).cast(m7483a(str, (Type) cls));
    }

    public final <T> T m7483a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        JsonReader a = m7477a(new StringReader(str));
        Object a2 = m7480a(a, type);
        m7472a(a2, a);
        return a2;
    }

    public final <T> T m7481a(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader a = m7477a(reader);
        Object a2 = m7480a(a, (Type) cls);
        m7472a(a2, a);
        return Primitives.m7550a((Class) cls).cast(a2);
    }

    private static void m7472a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.mo2475f() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (Throwable e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public final <T> T m7479a(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        return jsonElement == null ? null : m7480a(new JsonTreeReader(jsonElement), type);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.f8716h);
        stringBuilder.append("factories:");
        stringBuilder.append(this.f8713e);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append(this.f8714f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m7485a(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean z = jsonWriter.f8868c;
        jsonWriter.f8868c = true;
        boolean z2 = jsonWriter.f8869d;
        jsonWriter.f8869d = this.f8717i;
        boolean z3 = jsonWriter.f8870e;
        jsonWriter.f8870e = this.f8716h;
        try {
            Streams.m7555a(jsonElement, jsonWriter);
            jsonWriter.f8868c = z;
            jsonWriter.f8869d = z2;
            jsonWriter.f8870e = z3;
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable th) {
            jsonWriter.f8868c = z;
            jsonWriter.f8869d = z2;
            jsonWriter.f8870e = z3;
        }
    }

    public final <T> T m7480a(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        boolean z = jsonReader.f8838a;
        boolean z2 = true;
        jsonReader.f8838a = true;
        try {
            jsonReader.mo2475f();
            z2 = false;
            type = m7475a(TypeToken.m7571a(type)).mo2458a(jsonReader);
            jsonReader.f8838a = z;
            return type;
        } catch (Throwable e) {
            if (z2) {
                jsonReader.f8838a = z;
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        } catch (Throwable th) {
            jsonReader.f8838a = z;
        }
    }
}
