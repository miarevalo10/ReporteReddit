package com.reddit.frontpage.widgets;

import android.view.View.OnClickListener;

final /* synthetic */ class FloatingActionsView$$Lambda$12 implements Runnable {
    private final FloatingActionsView f21856a;
    private final OnClickListener f21857b;

    FloatingActionsView$$Lambda$12(FloatingActionsView floatingActionsView, OnClickListener onClickListener) {
        this.f21856a = floatingActionsView;
        this.f21857b = onClickListener;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21856a;
        floatingActionsView.menuSubmitLink.setOnClickListener(this.f21857b);
    }
}
