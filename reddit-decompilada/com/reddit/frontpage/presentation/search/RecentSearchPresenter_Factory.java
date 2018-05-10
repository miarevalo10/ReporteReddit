package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.presentation.analytics.SearchAnalytics;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RecentSearchPresenter_Factory implements Factory<RecentSearchPresenter> {
    private final Provider<View> f34168a;
    private final Provider<CommunitySearchNavigator> f34169b;
    private final Provider<SearchRepository> f34170c;
    private final Provider<SearchAnalytics> f34171d;
    private final Provider<PostExecutionThread> f34172e;

    private RecentSearchPresenter_Factory(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<SearchAnalytics> provider4, Provider<PostExecutionThread> provider5) {
        this.f34168a = provider;
        this.f34169b = provider2;
        this.f34170c = provider3;
        this.f34171d = provider4;
        this.f34172e = provider5;
    }

    public static RecentSearchPresenter_Factory m34875a(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<SearchAnalytics> provider4, Provider<PostExecutionThread> provider5) {
        return new RecentSearchPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new RecentSearchPresenter((View) this.f34168a.get(), (CommunitySearchNavigator) this.f34169b.get(), (SearchRepository) this.f34170c.get(), (SearchAnalytics) this.f34171d.get(), (PostExecutionThread) this.f34172e.get());
    }
}
