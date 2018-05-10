package com.reddit.frontpage.ui.onboard;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class WelcomeFragment$$Lambda$3 implements OnClickListener {
    private final WelcomeFragment f21499a;
    private final String f21500b;
    private final View f21501c;
    private final View f21502d;
    private final int f21503e;

    WelcomeFragment$$Lambda$3(WelcomeFragment welcomeFragment, String str, View view, View view2, int i) {
        this.f21499a = welcomeFragment;
        this.f21500b = str;
        this.f21501c = view;
        this.f21502d = view2;
        this.f21503e = i;
    }

    public final void onClick(View view) {
        this.f21499a.m39351a(this.f21500b, this.f21501c, this.f21502d, this.f21503e);
    }
}
