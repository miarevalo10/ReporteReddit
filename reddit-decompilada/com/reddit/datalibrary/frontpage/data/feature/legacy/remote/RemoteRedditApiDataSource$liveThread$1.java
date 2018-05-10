package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LiveThread;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$liveThread$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10483a;
    final /* synthetic */ String f10484b;

    RemoteRedditApiDataSource$liveThread$1(RedditClient redditClient, String str) {
        this.f10483a = redditClient;
        this.f10484b = str;
    }

    public final /* synthetic */ Object call() {
        return (LiveThread) this.f10483a.m9275i(this.f10484b).m9334b();
    }
}
