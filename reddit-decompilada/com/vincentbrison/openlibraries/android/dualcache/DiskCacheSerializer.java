package com.vincentbrison.openlibraries.android.dualcache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface DiskCacheSerializer<T> {
    T m26003a(InputStream inputStream) throws IOException;

    void m26004a(OutputStream outputStream, T t) throws IOException;
}
