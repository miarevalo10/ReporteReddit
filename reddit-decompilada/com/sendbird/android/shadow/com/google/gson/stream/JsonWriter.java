package com.sendbird.android.shadow.com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] f23026a = new String[128];
    private static final String[] f23027b;
    public String f23028c;
    public String f23029d;
    public boolean f23030e;
    public boolean f23031f;
    public boolean f23032g;
    private final Writer f23033h;
    private int[] f23034i = new int[32];
    private int f23035j = 0;
    private String f23036k;

    static {
        for (int i = 0; i <= 31; i++) {
            f23026a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f23026a[34] = "\\\"";
        f23026a[92] = "\\\\";
        f23026a[9] = "\\t";
        f23026a[8] = "\\b";
        f23026a[10] = "\\n";
        f23026a[13] = "\\r";
        f23026a[12] = "\\f";
        String[] strArr = (String[]) f23026a.clone();
        f23027b = strArr;
        strArr[60] = "\\u003c";
        f23027b[62] = "\\u003e";
        f23027b[38] = "\\u0026";
        f23027b[61] = "\\u003d";
        f23027b[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m25175a(6);
        this.f23029d = ":";
        this.f23032g = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f23033h = writer;
    }

    public JsonWriter mo5270a() throws IOException {
        m25179g();
        return m25174a(1, "[");
    }

    public JsonWriter mo5276b() throws IOException {
        return m25173a(1, 2, "]");
    }

    public JsonWriter mo5278c() throws IOException {
        m25179g();
        return m25174a(3, "{");
    }

    public JsonWriter mo5280d() throws IOException {
        return m25173a(3, 5, "}");
    }

    private JsonWriter m25174a(int i, String str) throws IOException {
        m25181i();
        m25175a(i);
        this.f23033h.write(str);
        return this;
    }

    private JsonWriter m25173a(int i, int i2, String str) throws IOException {
        int f = m25178f();
        if (f != i2 && f != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f23036k != 0) {
            i2 = new StringBuilder("Dangling name: ");
            i2.append(this.f23036k);
            throw new IllegalStateException(i2.toString());
        } else {
            this.f23035j--;
            if (f == i2) {
                m25180h();
            }
            this.f23033h.write(str);
            return this;
        }
    }

    private void m25175a(int i) {
        if (this.f23035j == this.f23034i.length) {
            Object obj = new int[(this.f23035j * 2)];
            System.arraycopy(this.f23034i, 0, obj, 0, this.f23035j);
            this.f23034i = obj;
        }
        int[] iArr = this.f23034i;
        int i2 = this.f23035j;
        this.f23035j = i2 + 1;
        iArr[i2] = i;
    }

    private int m25178f() {
        if (this.f23035j != 0) {
            return this.f23034i[this.f23035j - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m25176b(int i) {
        this.f23034i[this.f23035j - 1] = i;
    }

    public JsonWriter mo5274a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f23036k != null) {
            throw new IllegalStateException();
        } else if (this.f23035j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f23036k = str;
            return this;
        }
    }

    private void m25179g() throws IOException {
        if (this.f23036k != null) {
            int f = m25178f();
            if (f == 5) {
                this.f23033h.write(44);
            } else if (f != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m25180h();
            m25176b(4);
            m25177c(this.f23036k);
            this.f23036k = null;
        }
    }

    public JsonWriter mo5277b(String str) throws IOException {
        if (str == null) {
            return mo5281e();
        }
        m25179g();
        m25181i();
        m25177c(str);
        return this;
    }

    public JsonWriter mo5281e() throws IOException {
        if (this.f23036k != null) {
            if (this.f23032g) {
                m25179g();
            } else {
                this.f23036k = null;
                return this;
            }
        }
        m25181i();
        this.f23033h.write("null");
        return this;
    }

    public JsonWriter mo5275a(boolean z) throws IOException {
        m25179g();
        m25181i();
        this.f23033h.write(z ? "true" : "false");
        return this;
    }

    public JsonWriter mo5272a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo5281e();
        }
        m25179g();
        m25181i();
        this.f23033h.write(bool.booleanValue() != null ? "true" : "false");
        return this;
    }

    public JsonWriter mo5271a(long j) throws IOException {
        m25179g();
        m25181i();
        this.f23033h.write(Long.toString(j));
        return this;
    }

    public JsonWriter mo5273a(Number number) throws IOException {
        if (number == null) {
            return mo5281e();
        }
        m25179g();
        CharSequence obj = number.toString();
        if (this.f23030e || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m25181i();
            this.f23033h.append(obj);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder("Numeric values must be finite, but was ");
        stringBuilder.append(number);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void flush() throws IOException {
        if (this.f23035j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f23033h.flush();
    }

    public void close() throws IOException {
        this.f23033h.close();
        int i = this.f23035j;
        if (i <= 1) {
            if (i != 1 || this.f23034i[i - 1] == 7) {
                this.f23035j = 0;
                return;
            }
        }
        throw new IOException("Incomplete document");
    }

    private void m25177c(String str) throws IOException {
        String[] strArr = this.f23031f ? f23027b : f23026a;
        this.f23033h.write("\"");
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
                this.f23033h.write(str, i2, i - i2);
            }
            this.f23033h.write(str2);
            i2 = i + 1;
            i++;
        }
        if (i2 < length) {
            this.f23033h.write(str, i2, length - i2);
        }
        this.f23033h.write("\"");
    }

    private void m25180h() throws IOException {
        if (this.f23028c != null) {
            this.f23033h.write("\n");
            int i = this.f23035j;
            for (int i2 = 1; i2 < i; i2++) {
                this.f23033h.write(this.f23028c);
            }
        }
    }

    private void m25181i() throws IOException {
        switch (m25178f()) {
            case 1:
                m25176b(2);
                m25180h();
                return;
            case 2:
                this.f23033h.append(',');
                m25180h();
                return;
            case 4:
                this.f23033h.append(this.f23029d);
                m25176b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f23030e) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        m25176b(7);
    }
}
