package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean f15063a;
    private final ConstructorConstructor f15064b;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        final /* synthetic */ MapTypeAdapterFactory f15059a;
        private final TypeAdapter<K> f15060b;
        private final TypeAdapter<V> f15061c;
        private final ObjectConstructor<? extends Map<K, V>> f15062d;

        public final /* synthetic */ void mo2459a(JsonWriter jsonWriter, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.mo2499f();
            } else if (this.f15059a.f15063a) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i = 0;
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    int i3;
                    JsonElement a = this.f15060b.m7507a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    if (!(a instanceof JsonArray)) {
                        if (!(a instanceof JsonObject)) {
                            i3 = 0;
                            i2 |= i3;
                        }
                    }
                    i3 = 1;
                    i2 |= i3;
                }
                if (i2 != 0) {
                    jsonWriter.mo2493b();
                    while (i < arrayList.size()) {
                        jsonWriter.mo2493b();
                        Streams.m7555a((JsonElement) arrayList.get(i), jsonWriter);
                        this.f15061c.mo2459a(jsonWriter, arrayList2.get(i));
                        jsonWriter.mo2495c();
                        i++;
                    }
                    jsonWriter.mo2495c();
                    return;
                }
                jsonWriter.mo2497d();
                while (i < arrayList.size()) {
                    String valueOf;
                    JsonElement jsonElement = (JsonElement) arrayList.get(i);
                    if (jsonElement instanceof JsonPrimitive) {
                        obj = jsonElement.m7502j();
                        if (obj.f14993a instanceof Number) {
                            valueOf = String.valueOf(obj.mo2460b());
                        } else if (obj.f14993a instanceof Boolean) {
                            valueOf = Boolean.toString(obj.mo2465g());
                        } else if (obj.f14993a instanceof String) {
                            valueOf = obj.mo2461c();
                        } else {
                            throw new AssertionError();
                        }
                    } else if ((jsonElement instanceof JsonNull) != null) {
                        valueOf = "null";
                    } else {
                        throw new AssertionError();
                    }
                    jsonWriter.mo2491a(valueOf);
                    this.f15061c.mo2459a(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.mo2498e();
            } else {
                jsonWriter.mo2497d();
                for (Entry entry2 : map.entrySet()) {
                    jsonWriter.mo2491a(String.valueOf(entry2.getKey()));
                    this.f15061c.mo2459a(jsonWriter, entry2.getValue());
                }
                jsonWriter.mo2498e();
            }
        }

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f15059a = mapTypeAdapterFactory;
            this.f15060b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f15061c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f15062d = objectConstructor;
        }

        public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo2475f();
            if (f == JsonToken.NULL) {
                jsonReader.mo2480k();
                return null;
            }
            Map map = (Map) this.f15062d.mo2466a();
            Object a;
            StringBuilder stringBuilder;
            if (f == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo2469a();
                while (jsonReader.mo2474e()) {
                    jsonReader.mo2469a();
                    a = this.f15060b.mo2458a(jsonReader);
                    if (map.put(a, this.f15061c.mo2458a(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(a);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                    jsonReader.mo2470b();
                }
                jsonReader.mo2470b();
            } else {
                jsonReader.mo2471c();
                while (jsonReader.mo2474e()) {
                    JsonReaderInternalAccess.f8749a.mo2505a(jsonReader);
                    a = this.f15060b.mo2458a(jsonReader);
                    if (map.put(a, this.f15061c.mo2458a(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(a);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                }
                jsonReader.mo2473d();
            }
            return map;
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f15064b = constructorConstructor;
        this.f15063a = z;
    }

    public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.f8835b;
        if (!Map.class.isAssignableFrom(typeToken.f8834a)) {
            return null;
        }
        TypeAdapter a;
        Type[] b = C$Gson$Types.m7531b(type, C$Gson$Types.m7529b(type));
        Type type2 = b[0];
        if (type2 != Boolean.TYPE) {
            if (type2 != Boolean.class) {
                a = gson.m7475a(TypeToken.m7571a(type2));
                return new Adapter(this, gson, b[0], a, b[1], gson.m7475a(TypeToken.m7571a(b[1])), this.f15064b.m7537a((TypeToken) typeToken));
            }
        }
        a = TypeAdapters.f8812f;
        return new Adapter(this, gson, b[0], a, b[1], gson.m7475a(TypeToken.m7571a(b[1])), this.f15064b.m7537a((TypeToken) typeToken));
    }
}
