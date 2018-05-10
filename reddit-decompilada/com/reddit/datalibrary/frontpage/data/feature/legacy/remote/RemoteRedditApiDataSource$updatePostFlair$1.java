package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v2.LinkFlair;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$updatePostFlair$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10646a;
    final /* synthetic */ LinkFlair f10647b;
    final /* synthetic */ String f10648c;
    final /* synthetic */ String f10649d;

    RemoteRedditApiDataSource$updatePostFlair$1(RedditClient redditClient, LinkFlair linkFlair, String str, String str2) {
        this.f10646a = redditClient;
        this.f10647b = linkFlair;
        this.f10648c = str;
        this.f10649d = str2;
    }

    public final Object call() {
        return this.f10646a.m9240a(this.f10647b, this.f10648c, this.f10649d).m9334b();
    }
}
