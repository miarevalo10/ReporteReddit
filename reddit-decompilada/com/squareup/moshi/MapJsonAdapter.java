package com.squareup.moshi;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.squareup.moshi.JsonAdapter.Factory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class MapJsonAdapter<K, V> extends JsonAdapter<Map<K, V>> {
    public static final Factory f30652a = new C25121();
    private final JsonAdapter<K> f30653b;
    private final JsonAdapter<V> f30654c;

    class C25121 implements Factory {
        C25121() {
        }

        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (set.isEmpty() == null) {
                return null;
            }
            set = Types.m25728b(type);
            if (set != Map.class) {
                return null;
            }
            type = Types.m25730b(type, set);
            return new MapJsonAdapter(moshi, type[0], type[1]).nullSafe();
        }
    }

    public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        Map map = (Map) obj;
        jsonWriter.mo5441c();
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() == null) {
                StringBuilder stringBuilder = new StringBuilder("Map key is null at ");
                stringBuilder.append(jsonWriter.m25695g());
                throw new JsonDataException(stringBuilder.toString());
            }
            int f = jsonWriter.m25694f();
            if (f == 5 || f == 3) {
                jsonWriter.f23658i = true;
                this.f30653b.toJson(jsonWriter, entry.getKey());
                this.f30654c.toJson(jsonWriter, entry.getValue());
            } else {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        jsonWriter.mo5443d();
    }

    MapJsonAdapter(Moshi moshi, Type type, Type type2) {
        this.f30653b = moshi.m25717a(type);
        this.f30654c = moshi.m25717a(type2);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("JsonAdapter(");
        stringBuilder.append(this.f30653b);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(this.f30654c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        jsonReader.mo5420c();
        while (jsonReader.mo5422e()) {
            jsonReader.mo5432q();
            Object fromJson = this.f30653b.fromJson(jsonReader);
            Object fromJson2 = this.f30654c.fromJson(jsonReader);
            Object put = linkedHashTreeMap.put(fromJson, fromJson2);
            if (put != null) {
                StringBuilder stringBuilder = new StringBuilder("Map key '");
                stringBuilder.append(fromJson);
                stringBuilder.append("' has multiple values at path ");
                stringBuilder.append(jsonReader.m25676p());
                stringBuilder.append(": ");
                stringBuilder.append(put);
                stringBuilder.append(" and ");
                stringBuilder.append(fromJson2);
                throw new JsonDataException(stringBuilder.toString());
            }
        }
        jsonReader.mo5421d();
        return linkedHashTreeMap;
    }
}
