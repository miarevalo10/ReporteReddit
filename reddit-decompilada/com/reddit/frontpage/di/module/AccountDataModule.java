package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.LocalAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.repo.RedditAccountRepository;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.usecase.AccountUseCase;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/di/module/AccountDataModule;", "", "()V", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/remote/RemoteAccountDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/local/LocalAccountDataSource;", "accountUseCase", "Lcom/reddit/frontpage/domain/usecase/AccountUseCase;", "repository", "remoteAccountDataSource", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountDataModule.kt */
public final class AccountDataModule {
    @Singleton
    public static RemoteAccountDataSource m22311a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteAccountDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteAccountDataSource::class.java)");
        return (RemoteAccountDataSource) a;
    }

    @Singleton
    public static AccountRepository m22312a(BackgroundThread backgroundThread, RemoteAccountDataSource remoteAccountDataSource, LocalAccountDataSource localAccountDataSource) {
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(remoteAccountDataSource, "remote");
        Intrinsics.m26847b(localAccountDataSource, "local");
        return new RedditAccountRepository(backgroundThread, remoteAccountDataSource, localAccountDataSource);
    }

    public static AccountUseCase m22313a(AccountRepository accountRepository) {
        Intrinsics.m26847b(accountRepository, "repository");
        return new AccountUseCase(accountRepository);
    }
}
