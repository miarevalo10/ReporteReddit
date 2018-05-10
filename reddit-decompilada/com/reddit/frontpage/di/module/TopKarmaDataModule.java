package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local.LocalKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote.RemoteKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.repo.RedditKarmaRepository;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/di/module/TopKarmaDataModule;", "", "()V", "karmaRepository", "Lcom/reddit/frontpage/domain/repository/KarmaRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/remote/RemoteKarmaDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/local/LocalKarmaDataSource;", "remoteKarmaDataSource", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TopKarmaDataModule.kt */
public final class TopKarmaDataModule {
    @Singleton
    public static RemoteKarmaDataSource m22375a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteKarmaDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteKarmaDataSource::class.java)");
        return (RemoteKarmaDataSource) a;
    }

    @Singleton
    public static KarmaRepository m22376a(BackgroundThread backgroundThread, RemoteKarmaDataSource remoteKarmaDataSource, LocalKarmaDataSource localKarmaDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteKarmaDataSource, "remote");
        Intrinsics.m26847b(localKarmaDataSource, "local");
        return new RedditKarmaRepository(backgroundThread, remoteKarmaDataSource, localKarmaDataSource);
    }
}
