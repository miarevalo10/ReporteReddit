package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.FrontpageApplication;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;

public class ApiLinkDataSourceLegacy implements RemoteLinkDataSourceLegacy {
    @Inject
    RemoteRedditApiDataSource f15874a;

    public ApiLinkDataSourceLegacy() {
        FrontpageApplication.m().a(this);
    }

    public final Listing<? extends Link> mo2941a(ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8883a(listingRequestParams, (List) list, str).blockingGet();
    }

    public final Listing<? extends Link> mo2942a(String str, ListingRequestParams listingRequestParams) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8887a(str, listingRequestParams).blockingGet();
    }

    public final Listing<? extends Link> mo2944a(String str, ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str2) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8889a(str, listingRequestParams, (List) list, str2).blockingGet();
    }

    public final Listing<? extends Link> mo2943a(String str, ListingRequestParams listingRequestParams, String str2) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8888a(str, listingRequestParams, str2).blockingGet();
    }

    public final Listing<? extends Listable> mo2945a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        return (Listing) RemoteRedditApiDataSource.m8895a(str, str2, (List) list).blockingGet();
    }

    public final CommentResponse mo2940a(String str, String str2) throws Exception {
        return (CommentResponse) RemoteRedditApiDataSource.m8886a(str, -1, false, null, null, str2).blockingGet();
    }
}
