package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.IOException;
import java.util.Random;

final class WebSocketWriter {
    final boolean f23589a;
    final Random f23590b;
    final BufferedSink f23591c;
    boolean f23592d;
    final Buffer f23593e = new Buffer();
    final FrameSink f23594f = new FrameSink(this);
    boolean f23595g;
    final byte[] f23596h;
    final byte[] f23597i;

    final class FrameSink implements Sink {
        int f30554a;
        long f30555b;
        boolean f30556c;
        boolean f30557d;
        final /* synthetic */ WebSocketWriter f30558e;

        FrameSink(WebSocketWriter webSocketWriter) {
            this.f30558e = webSocketWriter;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            if (this.f30557d) {
                throw new IOException("closed");
            }
            this.f30558e.f23593e.a_(buffer, j);
            buffer = (this.f30556c == null || this.f30555b == -1 || this.f30558e.f23593e.f34625b <= this.f30555b - 8192) ? null : true;
            long e = this.f30558e.f23593e.m35478e();
            if (e > 0 && buffer == null) {
                this.f30558e.m25589a(this.f30554a, e, this.f30556c, false);
                this.f30556c = false;
            }
        }

        public final void flush() throws IOException {
            if (this.f30557d) {
                throw new IOException("closed");
            }
            this.f30558e.m25589a(this.f30554a, this.f30558e.f23593e.f34625b, this.f30556c, false);
            this.f30556c = false;
        }

        public final Timeout mo5334a() {
            return this.f30558e.f23591c.mo5334a();
        }

        public final void close() throws IOException {
            if (this.f30557d) {
                throw new IOException("closed");
            }
            this.f30558e.m25589a(this.f30554a, this.f30558e.f23593e.f34625b, this.f30556c, true);
            this.f30557d = true;
            this.f30558e.f23595g = false;
        }
    }

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random == null) {
            throw new NullPointerException("random == null");
        } else {
            this.f23589a = z;
            this.f23591c = bufferedSink;
            this.f23590b = random;
            bufferedSink = null;
            this.f23596h = z ? new byte[4] : null;
            if (z) {
                bufferedSink = new byte[true];
            }
            this.f23597i = bufferedSink;
        }
    }

    final void m25590a(int i, ByteString byteString) throws IOException {
        if (this.f23592d) {
            throw new IOException("closed");
        }
        int h = byteString.mo5405h();
        if (((long) h) > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f23591c.mo6570h(i | 128);
        if (this.f23589a != 0) {
            this.f23591c.mo6570h(h | 128);
            this.f23590b.nextBytes(this.f23596h);
            this.f23591c.mo6558c(this.f23596h);
            byte[] i2 = byteString.mo5407i();
            WebSocketProtocol.m25579a(i2, (long) i2.length, this.f23596h, 0);
            this.f23591c.mo6558c(i2);
        } else {
            this.f23591c.mo6570h(h);
            this.f23591c.mo6557c(byteString);
        }
        this.f23591c.flush();
    }

    final void m25589a(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.f23592d) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.f23591c.mo6570h(i);
        i = this.f23589a != 0 ? 128 : 0;
        if (j <= true) {
            this.f23591c.mo6570h(i | ((int) j));
        } else if (j <= true) {
            this.f23591c.mo6570h(i | 126);
            this.f23591c.mo6566g((int) j);
        } else {
            this.f23591c.mo6570h(i | 127);
            this.f23591c.mo6578m(j);
        }
        if (this.f23589a != 0) {
            this.f23590b.nextBytes(this.f23596h);
            this.f23591c.mo6558c(this.f23596h);
            z = 0;
            while (z < j) {
                i = this.f23593e.mo6547a(this.f23597i, 0, (int) Math.min(j, (long) this.f23597i.length));
                if (i == -1) {
                    throw new AssertionError();
                }
                long j2 = (long) i;
                WebSocketProtocol.m25579a(this.f23597i, j2, this.f23596h, z);
                this.f23591c.mo6559c(this.f23597i, 0, i);
                z += j2;
            }
        } else {
            this.f23591c.a_(this.f23593e, j);
        }
        this.f23591c.mo6556c();
    }
}
