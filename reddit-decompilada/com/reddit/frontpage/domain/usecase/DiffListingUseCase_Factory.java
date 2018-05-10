package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DiffListingUseCase_Factory implements Factory<DiffListingUseCase> {
    private final Provider<LinkRepository> f33717a;

    private DiffListingUseCase_Factory(Provider<LinkRepository> provider) {
        this.f33717a = provider;
    }

    public static DiffListingUseCase_Factory m34556a(Provider<LinkRepository> provider) {
        return new DiffListingUseCase_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new DiffListingUseCase((LinkRepository) this.f33717a.get());
    }
}
