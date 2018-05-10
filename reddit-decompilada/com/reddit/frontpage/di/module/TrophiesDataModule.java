package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import com.reddit.datalibrary.frontpage.data.feature.trophies.repo.RedditTrophiesRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/di/module/TrophiesDataModule;", "", "()V", "remoteTrophiesDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/trophies/remote/RemoteTrophiesDataSource;", "client", "Lretrofit2/Retrofit;", "trophiesRepository", "Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrophiesDataModule.kt */
public final class TrophiesDataModule {
    @Singleton
    public static RemoteTrophiesDataSource m22377a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteTrophiesDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteTrop…esDataSource::class.java)");
        return (RemoteTrophiesDataSource) a;
    }

    @Singleton
    public static TrophiesRepository m22378a(BackgroundThread backgroundThread, RemoteTrophiesDataSource remoteTrophiesDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteTrophiesDataSource, "remote");
        return new RedditTrophiesRepository(backgroundThread, remoteTrophiesDataSource);
    }
}
