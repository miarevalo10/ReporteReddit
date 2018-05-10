package com.reddit.frontpage.widgets;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final /* synthetic */ class GoEditTextView$$Lambda$3 implements OnTouchListener {
    private final GoEditTextView f21873a;

    GoEditTextView$$Lambda$3(GoEditTextView goEditTextView) {
        this.f21873a = goEditTextView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view = this.f21873a;
        if (motionEvent.getAction() != 1 || motionEvent.getRawX() < ((float) (view.getRight() - view.getCompoundDrawables()[2].getBounds().width())) || view.f34520a == null || view.f34520a.mo5021a() == null) {
            return null;
        }
        return true;
    }
}
