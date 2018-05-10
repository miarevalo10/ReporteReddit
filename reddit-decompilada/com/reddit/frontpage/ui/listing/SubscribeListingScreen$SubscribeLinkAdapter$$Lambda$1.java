package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;

final /* synthetic */ class SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$1 implements OnClickListener {
    private final SubscribeLinkAdapter f21319a;
    private final String f21320b;

    SubscribeListingScreen$SubscribeLinkAdapter$$Lambda$1(SubscribeLinkAdapter subscribeLinkAdapter, String str) {
        this.f21319a = subscribeLinkAdapter;
        this.f21320b = str;
    }

    public final void onClick(View view) {
        Routing.m22623a((Screen) this.f21319a.f37288b, Nav.m22566b(this.f21320b));
    }
}
