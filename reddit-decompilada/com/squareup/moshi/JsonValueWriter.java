package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class JsonValueWriter extends JsonWriter {
    final Object[] f30648a = new Object[32];
    private String f30649j;

    JsonValueWriter() {
        m25685a(6);
    }

    public final JsonWriter mo5433a() throws IOException {
        if (this.b == this.f30648a.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(m25695g());
            stringBuilder.append(": circular reference?");
            throw new JsonDataException(stringBuilder.toString());
        }
        Object arrayList = new ArrayList();
        m31663a(arrayList);
        this.f30648a[this.b] = arrayList;
        this.e[this.b] = 0;
        m25685a(1);
        return this;
    }

    public final JsonWriter mo5439b() throws IOException {
        if (m25694f() != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.b--;
        this.f30648a[this.b] = null;
        int[] iArr = this.e;
        int i = this.b - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public final JsonWriter mo5441c() throws IOException {
        if (this.b == this.f30648a.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(m25695g());
            stringBuilder.append(": circular reference?");
            throw new JsonDataException(stringBuilder.toString());
        }
        Object linkedHashTreeMap = new LinkedHashTreeMap();
        m31663a(linkedHashTreeMap);
        this.f30648a[this.b] = linkedHashTreeMap;
        m25685a(3);
        return this;
    }

    public final JsonWriter mo5443d() throws IOException {
        if (m25694f() == 3) {
            if (this.f30649j == null) {
                this.i = false;
                this.b--;
                this.f30648a[this.b] = null;
                this.d[this.b] = null;
                int[] iArr = this.e;
                int i = this.b - 1;
                iArr[i] = iArr[i] + 1;
                return this;
            }
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public final JsonWriter mo5440b(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            if (m25694f() == 3) {
                if (this.f30649j == null) {
                    this.f30649j = str;
                    this.d[this.b - 1] = str;
                    this.i = null;
                    return this;
                }
            }
            throw new IllegalStateException("Nesting problem.");
        }
    }

    public final JsonWriter mo5442c(String str) throws IOException {
        if (this.i) {
            return mo5440b(str);
        }
        m31663a((Object) str);
        str = this.e;
        int i = this.b - 1;
        str[i] = str[i] + 1;
        return this;
    }

    public final JsonWriter mo5444e() throws IOException {
        m31663a(null);
        int[] iArr = this.e;
        int i = this.b - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public final JsonWriter mo5437a(boolean z) throws IOException {
        m31663a(Boolean.valueOf(z));
        z = this.e;
        int i = this.b - 1;
        z[i] = z[i] + 1;
        return this;
    }

    public final JsonWriter mo5434a(double d) throws IOException {
        if (!this.g && (Double.isNaN(d) || d == Double.NEGATIVE_INFINITY || d == Double.POSITIVE_INFINITY)) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append(d);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.i) {
            return mo5440b(Double.toString(d));
        } else {
            m31663a(Double.valueOf(d));
            d = this.e;
            int i = this.b - 1;
            d[i] = d[i] + 1;
            return this;
        }
    }

    public final JsonWriter mo5435a(long j) throws IOException {
        if (this.i) {
            return mo5440b(Long.toString(j));
        }
        m31663a(Long.valueOf(j));
        j = this.e;
        int i = this.b - 1;
        j[i] = j[i] + 1;
        return this;
    }

    public final JsonWriter mo5436a(Number number) throws IOException {
        if (!((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer))) {
            if (!(number instanceof Long)) {
                if (!(number instanceof Float)) {
                    if (!(number instanceof Double)) {
                        if (number == null) {
                            return mo5444e();
                        }
                        Object obj;
                        if (number instanceof BigDecimal) {
                            obj = (BigDecimal) number;
                        } else {
                            obj = new BigDecimal(number.toString());
                        }
                        if (this.i) {
                            return mo5440b(obj.toString());
                        }
                        m31663a(obj);
                        number = this.e;
                        int i = this.b - 1;
                        number[i] = number[i] + 1;
                        return this;
                    }
                }
                return mo5434a(number.doubleValue());
            }
        }
        return mo5435a(number.longValue());
    }

    public final void close() throws IOException {
        int i = this.b;
        if (i <= 1) {
            if (i != 1 || this.c[i - 1] == 7) {
                this.b = 0;
                return;
            }
        }
        throw new IOException("Incomplete document");
    }

    public final void flush() throws IOException {
        if (this.b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private JsonValueWriter m31663a(Object obj) {
        int f = m25694f();
        if (this.b == 1) {
            if (f != 6) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            this.c[this.b - 1] = 7;
            this.f30648a[this.b - 1] = obj;
        } else if (f == 3 && this.f30649j != null) {
            if (obj != null || this.h) {
                Object put = ((Map) this.f30648a[this.b - 1]).put(this.f30649j, obj);
                if (put != null) {
                    StringBuilder stringBuilder = new StringBuilder("Map key '");
                    stringBuilder.append(this.f30649j);
                    stringBuilder.append("' has multiple values at path ");
                    stringBuilder.append(m25695g());
                    stringBuilder.append(": ");
                    stringBuilder.append(put);
                    stringBuilder.append(" and ");
                    stringBuilder.append(obj);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.f30649j = null;
        } else if (f == 1) {
            ((List) this.f30648a[this.b - 1]).add(obj);
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
        return this;
    }
}
