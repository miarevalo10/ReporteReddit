package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Http2Writer implements Closeable {
    private static final Logger f23517c = Logger.getLogger(Http2.class.getName());
    int f23518a = 16384;
    final Writer f23519b = new Writer(this.f23522f);
    private final BufferedSink f23520d;
    private final boolean f23521e;
    private final Buffer f23522f = new Buffer();
    private boolean f23523g;

    Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f23520d = bufferedSink;
        this.f23521e = z;
    }

    public final synchronized void m25508a() throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        } else if (this.f23521e) {
            if (f23517c.isLoggable(Level.FINE)) {
                f23517c.fine(Util.m25360a(">> CONNECTION %s", Http2.f23465a.mo5403f()));
            }
            this.f23520d.mo6558c(Http2.f23465a.mo5407i());
            this.f23520d.flush();
        }
    }

    public final synchronized void m25512a(Settings settings) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        int i = this.f23518a;
        if ((32 & settings.f23535a) != 0) {
            i = settings.f23536b[5];
        }
        this.f23518a = i;
        if (settings.m25526a() != -1) {
            this.f23519b.m25460a(settings.m25526a());
        }
        m25506a(0, 0, (byte) 4, (byte) 1);
        this.f23520d.flush();
    }

    public final synchronized void m25516b() throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        this.f23520d.flush();
    }

    public final synchronized void m25515a(boolean z, int i, List<Header> list) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        } else if (this.f23523g) {
            throw new IOException("closed");
        } else {
            this.f23519b.m25461a((List) list);
            long j = this.f23522f.f34625b;
            int min = (int) Math.min((long) this.f23518a, j);
            long j2 = (long) min;
            int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            m25506a(i, min, (byte) true, b);
            this.f23520d.a_(this.f23522f, j2);
            if (i2 > 0) {
                m25507b(i, j - j2);
            }
        }
    }

    public final synchronized void m25510a(int i, ErrorCode errorCode) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        } else if (errorCode.f23435g == -1) {
            throw new IllegalArgumentException();
        } else {
            m25506a(i, 4, (byte) 3, (byte) 0);
            this.f23520d.mo6564f(errorCode.f23435g);
            this.f23520d.flush();
        }
    }

    public final synchronized void m25514a(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        m25506a(i, i2, (byte) 0, (byte) z);
        if (i2 > 0) {
            this.f23520d.a_(buffer, (long) i2);
        }
    }

    public final synchronized void m25517b(Settings settings) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        int i = (byte) 0;
        m25506a(0, Integer.bitCount(settings.f23535a) * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (settings.m25528a(i)) {
                int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                this.f23520d.mo6566g(i2);
                this.f23520d.mo6564f(settings.f23536b[i]);
            }
            i++;
        }
        this.f23520d.flush();
    }

    public final synchronized void m25513a(boolean z, int i, int i2) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        m25506a(0, 8, (byte) 6, (byte) z);
        this.f23520d.mo6564f(i);
        this.f23520d.mo6564f(i2);
        this.f23520d.flush();
    }

    public final synchronized void m25511a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        } else if (errorCode.f23435g == -1) {
            throw Http2.m25463a("errorCode.httpCode == -1", new Object[0]);
        } else {
            m25506a(0, 8 + bArr.length, (byte) 7, (byte) 0);
            this.f23520d.mo6564f(i);
            this.f23520d.mo6564f(errorCode.f23435g);
            if (bArr.length > 0) {
                this.f23520d.mo6558c(bArr);
            }
            this.f23520d.flush();
        }
    }

    public final synchronized void m25509a(int i, long j) throws IOException {
        if (this.f23523g) {
            throw new IOException("closed");
        }
        if (j != 0) {
            if (j <= 2147483647L) {
                m25506a(i, 4, (byte) 8, (byte) 0);
                this.f23520d.mo6564f((int) j);
                this.f23520d.flush();
            }
        }
        throw Http2.m25463a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    private void m25506a(int i, int i2, byte b, byte b2) throws IOException {
        if (f23517c.isLoggable(Level.FINE)) {
            f23517c.fine(Http2.m25464a(false, i, i2, b, b2));
        }
        if (i2 > this.f23518a) {
            throw Http2.m25463a("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.f23518a), Integer.valueOf(i2)});
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw Http2.m25463a("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        } else {
            BufferedSink bufferedSink = this.f23520d;
            bufferedSink.mo6570h((i2 >>> 16) & 255);
            bufferedSink.mo6570h((i2 >>> 8) & 255);
            bufferedSink.mo6570h(i2 & 255);
            this.f23520d.mo6570h(b & 255);
            this.f23520d.mo6570h(b2 & 255);
            this.f23520d.mo6564f(i & (byte) -1);
        }
    }

    public final synchronized void close() throws IOException {
        this.f23523g = true;
        this.f23520d.close();
    }

    private void m25507b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f23518a, j);
            long j2 = (long) min;
            j -= j2;
            m25506a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f23520d.a_(this.f23522f, j2);
        }
    }
}
