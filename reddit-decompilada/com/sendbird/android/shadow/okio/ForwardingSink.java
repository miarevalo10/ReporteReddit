package com.sendbird.android.shadow.okio;

import java.io.IOException;

public abstract class ForwardingSink implements Sink {
    private final Sink f30569a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f30569a = sink;
    }

    public void a_(Buffer buffer, long j) throws IOException {
        this.f30569a.a_(buffer, j);
    }

    public void flush() throws IOException {
        this.f30569a.flush();
    }

    public final Timeout mo5334a() {
        return this.f30569a.mo5334a();
    }

    public void close() throws IOException {
        this.f30569a.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.f30569a.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
