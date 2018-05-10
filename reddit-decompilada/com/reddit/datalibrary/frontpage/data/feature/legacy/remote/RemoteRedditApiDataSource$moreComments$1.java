package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreCommentResponse;
import com.reddit.frontpage.commons.Sorting;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MoreCommentResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$moreComments$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10528a;
    final /* synthetic */ String f10529b;
    final /* synthetic */ List f10530c;
    final /* synthetic */ String f10531d;
    final /* synthetic */ int f10532e;

    RemoteRedditApiDataSource$moreComments$1(RedditClient redditClient, String str, List list, String str2, int i) {
        this.f10528a = redditClient;
        this.f10529b = str;
        this.f10530c = list;
        this.f10531d = str2;
        this.f10532e = i;
    }

    public final /* synthetic */ Object call() {
        RedditRequestBuilder a = this.f10528a.m9246a(this.f10529b, this.f10530c, this.f10531d);
        a.m9327a("sort", Sorting.a(this.f10532e));
        return (MoreCommentResponse) a.m9334b();
    }
}
