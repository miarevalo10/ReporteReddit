package com.reddit.frontpage.domain.usecase;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PopularLoadData_Factory implements Factory<PopularLoadData> {
    private final Provider<LinkRepository> f33760a;
    private final Provider<BackgroundThread> f33761b;
    private final Provider<AdsRepository> f33762c;
    private final Provider<FrontpageSettings> f33763d;
    private final Provider<SessionManager> f33764e;

    private PopularLoadData_Factory(Provider<LinkRepository> provider, Provider<BackgroundThread> provider2, Provider<AdsRepository> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        this.f33760a = provider;
        this.f33761b = provider2;
        this.f33762c = provider3;
        this.f33763d = provider4;
        this.f33764e = provider5;
    }

    public static PopularLoadData_Factory m34569a(Provider<LinkRepository> provider, Provider<BackgroundThread> provider2, Provider<AdsRepository> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        return new PopularLoadData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new PopularLoadData((LinkRepository) this.f33760a.get(), (BackgroundThread) this.f33761b.get(), (AdsRepository) this.f33762c.get(), (FrontpageSettings) this.f33763d.get(), (SessionManager) this.f33764e.get());
    }
}
