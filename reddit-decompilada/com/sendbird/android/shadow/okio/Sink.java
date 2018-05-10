package com.sendbird.android.shadow.okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface Sink extends Closeable, Flushable {
    Timeout mo5334a();

    void a_(Buffer buffer, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
