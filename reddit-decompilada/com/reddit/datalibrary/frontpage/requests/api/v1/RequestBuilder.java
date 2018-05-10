package com.reddit.datalibrary.frontpage.requests.api.v1;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request.Priority;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.frontpage.commons.analytics.TrackingRouter;
import com.reddit.frontpage.util.Util;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class RequestBuilder<T> {
    protected final Type f10905a;
    protected Gson f10906b;
    protected Builder f10907c;
    protected int f10908d = 0;
    protected Priority f10909e = Priority.NORMAL;
    boolean f10910f = false;
    protected byte[] f10911g;
    protected String f10912h;
    protected Map<String, String> f10913i = new HashMap();
    protected Map<String, String> f10914j = new HashMap();
    protected String f10915k;
    private final Cannon f10916l;

    public interface Callbacks<T> {
        void mo3015a(VolleyError volleyError);

        void mo3016a(T t);
    }

    public void mo3033a() {
    }

    public RequestBuilder(Cannon cannon, Type type) {
        this.f10916l = cannon;
        this.f10905a = type;
        this.f10907c = cannon.f10896a.buildUpon();
    }

    public final RequestBuilder m9322a(int i) {
        this.f10908d = i;
        return this;
    }

    public final RequestBuilder m9323a(Priority priority) {
        this.f10909e = priority;
        return this;
    }

    public final RequestBuilder m9325a(String str) {
        this.f10907c = this.f10907c.appendEncodedPath(str);
        return this;
    }

    public final RequestBuilder m9327a(String str, String str2) {
        this.f10907c.appendQueryParameter(str, str2);
        return this;
    }

    public final RequestBuilder m9333b(String str, String str2) {
        this.f10913i.put(str, str2);
        return this;
    }

    public final RequestBuilder m9326a(String str, long j) {
        this.f10913i.put(str, Long.toString(j));
        return this;
    }

    public final RequestBuilder m9328a(String str, boolean z) {
        this.f10913i.put(str, Boolean.toString(z));
        return this;
    }

    public final RequestBuilder m9336c(String str, String str2) {
        this.f10914j.put(str, str2);
        return this;
    }

    public final RequestBuilder m9329a(byte[] bArr) {
        this.f10911g = bArr;
        return this;
    }

    public final RequestBuilder m9332b(String str) {
        this.f10912h = str;
        return this;
    }

    public final RequestBuilder m9335c(String str) {
        this.f10915k = str;
        return this;
    }

    public final RequestBuilder m9324a(Gson gson) {
        this.f10906b = gson;
        return this;
    }

    public final T m9334b() throws ExecutionException, InterruptedException {
        RequestFuture a = RequestFuture.m10986a();
        this.f10916l.m9315a(this, a, a);
        return a.get();
    }

    public final void m9331a(Callbacks<T> callbacks) {
        this.f10916l.m9315a(this, new RequestBuilder$$Lambda$0(callbacks), new RequestBuilder$$Lambda$1(callbacks));
    }

    static final /* synthetic */ void m9319a(Callbacks callbacks, VolleyError volleyError) {
        callbacks.mo3015a(volleyError);
        Util.c("NETWORK_RESPONSE", volleyError.toString());
    }

    public JsonRequest<T> mo3808a(Listener<T> listener, ErrorListener errorListener) {
        mo3033a();
        JsonRequest<T> c17031 = new JsonRequest<T>(this, this.f10908d, this.f10907c.build().toString(), this.f10905a, this.f10906b, listener, errorListener) {
            final /* synthetic */ RequestBuilder f18803a;

            public Priority getPriority() {
                return this.f18803a.f10909e;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                return this.f18803a.m9337c();
            }

            protected Map<String, String> getParams() throws AuthFailureError {
                return this.f18803a.f10913i;
            }

            public String getBodyContentType() {
                if (this.f18803a.f10912h != null) {
                    return this.f18803a.f10912h;
                }
                return super.getBodyContentType();
            }

            protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
                TrackingRouter.a(this.f18803a.f10915k, this.f18803a.f10905a);
                return super.parseNetworkResponse(networkResponse);
            }

            public byte[] getBody() throws AuthFailureError {
                if (this.f18803a.f10911g != null) {
                    return this.f18803a.f10911g;
                }
                return super.getBody();
            }
        };
        c17031.setShouldCache(null);
        Util.c("NETWORK_REQUEST", c17031.toString());
        return c17031;
    }

    protected final Map<String, String> m9337c() {
        Map<String, String> hashMap = new HashMap((this.f10914j.size() + this.f10916l.f10897b.size()) + 1);
        hashMap.putAll(this.f10914j);
        Iterator it = this.f10916l.f10897b.iterator();
        while (it.hasNext()) {
            ((Dynamic) it.next()).mo3034a(hashMap);
        }
        hashMap.put("Client-Vendor-ID", Config.f10819g);
        hashMap.put("x-reddit-device-id", Config.f10819g);
        if (!TextUtils.isEmpty(Config.f10818f)) {
            hashMap.put("x-reddit-session", Config.f10818f);
        }
        if (!TextUtils.isEmpty(Config.f10820h)) {
            hashMap.put("x-reddit-loid", Config.f10820h);
        }
        if (!TextUtils.isEmpty(Config.f10822j)) {
            hashMap.put("x-reddaid", Config.f10822j);
        }
        return hashMap;
    }
}
