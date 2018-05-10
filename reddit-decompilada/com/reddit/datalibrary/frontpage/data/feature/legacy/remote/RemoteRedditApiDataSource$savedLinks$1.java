package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/ThingWrapperListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$savedLinks$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10560a;
    final /* synthetic */ String f10561b;
    final /* synthetic */ String f10562c;
    final /* synthetic */ boolean f10563d;

    RemoteRedditApiDataSource$savedLinks$1(RedditClient redditClient, String str, String str2, boolean z) {
        this.f10560a = redditClient;
        this.f10561b = str;
        this.f10562c = str2;
        this.f10563d = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder m = this.f10560a.m9283m(this.f10561b);
        if (!(this.f10562c == null || this.f10563d)) {
            m.m19782d(this.f10562c);
        }
        return (ThingWrapperListing) m.m9334b();
    }
}
