package com.reddit.datalibrary.frontpage.redditauth.redditclient;

import dagger.Lazy;
import dagger.MembersInjector;

public final class RedditClient_MembersInjector implements MembersInjector<RedditClient> {
    public static void m16367a(RedditClient redditClient, Lazy<WebSocketClient> lazy) {
        redditClient.f10881e = lazy;
    }
}
