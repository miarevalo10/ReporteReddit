package com.reddit.datalibrary.frontpage.redditauth.api;

import com.android.volley.NetworkResponse;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.JsonRequest;
import com.reddit.frontpage.util.Util;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0010B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder;", "T", "Lcom/reddit/datalibrary/frontpage/redditauth/api/SignedRequestBuilder;", "cannon", "Lcom/reddit/datalibrary/frontpage/requests/api/v1/Cannon;", "type", "Ljava/lang/reflect/Type;", "onInterceptListener", "Lcom/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder$OnInterceptListener;", "(Lcom/reddit/datalibrary/frontpage/requests/api/v1/Cannon;Ljava/lang/reflect/Type;Lcom/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder$OnInterceptListener;)V", "build", "Lcom/reddit/datalibrary/frontpage/requests/api/v1/JsonRequest;", "listener", "Lcom/android/volley/Response$Listener;", "errorListener", "Lcom/android/volley/Response$ErrorListener;", "OnInterceptListener", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InterceptingRequestBuilder.kt */
public final class InterceptingRequestBuilder<T> extends SignedRequestBuilder<T> {
    private final OnInterceptListener f18802l;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder$OnInterceptListener;", "", "interceptResponse", "", "response", "Lcom/android/volley/NetworkResponse;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: InterceptingRequestBuilder.kt */
    public interface OnInterceptListener {
        void m9212a(NetworkResponse networkResponse);
    }

    public InterceptingRequestBuilder(Cannon cannon, Type type, OnInterceptListener onInterceptListener) {
        Intrinsics.b(cannon, "cannon");
        Intrinsics.b(type, "type");
        Intrinsics.b(onInterceptListener, "onInterceptListener");
        super(cannon, type);
        this.f18802l = onInterceptListener;
    }

    public final JsonRequest<T> mo3808a(Listener<T> listener, ErrorListener errorListener) {
        Intrinsics.b(listener, "listener");
        mo3033a();
        InterceptingRequestBuilder$build$1 interceptingRequestBuilder$build$1 = new InterceptingRequestBuilder$build$1(this, listener, errorListener, this.d, this.c.build().toString(), this.a, this.b, listener, errorListener);
        interceptingRequestBuilder$build$1.setShouldCache(null);
        Util.c("NETWORK_REQUEST", interceptingRequestBuilder$build$1.toString());
        return interceptingRequestBuilder$build$1;
    }
}
