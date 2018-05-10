package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubredditListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$searchSubreddits$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10571a;
    final /* synthetic */ String f10572b;
    final /* synthetic */ String f10573c;
    final /* synthetic */ String f10574d;
    final /* synthetic */ boolean f10575e;

    RemoteRedditApiDataSource$searchSubreddits$1(RedditClient redditClient, String str, String str2, String str3, boolean z) {
        this.f10571a = redditClient;
        this.f10572b = str;
        this.f10573c = str2;
        this.f10574d = str3;
        this.f10575e = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder f = this.f10571a.m9270f(this.f10572b, this.f10573c);
        if (!(this.f10574d == null || this.f10575e)) {
            f.m19782d(this.f10574d);
        }
        return (SubredditListing) f.m9334b();
    }
}
