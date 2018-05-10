package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$14;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import org.parceler.Parcel;

public class MultiredditLinkListingProvider extends LinkListingProvider {
    private final String f19438b;

    @Parcel
    static class MultiredditLinkListingProviderSpec extends ProviderSpec<MultiredditLinkListingProvider> {
        final String multireddit;

        MultiredditLinkListingProviderSpec(String str, String str2) {
            super(str);
            this.multireddit = str2;
        }

        protected MultiredditLinkListingProvider createProvider() {
            return new MultiredditLinkListingProvider(this.ownerId, this.multireddit);
        }
    }

    public MultiredditLinkListingProvider(String str, String str2) {
        super(str);
        this.f19438b = str2;
    }

    public final ProviderSpec<? extends BaseOtherProvider> mo4201a() {
        return new MultiredditLinkListingProviderSpec(getOwnerId(), this.f19438b);
    }

    protected final void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        LegacyLinkRepository legacyLinkRepository = this.d;
        legacyLinkRepository.m8992a(new LegacyLinkRepository$$Lambda$14(legacyLinkRepository, this.f19438b, listingRequestParams, str), (AsyncCallback) asyncCallback);
    }
}
