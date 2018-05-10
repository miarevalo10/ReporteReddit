package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CategoryLinksLoadData_Factory implements Factory<CategoryLinksLoadData> {
    private final Provider<CategoryRepository> f33715a;
    private final Provider<LinkRepository> f33716b;

    private CategoryLinksLoadData_Factory(Provider<CategoryRepository> provider, Provider<LinkRepository> provider2) {
        this.f33715a = provider;
        this.f33716b = provider2;
    }

    public static CategoryLinksLoadData_Factory m34555a(Provider<CategoryRepository> provider, Provider<LinkRepository> provider2) {
        return new CategoryLinksLoadData_Factory(provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return new CategoryLinksLoadData((CategoryRepository) this.f33715a.get(), (LinkRepository) this.f33716b.get());
    }
}
