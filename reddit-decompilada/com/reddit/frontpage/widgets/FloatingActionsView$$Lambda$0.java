package com.reddit.frontpage.widgets;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final /* synthetic */ class FloatingActionsView$$Lambda$0 implements OnTouchListener {
    private final FloatingActionsView f21851a;

    FloatingActionsView$$Lambda$0(FloatingActionsView floatingActionsView) {
        this.f21851a = floatingActionsView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view = this.f21851a;
        if (view.menu == null || view.menu.a == null) {
            return null;
        }
        view.menu.a();
        return true;
    }
}
