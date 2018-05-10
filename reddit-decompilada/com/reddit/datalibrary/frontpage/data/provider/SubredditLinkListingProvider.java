package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$13;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import org.parceler.Parcel;

public class SubredditLinkListingProvider extends LinkListingProvider {
    private final String f19441b;

    @Parcel
    static class SubredditListingProviderSpec extends ProviderSpec<SubredditLinkListingProvider> {
        final String subreddit;

        SubredditListingProviderSpec(String str, String str2) {
            super(str);
            this.subreddit = str2;
        }

        protected SubredditLinkListingProvider createProvider() {
            return new SubredditLinkListingProvider(this.ownerId, this.subreddit);
        }
    }

    public SubredditLinkListingProvider(String str, String str2) {
        super(str);
        this.f19441b = str2;
    }

    public final ProviderSpec<? extends SubredditLinkListingProvider> mo4201a() {
        return new SubredditListingProviderSpec(getOwnerId(), this.f19441b);
    }

    protected final void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        this.d.m8991a(this.f19441b, listingRequestParams, new ArrayList(), str, asyncCallback);
    }

    protected final void mo4207a(String str, List<Pair<String, String>> list, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        LegacyLinkRepository legacyLinkRepository = this.d;
        legacyLinkRepository.m8992a(new LegacyLinkRepository$$Lambda$13(legacyLinkRepository, this.f19441b, str, list), (AsyncCallback) asyncCallback);
    }
}
