package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.GenericResponse;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\"\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0001¨\u0006\u00010\u0001¨\u0006\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/GenericResponse;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$compose$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10435a;
    final /* synthetic */ String f10436b;
    final /* synthetic */ String f10437c;
    final /* synthetic */ String f10438d;
    final /* synthetic */ String f10439e = null;

    RemoteRedditApiDataSource$compose$1(RedditClient redditClient, String str, String str2, String str3) {
        this.f10435a = redditClient;
        this.f10436b = str;
        this.f10437c = str2;
        this.f10438d = str3;
    }

    public final /* synthetic */ Object call() {
        return (GenericResponse) this.f10435a.m9259c(this.f10436b, this.f10437c, this.f10438d).m9334b();
    }
}
