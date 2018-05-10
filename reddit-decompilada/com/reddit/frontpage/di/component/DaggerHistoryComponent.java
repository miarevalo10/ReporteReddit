package com.reddit.frontpage.di.component;

import android.app.Activity;
import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.HistoryViewModule;
import com.reddit.frontpage.di.module.HistoryViewModule_LinkActionsFactory;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.HistoryLoadData;
import com.reddit.frontpage.domain.usecase.HistoryLoadData_Factory;
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
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.Parameters;
import com.reddit.frontpage.presentation.listing.history.HistoryListingContract.View;
import com.reddit.frontpage.presentation.listing.history.HistoryListingPresenter;
import com.reddit.frontpage.presentation.listing.history.HistoryListingPresenter_Factory;
import com.reddit.frontpage.presentation.listing.history.HistoryListingScreen;
import com.reddit.frontpage.presentation.listing.history.HistoryListingScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerHistoryComponent implements HistoryComponent {
    private UserComponent f27698a;
    private Lazy<? extends Activity> f27699b;
    private Provider<ListingScreenActions> f27700c;
    private Provider<View> f27701d;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27702e;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27703f;
    private C2268xab6fc1a4 f27704g;
    private Provider<HistoryLoadData> f27705h;
    private Provider<Lazy<? extends Context>> f27706i;
    private Provider<String> f27707j;
    private RedditListingNavigator_Factory f27708k;
    private Provider<ListingNavigator> f27709l;
    private Provider<UserLinkActions> f27710m;
    private com_reddit_frontpage_di_component_UserComponent_moderatorActions f27711n;
    private com_reddit_frontpage_di_component_UserComponent_backgroundThread f27712o;
    private C2267xdbdd5b83 f27713p;
    private Provider<Parameters> f27714q;
    private Provider<HistoryListingPresenter> f27715r;
    private Provider<ListingViewActions> f27716s;

    private static final class Builder implements com.reddit.frontpage.di.component.HistoryComponent.Builder {
        private HistoryViewModule f27685a;
        private UserComponent f27686b;
        private View f27687c;
        private Lazy<? extends Context> f27688d;
        private Lazy<? extends Activity> f27689e;
        private String f27690f;
        private Parameters f27691g;

        private Builder() {
        }

        public final HistoryComponent mo4669a() {
            if (this.f27685a == null) {
                this.f27685a = new HistoryViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27686b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27687c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27688d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27689e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27690f == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27691g != null) {
                return new DaggerHistoryComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Parameters.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final /* synthetic */ com.reddit.frontpage.di.component.HistoryComponent.Builder mo4670b(Lazy lazy) {
            this.f27688d = (Lazy) Preconditions.m26012a(lazy);
            return this;
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_backgroundThread implements Provider<BackgroundThread> {
        private final UserComponent f27692a;

        com_reddit_frontpage_di_component_UserComponent_backgroundThread(UserComponent userComponent) {
            this.f27692a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (BackgroundThread) Preconditions.m26013a(this.f27692a.mo4632t(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27693a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27693a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27693a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_moderatorActions implements Provider<ModeratorLinkActions> {
        private final UserComponent f27694a;

        com_reddit_frontpage_di_component_UserComponent_moderatorActions(UserComponent userComponent) {
            this.f27694a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (ModeratorLinkActions) Preconditions.m26013a(this.f27694a.mo4629q(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2267xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27695a;

        C2267xdbdd5b83(UserComponent userComponent) {
            this.f27695a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27695a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2268xab6fc1a4 implements Provider<PreferenceRepository> {
        private final UserComponent f27696a;

        C2268xab6fc1a4(UserComponent userComponent) {
            this.f27696a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PreferenceRepository) Preconditions.m26013a(this.f27696a.mo4613a(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27697a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27697a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27697a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerHistoryComponent(Builder builder) {
        this.f27698a = builder.f27686b;
        this.f27700c = DoubleCheck.m31842a(RedditListingScreenActions_Factory.m34713a());
        this.f27699b = builder.f27689e;
        this.f27701d = InstanceFactory.m35583a(builder.f27687c);
        this.f27702e = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27686b);
        this.f27703f = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27686b);
        this.f27704g = new C2268xab6fc1a4(builder.f27686b);
        this.f27705h = DoubleCheck.m31842a(HistoryLoadData_Factory.m34563a(this.f27703f, this.f27704g));
        this.f27706i = InstanceFactory.m35583a(builder.f27688d);
        this.f27707j = InstanceFactory.m35583a(builder.f27690f);
        this.f27708k = RedditListingNavigator_Factory.m34712a(this.f27706i, this.f27707j, this.f27702e, AdsNavigator_Factory.m35105a());
        this.f27709l = DoubleCheck.m31842a(this.f27708k);
        this.f27710m = DoubleCheck.m31842a(HistoryViewModule_LinkActionsFactory.m34491a(builder.f27685a, this.f27709l, this.f27702e, AdsNavigator_Factory.m35105a()));
        this.f27711n = new com_reddit_frontpage_di_component_UserComponent_moderatorActions(builder.f27686b);
        this.f27712o = new com_reddit_frontpage_di_component_UserComponent_backgroundThread(builder.f27686b);
        this.f27713p = new C2267xdbdd5b83(builder.f27686b);
        this.f27714q = InstanceFactory.m35583a(builder.f27691g);
        this.f27715r = DoubleCheck.m31842a(HistoryListingPresenter_Factory.m34724a(this.f27701d, this.f27702e, this.f27705h, this.f27703f, this.f27704g, this.f27710m, this.f27711n, this.f27712o, this.f27713p, this.f27714q));
        this.f27716s = DoubleCheck.m31842a(RedditListingViewActions_Factory.m34714a());
    }

    public static com.reddit.frontpage.di.component.HistoryComponent.Builder m29152a() {
        return new Builder();
    }

    public final void mo4671a(HistoryListingScreen historyListingScreen) {
        LinkListingScreen_MembersInjector.m29557a((LinkListingScreen) historyListingScreen, (FrontpageSettings) Preconditions.m26013a(this.f27698a.mo4620h(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29558a((LinkListingScreen) historyListingScreen, (PreferenceRepository) Preconditions.m26013a(this.f27698a.mo4613a(), "Cannot return null from a non-@Nullable component method"));
        LinkListingScreen_MembersInjector.m29559a((LinkListingScreen) historyListingScreen, (ListingScreenActions) this.f27700c.get());
        LinkListingScreen_MembersInjector.m29560a((LinkListingScreen) historyListingScreen, new AdVisibilityTracker(this.f27699b));
        HistoryListingScreen_MembersInjector.m29666a(historyListingScreen, (HistoryListingPresenter) this.f27715r.get());
        HistoryListingScreen_MembersInjector.m29665a(historyListingScreen, (ListingViewActions) this.f27716s.get());
    }
}
