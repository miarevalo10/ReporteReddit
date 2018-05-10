package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.region.local.LocalRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.remote.RemoteRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.repo.RedditRegionRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/di/module/RegionDataModule;", "", "()V", "accountRepository", "Lcom/reddit/frontpage/domain/repository/RegionRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/region/remote/RemoteRegionDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/region/local/LocalRegionDataSource;", "remoteAccountDataSource", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RegionDataModule.kt */
public final class RegionDataModule {
    @Singleton
    public static RemoteRegionDataSource m22363a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteRegionDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteRegionDataSource::class.java)");
        return (RemoteRegionDataSource) a;
    }

    @Singleton
    public static RegionRepository m22364a(BackgroundThread backgroundThread, RemoteRegionDataSource remoteRegionDataSource, LocalRegionDataSource localRegionDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteRegionDataSource, "remote");
        Intrinsics.m26847b(localRegionDataSource, "local");
        return new RedditRegionRepository(backgroundThread, remoteRegionDataSource, localRegionDataSource);
    }
}
