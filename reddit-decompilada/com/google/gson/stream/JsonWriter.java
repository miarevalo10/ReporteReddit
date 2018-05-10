package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] f8864f = new String[128];
    private static final String[] f8865g;
    public String f8866a;
    public String f8867b;
    public boolean f8868c;
    public boolean f8869d;
    public boolean f8870e;
    private final Writer f8871h;
    private int[] f8872i = new int[32];
    private int f8873j = 0;
    private String f8874k;

    static {
        for (int i = 0; i <= 31; i++) {
            f8864f[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f8864f[34] = "\\\"";
        f8864f[92] = "\\\\";
        f8864f[9] = "\\t";
        f8864f[8] = "\\b";
        f8864f[10] = "\\n";
        f8864f[13] = "\\r";
        f8864f[12] = "\\f";
        String[] strArr = (String[]) f8864f.clone();
        f8865g = strArr;
        strArr[60] = "\\u003c";
        f8865g[62] = "\\u003e";
        f8865g[38] = "\\u0026";
        f8865g[61] = "\\u003d";
        f8865g[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m7606a(6);
        this.f8867b = ":";
        this.f8870e = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f8871h = writer;
    }

    public JsonWriter mo2493b() throws IOException {
        m7609g();
        return m7605a(1, "[");
    }

    public JsonWriter mo2495c() throws IOException {
        return m7604a(1, 2, "]");
    }

    public JsonWriter mo2497d() throws IOException {
        m7609g();
        return m7605a(3, "{");
    }

    public JsonWriter mo2498e() throws IOException {
        return m7604a(3, 5, "}");
    }

    private JsonWriter m7605a(int i, String str) throws IOException {
        m7611i();
        m7606a(i);
        this.f8871h.write(str);
        return this;
    }

    private JsonWriter m7604a(int i, int i2, String str) throws IOException {
        int a = mo2487a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f8874k != 0) {
            i2 = new StringBuilder("Dangling name: ");
            i2.append(this.f8874k);
            throw new IllegalStateException(i2.toString());
        } else {
            this.f8873j--;
            if (a == i2) {
                m7610h();
            }
            this.f8871h.write(str);
            return this;
        }
    }

    private void m7606a(int i) {
        if (this.f8873j == this.f8872i.length) {
            Object obj = new int[(this.f8873j * 2)];
            System.arraycopy(this.f8872i, 0, obj, 0, this.f8873j);
            this.f8872i = obj;
        }
        int[] iArr = this.f8872i;
        int i2 = this.f8873j;
        this.f8873j = i2 + 1;
        iArr[i2] = i;
    }

    private int mo2487a() {
        if (this.f8873j != 0) {
            return this.f8872i[this.f8873j - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m7607b(int i) {
        this.f8872i[this.f8873j - 1] = i;
    }

    public JsonWriter mo2491a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f8874k != null) {
            throw new IllegalStateException();
        } else if (this.f8873j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f8874k = str;
            return this;
        }
    }

    private void m7609g() throws IOException {
        if (this.f8874k != null) {
            int a = mo2487a();
            if (a == 5) {
                this.f8871h.write(44);
            } else if (a != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m7610h();
            m7607b(4);
            m7608c(this.f8874k);
            this.f8874k = null;
        }
    }

    public JsonWriter mo2494b(String str) throws IOException {
        if (str == null) {
            return mo2499f();
        }
        m7609g();
        m7611i();
        m7608c(str);
        return this;
    }

    public JsonWriter mo2499f() throws IOException {
        if (this.f8874k != null) {
            if (this.f8870e) {
                m7609g();
            } else {
                this.f8874k = null;
                return this;
            }
        }
        m7611i();
        this.f8871h.write("null");
        return this;
    }

    public JsonWriter mo2492a(boolean z) throws IOException {
        m7609g();
        m7611i();
        this.f8871h.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter mo2489a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo2499f();
        }
        m7609g();
        m7611i();
        this.f8871h.write(bool.booleanValue() != null ? "true" : "false");
        return this;
    }

    public JsonWriter mo2488a(long j) throws IOException {
        m7609g();
        m7611i();
        this.f8871h.write(Long.toString(j));
        return this;
    }

    public JsonWriter mo2490a(Number number) throws IOException {
        if (number == null) {
            return mo2499f();
        }
        m7609g();
        CharSequence obj = number.toString();
        if (this.f8868c || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m7611i();
            this.f8871h.append(obj);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
        stringBuilder.append(number);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void flush() throws IOException {
        if (this.f8873j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f8871h.flush();
    }

    public void close() throws IOException {
        this.f8871h.close();
        int i = this.f8873j;
        if (i <= 1) {
            if (i != 1 || this.f8872i[i - 1] == 7) {
                this.f8873j = 0;
                return;
            }
        }
        throw new IOException("Incomplete document");
    }

    private void m7608c(String str) throws IOException {
        String[] strArr = this.f8869d ? f8865g : f8864f;
        this.f8871h.write("\"");
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
                this.f8871h.write(str, i2, i - i2);
            }
            this.f8871h.write(str2);
            i2 = i + 1;
            i++;
        }
        if (i2 < length) {
            this.f8871h.write(str, i2, length - i2);
        }
        this.f8871h.write("\"");
    }

    private void m7610h() throws IOException {
        if (this.f8866a != null) {
            this.f8871h.write("\n");
            int i = this.f8873j;
            for (int i2 = 1; i2 < i; i2++) {
                this.f8871h.write(this.f8866a);
            }
        }
    }

    private void m7611i() throws IOException {
        switch (mo2487a()) {
            case 1:
                m7607b(2);
                m7610h();
                return;
            case 2:
                this.f8871h.append(',');
                m7610h();
                return;
            case 4:
                this.f8871h.append(this.f8867b);
                m7607b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f8868c) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        m7607b(7);
    }
}
