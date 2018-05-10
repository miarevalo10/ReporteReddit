package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MessageListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$messageThread$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10494a;
    final /* synthetic */ String f10495b;

    RemoteRedditApiDataSource$messageThread$1(RedditClient redditClient, String str) {
        this.f10494a = redditClient;
        this.f10495b = str;
    }

    public final /* synthetic */ Object call() {
        return (MessageListing) this.f10494a.m9279k(this.f10495b).m9334b();
    }
}
