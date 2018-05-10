package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.carousel.CarouselActions;
import com.reddit.frontpage.presentation.carousel.RedditCarouselActions;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.RedditAdsActions;
import com.reddit.frontpage.presentation.listing.common.RedditUserLinkActions;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¨\u0006\u001a"}, d2 = {"Lcom/reddit/frontpage/di/module/FrontpageViewModule;", "", "()V", "adsActions", "Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "frontpageSettings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "carouselActions", "Lcom/reddit/frontpage/presentation/carousel/CarouselActions;", "subredditRepository", "Lcom/reddit/frontpage/domain/repository/SubredditRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "analytics", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "postExecutionThread", "Lcom/reddit/common/rx/PostExecutionThread;", "linkActions", "Lcom/reddit/frontpage/presentation/listing/common/UserLinkActions;", "navigator", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsNavigator", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageViewModule.kt */
public final class FrontpageViewModule {
    public static UserLinkActions m22337a(ListingNavigator listingNavigator, SessionManager sessionManager, AdsNavigator adsNavigator) {
        Intrinsics.m26847b(listingNavigator, "navigator");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsNavigator, "adsNavigator");
        return new RedditUserLinkActions(listingNavigator, sessionManager, adsNavigator);
    }

    public static AdsActions m22336a(FrontpageSettings frontpageSettings) {
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        return new RedditAdsActions(frontpageSettings);
    }

    public static CarouselActions m22335a(SubredditRepository subredditRepository, PreferenceRepository preferenceRepository, CarouselAnalytics carouselAnalytics, FrontpageSettings frontpageSettings, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(subredditRepository, "subredditRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        Intrinsics.m26847b(carouselAnalytics, "analytics");
        Intrinsics.m26847b(frontpageSettings, "frontpageSettings");
        Intrinsics.m26847b(postExecutionThread, "postExecutionThread");
        return new RedditCarouselActions(subredditRepository, preferenceRepository, carouselAnalytics, frontpageSettings, postExecutionThread);
    }
}
