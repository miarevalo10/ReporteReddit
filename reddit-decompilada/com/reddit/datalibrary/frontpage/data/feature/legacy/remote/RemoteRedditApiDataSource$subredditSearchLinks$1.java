package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/LinkListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$subredditSearchLinks$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10632a;
    final /* synthetic */ String f10633b;
    final /* synthetic */ String f10634c;
    final /* synthetic */ String f10635d;
    final /* synthetic */ String f10636e;
    final /* synthetic */ String f10637f;
    final /* synthetic */ String f10638g;

    RemoteRedditApiDataSource$subredditSearchLinks$1(RedditClient redditClient, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f10632a = redditClient;
        this.f10633b = str;
        this.f10634c = str2;
        this.f10635d = str3;
        this.f10636e = str4;
        this.f10637f = str5;
        this.f10638g = str6;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder b = this.f10632a.m9251b(this.f10633b, this.f10634c, this.f10635d);
        String str = this.f10636e;
        if (str != null) {
            b.m9327a("sort", str);
        }
        str = this.f10637f;
        if (str != null) {
            b.m9327a("t", str);
        }
        str = this.f10638g;
        if (str != null) {
            b.m19782d(str);
        }
        return (LinkListing) b.m9334b();
    }
}
