package com.reddit.frontpage.presentation.search;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.domain.common.ResourceProvider;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.search.CommunitySearchContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CommunitySearchResultsPresenter_Factory implements Factory<CommunitySearchResultsPresenter> {
    private final Provider<View> f34151a;
    private final Provider<CommunitySearchNavigator> f34152b;
    private final Provider<SearchRepository> f34153c;
    private final Provider<ResourceProvider> f34154d;
    private final Provider<NumberFormatter> f34155e;
    private final Provider<AccountFormatter> f34156f;
    private final Provider<SubredditRepository> f34157g;
    private final Provider<PostExecutionThread> f34158h;

    private CommunitySearchResultsPresenter_Factory(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<ResourceProvider> provider4, Provider<NumberFormatter> provider5, Provider<AccountFormatter> provider6, Provider<SubredditRepository> provider7, Provider<PostExecutionThread> provider8) {
        this.f34151a = provider;
        this.f34152b = provider2;
        this.f34153c = provider3;
        this.f34154d = provider4;
        this.f34155e = provider5;
        this.f34156f = provider6;
        this.f34157g = provider7;
        this.f34158h = provider8;
    }

    public static CommunitySearchResultsPresenter_Factory m34872a(Provider<View> provider, Provider<CommunitySearchNavigator> provider2, Provider<SearchRepository> provider3, Provider<ResourceProvider> provider4, Provider<NumberFormatter> provider5, Provider<AccountFormatter> provider6, Provider<SubredditRepository> provider7, Provider<PostExecutionThread> provider8) {
        return new CommunitySearchResultsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public final /* synthetic */ Object get() {
        return new CommunitySearchResultsPresenter((View) this.f34151a.get(), (CommunitySearchNavigator) this.f34152b.get(), (SearchRepository) this.f34153c.get(), (ResourceProvider) this.f34154d.get(), (NumberFormatter) this.f34155e.get(), (AccountFormatter) this.f34156f.get(), (SubredditRepository) this.f34157g.get(), (PostExecutionThread) this.f34158h.get());
    }
}
