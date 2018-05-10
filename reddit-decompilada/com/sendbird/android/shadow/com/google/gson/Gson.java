package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Excluder;
import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.internal.bind.ArrayTypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.bind.DateTypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.bind.ObjectTypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.TimeTypeAdapter;
import com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
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
    private static final TypeToken<?> f22886a = TypeToken.m25141a(Object.class);
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> f22887b;
    private final Map<TypeToken<?>, TypeAdapter<?>> f22888c;
    private final List<TypeAdapterFactory> f22889d;
    private final ConstructorConstructor f22890e;
    private final Excluder f22891f;
    private final FieldNamingStrategy f22892g;
    private final boolean f22893h;
    private final boolean f22894i;
    private final boolean f22895j;
    private final boolean f22896k;
    private final boolean f22897l;
    private final JsonAdapterAnnotationTypeAdapterFactory f22898m;

    class C24191 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f30228a;

        C24191(Gson gson) {
            this.f30228a = gson;
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo5281e();
                return;
            }
            Gson.m25060a(number.doubleValue());
            jsonWriter.mo5273a(number);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.mo5264l());
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    class C24202 extends TypeAdapter<Number> {
        final /* synthetic */ Gson f30229a;

        C24202(Gson gson) {
            this.f30229a = gson;
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo5281e();
                return;
            }
            Gson.m25060a((double) number.floatValue());
            jsonWriter.mo5273a(number);
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.mo5264l());
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    static class C24213 extends TypeAdapter<Number> {
        C24213() {
        }

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.mo5281e();
            } else {
                jsonWriter.mo5277b(number.toString());
            }
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo5258f() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.mo5265m());
            }
            jsonReader.mo5263k();
            return null;
        }
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        TypeAdapter<T> f30232a;

        FutureTypeAdapter() {
        }

        public final T mo5241a(JsonReader jsonReader) throws IOException {
            if (this.f30232a != null) {
                return this.f30232a.mo5241a(jsonReader);
            }
            throw new IllegalStateException();
        }

        public final void mo5242a(JsonWriter jsonWriter, T t) throws IOException {
            if (this.f30232a == null) {
                throw new IllegalStateException();
            }
            this.f30232a.mo5242a(jsonWriter, t);
        }
    }

    public Gson() {
        this(Excluder.f30268a, FieldNamingPolicy.f30222a, Collections.emptyMap(), LongSerializationPolicy.f22899a, Collections.emptyList());
    }

    private Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.f22887b = new ThreadLocal();
        this.f22888c = new ConcurrentHashMap();
        this.f22890e = new ConstructorConstructor(map);
        this.f22891f = excluder;
        this.f22892g = fieldNamingStrategy;
        this.f22893h = false;
        this.f22895j = false;
        this.f22894i = true;
        this.f22896k = false;
        this.f22897l = false;
        map = new ArrayList();
        map.add(TypeAdapters.f22967Y);
        map.add(ObjectTypeAdapter.f30309a);
        map.add(excluder);
        map.addAll(list);
        map.add(TypeAdapters.f22946D);
        map.add(TypeAdapters.f22981m);
        map.add(TypeAdapters.f22975g);
        map.add(TypeAdapters.f22977i);
        map.add(TypeAdapters.f22979k);
        if (longSerializationPolicy == LongSerializationPolicy.f22899a) {
            longSerializationPolicy = TypeAdapters.f22988t;
        } else {
            longSerializationPolicy = new C24213();
        }
        map.add(TypeAdapters.m25135a(Long.TYPE, Long.class, longSerializationPolicy));
        map.add(TypeAdapters.m25135a(Double.TYPE, Double.class, new C24191(this)));
        map.add(TypeAdapters.m25135a(Float.TYPE, Float.class, new C24202(this)));
        map.add(TypeAdapters.f22992x);
        map.add(TypeAdapters.f22983o);
        map.add(TypeAdapters.f22985q);
        map.add(TypeAdapters.m25134a(AtomicLong.class, new TypeAdapter<AtomicLong>() {
            public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
                longSerializationPolicy.mo5242a(jsonWriter, Long.valueOf(((AtomicLong) obj).get()));
            }

            public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) longSerializationPolicy.mo5241a(jsonReader)).longValue());
            }
        }.m25081a()));
        map.add(TypeAdapters.m25134a(AtomicLongArray.class, new TypeAdapter<AtomicLongArray>() {
            public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                jsonWriter.mo5270a();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    longSerializationPolicy.mo5242a(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.mo5276b();
            }

            public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
                List arrayList = new ArrayList();
                jsonReader.mo5252a();
                while (jsonReader.mo5257e()) {
                    arrayList.add(Long.valueOf(((Number) longSerializationPolicy.mo5241a(jsonReader)).longValue()));
                }
                jsonReader.mo5253b();
                jsonReader = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(jsonReader);
                for (int i = 0; i < jsonReader; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.m25081a()));
        map.add(TypeAdapters.f22987s);
        map.add(TypeAdapters.f22994z);
        map.add(TypeAdapters.f22948F);
        map.add(TypeAdapters.f22950H);
        map.add(TypeAdapters.m25134a(BigDecimal.class, TypeAdapters.f22944B));
        map.add(TypeAdapters.m25134a(BigInteger.class, TypeAdapters.f22945C));
        map.add(TypeAdapters.f22952J);
        map.add(TypeAdapters.f22954L);
        map.add(TypeAdapters.f22958P);
        map.add(TypeAdapters.f22960R);
        map.add(TypeAdapters.f22965W);
        map.add(TypeAdapters.f22956N);
        map.add(TypeAdapters.f22972d);
        map.add(DateTypeAdapter.f30288a);
        map.add(TypeAdapters.f22963U);
        map.add(TimeTypeAdapter.f30326a);
        map.add(SqlDateTypeAdapter.f30324a);
        map.add(TypeAdapters.f22961S);
        map.add(ArrayTypeAdapter.f30282a);
        map.add(TypeAdapters.f22970b);
        map.add(new CollectionTypeAdapterFactory(this.f22890e));
        map.add(new MapTypeAdapterFactory(this.f22890e));
        this.f22898m = new JsonAdapterAnnotationTypeAdapterFactory(this.f22890e);
        map.add(this.f22898m);
        map.add(TypeAdapters.f22968Z);
        map.add(new ReflectiveTypeAdapterFactory(this.f22890e, fieldNamingStrategy, excluder, this.f22898m));
        this.f22889d = Collections.unmodifiableList(map);
    }

    static void m25060a(double d) {
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

    public final <T> TypeAdapter<T> m25062a(TypeToken<T> typeToken) {
        TypeAdapter<T> typeAdapter = (TypeAdapter) this.f22888c.get(typeToken == null ? f22886a : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = (Map) this.f22887b.get();
        Object obj = null;
        if (map == null) {
            map = new HashMap();
            this.f22887b.set(map);
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
            Iterator it = this.f22889d.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext != null) {
                    hasNext = ((TypeAdapterFactory) it.next()).mo5250a(this, typeToken);
                    if (hasNext != null) {
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("GSON cannot handle ");
                stringBuilder.append(typeToken);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (futureTypeAdapter.f30232a != null) {
                throw new AssertionError();
            }
            futureTypeAdapter.f30232a = hasNext;
            this.f22888c.put(typeToken, hasNext);
            return hasNext;
        } finally {
            map.remove(typeToken);
            if (obj != null) {
                this.f22887b.remove();
            }
        }
    }

    public final <T> TypeAdapter<T> m25061a(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f22889d.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f22898m;
        }
        Object obj = null;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f22889d) {
            if (obj != null) {
                TypeAdapter<T> a = typeAdapterFactory2.mo5250a(this, typeToken);
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

    public final <T> TypeAdapter<T> m25063a(Class<T> cls) {
        return m25062a(TypeToken.m25141a((Class) cls));
    }

    public final String m25064a(JsonElement jsonElement) {
        boolean z;
        boolean z2;
        boolean z3;
        Appendable stringWriter = new StringWriter();
        JsonWriter jsonWriter;
        try {
            Writer a = Streams.m25126a(stringWriter);
            if (this.f22895j) {
                a.write(")]}'\n");
            }
            jsonWriter = new JsonWriter(a);
            if (this.f22896k) {
                String str = "  ";
                if (str.length() == 0) {
                    jsonWriter.f23028c = null;
                    jsonWriter.f23029d = ":";
                } else {
                    jsonWriter.f23028c = str;
                    jsonWriter.f23029d = ": ";
                }
            }
            jsonWriter.f23032g = this.f22893h;
            z = jsonWriter.f23030e;
            jsonWriter.f23030e = true;
            z2 = jsonWriter.f23031f;
            jsonWriter.f23031f = this.f22894i;
            z3 = jsonWriter.f23032g;
            jsonWriter.f23032g = this.f22893h;
            Streams.m25127a(jsonElement, jsonWriter);
            jsonWriter.f23030e = z;
            jsonWriter.f23031f = z2;
            jsonWriter.f23032g = z3;
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        } catch (Throwable th) {
            jsonWriter.f23030e = z;
            jsonWriter.f23031f = z2;
            jsonWriter.f23032g = z3;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.f22893h);
        stringBuilder.append(",factories:");
        stringBuilder.append(this.f22889d);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append(this.f22890e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
