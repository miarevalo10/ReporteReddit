package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.DatabaseLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.RedditLinkRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.squareup.moshi.Moshi;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0013"}, d2 = {"Lcom/reddit/frontpage/di/module/LinkDataModule;", "", "()V", "provideDatabaseLinkDatasource", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "provideLinkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/RemoteLinkDatasource;", "local", "db", "provideRemoteLinkDatasource", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkDataModule.kt */
public final class LinkDataModule {
    @Singleton
    public static RemoteLinkDatasource m22343a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteLinkDatasource.class);
        Intrinsics.m26843a(a, "client.create(RemoteLinkDatasource::class.java)");
        return (RemoteLinkDatasource) a;
    }

    @Singleton
    public static LinkRepository m22344a(BackgroundThread backgroundThread, RemoteLinkDatasource remoteLinkDatasource, LocalLinkDataSource localLinkDataSource, LocalLinkDataSource localLinkDataSource2) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteLinkDatasource, "remote");
        Intrinsics.m26847b(localLinkDataSource, "local");
        Intrinsics.m26847b(localLinkDataSource2, "db");
        return new RedditLinkRepository(backgroundThread, remoteLinkDatasource, localLinkDataSource, localLinkDataSource2);
    }

    @Singleton
    public static LocalLinkDataSource m22342a(Moshi moshi) {
        Intrinsics.m26847b(moshi, "moshi");
        return new DatabaseLinkDataSource(moshi);
    }
}
