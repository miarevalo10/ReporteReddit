package com.squareup.moshi;

import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonReader.Token;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class JsonValueReader extends JsonReader {
    private static final Object f30646g = new Object();
    private final Object[] f30647h = new Object[32];

    JsonValueReader(Object obj) {
        this.b[this.a] = 7;
        Object[] objArr = this.f30647h;
        int i = this.a;
        this.a = i + 1;
        objArr[i] = obj;
    }

    public final void mo5417a() throws IOException {
        ListIterator listIterator = ((List) m31642a(List.class, Token.BEGIN_ARRAY)).listIterator();
        this.f30647h[this.a - 1] = listIterator;
        this.b[this.a - 1] = 1;
        this.d[this.a - 1] = 0;
        if (listIterator.hasNext()) {
            m31644a(listIterator.next());
        }
    }

    public final void mo5419b() throws IOException {
        ListIterator listIterator = (ListIterator) m31642a(ListIterator.class, Token.END_ARRAY);
        if (listIterator.hasNext()) {
            throw m25657a(listIterator, Token.END_ARRAY);
        }
        m31645r();
    }

    public final void mo5420c() throws IOException {
        Iterator it = ((Map) m31642a(Map.class, Token.BEGIN_OBJECT)).entrySet().iterator();
        this.f30647h[this.a - 1] = it;
        this.b[this.a - 1] = 3;
        if (it.hasNext()) {
            m31644a(it.next());
        }
    }

    public final void mo5421d() throws IOException {
        Iterator it = (Iterator) m31642a(Iterator.class, Token.END_OBJECT);
        if (!(it instanceof ListIterator)) {
            if (!it.hasNext()) {
                this.c[this.a - 1] = null;
                m31645r();
                return;
            }
        }
        throw m25657a(it, Token.END_OBJECT);
    }

    public final boolean mo5422e() throws IOException {
        if (this.a == 0) {
            return true;
        }
        Object obj = this.f30647h[this.a - 1];
        if (obj instanceof Iterator) {
            if (!((Iterator) obj).hasNext()) {
                return false;
            }
        }
        return true;
    }

    public final Token mo5423f() throws IOException {
        if (this.a == 0) {
            return Token.END_DOCUMENT;
        }
        Object obj = this.f30647h[this.a - 1];
        if (obj instanceof ListIterator) {
            return Token.END_ARRAY;
        }
        if (obj instanceof Iterator) {
            return Token.END_OBJECT;
        }
        if (obj instanceof List) {
            return Token.BEGIN_ARRAY;
        }
        if (obj instanceof Map) {
            return Token.BEGIN_OBJECT;
        }
        if (obj instanceof Entry) {
            return Token.NAME;
        }
        if (obj instanceof String) {
            return Token.STRING;
        }
        if (obj instanceof Boolean) {
            return Token.BOOLEAN;
        }
        if (obj instanceof Number) {
            return Token.NUMBER;
        }
        if (obj == null) {
            return Token.NULL;
        }
        if (obj == f30646g) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw m25657a(obj, "a JSON value");
    }

    public final String mo5424g() throws IOException {
        Entry entry = (Entry) m31642a(Entry.class, Token.NAME);
        String a = m31643a(entry);
        this.f30647h[this.a - 1] = entry.getValue();
        this.c[this.a - 2] = a;
        return a;
    }

    public final int mo5416a(Options options) throws IOException {
        Entry entry = (Entry) m31642a(Entry.class, Token.NAME);
        String a = m31643a(entry);
        int length = options.f23632a.length;
        for (int i = 0; i < length; i++) {
            if (options.f23632a[i].equals(a)) {
                this.f30647h[this.a - 1] = entry.getValue();
                this.c[this.a - 2] = a;
                return i;
            }
        }
        return -1;
    }

    public final String mo5425h() throws IOException {
        String str = (String) m31642a(String.class, Token.STRING);
        m31645r();
        return str;
    }

    public final int mo5418b(Options options) throws IOException {
        String str = (String) m31642a(String.class, Token.STRING);
        int length = options.f23632a.length;
        for (int i = 0; i < length; i++) {
            if (options.f23632a[i].equals(str)) {
                m31645r();
                return i;
            }
        }
        return -1;
    }

    public final boolean mo5426i() throws IOException {
        Boolean bool = (Boolean) m31642a(Boolean.class, Token.BOOLEAN);
        m31645r();
        return bool.booleanValue();
    }

    public final <T> T mo5427j() throws IOException {
        m31642a(Void.class, Token.NULL);
        m31645r();
        return null;
    }

    public final double mo5428k() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = java.lang.Object.class;
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r5.m31642a(r0, r1);
        r1 = r0 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0013;
    L_0x000c:
        r0 = (java.lang.Number) r0;
        r0 = r0.doubleValue();
        goto L_0x001f;
    L_0x0013:
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x005a;
    L_0x0017:
        r1 = r0;	 Catch:{ NumberFormatException -> 0x0053 }
        r1 = (java.lang.String) r1;	 Catch:{ NumberFormatException -> 0x0053 }
        r1 = java.lang.Double.parseDouble(r1);	 Catch:{ NumberFormatException -> 0x0053 }
        r0 = r1;
    L_0x001f:
        r2 = r5.e;
        if (r2 != 0) goto L_0x004f;
    L_0x0023:
        r2 = java.lang.Double.isNaN(r0);
        if (r2 != 0) goto L_0x002f;
    L_0x0029:
        r2 = java.lang.Double.isInfinite(r0);
        if (r2 == 0) goto L_0x004f;
    L_0x002f:
        r2 = new com.squareup.moshi.JsonEncodingException;
        r3 = new java.lang.StringBuilder;
        r4 = "JSON forbids NaN and infinities: ";
        r3.<init>(r4);
        r3.append(r0);
        r0 = " at path ";
        r3.append(r0);
        r0 = r5.m25676p();
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        throw r2;
    L_0x004f:
        r5.m31645r();
        return r0;
    L_0x0053:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r5.m25657a(r0, r1);
        throw r0;
    L_0x005a:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r5.m25657a(r0, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.k():double");
    }

    public final long mo5429l() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = java.lang.Object.class;
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m31642a(r0, r1);
        r1 = r0 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0014;
    L_0x000c:
        r0 = (java.lang.Number) r0;
        r0 = r0.longValue();
        r1 = r0;
        goto L_0x002c;
    L_0x0014:
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0037;
    L_0x0018:
        r1 = r0;	 Catch:{ NumberFormatException -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ NumberFormatException -> 0x0020 }
        r1 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0020 }
        goto L_0x002c;
    L_0x0020:
        r1 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0030 }
        r2 = r0;	 Catch:{ NumberFormatException -> 0x0030 }
        r2 = (java.lang.String) r2;	 Catch:{ NumberFormatException -> 0x0030 }
        r1.<init>(r2);	 Catch:{ NumberFormatException -> 0x0030 }
        r1 = r1.longValueExact();	 Catch:{ NumberFormatException -> 0x0030 }
    L_0x002c:
        r3.m31645r();
        return r1;
    L_0x0030:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m25657a(r0, r1);
        throw r0;
    L_0x0037:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m25657a(r0, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.l():long");
    }

    public final int mo5430m() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = java.lang.Object.class;
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m31642a(r0, r1);
        r1 = r0 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0014;
    L_0x000c:
        r0 = (java.lang.Number) r0;
        r0 = r0.intValue();
        r1 = r0;
        goto L_0x002c;
    L_0x0014:
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0037;
    L_0x0018:
        r1 = r0;	 Catch:{ NumberFormatException -> 0x0020 }
        r1 = (java.lang.String) r1;	 Catch:{ NumberFormatException -> 0x0020 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0020 }
        goto L_0x002c;
    L_0x0020:
        r1 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0030 }
        r2 = r0;	 Catch:{ NumberFormatException -> 0x0030 }
        r2 = (java.lang.String) r2;	 Catch:{ NumberFormatException -> 0x0030 }
        r1.<init>(r2);	 Catch:{ NumberFormatException -> 0x0030 }
        r1 = r1.intValueExact();	 Catch:{ NumberFormatException -> 0x0030 }
    L_0x002c:
        r3.m31645r();
        return r1;
    L_0x0030:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m25657a(r0, r1);
        throw r0;
    L_0x0037:
        r1 = com.squareup.moshi.JsonReader.Token.NUMBER;
        r0 = r3.m25657a(r0, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonValueReader.m():int");
    }

    public final void mo5431n() throws IOException {
        if (this.f) {
            StringBuilder stringBuilder = new StringBuilder("Cannot skip unexpected ");
            stringBuilder.append(mo5423f());
            stringBuilder.append(" at ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        if (this.a > 1) {
            this.c[this.a - 2] = "null";
        }
        if ((this.a != 0 ? this.f30647h[this.a - 1] : null) instanceof Entry) {
            this.f30647h[this.a - 1] = ((Entry) this.f30647h[this.a - 1]).getValue();
            return;
        }
        if (this.a > 0) {
            m31645r();
        }
    }

    final void mo5432q() throws IOException {
        if (mo5422e()) {
            m31644a(mo5424g());
        }
    }

    public final void close() throws IOException {
        Arrays.fill(this.f30647h, 0, this.a, null);
        this.f30647h[0] = f30646g;
        this.b[0] = 8;
        this.a = 1;
    }

    private void m31644a(Object obj) {
        if (this.a == this.f30647h.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(m25676p());
            throw new JsonDataException(stringBuilder.toString());
        }
        Object[] objArr = this.f30647h;
        int i = this.a;
        this.a = i + 1;
        objArr[i] = obj;
    }

    private <T> T m31642a(Class<T> cls, Token token) throws IOException {
        Class<T> cls2 = this.a != 0 ? this.f30647h[this.a - 1] : null;
        if (cls.isInstance(cls2)) {
            return cls.cast(cls2);
        }
        if (cls2 == null && token == Token.NULL) {
            return null;
        }
        if (cls2 == f30646g) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw m25657a(cls2, token);
    }

    private String m31643a(Entry<?, ?> entry) {
        entry = entry.getKey();
        if (entry instanceof String) {
            return (String) entry;
        }
        throw m25657a(entry, Token.NAME);
    }

    private void m31645r() {
        this.a--;
        this.f30647h[this.a] = null;
        this.b[this.a] = 0;
        if (this.a > 0) {
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            Object obj = this.f30647h[this.a - 1];
            if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                if (it.hasNext()) {
                    m31644a(it.next());
                }
            }
        }
    }
}
