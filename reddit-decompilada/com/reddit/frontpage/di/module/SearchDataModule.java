package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.search.RemoteSearchDataSource;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/SearchDataModule;", "", "()V", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/search/RemoteSearchDataSource;", "client", "Lretrofit2/Retrofit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchDataModule.kt */
public final class SearchDataModule {
    @Singleton
    public static RemoteSearchDataSource m22368a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteSearchDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteSearchDataSource::class.java)");
        return (RemoteSearchDataSource) a;
    }
}
