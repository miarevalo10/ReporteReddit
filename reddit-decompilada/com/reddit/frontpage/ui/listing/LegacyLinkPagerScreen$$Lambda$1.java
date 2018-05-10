package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;

final /* synthetic */ class LegacyLinkPagerScreen$$Lambda$1 implements OnClickListener {
    private final LegacyLinkPagerScreen f21295a;

    LegacyLinkPagerScreen$$Lambda$1(LegacyLinkPagerScreen legacyLinkPagerScreen) {
        this.f21295a = legacyLinkPagerScreen;
    }

    public final void onClick(View view) {
        Screen screen = this.f21295a;
        if (!screen.mo6986J()) {
            Routing.m22621a(screen);
        }
    }
}
