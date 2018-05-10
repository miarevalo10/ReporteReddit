package com.reddit.config;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

public final class RedditGlideModule_MembersInjector implements MembersInjector<RedditGlideModule> {
    public static void m15800a(RedditGlideModule redditGlideModule, OkHttpClient okHttpClient) {
        redditGlideModule.f19335a = okHttpClient;
    }
}
