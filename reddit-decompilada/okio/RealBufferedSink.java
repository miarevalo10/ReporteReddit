package okio;

import java.io.IOException;
import java.io.OutputStream;

final class RealBufferedSink implements BufferedSink {
    public final Buffer f36203a = new Buffer();
    public final Sink f36204b;
    boolean f36205c;

    class C21871 extends OutputStream {
        final /* synthetic */ RealBufferedSink f26676a;

        C21871(RealBufferedSink realBufferedSink) {
            this.f26676a = realBufferedSink;
        }

        public void write(int i) throws IOException {
            if (this.f26676a.f36205c) {
                throw new IOException("closed");
            }
            this.f26676a.f36203a.m36493b((byte) i);
            this.f26676a.mo6791w();
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f26676a.f36205c) {
                throw new IOException("closed");
            }
            this.f26676a.f36203a.m36495b(bArr, i, i2);
            this.f26676a.mo6791w();
        }

        public void flush() throws IOException {
            if (!this.f26676a.f36205c) {
                this.f26676a.flush();
            }
        }

        public void close() throws IOException {
            this.f26676a.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f26676a);
            stringBuilder.append(".outputStream()");
            return stringBuilder.toString();
        }
    }

    RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.f36204b = sink;
    }

    public final Buffer mo6754a() {
        return this.f36203a;
    }

    public final void write(Buffer buffer, long j) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.write(buffer, j);
        mo6791w();
    }

    public final BufferedSink mo6767d(ByteString byteString) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36486a(byteString);
        return mo6791w();
    }

    public final BufferedSink mo6760b(String str) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36482a(str);
        return mo6791w();
    }

    public final BufferedSink mo6761b(String str, int i, int i2) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36483a(str, i, i2);
        return mo6791w();
    }

    public final BufferedSink mo6764c(byte[] bArr) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36494b(bArr);
        return mo6791w();
    }

    public final BufferedSink mo6765c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36495b(bArr, i, i2);
        return mo6791w();
    }

    public final long mo6752a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.f36203a, 8192);
            if (read == -1) {
                return j;
            }
            j += read;
            mo6791w();
        }
    }

    public final BufferedSink mo6775h(int i) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36493b(i);
        return mo6791w();
    }

    public final BufferedSink mo6774g(int i) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36500c(i);
        return mo6791w();
    }

    public final BufferedSink mo6772f(int i) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36505d(i);
        return mo6791w();
    }

    public final BufferedSink mo6787o(long j) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36524j(j);
        return mo6791w();
    }

    public final BufferedSink mo6786n(long j) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36525k(j);
        return mo6791w();
    }

    public final BufferedSink mo6784m(long j) throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        this.f36203a.m36528l(j);
        return mo6791w();
    }

    public final BufferedSink mo6791w() throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        long f = this.f36203a.m36512f();
        if (f > 0) {
            this.f36204b.write(this.f36203a, f);
        }
        return this;
    }

    public final BufferedSink mo6763c() throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        long j = this.f36203a.f36201b;
        if (j > 0) {
            this.f36204b.write(this.f36203a, j);
        }
        return this;
    }

    public final OutputStream mo6759b() {
        return new C21871(this);
    }

    public final void flush() throws IOException {
        if (this.f36205c) {
            throw new IllegalStateException("closed");
        }
        if (this.f36203a.f36201b > 0) {
            this.f36204b.write(this.f36203a, this.f36203a.f36201b);
        }
        this.f36204b.flush();
    }

    public final void close() throws IOException {
        if (!this.f36205c) {
            Throwable th = null;
            try {
                if (this.f36203a.f36201b > 0) {
                    this.f36204b.write(this.f36203a, this.f36203a.f36201b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f36204b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f36205c = true;
            if (th != null) {
                Util.m28311a(th);
            }
        }
    }

    public final Timeout timeout() {
        return this.f36204b.timeout();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append(this.f36204b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
