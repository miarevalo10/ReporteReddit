package com.sendbird.android.shadow.okhttp3.internal.http;

import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import java.io.IOException;
import java.util.List;

public final class RealInterceptorChain implements Chain {
    public final StreamAllocation f30407a;
    final HttpCodec f30408b;
    final RealConnection f30409c;
    public final Request f30410d;
    final Call f30411e;
    final EventListener f30412f;
    private final List<Interceptor> f30413g;
    private final int f30414h;
    private final int f30415i;
    private final int f30416j;
    private final int f30417k;
    private int f30418l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f30413g = list;
        this.f30409c = realConnection;
        this.f30407a = streamAllocation;
        this.f30408b = httpCodec;
        this.f30414h = i;
        this.f30410d = request;
        this.f30411e = call;
        this.f30412f = eventListener;
        this.f30415i = i2;
        this.f30416j = i3;
        this.f30417k = i4;
    }

    public final int mo5331b() {
        return this.f30415i;
    }

    public final int mo5332c() {
        return this.f30416j;
    }

    public final int mo5333d() {
        return this.f30417k;
    }

    public final Request mo5329a() {
        return this.f30410d;
    }

    public final Response mo5330a(Request request) throws IOException {
        return m31373a(request, this.f30407a, this.f30408b, this.f30409c);
    }

    public final Response m31373a(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f30414h >= this.f30413g.size()) {
            throw new AssertionError();
        }
        r0.f30418l++;
        StringBuilder stringBuilder;
        if (r0.f30408b != null && !r0.f30409c.m31366a(request.url())) {
            stringBuilder = new StringBuilder("network interceptor ");
            stringBuilder.append(r0.f30413g.get(r0.f30414h - 1));
            stringBuilder.append(" must retain the same host and port");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (r0.f30408b == null || r0.f30418l <= 1) {
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(r0.f30413g, streamAllocation, httpCodec, realConnection, r0.f30414h + 1, request, r0.f30411e, r0.f30412f, r0.f30415i, r0.f30416j, r0.f30417k);
            Interceptor interceptor = (Interceptor) r0.f30413g.get(r0.f30414h);
            Response a = interceptor.mo5325a(realInterceptorChain);
            StringBuilder stringBuilder2;
            if (httpCodec != null && r0.f30414h + 1 < r0.f30413g.size() && realInterceptorChain.f30418l != 1) {
                stringBuilder2 = new StringBuilder("network interceptor ");
                stringBuilder2.append(interceptor);
                stringBuilder2.append(" must call proceed() exactly once");
                throw new IllegalStateException(stringBuilder2.toString());
            } else if (a == null) {
                stringBuilder2 = new StringBuilder("interceptor ");
                stringBuilder2.append(interceptor);
                stringBuilder2.append(" returned null");
                throw new NullPointerException(stringBuilder2.toString());
            } else if (a.f23314g != null) {
                return a;
            } else {
                stringBuilder2 = new StringBuilder("interceptor ");
                stringBuilder2.append(interceptor);
                stringBuilder2.append(" returned a response with no body");
                throw new IllegalStateException(stringBuilder2.toString());
            }
        } else {
            stringBuilder = new StringBuilder("network interceptor ");
            stringBuilder.append(r0.f30413g.get(r0.f30414h - 1));
            stringBuilder.append(" must call proceed() exactly once");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
