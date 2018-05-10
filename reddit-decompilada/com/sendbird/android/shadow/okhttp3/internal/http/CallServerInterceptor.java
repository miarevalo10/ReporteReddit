package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.Response.Builder;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import java.io.IOException;
import java.net.ProtocolException;

public final class CallServerInterceptor implements Interceptor {
    private final boolean f30406a;

    static final class CountingSink extends ForwardingSink {
        long f34610a;

        CountingSink(Sink sink) {
            super(sink);
        }

        public final void a_(Buffer buffer, long j) throws IOException {
            super.a_(buffer, j);
            this.f34610a += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f30406a = z;
    }

    public final Response mo5325a(Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpCodec httpCodec = realInterceptorChain.f30408b;
        StreamAllocation streamAllocation = realInterceptorChain.f30407a;
        RealConnection realConnection = realInterceptorChain.f30409c;
        Request request = realInterceptorChain.f30410d;
        long currentTimeMillis = System.currentTimeMillis();
        EventListener.m25247k();
        httpCodec.mo5342a(request);
        EventListener.m25248l();
        Builder builder = null;
        if (HttpMethod.m25438c(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                httpCodec.mo5341a();
                EventListener.m25251o();
                builder = httpCodec.mo5338a(true);
            }
            if (builder == null) {
                EventListener.m25249m();
                BufferedSink a = Okio.m25614a(new CountingSink(httpCodec.mo5340a(request, request.body().mo5213b())));
                request.body().mo5212a(a);
                a.close();
                EventListener.m25250n();
            } else if (!realConnection.m31368b()) {
                streamAllocation.m25415d();
            }
        }
        httpCodec.mo5343b();
        if (builder == null) {
            EventListener.m25251o();
            builder = httpCodec.mo5338a(false);
        }
        builder.f23296a = request;
        builder.f23300e = streamAllocation.m25413b().f30394d;
        builder.f23306k = currentTimeMillis;
        builder.f23307l = System.currentTimeMillis();
        Response a2 = builder.m25330a();
        EventListener.m25252p();
        int i = a2.f23310c;
        if (this.f30406a && i == 101) {
            chain = a2.m25332a();
            chain.f23302g = Util.f23336c;
            chain = chain.m25330a();
        } else {
            Builder a3 = a2.m25332a();
            a3.f23302g = httpCodec.mo5339a(a2);
            chain = a3.m25330a();
        }
        if ("close".equalsIgnoreCase(chain.f23308a.header("Connection")) || "close".equalsIgnoreCase(chain.m25333a("Connection"))) {
            streamAllocation.m25415d();
        }
        if ((i != 204 && i != 205) || chain.f23314g.mo5297b() <= 0) {
            return chain;
        }
        StringBuilder stringBuilder = new StringBuilder("HTTP ");
        stringBuilder.append(i);
        stringBuilder.append(" had non-zero Content-Length: ");
        stringBuilder.append(chain.f23314g.mo5297b());
        throw new ProtocolException(stringBuilder.toString());
    }
}
