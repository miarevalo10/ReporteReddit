package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class CommunitiesViewModule_CarouselActionsFactory implements Factory<CarouselActions> {
    private final CommunitiesViewModule f33545a;
    private final Provider<SubredditRepository> f33546b;
    private final Provider<PreferenceRepository> f33547c;
    private final Provider<CarouselAnalytics> f33548d;
    private final Provider<FrontpageSettings> f33549e;
    private final Provider<PostExecutionThread> f33550f;

    private CommunitiesViewModule_CarouselActionsFactory(CommunitiesViewModule communitiesViewModule, Provider<SubredditRepository> provider, Provider<PreferenceRepository> provider2, Provider<CarouselAnalytics> provider3, Provider<FrontpageSettings> provider4, Provider<PostExecutionThread> provider5) {
        this.f33545a = communitiesViewModule;
        this.f33546b = provider;
        this.f33547c = provider2;
        this.f33548d = provider3;
        this.f33549e = provider4;
        this.f33550f = provider5;
    }

    public static CommunitiesViewModule_CarouselActionsFactory m34475a(CommunitiesViewModule communitiesViewModule, Provider<SubredditRepository> provider, Provider<PreferenceRepository> provider2, Provider<CarouselAnalytics> provider3, Provider<FrontpageSettings> provider4, Provider<PostExecutionThread> provider5) {
        return new CommunitiesViewModule_CarouselActionsFactory(communitiesViewModule, provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return (CarouselActions) Preconditions.m26013a(CommunitiesViewModule.m22332a((SubredditRepository) this.f33546b.get(), (PreferenceRepository) this.f33547c.get(), (CarouselAnalytics) this.f33548d.get(), (FrontpageSettings) this.f33549e.get(), (PostExecutionThread) this.f33550f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
