package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$vote$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10650a;
    final /* synthetic */ String f10651b;
    final /* synthetic */ int f10652c;

    RemoteRedditApiDataSource$vote$1(RedditClient redditClient, String str, int i) {
        this.f10650a = redditClient;
        this.f10651b = str;
        this.f10652c = i;
    }

    public final Object call() {
        return this.f10650a.m9243a(this.f10651b, this.f10652c).m9334b();
    }
}
