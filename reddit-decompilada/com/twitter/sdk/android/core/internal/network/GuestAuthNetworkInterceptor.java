package com.twitter.sdk.android.core.internal.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

public class GuestAuthNetworkInterceptor implements Interceptor {
    public Response intercept(Chain chain) throws IOException {
        chain = chain.proceed(chain.request());
        return chain.code() == 403 ? chain.newBuilder().code(401).build() : chain;
    }
}
