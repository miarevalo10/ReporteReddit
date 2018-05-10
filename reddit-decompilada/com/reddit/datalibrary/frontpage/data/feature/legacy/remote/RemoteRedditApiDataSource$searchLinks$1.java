package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/LinkListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$searchLinks$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10564a;
    final /* synthetic */ String f10565b;
    final /* synthetic */ String f10566c;
    final /* synthetic */ String f10567d;
    final /* synthetic */ String f10568e;

    RemoteRedditApiDataSource$searchLinks$1(RedditClient redditClient, String str, String str2, String str3, String str4) {
        this.f10564a = redditClient;
        this.f10565b = str;
        this.f10566c = str2;
        this.f10567d = str3;
        this.f10568e = str4;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder u = this.f10564a.m9291u(this.f10565b);
        String str = this.f10566c;
        if (str != null) {
            u.m9327a("sort", str);
        }
        str = this.f10567d;
        if (str != null) {
            u.m9327a("t", str);
        }
        str = this.f10568e;
        if (str != null) {
            u.m19782d(str);
        }
        return (LinkListing) u.m9334b();
    }
}
