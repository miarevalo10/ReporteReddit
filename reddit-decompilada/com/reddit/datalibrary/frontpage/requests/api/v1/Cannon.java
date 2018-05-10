package com.reddit.datalibrary.frontpage.requests.api.v1;

import android.net.Uri;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.google.gson.Gson;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.NoTimeoutRetryPolicy;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RequestTagger;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RetryPolicyFactory;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.JsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;

public class Cannon {
    final Uri f10896a;
    final ArrayList<Dynamic> f10897b;
    @Inject
    @Named("no_body_logging")
    public RequestQueue f10898c;
    private final String f10899d;
    private final RetryPolicyFactory f10900e;
    private final ArrayList<Transformer> f10901f;
    private final RequestTagger f10902g;
    private final Gson f10903h;

    public static class Builder {
        public String f10888a;
        public RetryPolicyFactory f10889b;
        public Gson f10890c = JsonUtil.a();
        public RequestTagger f10891d;
        public RequestQueue f10892e;
        private final Uri f10893f;
        private final ArrayList<Transformer> f10894g = new ArrayList();
        private final ArrayList<Dynamic> f10895h = new ArrayList();

        public Builder(Uri uri) {
            this.f10893f = uri;
        }

        public final Builder m9313a(Transformer transformer) {
            this.f10894g.add(transformer);
            return this;
        }

        public final Builder m9312a(Dynamic dynamic) {
            this.f10895h.add(dynamic);
            return this;
        }

        public final Cannon m9314a() {
            return new Cannon(this);
        }
    }

    public Cannon(Builder builder) {
        this.f10899d = builder.f10888a;
        this.f10896a = builder.f10893f;
        this.f10900e = builder.f10889b;
        this.f10901f = builder.f10894g;
        this.f10897b = builder.f10895h;
        this.f10902g = builder.f10891d;
        this.f10903h = builder.f10890c;
        this.f10898c = builder.f10892e;
        if (this.f10898c == null) {
            FrontpageApplication.f().a(this);
        }
    }

    public final void m9315a(RequestBuilder requestBuilder, Listener listener, ErrorListener errorListener) {
        requestBuilder.m9324a(this.f10903h);
        Iterator it = this.f10901f.iterator();
        while (it.hasNext()) {
            requestBuilder = ((Transformer) it.next()).mo3042a(requestBuilder);
        }
        listener = requestBuilder.m9336c("User-Agent", this.f10899d).m9336c("X-Dev-Ad-Id", Config.m9162f()).mo3808a(listener, errorListener);
        if (this.f10900e != null) {
            listener.setRetryPolicy(this.f10900e.mo3039a());
        }
        if (requestBuilder.f10910f == null) {
            listener.setRetryPolicy(NoTimeoutRetryPolicy.m16319a(listener.getRetryPolicy()));
        }
        if (this.f10902g != null) {
            this.f10902g.mo3038a(listener);
        }
        this.f10898c.mo3040a(listener);
    }
}
