package com.reddit.frontpage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.config.AppConfiguration.Onboarding;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.presentation.listing.FrontpageListingScreen;
import com.reddit.frontpage.presentation.onboarding.OnboardingUtil;

final /* synthetic */ class HomeScreen$$Lambda$4 implements OnClickListener {
    private final HomeScreen f21074a;
    private final FrontpageListingScreen f21075b;

    HomeScreen$$Lambda$4(HomeScreen homeScreen, FrontpageListingScreen frontpageListingScreen) {
        this.f21074a = homeScreen;
        this.f21075b = frontpageListingScreen;
    }

    public final void onClick(View view) {
        view = this.f21074a;
        FrontpageListingScreen frontpageListingScreen = this.f21075b;
        if (OnboardingUtil.m23163a()) {
            OnboardingUtil.m23162a(view);
            new OnboardingEventBuilder().m28959a(Source.ONBOARDING).m28956a(Action.CLICK).m28957a(Noun.EXPLORE).m21891a();
        } else {
            view.screenPager.setCurrentItem(1, true);
        }
        AppAnalytics.m21856a(Onboarding.NAME, frontpageListingScreen.getAnalyticsScreenName());
    }
}
