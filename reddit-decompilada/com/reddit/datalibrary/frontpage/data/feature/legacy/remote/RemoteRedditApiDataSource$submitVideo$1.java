package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubmitVideoResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/SubmitVideoResponse;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$submitVideo$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10611a;
    final /* synthetic */ String f10612b;
    final /* synthetic */ String f10613c;
    final /* synthetic */ String f10614d;
    final /* synthetic */ String f10615e;
    final /* synthetic */ String f10616f;
    final /* synthetic */ String f10617g;
    final /* synthetic */ boolean f10618h = false;
    final /* synthetic */ boolean f10619i = false;

    RemoteRedditApiDataSource$submitVideo$1(RedditClient redditClient, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f10611a = redditClient;
        this.f10612b = str;
        this.f10613c = str2;
        this.f10614d = str3;
        this.f10615e = str4;
        this.f10616f = str5;
        this.f10617g = str6;
    }

    public final /* synthetic */ Object call() {
        return (SubmitVideoResponse) this.f10611a.m9244a(this.f10612b, this.f10613c, this.f10614d, this.f10615e, this.f10616f, this.f10617g, this.f10618h, this.f10619i).m9334b();
    }
}
