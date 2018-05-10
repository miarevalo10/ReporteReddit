package com.reddit.frontpage;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class MainActivity$$Lambda$1 implements Runnable {
    private final MainActivity f19875a;
    private final String f19876b;

    MainActivity$$Lambda$1(MainActivity mainActivity, String str) {
        this.f19875a = mainActivity;
        this.f19876b = str;
    }

    public final void run() {
        Routing.m22619a(this.f19875a, Nav.m22606q(this.f19876b));
    }
}
