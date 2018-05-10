package com.reddit.frontpage.ui.detail.xpost;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class XPostVideoDetailScreen$$Lambda$0 implements OnClickListener {
    private final XPostVideoDetailScreen f21216a;

    XPostVideoDetailScreen$$Lambda$0(XPostVideoDetailScreen xPostVideoDetailScreen) {
        this.f21216a = xPostVideoDetailScreen;
    }

    public final void onClick(View view) {
        view = this.f21216a;
        Routing.m22627b(Routing.m22617a(view.am_()), Nav.m22541a(view.aa));
    }
}
