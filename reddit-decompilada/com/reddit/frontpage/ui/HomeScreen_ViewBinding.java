package com.reddit.frontpage.ui;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ScreenPager;

public class HomeScreen_ViewBinding implements Unbinder {
    private HomeScreen f28884b;

    public HomeScreen_ViewBinding(HomeScreen homeScreen, View view) {
        this.f28884b = homeScreen;
        homeScreen.appBarLayout = (AppBarLayout) Utils.b(view, C1761R.id.app_bar_layout, "field 'appBarLayout'", AppBarLayout.class);
        homeScreen.tabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        homeScreen.screenPager = (ScreenPager) Utils.b(view, C1761R.id.screen_pager, "field 'screenPager'", ScreenPager.class);
    }

    public final void m29941a() {
        HomeScreen homeScreen = this.f28884b;
        if (homeScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28884b = null;
        homeScreen.appBarLayout = null;
        homeScreen.tabLayout = null;
        homeScreen.screenPager = null;
    }
}
