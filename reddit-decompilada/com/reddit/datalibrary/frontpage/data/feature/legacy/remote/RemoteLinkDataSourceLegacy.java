package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import com.reddit.datalibrary.frontpage.data.provider.ListingRequestParams;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.List;
import kotlin.Pair;

public interface RemoteLinkDataSourceLegacy {
    CommentResponse mo2940a(String str, String str2) throws Exception;

    Listing<? extends Listable> mo2941a(ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str) throws Exception;

    Listing<? extends Listable> mo2942a(String str, ListingRequestParams listingRequestParams) throws Exception;

    Listing<? extends Listable> mo2943a(String str, ListingRequestParams listingRequestParams, String str2) throws Exception;

    Listing<? extends Listable> mo2944a(String str, ListingRequestParams listingRequestParams, List<Pair<String, String>> list, String str2) throws Exception;

    Listing<? extends Listable> mo2945a(String str, String str2, List<Pair<String, String>> list) throws Exception;
}
