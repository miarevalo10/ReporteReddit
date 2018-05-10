package com.reddit.datalibrary.frontpage.data.common.interceptor;

import com.reddit.frontpage.FrontpageApplication;
import java.io.File;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/StagingCookieInterceptor;", "Lokhttp3/Interceptor;", "()V", "cookie", "", "getCookie", "()Ljava/lang/String;", "cookie$delegate", "Lkotlin/Lazy;", "cookieFile", "Ljava/io/File;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "loadCookie", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: StagingCookieInterceptor.kt */
public final class StagingCookieInterceptor implements Interceptor {
    static final /* synthetic */ KProperty[] f15740a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(StagingCookieInterceptor.class), "cookie", "getCookie()Ljava/lang/String;"))};
    public static final Companion f15741b = new Companion();
    private final Lazy f15742c = LazyKt.a(new StagingCookieInterceptor$cookie$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/interceptor/StagingCookieInterceptor$Companion;", "", "()V", "COOKIE_FILE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: StagingCookieInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    private final String m15826b() {
        return (String) this.f15742c.b();
    }

    public final Response intercept(Chain chain) {
        Intrinsics.b(chain, "chain");
        Request request = chain.request();
        if ((StringsKt.a(m15826b()) ^ 1) != 0) {
            request = request.newBuilder().addHeader("Cookie", m15826b()).build();
        } else {
            StringBuilder stringBuilder = new StringBuilder("Cookie not found in ");
            stringBuilder.append(m15828d().getAbsolutePath());
            Timber.d(stringBuilder.toString(), new Object[0]);
        }
        chain = chain.proceed(request);
        Intrinsics.a(chain, "chain.proceed(request)");
        return chain;
    }

    private static String m15827c() {
        try {
            return FilesKt.b(m15828d());
        } catch (IOException e) {
            Timber.c(e, "Failed to read cookie", new Object[0]);
            return "";
        }
    }

    private static File m15828d() {
        FrontpageApplication frontpageApplication = FrontpageApplication.a;
        Intrinsics.a(frontpageApplication, "FrontpageApplication.instance");
        return new File(frontpageApplication.getApplicationContext().getExternalFilesDir(null), "staging_cookie.txt");
    }
}
