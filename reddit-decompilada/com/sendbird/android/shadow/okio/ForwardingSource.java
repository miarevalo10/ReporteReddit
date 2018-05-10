package com.sendbird.android.shadow.okio;

import java.io.IOException;

public abstract class ForwardingSource implements Source {
    protected final Source f30570d;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f30570d = source;
    }

    public long mo5322a(Buffer buffer, long j) throws IOException {
        return this.f30570d.mo5322a(buffer, j);
    }

    public final Timeout mo5323a() {
        return this.f30570d.mo5323a();
    }

    public void close() throws IOException {
        this.f30570d.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("(");
        stringBuilder.append(this.f30570d.toString());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
