package com.reddit.frontpage.ui.profile;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.ScreenPager;
import com.reddit.frontpage.widgets.ShapedIconView;

public class ProfilePagerScreen_ViewBinding implements Unbinder {
    private ProfilePagerScreen f29231b;

    public ProfilePagerScreen_ViewBinding(ProfilePagerScreen profilePagerScreen, View view) {
        this.f29231b = profilePagerScreen;
        profilePagerScreen.toolbarTitle = (TextView) Utils.b(view, C1761R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
        profilePagerScreen.collapsingToolbar = (CollapsingToolbarLayout) Utils.b(view, C1761R.id.collapsing_toolbar, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
        profilePagerScreen.headerView = (ViewGroup) Utils.b(view, C1761R.id.profile_header, "field 'headerView'", ViewGroup.class);
        profilePagerScreen.bannerView = (ImageView) Utils.b(view, C1761R.id.profile_banner, "field 'bannerView'", ImageView.class);
        profilePagerScreen.bannerShadow = Utils.a(view, C1761R.id.banner_shadow, "field 'bannerShadow'");
        profilePagerScreen.userTitleView = (TextView) Utils.b(view, C1761R.id.profile_title, "field 'userTitleView'", TextView.class);
        profilePagerScreen.usernameView = (TextView) Utils.b(view, C1761R.id.profile_name, "field 'usernameView'", TextView.class);
        profilePagerScreen.userIconView = (ShapedIconView) Utils.b(view, C1761R.id.profile_icon, "field 'userIconView'", ShapedIconView.class);
        profilePagerScreen.followButton = (Button) Utils.b(view, C1761R.id.profile_follow, "field 'followButton'", Button.class);
        profilePagerScreen.editButton = (Button) Utils.b(view, C1761R.id.profile_edit, "field 'editButton'", Button.class);
        profilePagerScreen.profileDetail1 = (TextView) Utils.b(view, C1761R.id.profile_detail_1, "field 'profileDetail1'", TextView.class);
        profilePagerScreen.profileDetailSpacer = (TextView) Utils.b(view, C1761R.id.dot, "field 'profileDetailSpacer'", TextView.class);
        profilePagerScreen.profileDetail2 = (TextView) Utils.b(view, C1761R.id.profile_detail_2, "field 'profileDetail2'", TextView.class);
        profilePagerScreen.profileDescription = (TextView) Utils.b(view, C1761R.id.profile_description, "field 'profileDescription'", TextView.class);
        profilePagerScreen.tabLayout = (TabLayout) Utils.b(view, C1761R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        profilePagerScreen.screenPager = (ScreenPager) Utils.b(view, C1761R.id.screen_pager, "field 'screenPager'", ScreenPager.class);
    }

    public final void m30334a() {
        ProfilePagerScreen profilePagerScreen = this.f29231b;
        if (profilePagerScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29231b = null;
        profilePagerScreen.toolbarTitle = null;
        profilePagerScreen.collapsingToolbar = null;
        profilePagerScreen.headerView = null;
        profilePagerScreen.bannerView = null;
        profilePagerScreen.bannerShadow = null;
        profilePagerScreen.userTitleView = null;
        profilePagerScreen.usernameView = null;
        profilePagerScreen.userIconView = null;
        profilePagerScreen.followButton = null;
        profilePagerScreen.editButton = null;
        profilePagerScreen.profileDetail1 = null;
        profilePagerScreen.profileDetailSpacer = null;
        profilePagerScreen.profileDetail2 = null;
        profilePagerScreen.profileDescription = null;
        profilePagerScreen.tabLayout = null;
        profilePagerScreen.screenPager = null;
    }
}
