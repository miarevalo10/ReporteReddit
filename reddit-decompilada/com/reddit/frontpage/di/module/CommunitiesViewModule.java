package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.carousel.RedditCarouselActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/di/module/CommunitiesViewModule;", "", "()V", "carouselActions", "Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "analytics", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesViewModule.kt */
public final class CommunitiesViewModule {
    public static CarouselActions m22332a(SubredditRepository subredditRepository, PreferenceRepository preferenceRepository, CarouselAnalytics carouselAnalytics, FrontpageSettings frontpageSettings, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(subredditRepository, "subredditRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(carouselAnalytics, "analytics");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        return new RedditCarouselActions(subredditRepository, preferenceRepository, carouselAnalytics, frontpageSettings, postExecutionThread);
    }
}
