package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LinkFlair;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$flair$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10453a;
    final /* synthetic */ String f10454b;

    RemoteRedditApiDataSource$flair$1(RedditClient redditClient, String str) {
        this.f10453a = redditClient;
        this.f10454b = str;
    }

    public final /* synthetic */ Object call() {
        return (List) this.f10453a.m9232I(this.f10454b).m9334b();
    }
}
