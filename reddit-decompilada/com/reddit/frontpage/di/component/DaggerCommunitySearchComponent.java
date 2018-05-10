package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.RedditSearchAnalytics_Factory;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import com.reddit.frontpage.presentation.search.CommunitySearchNavigator;
import com.reddit.frontpage.presentation.search.CommunitySearchResultsPresenter;
import com.reddit.frontpage.presentation.search.CommunitySearchResultsPresenter_Factory;
import com.reddit.frontpage.presentation.search.CommunitySearchScreen;
import com.reddit.frontpage.presentation.search.CommunitySearchScreen_MembersInjector;
import com.reddit.frontpage.presentation.search.CommunityTypeAheadSearchPresenter;
import com.reddit.frontpage.presentation.search.CommunityTypeAheadSearchPresenter_Factory;
import com.reddit.frontpage.presentation.search.RecentSearchPresenter;
import com.reddit.frontpage.presentation.search.RecentSearchPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerCommunitySearchComponent implements CommunitySearchComponent {
    private Provider<View> f27609a;
    private Provider<CommunitySearchNavigator> f27610b;
    private com_reddit_frontpage_di_component_UserComponent_searchRepository f27611c;
    private Provider<SearchAnalytics> f27612d;
    private C2260xdbdd5b83 f27613e;
    private Provider<RecentSearchPresenter> f27614f;
    private com_reddit_frontpage_di_component_UserComponent_numberFormatter f27615g;
    private com_reddit_frontpage_di_component_UserComponent_resourceProvider f27616h;
    private com_reddit_frontpage_di_component_UserComponent_accountFormatter f27617i;
    private Provider<CommunityTypeAheadSearchPresenter> f27618j;
    private C2261x11a20b89 f27619k;
    private Provider<CommunitySearchResultsPresenter> f27620l;

    private static final class Builder implements com.reddit.frontpage.di.component.CommunitySearchComponent.Builder {
        private UserComponent f27600a;
        private View f27601b;
        private CommunitySearchNavigator f27602c;

        private Builder() {
        }

        public final CommunitySearchComponent mo4650a() {
            StringBuilder stringBuilder;
            if (this.f27600a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27601b == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27602c != null) {
                return new DaggerCommunitySearchComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(CommunitySearchNavigator.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_accountFormatter implements Provider<AccountFormatter> {
        private final UserComponent f27603a;

        com_reddit_frontpage_di_component_UserComponent_accountFormatter(UserComponent userComponent) {
            this.f27603a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (AccountFormatter) Preconditions.m26013a(this.f27603a.mo4626n(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_numberFormatter implements Provider<NumberFormatter> {
        private final UserComponent f27604a;

        com_reddit_frontpage_di_component_UserComponent_numberFormatter(UserComponent userComponent) {
            this.f27604a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (NumberFormatter) Preconditions.m26013a(this.f27604a.mo4625m(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2260xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27605a;

        C2260xdbdd5b83(UserComponent userComponent) {
            this.f27605a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27605a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_resourceProvider implements Provider<ResourceProvider> {
        private final UserComponent f27606a;

        com_reddit_frontpage_di_component_UserComponent_resourceProvider(UserComponent userComponent) {
            this.f27606a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (ResourceProvider) Preconditions.m26013a(this.f27606a.mo4622j(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_searchRepository implements Provider<SearchRepository> {
        private final UserComponent f27607a;

        com_reddit_frontpage_di_component_UserComponent_searchRepository(UserComponent userComponent) {
            this.f27607a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SearchRepository) Preconditions.m26013a(this.f27607a.mo4634v(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2261x11a20b89 implements Provider<SubredditRepository> {
        private final UserComponent f27608a;

        C2261x11a20b89(UserComponent userComponent) {
            this.f27608a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SubredditRepository) Preconditions.m26013a(this.f27608a.mo4635w(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerCommunitySearchComponent(Builder builder) {
        this.f27609a = InstanceFactory.m35583a(builder.f27601b);
        this.f27610b = InstanceFactory.m35583a(builder.f27602c);
        this.f27611c = new com_reddit_frontpage_di_component_UserComponent_searchRepository(builder.f27600a);
        this.f27612d = DoubleCheck.m31842a(RedditSearchAnalytics_Factory.m34575a());
        this.f27613e = new C2260xdbdd5b83(builder.f27600a);
        this.f27614f = DoubleCheck.m31842a(RecentSearchPresenter_Factory.m34875a(this.f27609a, this.f27610b, this.f27611c, this.f27612d, this.f27613e));
        this.f27615g = new com_reddit_frontpage_di_component_UserComponent_numberFormatter(builder.f27600a);
        this.f27616h = new com_reddit_frontpage_di_component_UserComponent_resourceProvider(builder.f27600a);
        this.f27617i = new com_reddit_frontpage_di_component_UserComponent_accountFormatter(builder.f27600a);
        this.f27618j = DoubleCheck.m31842a(CommunityTypeAheadSearchPresenter_Factory.m34873a(this.f27609a, this.f27610b, this.f27611c, this.f27615g, this.f27616h, this.f27617i, this.f27612d, this.f27613e));
        this.f27619k = new C2261x11a20b89(builder.f27600a);
        this.f27620l = DoubleCheck.m31842a(CommunitySearchResultsPresenter_Factory.m34872a(this.f27609a, this.f27610b, this.f27611c, this.f27616h, this.f27615g, this.f27617i, this.f27619k, this.f27613e));
    }

    public static com.reddit.frontpage.di.component.CommunitySearchComponent.Builder m29110a() {
        return new Builder();
    }

    public final void mo4651a(CommunitySearchScreen communitySearchScreen) {
        CommunitySearchScreen_MembersInjector.m29871a(communitySearchScreen, (RecentSearchPresenter) this.f27614f.get());
        CommunitySearchScreen_MembersInjector.m29870a(communitySearchScreen, (CommunityTypeAheadSearchPresenter) this.f27618j.get());
        CommunitySearchScreen_MembersInjector.m29869a(communitySearchScreen, (CommunitySearchResultsPresenter) this.f27620l.get());
    }
}
