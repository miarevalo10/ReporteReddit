package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.AdsModule;
import com.reddit.frontpage.di.module.AdsModule_ProvideAdsLoaderFactoryFactory;
import com.reddit.frontpage.di.module.AdsModule_ProvideAdsRepoFactory;
import com.reddit.frontpage.di.module.PopularViewModule;
import com.reddit.frontpage.di.module.PopularViewModule_AdsActionsFactory;
import com.reddit.frontpage.di.module.PopularViewModule_LinkActionsFactory;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase;
import com.reddit.frontpage.domain.usecase.DiffListingUseCase_Factory;
import com.reddit.frontpage.domain.usecase.PopularLoadData;
import com.reddit.frontpage.domain.usecase.PopularLoadData_Factory;
import com.reddit.frontpage.domain.usecase.PopularRefreshData;
import com.reddit.frontpage.domain.usecase.PopularRefreshData_Factory;
import com.reddit.frontpage.presentation.listing.PopularListingScreen;
import com.reddit.frontpage.presentation.listing.PopularListingScreen_MembersInjector;
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
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.popular.PopularListingContract.View;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter_Factory;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerPopularComponent implements PopularComponent {
    private UserComponent f27841a;
    private Lazy<? extends Activity> f27842b;
    private Provider<ListingScreenActions> f27843c;
    private Provider<View> f27844d;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27845e;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27846f;
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27847g;
    private C2280x822ff5bc f27848h;
    private com_reddit_frontpage_di_component_UserComponent_context f27849i;
    private AdsModule_ProvideAdsLoaderFactoryFactory f27850j;
    private Provider<AdsRepository> f27851k;
    private Provider<PopularLoadData> f27852l;
    private Provider<PopularRefreshData> f27853m;
    private Provider<Lazy<? extends Context>> f27854n;
    private Provider<String> f27855o;
    private RedditListingNavigator_Factory f27856p;
    private Provider<ListingNavigator> f27857q;
    private Provider<UserLinkActions> f27858r;
    private com_reddit_frontpage_di_component_UserComponent_moderatorActions f27859s;
    private C2281xdbdd5b83 f27860t;
    private Provider<AdsActions> f27861u;
    private C2282xab6fc1a4 f27862v;
    private Provider<DiffListingUseCase> f27863w;
    private Provider<Parameters> f27864x;
    private Provider<PopularListingPresenter> f27865y;
    private Provider<ListingViewActions> f27866z;

    private static final class Builder implements com.reddit.frontpage.di.component.PopularComponent.Builder {
        private AdsModule f27825a;
        private PopularViewModule f27826b;
        private UserComponent f27827c;
        private View f27828d;
        private Lazy<? extends Context> f27829e;
        private Lazy<? extends Activity> f27830f;
        private String f27831g;
        private Parameters f27832h;

        private Builder() {
        }

        public final PopularComponent mo4716a() {
            if (this.f27825a == null) {
                this.f27825a = new AdsModule();
            }
            if (this.f27826b == null) {
                this.f27826b = new PopularViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27827c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27828d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27829e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27830f == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27831g == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27832h != null) {
                return new DaggerPopularComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final /* synthetic */ com.reddit.frontpage.di.component.PopularComponent.Builder mo4717b(Lazy lazy) {
            this.f27829e = (Lazy) Preconditions.m26012a(lazy);
            return this;
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27833a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27833a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27833a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_context implements Provider<Context> {
        private final UserComponent f27834a;

        com_reddit_frontpage_di_component_UserComponent_context(UserComponent userComponent) {
            this.f27834a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (Context) Preconditions.m26013a(this.f27834a.mo4619g(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2280x822ff5bc implements Provider<FrontpageSettings> {
        private final UserComponent f27835a;

        C2280x822ff5bc(UserComponent userComponent) {
            this.f27835a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (FrontpageSettings) Preconditions.m26013a(this.f27835a.mo4620h(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27836a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27836a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27836a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_moderatorActions implements Provider<ModeratorLinkActions> {
        private final UserComponent f27837a;

        com_reddit_frontpage_di_component_UserComponent_moderatorActions(UserComponent userComponent) {
            this.f27837a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (ModeratorLinkActions) Preconditions.m26013a(this.f27837a.mo4629q(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2281xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27838a;

        C2281xdbdd5b83(UserComponent userComponent) {
            this.f27838a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27838a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2282xab6fc1a4 implements Provider<PreferenceRepository> {
        private final UserComponent f27839a;

        C2282xab6fc1a4(UserComponent userComponent) {
            this.f27839a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PreferenceRepository) Preconditions.m26013a(this.f27839a.mo4613a(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27840a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27840a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27840a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerPopularComponent(Builder builder) {
        this.f27841a = builder.f27827c;
        this.f27843c = DoubleCheck.m31842a(RedditListingScreenActions_Factory.m34713a());
        this.f27842b = builder.f27830f;
        this.f27844d = InstanceFactory.m35583a(builder.f27828d);
        this.f27845e = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27827c);
        this.f27846f = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27827c);
        this.f27847g = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f27827c);
        this.f27848h = new C2280x822ff5bc(builder.f27827c);
        this.f27849i = new com_reddit_frontpage_di_component_UserComponent_context(builder.f27827c);
        this.f27850j = AdsModule_ProvideAdsLoaderFactoryFactory.m34452a(builder.f27825a);
        this.f27851k = DoubleCheck.m31842a(AdsModule_ProvideAdsRepoFactory.m34453a(builder.f27825a, this.f27848h, this.f27849i, this.f27847g, this.f27850j));
        this.f27852l = DoubleCheck.m31842a(PopularLoadData_Factory.m34569a(this.f27846f, this.f27847g, this.f27851k, this.f27848h, this.f27845e));
        this.f27853m = DoubleCheck.m31842a(PopularRefreshData_Factory.m34572a(this.f27846f, this.f27851k, this.f27847g, this.f27848h, this.f27845e));
        this.f27854n = InstanceFactory.m35583a(builder.f27829e);
        this.f27855o = InstanceFactory.m35583a(builder.f27831g);
        this.f27856p = RedditListingNavigator_Factory.m34712a(this.f27854n, this.f27855o, this.f27845e, AdsNavigator_Factory.m35105a());
        this.f27857q = DoubleCheck.m31842a(this.f27856p);
        this.f27858r = DoubleCheck.m31842a(PopularViewModule_LinkActionsFactory.m34523a(builder.f27826b, this.f27857q, this.f27845e, AdsNavigator_Factory.m35105a()));
        this.f27859s = new com_reddit_frontpage_di_component_UserComponent_moderatorActions(builder.f27827c);
        this.f27860t = new C2281xdbdd5b83(builder.f27827c);
        this.f27861u = DoubleCheck.m31842a(PopularViewModule_AdsActionsFactory.m34522a(builder.f27826b, this.f27848h));
        this.f27862v = new C2282xab6fc1a4(builder.f27827c);
        this.f27863w = DoubleCheck.m31842a(DiffListingUseCase_Factory.m34556a(this.f27846f));
        this.f27864x = InstanceFactory.m35583a(builder.f27832h);
        this.f27865y = DoubleCheck.m31842a(PopularListingPresenter_Factory.m34746a(this.f27844d, this.f27845e, this.f27852l, this.f27853m, this.f27858r, this.f27859s, this.f27860t, this.f27861u, this.f27848h, this.f27862v, this.f27847g, this.f27863w, this.f27864x));
        this.f27866z = DoubleCheck.m31842a(RedditListingViewActions_Factory.m34714a());
    }

    public static com.reddit.frontpage.di.component.PopularComponent.Builder m29239a() {
        return new Builder();
    }

    public final void mo4718a(PopularListingScreen popularListingScreen) {
        LinkListingScreen_MembersInjector.m29557a((LinkListingScreen) popularListingScreen, (FrontpageSettings) Preconditions.m26013a(this.f27841a.mo4620h(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29558a((LinkListingScreen) popularListingScreen, (PreferenceRepository) Preconditions.m26013a(this.f27841a.mo4613a(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29559a((LinkListingScreen) popularListingScreen, (ListingScreenActions) this.f27843c.get());
        LinkListingScreen_MembersInjector.m29560a((LinkListingScreen) popularListingScreen, new AdVisibilityTracker(this.f27842b));
        PopularListingScreen_MembersInjector.m29552a(popularListingScreen, (PopularListingPresenter) this.f27865y.get());
        PopularListingScreen_MembersInjector.m29551a(popularListingScreen, (ListingViewActions) this.f27866z.get());
    }
}
