package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class CategoryDataModule_RemoteCategoryDataSourceFactory implements Factory<RemoteCategoryDataSource> {
    private final CategoryDataModule f33534a;
    private final Provider<Retrofit> f33535b;

    private CategoryDataModule_RemoteCategoryDataSourceFactory(CategoryDataModule categoryDataModule, Provider<Retrofit> provider) {
        this.f33534a = categoryDataModule;
        this.f33535b = provider;
    }

    public static CategoryDataModule_RemoteCategoryDataSourceFactory m34471a(CategoryDataModule categoryDataModule, Provider<Retrofit> provider) {
        return new CategoryDataModule_RemoteCategoryDataSourceFactory(categoryDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteCategoryDataSource) Preconditions.m26013a(CategoryDataModule.m22327a((Retrofit) this.f33535b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
