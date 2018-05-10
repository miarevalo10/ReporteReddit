package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.Interceptor;
import com.sendbird.android.shadow.okhttp3.Interceptor.Chain;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.http.RealInterceptorChain;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;

public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient f30388a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f30388a = okHttpClient;
    }

    public final Response mo5325a(Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.f30410d;
        StreamAllocation streamAllocation = realInterceptorChain.f30407a;
        return realInterceptorChain.m31373a(request, streamAllocation, streamAllocation.m25408a(this.f30388a, chain, request.method().equals(HttpRequest.METHOD_GET) ^ 1), streamAllocation.m25413b());
    }
}
