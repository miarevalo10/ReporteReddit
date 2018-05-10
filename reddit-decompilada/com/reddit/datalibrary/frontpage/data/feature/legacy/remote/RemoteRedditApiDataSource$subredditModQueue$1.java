package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$subredditModQueue$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10628a;
    final /* synthetic */ String f10629b;
    final /* synthetic */ String f10630c;
    final /* synthetic */ List f10631d;

    RemoteRedditApiDataSource$subredditModQueue$1(RedditClient redditClient, String str, String str2, List list) {
        this.f10628a = redditClient;
        this.f10629b = str;
        this.f10630c = str2;
        this.f10631d = list;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 c = this.f10628a.m9256c(this.f10629b);
        CharSequence charSequence = this.f10630c;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    c.m19780d(this.f10630c);
                }
                for (Pair pair : this.f10631d) {
                    c.m9327a((String) pair.a, (String) pair.b);
                }
                return (Listing) c.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            c.m19780d(this.f10630c);
        }
        for (Pair pair2 : this.f10631d) {
            c.m9327a((String) pair2.a, (String) pair2.b);
        }
        return (Listing) c.m9334b();
    }
}
