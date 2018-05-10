package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.AdsAnalyticsModule;
import com.reddit.frontpage.di.module.AdsAnalyticsModule_AdsVisibilityTrackerFactory;
import com.reddit.frontpage.di.module.OnboardingListingViewModule;
import com.reddit.frontpage.di.module.OnboardingListingViewModule_LinkActionsFactory;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadData;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadData_Factory;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen;
import com.reddit.frontpage.presentation.listing.common.LinkListingScreen_MembersInjector;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ListingScreenActions;
import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.common.RedditListingNavigator_Factory;
import com.reddit.frontpage.presentation.listing.common.RedditListingScreenActions_Factory;
import com.reddit.frontpage.presentation.listing.common.RedditListingViewActions_Factory;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.onboarding.OnboardingNavigator;
import com.reddit.frontpage.presentation.onboarding.RedditOnboardingNavigator_Factory;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Parameters;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.View;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingPresenter;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingPresenter_Factory;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerOnboardingListingViewComponent implements OnboardingListingViewComponent {
    private UserComponent f27792a;
    private Provider<ListingScreenActions> f27793b;
    private Provider<Lazy<? extends Activity>> f27794c;
    private Provider<AdVisibilityTracker> f27795d;
    private Provider<View> f27796e;
    private Provider<Parameters> f27797f;
    private Provider<Lazy<? extends Context>> f27798g;
    private Provider<String> f27799h;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27800i;
    private RedditListingNavigator_Factory f27801j;
    private Provider<ListingNavigator> f27802k;
    private Provider<UserLinkActions> f27803l;
    private RedditOnboardingNavigator_Factory f27804m;
    private Provider<OnboardingNavigator> f27805n;
    private com_reddit_frontpage_di_component_UserComponent_numberFormatter f27806o;
    private C2274xa5e66dc7 f27807p;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27808q;
    private Provider<CategoryLinksLoadData> f27809r;
    private C2276xfa494edd f27810s;
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27811t;
    private C2275xdbdd5b83 f27812u;
    private Provider<OnboardingListingPresenter> f27813v;
    private Provider<ListingViewActions> f27814w;

    private static final class Builder implements com.reddit.frontpage.di.component.OnboardingListingViewComponent.Builder {
        private AdsAnalyticsModule f27777a;
        private OnboardingListingViewModule f27778b;
        private UserComponent f27779c;
        private View f27780d;
        private Lazy<? extends Activity> f27781e;
        private Parameters f27782f;
        private Lazy<? extends Context> f27783g;
        private String f27784h;

        private Builder() {
        }

        public final OnboardingListingViewComponent mo4707a() {
            if (this.f27777a == null) {
                this.f27777a = new AdsAnalyticsModule();
            }
            if (this.f27778b == null) {
                this.f27778b = new OnboardingListingViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27779c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27780d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27781e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27782f == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27783g == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27784h != null) {
                return new DaggerOnboardingListingViewComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final /* synthetic */ com.reddit.frontpage.di.component.OnboardingListingViewComponent.Builder mo4708b(Lazy lazy) {
            this.f27781e = (Lazy) Preconditions.m26012a(lazy);
            return this;
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27785a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27785a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27785a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2274xa5e66dc7 implements Provider<CategoryRepository> {
        private final UserComponent f27786a;

        C2274xa5e66dc7(UserComponent userComponent) {
            this.f27786a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (CategoryRepository) Preconditions.m26013a(this.f27786a.mo4623k(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27787a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27787a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27787a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_numberFormatter implements Provider<NumberFormatter> {
        private final UserComponent f27788a;

        com_reddit_frontpage_di_component_UserComponent_numberFormatter(UserComponent userComponent) {
            this.f27788a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (NumberFormatter) Preconditions.m26013a(this.f27788a.mo4625m(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2275xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27789a;

        C2275xdbdd5b83(UserComponent userComponent) {
            this.f27789a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27789a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27790a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27790a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27790a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2276xfa494edd implements Provider<SubscriptionCountRepository> {
        private final UserComponent f27791a;

        C2276xfa494edd(UserComponent userComponent) {
            this.f27791a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SubscriptionCountRepository) Preconditions.m26013a(this.f27791a.mo4636x(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerOnboardingListingViewComponent(Builder builder) {
        this.f27792a = builder.f27779c;
        this.f27793b = DoubleCheck.m31842a(RedditListingScreenActions_Factory.m34713a());
        this.f27794c = InstanceFactory.m35583a(builder.f27781e);
        this.f27795d = DoubleCheck.m31842a(AdsAnalyticsModule_AdsVisibilityTrackerFactory.m34451a(builder.f27777a, this.f27794c));
        this.f27796e = InstanceFactory.m35583a(builder.f27780d);
        this.f27797f = InstanceFactory.m35583a(builder.f27782f);
        this.f27798g = InstanceFactory.m35583a(builder.f27783g);
        this.f27799h = InstanceFactory.m35583a(builder.f27784h);
        this.f27800i = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27779c);
        this.f27801j = RedditListingNavigator_Factory.m34712a(this.f27798g, this.f27799h, this.f27800i, AdsNavigator_Factory.m35105a());
        this.f27802k = DoubleCheck.m31842a(this.f27801j);
        this.f27803l = DoubleCheck.m31842a(OnboardingListingViewModule_LinkActionsFactory.m34520a(builder.f27778b, this.f27802k, this.f27800i, AdsNavigator_Factory.m35105a()));
        this.f27804m = RedditOnboardingNavigator_Factory.m34826a(this.f27798g);
        this.f27805n = DoubleCheck.m31842a(this.f27804m);
        this.f27806o = new com_reddit_frontpage_di_component_UserComponent_numberFormatter(builder.f27779c);
        this.f27807p = new C2274xa5e66dc7(builder.f27779c);
        this.f27808q = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27779c);
        this.f27809r = DoubleCheck.m31842a(CategoryLinksLoadData_Factory.m34555a(this.f27807p, this.f27808q));
        this.f27810s = new C2276xfa494edd(builder.f27779c);
        this.f27811t = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f27779c);
        this.f27812u = new C2275xdbdd5b83(builder.f27779c);
        this.f27813v = DoubleCheck.m31842a(OnboardingListingPresenter_Factory.m34848a(this.f27796e, this.f27797f, this.f27803l, this.f27805n, this.f27806o, this.f27809r, this.f27810s, this.f27811t, this.f27812u));
        this.f27814w = DoubleCheck.m31842a(RedditListingViewActions_Factory.m34714a());
    }

    public static com.reddit.frontpage.di.component.OnboardingListingViewComponent.Builder m29220a() {
        return new Builder();
    }

    public final void mo4709a(OnboardingListingScreen onboardingListingScreen) {
        LinkListingScreen_MembersInjector.m29557a((LinkListingScreen) onboardingListingScreen, (FrontpageSettings) Preconditions.m26013a(this.f27792a.mo4620h(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29558a((LinkListingScreen) onboardingListingScreen, (PreferenceRepository) Preconditions.m26013a(this.f27792a.mo4613a(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29559a((LinkListingScreen) onboardingListingScreen, (ListingScreenActions) this.f27793b.get());
        LinkListingScreen_MembersInjector.m29560a((LinkListingScreen) onboardingListingScreen, (AdVisibilityTracker) this.f27795d.get());
        OnboardingListingScreen_MembersInjector.m29844a(onboardingListingScreen, (OnboardingListingPresenter) this.f27813v.get());
        OnboardingListingScreen_MembersInjector.m29843a(onboardingListingScreen, (ListingViewActions) this.f27814w.get());
    }
}
