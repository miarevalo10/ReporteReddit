package com.reddit.datalibrary.frontpage.redditauth.api;

import com.android.volley.RequestQueue;
import dagger.MembersInjector;

public final class RedditAuthClient_MembersInjector implements MembersInjector<RedditAuthClient> {
    public static void m16314a(RedditAuthClient redditAuthClient, RequestQueue requestQueue) {
        redditAuthClient.f10846b = requestQueue;
    }
}
