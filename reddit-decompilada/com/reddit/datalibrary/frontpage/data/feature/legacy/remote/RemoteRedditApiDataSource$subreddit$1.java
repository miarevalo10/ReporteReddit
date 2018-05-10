package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.commons.Sorting;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$subreddit$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10623a;
    final /* synthetic */ String f10624b;
    final /* synthetic */ String f10625c;
    final /* synthetic */ ListingRequestParams f10626d;
    final /* synthetic */ List f10627e;

    RemoteRedditApiDataSource$subreddit$1(RedditClient redditClient, String str, String str2, ListingRequestParams listingRequestParams, List list) {
        this.f10623a = redditClient;
        this.f10624b = str;
        this.f10625c = str2;
        this.f10626d = listingRequestParams;
        this.f10627e = list;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 a = this.f10623a.m9236a(this.f10624b, this.f10625c);
        CharSequence charSequence = this.f10626d.f10791a;
        Object obj2 = 1;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    a.m19780d(this.f10626d.f10791a);
                }
                charSequence = this.f10626d.f10794d;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    a.m9327a("dist", this.f10626d.f10794d);
                }
                if (this.f10626d.f10792b != -1) {
                    a.m9325a(Sorting.a(this.f10626d.f10792b));
                }
                if (this.f10626d.f10793c != -1) {
                    a.m9327a("t", Sorting.d(this.f10626d.f10793c));
                }
                for (Pair pair : this.f10627e) {
                    a.m9327a((String) pair.a, (String) pair.b);
                }
                a.m9327a("withAds", "true");
                return (Listing) a.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            a.m19780d(this.f10626d.f10791a);
        }
        charSequence = this.f10626d.f10794d;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            a.m9327a("dist", this.f10626d.f10794d);
        }
        if (this.f10626d.f10792b != -1) {
            a.m9325a(Sorting.a(this.f10626d.f10792b));
        }
        if (this.f10626d.f10793c != -1) {
            a.m9327a("t", Sorting.d(this.f10626d.f10793c));
        }
        for (Pair pair2 : this.f10627e) {
            a.m9327a((String) pair2.a, (String) pair2.b);
        }
        a.m9327a("withAds", "true");
        return (Listing) a.m9334b();
    }
}
