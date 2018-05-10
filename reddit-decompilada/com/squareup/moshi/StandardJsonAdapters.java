package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader.Options;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class StandardJsonAdapters {
    public static final Factory f23694a = new C25131();
    static final JsonAdapter<Boolean> f23695b = new C25142();
    static final JsonAdapter<Byte> f23696c = new C25153();
    static final JsonAdapter<Character> f23697d = new C25164();
    static final JsonAdapter<Double> f23698e = new C25175();
    static final JsonAdapter<Float> f23699f = new C25186();
    static final JsonAdapter<Integer> f23700g = new C25197();
    static final JsonAdapter<Long> f23701h = new C25208();
    static final JsonAdapter<Short> f23702i = new C25219();
    static final JsonAdapter<String> f23703j = new JsonAdapter<String>() {
        public final String toString() {
            return "JsonAdapter(String)";
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5442c((String) obj);
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.mo5425h();
        }
    };

    class C25131 implements Factory {
        C25131() {
        }

        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (set.isEmpty() == null) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return StandardJsonAdapters.f23695b;
            }
            if (type == Byte.TYPE) {
                return StandardJsonAdapters.f23696c;
            }
            if (type == Character.TYPE) {
                return StandardJsonAdapters.f23697d;
            }
            if (type == Double.TYPE) {
                return StandardJsonAdapters.f23698e;
            }
            if (type == Float.TYPE) {
                return StandardJsonAdapters.f23699f;
            }
            if (type == Integer.TYPE) {
                return StandardJsonAdapters.f23700g;
            }
            if (type == Long.TYPE) {
                return StandardJsonAdapters.f23701h;
            }
            if (type == Short.TYPE) {
                return StandardJsonAdapters.f23702i;
            }
            if (type == Boolean.class) {
                return StandardJsonAdapters.f23695b.nullSafe();
            }
            if (type == Byte.class) {
                return StandardJsonAdapters.f23696c.nullSafe();
            }
            if (type == Character.class) {
                return StandardJsonAdapters.f23697d.nullSafe();
            }
            if (type == Double.class) {
                return StandardJsonAdapters.f23698e.nullSafe();
            }
            if (type == Float.class) {
                return StandardJsonAdapters.f23699f.nullSafe();
            }
            if (type == Integer.class) {
                return StandardJsonAdapters.f23700g.nullSafe();
            }
            if (type == Long.class) {
                return StandardJsonAdapters.f23701h.nullSafe();
            }
            if (type == Short.class) {
                return StandardJsonAdapters.f23702i.nullSafe();
            }
            if (type == String.class) {
                return StandardJsonAdapters.f23703j.nullSafe();
            }
            if (type == Object.class) {
                return new ObjectJsonAdapter(moshi).nullSafe();
            }
            type = Types.m25728b(type);
            if (type.isEnum() != null) {
                return new EnumJsonAdapter(type).nullSafe();
            }
            return null;
        }
    }

    class C25142 extends JsonAdapter<Boolean> {
        public final String toString() {
            return "JsonAdapter(Boolean)";
        }

        C25142() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5437a(((Boolean) obj).booleanValue());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Boolean.valueOf(jsonReader.mo5426i());
        }
    }

    class C25153 extends JsonAdapter<Byte> {
        public final String toString() {
            return "JsonAdapter(Byte)";
        }

        C25153() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5435a((long) (((Byte) obj).intValue() & 255));
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Byte.valueOf((byte) StandardJsonAdapters.m25719a(jsonReader, "a byte", -128, 255));
        }
    }

    class C25164 extends JsonAdapter<Character> {
        public final String toString() {
            return "JsonAdapter(Character)";
        }

        C25164() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5442c(((Character) obj).toString());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            String h = jsonReader.mo5425h();
            if (h.length() <= 1) {
                return Character.valueOf(h.charAt(0));
            }
            Object[] objArr = new Object[3];
            objArr[0] = "a char";
            StringBuilder stringBuilder = new StringBuilder("\"");
            stringBuilder.append(h);
            stringBuilder.append('\"');
            objArr[1] = stringBuilder.toString();
            objArr[2] = jsonReader.m25676p();
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", objArr));
        }
    }

    class C25175 extends JsonAdapter<Double> {
        public final String toString() {
            return "JsonAdapter(Double)";
        }

        C25175() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5434a(((Double) obj).doubleValue());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.mo5428k());
        }
    }

    class C25186 extends JsonAdapter<Float> {
        public final String toString() {
            return "JsonAdapter(Float)";
        }

        C25186() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Float) obj;
            if (number == null) {
                throw new NullPointerException();
            }
            jsonWriter.mo5436a(number);
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            float k = (float) jsonReader.mo5428k();
            if (jsonReader.f23649e || !Float.isInfinite(k)) {
                return Float.valueOf(k);
            }
            StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
            stringBuilder.append(k);
            stringBuilder.append(" at path ");
            stringBuilder.append(jsonReader.m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
    }

    class C25197 extends JsonAdapter<Integer> {
        public final String toString() {
            return "JsonAdapter(Integer)";
        }

        C25197() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5435a((long) ((Integer) obj).intValue());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Integer.valueOf(jsonReader.mo5430m());
        }
    }

    class C25208 extends JsonAdapter<Long> {
        public final String toString() {
            return "JsonAdapter(Long)";
        }

        C25208() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5435a(((Long) obj).longValue());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Long.valueOf(jsonReader.mo5429l());
        }
    }

    class C25219 extends JsonAdapter<Short> {
        public final String toString() {
            return "JsonAdapter(Short)";
        }

        C25219() {
        }

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5435a((long) ((Short) obj).intValue());
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            return Short.valueOf((short) StandardJsonAdapters.m25719a(jsonReader, "a short", -32768, 32767));
        }
    }

    static final class EnumJsonAdapter<T extends Enum<T>> extends JsonAdapter<T> {
        private final Class<T> f30657a;
        private final String[] f30658b;
        private final T[] f30659c;
        private final Options f30660d;

        public final /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            jsonWriter.mo5442c(this.f30658b[((Enum) obj).ordinal()]);
        }

        EnumJsonAdapter(Class<T> cls) {
            this.f30657a = cls;
            try {
                this.f30659c = (Enum[]) cls.getEnumConstants();
                this.f30658b = new String[this.f30659c.length];
                for (int i = 0; i < this.f30659c.length; i++) {
                    Enum enumR = this.f30659c[i];
                    Json json = (Json) cls.getField(enumR.name()).getAnnotation(Json.class);
                    this.f30658b[i] = json != null ? json.m25653a() : enumR.name();
                }
                this.f30660d = Options.m25654a(this.f30658b);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Missing field in ");
                stringBuilder.append(cls.getName());
                throw new AssertionError(stringBuilder.toString(), e);
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("JsonAdapter(");
            stringBuilder.append(this.f30657a.getName());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final /* synthetic */ Object fromJson(JsonReader jsonReader) throws IOException {
            int b = jsonReader.mo5418b(this.f30660d);
            if (b != -1) {
                return this.f30659c[b];
            }
            String h = jsonReader.mo5425h();
            StringBuilder stringBuilder = new StringBuilder("Expected one of ");
            stringBuilder.append(Arrays.asList(this.f30658b));
            stringBuilder.append(" but was ");
            stringBuilder.append(h);
            stringBuilder.append(" at path ");
            stringBuilder.append(jsonReader.m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
    }

    static final class ObjectJsonAdapter extends JsonAdapter<Object> {
        private final Moshi f30661a;

        public final String toString() {
            return "JsonAdapter(Object)";
        }

        ObjectJsonAdapter(Moshi moshi) {
            this.f30661a = moshi;
        }

        public final Object fromJson(JsonReader jsonReader) throws IOException {
            return jsonReader.m25675o();
        }

        public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
            Type type = obj.getClass();
            if (type == Object.class) {
                jsonWriter.mo5441c();
                jsonWriter.mo5443d();
                return;
            }
            Moshi moshi = this.f30661a;
            if (Map.class.isAssignableFrom(type)) {
                type = Map.class;
            } else if (Collection.class.isAssignableFrom(type)) {
                type = Collection.class;
            }
            moshi.m25718a(type, Util.f23711a).toJson(jsonWriter, obj);
        }
    }

    static int m25719a(JsonReader jsonReader, String str, int i, int i2) throws IOException {
        int m = jsonReader.mo5430m();
        if (m >= i) {
            if (m <= i2) {
                return m;
            }
        }
        throw new JsonDataException(String.format("Expected %s but was %s at path %s", new Object[]{str, Integer.valueOf(m), jsonReader.m25676p()}));
    }
}
