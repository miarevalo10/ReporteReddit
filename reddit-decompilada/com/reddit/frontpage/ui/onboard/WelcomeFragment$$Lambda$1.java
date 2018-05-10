package com.reddit.frontpage.ui.onboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class WelcomeFragment$$Lambda$1 implements OnClickListener {
    private final WelcomeFragment f21497a;

    WelcomeFragment$$Lambda$1(WelcomeFragment welcomeFragment) {
        this.f21497a = welcomeFragment;
    }

    public final void onClick(View view) {
        view = this.f21497a;
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = view.getAnalyticsScreenName();
        b.f19955b = "signup";
        b.m21825a();
        SessionManager.b().a(Util.m24019e(view.getActivity()), true);
    }
}
