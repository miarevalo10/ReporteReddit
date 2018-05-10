package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import okio.BufferedSink;

public abstract class JsonWriter implements Closeable, Flushable {
    int f23651b = 0;
    final int[] f23652c = new int[32];
    final String[] f23653d = new String[32];
    final int[] f23654e = new int[32];
    String f23655f;
    boolean f23656g;
    boolean f23657h;
    boolean f23658i;

    public abstract JsonWriter mo5433a() throws IOException;

    public abstract JsonWriter mo5434a(double d) throws IOException;

    public abstract JsonWriter mo5435a(long j) throws IOException;

    public abstract JsonWriter mo5436a(Number number) throws IOException;

    public abstract JsonWriter mo5437a(boolean z) throws IOException;

    public abstract JsonWriter mo5439b() throws IOException;

    public abstract JsonWriter mo5440b(String str) throws IOException;

    public abstract JsonWriter mo5441c() throws IOException;

    public abstract JsonWriter mo5442c(String str) throws IOException;

    public abstract JsonWriter mo5443d() throws IOException;

    public abstract JsonWriter mo5444e() throws IOException;

    public static JsonWriter m25679a(BufferedSink bufferedSink) {
        return new JsonUtf8Writer(bufferedSink);
    }

    JsonWriter() {
    }

    final int m25694f() {
        if (this.f23651b != 0) {
            return this.f23652c[this.f23651b - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    final void m25685a(int i) {
        if (this.f23651b == this.f23652c.length) {
            StringBuilder stringBuilder = new StringBuilder("Nesting too deep at ");
            stringBuilder.append(m25695g());
            stringBuilder.append(": circular reference?");
            throw new JsonDataException(stringBuilder.toString());
        }
        int[] iArr = this.f23652c;
        int i2 = this.f23651b;
        this.f23651b = i2 + 1;
        iArr[i2] = i;
    }

    final void m25689b(int i) {
        this.f23652c[this.f23651b - 1] = i;
    }

    public void mo5438a(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.f23655f = str;
    }

    public final String m25695g() {
        return JsonScope.m25678a(this.f23651b, this.f23652c, this.f23653d, this.f23654e);
    }
}
