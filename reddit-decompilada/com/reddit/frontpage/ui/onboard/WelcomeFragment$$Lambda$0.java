package com.reddit.frontpage.ui.onboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class WelcomeFragment$$Lambda$0 implements OnClickListener {
    private final WelcomeFragment f21496a;

    WelcomeFragment$$Lambda$0(WelcomeFragment welcomeFragment) {
        this.f21496a = welcomeFragment;
    }

    public final void onClick(View view) {
        view = this.f21496a;
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = view.getAnalyticsScreenName();
        b.f19955b = "login";
        b.m21825a();
        SessionManager.b().a(Util.m24019e(view.getActivity()), false);
    }
}
