package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentReplyResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentReplyResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$comment$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10427a;
    final /* synthetic */ String f10428b;
    final /* synthetic */ String f10429c;

    RemoteRedditApiDataSource$comment$1(RedditClient redditClient, String str, String str2) {
        this.f10427a = redditClient;
        this.f10428b = str;
        this.f10429c = str2;
    }

    public final /* synthetic */ Object call() {
        return (CommentReplyResponse) this.f10427a.m9278j(this.f10428b, this.f10429c).m9334b();
    }
}
