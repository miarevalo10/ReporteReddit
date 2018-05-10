package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.UrlUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OAuth1aInterceptor implements Interceptor {
    final Session<? extends TwitterAuthToken> f30719a;
    final TwitterAuthConfig f30720b;

    public OAuth1aInterceptor(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        this.f30719a = session;
        this.f30720b = twitterAuthConfig;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Builder newBuilder = request.newBuilder();
        HttpUrl url = request.url();
        HttpUrl.Builder query = url.newBuilder().query(null);
        int querySize = url.querySize();
        int i = 0;
        for (int i2 = 0; i2 < querySize; i2++) {
            query.addEncodedQueryParameter(UrlUtils.m26424b(url.queryParameterName(i2)), UrlUtils.m26424b(url.queryParameterValue(i2)));
        }
        request = newBuilder.url(query.build()).build();
        newBuilder = request.newBuilder();
        String str = HttpRequest.HEADER_AUTHORIZATION;
        OAuth1aHeaders oAuth1aHeaders = new OAuth1aHeaders();
        TwitterAuthConfig twitterAuthConfig = this.f30720b;
        TwitterAuthToken twitterAuthToken = (TwitterAuthToken) this.f30719a.f23922a;
        String method = request.method();
        String httpUrl = request.url().toString();
        Map hashMap = new HashMap();
        if (HttpRequest.METHOD_POST.equals(request.method().toUpperCase(Locale.US))) {
            RequestBody body = request.body();
            if (body instanceof FormBody) {
                FormBody formBody = (FormBody) body;
                while (i < formBody.size()) {
                    hashMap.put(formBody.encodedName(i), formBody.value(i));
                    i++;
                }
            }
        }
        return chain.proceed(newBuilder.header(str, OAuth1aHeaders.m25872a(twitterAuthConfig, twitterAuthToken, null, method, httpUrl, hashMap)).build());
    }
}
