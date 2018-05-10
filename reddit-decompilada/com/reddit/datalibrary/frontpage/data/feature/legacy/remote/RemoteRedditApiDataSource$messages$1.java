package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.EmptyMessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MessageListing;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$messages$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10496a;
    final /* synthetic */ String f10497b;
    final /* synthetic */ String f10498c;
    final /* synthetic */ boolean f10499d;

    RemoteRedditApiDataSource$messages$1(RedditClient redditClient, String str, String str2, boolean z) {
        this.f10496a = redditClient;
        this.f10497b = str;
        this.f10498c = str2;
        this.f10499d = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder j = this.f10496a.m9277j(this.f10497b);
        if (!(this.f10498c == null || this.f10499d)) {
            j.m19782d(this.f10498c);
        }
        MessageListing messageListing = (MessageListing) j.m9334b();
        return messageListing == null ? new EmptyMessageListing() : messageListing;
    }
}
