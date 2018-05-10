package com.reddit.frontpage.commons.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.reddit.frontpage.commons.analytics.AnalyticsTrackable;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v2.AnalyticsHeartbeatParams;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.util.Util;
import java.util.List;
import timber.log.Timber;

public class BaseFragment extends Fragment implements AnalyticsTrackable {
    public AnalyticsHeartbeatParams getAnalyticsHeartbeatParams() {
        return null;
    }

    public String getAnalyticsPageType() {
        return null;
    }

    public String getAnalyticsScreenName() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dropBreadCrumbs();
    }

    private void dropBreadCrumbs() {
        Util.m24009c(getClass().getSimpleName(), "onCreate");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AppAnalytics.m21860b(view, getAnalyticsScreenName());
        AppAnalytics.m21865c(view, getAnalyticsPageType());
    }

    public void onStart() {
        super.onStart();
        sendScreenViewEvent();
    }

    protected void sendScreenViewEvent() {
        if (getAnalyticsScreenName() != null) {
            Timber.b("Sending v1 screen view event for %s", new Object[]{getAnalyticsScreenName()});
            AppAnalytics.m21852a(createV1ScreenViewEvent());
            if (getAnalyticsScreenviewEvent() != null) {
                Timber.b("Sending v2 screen view event for %s", new Object[]{r0});
                getAnalyticsScreenviewEvent().m21931b();
            }
            return;
        }
        Timber.b("No screenname is defined--no screen view event will be sent.", new Object[0]);
    }

    public ScreenviewEventBuilder getAnalyticsScreenviewEvent() {
        if (getAnalyticsScreenName() == null) {
            return null;
        }
        return new ScreenviewEventBuilder().m21927a(getAnalyticsPageType());
    }

    public ScreenViewEvent createV1ScreenViewEvent() {
        if (getAnalyticsScreenName() == null) {
            return null;
        }
        return new ScreenViewEvent(getAnalyticsScreenName());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (childFragmentManager != null) {
            List<Fragment> f = childFragmentManager.f();
            if (f != null) {
                if (f.size() != 0) {
                    for (Fragment fragment : f) {
                        if (!(fragment == null || fragment.isDetached() || fragment.isRemoving())) {
                            fragment.onActivityResult(i, i2, intent);
                        }
                    }
                }
            }
        }
    }
}
