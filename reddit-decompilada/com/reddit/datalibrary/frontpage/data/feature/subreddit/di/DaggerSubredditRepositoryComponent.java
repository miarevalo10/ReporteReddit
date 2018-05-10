package com.reddit.datalibrary.frontpage.data.feature.subreddit.di;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.legacy.C1687x8b8952c8;
import com.reddit.datalibrary.frontpage.data.feature.legacy.C1688xbb4c52fd;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditDataSourceModule;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.RedditLocalSubredditDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider;
import com.reddit.datalibrary.frontpage.data.provider.MultiredditCommunitiesProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.SubredditLoaderProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditLoaderProvider_MembersInjector;
import com.reddit.datalibrary.frontpage.data.provider.SubredditNameInfoProvider;
import com.reddit.datalibrary.frontpage.data.provider.SubredditNameInfoProvider_MembersInjector;
import com.reddit.frontpage.di.module.ApplicationModule;
import com.reddit.frontpage.di.module.ApplicationModule_ContextFactory;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.NetworkModule_OauthHttpClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_ProvideMoshiFactory;
import com.reddit.frontpage.di.module.NetworkModule_RetrofitClientFactory;
import com.reddit.frontpage.di.module.RxModule;
import com.reddit.frontpage.di.module.RxModule_BackgroundThreadFactory;
import com.reddit.frontpage.di.module.SubredditDataModule;
import com.reddit.frontpage.di.module.SubredditDataModule_RemoteSubredditDataSourceFactory;
import com.reddit.frontpage.di.module.SubredditDataModule_SubredditRepositoryFactory;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.sync.routine.SubredditSyncRoutine;
import com.reddit.frontpage.sync.routine.SubredditSyncRoutine_MembersInjector;
import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerSubredditRepositoryComponent implements SubredditRepositoryComponent {
    private Provider<LegacyRemoteSubredditDataSource> f16169a;
    private Provider<LegacyLocalSubredditDataSource> f16170b;
    private Provider<LegacySubredditRepository> f16171c;
    private Provider<BackgroundThread> f16172d;
    private Provider<OkHttpClient> f16173e;
    private Provider<Moshi> f16174f;
    private Provider<Retrofit> f16175g;
    private Provider<RemoteSubredditDataSource> f16176h;
    private Provider<Context> f16177i;
    private RedditLocalSubredditDataSource_Factory f16178j;
    private Provider<LocalSubredditDataSource> f16179k;
    private Provider<SubredditRepository> f16180l;

    public static final class Builder {
        public LegacySubredditDataSourceModule f10774a;
        public SubredditRepositoryModule f10775b;
        public RxModule f10776c;
        public NetworkModule f10777d;
        public SubredditDataModule f10778e;
        public ApplicationModule f10779f;

        private Builder() {
        }
    }

    private DaggerSubredditRepositoryComponent(Builder builder) {
        this.f16169a = DoubleCheck.a(C1688xbb4c52fd.m19672a(builder.f10774a));
        this.f16170b = DoubleCheck.a(C1687x8b8952c8.m19671a(builder.f10774a));
        this.f16171c = DoubleCheck.a(SubredditRepositoryModule_ProvideLinkRepositoryFactory.m19696a(builder.f10775b, this.f16169a, this.f16170b));
        this.f16172d = DoubleCheck.a(RxModule_BackgroundThreadFactory.a(builder.f10776c));
        this.f16173e = DoubleCheck.a(NetworkModule_OauthHttpClientFactory.a(builder.f10777d));
        this.f16174f = DoubleCheck.a(NetworkModule_ProvideMoshiFactory.a(builder.f10777d));
        this.f16175g = DoubleCheck.a(NetworkModule_RetrofitClientFactory.a(builder.f10777d, this.f16173e, this.f16174f));
        this.f16176h = DoubleCheck.a(SubredditDataModule_RemoteSubredditDataSourceFactory.a(builder.f10778e, this.f16175g));
        this.f16177i = DoubleCheck.a(ApplicationModule_ContextFactory.a(builder.f10779f));
        this.f16178j = RedditLocalSubredditDataSource_Factory.m19695a(this.f16174f, this.f16177i);
        this.f16179k = DoubleCheck.a(this.f16178j);
        this.f16180l = DoubleCheck.a(SubredditDataModule_SubredditRepositoryFactory.a(builder.f10778e, this.f16172d, this.f16176h, this.f16179k));
    }

    public static Builder m16162a() {
        return new Builder();
    }

    public final void mo3001a(SubredditSyncRoutine subredditSyncRoutine) {
        SubredditSyncRoutine_MembersInjector.a(subredditSyncRoutine, (LegacySubredditRepository) this.f16171c.get());
        SubredditSyncRoutine_MembersInjector.a(subredditSyncRoutine, (SubredditRepository) this.f16180l.get());
    }

    public final void mo2999a(SubredditLoaderProvider subredditLoaderProvider) {
        SubredditLoaderProvider_MembersInjector.m16292a(subredditLoaderProvider, (LegacySubredditRepository) this.f16171c.get());
    }

    public final void mo2998a(MultiredditCommunitiesProvider multiredditCommunitiesProvider) {
        MultiredditCommunitiesProvider_MembersInjector.m16287a(multiredditCommunitiesProvider, (LegacySubredditRepository) this.f16171c.get());
    }

    public final void mo3000a(SubredditNameInfoProvider subredditNameInfoProvider) {
        SubredditNameInfoProvider_MembersInjector.m16295a(subredditNameInfoProvider, (LegacySubredditRepository) this.f16171c.get());
    }
}
