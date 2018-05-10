package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$report$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10549a;
    final /* synthetic */ String f10550b;
    final /* synthetic */ String f10551c;
    final /* synthetic */ String f10552d;

    RemoteRedditApiDataSource$report$1(RedditClient redditClient, String str, String str2, String str3) {
        this.f10549a = redditClient;
        this.f10550b = str;
        this.f10551c = str2;
        this.f10552d = str3;
    }

    public final Object call() {
        return this.f10549a.m9265d(this.f10550b, this.f10551c, this.f10552d).m9334b();
    }
}
