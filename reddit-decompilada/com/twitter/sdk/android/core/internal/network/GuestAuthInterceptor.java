package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class GuestAuthInterceptor implements Interceptor {
    final GuestSessionProvider f30717a;

    public GuestAuthInterceptor(GuestSessionProvider guestSessionProvider) {
        this.f30717a = guestSessionProvider;
    }

    public Response intercept(Chain chain) throws IOException {
        GuestAuthToken guestAuthToken;
        Request request = chain.request();
        Session a = this.f30717a.m25836a();
        if (a == null) {
            guestAuthToken = null;
        } else {
            guestAuthToken = (GuestAuthToken) a.f23922a;
        }
        if (guestAuthToken == null) {
            return chain.proceed(request);
        }
        Builder newBuilder = request.newBuilder();
        m31745a(newBuilder, guestAuthToken);
        return chain.proceed(newBuilder.build());
    }

    static void m31745a(Builder builder, GuestAuthToken guestAuthToken) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(guestAuthToken.f30723c);
        stringBuilder.append(" ");
        stringBuilder.append(guestAuthToken.f30724d);
        builder.header(HttpRequest.HEADER_AUTHORIZATION, stringBuilder.toString());
        builder.header("x-guest-token", guestAuthToken.f34639b);
    }
}
