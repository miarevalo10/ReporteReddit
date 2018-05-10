package com.reddit.frontpage.presentation.listing.history;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.HistoryLoadData;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HistoryListingPresenter_Factory implements Factory<HistoryListingPresenter> {
    private final Provider<View> f33917a;
    private final Provider<SessionManager> f33918b;
    private final Provider<HistoryLoadData> f33919c;
    private final Provider<LinkRepository> f33920d;
    private final Provider<PreferenceRepository> f33921e;
    private final Provider<UserLinkActions> f33922f;
    private final Provider<ModeratorLinkActions> f33923g;
    private final Provider<BackgroundThread> f33924h;
    private final Provider<PostExecutionThread> f33925i;
    private final Provider<Parameters> f33926j;

    private HistoryListingPresenter_Factory(Provider<View> provider, Provider<SessionManager> provider2, Provider<HistoryLoadData> provider3, Provider<LinkRepository> provider4, Provider<PreferenceRepository> provider5, Provider<UserLinkActions> provider6, Provider<ModeratorLinkActions> provider7, Provider<BackgroundThread> provider8, Provider<PostExecutionThread> provider9, Provider<Parameters> provider10) {
        this.f33917a = provider;
        this.f33918b = provider2;
        this.f33919c = provider3;
        this.f33920d = provider4;
        this.f33921e = provider5;
        this.f33922f = provider6;
        this.f33923g = provider7;
        this.f33924h = provider8;
        this.f33925i = provider9;
        this.f33926j = provider10;
    }

    public static HistoryListingPresenter_Factory m34724a(Provider<View> provider, Provider<SessionManager> provider2, Provider<HistoryLoadData> provider3, Provider<LinkRepository> provider4, Provider<PreferenceRepository> provider5, Provider<UserLinkActions> provider6, Provider<ModeratorLinkActions> provider7, Provider<BackgroundThread> provider8, Provider<PostExecutionThread> provider9, Provider<Parameters> provider10) {
        return new HistoryListingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public final /* synthetic */ Object get() {
        return new HistoryListingPresenter((View) this.f33917a.get(), (SessionManager) this.f33918b.get(), (HistoryLoadData) this.f33919c.get(), (LinkRepository) this.f33920d.get(), (PreferenceRepository) this.f33921e.get(), (UserLinkActions) this.f33922f.get(), (ModeratorLinkActions) this.f33923g.get(), (BackgroundThread) this.f33924h.get(), (PostExecutionThread) this.f33925i.get(), (Parameters) this.f33926j.get());
    }
}
