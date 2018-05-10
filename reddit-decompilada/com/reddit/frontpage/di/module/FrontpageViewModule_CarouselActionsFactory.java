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

public final class FrontpageViewModule_CarouselActionsFactory implements Factory<CarouselActions> {
    private final FrontpageViewModule f33557a;
    private final Provider<SubredditRepository> f33558b;
    private final Provider<PreferenceRepository> f33559c;
    private final Provider<CarouselAnalytics> f33560d;
    private final Provider<FrontpageSettings> f33561e;
    private final Provider<PostExecutionThread> f33562f;

    private FrontpageViewModule_CarouselActionsFactory(FrontpageViewModule frontpageViewModule, Provider<SubredditRepository> provider, Provider<PreferenceRepository> provider2, Provider<CarouselAnalytics> provider3, Provider<FrontpageSettings> provider4, Provider<PostExecutionThread> provider5) {
        this.f33557a = frontpageViewModule;
        this.f33558b = provider;
        this.f33559c = provider2;
        this.f33560d = provider3;
        this.f33561e = provider4;
        this.f33562f = provider5;
    }

    public static FrontpageViewModule_CarouselActionsFactory m34480a(FrontpageViewModule frontpageViewModule, Provider<SubredditRepository> provider, Provider<PreferenceRepository> provider2, Provider<CarouselAnalytics> provider3, Provider<FrontpageSettings> provider4, Provider<PostExecutionThread> provider5) {
        return new FrontpageViewModule_CarouselActionsFactory(frontpageViewModule, provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return (CarouselActions) Preconditions.m26013a(FrontpageViewModule.m22335a((SubredditRepository) this.f33558b.get(), (PreferenceRepository) this.f33559c.get(), (CarouselAnalytics) this.f33560d.get(), (FrontpageSettings) this.f33561e.get(), (PostExecutionThread) this.f33562f.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
