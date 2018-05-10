package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.FrontpageLoadData;
import com.reddit.frontpage.domain.usecase.FrontpageRefreshData;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FrontpageListingPresenter_Factory implements Factory<FrontpageListingPresenter> {
    private final Provider<View> f33899a;
    private final Provider<SessionManager> f33900b;
    private final Provider<ListingNavigator> f33901c;
    private final Provider<FrontpageNavigator> f33902d;
    private final Provider<FrontpageLoadData> f33903e;
    private final Provider<FrontpageRefreshData> f33904f;
    private final Provider<UserLinkActions> f33905g;
    private final Provider<ModeratorLinkActions> f33906h;
    private final Provider<FrontpageSettings> f33907i;
    private final Provider<AdsActions> f33908j;
    private final Provider<PreferenceRepository> f33909k;
    private final Provider<ListingSortUseCase> f33910l;
    private final Provider<CarouselActions> f33911m;
    private final Provider<BackgroundThread> f33912n;
    private final Provider<PostExecutionThread> f33913o;
    private final Provider<DiffListingUseCase> f33914p;
    private final Provider<Parameters> f33915q;

    private FrontpageListingPresenter_Factory(Provider<View> provider, Provider<SessionManager> provider2, Provider<ListingNavigator> provider3, Provider<FrontpageNavigator> provider4, Provider<FrontpageLoadData> provider5, Provider<FrontpageRefreshData> provider6, Provider<UserLinkActions> provider7, Provider<ModeratorLinkActions> provider8, Provider<FrontpageSettings> provider9, Provider<AdsActions> provider10, Provider<PreferenceRepository> provider11, Provider<ListingSortUseCase> provider12, Provider<CarouselActions> provider13, Provider<BackgroundThread> provider14, Provider<PostExecutionThread> provider15, Provider<DiffListingUseCase> provider16, Provider<Parameters> provider17) {
        this.f33899a = provider;
        this.f33900b = provider2;
        this.f33901c = provider3;
        this.f33902d = provider4;
        this.f33903e = provider5;
        this.f33904f = provider6;
        this.f33905g = provider7;
        this.f33906h = provider8;
        this.f33907i = provider9;
        this.f33908j = provider10;
        this.f33909k = provider11;
        this.f33910l = provider12;
        this.f33911m = provider13;
        this.f33912n = provider14;
        this.f33913o = provider15;
        this.f33914p = provider16;
        this.f33915q = provider17;
    }

    public static FrontpageListingPresenter_Factory m34722a(Provider<View> provider, Provider<SessionManager> provider2, Provider<ListingNavigator> provider3, Provider<FrontpageNavigator> provider4, Provider<FrontpageLoadData> provider5, Provider<FrontpageRefreshData> provider6, Provider<UserLinkActions> provider7, Provider<ModeratorLinkActions> provider8, Provider<FrontpageSettings> provider9, Provider<AdsActions> provider10, Provider<PreferenceRepository> provider11, Provider<ListingSortUseCase> provider12, Provider<CarouselActions> provider13, Provider<BackgroundThread> provider14, Provider<PostExecutionThread> provider15, Provider<DiffListingUseCase> provider16, Provider<Parameters> provider17) {
        return new FrontpageListingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    public final /* synthetic */ Object get() {
        return new FrontpageListingPresenter((View) this.f33899a.get(), (SessionManager) this.f33900b.get(), (ListingNavigator) this.f33901c.get(), (FrontpageNavigator) this.f33902d.get(), (FrontpageLoadData) this.f33903e.get(), (FrontpageRefreshData) this.f33904f.get(), (UserLinkActions) this.f33905g.get(), (ModeratorLinkActions) this.f33906h.get(), (FrontpageSettings) this.f33907i.get(), (AdsActions) this.f33908j.get(), (PreferenceRepository) this.f33909k.get(), (ListingSortUseCase) this.f33910l.get(), (CarouselActions) this.f33911m.get(), (BackgroundThread) this.f33912n.get(), (PostExecutionThread) this.f33913o.get(), (DiffListingUseCase) this.f33914p.get(), (Parameters) this.f33915q.get());
    }
}
