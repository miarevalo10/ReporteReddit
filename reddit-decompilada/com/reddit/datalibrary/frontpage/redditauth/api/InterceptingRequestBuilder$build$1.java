package com.reddit.datalibrary.frontpage.redditauth.api;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request.Priority;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.requests.api.v1.JsonRequest;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0017J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH\u0015J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, d2 = {"com/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder$build$1", "Lcom/reddit/datalibrary/frontpage/requests/api/v1/JsonRequest;", "(Lcom/reddit/datalibrary/frontpage/redditauth/api/InterceptingRequestBuilder;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;ILjava/lang/String;Ljava/lang/reflect/Type;Lcom/google/gson/Gson;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V", "getBody", "", "getBodyContentType", "", "getHeaders", "", "getParams", "getPriority", "Lcom/android/volley/Request$Priority;", "parseNetworkResponse", "Lcom/android/volley/Response;", "response", "Lcom/android/volley/NetworkResponse;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: InterceptingRequestBuilder.kt */
public final class InterceptingRequestBuilder$build$1 extends JsonRequest<T> {
    final /* synthetic */ InterceptingRequestBuilder f18799a;
    final /* synthetic */ Listener f18800b;
    final /* synthetic */ ErrorListener f18801c;

    InterceptingRequestBuilder$build$1(InterceptingRequestBuilder interceptingRequestBuilder, Listener listener, ErrorListener errorListener, int i, String str, Type type, Gson gson, Listener listener2, ErrorListener errorListener2) {
        this.f18799a = interceptingRequestBuilder;
        this.f18800b = listener;
        this.f18801c = errorListener;
        super(i, str, type, gson, listener2, errorListener2);
    }

    public final Priority getPriority() {
        Priority a = this.f18799a.e;
        Intrinsics.a(a, "this@InterceptingRequestBuilder.priority");
        return a;
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> b = this.f18799a.m9337c();
        Intrinsics.a(b, "generateHeaders()");
        return b;
    }

    protected final Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> c = this.f18799a.i;
        Intrinsics.a(c, "this@InterceptingRequestBuilder.formParameters");
        return c;
    }

    public final byte[] getBody() throws AuthFailureError {
        byte[] d = this.f18799a.g;
        if (d != null) {
            return d;
        }
        Object body = super.getBody();
        Intrinsics.a(body, "super.getBody()");
        return body;
    }

    public final String getBodyContentType() {
        String e = this.f18799a.h;
        if (e != null) {
            return e;
        }
        e = super.getBodyContentType();
        Intrinsics.a(e, "super.getBodyContentType()");
        return e;
    }

    protected final Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        Intrinsics.b(networkResponse, "response");
        this.f18799a.f18802l.m9212a(networkResponse);
        Unit unit = Unit.a;
        networkResponse = super.parseNetworkResponse(networkResponse);
        Intrinsics.a(networkResponse, "super.parseNetworkResponse(response)");
        Intrinsics.a(networkResponse, "onInterceptListener.inte…se)\n                    }");
        return networkResponse;
    }
}
