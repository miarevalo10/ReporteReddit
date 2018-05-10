package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import java.io.IOException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class OAuthService {
    public final TwitterCore f23965b;
    public final TwitterApi f23966c;
    final String f23967d;
    final Retrofit f23968e;

    class C25261 implements Interceptor {
        final /* synthetic */ OAuthService f30725a;

        C25261(OAuthService oAuthService) {
            this.f30725a = oAuthService;
        }

        public Response intercept(Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("User-Agent", this.f30725a.f23967d).build());
        }
    }

    OAuthService(TwitterCore twitterCore, SSLSocketFactory sSLSocketFactory, TwitterApi twitterApi) {
        this.f23965b = twitterCore;
        this.f23966c = twitterApi;
        this.f23967d = TwitterApi.buildUserAgent("TwitterAndroidSDK", twitterCore.getVersion());
        if (sSLSocketFactory == null) {
            throw new IllegalArgumentException("sslSocketFactory must not be null");
        }
        this.f23968e = new Builder().a(this.f23966c.getBaseHostUrl()).a(new OkHttpClient.Builder().sslSocketFactory(sSLSocketFactory).addInterceptor(new C25261(this)).build()).a(GsonConverterFactory.a()).a();
    }
}
