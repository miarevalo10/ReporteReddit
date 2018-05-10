package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v2.FileUploadLease;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/FileUploadLease;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$getVideoUploadLease$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10462a;
    final /* synthetic */ String f10463b;
    final /* synthetic */ String f10464c;

    RemoteRedditApiDataSource$getVideoUploadLease$1(RedditClient redditClient, String str, String str2) {
        this.f10462a = redditClient;
        this.f10463b = str;
        this.f10464c = str2;
    }

    public final /* synthetic */ Object call() {
        return (FileUploadLease) this.f10462a.m9276i(this.f10463b, this.f10464c).m9334b();
    }
}
