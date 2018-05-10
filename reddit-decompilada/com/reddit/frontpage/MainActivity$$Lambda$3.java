package com.reddit.frontpage;

import android.net.Uri;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class MainActivity$$Lambda$3 implements Runnable {
    private final MainActivity f19879a;
    private final Uri f19880b;

    MainActivity$$Lambda$3(MainActivity mainActivity, Uri uri) {
        this.f19879a = mainActivity;
        this.f19880b = uri;
    }

    public final void run() {
        Routing.m22619a(this.f19879a, Nav.m22538a(0, this.f19880b));
    }
}
