package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$modSetStickyStatus$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10515a;
    final /* synthetic */ String f10516b;
    final /* synthetic */ boolean f10517c;

    RemoteRedditApiDataSource$modSetStickyStatus$1(RedditClient redditClient, String str, boolean z) {
        this.f10515a = redditClient;
        this.f10516b = str;
        this.f10517c = z;
    }

    public final Object call() {
        return this.f10515a.m9247a(this.f10516b, this.f10517c).m9334b();
    }
}
