package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.frontpage.commons.Sorting;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$link$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10476a;
    final /* synthetic */ String f10477b;
    final /* synthetic */ String f10478c;
    final /* synthetic */ int f10479d;
    final /* synthetic */ boolean f10480e;
    final /* synthetic */ String f10481f;
    final /* synthetic */ String f10482g;

    RemoteRedditApiDataSource$link$1(RedditClient redditClient, String str, String str2, int i, boolean z, String str3, String str4) {
        this.f10476a = redditClient;
        this.f10477b = str;
        this.f10478c = str2;
        this.f10479d = i;
        this.f10480e = z;
        this.f10481f = str3;
        this.f10482g = str4;
    }

    public final /* synthetic */ Object call() {
        RedditRequestBuilder d = this.f10476a.m9264d(this.f10477b, this.f10478c);
        if (this.f10479d >= 0) {
            d.m9327a("sort", Sorting.a(this.f10479d));
        }
        if (this.f10480e) {
            d.m9327a("limit", Integer.toString(8));
        }
        String str = this.f10481f;
        if (str != null) {
            d.m9325a("xxx").m9325a(str);
        }
        str = this.f10482g;
        if (str != null) {
            d.m9327a("context", str);
        }
        return (CommentResponse) d.m9334b();
    }
}
