package com.reddit.datalibrary.frontpage.data.common.interceptor;

import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import io.fabric.sdk.android.services.network.HttpRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/TokenValidityInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TokenValidityInterceptor.kt */
public final class TokenValidityInterceptor implements Interceptor {
    public final Response intercept(Chain chain) {
        Request build;
        Intrinsics.b(chain, "chain");
        SessionManager b = SessionManager.m9191b();
        Intrinsics.a(b, "SessionManager.getInstance()");
        Session c = b.m9203c();
        if (c != null ? c.m16313d() : true) {
            SessionManager.m9191b().m9206e();
            Builder removeHeader = chain.request().newBuilder().removeHeader(HttpRequest.HEADER_AUTHORIZATION);
            String str = HttpRequest.HEADER_AUTHORIZATION;
            StringBuilder stringBuilder = new StringBuilder("Bearer ");
            SessionManager b2 = SessionManager.m9191b();
            Intrinsics.a(b2, "SessionManager.getInstance()");
            Session c2 = b2.m9203c();
            Intrinsics.a(c2, "SessionManager.getInstance().activeSession");
            stringBuilder.append(c2.m16311b());
            build = removeHeader.addHeader(str, stringBuilder.toString()).build();
        } else {
            build = chain.request();
        }
        chain = chain.proceed(build);
        Intrinsics.a(chain, "chain.proceed(request)");
        return chain;
    }
}
