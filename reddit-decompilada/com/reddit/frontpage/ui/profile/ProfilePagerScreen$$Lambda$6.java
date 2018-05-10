package com.reddit.frontpage.ui.profile;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class ProfilePagerScreen$$Lambda$6 implements OnClickListener {
    private final ProfilePagerScreen f21518a;
    private final UserSubreddit f21519b;

    ProfilePagerScreen$$Lambda$6(ProfilePagerScreen profilePagerScreen, UserSubreddit userSubreddit) {
        this.f21518a = profilePagerScreen;
        this.f21519b = userSubreddit;
    }

    public final void onClick(View view) {
        Routing.m22623a(this.f21518a, Nav.m22597k(this.f21519b.getDisplayName()));
    }
}
