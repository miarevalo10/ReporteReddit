package com.reddit.frontpage.widgets;

import android.view.View.OnClickListener;

final /* synthetic */ class FloatingActionsView$$Lambda$9 implements Runnable {
    private final FloatingActionsView f21863a;
    private final OnClickListener f21864b;

    FloatingActionsView$$Lambda$9(FloatingActionsView floatingActionsView, OnClickListener onClickListener) {
        this.f21863a = floatingActionsView;
        this.f21864b = onClickListener;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21863a;
        floatingActionsView.menuExpand.setOnClickListener(this.f21864b);
    }
}
