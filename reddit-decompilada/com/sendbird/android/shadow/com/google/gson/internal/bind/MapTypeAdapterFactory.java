package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.C$Gson$Types;
import com.sendbird.android.shadow.com.google.gson.internal.ConstructorConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.JsonReaderInternalAccess;
import com.sendbird.android.shadow.com.google.gson.internal.ObjectConstructor;
import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean f30307a = null;
    private final ConstructorConstructor f30308b;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        final /* synthetic */ MapTypeAdapterFactory f30303a;
        private final TypeAdapter<K> f30304b;
        private final TypeAdapter<V> f30305c;
        private final ObjectConstructor<? extends Map<K, V>> f30306d;

        public final /* synthetic */ void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.mo5281e();
            } else if (this.f30303a.f30307a) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i = 0;
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    int i3;
                    JsonElement a = this.f30304b.m25080a(entry.getKey());
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
                    jsonWriter.mo5270a();
                    obj = arrayList.size();
                    while (i < obj) {
                        jsonWriter.mo5270a();
                        Streams.m25127a((JsonElement) arrayList.get(i), jsonWriter);
                        this.f30305c.mo5242a(jsonWriter, arrayList2.get(i));
                        jsonWriter.mo5276b();
                        i++;
                    }
                    jsonWriter.mo5276b();
                    return;
                }
                jsonWriter.mo5278c();
                obj = arrayList.size();
                while (i < obj) {
                    String valueOf;
                    JsonElement jsonElement = (JsonElement) arrayList.get(i);
                    if (jsonElement instanceof JsonPrimitive) {
                        JsonPrimitive j = jsonElement.m25075j();
                        if (j.f30237a instanceof Number) {
                            valueOf = String.valueOf(j.mo5243b());
                        } else if (j.f30237a instanceof Boolean) {
                            valueOf = Boolean.toString(j.mo5248g());
                        } else if (j.f30237a instanceof String) {
                            valueOf = j.mo5244c();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (jsonElement instanceof JsonNull) {
                        valueOf = "null";
                    } else {
                        throw new AssertionError();
                    }
                    jsonWriter.mo5274a(valueOf);
                    this.f30305c.mo5242a(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.mo5280d();
            } else {
                jsonWriter.mo5278c();
                for (Entry entry2 : map.entrySet()) {
                    jsonWriter.mo5274a(String.valueOf(entry2.getKey()));
                    this.f30305c.mo5242a(jsonWriter, entry2.getValue());
                }
                jsonWriter.mo5280d();
            }
        }

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f30303a = mapTypeAdapterFactory;
            this.f30304b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f30305c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f30306d = objectConstructor;
        }

        public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
            JsonToken f = jsonReader.mo5258f();
            if (f == JsonToken.NULL) {
                jsonReader.mo5263k();
                return null;
            }
            Map map = (Map) this.f30306d.mo5249a();
            Object a;
            StringBuilder stringBuilder;
            if (f == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo5252a();
                while (jsonReader.mo5257e()) {
                    jsonReader.mo5252a();
                    a = this.f30304b.mo5241a(jsonReader);
                    if (map.put(a, this.f30305c.mo5241a(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(a);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                    jsonReader.mo5253b();
                }
                jsonReader.mo5253b();
            } else {
                jsonReader.mo5254c();
                while (jsonReader.mo5257e()) {
                    JsonReaderInternalAccess.f22910a.mo5286a(jsonReader);
                    a = this.f30304b.mo5241a(jsonReader);
                    if (map.put(a, this.f30305c.mo5241a(jsonReader)) != null) {
                        stringBuilder = new StringBuilder("duplicate key: ");
                        stringBuilder.append(a);
                        throw new JsonSyntaxException(stringBuilder.toString());
                    }
                }
                jsonReader.mo5256d();
            }
            return map;
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f30308b = constructorConstructor;
    }

    public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.f22997b;
        if (!Map.class.isAssignableFrom(typeToken.f22996a)) {
            return null;
        }
        TypeAdapter a;
        Type[] b = C$Gson$Types.m25104b(type, C$Gson$Types.m25102b(type));
        Type type2 = b[0];
        if (type2 != Boolean.TYPE) {
            if (type2 != Boolean.class) {
                a = gson.m25062a(TypeToken.m25142a(type2));
                return new Adapter(this, gson, b[0], a, b[1], gson.m25062a(TypeToken.m25142a(b[1])), this.f30308b.m25110a((TypeToken) typeToken));
            }
        }
        a = TypeAdapters.f22974f;
        return new Adapter(this, gson, b[0], a, b[1], gson.m25062a(TypeToken.m25142a(b[1])), this.f30308b.m25110a((TypeToken) typeToken));
    }
}
