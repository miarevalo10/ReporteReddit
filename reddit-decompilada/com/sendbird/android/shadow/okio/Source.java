package com.sendbird.android.shadow.okio;

import java.io.Closeable;
import java.io.IOException;

public interface Source extends Closeable {
    long mo5322a(Buffer buffer, long j) throws IOException;

    Timeout mo5323a();

    void close() throws IOException;
}
