package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.di.module.CommunitiesViewModule;
import com.reddit.frontpage.di.module.CommunitiesViewModule_CarouselActionsFactory;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.communities.CommunitiesContract.View;
import com.reddit.frontpage.presentation.communities.CommunitiesNavigator;
import com.reddit.frontpage.presentation.communities.CommunitiesPresenter;
import com.reddit.frontpage.presentation.communities.CommunitiesScreen;
import com.reddit.frontpage.presentation.communities.CommunitiesScreen_MembersInjector;
import com.reddit.frontpage.presentation.listing.common.RedditListingNavigator;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class DaggerCommunitiesComponent implements CommunitiesComponent {
    private View f27589a;
    private CommunitiesNavigator f27590b;
    private UserComponent f27591c;
    private Lazy<? extends Context> f27592d;
    private String f27593e;
    private C2259x11a20b89 f27594f;
    private C2258xab6fc1a4 f27595g;
    private C2255xddb86f47 f27596h;
    private C2256x822ff5bc f27597i;
    private C2257xdbdd5b83 f27598j;
    private Provider<CarouselActions> f27599k;

    private static final class Builder implements com.reddit.frontpage.di.component.CommunitiesComponent.Builder {
        private CommunitiesViewModule f27578a;
        private UserComponent f27579b;
        private View f27580c;
        private CommunitiesNavigator f27581d;
        private Lazy<? extends Context> f27582e;
        private String f27583f;

        private Builder() {
        }

        public final CommunitiesComponent mo4645a() {
            if (this.f27578a == null) {
                this.f27578a = new CommunitiesViewModule();
            }
            StringBuilder stringBuilder;
            if (this.f27579b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27580c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27581d == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(CommunitiesNavigator.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27582e == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(Lazy.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27583f != null) {
                return new DaggerCommunitiesComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class C2255xddb86f47 implements Provider<CarouselAnalytics> {
        private final UserComponent f27584a;

        C2255xddb86f47(UserComponent userComponent) {
            this.f27584a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (CarouselAnalytics) Preconditions.m26013a(this.f27584a.mo4616d(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2256x822ff5bc implements Provider<FrontpageSettings> {
        private final UserComponent f27585a;

        C2256x822ff5bc(UserComponent userComponent) {
            this.f27585a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (FrontpageSettings) Preconditions.m26013a(this.f27585a.mo4620h(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2257xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27586a;

        C2257xdbdd5b83(UserComponent userComponent) {
            this.f27586a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27586a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2258xab6fc1a4 implements Provider<PreferenceRepository> {
        private final UserComponent f27587a;

        C2258xab6fc1a4(UserComponent userComponent) {
            this.f27587a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PreferenceRepository) Preconditions.m26013a(this.f27587a.mo4613a(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2259x11a20b89 implements Provider<SubredditRepository> {
        private final UserComponent f27588a;

        C2259x11a20b89(UserComponent userComponent) {
            this.f27588a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SubredditRepository) Preconditions.m26013a(this.f27588a.mo4635w(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerCommunitiesComponent(Builder builder) {
        this.f27589a = builder.f27580c;
        this.f27590b = builder.f27581d;
        this.f27591c = builder.f27579b;
        this.f27594f = new C2259x11a20b89(builder.f27579b);
        this.f27595g = new C2258xab6fc1a4(builder.f27579b);
        this.f27596h = new C2255xddb86f47(builder.f27579b);
        this.f27597i = new C2256x822ff5bc(builder.f27579b);
        this.f27598j = new C2257xdbdd5b83(builder.f27579b);
        this.f27599k = DoubleCheck.m31842a(CommunitiesViewModule_CarouselActionsFactory.m34475a(builder.f27578a, this.f27594f, this.f27595g, this.f27596h, this.f27597i, this.f27598j));
        this.f27592d = builder.f27582e;
        this.f27593e = builder.f27583f;
    }

    public static com.reddit.frontpage.di.component.CommunitiesComponent.Builder m29101a() {
        return new Builder();
    }

    public final void mo4646a(CommunitiesScreen communitiesScreen) {
        CommunitiesScreen_MembersInjector.m29483a(communitiesScreen, new CommunitiesPresenter(this.f27589a, this.f27590b, (SubredditRepository) Preconditions.m26013a(this.f27591c.mo4635w(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27591c.mo4633u(), "Cannot return null from a non-@Nullable component method"), (CarouselActions) this.f27599k.get(), new RedditListingNavigator(this.f27592d, this.f27593e, (SessionManager) Preconditions.m26013a(this.f27591c.mo4621i(), "Cannot return null from a non-@Nullable component method"), new AdsNavigator())));
    }
}
