package com.reddit.datalibrary.frontpage.data.provider;

import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$10;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$11;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$2;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$3;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$4;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$5;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$6;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$7;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$8;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository$$Lambda$9;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.util.SchedulerProvider;
import io.reactivex.Observable;
import java.io.Serializable;
import org.parceler.Parcel;

public class UserSubmittedListingProvider extends LinkListingProvider {
    private final String f19442b;

    public interface Filter extends com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider.Filter, Serializable {
    }

    @Parcel
    static class UserSubmittedListingProviderSpec extends ProviderSpec<UserSubmittedListingProvider> {
        final Filter filter;
        final String username;

        UserSubmittedListingProviderSpec(String str, String str2, Filter filter) {
            super(str);
            this.username = str2;
            this.filter = filter;
        }

        protected UserSubmittedListingProvider createProvider() {
            return new UserSubmittedListingProvider(this.ownerId, this.username, this.filter);
        }
    }

    public UserSubmittedListingProvider(String str, String str2, Filter filter) {
        super(str, -1, (com.reddit.datalibrary.frontpage.data.provider.LinkListingProvider.Filter) filter);
        this.f19442b = str2;
    }

    public final ProviderSpec<? extends BaseOtherProvider> mo4201a() {
        return new UserSubmittedListingProviderSpec(getOwnerId(), this.f19442b, (Filter) this.c);
    }

    protected final void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
        LegacyLinkRepository legacyLinkRepository = this.d;
        String str2 = this.f19442b;
        if (TextUtils.isEmpty(listingRequestParams.f10791a)) {
            listingRequestParams = Observable.zip(Observable.fromCallable(LegacyLinkRepository$$Lambda$2.f10698a).flatMapIterable(LegacyLinkRepository$$Lambda$3.f16063a).filter(LegacyLinkRepository$$Lambda$4.f16064a).map(LegacyLinkRepository$$Lambda$5.f16065a).toSortedList(LegacyLinkRepository$$Lambda$6.f10699a).toObservable(), Observable.fromCallable(new LegacyLinkRepository$$Lambda$7(legacyLinkRepository, str2, listingRequestParams, str)), LegacyLinkRepository$$Lambda$8.f16066a).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c());
            asyncCallback.getClass();
            listingRequestParams.subscribe(LegacyLinkRepository$$Lambda$9.m16025a(asyncCallback), new LegacyLinkRepository$$Lambda$10(asyncCallback));
            return;
        }
        legacyLinkRepository.m8992a(new LegacyLinkRepository$$Lambda$11(legacyLinkRepository, str2, listingRequestParams, str), (AsyncCallback) asyncCallback);
    }
}
