package com.sendbird.android.shadow.okhttp3.internal.http1;

import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.Response.Builder;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.RealResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.http.RequestLine;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ForwardingTimeout;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class Http1Codec implements HttpCodec {
    final OkHttpClient f30438a;
    final StreamAllocation f30439b;
    final BufferedSource f30440c;
    final BufferedSink f30441d;
    int f30442e = 0;
    private long f30443f = 262144;

    private abstract class AbstractSource implements Source {
        protected final ForwardingTimeout f30427a;
        protected boolean f30428b;
        protected long f30429c;
        final /* synthetic */ Http1Codec f30430d;

        private AbstractSource(Http1Codec http1Codec) {
            this.f30430d = http1Codec;
            this.f30427a = new ForwardingTimeout(this.f30430d.f30440c.mo5323a());
            this.f30429c = 0;
        }

        public final Timeout mo5323a() {
            return this.f30427a;
        }

        public long mo5322a(Buffer buffer, long j) throws IOException {
            try {
                buffer = this.f30430d.f30440c.mo5322a(buffer, j);
                if (buffer > 0) {
                    this.f30429c += buffer;
                }
                return buffer;
            } catch (IOException e) {
                m31386a((boolean) 0, e);
                throw e;
            }
        }

        protected final void m31386a(boolean z, IOException iOException) throws IOException {
            if (this.f30430d.f30442e != 6) {
                if (this.f30430d.f30442e != 5) {
                    iOException = new StringBuilder("state: ");
                    iOException.append(this.f30430d.f30442e);
                    throw new IllegalStateException(iOException.toString());
                }
                Http1Codec.m31389a(this.f30427a);
                this.f30430d.f30442e = 6;
                if (this.f30430d.f30439b != null) {
                    this.f30430d.f30439b.m25412a(z ^ 1, this.f30430d, iOException);
                }
            }
        }
    }

    private final class ChunkedSink implements Sink {
        final /* synthetic */ Http1Codec f30431a;
        private final ForwardingTimeout f30432b = new ForwardingTimeout(this.f30431a.f30441d.mo5334a());
        private boolean f30433c;

        ChunkedSink(Http1Codec http1Codec) {
            this.f30431a = http1Codec;
        }

        public final Timeout mo5334a() {
            return this.f30432b;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            if (this.f30433c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.f30431a.f30441d.mo6574k(j);
                this.f30431a.f30441d.mo6553b("\r\n");
                this.f30431a.f30441d.a_(buffer, j);
                this.f30431a.f30441d.mo6553b("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.f30433c) {
                this.f30431a.f30441d.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.f30433c) {
                this.f30433c = true;
                this.f30431a.f30441d.mo6553b("0\r\n\r\n");
                Http1Codec.m31389a(this.f30432b);
                this.f30431a.f30442e = 3;
            }
        }
    }

    private final class FixedLengthSink implements Sink {
        final /* synthetic */ Http1Codec f30434a;
        private final ForwardingTimeout f30435b = new ForwardingTimeout(this.f30434a.f30441d.mo5334a());
        private boolean f30436c;
        private long f30437d;

        FixedLengthSink(Http1Codec http1Codec, long j) {
            this.f30434a = http1Codec;
            this.f30437d = j;
        }

        public final Timeout mo5334a() {
            return this.f30435b;
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            if (this.f30436c) {
                throw new IllegalStateException("closed");
            }
            Util.m25365a(buffer.f34625b, j);
            if (j > this.f30437d) {
                StringBuilder stringBuilder = new StringBuilder("expected ");
                stringBuilder.append(this.f30437d);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(j);
                throw new ProtocolException(stringBuilder.toString());
            }
            this.f30434a.f30441d.a_(buffer, j);
            this.f30437d -= j;
        }

        public final void flush() throws IOException {
            if (!this.f30436c) {
                this.f30434a.f30441d.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.f30436c) {
                this.f30436c = true;
                if (this.f30437d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                Http1Codec.m31389a(this.f30435b);
                this.f30434a.f30442e = 3;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        final /* synthetic */ Http1Codec f34611e;
        private final HttpUrl f34612f;
        private long f34613g = -1;
        private boolean f34614h = true;

        ChunkedSource(Http1Codec http1Codec, HttpUrl httpUrl) {
            this.f34611e = http1Codec;
            super();
            this.f34612f = httpUrl;
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.f34614h) {
                return -1;
            } else {
                if (this.f34613g == 0 || this.f34613g == -1) {
                    if (this.f34613g != -1) {
                        this.f34611e.f30440c.mo6579p();
                    }
                    try {
                        this.f34613g = this.f34611e.f30440c.mo6577m();
                        String trim = this.f34611e.f30440c.mo6579p().trim();
                        if (this.f34613g >= 0) {
                            if (trim.isEmpty() || trim.startsWith(";")) {
                                if (this.f34613g == 0) {
                                    this.f34614h = false;
                                    HttpHeaders.m25430a(this.f34611e.f30438a.f23269k, this.f34612f, this.f34611e.m31400d());
                                    m31386a(true, null);
                                }
                                if (!this.f34614h) {
                                    return -1;
                                }
                            }
                        }
                        j = new StringBuilder("expected chunk size and optional extensions but was \"");
                        j.append(this.f34613g);
                        j.append(trim);
                        j.append("\"");
                        throw new ProtocolException(j.toString());
                    } catch (Buffer buffer2) {
                        throw new ProtocolException(buffer2.getMessage());
                    }
                }
                buffer2 = super.mo5322a(buffer2, Math.min(j, this.f34613g));
                if (buffer2 == -1) {
                    buffer2 = new ProtocolException("unexpected end of stream");
                    m31386a(false, (IOException) buffer2);
                    throw buffer2;
                }
                this.f34613g -= buffer2;
                return buffer2;
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (this.f34614h && !Util.m25369a((Source) this, TimeUnit.MILLISECONDS)) {
                    m31386a(false, null);
                }
                this.b = true;
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        final /* synthetic */ Http1Codec f34615e;
        private long f34616f;

        FixedLengthSource(Http1Codec http1Codec, long j) throws IOException {
            this.f34615e = http1Codec;
            super();
            this.f34616f = j;
            if (this.f34616f == 0) {
                m31386a(true, (IOException) 0);
            }
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f34616f == 0) {
                return -1;
            } else {
                buffer = super.mo5322a(buffer, Math.min(this.f34616f, j));
                if (buffer == -1) {
                    buffer = new ProtocolException("unexpected end of stream");
                    m31386a((boolean) 0, (IOException) buffer);
                    throw buffer;
                }
                this.f34616f -= buffer;
                if (this.f34616f == 0) {
                    m31386a(true, null);
                }
                return buffer;
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (!(this.f34616f == 0 || Util.m25369a((Source) this, TimeUnit.MILLISECONDS))) {
                    m31386a(false, null);
                }
                this.b = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        final /* synthetic */ Http1Codec f34617e;
        private boolean f34618f;

        UnknownLengthSource(Http1Codec http1Codec) {
            this.f34617e = http1Codec;
            super();
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.f34618f) {
                return -1;
            } else {
                buffer = super.mo5322a(buffer, j);
                if (buffer != -1) {
                    return buffer;
                }
                this.f34618f = true;
                m31386a(true, (IOException) 0);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.b) {
                if (!this.f34618f) {
                    m31386a(false, null);
                }
                this.b = true;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f30438a = okHttpClient;
        this.f30439b = streamAllocation;
        this.f30440c = bufferedSource;
        this.f30441d = bufferedSink;
    }

    public final Sink mo5340a(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding")) != null) {
            if (this.f30442e != 1) {
                j = new StringBuilder("state: ");
                j.append(this.f30442e);
                throw new IllegalStateException(j.toString());
            }
            this.f30442e = 2;
            return new ChunkedSink(this);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f30442e != 1) {
            j = new StringBuilder("state: ");
            j.append(this.f30442e);
            throw new IllegalStateException(j.toString());
        } else {
            this.f30442e = 2;
            return new FixedLengthSink(this, j);
        }
    }

    public final void mo5344c() {
        RealConnection b = this.f30439b.m25413b();
        if (b != null) {
            Util.m25367a(b.f30392b);
        }
    }

    public final void mo5342a(Request request) throws IOException {
        m31396a(request.headers(), RequestLine.m25442a(request, this.f30439b.m25413b().f30391a.f23322b.type()));
    }

    public final ResponseBody mo5339a(Response response) throws IOException {
        EventListener eventListener = this.f30439b.f23412f;
        Call call = this.f30439b.f23411e;
        EventListener.m25253q();
        String a = response.m25333a("Content-Type");
        if (!HttpHeaders.m25435d(response)) {
            return new RealResponseBody(a, 0, Okio.m25615a(m31394a(0)));
        }
        if ("chunked".equalsIgnoreCase(response.m25333a("Transfer-Encoding"))) {
            response = response.f23308a.url();
            if (this.f30442e != 4) {
                StringBuilder stringBuilder = new StringBuilder("state: ");
                stringBuilder.append(this.f30442e);
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.f30442e = 5;
            return new RealResponseBody(a, -1, Okio.m25615a(new ChunkedSource(this, response)));
        }
        long a2 = HttpHeaders.m25427a(response);
        if (a2 != -1) {
            return new RealResponseBody(a, a2, Okio.m25615a(m31394a(a2)));
        }
        if (this.f30442e != 4) {
            stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.f30442e);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.f30439b == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.f30442e = 5;
            this.f30439b.m25415d();
            return new RealResponseBody(a, -1, Okio.m25615a(new UnknownLengthSource(this)));
        }
    }

    public final void mo5341a() throws IOException {
        this.f30441d.flush();
    }

    public final void mo5343b() throws IOException {
        this.f30441d.flush();
    }

    public final void m31396a(Headers headers, String str) throws IOException {
        if (this.f30442e != 0) {
            str = new StringBuilder("state: ");
            str.append(this.f30442e);
            throw new IllegalStateException(str.toString());
        }
        this.f30441d.mo6553b(str).mo6553b("\r\n");
        int length = headers.f23197a.length / 2;
        for (int i = null; i < length; i++) {
            this.f30441d.mo6553b(headers.m25268a(i)).mo6553b(": ").mo6553b(headers.m25270b(i)).mo6553b("\r\n");
        }
        this.f30441d.mo6553b("\r\n");
        this.f30442e = 1;
    }

    public final Builder mo5338a(boolean z) throws IOException {
        if (this.f30442e == 1 || this.f30442e == 3) {
            try {
                StatusLine a = StatusLine.m25443a(m31390e());
                Builder builder = new Builder();
                builder.f23297b = a.f23425a;
                builder.f23298c = a.f23426b;
                builder.f23299d = a.f23427c;
                builder = builder.m25327a(m31400d());
                if (z && a.f23426b) {
                    return false;
                }
                this.f30442e = true;
                return builder;
            } catch (boolean z2) {
                StringBuilder stringBuilder = new StringBuilder("unexpected end of stream on ");
                stringBuilder.append(this.f30439b);
                IOException iOException = new IOException(stringBuilder.toString());
                iOException.initCause(z2);
                throw iOException;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("state: ");
        stringBuilder2.append(this.f30442e);
        throw new IllegalStateException(stringBuilder2.toString());
    }

    private String m31390e() throws IOException {
        String d = this.f30440c.mo6561d(this.f30443f);
        this.f30443f -= (long) d.length();
        return d;
    }

    public final Headers m31400d() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String e = m31390e();
            if (e.length() == 0) {
                return builder.m25262a();
            }
            Internal.instance.addLenient(builder, e);
        }
    }

    public final Source m31394a(long j) throws IOException {
        if (this.f30442e != 4) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.f30442e);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.f30442e = 5;
        return new FixedLengthSource(this, j);
    }

    static void m31389a(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.f30571a;
        Timeout timeout2 = Timeout.f23616c;
        if (timeout2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        forwardingTimeout.f30571a = timeout2;
        timeout.ax_();
        timeout.mo5390d();
    }
}
