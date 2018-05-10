package com.reddit.frontpage;

import android.net.Uri;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;

final /* synthetic */ class MainActivity$$Lambda$4 implements Runnable {
    private final MainActivity f19881a;
    private final Uri f19882b;

    MainActivity$$Lambda$4(MainActivity mainActivity, Uri uri) {
        this.f19881a = mainActivity;
        this.f19882b = uri;
    }

    public final void run() {
        Routing.m22619a(this.f19881a, Nav.m22538a(2, this.f19882b));
    }
}
