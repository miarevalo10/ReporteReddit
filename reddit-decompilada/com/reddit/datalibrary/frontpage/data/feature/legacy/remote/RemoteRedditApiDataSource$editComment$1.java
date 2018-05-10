package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentEditResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/CommentEditResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$editComment$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10444a;
    final /* synthetic */ String f10445b;
    final /* synthetic */ String f10446c;

    RemoteRedditApiDataSource$editComment$1(RedditClient redditClient, String str, String str2) {
        this.f10444a = redditClient;
        this.f10445b = str;
        this.f10446c = str2;
    }

    public final /* synthetic */ Object call() {
        return (CommentEditResponse) this.f10444a.m9280k(this.f10445b, this.f10446c).m9334b();
    }
}
