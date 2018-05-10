package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource;
import com.reddit.datalibrary.frontpage.data.feature.modtools.repo.RedditModToolsRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/di/module/ModToolsDataModule;", "", "()V", "modToolsRepository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/datasource/RemoteModToolsDataSource;", "remoteModToolsDataSource", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsDataModule.kt */
public final class ModToolsDataModule {
    @Singleton
    public static RemoteModToolsDataSource m22347a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteModToolsDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteModT…lsDataSource::class.java)");
        return (RemoteModToolsDataSource) a;
    }

    @Singleton
    public static ModToolsRepository m22348a(BackgroundThread backgroundThread, RemoteModToolsDataSource remoteModToolsDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteModToolsDataSource, "remote");
        return new RedditModToolsRepository(backgroundThread, remoteModToolsDataSource);
    }
}
