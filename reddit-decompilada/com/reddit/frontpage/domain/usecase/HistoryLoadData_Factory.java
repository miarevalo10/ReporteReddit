package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HistoryLoadData_Factory implements Factory<HistoryLoadData> {
    private final Provider<LinkRepository> f33740a;
    private final Provider<PreferenceRepository> f33741b;

    private HistoryLoadData_Factory(Provider<LinkRepository> provider, Provider<PreferenceRepository> provider2) {
        this.f33740a = provider;
        this.f33741b = provider2;
    }

    public static HistoryLoadData_Factory m34563a(Provider<LinkRepository> provider, Provider<PreferenceRepository> provider2) {
        return new HistoryLoadData_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new HistoryLoadData((LinkRepository) this.f33740a.get(), (PreferenceRepository) this.f33741b.get());
    }
}
