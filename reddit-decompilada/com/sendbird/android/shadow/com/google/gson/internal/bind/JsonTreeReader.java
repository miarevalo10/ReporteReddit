package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonPrimitive;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
    private static final Reader f30292c = new C20321();
    private static final Object f30293d = new Object();
    private Object[] f30294e;
    private int f30295f;
    private String[] f30296g;
    private int[] f30297h;

    static class C20321 extends Reader {
        C20321() {
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    }

    public final void mo5252a() throws IOException {
        m31186a(JsonToken.BEGIN_ARRAY);
        m31187a(((JsonArray) mo5259g()).iterator());
        this.f30297h[this.f30295f - 1] = 0;
    }

    public final void mo5253b() throws IOException {
        m31186a(JsonToken.END_ARRAY);
        m31183s();
        m31183s();
        if (this.f30295f > 0) {
            int[] iArr = this.f30297h;
            int i = this.f30295f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final void mo5254c() throws IOException {
        m31186a(JsonToken.BEGIN_OBJECT);
        m31187a(((JsonObject) mo5259g()).f30235a.entrySet().iterator());
    }

    public final void mo5256d() throws IOException {
        m31186a(JsonToken.END_OBJECT);
        m31183s();
        m31183s();
        if (this.f30295f > 0) {
            int[] iArr = this.f30297h;
            int i = this.f30295f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final boolean mo5257e() throws IOException {
        JsonToken f = mo5258f();
        return (f == JsonToken.END_OBJECT || f == JsonToken.END_ARRAY) ? false : true;
    }

    public final JsonToken mo5258f() throws IOException {
        while (this.f30295f != 0) {
            Object g = mo5259g();
            if (g instanceof Iterator) {
                boolean z = this.f30294e[this.f30295f - 2] instanceof JsonObject;
                Iterator it = (Iterator) g;
                if (!it.hasNext()) {
                    return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                } else {
                    if (z) {
                        return JsonToken.NAME;
                    }
                    m31187a(it.next());
                }
            } else if (g instanceof JsonObject) {
                return JsonToken.BEGIN_OBJECT;
            } else {
                if (g instanceof JsonArray) {
                    return JsonToken.BEGIN_ARRAY;
                }
                if (g instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) g;
                    if (jsonPrimitive.f30237a instanceof String) {
                        return JsonToken.STRING;
                    }
                    if (jsonPrimitive.f30237a instanceof Boolean) {
                        return JsonToken.BOOLEAN;
                    }
                    if (jsonPrimitive.f30237a instanceof Number) {
                        return JsonToken.NUMBER;
                    }
                    throw new AssertionError();
                } else if (g instanceof JsonNull) {
                    return JsonToken.NULL;
                } else {
                    if (g == f30293d) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return JsonToken.END_DOCUMENT;
    }

    public final Object mo5259g() {
        return this.f30294e[this.f30295f - 1];
    }

    private Object m31183s() {
        Object[] objArr = this.f30294e;
        int i = this.f30295f - 1;
        this.f30295f = i;
        Object obj = objArr[i];
        this.f30294e[this.f30295f] = null;
        return obj;
    }

    public final void m31186a(JsonToken jsonToken) throws IOException {
        if (mo5258f() != jsonToken) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append(jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(mo5258f());
            stringBuilder.append(m31184t());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final String mo5260h() throws IOException {
        m31186a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) mo5259g()).next();
        String str = (String) entry.getKey();
        this.f30296g[this.f30295f - 1] = str;
        m31187a(entry.getValue());
        return str;
    }

    public final String mo5261i() throws IOException {
        JsonToken f = mo5258f();
        if (f == JsonToken.STRING || f == JsonToken.NUMBER) {
            String c = ((JsonPrimitive) m31183s()).mo5244c();
            if (this.f30295f > 0) {
                int[] iArr = this.f30297h;
                int i = this.f30295f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return c;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.STRING);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m31184t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final boolean mo5262j() throws IOException {
        m31186a(JsonToken.BOOLEAN);
        boolean g = ((JsonPrimitive) m31183s()).mo5248g();
        if (this.f30295f > 0) {
            int[] iArr = this.f30297h;
            int i = this.f30295f - 1;
            iArr[i] = iArr[i] + 1;
        }
        return g;
    }

    public final void mo5263k() throws IOException {
        m31186a(JsonToken.NULL);
        m31183s();
        if (this.f30295f > 0) {
            int[] iArr = this.f30297h;
            int i = this.f30295f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final double mo5264l() throws IOException {
        JsonToken f = mo5258f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            double d = ((JsonPrimitive) mo5259g()).mo5245d();
            if (this.f23000a || !(Double.isNaN(d) || Double.isInfinite(d))) {
                m31183s();
                if (this.f30295f > 0) {
                    int[] iArr = this.f30297h;
                    int i = this.f30295f - 1;
                    iArr[i] = iArr[i] + 1;
                }
                return d;
            }
            StringBuilder stringBuilder = new StringBuilder("JSON forbids NaN and infinities: ");
            stringBuilder.append(d);
            throw new NumberFormatException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("Expected ");
        stringBuilder2.append(JsonToken.NUMBER);
        stringBuilder2.append(" but was ");
        stringBuilder2.append(f);
        stringBuilder2.append(m31184t());
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public final long mo5265m() throws IOException {
        JsonToken f = mo5258f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            long e = ((JsonPrimitive) mo5259g()).mo5246e();
            m31183s();
            if (this.f30295f > 0) {
                int[] iArr = this.f30297h;
                int i = this.f30295f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.NUMBER);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m31184t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final int mo5266n() throws IOException {
        JsonToken f = mo5258f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            int f2 = ((JsonPrimitive) mo5259g()).mo5247f();
            m31183s();
            if (this.f30295f > 0) {
                int[] iArr = this.f30297h;
                int i = this.f30295f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return f2;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.NUMBER);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m31184t());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void close() throws IOException {
        this.f30294e = new Object[]{f30293d};
        this.f30295f = 1;
    }

    public final void mo5267o() throws IOException {
        if (mo5258f() == JsonToken.NAME) {
            mo5260h();
            this.f30296g[this.f30295f - 2] = "null";
        } else {
            m31183s();
            if (this.f30295f > 0) {
                this.f30296g[this.f30295f - 1] = "null";
            }
        }
        if (this.f30295f > 0) {
            int[] iArr = this.f30297h;
            int i = this.f30295f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void m31187a(Object obj) {
        if (this.f30295f == this.f30294e.length) {
            Object obj2 = new Object[(this.f30295f * 2)];
            Object obj3 = new int[(this.f30295f * 2)];
            Object obj4 = new String[(this.f30295f * 2)];
            System.arraycopy(this.f30294e, 0, obj2, 0, this.f30295f);
            System.arraycopy(this.f30297h, 0, obj3, 0, this.f30295f);
            System.arraycopy(this.f30296g, 0, obj4, 0, this.f30295f);
            this.f30294e = obj2;
            this.f30297h = obj3;
            this.f30296g = obj4;
        }
        Object[] objArr = this.f30294e;
        int i = this.f30295f;
        this.f30295f = i + 1;
        objArr[i] = obj;
    }

    public final String mo5268p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int i = 0;
        while (i < this.f30295f) {
            if (this.f30294e[i] instanceof JsonArray) {
                i++;
                if (this.f30294e[i] instanceof Iterator) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.f30297h[i]);
                    stringBuilder.append(']');
                }
            } else if (this.f30294e[i] instanceof JsonObject) {
                i++;
                if (this.f30294e[i] instanceof Iterator) {
                    stringBuilder.append('.');
                    if (this.f30296g[i] != null) {
                        stringBuilder.append(this.f30296g[i]);
                    }
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    private String m31184t() {
        StringBuilder stringBuilder = new StringBuilder(" at path ");
        stringBuilder.append(mo5268p());
        return stringBuilder.toString();
    }
}
