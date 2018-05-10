package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {
    int f23645a = 0;
    final int[] f23646b = new int[32];
    final String[] f23647c = new String[32];
    final int[] f23648d = new int[32];
    boolean f23649e;
    boolean f23650f;

    public static final class Options {
        final String[] f23632a;
        final okio.Options f23633b;

        private Options(String[] strArr, okio.Options options) {
            this.f23632a = strArr;
            this.f23633b = options;
        }

        public static Options m25654a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                BufferedSink buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonUtf8Writer.m31626a(buffer, strArr[i]);
                    buffer.mo6773g();
                    byteStringArr[i] = buffer.m36534o();
                }
                return new Options((String[]) strArr.clone(), okio.Options.m28302a(byteStringArr));
            } catch (String[] strArr2) {
                throw new AssertionError(strArr2);
            }
        }
    }

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract int mo5416a(Options options) throws IOException;

    public abstract void mo5417a() throws IOException;

    public abstract int mo5418b(Options options) throws IOException;

    public abstract void mo5419b() throws IOException;

    public abstract void mo5420c() throws IOException;

    public abstract void mo5421d() throws IOException;

    public abstract boolean mo5422e() throws IOException;

    public abstract Token mo5423f() throws IOException;

    public abstract String mo5424g() throws IOException;

    public abstract String mo5425h() throws IOException;

    public abstract boolean mo5426i() throws IOException;

    public abstract <T> T mo5427j() throws IOException;

    public abstract double mo5428k() throws IOException;

    public abstract long mo5429l() throws IOException;

    public abstract int mo5430m() throws IOException;

    public abstract void mo5431n() throws IOException;

    abstract void mo5432q() throws IOException;

    public static JsonReader m25655a(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    JsonReader() {
    }

    final void m25660a(int i) {
        if (this.f23645a == this.f23646b.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        int[] iArr = this.f23646b;
        int i2 = this.f23645a;
        this.f23645a = i2 + 1;
        iArr[i2] = i;
    }

    final JsonEncodingException m25658a(String str) throws JsonEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" at path ");
        stringBuilder.append(m25676p());
        throw new JsonEncodingException(stringBuilder.toString());
    }

    final JsonDataException m25657a(Object obj, Object obj2) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append(obj2);
            stringBuilder.append(" but was null at path ");
            stringBuilder.append(m25676p());
            return new JsonDataException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("Expected ");
        stringBuilder2.append(obj2);
        stringBuilder2.append(" but was ");
        stringBuilder2.append(obj);
        stringBuilder2.append(", a ");
        stringBuilder2.append(obj.getClass().getName());
        stringBuilder2.append(", at path ");
        stringBuilder2.append(m25676p());
        return new JsonDataException(stringBuilder2.toString());
    }

    public final Object m25675o() throws IOException {
        switch (mo5423f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                mo5417a();
                while (mo5422e()) {
                    arrayList.add(m25675o());
                }
                mo5419b();
                return arrayList;
            case BEGIN_OBJECT:
                Map linkedHashTreeMap = new LinkedHashTreeMap();
                mo5420c();
                while (mo5422e()) {
                    String g = mo5424g();
                    Object o = m25675o();
                    Object put = linkedHashTreeMap.put(g, o);
                    if (put != null) {
                        StringBuilder stringBuilder = new StringBuilder("Map key '");
                        stringBuilder.append(g);
                        stringBuilder.append("' has multiple values at path ");
                        stringBuilder.append(m25676p());
                        stringBuilder.append(": ");
                        stringBuilder.append(put);
                        stringBuilder.append(" and ");
                        stringBuilder.append(o);
                        throw new JsonDataException(stringBuilder.toString());
                    }
                }
                mo5421d();
                return linkedHashTreeMap;
            case STRING:
                return mo5425h();
            case NUMBER:
                return Double.valueOf(mo5428k());
            case BOOLEAN:
                return Boolean.valueOf(mo5426i());
            case NULL:
                return mo5427j();
            default:
                StringBuilder stringBuilder2 = new StringBuilder("Expected a value but was ");
                stringBuilder2.append(mo5423f());
                stringBuilder2.append(" at path ");
                stringBuilder2.append(m25676p());
                throw new IllegalStateException(stringBuilder2.toString());
        }
    }

    public final String m25676p() {
        return JsonScope.m25678a(this.f23645a, this.f23646b, this.f23647c, this.f23648d);
    }
}
