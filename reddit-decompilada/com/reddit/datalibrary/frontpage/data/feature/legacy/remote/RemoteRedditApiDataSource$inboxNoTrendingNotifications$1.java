package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.EmptyMessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MessageListing;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$inboxNoTrendingNotifications$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10473a;
    final /* synthetic */ String f10474b;
    final /* synthetic */ boolean f10475c;

    RemoteRedditApiDataSource$inboxNoTrendingNotifications$1(RedditClient redditClient, String str, boolean z) {
        this.f10473a = redditClient;
        this.f10474b = str;
        this.f10475c = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder a = this.f10473a.m9237a();
        if (!(this.f10474b == null || this.f10475c)) {
            a.m19782d(this.f10474b);
        }
        MessageListing messageListing = (MessageListing) a.m9334b();
        return messageListing == null ? new EmptyMessageListing() : messageListing;
    }
}
