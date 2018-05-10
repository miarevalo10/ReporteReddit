package com.reddit.frontpage;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class MainActivity$$Lambda$0 implements Runnable {
    private final MainActivity f19873a;
    private final String f19874b;

    MainActivity$$Lambda$0(MainActivity mainActivity, String str) {
        this.f19873a = mainActivity;
        this.f19874b = str;
    }

    public final void run() {
        Routing.m22619a(this.f19873a, Nav.m22611v(this.f19874b));
    }
}
