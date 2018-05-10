package com.reddit.frontpage.di.component;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.DatabaseAccountDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.LocalAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.category.datasource.RemoteCategoryDataSource;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.datalibrary.frontpage.data.feature.comments.LocalCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.comments.RemoteCommentDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local.FileKarmaDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local.LocalKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote.RemoteKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.FileLinkDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.datasource.SharedPrefsRegionDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.region.local.LocalRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.remote.RemoteRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.search.LocalSearchDataSource;
import com.reddit.datalibrary.frontpage.data.feature.search.RemoteSearchDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.UserSettingsStorage.UserSettings;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.RedditLocalSubredditDataSource_Factory;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.AccountDataModule;
import com.reddit.frontpage.di.module.AccountDataModule_AccountRepositoryFactory;
import com.reddit.frontpage.di.module.AccountDataModule_RemoteAccountDataSourceFactory;
import com.reddit.frontpage.di.module.AnalyticsModule;
import com.reddit.frontpage.di.module.AnalyticsModule_CarouselAnalyticsFactory;
import com.reddit.frontpage.di.module.AnalyticsModule_ProfileSettingsAnalyticsFactory;
import com.reddit.frontpage.di.module.ApiClientModule;
import com.reddit.frontpage.di.module.ApiClientModule_ProvideRemoteRedditApiDataSourceFactory;
import com.reddit.frontpage.di.module.ApplicationModule;
import com.reddit.frontpage.di.module.ApplicationModule_ApplicationFactory;
import com.reddit.frontpage.di.module.ApplicationModule_ApplicationSharedPreferencesFactory;
import com.reddit.frontpage.di.module.ApplicationModule_ContextFactory;
import com.reddit.frontpage.di.module.ApplicationModule_ProvideFrontpageSettingsFactory;
import com.reddit.frontpage.di.module.ApplicationModule_ResourceProviderFactory;
import com.reddit.frontpage.di.module.ApplicationModule_SessionFactory;
import com.reddit.frontpage.di.module.ApplicationModule_SessionManagerFactory;
import com.reddit.frontpage.di.module.CategoryDataModule;
import com.reddit.frontpage.di.module.CategoryDataModule_CategoryRepositoryFactory;
import com.reddit.frontpage.di.module.CategoryDataModule_RemoteCategoryDataSourceFactory;
import com.reddit.frontpage.di.module.CommentDataModule;
import com.reddit.frontpage.di.module.CommentDataModule_ProvideCommentRepositoryFactory;
import com.reddit.frontpage.di.module.CommentDataModule_ProvideDatabaseCommentDataSourceFactory;
import com.reddit.frontpage.di.module.CommentDataModule_ProvideRemoteCommentDataSourceFactory;
import com.reddit.frontpage.di.module.FormatterModule;
import com.reddit.frontpage.di.module.FormatterModule_AccountFormatterFactory;
import com.reddit.frontpage.di.module.FormatterModule_SubredditFormatterFactory;
import com.reddit.frontpage.di.module.GeneratorModule;
import com.reddit.frontpage.di.module.GeneratorModule_CarouselColorGeneratorFactory;
import com.reddit.frontpage.di.module.LinkDataModule;
import com.reddit.frontpage.di.module.LinkDataModule_ProvideDatabaseLinkDatasourceFactory;
import com.reddit.frontpage.di.module.LinkDataModule_ProvideLinkRepositoryFactory;
import com.reddit.frontpage.di.module.LinkDataModule_ProvideRemoteLinkDatasourceFactory;
import com.reddit.frontpage.di.module.LinkModule;
import com.reddit.frontpage.di.module.LinkModule_ModeratorActionsFactory;
import com.reddit.frontpage.di.module.ModToolsDataModule;
import com.reddit.frontpage.di.module.ModToolsDataModule_ModToolsRepositoryFactory;
import com.reddit.frontpage.di.module.ModToolsDataModule_RemoteModToolsDataSourceFactory;
import com.reddit.frontpage.di.module.NetworkModule;
import com.reddit.frontpage.di.module.NetworkModule_OauthHttpClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_ProvideMoshiFactory;
import com.reddit.frontpage.di.module.NetworkModule_ProvideObservableWebSocketClientFactory;
import com.reddit.frontpage.di.module.NetworkModule_RetrofitClientFactory;
import com.reddit.frontpage.di.module.RegionDataModule;
import com.reddit.frontpage.di.module.RegionDataModule_AccountRepositoryFactory;
import com.reddit.frontpage.di.module.RegionDataModule_RemoteAccountDataSourceFactory;
import com.reddit.frontpage.di.module.RxModule;
import com.reddit.frontpage.di.module.RxModule_BackgroundThreadFactory;
import com.reddit.frontpage.di.module.RxModule_PostExecutionThreadFactory;
import com.reddit.frontpage.di.module.SearchDataModule;
import com.reddit.frontpage.di.module.SearchDataModule_RemoteFactory;
import com.reddit.frontpage.di.module.SubredditDataModule;
import com.reddit.frontpage.di.module.SubredditDataModule_ProvideSubscriptionCountRepositoryFactory;
import com.reddit.frontpage.di.module.SubredditDataModule_RemoteSubredditDataSourceFactory;
import com.reddit.frontpage.di.module.SubredditDataModule_SubredditRepositoryFactory;
import com.reddit.frontpage.di.module.TopKarmaDataModule;
import com.reddit.frontpage.di.module.TopKarmaDataModule_KarmaRepositoryFactory;
import com.reddit.frontpage.di.module.TopKarmaDataModule_RemoteKarmaDataSourceFactory;
import com.reddit.frontpage.di.module.TrophiesDataModule;
import com.reddit.frontpage.di.module.TrophiesDataModule_RemoteTrophiesDataSourceFactory;
import com.reddit.frontpage.di.module.TrophiesDataModule_TrophiesRepositoryFactory;
import com.reddit.frontpage.di.module.UserPreferenceDataModule;
import com.reddit.frontpage.di.module.UserPreferenceDataModule_PreferenceRepositoryFactory;
import com.reddit.frontpage.di.module.UserPreferenceDataModule_UserSettingsFactory;
import com.reddit.frontpage.di.module.UserPreferenceDataModule_UserSharedPreferencesFactory;
import com.reddit.frontpage.di.module.UserPreferenceDataModule_UsernameFactory;
import com.reddit.frontpage.di.module.UserSearchDataModule;
import com.reddit.frontpage.di.module.UserSearchDataModule_LocalSearchDataSourceFactory;
import com.reddit.frontpage.di.module.UserSearchDataModule_SearchRepositoryFactory;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase_Factory;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.ColorGenerator;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import com.squareup.moshi.Moshi;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerBaseComponent implements BaseComponent {
    private Provider<AccountFormatter> f27526A;
    private Provider<ColorGenerator> f27527B;
    private Provider<RemoteLinkDatasource> f27528C;
    private FileLinkDataSource_Factory f27529D;
    private Provider<LocalLinkDataSource> f27530E;
    private Provider<LinkRepository> f27531F;
    private Provider<PostExecutionThread> f27532G;
    private Provider<ModeratorLinkActions> f27533H;
    private Provider<RemoteModToolsDataSource> f27534I;
    private Provider<ModToolsRepository> f27535J;
    private Provider<RemoteRegionDataSource> f27536K;
    private ApplicationModule_ApplicationSharedPreferencesFactory f27537L;
    private SharedPrefsRegionDataSource_Factory f27538M;
    private Provider<LocalRegionDataSource> f27539N;
    private Provider<RegionRepository> f27540O;
    private Provider<RemoteSearchDataSource> f27541P;
    private Provider<RemoteSubredditDataSource> f27542Q;
    private RedditLocalSubredditDataSource_Factory f27543R;
    private Provider<LocalSubredditDataSource> f27544S;
    private Provider<SubredditRepository> f27545T;
    private Provider<SubscriptionCountRepository> f27546U;
    private Provider<RemoteKarmaDataSource> f27547V;
    private FileKarmaDataSource_Factory f27548W;
    private Provider<LocalKarmaDataSource> f27549X;
    private Provider<KarmaRepository> f27550Y;
    private Provider<RemoteTrophiesDataSource> f27551Z;
    private AccountDataModule f27552a;
    private Provider<TrophiesRepository> aa;
    private Provider<Context> f27553b;
    private Provider<SessionManager> f27554c;
    private ApplicationModule_SessionFactory f27555d;
    private Provider<Application> f27556e;
    private Provider<BackgroundThread> f27557f;
    private Provider<OkHttpClient> f27558g;
    private Provider<Moshi> f27559h;
    private Provider<Retrofit> f27560i;
    private Provider<RemoteAccountDataSource> f27561j;
    private Provider<LocalAccountDataSource> f27562k;
    private Provider<AccountRepository> f27563l;
    private Provider<AccountInfoUseCase> f27564m;
    private Provider<CarouselAnalytics> f27565n;
    private Provider<ProfileSettingsAnalyticsContract> f27566o;
    private Provider<RemoteRedditApiDataSource> f27567p;
    private Provider<FrontpageSettings> f27568q;
    private Provider<ResourceProvider> f27569r;
    private Provider<RemoteCategoryDataSource> f27570s;
    private Provider<CategoryRepository> f27571t;
    private Provider<RemoteCommentDataSource> f27572u;
    private Provider<LocalCommentDataSource> f27573v;
    private Provider<LocalLinkDataSource> f27574w;
    private Provider<ObservableWebSocketClient> f27575x;
    private Provider<CommentRepository> f27576y;
    private Provider<NumberFormatter> f27577z;

    public static final class Builder {
        public ApplicationModule f20164a;
        public RxModule f20165b;
        public NetworkModule f20166c;
        public AccountDataModule f20167d;
        public AnalyticsModule f20168e;
        public ApiClientModule f20169f;
        public CategoryDataModule f20170g;
        public CommentDataModule f20171h;
        public LinkDataModule f20172i;
        public FormatterModule f20173j;
        public GeneratorModule f20174k;
        public LinkModule f20175l;
        public ModToolsDataModule f20176m;
        public RegionDataModule f20177n;
        public SearchDataModule f20178o;
        public SubredditDataModule f20179p;
        public TopKarmaDataModule f20180q;
        public TrophiesDataModule f20181r;

        private Builder() {
        }
    }

    private final class UserComponentImpl implements UserComponent {
        final /* synthetic */ DaggerBaseComponent f27517a;
        private final UserPreferenceDataModule f27518b;
        private final UserSearchDataModule f27519c;
        private Provider<String> f27520d;
        private Provider<SharedPreferences> f27521e;
        private Provider<UserSettings> f27522f;
        private Provider<PreferenceRepository> f27523g;
        private Provider<LocalSearchDataSource> f27524h;
        private Provider<SearchRepository> f27525i;

        private UserComponentImpl(DaggerBaseComponent daggerBaseComponent, UserPreferenceDataModule userPreferenceDataModule) {
            this.f27517a = daggerBaseComponent;
            this.f27518b = (UserPreferenceDataModule) Preconditions.m26012a(userPreferenceDataModule);
            this.f27519c = new UserSearchDataModule();
            this.f27520d = DoubleCheck.m31842a(UserPreferenceDataModule_UsernameFactory.m34546a(this.f27518b, this.f27517a.f27555d));
            this.f27521e = DoubleCheck.m31842a(UserPreferenceDataModule_UserSharedPreferencesFactory.m34545a(this.f27518b, this.f27520d, this.f27517a.f27556e));
            this.f27522f = DoubleCheck.m31842a(UserPreferenceDataModule_UserSettingsFactory.m34544a(this.f27518b, this.f27520d));
            this.f27523g = DoubleCheck.m31842a(UserPreferenceDataModule_PreferenceRepositoryFactory.m34543a(this.f27518b, this.f27517a.f27553b, this.f27521e, this.f27522f, this.f27517a.f27557f));
            this.f27524h = DoubleCheck.m31842a(UserSearchDataModule_LocalSearchDataSourceFactory.m34547a(this.f27519c, this.f27521e));
            this.f27525i = DoubleCheck.m31842a(UserSearchDataModule_SearchRepositoryFactory.m34548a(this.f27519c, this.f27517a.f27557f, this.f27517a.f27541P, this.f27524h));
        }

        public final PreferenceRepository mo4613a() {
            return (PreferenceRepository) this.f27523g.get();
        }

        public final AccountRepository mo4614b() {
            return (AccountRepository) this.f27517a.f27563l.get();
        }

        public final AccountInfoUseCase mo4615c() {
            return (AccountInfoUseCase) this.f27517a.f27564m.get();
        }

        public final CarouselAnalytics mo4616d() {
            return (CarouselAnalytics) this.f27517a.f27565n.get();
        }

        public final ProfileSettingsAnalyticsContract mo4617e() {
            return (ProfileSettingsAnalyticsContract) this.f27517a.f27566o.get();
        }

        public final RemoteRedditApiDataSource mo4618f() {
            return (RemoteRedditApiDataSource) this.f27517a.f27567p.get();
        }

        public final Context mo4619g() {
            return (Context) this.f27517a.f27553b.get();
        }

        public final FrontpageSettings mo4620h() {
            return (FrontpageSettings) this.f27517a.f27568q.get();
        }

        public final SessionManager mo4621i() {
            return (SessionManager) this.f27517a.f27554c.get();
        }

        public final ResourceProvider mo4622j() {
            return (ResourceProvider) this.f27517a.f27569r.get();
        }

        public final CategoryRepository mo4623k() {
            return (CategoryRepository) this.f27517a.f27571t.get();
        }

        public final CommentRepository mo4624l() {
            return (CommentRepository) this.f27517a.f27576y.get();
        }

        public final NumberFormatter mo4625m() {
            return (NumberFormatter) this.f27517a.f27577z.get();
        }

        public final AccountFormatter mo4626n() {
            return (AccountFormatter) this.f27517a.f27526A.get();
        }

        public final ColorGenerator mo4627o() {
            return (ColorGenerator) this.f27517a.f27527B.get();
        }

        public final LinkRepository mo4628p() {
            return (LinkRepository) this.f27517a.f27531F.get();
        }

        public final ModeratorLinkActions mo4629q() {
            return (ModeratorLinkActions) this.f27517a.f27533H.get();
        }

        public final ModToolsRepository mo4630r() {
            return (ModToolsRepository) this.f27517a.f27535J.get();
        }

        public final RegionRepository mo4631s() {
            return (RegionRepository) this.f27517a.f27540O.get();
        }

        public final BackgroundThread mo4632t() {
            return (BackgroundThread) this.f27517a.f27557f.get();
        }

        public final PostExecutionThread mo4633u() {
            return (PostExecutionThread) this.f27517a.f27532G.get();
        }

        public final SearchRepository mo4634v() {
            return (SearchRepository) this.f27525i.get();
        }

        public final SubredditRepository mo4635w() {
            return (SubredditRepository) this.f27517a.f27545T.get();
        }

        public final SubscriptionCountRepository mo4636x() {
            return (SubscriptionCountRepository) this.f27517a.f27546U.get();
        }

        public final KarmaRepository mo4637y() {
            return (KarmaRepository) this.f27517a.f27550Y.get();
        }

        public final TrophiesRepository mo4638z() {
            return (TrophiesRepository) this.f27517a.aa.get();
        }
    }

    private DaggerBaseComponent(Builder builder) {
        this.f27553b = DoubleCheck.m31842a(ApplicationModule_ContextFactory.m34462a(builder.f20164a));
        this.f27554c = DoubleCheck.m31842a(ApplicationModule_SessionManagerFactory.m34466a(builder.f20164a));
        this.f27555d = ApplicationModule_SessionFactory.m34465a(builder.f20164a, this.f27554c);
        this.f27556e = DoubleCheck.m31842a(ApplicationModule_ApplicationFactory.m34460a(builder.f20164a));
        this.f27557f = DoubleCheck.m31842a(RxModule_BackgroundThreadFactory.m34527a(builder.f20165b));
        this.f27558g = DoubleCheck.m31842a(NetworkModule_OauthHttpClientFactory.m34508a(builder.f20166c));
        this.f27559h = DoubleCheck.m31842a(NetworkModule_ProvideMoshiFactory.m34510a(builder.f20166c));
        this.f27560i = DoubleCheck.m31842a(NetworkModule_RetrofitClientFactory.m34512a(builder.f20166c, this.f27558g, this.f27559h));
        this.f27561j = DoubleCheck.m31842a(AccountDataModule_RemoteAccountDataSourceFactory.m34445a(builder.f20167d, this.f27560i));
        this.f27562k = DoubleCheck.m31842a(DatabaseAccountDataSource_Factory.a());
        this.f27563l = DoubleCheck.m31842a(AccountDataModule_AccountRepositoryFactory.m34443a(builder.f20167d, this.f27557f, this.f27561j, this.f27562k));
        this.f27552a = builder.f20167d;
        this.f27564m = DoubleCheck.m31842a(AccountInfoUseCase_Factory.m34554a(this.f27563l));
        this.f27565n = DoubleCheck.m31842a(AnalyticsModule_CarouselAnalyticsFactory.m34455a(builder.f20168e));
        this.f27566o = DoubleCheck.m31842a(AnalyticsModule_ProfileSettingsAnalyticsFactory.m34456a(builder.f20168e));
        this.f27567p = DoubleCheck.m31842a(ApiClientModule_ProvideRemoteRedditApiDataSourceFactory.m34458a(builder.f20169f));
        this.f27568q = DoubleCheck.m31842a(ApplicationModule_ProvideFrontpageSettingsFactory.m34463a(builder.f20164a));
        this.f27569r = DoubleCheck.m31842a(ApplicationModule_ResourceProviderFactory.m34464a(builder.f20164a, this.f27553b));
        this.f27570s = DoubleCheck.m31842a(CategoryDataModule_RemoteCategoryDataSourceFactory.m34471a(builder.f20170g, this.f27560i));
        this.f27571t = DoubleCheck.m31842a(CategoryDataModule_CategoryRepositoryFactory.m34470a(builder.f20170g, this.f27557f, this.f27570s));
        this.f27572u = DoubleCheck.m31842a(CommentDataModule_ProvideRemoteCommentDataSourceFactory.m34474a(builder.f20171h, this.f27560i));
        this.f27573v = DoubleCheck.m31842a(CommentDataModule_ProvideDatabaseCommentDataSourceFactory.m34473a(builder.f20171h));
        this.f27574w = DoubleCheck.m31842a(LinkDataModule_ProvideDatabaseLinkDatasourceFactory.m34492a(builder.f20172i, this.f27559h));
        this.f27575x = DoubleCheck.m31842a(NetworkModule_ProvideObservableWebSocketClientFactory.m34511a(builder.f20166c, this.f27558g));
        this.f27576y = DoubleCheck.m31842a(CommentDataModule_ProvideCommentRepositoryFactory.m34472a(builder.f20171h, this.f27572u, this.f27573v, this.f27574w, this.f27557f, this.f27575x));
        this.f27577z = DoubleCheck.m31842a(FormatterModule_SubredditFormatterFactory.m34478a(builder.f20173j));
        this.f27526A = DoubleCheck.m31842a(FormatterModule_AccountFormatterFactory.m34477a(builder.f20173j, this.f27553b));
        this.f27527B = DoubleCheck.m31842a(GeneratorModule_CarouselColorGeneratorFactory.m34482a(builder.f20174k, this.f27553b, this.f27568q));
        this.f27528C = DoubleCheck.m31842a(LinkDataModule_ProvideRemoteLinkDatasourceFactory.m34494a(builder.f20172i, this.f27560i));
        this.f27529D = FileLinkDataSource_Factory.a(this.f27559h, this.f27553b);
        this.f27530E = DoubleCheck.m31842a(this.f27529D);
        this.f27531F = DoubleCheck.m31842a(LinkDataModule_ProvideLinkRepositoryFactory.m34493a(builder.f20172i, this.f27557f, this.f27528C, this.f27530E, this.f27574w));
        this.f27532G = DoubleCheck.m31842a(RxModule_PostExecutionThreadFactory.m34528a(builder.f20165b));
        this.f27533H = DoubleCheck.m31842a(LinkModule_ModeratorActionsFactory.m34497a(builder.f20175l, this.f27531F, this.f27532G));
        this.f27534I = DoubleCheck.m31842a(ModToolsDataModule_RemoteModToolsDataSourceFactory.m34503a(builder.f20176m, this.f27560i));
        this.f27535J = DoubleCheck.m31842a(ModToolsDataModule_ModToolsRepositoryFactory.m34502a(builder.f20176m, this.f27557f, this.f27534I));
        this.f27536K = DoubleCheck.m31842a(RegionDataModule_RemoteAccountDataSourceFactory.m34525a(builder.f20177n, this.f27560i));
        this.f27537L = ApplicationModule_ApplicationSharedPreferencesFactory.m34461a(builder.f20164a);
        this.f27538M = SharedPrefsRegionDataSource_Factory.a(this.f27559h, this.f27537L);
        this.f27539N = DoubleCheck.m31842a(this.f27538M);
        this.f27540O = DoubleCheck.m31842a(RegionDataModule_AccountRepositoryFactory.m34524a(builder.f20177n, this.f27557f, this.f27536K, this.f27539N));
        this.f27541P = DoubleCheck.m31842a(SearchDataModule_RemoteFactory.m34529a(builder.f20178o, this.f27560i));
        this.f27542Q = DoubleCheck.m31842a(SubredditDataModule_RemoteSubredditDataSourceFactory.m34531a(builder.f20179p, this.f27560i));
        this.f27543R = RedditLocalSubredditDataSource_Factory.a(this.f27559h, this.f27553b);
        this.f27544S = DoubleCheck.m31842a(this.f27543R);
        this.f27545T = DoubleCheck.m31842a(SubredditDataModule_SubredditRepositoryFactory.m34532a(builder.f20179p, this.f27557f, this.f27542Q, this.f27544S));
        this.f27546U = DoubleCheck.m31842a(SubredditDataModule_ProvideSubscriptionCountRepositoryFactory.m34530a(builder.f20179p));
        this.f27547V = DoubleCheck.m31842a(TopKarmaDataModule_RemoteKarmaDataSourceFactory.m34538a(builder.f20180q, this.f27560i));
        this.f27548W = FileKarmaDataSource_Factory.a(this.f27559h, this.f27553b);
        this.f27549X = DoubleCheck.m31842a(this.f27548W);
        this.f27550Y = DoubleCheck.m31842a(TopKarmaDataModule_KarmaRepositoryFactory.m34537a(builder.f20180q, this.f27557f, this.f27547V, this.f27549X));
        this.f27551Z = DoubleCheck.m31842a(TrophiesDataModule_RemoteTrophiesDataSourceFactory.m34539a(builder.f20181r, this.f27560i));
        this.aa = DoubleCheck.m31842a(TrophiesDataModule_TrophiesRepositoryFactory.m34540a(builder.f20181r, this.f27557f, this.f27551Z));
    }

    public static Builder m29061a() {
        return new Builder();
    }

    public final UserComponent mo4639a(UserPreferenceDataModule userPreferenceDataModule) {
        return new UserComponentImpl(userPreferenceDataModule);
    }
}
