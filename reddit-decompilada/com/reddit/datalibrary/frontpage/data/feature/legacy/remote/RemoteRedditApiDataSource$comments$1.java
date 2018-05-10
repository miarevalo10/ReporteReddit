package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentListing;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$comments$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10430a;
    final /* synthetic */ String f10431b;
    final /* synthetic */ String f10432c;
    final /* synthetic */ String f10433d;
    final /* synthetic */ boolean f10434e;

    RemoteRedditApiDataSource$comments$1(RedditClient redditClient, String str, String str2, String str3, boolean z) {
        this.f10430a = redditClient;
        this.f10431b = str;
        this.f10432c = str2;
        this.f10433d = str3;
        this.f10434e = z;
    }

    public final /* synthetic */ Object call() {
        ListingRequestBuilder e = this.f10430a.m9268e(this.f10431b, this.f10432c);
        if (!(this.f10433d == null || this.f10434e)) {
            e.m19782d(this.f10433d);
        }
        return (CommentListing) e.m9334b();
    }
}
