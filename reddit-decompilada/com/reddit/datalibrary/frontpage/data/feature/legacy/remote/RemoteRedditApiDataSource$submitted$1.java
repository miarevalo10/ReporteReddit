package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.commons.Sorting;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$submitted$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10620a;
    final /* synthetic */ String f10621b;
    final /* synthetic */ ListingRequestParams f10622c;

    RemoteRedditApiDataSource$submitted$1(RedditClient redditClient, String str, ListingRequestParams listingRequestParams) {
        this.f10620a = redditClient;
        this.f10621b = str;
        this.f10622c = listingRequestParams;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 o = this.f10620a.m9285o(this.f10621b);
        CharSequence charSequence = this.f10622c.f10791a;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    o.m19780d(this.f10622c.f10791a);
                }
                if (this.f10622c.f10792b != -1) {
                    o.m9327a("sort", Sorting.a(this.f10622c.f10792b));
                }
                if (this.f10622c.f10793c != -1) {
                    o.m9327a("t", Sorting.d(this.f10622c.f10793c));
                }
                return (Listing) o.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            o.m19780d(this.f10622c.f10791a);
        }
        if (this.f10622c.f10792b != -1) {
            o.m9327a("sort", Sorting.a(this.f10622c.f10792b));
        }
        if (this.f10622c.f10793c != -1) {
            o.m9327a("t", Sorting.d(this.f10622c.f10793c));
        }
        return (Listing) o.m9334b();
    }
}
