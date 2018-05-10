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
final class RemoteRedditApiDataSource$frontpage$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10455a;
    final /* synthetic */ String f10456b;
    final /* synthetic */ ListingRequestParams f10457c;
    final /* synthetic */ List f10458d;

    RemoteRedditApiDataSource$frontpage$1(RedditClient redditClient, String str, ListingRequestParams listingRequestParams, List list) {
        this.f10455a = redditClient;
        this.f10456b = str;
        this.f10457c = listingRequestParams;
        this.f10458d = list;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 b = this.f10455a.m9249b(this.f10456b);
        CharSequence charSequence = this.f10457c.f10791a;
        Object obj2 = 1;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    b.m19780d(this.f10457c.f10791a);
                }
                charSequence = this.f10457c.f10794d;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    b.m9327a("dist", this.f10457c.f10794d);
                }
                if (this.f10457c.f10792b != -1) {
                    b.m9327a("sort", Sorting.a(this.f10457c.f10792b));
                }
                if (this.f10457c.f10793c != -1) {
                    b.m9327a("t", Sorting.d(this.f10457c.f10793c));
                }
                b.m9327a("withAds", "true");
                for (Pair pair : this.f10458d) {
                    b.m9327a((String) pair.a, (String) pair.b);
                }
                return (Listing) b.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            b.m19780d(this.f10457c.f10791a);
        }
        charSequence = this.f10457c.f10794d;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            b.m9327a("dist", this.f10457c.f10794d);
        }
        if (this.f10457c.f10792b != -1) {
            b.m9327a("sort", Sorting.a(this.f10457c.f10792b));
        }
        if (this.f10457c.f10793c != -1) {
            b.m9327a("t", Sorting.d(this.f10457c.f10793c));
        }
        b.m9327a("withAds", "true");
        for (Pair pair2 : this.f10458d) {
            b.m9327a((String) pair2.a, (String) pair2.b);
        }
        return (Listing) b.m9334b();
    }
}
