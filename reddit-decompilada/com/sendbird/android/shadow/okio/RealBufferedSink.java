package com.sendbird.android.shadow.okio;

import java.io.IOException;

final class RealBufferedSink implements BufferedSink {
    public final Buffer f34627a = new Buffer();
    public final Sink f34628b;
    boolean f34629c;

    RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.f34628b = sink;
    }

    public final Buffer mo6552b() {
        return this.f34627a;
    }

    public final void a_(Buffer buffer, long j) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.a_(buffer, j);
        mo6581t();
    }

    public final BufferedSink mo6557c(ByteString byteString) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35454a(byteString);
        return mo6581t();
    }

    public final BufferedSink mo6553b(String str) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35455a(str);
        return mo6581t();
    }

    public final BufferedSink mo6558c(byte[] bArr) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35464b(bArr);
        return mo6581t();
    }

    public final BufferedSink mo6559c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35465b(bArr, i, i2);
        return mo6581t();
    }

    public final long mo6548a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = source.mo5322a(this.f34627a, 8192);
            if (a == -1) {
                return j;
            }
            j += a;
            mo6581t();
        }
    }

    public final BufferedSink mo6570h(int i) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35463b(i);
        return mo6581t();
    }

    public final BufferedSink mo6566g(int i) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35469c(i);
        return mo6581t();
    }

    public final BufferedSink mo6564f(int i) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35475d(i);
        return mo6581t();
    }

    public final BufferedSink mo6578m(long j) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35488h(j);
        return mo6581t();
    }

    public final BufferedSink mo6576l(long j) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35491i(j);
        return mo6581t();
    }

    public final BufferedSink mo6574k(long j) throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        this.f34627a.m35492j(j);
        return mo6581t();
    }

    public final BufferedSink mo6581t() throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        long e = this.f34627a.m35478e();
        if (e > 0) {
            this.f34628b.a_(this.f34627a, e);
        }
        return this;
    }

    public final BufferedSink mo6556c() throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        long j = this.f34627a.f34625b;
        if (j > 0) {
            this.f34628b.a_(this.f34627a, j);
        }
        return this;
    }

    public final void flush() throws IOException {
        if (this.f34629c) {
            throw new IllegalStateException("closed");
        }
        if (this.f34627a.f34625b > 0) {
            this.f34628b.a_(this.f34627a, this.f34627a.f34625b);
        }
        this.f34628b.flush();
    }

    public final void close() throws IOException {
        if (!this.f34629c) {
            Throwable th = null;
            try {
                if (this.f34627a.f34625b > 0) {
                    this.f34628b.a_(this.f34627a, this.f34627a.f34625b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f34628b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f34629c = true;
            if (th != null) {
                Util.m25644a(th);
            }
        }
    }

    public final Timeout mo5334a() {
        return this.f34628b.mo5334a();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append(this.f34628b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
