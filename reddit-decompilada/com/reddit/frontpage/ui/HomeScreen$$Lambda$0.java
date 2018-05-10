package com.reddit.frontpage.ui;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.home.HomeTab;

final /* synthetic */ class HomeScreen$$Lambda$0 implements OnOffsetChangedListener {
    private final HomeScreen f28882a;

    HomeScreen$$Lambda$0(HomeScreen homeScreen) {
        this.f28882a = homeScreen;
    }

    public final void m29939a(AppBarLayout appBarLayout, int i) {
        HomeScreen homeScreen = this.f28882a;
        if (homeScreen.f39135x != null) {
            for (int i2 = 0; i2 < HomeScreen.f39133v.length; i2++) {
                Screen d = homeScreen.f39135x.m35102d(i2);
                if (d != null) {
                    ((HomeTab) d).mo7215a(appBarLayout, i);
                }
            }
        }
    }
}
