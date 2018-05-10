package com.reddit.datalibrary.frontpage.data.common.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/ApiParametersInterceptor;", "Lokhttp3/Interceptor;", "()V", "RAW_JSON_PARAM_NAME", "", "RAW_JSON_PARAM_VALUE", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApiParametersInterceptor.kt */
public final class ApiParametersInterceptor implements Interceptor {
    public static final ApiParametersInterceptor f15730a = new ApiParametersInterceptor();

    private ApiParametersInterceptor() {
    }

    public final Response intercept(Chain chain) {
        Intrinsics.b(chain, "chain");
        Request request = chain.request();
        chain = chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter("raw_json", "1").build()).build());
        Intrinsics.a(chain, "chain.proceed(requestBuilder.build())");
        return chain;
    }
}
