package com.reddit.frontpage.ui;

import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;

final /* synthetic */ class HomeScreen$$Lambda$2 implements Runnable {
    private final HomeScreen f21070a;
    private final InternalSettings f21071b;

    HomeScreen$$Lambda$2(HomeScreen homeScreen, InternalSettings internalSettings) {
        this.f21070a = homeScreen;
        this.f21071b = internalSettings;
    }

    public final void run() {
        HomeScreen homeScreen = this.f21070a;
        this.f21071b.a.edit().putBoolean("com.reddit.frontpage.seen_new_user_experiment", true).apply();
        RedditAlertDialog.m23321b(homeScreen.am_());
    }
}
