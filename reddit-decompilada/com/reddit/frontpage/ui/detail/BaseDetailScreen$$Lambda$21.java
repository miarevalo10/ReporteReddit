package com.reddit.frontpage.ui.detail;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen;
import io.reactivex.functions.Consumer;

final /* synthetic */ class BaseDetailScreen$$Lambda$21 implements Consumer {
    private final BaseDetailScreen f28935a;

    BaseDetailScreen$$Lambda$21(BaseDetailScreen baseDetailScreen) {
        this.f28935a = baseDetailScreen;
    }

    public final void accept(Object obj) {
        Screen screen = this.f28935a;
        Screen screen2 = (LinkFlairSelectScreen) Nav.m22550a(screen.f39153F.getSubreddit(), screen.f39153F, null, null);
        screen2.m29363b(screen);
        Routing.m22623a(screen, screen2);
    }
}
