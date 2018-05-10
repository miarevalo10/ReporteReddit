package okio;

import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource {
    public final Buffer f36206a = new Buffer();
    public final Source f36207b;
    boolean f36208c;

    class C21881 extends InputStream {
        final /* synthetic */ RealBufferedSource f26677a;

        C21881(RealBufferedSource realBufferedSource) {
            this.f26677a = realBufferedSource;
        }

        public int read() throws IOException {
            if (this.f26677a.f36208c) {
                throw new IOException("closed");
            } else if (this.f26677a.f36206a.f36201b == 0 && this.f26677a.f36207b.read(this.f26677a.f36206a, 8192) == -1) {
                return -1;
            } else {
                return this.f26677a.f36206a.mo6773g() & 255;
            }
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.f26677a.f36208c) {
                throw new IOException("closed");
            }
            Util.m28310a((long) bArr.length, (long) i, (long) i2);
            if (this.f26677a.f36206a.f36201b == 0 && this.f26677a.f36207b.read(this.f26677a.f36206a, 8192) == -1) {
                return -1;
            }
            return this.f26677a.f36206a.mo6750a(bArr, i, i2);
        }

        public int available() throws IOException {
            if (!this.f26677a.f36208c) {
                return (int) Math.min(this.f26677a.f36206a.f36201b, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() throws IOException {
            this.f26677a.close();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f26677a);
            stringBuilder.append(".inputStream()");
            return stringBuilder.toString();
        }
    }

    RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.f36207b = source;
    }

    public final Buffer mo6754a() {
        return this.f36206a;
    }

    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f36208c) {
            throw new IllegalStateException("closed");
        } else if (this.f36206a.f36201b == 0 && this.f36207b.read(this.f36206a, 8192) == -1) {
            return -1;
        } else {
            return this.f36206a.read(buffer, Math.min(j, this.f36206a.f36201b));
        }
    }

    public final boolean mo6769d() throws IOException {
        if (!this.f36208c) {
            return this.f36206a.mo6769d() && this.f36207b.read(this.f36206a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final void mo6755a(long j) throws IOException {
        if (mo6762b(j) == null) {
            throw new EOFException();
        }
    }

    public final boolean mo6762b(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f36208c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f36206a.f36201b < j) {
                if (this.f36207b.read(this.f36206a, 8192) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public final byte mo6773g() throws IOException {
        mo6755a(1);
        return this.f36206a.mo6773g();
    }

    public final ByteString mo6768d(long j) throws IOException {
        mo6755a(j);
        return this.f36206a.mo6768d(j);
    }

    public final int mo6749a(Options options) throws IOException {
        if (this.f36208c) {
            throw new IllegalStateException("closed");
        }
        do {
            int b = this.f36206a.m36490b(options);
            if (b == -1) {
                return -1;
            }
            long h = (long) options.f26669a[b].mo6166h();
            if (h <= this.f36206a.f36201b) {
                this.f36206a.mo6779i(h);
                return b;
            }
        } while (this.f36207b.read(this.f36206a, 8192) != -1);
        return -1;
    }

    public final byte[] mo6789s() throws IOException {
        this.f36206a.mo6752a(this.f36207b);
        return this.f36206a.mo6789s();
    }

    public final byte[] mo6777h(long j) throws IOException {
        mo6755a(j);
        return this.f36206a.mo6777h(j);
    }

    public final void mo6757a(byte[] bArr) throws IOException {
        try {
            mo6755a((long) bArr.length);
            this.f36206a.mo6757a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f36206a.f36201b > 0) {
                int a = this.f36206a.mo6750a(bArr, i, (int) this.f36206a.f36201b);
                if (a == -1) {
                    throw new AssertionError();
                }
                i += a;
            }
            throw e;
        }
    }

    public final int mo6750a(byte[] bArr, int i, int i2) throws IOException {
        long j = (long) i2;
        Util.m28310a((long) bArr.length, (long) i, j);
        if (this.f36206a.f36201b == 0 && this.f36207b.read(this.f36206a, 8192) == -1) {
            return -1;
        }
        return this.f36206a.mo6750a(bArr, i, (int) Math.min(j, this.f36206a.f36201b));
    }

    public final void mo6756a(Buffer buffer, long j) throws IOException {
        try {
            mo6755a(j);
            this.f36206a.mo6756a(buffer, j);
        } catch (long j2) {
            buffer.mo6752a(this.f36206a);
            throw j2;
        }
    }

    public final long mo6751a(Sink sink) throws IOException {
        long j = 0;
        while (this.f36207b.read(this.f36206a, 8192) != -1) {
            long f = this.f36206a.m36512f();
            if (f > 0) {
                j += f;
                sink.write(this.f36206a, f);
            }
        }
        if (this.f36206a.f36201b <= 0) {
            return j;
        }
        j += this.f36206a.f36201b;
        sink.write(this.f36206a, this.f36206a.f36201b);
        return j;
    }

    public final String mo6753a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f36206a.mo6752a(this.f36207b);
        return this.f36206a.mo6753a(charset);
    }

    public final String mo6788q() throws IOException {
        return mo6771f(Long.MAX_VALUE);
    }

    public final String mo6771f(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a = m36559a((byte) 10, 0, j2);
        if (a != -1) {
            return this.f36206a.m36516g(a);
        }
        if (j2 < Long.MAX_VALUE && mo6762b(j2) && this.f36206a.m36499c(j2 - 1) == (byte) 13 && mo6762b(1 + j2) && this.f36206a.m36499c(j2) == (byte) 10) {
            return this.f36206a.m36516g(j2);
        }
        Buffer buffer = new Buffer();
        this.f36206a.m36485a(buffer, 0, Math.min(32, this.f36206a.f36201b));
        stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.f36206a.f36201b, j));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer.m36534o().mo6164f());
        stringBuilder.append(8230);
        throw new EOFException(stringBuilder.toString());
    }

    public final short mo6776h() throws IOException {
        mo6755a(2);
        return this.f36206a.mo6776h();
    }

    public final short mo6781k() throws IOException {
        mo6755a(2);
        return Util.m28309a(this.f36206a.mo6776h());
    }

    public final int mo6778i() throws IOException {
        mo6755a(4);
        return this.f36206a.mo6778i();
    }

    public final int mo6782l() throws IOException {
        mo6755a(4);
        return Util.m28308a(this.f36206a.mo6778i());
    }

    public final long mo6780j() throws IOException {
        mo6755a(8);
        return this.f36206a.mo6780j();
    }

    public final long mo6783m() throws IOException {
        mo6755a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo6762b((long) i2)) {
                break;
            }
            byte c = this.f36206a.m36499c((long) i);
            if (c < (byte) 48 || c > (byte) 57) {
                if (i != 0) {
                    break;
                } else if (c != Framer.STDIN_FRAME_PREFIX) {
                    break;
                }
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(c)}));
        }
        return this.f36206a.mo6783m();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo6785n() throws java.io.IOException {
        /*
        r6 = this;
        r0 = 1;
        r6.mo6755a(r0);
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.mo6762b(r3);
        if (r3 == 0) goto L_0x0049;
    L_0x0010:
        r3 = r6.f36206a;
        r4 = (long) r1;
        r3 = r3.m36499c(r4);
        r4 = 48;
        if (r3 < r4) goto L_0x001f;
    L_0x001b:
        r4 = 57;
        if (r3 <= r4) goto L_0x0030;
    L_0x001f:
        r4 = 97;
        if (r3 < r4) goto L_0x0027;
    L_0x0023:
        r4 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 <= r4) goto L_0x0030;
    L_0x0027:
        r4 = 65;
        if (r3 < r4) goto L_0x0032;
    L_0x002b:
        r4 = 70;
        if (r3 <= r4) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r1 = r2;
        goto L_0x0007;
    L_0x0032:
        if (r1 != 0) goto L_0x0049;
    L_0x0034:
        r1 = new java.lang.NumberFormatException;
        r2 = "Expected leading [0-9a-fA-F] character but was %#x";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r3 = java.lang.Byte.valueOf(r3);
        r4[r0] = r3;
        r0 = java.lang.String.format(r2, r4);
        r1.<init>(r0);
        throw r1;
    L_0x0049:
        r0 = r6.f36206a;
        r0 = r0.mo6785n();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.n():long");
    }

    public final void mo6779i(long j) throws IOException {
        if (this.f36208c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f36206a.f36201b == 0 && this.f36207b.read(this.f36206a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f36206a.f36201b);
            this.f36206a.mo6779i(min);
            j -= min;
        }
    }

    public final long mo6790u() throws IOException {
        return m36559a((byte) 0, 0, Long.MAX_VALUE);
    }

    private long m36559a(byte b, long j, long j2) throws IOException {
        if (this.f36208c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(0), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f36206a.m36475a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                a = this.f36206a.f36201b;
                if (a < j2) {
                    if (this.f36207b.read(this.f36206a, 8192) != -1) {
                        j = Math.max(j, a);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    public final boolean mo6766c(ByteString byteString) throws IOException {
        int h = byteString.mo6166h();
        if (this.f36208c) {
            throw new IllegalStateException("closed");
        }
        if (h >= 0) {
            if (byteString.mo6166h() - 0 >= h) {
                int i = 0;
                while (i < h) {
                    long j = 0 + ((long) i);
                    if (!mo6762b(1 + j) || this.f36206a.m36499c(j) != byteString.mo6153a(0 + i)) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public final InputStream mo6770e() {
        return new C21881(this);
    }

    public final void close() throws IOException {
        if (!this.f36208c) {
            this.f36208c = true;
            this.f36207b.close();
            this.f36206a.m36539t();
        }
    }

    public final Timeout timeout() {
        return this.f36207b.timeout();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append(this.f36207b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final long mo6758b(ByteString byteString) throws IOException {
        if (this.f36208c) {
            throw new IllegalStateException("closed");
        }
        long j = 0;
        while (true) {
            long a = this.f36206a.m36476a(byteString, j);
            if (a != -1) {
                return a;
            }
            a = this.f36206a.f36201b;
            if (this.f36207b.read(this.f36206a, 8192) == -1) {
                return -1;
            }
            j = Math.max(j, a);
        }
    }
}
