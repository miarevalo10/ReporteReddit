package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.AdsAnalyticsModule;
import com.reddit.frontpage.di.module.AdsAnalyticsModule_AdsVisibilityTrackerFactory;
import com.reddit.frontpage.di.module.AdsModule;
import com.reddit.frontpage.di.module.AdsModule_ProvideAdsLoaderFactoryFactory;
import com.reddit.frontpage.di.module.AdsModule_ProvideAdsRepoFactory;
import com.reddit.frontpage.di.module.FrontpageViewModule;
import com.reddit.frontpage.di.module.FrontpageViewModule_AdsActionsFactory;
import com.reddit.frontpage.di.module.FrontpageViewModule_CarouselActionsFactory;
import com.reddit.frontpage.di.module.FrontpageViewModule_LinkActionsFactory;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase_Factory;
import com.reddit.frontpage.domain.usecase.FrontpageLoadData;
import com.reddit.frontpage.domain.usecase.FrontpageLoadData_Factory;
import com.reddit.frontpage.domain.usecase.FrontpageRefreshData;
import com.reddit.frontpage.domain.usecase.FrontpageRefreshData_Factory;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase;
import com.reddit.frontpage.domain.usecase.ListingSortUseCase_Factory;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.listing.FrontpageListingScreen;
import com.reddit.frontpage.presentation.listing.FrontpageListingScreen_MembersInjector;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen_MembersInjector;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ListingScreenActions;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.RedditListingNavigator_Factory;
import com.reddit.frontpage.presentation.listing.common.RedditListingScreenActions_Factory;
import com.reddit.frontpage.presentation.listing.common.RedditListingViewActions_Factory;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingContract.View;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter_Factory;
import com.reddit.frontpage.presentation.listing.frontpage.RedditFrontpageNavigator;
import com.reddit.frontpage.presentation.listing.frontpage.RedditFrontpageNavigator_Factory;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerFrontpageComponent implements FrontpageComponent {
    private C2264xdbdd5b83 f27642A;
    private Provider<CarouselActions> f27643B;
    private Provider<DiffListingUseCase> f27644C;
    private Provider<Parameters> f27645D;
    private Provider<FrontpageListingPresenter> f27646E;
    private Provider<ListingViewActions> f27647F;
    private UserComponent f27648a;
    private Provider<ListingScreenActions> f27649b;
    private Provider<Lazy<? extends Activity>> f27650c;
    private Provider<AdVisibilityTracker> f27651d;
    private Provider<View> f27652e;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27653f;
    private Provider<Lazy<? extends Context>> f27654g;
    private Provider<String> f27655h;
    private RedditListingNavigator_Factory f27656i;
    private Provider<ListingNavigator> f27657j;
    private Provider<RedditFrontpageNavigator> f27658k;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27659l;
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27660m;
    private C2263x822ff5bc f27661n;
    private com_reddit_frontpage_di_component_UserComponent_context f27662o;
    private AdsModule_ProvideAdsLoaderFactoryFactory f27663p;
    private Provider<AdsRepository> f27664q;
    private Provider<FrontpageLoadData> f27665r;
    private Provider<FrontpageRefreshData> f27666s;
    private Provider<UserLinkActions> f27667t;
    private com_reddit_frontpage_di_component_UserComponent_moderatorActions f27668u;
    private Provider<AdsActions> f27669v;
    private C2265xab6fc1a4 f27670w;
    private Provider<ListingSortUseCase> f27671x;
    private C2266x11a20b89 f27672y;
    private C2262xddb86f47 f27673z;

    private static final class Builder implements com.reddit.frontpage.di.component.FrontpageComponent.Builder {
        private AdsAnalyticsModule f27623a;
        private AdsModule f27624b;
        private FrontpageViewModule f27625c;
        private UserComponent f27626d;
        private View f27627e;
        private Lazy<? extends Context> f27628f;
        private Lazy<? extends Activity> f27629g;
        private String f27630h;
        private Parameters f27631i;

        private Builder() {
        }

        public final FrontpageComponent mo4658a() {
            if (this.f27623a == null) {
                this.f27623a = new AdsAnalyticsModule();
            }
            if (this.f27624b == null) {
                this.f27624b = new AdsModule();
            }
            if (this.f27625c == null) {
                this.f27625c = new FrontpageViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27626d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27627e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27628f == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27629g == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27630h == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27631i != null) {
                return new DaggerFrontpageComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final /* synthetic */ com.reddit.frontpage.di.component.FrontpageComponent.Builder mo4659b(Lazy lazy) {
            this.f27628f = (Lazy) Preconditions.m26012a(lazy);
            return this;
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27632a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27632a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27632a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2262xddb86f47 implements Provider<CarouselAnalytics> {
        private final UserComponent f27633a;

        C2262xddb86f47(UserComponent userComponent) {
            this.f27633a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (CarouselAnalytics) Preconditions.m26013a(this.f27633a.mo4616d(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_context implements Provider<Context> {
        private final UserComponent f27634a;

        com_reddit_frontpage_di_component_UserComponent_context(UserComponent userComponent) {
            this.f27634a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (Context) Preconditions.m26013a(this.f27634a.mo4619g(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2263x822ff5bc implements Provider<FrontpageSettings> {
        private final UserComponent f27635a;

        C2263x822ff5bc(UserComponent userComponent) {
            this.f27635a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (FrontpageSettings) Preconditions.m26013a(this.f27635a.mo4620h(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27636a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27636a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27636a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_moderatorActions implements Provider<ModeratorLinkActions> {
        private final UserComponent f27637a;

        com_reddit_frontpage_di_component_UserComponent_moderatorActions(UserComponent userComponent) {
            this.f27637a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (ModeratorLinkActions) Preconditions.m26013a(this.f27637a.mo4629q(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2264xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27638a;

        C2264xdbdd5b83(UserComponent userComponent) {
            this.f27638a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27638a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2265xab6fc1a4 implements Provider<PreferenceRepository> {
        private final UserComponent f27639a;

        C2265xab6fc1a4(UserComponent userComponent) {
            this.f27639a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PreferenceRepository) Preconditions.m26013a(this.f27639a.mo4613a(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27640a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27640a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27640a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2266x11a20b89 implements Provider<SubredditRepository> {
        private final UserComponent f27641a;

        C2266x11a20b89(UserComponent userComponent) {
            this.f27641a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SubredditRepository) Preconditions.m26013a(this.f27641a.mo4635w(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerFrontpageComponent(Builder builder) {
        this.f27648a = builder.f27626d;
        this.f27649b = DoubleCheck.m31842a(RedditListingScreenActions_Factory.m34713a());
        this.f27650c = InstanceFactory.m35583a(builder.f27629g);
        this.f27651d = DoubleCheck.m31842a(AdsAnalyticsModule_AdsVisibilityTrackerFactory.m34451a(builder.f27623a, this.f27650c));
        this.f27652e = InstanceFactory.m35583a(builder.f27627e);
        this.f27653f = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27626d);
        this.f27654g = InstanceFactory.m35583a(builder.f27628f);
        this.f27655h = InstanceFactory.m35583a(builder.f27630h);
        this.f27656i = RedditListingNavigator_Factory.m34712a(this.f27654g, this.f27655h, this.f27653f, AdsNavigator_Factory.m35105a());
        this.f27657j = DoubleCheck.m31842a(this.f27656i);
        this.f27658k = DoubleCheck.m31842a(RedditFrontpageNavigator_Factory.m34723a());
        this.f27659l = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27626d);
        this.f27660m = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f27626d);
        this.f27661n = new C2263x822ff5bc(builder.f27626d);
        this.f27662o = new com_reddit_frontpage_di_component_UserComponent_context(builder.f27626d);
        this.f27663p = AdsModule_ProvideAdsLoaderFactoryFactory.m34452a(builder.f27624b);
        this.f27664q = DoubleCheck.m31842a(AdsModule_ProvideAdsRepoFactory.m34453a(builder.f27624b, this.f27661n, this.f27662o, this.f27660m, this.f27663p));
        this.f27665r = DoubleCheck.m31842a(FrontpageLoadData_Factory.m34559a(this.f27659l, this.f27660m, this.f27664q, this.f27661n, this.f27653f));
        this.f27666s = DoubleCheck.m31842a(FrontpageRefreshData_Factory.m34562a(this.f27659l, this.f27664q, this.f27660m, this.f27661n, this.f27653f));
        this.f27667t = DoubleCheck.m31842a(FrontpageViewModule_LinkActionsFactory.m34481a(builder.f27625c, this.f27657j, this.f27653f, AdsNavigator_Factory.m35105a()));
        this.f27668u = new com_reddit_frontpage_di_component_UserComponent_moderatorActions(builder.f27626d);
        this.f27669v = DoubleCheck.m31842a(FrontpageViewModule_AdsActionsFactory.m34479a(builder.f27625c, this.f27661n));
        this.f27670w = new C2265xab6fc1a4(builder.f27626d);
        this.f27671x = DoubleCheck.m31842a(ListingSortUseCase_Factory.m34566a(this.f27670w));
        this.f27672y = new C2266x11a20b89(builder.f27626d);
        this.f27673z = new C2262xddb86f47(builder.f27626d);
        this.f27642A = new C2264xdbdd5b83(builder.f27626d);
        this.f27643B = DoubleCheck.m31842a(FrontpageViewModule_CarouselActionsFactory.m34480a(builder.f27625c, this.f27672y, this.f27670w, this.f27673z, this.f27661n, this.f27642A));
        this.f27644C = DoubleCheck.m31842a(DiffListingUseCase_Factory.m34556a(this.f27659l));
        this.f27645D = InstanceFactory.m35583a(builder.f27631i);
        this.f27646E = DoubleCheck.m31842a(FrontpageListingPresenter_Factory.m34722a(this.f27652e, this.f27653f, this.f27657j, this.f27658k, this.f27665r, this.f27666s, this.f27667t, this.f27668u, this.f27661n, this.f27669v, this.f27670w, this.f27671x, this.f27643B, this.f27660m, this.f27642A, this.f27644C, this.f27645D));
        this.f27647F = DoubleCheck.m31842a(RedditListingViewActions_Factory.m34714a());
    }

    public static com.reddit.frontpage.di.component.FrontpageComponent.Builder m29130a() {
        return new Builder();
    }

    public final void mo4660a(FrontpageListingScreen frontpageListingScreen) {
        LinkListingScreen_MembersInjector.m29557a((LinkListingScreen) frontpageListingScreen, (FrontpageSettings) Preconditions.m26013a(this.f27648a.mo4620h(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29558a((LinkListingScreen) frontpageListingScreen, (PreferenceRepository) Preconditions.m26013a(this.f27648a.mo4613a(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29559a((LinkListingScreen) frontpageListingScreen, (ListingScreenActions) this.f27649b.get());
        LinkListingScreen_MembersInjector.m29560a((LinkListingScreen) frontpageListingScreen, (AdVisibilityTracker) this.f27651d.get());
        FrontpageListingScreen_MembersInjector.m29549a(frontpageListingScreen, (FrontpageListingPresenter) this.f27646E.get());
        FrontpageListingScreen_MembersInjector.m29548a(frontpageListingScreen, (ListingViewActions) this.f27647F.get());
    }
}
