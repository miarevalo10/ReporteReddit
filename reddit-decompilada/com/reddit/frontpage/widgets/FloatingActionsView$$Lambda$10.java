package com.reddit.frontpage.widgets;

import android.view.View.OnClickListener;

final /* synthetic */ class FloatingActionsView$$Lambda$10 implements Runnable {
    private final FloatingActionsView f21852a;
    private final OnClickListener f21853b;

    FloatingActionsView$$Lambda$10(FloatingActionsView floatingActionsView, OnClickListener onClickListener) {
        this.f21852a = floatingActionsView;
        this.f21853b = onClickListener;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21852a;
        floatingActionsView.menuSubmitImage.setOnClickListener(this.f21853b);
    }
}
