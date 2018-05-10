package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$submitLink$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10589a;
    final /* synthetic */ String f10590b;
    final /* synthetic */ String f10591c;
    final /* synthetic */ String f10592d;
    final /* synthetic */ boolean f10593e = false;
    final /* synthetic */ boolean f10594f = false;
    final /* synthetic */ String f10595g;
    final /* synthetic */ String f10596h;
    final /* synthetic */ String f10597i;
    final /* synthetic */ String f10598j;
    final /* synthetic */ String f10599k;

    RemoteRedditApiDataSource$submitLink$1(RedditClient redditClient, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f10589a = redditClient;
        this.f10590b = str;
        this.f10591c = str2;
        this.f10592d = str3;
        this.f10595g = str4;
        this.f10596h = str5;
        this.f10597i = str6;
        this.f10598j = str7;
        this.f10599k = str8;
    }

    public final /* synthetic */ Object call() {
        return (SubmitResponse) this.f10589a.m9245a(this.f10590b, this.f10591c, this.f10592d, this.f10593e, this.f10594f, this.f10595g, this.f10596h, this.f10597i, this.f10598j, this.f10599k).m9334b();
    }
}
