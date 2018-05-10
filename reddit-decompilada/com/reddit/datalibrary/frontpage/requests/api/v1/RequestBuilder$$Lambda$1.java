package com.reddit.datalibrary.frontpage.requests.api.v1;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder.Callbacks;

final /* synthetic */ class RequestBuilder$$Lambda$1 implements ErrorListener {
    private final Callbacks f16332a;

    RequestBuilder$$Lambda$1(Callbacks callbacks) {
        this.f16332a = callbacks;
    }

    public final void mo793a(VolleyError volleyError) {
        RequestBuilder.m9319a(this.f16332a, volleyError);
    }
}
