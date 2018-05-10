package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.UserSubmittedListingViewModule;
import com.reddit.frontpage.di.module.UserSubmittedListingViewModule_LinkActionsFactory;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.usecase.LinksLoadData;
import com.reddit.frontpage.domain.usecase.LinksLoadData_Factory;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.ModeratorLinkActions;
import com.reddit.frontpage.presentation.listing.common.RedditListingNavigator_Factory;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingContract.View;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingPresenter;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingPresenter_Factory;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingScreen;
import com.reddit.frontpage.presentation.listing.submitted.UserSubmittedListingScreen_MembersInjector;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerUserSubmittedListingComponent implements UserSubmittedListingComponent {
    private UserComponent f27937a;
    private Provider<View> f27938b;
    private Provider<Lazy<? extends Context>> f27939c;
    private Provider<String> f27940d;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27941e;
    private RedditListingNavigator_Factory f27942f;
    private Provider<ListingNavigator> f27943g;
    private com_reddit_frontpage_di_component_UserComponent_karmaRepository f27944h;
    private C2285x182fb698 f27945i;
    private C2286xdbdd5b83 f27946j;
    private com_reddit_frontpage_di_component_UserComponent_moderatorActions f27947k;
    private Provider<UserLinkActions> f27948l;
    private com_reddit_frontpage_di_component_UserComponent_linkRepository f27949m;
    private Provider<LinksLoadData> f27950n;
    private Provider<UserSubmittedListingPresenter> f27951o;

    private static final class Builder implements com.reddit.frontpage.di.component.UserSubmittedListingComponent.Builder {
        private UserSubmittedListingViewModule f27926a;
        private UserComponent f27927b;
        private View f27928c;
        private Lazy<? extends Context> f27929d;
        private String f27930e;

        private Builder() {
        }

        public final UserSubmittedListingComponent mo4752a() {
            if (this.f27926a == null) {
                this.f27926a = new UserSubmittedListingViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27927b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27928c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27929d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27930e != null) {
                return new DaggerUserSubmittedListingComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class C2285x182fb698 implements Provider<AccountRepository> {
        private final UserComponent f27931a;

        C2285x182fb698(UserComponent userComponent) {
            this.f27931a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (AccountRepository) Preconditions.m26013a(this.f27931a.mo4614b(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_karmaRepository implements Provider<KarmaRepository> {
        private final UserComponent f27932a;

        com_reddit_frontpage_di_component_UserComponent_karmaRepository(UserComponent userComponent) {
            this.f27932a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (KarmaRepository) Preconditions.m26013a(this.f27932a.mo4637y(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_linkRepository implements Provider<LinkRepository> {
        private final UserComponent f27933a;

        com_reddit_frontpage_di_component_UserComponent_linkRepository(UserComponent userComponent) {
            this.f27933a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (LinkRepository) Preconditions.m26013a(this.f27933a.mo4628p(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_moderatorActions implements Provider<ModeratorLinkActions> {
        private final UserComponent f27934a;

        com_reddit_frontpage_di_component_UserComponent_moderatorActions(UserComponent userComponent) {
            this.f27934a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (ModeratorLinkActions) Preconditions.m26013a(this.f27934a.mo4629q(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2286xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27935a;

        C2286xdbdd5b83(UserComponent userComponent) {
            this.f27935a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27935a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27936a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27936a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27936a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerUserSubmittedListingComponent(Builder builder) {
        this.f27938b = InstanceFactory.m35583a(builder.f27928c);
        this.f27939c = InstanceFactory.m35583a(builder.f27929d);
        this.f27940d = InstanceFactory.m35583a(builder.f27930e);
        this.f27941e = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27927b);
        this.f27942f = RedditListingNavigator_Factory.m34712a(this.f27939c, this.f27940d, this.f27941e, AdsNavigator_Factory.m35105a());
        this.f27943g = DoubleCheck.m31842a(this.f27942f);
        this.f27944h = new com_reddit_frontpage_di_component_UserComponent_karmaRepository(builder.f27927b);
        this.f27945i = new C2285x182fb698(builder.f27927b);
        this.f27946j = new C2286xdbdd5b83(builder.f27927b);
        this.f27947k = new com_reddit_frontpage_di_component_UserComponent_moderatorActions(builder.f27927b);
        this.f27948l = DoubleCheck.m31842a(UserSubmittedListingViewModule_LinkActionsFactory.m34549a(builder.f27926a, this.f27943g, this.f27941e, AdsNavigator_Factory.m35105a()));
        this.f27949m = new com_reddit_frontpage_di_component_UserComponent_linkRepository(builder.f27927b);
        this.f27950n = DoubleCheck.m31842a(LinksLoadData_Factory.m34565a(this.f27949m));
        this.f27951o = DoubleCheck.m31842a(UserSubmittedListingPresenter_Factory.m34747a(this.f27938b, this.f27943g, this.f27944h, this.f27945i, this.f27946j, this.f27947k, this.f27948l, this.f27950n));
        this.f27937a = builder.f27927b;
    }

    public static com.reddit.frontpage.di.component.UserSubmittedListingComponent.Builder m29303a() {
        return new Builder();
    }

    public final void mo4753a(UserSubmittedListingScreen userSubmittedListingScreen) {
        UserSubmittedListingScreen_MembersInjector.m29702a(userSubmittedListingScreen, (UserSubmittedListingPresenter) this.f27951o.get());
        UserSubmittedListingScreen_MembersInjector.m29701a(userSubmittedListingScreen, (FrontpageSettings) Preconditions.m26013a(this.f27937a.mo4620h(), "Cannot return null from a non-@Nullable component method"));
    }
}
