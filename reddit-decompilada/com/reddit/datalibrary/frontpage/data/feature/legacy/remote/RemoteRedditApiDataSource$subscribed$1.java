package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Subreddit;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$subscribed$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10639a;
    final /* synthetic */ String f10640b;
    final /* synthetic */ String f10641c;

    RemoteRedditApiDataSource$subscribed$1(RedditClient redditClient, String str, String str2) {
        this.f10639a = redditClient;
        this.f10640b = str;
        this.f10641c = str2;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 d = this.f10639a.m9262d(this.f10640b);
        CharSequence charSequence = this.f10641c;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    d.m19780d(this.f10641c);
                }
                return (Listing) d.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            d.m19780d(this.f10641c);
        }
        return (Listing) d.m9334b();
    }
}
