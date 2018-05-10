package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ThingWrapperListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$savedComments$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10556a;
    final /* synthetic */ String f10557b;
    final /* synthetic */ String f10558c;
    final /* synthetic */ boolean f10559d;

    RemoteRedditApiDataSource$savedComments$1(RedditClient redditClient, String str, String str2, boolean z) {
        this.f10556a = redditClient;
        this.f10557b = str;
        this.f10558c = str2;
        this.f10559d = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder n = this.f10556a.m9284n(this.f10557b);
        if (!(this.f10558c == null || this.f10559d)) {
            n.m19782d(this.f10558c);
        }
        return (ThingWrapperListing) n.m9334b();
    }
}
