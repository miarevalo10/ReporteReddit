package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import java.util.Collection;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$favorite$1<V> implements Callable<Object> {
    final /* synthetic */ RedditClient f10450a;
    final /* synthetic */ Boolean f10451b;
    final /* synthetic */ Collection f10452c;

    RemoteRedditApiDataSource$favorite$1(RedditClient redditClient, Boolean bool, Collection collection) {
        this.f10450a = redditClient;
        this.f10451b = bool;
        this.f10452c = collection;
    }

    public final /* synthetic */ Object call() {
        return (Void) this.f10450a.m9241a(this.f10451b, this.f10452c).m9334b();
    }
}
