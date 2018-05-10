package com.reddit.frontpage.widgets;

final /* synthetic */ class FloatingActionsView$$Lambda$8 implements Runnable {
    private final FloatingActionsView f21862a;

    FloatingActionsView$$Lambda$8(FloatingActionsView floatingActionsView) {
        this.f21862a = floatingActionsView;
    }

    public final void run() {
        FloatingActionsView floatingActionsView = this.f21862a;
        floatingActionsView.menu.a();
        floatingActionsView.menuSubmitSelf.setClickable(false);
        floatingActionsView.menuSubmitLink.setClickable(false);
        floatingActionsView.menuSubmitImage.setClickable(false);
    }
}
