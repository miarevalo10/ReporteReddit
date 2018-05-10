package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LinkPagerLoadData_Factory implements Factory<LinkPagerLoadData> {
    private final Provider<LinkRepository> f33748a;
    private final Provider<PreferenceRepository> f33749b;

    private LinkPagerLoadData_Factory(Provider<LinkRepository> provider, Provider<PreferenceRepository> provider2) {
        this.f33748a = provider;
        this.f33749b = provider2;
    }

    public static LinkPagerLoadData_Factory m34564a(Provider<LinkRepository> provider, Provider<PreferenceRepository> provider2) {
        return new LinkPagerLoadData_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new LinkPagerLoadData((LinkRepository) this.f33748a.get(), (PreferenceRepository) this.f33749b.get());
    }
}
