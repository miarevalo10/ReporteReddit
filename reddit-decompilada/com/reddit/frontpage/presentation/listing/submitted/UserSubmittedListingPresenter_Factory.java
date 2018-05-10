package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.domain.usecase.LinksLoadData;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UserSubmittedListingPresenter_Factory implements Factory<UserSubmittedListingPresenter> {
    private final Provider<View> f34022a;
    private final Provider<ListingNavigator> f34023b;
    private final Provider<KarmaRepository> f34024c;
    private final Provider<AccountRepository> f34025d;
    private final Provider<PostExecutionThread> f34026e;
    private final Provider<ModeratorLinkActions> f34027f;
    private final Provider<UserLinkActions> f34028g;
    private final Provider<LinksLoadData> f34029h;

    private UserSubmittedListingPresenter_Factory(Provider<View> provider, Provider<ListingNavigator> provider2, Provider<KarmaRepository> provider3, Provider<AccountRepository> provider4, Provider<PostExecutionThread> provider5, Provider<ModeratorLinkActions> provider6, Provider<UserLinkActions> provider7, Provider<LinksLoadData> provider8) {
        this.f34022a = provider;
        this.f34023b = provider2;
        this.f34024c = provider3;
        this.f34025d = provider4;
        this.f34026e = provider5;
        this.f34027f = provider6;
        this.f34028g = provider7;
        this.f34029h = provider8;
    }

    public static UserSubmittedListingPresenter_Factory m34747a(Provider<View> provider, Provider<ListingNavigator> provider2, Provider<KarmaRepository> provider3, Provider<AccountRepository> provider4, Provider<PostExecutionThread> provider5, Provider<ModeratorLinkActions> provider6, Provider<UserLinkActions> provider7, Provider<LinksLoadData> provider8) {
        return new UserSubmittedListingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public final /* synthetic */ Object get() {
        return new UserSubmittedListingPresenter((View) this.f34022a.get(), (ListingNavigator) this.f34023b.get(), (KarmaRepository) this.f34024c.get(), (AccountRepository) this.f34025d.get(), (PostExecutionThread) this.f34026e.get(), (ModeratorLinkActions) this.f34027f.get(), (UserLinkActions) this.f34028g.get(), (LinksLoadData) this.f34029h.get());
    }
}
