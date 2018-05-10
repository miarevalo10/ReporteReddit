package com.sendbird.android.shadow.okio;

import com.facebook.stetho.dumpapp.Framer;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource {
    public final Buffer f34630a = new Buffer();
    public final Source f34631b;
    boolean f34632c;

    RealBufferedSource(Source source) {
        if (source == null) {
            throw new NullPointerException("source == null");
        }
        this.f34631b = source;
    }

    public final Buffer mo6552b() {
        return this.f34630a;
    }

    public final long mo5322a(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f34632c) {
            throw new IllegalStateException("closed");
        } else if (this.f34630a.f34625b == 0 && this.f34631b.mo5322a(this.f34630a, 8192) == -1) {
            return -1;
        } else {
            return this.f34630a.mo5322a(buffer, Math.min(j, this.f34630a.f34625b));
        }
    }

    public final boolean mo6562d() throws IOException {
        if (!this.f34632c) {
            return this.f34630a.mo6562d() && this.f34631b.mo5322a(this.f34630a, 8192) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final void mo6550a(long j) throws IOException {
        if (m35525b(j) == null) {
            throw new EOFException();
        }
    }

    private boolean m35525b(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f34632c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f34630a.f34625b < j) {
                if (this.f34631b.mo5322a(this.f34630a, 8192) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public final byte mo6563f() throws IOException {
        mo6550a(1);
        return this.f34630a.mo6563f();
    }

    public final ByteString mo6560c(long j) throws IOException {
        mo6550a(j);
        return this.f34630a.mo6560c(j);
    }

    public final byte[] mo6565f(long j) throws IOException {
        mo6550a(j);
        return this.f34630a.mo6565f(j);
    }

    public final void mo6551a(byte[] bArr) throws IOException {
        try {
            mo6550a((long) bArr.length);
            this.f34630a.mo6551a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f34630a.f34625b > 0) {
                int a = this.f34630a.mo6547a(bArr, i, (int) this.f34630a.f34625b);
                if (a == -1) {
                    throw new AssertionError();
                }
                i += a;
            }
            throw e;
        }
    }

    public final int mo6547a(byte[] bArr, int i, int i2) throws IOException {
        long j = (long) i2;
        Util.m25643a((long) bArr.length, (long) i, j);
        if (this.f34630a.f34625b == 0 && this.f34631b.mo5322a(this.f34630a, 8192) == -1) {
            return -1;
        }
        return this.f34630a.mo6547a(bArr, i, (int) Math.min(j, this.f34630a.f34625b));
    }

    public final void mo6554b(Buffer buffer, long j) throws IOException {
        try {
            mo6550a(j);
            this.f34630a.mo6554b(buffer, j);
        } catch (long j2) {
            buffer.mo6548a(this.f34630a);
            throw j2;
        }
    }

    public final String mo6549a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f34630a.mo6548a(this.f34631b);
        return this.f34630a.mo6549a(charset);
    }

    public final String mo6579p() throws IOException {
        return mo6561d(Long.MAX_VALUE);
    }

    public final String mo6561d(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("limit < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long a = m35524a((byte) 10, 0, j2);
        if (a != -1) {
            return this.f34630a.m35480e(a);
        }
        if (j2 < Long.MAX_VALUE && m35525b(j2) && this.f34630a.m35461b(j2 - 1) == (byte) 13 && m35525b(1 + j2) && this.f34630a.m35461b(j2) == (byte) 10) {
            return this.f34630a.m35480e(j2);
        }
        Buffer buffer = new Buffer();
        this.f34630a.m35453a(buffer, 0, Math.min(32, this.f34630a.f34625b));
        stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.f34630a.f34625b, j));
        stringBuilder.append(" content=");
        stringBuilder.append(buffer.m35500n().mo5403f());
        stringBuilder.append(8230);
        throw new EOFException(stringBuilder.toString());
    }

    public final short mo6567g() throws IOException {
        mo6550a(2);
        return this.f34630a.mo6567g();
    }

    public final short mo6572j() throws IOException {
        mo6550a(2);
        return Util.m25642a(this.f34630a.mo6567g());
    }

    public final int mo6569h() throws IOException {
        mo6550a(4);
        return this.f34630a.mo6569h();
    }

    public final int mo6573k() throws IOException {
        mo6550a(4);
        return Util.m25641a(this.f34630a.mo6569h());
    }

    public final long mo6571i() throws IOException {
        mo6550a(8);
        return this.f34630a.mo6571i();
    }

    public final long mo6575l() throws IOException {
        mo6550a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m35525b((long) i2)) {
                break;
            }
            byte b = this.f34630a.m35461b((long) i);
            if (b < (byte) 48 || b > (byte) 57) {
                if (i != 0) {
                    break;
                } else if (b != Framer.STDIN_FRAME_PREFIX) {
                    break;
                }
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b)}));
        }
        return this.f34630a.mo6575l();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo6577m() throws java.io.IOException {
        /*
        r6 = this;
        r0 = 1;
        r6.mo6550a(r0);
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.m35525b(r3);
        if (r3 == 0) goto L_0x0049;
    L_0x0010:
        r3 = r6.f34630a;
        r4 = (long) r1;
        r3 = r3.m35461b(r4);
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
        r0 = r6.f34630a;
        r0 = r0.mo6577m();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.RealBufferedSource.m():long");
    }

    public final void mo6568g(long j) throws IOException {
        if (this.f34632c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f34630a.f34625b == 0 && this.f34631b.mo5322a(this.f34630a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f34630a.f34625b);
            this.f34630a.mo6568g(min);
            j -= min;
        }
    }

    public final long mo6580s() throws IOException {
        return m35524a((byte) 0, 0, Long.MAX_VALUE);
    }

    private long m35524a(byte b, long j, long j2) throws IOException {
        if (this.f34632c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(0), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.f34630a.m35449a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                a = this.f34630a.f34625b;
                if (a < j2) {
                    if (this.f34631b.mo5322a(this.f34630a, 8192) != -1) {
                        j = Math.max(j, a);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    public final boolean mo6555b(ByteString byteString) throws IOException {
        int h = byteString.mo5405h();
        if (this.f34632c) {
            throw new IllegalStateException("closed");
        }
        if (h >= 0) {
            if (byteString.mo5405h() - 0 >= h) {
                int i = 0;
                while (i < h) {
                    long j = 0 + ((long) i);
                    if (!m35525b(1 + j) || this.f34630a.m35461b(j) != byteString.mo5392a(0 + i)) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public final void close() throws IOException {
        if (!this.f34632c) {
            this.f34632c = true;
            this.f34631b.close();
            this.f34630a.m35504r();
        }
    }

    public final Timeout mo5323a() {
        return this.f34631b.mo5323a();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append(this.f34631b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
