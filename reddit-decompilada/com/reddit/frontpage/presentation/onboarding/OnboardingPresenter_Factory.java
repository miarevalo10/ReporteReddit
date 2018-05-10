package com.reddit.frontpage.presentation.onboarding;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import com.reddit.frontpage.domain.repository.CategoryRepository;
import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class OnboardingPresenter_Factory implements Factory<OnboardingPresenter> {
    private final Provider<View> f34107a;
    private final Provider<CategoryRepository> f34108b;
    private final Provider<SubscriptionCountRepository> f34109c;
    private final Provider<BackgroundThread> f34110d;
    private final Provider<PostExecutionThread> f34111e;

    private OnboardingPresenter_Factory(Provider<View> provider, Provider<CategoryRepository> provider2, Provider<SubscriptionCountRepository> provider3, Provider<BackgroundThread> provider4, Provider<PostExecutionThread> provider5) {
        this.f34107a = provider;
        this.f34108b = provider2;
        this.f34109c = provider3;
        this.f34110d = provider4;
        this.f34111e = provider5;
    }

    public static OnboardingPresenter_Factory m34824a(Provider<View> provider, Provider<CategoryRepository> provider2, Provider<SubscriptionCountRepository> provider3, Provider<BackgroundThread> provider4, Provider<PostExecutionThread> provider5) {
        return new OnboardingPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new OnboardingPresenter((View) this.f34107a.get(), (CategoryRepository) this.f34108b.get(), (SubscriptionCountRepository) this.f34109c.get(), (BackgroundThread) this.f34110d.get(), (PostExecutionThread) this.f34111e.get());
    }
}
