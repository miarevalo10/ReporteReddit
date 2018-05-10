package com.squareup.moshi;

import java.io.IOException;
import okio.BufferedSink;

final class JsonUtf8Writer extends JsonWriter {
    private static final String[] f30642a = new String[128];
    private final BufferedSink f30643j;
    private String f30644k = ":";
    private String f30645l;

    static {
        for (int i = 0; i <= 31; i++) {
            f30642a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f30642a[34] = "\\\"";
        f30642a[92] = "\\\\";
        f30642a[9] = "\\t";
        f30642a[8] = "\\b";
        f30642a[10] = "\\n";
        f30642a[13] = "\\r";
        f30642a[12] = "\\f";
    }

    JsonUtf8Writer(BufferedSink bufferedSink) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        this.f30643j = bufferedSink;
        m25685a(6);
    }

    public final void mo5438a(String str) {
        super.mo5438a(str);
        this.f30644k = str.isEmpty() == null ? ": " : ":";
    }

    public final JsonWriter mo5433a() throws IOException {
        m31627h();
        return m31625a(1, "[");
    }

    public final JsonWriter mo5439b() throws IOException {
        return m31624a(1, 2, "]");
    }

    public final JsonWriter mo5441c() throws IOException {
        m31627h();
        return m31625a(3, "{");
    }

    public final JsonWriter mo5443d() throws IOException {
        this.i = false;
        return m31624a(3, 5, "}");
    }

    private JsonWriter m31625a(int i, String str) throws IOException {
        m31629j();
        m25685a(i);
        this.e[this.b - 1] = null;
        this.f30643j.mo6760b(str);
        return this;
    }

    private JsonWriter m31624a(int i, int i2, String str) throws IOException {
        int f = m25694f();
        if (f != i2 && f != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f30645l != 0) {
            i2 = new StringBuilder("Dangling name: ");
            i2.append(this.f30645l);
            throw new IllegalStateException(i2.toString());
        } else {
            this.b--;
            this.d[this.b] = null;
            i = this.e;
            int i3 = this.b - 1;
            i[i3] = i[i3] + 1;
            if (f == i2) {
                m31628i();
            }
            this.f30643j.mo6760b(str);
            return this;
        }
    }

    public final JsonWriter mo5440b(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else if (this.f30645l != null) {
            throw new IllegalStateException("Nesting problem.");
        } else {
            this.f30645l = str;
            this.d[this.b - 1] = str;
            this.i = null;
            return this;
        }
    }

    private void m31627h() throws IOException {
        if (this.f30645l != null) {
            int f = m25694f();
            if (f == 5) {
                this.f30643j.mo6775h(44);
            } else if (f != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m31628i();
            m25689b(4);
            m31626a(this.f30643j, this.f30645l);
            this.f30645l = null;
        }
    }

    public final JsonWriter mo5442c(String str) throws IOException {
        if (str == null) {
            return mo5444e();
        }
        if (this.i) {
            return mo5440b(str);
        }
        m31627h();
        m31629j();
        m31626a(this.f30643j, str);
        str = this.e;
        int i = this.b - 1;
        str[i] = str[i] + 1;
        return this;
    }

    public final JsonWriter mo5444e() throws IOException {
        if (this.f30645l != null) {
            if (this.h) {
                m31627h();
            } else {
                this.f30645l = null;
                return this;
            }
        }
        m31629j();
        this.f30643j.mo6760b("null");
        int[] iArr = this.e;
        int i = this.b - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public final JsonWriter mo5437a(boolean z) throws IOException {
        m31627h();
        m31629j();
        this.f30643j.mo6760b(z ? "true" : "false");
        z = this.e;
        int i = this.b - 1;
        z[i] = z[i] + 1;
        return this;
    }

    public final JsonWriter mo5434a(double d) throws IOException {
        if (!this.g && (Double.isNaN(d) || Double.isInfinite(d))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append(d);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.i) {
            return mo5440b(Double.toString(d));
        } else {
            m31627h();
            m31629j();
            this.f30643j.mo6760b(Double.toString(d));
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
        m31627h();
        m31629j();
        this.f30643j.mo6760b(Long.toString(j));
        j = this.e;
        int i = this.b - 1;
        j[i] = j[i] + 1;
        return this;
    }

    public final JsonWriter mo5436a(Number number) throws IOException {
        if (number == null) {
            return mo5444e();
        }
        String obj = number.toString();
        if (!this.g && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
            stringBuilder.append(number);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.i != null) {
            return mo5440b(obj);
        } else {
            m31627h();
            m31629j();
            this.f30643j.mo6760b(obj);
            number = this.e;
            int i = this.b - 1;
            number[i] = number[i] + 1;
            return this;
        }
    }

    public final void flush() throws IOException {
        if (this.b == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f30643j.flush();
    }

    public final void close() throws IOException {
        this.f30643j.close();
        int i = this.b;
        if (i <= 1) {
            if (i != 1 || this.c[i - 1] == 7) {
                this.b = 0;
                return;
            }
        }
        throw new IOException("Incomplete document");
    }

    static void m31626a(BufferedSink bufferedSink, String str) throws IOException {
        String[] strArr = f30642a;
        bufferedSink.mo6775h(34);
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str2;
            char charAt = str.charAt(i);
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                    i++;
                }
            } else if (charAt == ' ') {
                str2 = "\\u2028";
            } else if (charAt == ' ') {
                str2 = "\\u2029";
            } else {
                i++;
            }
            if (i2 < i) {
                bufferedSink.mo6761b(str, i2, i);
            }
            bufferedSink.mo6760b(str2);
            i2 = i + 1;
            i++;
        }
        if (i2 < length) {
            bufferedSink.mo6761b(str, i2, length);
        }
        bufferedSink.mo6775h(34);
    }

    private void m31628i() throws IOException {
        if (this.f != null) {
            this.f30643j.mo6775h(10);
            int i = this.b;
            for (int i2 = 1; i2 < i; i2++) {
                this.f30643j.mo6760b(this.f);
            }
        }
    }

    private void m31629j() throws IOException {
        switch (m25694f()) {
            case 1:
                m25689b(2);
                m31628i();
                return;
            case 2:
                this.f30643j.mo6775h(44);
                m31628i();
                return;
            case 4:
                this.f30643j.mo6760b(this.f30644k);
                m25689b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        m25689b(7);
    }
}
