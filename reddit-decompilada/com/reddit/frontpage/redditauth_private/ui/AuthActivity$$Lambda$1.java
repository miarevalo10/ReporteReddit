package com.reddit.frontpage.redditauth_private.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;

final /* synthetic */ class AuthActivity$$Lambda$1 implements OnShowListener {
    static final OnShowListener f21015a = new AuthActivity$$Lambda$1();

    private AuthActivity$$Lambda$1() {
    }

    public final void onShow(DialogInterface dialogInterface) {
        AppAnalytics.m21852a(new ScreenViewEvent("forgot_password"));
    }
}
