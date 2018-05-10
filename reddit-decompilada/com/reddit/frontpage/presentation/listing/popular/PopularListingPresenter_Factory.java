package com.reddit.frontpage.presentation.listing.popular;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.PopularLoadData;
import com.reddit.frontpage.domain.usecase.PopularRefreshData;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PopularListingPresenter_Factory implements Factory<PopularListingPresenter> {
    private final Provider<View> f34009a;
    private final Provider<SessionManager> f34010b;
    private final Provider<PopularLoadData> f34011c;
    private final Provider<PopularRefreshData> f34012d;
    private final Provider<UserLinkActions> f34013e;
    private final Provider<ModeratorLinkActions> f34014f;
    private final Provider<PostExecutionThread> f34015g;
    private final Provider<AdsActions> f34016h;
    private final Provider<FrontpageSettings> f34017i;
    private final Provider<PreferenceRepository> f34018j;
    private final Provider<BackgroundThread> f34019k;
    private final Provider<DiffListingUseCase> f34020l;
    private final Provider<Parameters> f34021m;

    private PopularListingPresenter_Factory(Provider<View> provider, Provider<SessionManager> provider2, Provider<PopularLoadData> provider3, Provider<PopularRefreshData> provider4, Provider<UserLinkActions> provider5, Provider<ModeratorLinkActions> provider6, Provider<PostExecutionThread> provider7, Provider<AdsActions> provider8, Provider<FrontpageSettings> provider9, Provider<PreferenceRepository> provider10, Provider<BackgroundThread> provider11, Provider<DiffListingUseCase> provider12, Provider<Parameters> provider13) {
        this.f34009a = provider;
        this.f34010b = provider2;
        this.f34011c = provider3;
        this.f34012d = provider4;
        this.f34013e = provider5;
        this.f34014f = provider6;
        this.f34015g = provider7;
        this.f34016h = provider8;
        this.f34017i = provider9;
        this.f34018j = provider10;
        this.f34019k = provider11;
        this.f34020l = provider12;
        this.f34021m = provider13;
    }

    public static PopularListingPresenter_Factory m34746a(Provider<View> provider, Provider<SessionManager> provider2, Provider<PopularLoadData> provider3, Provider<PopularRefreshData> provider4, Provider<UserLinkActions> provider5, Provider<ModeratorLinkActions> provider6, Provider<PostExecutionThread> provider7, Provider<AdsActions> provider8, Provider<FrontpageSettings> provider9, Provider<PreferenceRepository> provider10, Provider<BackgroundThread> provider11, Provider<DiffListingUseCase> provider12, Provider<Parameters> provider13) {
        return new PopularListingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public final /* synthetic */ Object get() {
        return new PopularListingPresenter((View) this.f34009a.get(), (SessionManager) this.f34010b.get(), (PopularLoadData) this.f34011c.get(), (PopularRefreshData) this.f34012d.get(), (UserLinkActions) this.f34013e.get(), (ModeratorLinkActions) this.f34014f.get(), (PostExecutionThread) this.f34015g.get(), (AdsActions) this.f34016h.get(), (FrontpageSettings) this.f34017i.get(), (PreferenceRepository) this.f34018j.get(), (BackgroundThread) this.f34019k.get(), (DiffListingUseCase) this.f34020l.get(), (Parameters) this.f34021m.get());
    }
}
