package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.frontpage.domain.usecase.CategoryLinksLoadData;
import com.reddit.frontpage.presentation.formatter.NumberFormatter;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.presentation.onboarding.OnboardingNavigator;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.Parameters;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class OnboardingListingPresenter_Factory implements Factory<OnboardingListingPresenter> {
    private final Provider<View> f34132a;
    private final Provider<Parameters> f34133b;
    private final Provider<UserLinkActions> f34134c;
    private final Provider<OnboardingNavigator> f34135d;
    private final Provider<NumberFormatter> f34136e;
    private final Provider<CategoryLinksLoadData> f34137f;
    private final Provider<SubscriptionCountRepository> f34138g;
    private final Provider<BackgroundThread> f34139h;
    private final Provider<PostExecutionThread> f34140i;

    private OnboardingListingPresenter_Factory(Provider<View> provider, Provider<Parameters> provider2, Provider<UserLinkActions> provider3, Provider<OnboardingNavigator> provider4, Provider<NumberFormatter> provider5, Provider<CategoryLinksLoadData> provider6, Provider<SubscriptionCountRepository> provider7, Provider<BackgroundThread> provider8, Provider<PostExecutionThread> provider9) {
        this.f34132a = provider;
        this.f34133b = provider2;
        this.f34134c = provider3;
        this.f34135d = provider4;
        this.f34136e = provider5;
        this.f34137f = provider6;
        this.f34138g = provider7;
        this.f34139h = provider8;
        this.f34140i = provider9;
    }

    public static OnboardingListingPresenter_Factory m34848a(Provider<View> provider, Provider<Parameters> provider2, Provider<UserLinkActions> provider3, Provider<OnboardingNavigator> provider4, Provider<NumberFormatter> provider5, Provider<CategoryLinksLoadData> provider6, Provider<SubscriptionCountRepository> provider7, Provider<BackgroundThread> provider8, Provider<PostExecutionThread> provider9) {
        return new OnboardingListingPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public final /* synthetic */ Object get() {
        return new OnboardingListingPresenter((View) this.f34132a.get(), (Parameters) this.f34133b.get(), (UserLinkActions) this.f34134c.get(), (OnboardingNavigator) this.f34135d.get(), (NumberFormatter) this.f34136e.get(), (CategoryLinksLoadData) this.f34137f.get(), (SubscriptionCountRepository) this.f34138g.get(), (BackgroundThread) this.f34139h.get(), (PostExecutionThread) this.f34140i.get());
    }
}
