package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LinksLoadData_Factory implements Factory<LinksLoadData> {
    private final Provider<LinkRepository> f33750a;

    private LinksLoadData_Factory(Provider<LinkRepository> provider) {
        this.f33750a = provider;
    }

    public static LinksLoadData_Factory m34565a(Provider<LinkRepository> provider) {
        return new LinksLoadData_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new LinksLoadData((LinkRepository) this.f33750a.get());
    }
}
