package com.reddit.frontpage.domain.usecase;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PopularRefreshData_Factory implements Factory<PopularRefreshData> {
    private final Provider<LinkRepository> f33770a;
    private final Provider<AdsRepository> f33771b;
    private final Provider<BackgroundThread> f33772c;
    private final Provider<FrontpageSettings> f33773d;
    private final Provider<SessionManager> f33774e;

    private PopularRefreshData_Factory(Provider<LinkRepository> provider, Provider<AdsRepository> provider2, Provider<BackgroundThread> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        this.f33770a = provider;
        this.f33771b = provider2;
        this.f33772c = provider3;
        this.f33773d = provider4;
        this.f33774e = provider5;
    }

    public static PopularRefreshData_Factory m34572a(Provider<LinkRepository> provider, Provider<AdsRepository> provider2, Provider<BackgroundThread> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        return new PopularRefreshData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new PopularRefreshData((LinkRepository) this.f33770a.get(), (AdsRepository) this.f33771b.get(), (BackgroundThread) this.f33772c.get(), (FrontpageSettings) this.f33773d.get(), (SessionManager) this.f33774e.get());
    }
}
