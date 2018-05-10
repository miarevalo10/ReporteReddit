package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Protocol;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.Response.Builder;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpCodec;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.RealResponseBody;
import com.sendbird.android.shadow.okhttp3.internal.http.RequestLine;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Http2Codec implements HttpCodec {
    private static final ByteString f30444b = ByteString.m25595a("connection");
    private static final ByteString f30445c = ByteString.m25595a("host");
    private static final ByteString f30446d = ByteString.m25595a("keep-alive");
    private static final ByteString f30447e = ByteString.m25595a("proxy-connection");
    private static final ByteString f30448f = ByteString.m25595a("transfer-encoding");
    private static final ByteString f30449g = ByteString.m25595a("te");
    private static final ByteString f30450h = ByteString.m25595a("encoding");
    private static final ByteString f30451i = ByteString.m25595a("upgrade");
    private static final List<ByteString> f30452j = Util.m25363a(f30444b, f30445c, f30446d, f30447e, f30449g, f30448f, f30450h, f30451i, Header.f23438c, Header.f23439d, Header.f23440e, Header.f23441f);
    private static final List<ByteString> f30453k = Util.m25363a(f30444b, f30445c, f30446d, f30447e, f30449g, f30448f, f30450h, f30451i);
    final StreamAllocation f30454a;
    private final OkHttpClient f30455l;
    private final Chain f30456m;
    private final Http2Connection f30457n;
    private Http2Stream f30458o;

    class StreamFinishingSource extends ForwardingSource {
        boolean f34619a = null;
        long f34620b = null;
        final /* synthetic */ Http2Codec f34621c;

        StreamFinishingSource(Http2Codec http2Codec, Source source) {
            this.f34621c = http2Codec;
            super(source);
        }

        public void close() throws IOException {
            super.close();
            m35441a(null);
        }

        private void m35441a(IOException iOException) {
            if (!this.f34619a) {
                this.f34619a = true;
                this.f34621c.f30454a.m25412a(false, this.f34621c, iOException);
            }
        }

        public final long mo5322a(Buffer buffer, long j) throws IOException {
            try {
                buffer = this.f30570d.mo5322a(buffer, j);
                if (buffer > 0) {
                    this.f34620b += buffer;
                }
                return buffer;
            } catch (Buffer buffer2) {
                m35441a(buffer2);
                throw buffer2;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f30455l = okHttpClient;
        this.f30456m = chain;
        this.f30454a = streamAllocation;
        this.f30457n = http2Connection;
    }

    public final Sink mo5340a(Request request, long j) {
        return this.f30458o.m25501d();
    }

    public final void mo5342a(Request request) throws IOException {
        if (this.f30458o == null) {
            int i = 0;
            boolean z = request.body() != null;
            Headers headers = request.headers();
            List arrayList = new ArrayList((headers.f23197a.length / 2) + 4);
            arrayList.add(new Header(Header.f23438c, request.method()));
            arrayList.add(new Header(Header.f23439d, RequestLine.m25441a(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.f23441f, header));
            }
            arrayList.add(new Header(Header.f23440e, request.url().f23214a));
            request = headers.f23197a.length / 2;
            while (i < request) {
                ByteString a = ByteString.m25595a(headers.m25268a(i).toLowerCase(Locale.US));
                if (!f30452j.contains(a)) {
                    arrayList.add(new Header(a, headers.m25270b(i)));
                }
                i++;
            }
            this.f30458o = this.f30457n.m25471a(arrayList, z);
            this.f30458o.f23513i.mo5385a((long) this.f30456m.mo5332c(), TimeUnit.MILLISECONDS);
            this.f30458o.f23514j.mo5385a((long) this.f30456m.mo5333d(), TimeUnit.MILLISECONDS);
        }
    }

    public final void mo5341a() throws IOException {
        this.f30457n.f23494q.m25516b();
    }

    public final void mo5343b() throws IOException {
        this.f30458o.m25501d().close();
    }

    public final Builder mo5338a(boolean z) throws IOException {
        List c = this.f30458o.m25499c();
        Headers.Builder builder = new Headers.Builder();
        int size = c.size();
        Headers.Builder builder2 = builder;
        StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            Header header = (Header) c.get(i);
            if (header != null) {
                ByteString byteString = header.f23442g;
                String a = header.f23443h.mo5394a();
                if (byteString.equals(Header.f23437b)) {
                    StringBuilder stringBuilder = new StringBuilder("HTTP/1.1 ");
                    stringBuilder.append(a);
                    statusLine = StatusLine.m25443a(stringBuilder.toString());
                } else if (!f30453k.contains(byteString)) {
                    Internal.instance.addLenient(builder2, byteString.mo5394a(), a);
                }
            } else if (statusLine != null && statusLine.f23426b == 100) {
                builder2 = new Headers.Builder();
                statusLine = null;
            }
        }
        if (statusLine == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Builder builder3 = new Builder();
        builder3.f23297b = Protocol.HTTP_2;
        builder3.f23298c = statusLine.f23426b;
        builder3.f23299d = statusLine.f23427c;
        builder3 = builder3.m25327a(builder2.m25262a());
        if (z && Internal.instance.code(builder3)) {
            return null;
        }
        return builder3;
    }

    public final ResponseBody mo5339a(Response response) throws IOException {
        EventListener eventListener = this.f30454a.f23412f;
        Call call = this.f30454a.f23411e;
        EventListener.m25253q();
        return new RealResponseBody(response.m25333a("Content-Type"), HttpHeaders.m25427a(response), Okio.m25615a(new StreamFinishingSource(this, this.f30458o.f23511g)));
    }

    public final void mo5344c() {
        if (this.f30458o != null) {
            this.f30458o.m25497b(ErrorCode.CANCEL);
        }
    }
}
