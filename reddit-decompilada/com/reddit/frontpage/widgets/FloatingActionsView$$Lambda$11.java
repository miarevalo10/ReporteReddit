package com.reddit.frontpage.widgets;

import android.view.View.OnClickListener;

final /* synthetic */ class FloatingActionsView$$Lambda$11 implements Runnable {
    private final FloatingActionsView f21854a;
    private final OnClickListener f21855b;

    FloatingActionsView$$Lambda$11(FloatingActionsView floatingActionsView, OnClickListener onClickListener) {
        this.f21854a = floatingActionsView;
        this.f21855b = onClickListener;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21854a;
        floatingActionsView.menuSubmitSelf.setOnClickListener(this.f21855b);
    }
}
