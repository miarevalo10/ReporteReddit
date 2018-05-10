package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource;
import com.reddit.datalibrary.frontpage.data.feature.category.repo.RedditCategoryRepository;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/di/module/CategoryDataModule;", "", "()V", "categoryRepository", "Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "dataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/category/datasource/RemoteCategoryDataSource;", "remoteCategoryDataSource", "client", "Lretrofit2/Retrofit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CategoryDataModule.kt */
public final class CategoryDataModule {
    @Singleton
    public static RemoteCategoryDataSource m22327a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteCategoryDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteCate…ryDataSource::class.java)");
        return (RemoteCategoryDataSource) a;
    }

    @Singleton
    public static CategoryRepository m22328a(BackgroundThread backgroundThread, RemoteCategoryDataSource remoteCategoryDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteCategoryDataSource, "dataSource");
        return new RedditCategoryRepository(backgroundThread, remoteCategoryDataSource);
    }
}
