package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
    private static final Reader f15048c = new C04571();
    private static final Object f15049d = new Object();
    private Object[] f15050e = new Object[32];
    private int f15051f = 0;
    private String[] f15052g = new String[32];
    private int[] f15053h = new int[32];

    static class C04571 extends Reader {
        C04571() {
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(f15048c);
        m14990a((Object) jsonElement);
    }

    public final void mo2469a() throws IOException {
        m14989a(JsonToken.BEGIN_ARRAY);
        m14990a(((JsonArray) mo2476g()).iterator());
        this.f15053h[this.f15051f - 1] = 0;
    }

    public final void mo2470b() throws IOException {
        m14989a(JsonToken.END_ARRAY);
        m14986r();
        m14986r();
        if (this.f15051f > 0) {
            int[] iArr = this.f15053h;
            int i = this.f15051f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final void mo2471c() throws IOException {
        m14989a(JsonToken.BEGIN_OBJECT);
        m14990a(((JsonObject) mo2476g()).f14991a.entrySet().iterator());
    }

    public final void mo2473d() throws IOException {
        m14989a(JsonToken.END_OBJECT);
        m14986r();
        m14986r();
        if (this.f15051f > 0) {
            int[] iArr = this.f15053h;
            int i = this.f15051f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final boolean mo2474e() throws IOException {
        JsonToken f = mo2475f();
        return (f == JsonToken.END_OBJECT || f == JsonToken.END_ARRAY) ? false : true;
    }

    public final JsonToken mo2475f() throws IOException {
        while (this.f15051f != 0) {
            Object g = mo2476g();
            if (g instanceof Iterator) {
                boolean z = this.f15050e[this.f15051f - 2] instanceof JsonObject;
                Iterator it = (Iterator) g;
                if (!it.hasNext()) {
                    return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                } else {
                    if (z) {
                        return JsonToken.NAME;
                    }
                    m14990a(it.next());
                }
            } else if (g instanceof JsonObject) {
                return JsonToken.BEGIN_OBJECT;
            } else {
                if (g instanceof JsonArray) {
                    return JsonToken.BEGIN_ARRAY;
                }
                if (g instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitive = (JsonPrimitive) g;
                    if (jsonPrimitive.f14993a instanceof String) {
                        return JsonToken.STRING;
                    }
                    if (jsonPrimitive.f14993a instanceof Boolean) {
                        return JsonToken.BOOLEAN;
                    }
                    if (jsonPrimitive.f14993a instanceof Number) {
                        return JsonToken.NUMBER;
                    }
                    throw new AssertionError();
                } else if (g instanceof JsonNull) {
                    return JsonToken.NULL;
                } else {
                    if (g == f15049d) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return JsonToken.END_DOCUMENT;
    }

    public final Object mo2476g() {
        return this.f15050e[this.f15051f - 1];
    }

    private Object m14986r() {
        Object[] objArr = this.f15050e;
        int i = this.f15051f - 1;
        this.f15051f = i;
        Object obj = objArr[i];
        this.f15050e[this.f15051f] = null;
        return obj;
    }

    public final void m14989a(JsonToken jsonToken) throws IOException {
        if (mo2475f() != jsonToken) {
            StringBuilder stringBuilder = new StringBuilder("Expected ");
            stringBuilder.append(jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(mo2475f());
            stringBuilder.append(m14987s());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final String mo2477h() throws IOException {
        m14989a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) mo2476g()).next();
        String str = (String) entry.getKey();
        this.f15052g[this.f15051f - 1] = str;
        m14990a(entry.getValue());
        return str;
    }

    public final String mo2478i() throws IOException {
        JsonToken f = mo2475f();
        if (f == JsonToken.STRING || f == JsonToken.NUMBER) {
            String c = ((JsonPrimitive) m14986r()).mo2461c();
            if (this.f15051f > 0) {
                int[] iArr = this.f15053h;
                int i = this.f15051f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return c;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.STRING);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m14987s());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final boolean mo2479j() throws IOException {
        m14989a(JsonToken.BOOLEAN);
        boolean g = ((JsonPrimitive) m14986r()).mo2465g();
        if (this.f15051f > 0) {
            int[] iArr = this.f15053h;
            int i = this.f15051f - 1;
            iArr[i] = iArr[i] + 1;
        }
        return g;
    }

    public final void mo2480k() throws IOException {
        m14989a(JsonToken.NULL);
        m14986r();
        if (this.f15051f > 0) {
            int[] iArr = this.f15053h;
            int i = this.f15051f - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    public final double mo2481l() throws IOException {
        JsonToken f = mo2475f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            double d = ((JsonPrimitive) mo2476g()).mo2462d();
            if (this.f8838a || !(Double.isNaN(d) || Double.isInfinite(d))) {
                m14986r();
                if (this.f15051f > 0) {
                    int[] iArr = this.f15053h;
                    int i = this.f15051f - 1;
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
        stringBuilder2.append(m14987s());
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public final long mo2482m() throws IOException {
        JsonToken f = mo2475f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            long e = ((JsonPrimitive) mo2476g()).mo2463e();
            m14986r();
            if (this.f15051f > 0) {
                int[] iArr = this.f15053h;
                int i = this.f15051f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.NUMBER);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m14987s());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final int mo2483n() throws IOException {
        JsonToken f = mo2475f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            int f2 = ((JsonPrimitive) mo2476g()).mo2464f();
            m14986r();
            if (this.f15051f > 0) {
                int[] iArr = this.f15053h;
                int i = this.f15051f - 1;
                iArr[i] = iArr[i] + 1;
            }
            return f2;
        }
        StringBuilder stringBuilder = new StringBuilder("Expected ");
        stringBuilder.append(JsonToken.NUMBER);
        stringBuilder.append(" but was ");
        stringBuilder.append(f);
        stringBuilder.append(m14987s());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void close() throws IOException {
        this.f15050e = new Object[]{f15049d};
        this.f15051f = 1;
    }

    public final void mo2484o() throws IOException {
        if (mo2475f() == JsonToken.NAME) {
            mo2477h();
            this.f15052g[this.f15051f - 2] = "null";
        } else {
            m14986r();
            this.f15052g[this.f15051f - 1] = "null";
        }
        int[] iArr = this.f15053h;
        int i = this.f15051f - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void m14990a(Object obj) {
        if (this.f15051f == this.f15050e.length) {
            Object obj2 = new Object[(this.f15051f * 2)];
            Object obj3 = new int[(this.f15051f * 2)];
            Object obj4 = new String[(this.f15051f * 2)];
            System.arraycopy(this.f15050e, 0, obj2, 0, this.f15051f);
            System.arraycopy(this.f15053h, 0, obj3, 0, this.f15051f);
            System.arraycopy(this.f15052g, 0, obj4, 0, this.f15051f);
            this.f15050e = obj2;
            this.f15053h = obj3;
            this.f15052g = obj4;
        }
        Object[] objArr = this.f15050e;
        int i = this.f15051f;
        this.f15051f = i + 1;
        objArr[i] = obj;
    }

    public final String mo2485p() {
        StringBuilder stringBuilder = new StringBuilder("$");
        int i = 0;
        while (i < this.f15051f) {
            if (this.f15050e[i] instanceof JsonArray) {
                i++;
                if (this.f15050e[i] instanceof Iterator) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.f15053h[i]);
                    stringBuilder.append(']');
                }
            } else if (this.f15050e[i] instanceof JsonObject) {
                i++;
                if (this.f15050e[i] instanceof Iterator) {
                    stringBuilder.append('.');
                    if (this.f15052g[i] != null) {
                        stringBuilder.append(this.f15052g[i]);
                    }
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    private String m14987s() {
        StringBuilder stringBuilder = new StringBuilder(" at path ");
        stringBuilder.append(mo2485p());
        return stringBuilder.toString();
    }
}
