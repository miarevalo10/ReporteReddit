package com.reddit.frontpage.widgets;

import android.view.View;
import butterknife.ButterKnife;

final /* synthetic */ class FloatingActionsView$$Lambda$1 implements Runnable {
    private final FloatingActionsView f21858a;

    FloatingActionsView$$Lambda$1(FloatingActionsView floatingActionsView) {
        this.f21858a = floatingActionsView;
    }

    public final void run() {
        View view = this.f21858a;
        view.menuStub.inflate();
        ButterKnife.a(view);
        synchronized (view.f21866a) {
            view.m24139a();
        }
        synchronized (view.f21866a) {
            view.m24139a();
        }
    }
}
