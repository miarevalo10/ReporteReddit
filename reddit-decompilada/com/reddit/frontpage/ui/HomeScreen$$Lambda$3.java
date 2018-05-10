package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Onboarding;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;
import com.reddit.frontpage.ui.listing.LegacyFrontpageScreen;

final /* synthetic */ class HomeScreen$$Lambda$3 implements OnClickListener {
    private final HomeScreen f21072a;
    private final LegacyFrontpageScreen f21073b;

    HomeScreen$$Lambda$3(HomeScreen homeScreen, LegacyFrontpageScreen legacyFrontpageScreen) {
        this.f21072a = homeScreen;
        this.f21073b = legacyFrontpageScreen;
    }

    public final void onClick(View view) {
        view = this.f21072a;
        LegacyFrontpageScreen legacyFrontpageScreen = this.f21073b;
        if (OnboardingUtil.m23163a()) {
            OnboardingUtil.m23162a(view);
            new OnboardingEventBuilder().m28959a(Source.ONBOARDING).m28956a(Action.CLICK).m28957a(Noun.EXPLORE).m21891a();
        } else {
            view.screenPager.setCurrentItem(1, true);
        }
        AppAnalytics.m21856a(Onboarding.NAME, legacyFrontpageScreen.getAnalyticsScreenName());
    }
}
