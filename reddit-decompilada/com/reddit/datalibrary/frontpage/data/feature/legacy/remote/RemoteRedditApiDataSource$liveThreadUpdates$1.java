package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/LiveUpdate;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$liveThreadUpdates$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10485a;
    final /* synthetic */ String f10486b;
    final /* synthetic */ String f10487c;

    RemoteRedditApiDataSource$liveThreadUpdates$1(RedditClient redditClient, String str, String str2) {
        this.f10485a = redditClient;
        this.f10486b = str;
        this.f10487c = str2;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        RequestBuilder h = this.f10485a.m9273h(this.f10486b);
        CharSequence charSequence = this.f10487c;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    h.m9327a("after", this.f10487c);
                }
                return (Listing) h.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            h.m9327a("after", this.f10487c);
        }
        return (Listing) h.m9334b();
    }
}
