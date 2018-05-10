package com.reddit.frontpage.domain.usecase;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FrontpageRefreshData_Factory implements Factory<FrontpageRefreshData> {
    private final Provider<LinkRepository> f33735a;
    private final Provider<AdsRepository> f33736b;
    private final Provider<BackgroundThread> f33737c;
    private final Provider<FrontpageSettings> f33738d;
    private final Provider<SessionManager> f33739e;

    private FrontpageRefreshData_Factory(Provider<LinkRepository> provider, Provider<AdsRepository> provider2, Provider<BackgroundThread> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        this.f33735a = provider;
        this.f33736b = provider2;
        this.f33737c = provider3;
        this.f33738d = provider4;
        this.f33739e = provider5;
    }

    public static FrontpageRefreshData_Factory m34562a(Provider<LinkRepository> provider, Provider<AdsRepository> provider2, Provider<BackgroundThread> provider3, Provider<FrontpageSettings> provider4, Provider<SessionManager> provider5) {
        return new FrontpageRefreshData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new FrontpageRefreshData((LinkRepository) this.f33735a.get(), (AdsRepository) this.f33736b.get(), (BackgroundThread) this.f33737c.get(), (FrontpageSettings) this.f33738d.get(), (SessionManager) this.f33739e.get());
    }
}
