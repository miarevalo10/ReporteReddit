package com.reddit.frontpage.widgets;

public final /* synthetic */ class FloatingActionsView$$Lambda$6 implements Runnable {
    private final FloatingActionsView f21861a;

    public FloatingActionsView$$Lambda$6(FloatingActionsView floatingActionsView) {
        this.f21861a = floatingActionsView;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21861a;
        floatingActionsView.menu.b();
        floatingActionsView.menuSubmitSelf.setClickable(floatingActionsView.menu.a);
        floatingActionsView.menuSubmitLink.setClickable(floatingActionsView.menu.a);
        floatingActionsView.menuSubmitImage.setClickable(floatingActionsView.menu.a);
    }
}
