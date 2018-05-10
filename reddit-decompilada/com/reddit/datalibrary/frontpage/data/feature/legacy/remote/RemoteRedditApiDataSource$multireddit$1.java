package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.ListingRequestBuilder2;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.commons.Sorting;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listing;", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RemoteRedditApiDataSource.kt */
final class RemoteRedditApiDataSource$multireddit$1<V> implements Callable<T> {
    final /* synthetic */ RedditClient f10536a;
    final /* synthetic */ String f10537b;
    final /* synthetic */ String f10538c;
    final /* synthetic */ ListingRequestParams f10539d;

    RemoteRedditApiDataSource$multireddit$1(RedditClient redditClient, String str, String str2, ListingRequestParams listingRequestParams) {
        this.f10536a = redditClient;
        this.f10537b = str;
        this.f10538c = str2;
        this.f10539d = listingRequestParams;
    }

    public final /* synthetic */ Object call() {
        Object obj;
        ListingRequestBuilder2 b = this.f10536a.m9250b(this.f10537b, this.f10538c);
        CharSequence charSequence = this.f10539d.f10791a;
        Object obj2 = 1;
        if (charSequence != null) {
            if (charSequence.length() != 0) {
                obj = null;
                if (obj == null) {
                    b.m19780d(this.f10539d.f10791a);
                }
                charSequence = this.f10539d.f10794d;
                if (charSequence != null) {
                    if (charSequence.length() == 0) {
                        obj2 = null;
                    }
                }
                if (obj2 == null) {
                    b.m9327a("dist", this.f10539d.f10794d);
                }
                if (this.f10539d.f10792b != -1) {
                    b.m9325a(Sorting.a(this.f10539d.f10792b));
                }
                if (this.f10539d.f10793c != -1) {
                    b.m9327a("t", Sorting.d(this.f10539d.f10793c));
                }
                return (Listing) b.m9334b();
            }
        }
        obj = 1;
        if (obj == null) {
            b.m19780d(this.f10539d.f10791a);
        }
        charSequence = this.f10539d.f10794d;
        if (charSequence != null) {
            if (charSequence.length() == 0) {
                obj2 = null;
            }
        }
        if (obj2 == null) {
            b.m9327a("dist", this.f10539d.f10794d);
        }
        if (this.f10539d.f10792b != -1) {
            b.m9325a(Sorting.a(this.f10539d.f10792b));
        }
        if (this.f10539d.f10793c != -1) {
            b.m9327a("t", Sorting.d(this.f10539d.f10793c));
        }
        return (Listing) b.m9334b();
    }
}
