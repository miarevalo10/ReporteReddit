package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.comments.CommentRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
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
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.ColorGenerator;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H'J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H'J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u000201H&J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u000205H&J\b\u00106\u001a\u000207H&J\b\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020;H&J\b\u0010<\u001a\u00020=H&J\b\u0010>\u001a\u00020?H&J\b\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020CH&J\b\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020IH&J\b\u0010J\u001a\u00020KH&J\b\u0010L\u001a\u00020MH&J\b\u0010N\u001a\u00020OH&J\b\u0010P\u001a\u00020QH'¨\u0006R"}, d2 = {"Lcom/reddit/frontpage/di/component/UserComponent;", "", "accountFormatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "accountInfoUseCase", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "accountUseCase", "Lcom/reddit/frontpage/domain/usecase/AccountUseCase;", "application", "Landroid/app/Application;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "carouselAnalytics", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "categoryRepository", "Lcom/reddit/frontpage/domain/repository/CategoryRepository;", "colorGenerator", "Lcom/reddit/frontpage/presentation/carousel/ColorGenerator;", "commentRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/CommentRepository;", "context", "Landroid/content/Context;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "karmaRepository", "Lcom/reddit/frontpage/domain/repository/KarmaRepository;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "localCommentDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/LocalCommentDataSource;", "localSearchDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;", "modToolsRepository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "moderatorActions", "Lcom/reddit/frontpage/presentation/listing/common/ModeratorLinkActions;", "numberFormatter", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "profileSettingsAnalyticsContract", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalyticsContract;", "regionRepository", "Lcom/reddit/frontpage/domain/repository/RegionRepository;", "remoteAccountDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/account/datasource/remote/RemoteAccountDataSource;", "remoteCategoryDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/category/datasource/RemoteCategoryDataSource;", "remoteCommentDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/comments/RemoteCommentDataSource;", "remoteKarmaDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/karma/datasource/remote/RemoteKarmaDataSource;", "remoteLinkDatasource", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/RemoteLinkDatasource;", "remoteModToolsDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/modtools/datasource/RemoteModToolsDataSource;", "remoteRedditApiDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "remoteRegionDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/region/remote/RemoteRegionDataSource;", "remoteSubredditDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/datasource/remote/RemoteSubredditDataSource;", "remoteTrophiesDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/trophies/remote/RemoteTrophiesDataSource;", "resourceProvider", "Lcom/reddit/frontpage/domain/common/ResourceProvider;", "searchRepository", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "subscriptionCountRepository", "Lcom/reddit/datalibrary/frontpage/data/feature/subreddit/repo/SubscriptionCountRepository;", "trophiesRepository", "Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "userSharedPreferences", "Landroid/content/SharedPreferences;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserComponent.kt */
public interface UserComponent {
    PreferenceRepository mo4613a();

    AccountRepository mo4614b();

    AccountInfoUseCase mo4615c();

    CarouselAnalytics mo4616d();

    ProfileSettingsAnalyticsContract mo4617e();

    RemoteRedditApiDataSource mo4618f();

    Context mo4619g();

    FrontpageSettings mo4620h();

    SessionManager mo4621i();

    ResourceProvider mo4622j();

    CategoryRepository mo4623k();

    CommentRepository mo4624l();

    NumberFormatter mo4625m();

    AccountFormatter mo4626n();

    ColorGenerator mo4627o();

    LinkRepository mo4628p();

    ModeratorLinkActions mo4629q();

    ModToolsRepository mo4630r();

    RegionRepository mo4631s();

    BackgroundThread mo4632t();

    PostExecutionThread mo4633u();

    SearchRepository mo4634v();

    SubredditRepository mo4635w();

    SubscriptionCountRepository mo4636x();

    KarmaRepository mo4637y();

    TrophiesRepository mo4638z();
}
