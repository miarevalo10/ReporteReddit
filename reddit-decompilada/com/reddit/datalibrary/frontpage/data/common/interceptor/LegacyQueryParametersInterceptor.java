package com.reddit.datalibrary.frontpage.data.common.interceptor;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/LegacyQueryParametersInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LegacyQueryParametersInterceptor.kt */
public final class LegacyQueryParametersInterceptor implements Interceptor {
    public final Response intercept(Chain chain) {
        Intrinsics.b(chain, "chain");
        Builder newBuilder = chain.request().url().newBuilder();
        newBuilder.addQueryParameter("feature", "link_preview").addQueryParameter("obey_over18", "true").addQueryParameter("sr_detail", "true").addQueryParameter("expand_srs", "true").addQueryParameter("from_detail", "true").addQueryParameter("api_type", "json").addQueryParameter("raw_json", "1").addQueryParameter("always_show_media", FrontpageSettings.m9011a().m9027b() ? "0" : "1");
        chain = chain.proceed(chain.request().newBuilder().url(newBuilder.build()).build());
        Intrinsics.a(chain, "chain.proceed(newRequest)");
        return chain;
    }
}
