package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$submitSelf$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10600a;
    final /* synthetic */ String f10601b;
    final /* synthetic */ String f10602c;
    final /* synthetic */ String f10603d;
    final /* synthetic */ boolean f10604e = false;
    final /* synthetic */ boolean f10605f = false;
    final /* synthetic */ String f10606g;
    final /* synthetic */ String f10607h;
    final /* synthetic */ String f10608i;
    final /* synthetic */ String f10609j;
    final /* synthetic */ String f10610k;

    RemoteRedditApiDataSource$submitSelf$1(RedditClient redditClient, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f10600a = redditClient;
        this.f10601b = str;
        this.f10602c = str2;
        this.f10603d = str3;
        this.f10606g = str4;
        this.f10607h = str5;
        this.f10608i = str6;
        this.f10609j = str7;
        this.f10610k = str8;
    }

    public final /* synthetic */ Object call() {
        return (SubmitResponse) this.f10600a.m9260c(this.f10601b, this.f10602c, this.f10603d, this.f10604e, this.f10605f, this.f10606g, this.f10607h, this.f10608i, this.f10609j, this.f10610k).m9334b();
    }
}
