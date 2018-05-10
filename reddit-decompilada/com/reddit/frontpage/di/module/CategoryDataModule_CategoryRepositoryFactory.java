package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CategoryDataModule_CategoryRepositoryFactory implements Factory<CategoryRepository> {
    private final CategoryDataModule f33531a;
    private final Provider<BackgroundThread> f33532b;
    private final Provider<RemoteCategoryDataSource> f33533c;

    private CategoryDataModule_CategoryRepositoryFactory(CategoryDataModule categoryDataModule, Provider<BackgroundThread> provider, Provider<RemoteCategoryDataSource> provider2) {
        this.f33531a = categoryDataModule;
        this.f33532b = provider;
        this.f33533c = provider2;
    }

    public static CategoryDataModule_CategoryRepositoryFactory m34470a(CategoryDataModule categoryDataModule, Provider<BackgroundThread> provider, Provider<RemoteCategoryDataSource> provider2) {
        return new CategoryDataModule_CategoryRepositoryFactory(categoryDataModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (CategoryRepository) Preconditions.m26013a(CategoryDataModule.m22328a((BackgroundThread) this.f33532b.get(), (RemoteCategoryDataSource) this.f33533c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
