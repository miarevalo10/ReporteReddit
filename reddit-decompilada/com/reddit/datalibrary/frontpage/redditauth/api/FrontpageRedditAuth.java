package com.reddit.datalibrary.frontpage.redditauth.api;

import com.reddit.datalibrary.frontpage.redditauth.Config;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon;
import com.reddit.datalibrary.frontpage.requests.api.v1.Cannon.Builder;

public class FrontpageRedditAuth {
    public final Cannon f10844a;

    public FrontpageRedditAuth() {
        Builder builder = new Builder(Config.f10813a);
        builder.f10888a = Config.f10814b;
        this.f10844a = builder.m9314a();
    }
}
