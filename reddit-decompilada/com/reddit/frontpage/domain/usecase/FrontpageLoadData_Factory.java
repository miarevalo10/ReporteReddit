package com.reddit.frontpage.domain.usecase;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FrontpageLoadData_Factory implements Factory<FrontpageLoadData> {
    private final Provider<LinkRepository> f33725a;
    private final Provider<BackgroundThread> f33726b;
    private final Provider<AdsRepository> f33727c;
    private final Provider<FrontpageSettings> f33728d;
    private final Provider<SessionManager> f33729e;

    private FrontpageLoadData_Factory(Provider<LinkRepository> provider, Provider<BackgroundThread> provider2, Provider<AdsRepository> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        this.f33725a = provider;
        this.f33726b = provider2;
        this.f33727c = provider3;
        this.f33728d = provider4;
        this.f33729e = provider5;
    }

    public static FrontpageLoadData_Factory m34559a(Provider<LinkRepository> provider, Provider<BackgroundThread> provider2, Provider<AdsRepository> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        return new FrontpageLoadData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new FrontpageLoadData((LinkRepository) this.f33725a.get(), (BackgroundThread) this.f33726b.get(), (AdsRepository) this.f33727c.get(), (FrontpageSettings) this.f33728d.get(), (SessionManager) this.f33729e.get());
    }
}
