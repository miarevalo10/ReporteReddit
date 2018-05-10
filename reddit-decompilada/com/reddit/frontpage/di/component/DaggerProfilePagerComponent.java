package com.reddit.frontpage.di.component;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.DatabaseAccountDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.LocalAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import com.reddit.frontpage.di.module.AccountDataModule;
import com.reddit.frontpage.di.module.AccountDataModule_AccountRepositoryFactory;
import com.reddit.frontpage.di.module.AccountDataModule_AccountUseCaseFactory;
import com.reddit.frontpage.di.module.AccountDataModule_RemoteAccountDataSourceFactory;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.NetworkModule_OauthHttpClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_ProvideMoshiFactory;
import com.reddit.frontpage.di.module.NetworkModule_RetrofitClientFactory;
import com.reddit.frontpage.di.module.RxModule;
import com.reddit.frontpage.di.module.RxModule_BackgroundThreadFactory;
import com.reddit.frontpage.di.module.RxModule_PostExecutionThreadFactory;
import com.reddit.frontpage.di.module.TrophiesDataModule;
import com.reddit.frontpage.di.module.TrophiesDataModule_RemoteTrophiesDataSourceFactory;
import com.reddit.frontpage.di.module.TrophiesDataModule_TrophiesRepositoryFactory;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.ui.profile.ProfilePagerScreen;
import com.reddit.frontpage.ui.profile.ProfilePagerScreen_MembersInjector;
import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerProfilePagerComponent implements ProfilePagerComponent {
    private AccountDataModule f27876a;
    private Provider<BackgroundThread> f27877b;
    private Provider<OkHttpClient> f27878c;
    private Provider<Moshi> f27879d;
    private Provider<Retrofit> f27880e;
    private Provider<RemoteTrophiesDataSource> f27881f;
    private Provider<TrophiesRepository> f27882g;
    private Provider<RemoteAccountDataSource> f27883h;
    private Provider<LocalAccountDataSource> f27884i;
    private Provider<AccountRepository> f27885j;
    private Provider<PostExecutionThread> f27886k;

    public static final class Builder {
        RxModule f20209a;
        NetworkModule f20210b;
        TrophiesDataModule f20211c;
        AccountDataModule f20212d;

        private Builder() {
        }
    }

    private DaggerProfilePagerComponent(Builder builder) {
        this.f27877b = DoubleCheck.m31842a(RxModule_BackgroundThreadFactory.m34527a(builder.f20209a));
        this.f27878c = DoubleCheck.m31842a(NetworkModule_OauthHttpClientFactory.m34508a(builder.f20210b));
        this.f27879d = DoubleCheck.m31842a(NetworkModule_ProvideMoshiFactory.m34510a(builder.f20210b));
        this.f27880e = DoubleCheck.m31842a(NetworkModule_RetrofitClientFactory.m34512a(builder.f20210b, this.f27878c, this.f27879d));
        this.f27881f = DoubleCheck.m31842a(TrophiesDataModule_RemoteTrophiesDataSourceFactory.m34539a(builder.f20211c, this.f27880e));
        this.f27882g = DoubleCheck.m31842a(TrophiesDataModule_TrophiesRepositoryFactory.m34540a(builder.f20211c, this.f27877b, this.f27881f));
        this.f27883h = DoubleCheck.m31842a(AccountDataModule_RemoteAccountDataSourceFactory.m34445a(builder.f20212d, this.f27880e));
        this.f27884i = DoubleCheck.m31842a(DatabaseAccountDataSource_Factory.a());
        this.f27885j = DoubleCheck.m31842a(AccountDataModule_AccountRepositoryFactory.m34443a(builder.f20212d, this.f27877b, this.f27883h, this.f27884i));
        this.f27876a = builder.f20212d;
        this.f27886k = DoubleCheck.m31842a(RxModule_PostExecutionThreadFactory.m34528a(builder.f20209a));
    }

    public static ProfilePagerComponent m29251a() {
        Builder builder = new Builder();
        if (builder.f20209a == null) {
            builder.f20209a = new RxModule();
        }
        if (builder.f20210b == null) {
            builder.f20210b = new NetworkModule();
        }
        if (builder.f20211c == null) {
            builder.f20211c = new TrophiesDataModule();
        }
        if (builder.f20212d == null) {
            builder.f20212d = new AccountDataModule();
        }
        return new DaggerProfilePagerComponent(builder);
    }

    public final void mo4725a(ProfilePagerScreen profilePagerScreen) {
        ProfilePagerScreen_MembersInjector.m30332a(profilePagerScreen, (TrophiesRepository) this.f27882g.get());
        ProfilePagerScreen_MembersInjector.m30331a(profilePagerScreen, (AccountRepository) this.f27885j.get());
        ProfilePagerScreen_MembersInjector.m30333a(profilePagerScreen, AccountDataModule_AccountUseCaseFactory.m34444a((AccountRepository) this.f27885j.get()));
        ProfilePagerScreen_MembersInjector.m30330a(profilePagerScreen, (PostExecutionThread) this.f27886k.get());
    }
}
