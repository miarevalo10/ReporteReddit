package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.models.v1.EmptyMessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/MessageListing;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$inboxMessages$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10469a;
    final /* synthetic */ String f10470b;
    final /* synthetic */ String f10471c;
    final /* synthetic */ String f10472d;

    RemoteRedditApiDataSource$inboxMessages$1(RedditClient redditClient, String str, String str2, String str3) {
        this.f10469a = redditClient;
        this.f10470b = str;
        this.f10471c = str2;
        this.f10472d = str3;
    }

    public final /* synthetic */ Object call() {
        MessageListing messageListing = (MessageListing) this.f10469a.m9238a(this.f10470b, this.f10471c, this.f10472d).m9334b();
        return messageListing == null ? new EmptyMessageListing() : messageListing;
    }
}
