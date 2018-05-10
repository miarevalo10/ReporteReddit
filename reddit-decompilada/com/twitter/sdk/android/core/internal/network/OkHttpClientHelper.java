package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class OkHttpClientHelper {
    public static OkHttpClient m25870a(GuestSessionProvider guestSessionProvider, SSLSocketFactory sSLSocketFactory) {
        return new Builder().sslSocketFactory(sSLSocketFactory).authenticator(new GuestAuthenticator(guestSessionProvider)).addInterceptor(new GuestAuthInterceptor(guestSessionProvider)).addNetworkInterceptor(new GuestAuthNetworkInterceptor()).build();
    }

    public static OkHttpClient m25871a(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig, SSLSocketFactory sSLSocketFactory) {
        if (session != null) {
            return new Builder().sslSocketFactory(sSLSocketFactory).addInterceptor(new OAuth1aInterceptor(session, twitterAuthConfig)).build();
        }
        throw new IllegalArgumentException("Session must not be null.");
    }
}
