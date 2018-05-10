package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.SearchResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SearchResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$combinedSearch$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10423a;
    final /* synthetic */ String f10424b;
    final /* synthetic */ String f10425c;
    final /* synthetic */ String f10426d;

    RemoteRedditApiDataSource$combinedSearch$1(RedditClient redditClient, String str, String str2, String str3) {
        this.f10423a = redditClient;
        this.f10424b = str;
        this.f10425c = str2;
        this.f10426d = str3;
    }

    public final /* synthetic */ Object call() {
        RedditRequestBuilder s = this.f10423a.m9289s(this.f10424b);
        String str = this.f10425c;
        if (str != null) {
            s.m9327a("sort", str);
        }
        str = this.f10426d;
        if (str != null) {
            s.m9327a("t", str);
        }
        return (SearchResponse) s.m9334b();
    }
}
