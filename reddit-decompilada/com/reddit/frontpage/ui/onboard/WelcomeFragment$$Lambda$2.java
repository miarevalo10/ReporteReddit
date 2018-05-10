package com.reddit.frontpage.ui.onboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.AppAnalytics.ClickEventBuilder;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class WelcomeFragment$$Lambda$2 implements OnClickListener {
    private final WelcomeFragment f21498a;

    WelcomeFragment$$Lambda$2(WelcomeFragment welcomeFragment) {
        this.f21498a = welcomeFragment;
    }

    public final void onClick(View view) {
        WelcomeFragment welcomeFragment = this.f21498a;
        ClickEventBuilder b = AppAnalytics.m21858b();
        b.f19954a = welcomeFragment.getAnalyticsScreenName();
        b.f19955b = FreeSpaceBox.TYPE;
        b.m21825a();
        IntentUtil.m23755a(view.getContext(), null);
        welcomeFragment.getActivity().finish();
    }
}
