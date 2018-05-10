package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import com.reddit.frontpage.presentation.analytics.RedditCarouselAnalytics;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalytics;
import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import javax.inject.Singleton;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/di/module/AnalyticsModule;", "", "()V", "carouselAnalytics", "Lcom/reddit/frontpage/presentation/analytics/CarouselAnalytics;", "profileSettingsAnalytics", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalyticsContract;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AnalyticsModule.kt */
public final class AnalyticsModule {
    @Singleton
    public static CarouselAnalytics m22318a() {
        return new RedditCarouselAnalytics();
    }

    @Singleton
    public static ProfileSettingsAnalyticsContract m22319b() {
        return new ProfileSettingsAnalytics();
    }
}
