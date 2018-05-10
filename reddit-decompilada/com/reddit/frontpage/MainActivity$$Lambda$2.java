package com.reddit.frontpage;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class MainActivity$$Lambda$2 implements Runnable {
    private final MainActivity f19877a;
    private final String f19878b;

    MainActivity$$Lambda$2(MainActivity mainActivity, String str) {
        this.f19877a = mainActivity;
        this.f19878b = str;
    }

    public final void run() {
        Routing.m22619a(this.f19877a, Nav.m22607r(this.f19878b));
    }
}
