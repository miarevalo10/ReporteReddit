package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.common.interceptor.ApiParametersInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.LegacyQueryParametersInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.OAuthInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.RedditHeaderInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.StagingCookieInterceptor;
import com.reddit.datalibrary.frontpage.data.common.interceptor.TokenValidityInterceptor;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.util.InstabugUtil;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public final class NetworkModule_OauthHttpClientFactory implements Factory<OkHttpClient> {
    private final NetworkModule f33615a;

    private NetworkModule_OauthHttpClientFactory(NetworkModule networkModule) {
        this.f33615a = networkModule;
    }

    public static NetworkModule_OauthHttpClientFactory m34508a(NetworkModule networkModule) {
        return new NetworkModule_OauthHttpClientFactory(networkModule);
    }

    public final /* synthetic */ Object get() {
        Builder builder = new Builder();
        if (FrontpageSettings.a().k()) {
            NetworkModule$disableSslValidation$trustAllCerts$1[] networkModule$disableSslValidation$trustAllCerts$1Arr = new NetworkModule$disableSslValidation$trustAllCerts$1[]{new NetworkModule$disableSslValidation$trustAllCerts$1()};
            Object instance = SSLContext.getInstance("SSL");
            instance.init(null, (TrustManager[]) networkModule$disableSslValidation$trustAllCerts$1Arr, new SecureRandom());
            Intrinsics.m26843a(instance, "sslContext");
            instance.getSocketFactory();
            builder.sslSocketFactory(instance.getSocketFactory(), networkModule$disableSslValidation$trustAllCerts$1Arr[0]);
            builder.hostnameVerifier(NetworkModule$disableSslValidation$1.f20248a);
            builder.addNetworkInterceptor(new StagingCookieInterceptor());
        }
        builder.addNetworkInterceptor(InstabugUtil.f21744a);
        builder.addNetworkInterceptor(new LegacyQueryParametersInterceptor());
        builder.addInterceptor(new OAuthInterceptor());
        builder.addInterceptor(new RedditHeaderInterceptor());
        builder.addInterceptor(new TokenValidityInterceptor());
        builder.addInterceptor(ApiParametersInterceptor.a);
        Object build = builder.build();
        Intrinsics.m26843a(build, "OkHttpClient.Builder().a…ceptor)\n        }.build()");
        return (OkHttpClient) Preconditions.m26013a(build, "Cannot return null from a non-@Nullable @Provides method");
    }
}
