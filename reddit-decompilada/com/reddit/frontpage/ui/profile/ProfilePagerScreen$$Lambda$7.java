package com.reddit.frontpage.ui.profile;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.model.UserSubreddit;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.SubredditUtil;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class ProfilePagerScreen$$Lambda$7 implements OnClickListener {
    private final ProfilePagerScreen f21520a;
    private final UserSubreddit f21521b;
    private final int f21522c;

    ProfilePagerScreen$$Lambda$7(ProfilePagerScreen profilePagerScreen, UserSubreddit userSubreddit, int i) {
        this.f21520a = profilePagerScreen;
        this.f21521b = userSubreddit;
        this.f21522c = i;
    }

    public final void onClick(View view) {
        Screen screen = this.f21520a;
        UserSubreddit userSubreddit = this.f21521b;
        int i = this.f21522c;
        if (SessionManager.b().c.isAnonymous()) {
            SessionManager.b().a(Util.m24019e(view.getContext()), true);
            return;
        }
        if (screen.following != null) {
            SubredditUtil.m23923b(userSubreddit, screen.m39396x());
            view = Screens.m22629a(screen, Util.m23960a((int) C1761R.string.fmt_now_unfollow, screen.username), -1);
            if (view != null) {
                view.a();
            }
        } else {
            SubredditUtil.m23914a(userSubreddit, screen.m39396x());
            view = Screens.m22629a(screen, Util.m23960a((int) C1761R.string.fmt_now_following, screen.username), -1);
            if (view != null) {
                view.a();
            }
        }
        screen.following ^= 1;
        screen.m39379a(i, true);
    }
}
