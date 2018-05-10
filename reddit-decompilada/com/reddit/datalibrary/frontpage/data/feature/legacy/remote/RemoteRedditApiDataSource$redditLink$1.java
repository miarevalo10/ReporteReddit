package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v2.RedditLinkImageInfo;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/RedditLinkImageInfo;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$redditLink$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10545a;
    final /* synthetic */ String f10546b;

    RemoteRedditApiDataSource$redditLink$1(RedditClient redditClient, String str) {
        this.f10545a = redditClient;
        this.f10546b = str;
    }

    public final /* synthetic */ Object call() {
        return (RedditLinkImageInfo) this.f10545a.m9242a(this.f10546b).m9334b();
    }
}
