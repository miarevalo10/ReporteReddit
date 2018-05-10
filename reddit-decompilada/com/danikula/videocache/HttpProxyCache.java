package com.danikula.videocache;

import com.danikula.videocache.file.FileCache;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

class HttpProxyCache extends ProxyCache {
    final HttpUrlSource f12679a;
    final FileCache f12680b;
    CacheListener f12681c;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.f12680b = fileCache;
        this.f12679a = httpUrlSource;
    }

    final void m11758a(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int a = m3341a(bArr, j);
            if (a != -1) {
                outputStream.write(bArr, 0, a);
                j += (long) a;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    final void m11759b(OutputStream outputStream, long j) throws ProxyCacheException, IOException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.f12679a);
        try {
            httpUrlSource.mo1101a((long) ((int) j));
            byte[] bArr = new byte[8192];
            while (true) {
                int a = httpUrlSource.mo1099a(bArr);
                if (a == -1) {
                    break;
                }
                outputStream.write(bArr, 0, a);
            }
            outputStream.flush();
        } finally {
            httpUrlSource.mo1102b();
        }
    }

    static String m11756a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    protected final void mo1097a(int i) {
        if (this.f12681c != null) {
            CacheListener cacheListener = this.f12681c;
            File file = this.f12680b.file;
            SourceInfo sourceInfo = this.f12679a.f12685a;
            cacheListener.mo1098a(file, i);
        }
    }
}
