package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import io.reactivex.Single;

public class SavedLinksProvider extends SavedListingProvider {
    protected final Single<ThingWrapperListing> mo4206a(String str, boolean z) {
        return RemoteRedditApiDataSource.m8908b(str, this.mAfter, z);
    }
}
