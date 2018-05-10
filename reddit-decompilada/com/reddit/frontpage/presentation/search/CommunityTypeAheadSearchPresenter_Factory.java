package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CommunityTypeAheadSearchPresenter_Factory implements Factory<CommunityTypeAheadSearchPresenter> {
    private final Provider<View> f34159a;
    private final Provider<CommunitySearchNavigator> f34160b;
    private final Provider<SearchRepository> f34161c;
    private final Provider<NumberFormatter> f34162d;
    private final Provider<ResourceProvider> f34163e;
    private final Provider<AccountFormatter> f34164f;
    private final Provider<SearchAnalytics> f34165g;
    private final Provider<PostExecutionThread> f34166h;

    private CommunityTypeAheadSearchPresenter_Factory(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<NumberFormatter> provider4, Provider<ResourceProvider> provider5, Provider<AccountFormatter> provider6, Provider<SearchAnalytics> provider7, Provider<PostExecutionThread> provider8) {
        this.f34159a = provider;
        this.f34160b = provider2;
        this.f34161c = provider3;
        this.f34162d = provider4;
        this.f34163e = provider5;
        this.f34164f = provider6;
        this.f34165g = provider7;
        this.f34166h = provider8;
    }

    public static CommunityTypeAheadSearchPresenter_Factory m34873a(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<NumberFormatter> provider4, Provider<ResourceProvider> provider5, Provider<AccountFormatter> provider6, Provider<SearchAnalytics> provider7, Provider<PostExecutionThread> provider8) {
        return new CommunityTypeAheadSearchPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public final /* synthetic */ Object get() {
        return new CommunityTypeAheadSearchPresenter((View) this.f34159a.get(), (CommunitySearchNavigator) this.f34160b.get(), (SearchRepository) this.f34161c.get(), (NumberFormatter) this.f34162d.get(), (ResourceProvider) this.f34163e.get(), (AccountFormatter) this.f34164f.get(), (SearchAnalytics) this.f34165g.get(), (PostExecutionThread) this.f34166h.get());
    }
}
