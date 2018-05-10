package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitImageResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitImageResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$submitImage$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10578a;
    final /* synthetic */ String f10579b;
    final /* synthetic */ String f10580c;
    final /* synthetic */ String f10581d;
    final /* synthetic */ boolean f10582e = false;
    final /* synthetic */ boolean f10583f = false;
    final /* synthetic */ String f10584g;
    final /* synthetic */ String f10585h;
    final /* synthetic */ String f10586i;
    final /* synthetic */ String f10587j;
    final /* synthetic */ String f10588k;

    RemoteRedditApiDataSource$submitImage$1(RedditClient redditClient, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f10578a = redditClient;
        this.f10579b = str;
        this.f10580c = str2;
        this.f10581d = str3;
        this.f10584g = str4;
        this.f10585h = str5;
        this.f10586i = str6;
        this.f10587j = str7;
        this.f10588k = str8;
    }

    public final /* synthetic */ Object call() {
        return (SubmitImageResponse) this.f10578a.m9253b(this.f10579b, this.f10580c, this.f10581d, this.f10582e, this.f10583f, this.f10584g, this.f10585h, this.f10586i, this.f10587j, this.f10588k).m9334b();
    }
}
