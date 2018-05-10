package com.reddit.frontpage.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.util.SubredditUtil;

final /* synthetic */ class BaseDetailScreen$$Lambda$8 implements OnClickListener {
    private final BaseDetailScreen f21158a;

    BaseDetailScreen$$Lambda$8(BaseDetailScreen baseDetailScreen) {
        this.f21158a = baseDetailScreen;
    }

    public final void onClick(View view) {
        view = this.f21158a;
        if (SubredditUtil.m23920a(view.f39153F.getSubredditNamePrefixed())) {
            Routing.m22619a(view.am_(), Nav.m22594j(view.f39153F.getAuthor()));
        } else {
            Routing.m22619a(view.am_(), Nav.m22566b(view.f39153F.getSubreddit()));
        }
    }
}
