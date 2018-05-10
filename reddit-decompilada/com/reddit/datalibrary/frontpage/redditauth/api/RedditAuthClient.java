package com.reddit.datalibrary.frontpage.redditauth.api;

import com.android.volley.RequestQueue;
import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.redditauth.models.LoginResponse;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.frontpage.FrontpageApplication;
import javax.inject.Inject;
import javax.inject.Named;

public class RedditAuthClient {
    public final Cannon f10845a;
    @Inject
    @Named("no_redirects")
    RequestQueue f10846b;

    public RedditAuthClient() {
        FrontpageApplication.f().a(this);
        Builder builder = new Builder(Config.f10813a);
        builder.f10888a = Config.f10814b;
        builder.f10892e = this.f10846b;
        this.f10845a = builder.m9314a();
    }

    public static void m9213a(RequestBuilder<LoginResponse> requestBuilder, String str, String str2) {
        requestBuilder.m9322a(1).m9325a("api/v1/login").m9333b("user", str).m9333b("passwd", str2).m9333b("api_type", "json").m9333b("rem", "true");
    }
}
