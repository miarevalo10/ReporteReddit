package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$registerPushToken$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10547a;
    final /* synthetic */ String f10548b;

    RemoteRedditApiDataSource$registerPushToken$1(RedditClient redditClient, String str) {
        this.f10547a = redditClient;
        this.f10548b = str;
    }

    public final Object call() {
        return this.f10547a.m9231H(this.f10548b).m9334b();
    }
}
