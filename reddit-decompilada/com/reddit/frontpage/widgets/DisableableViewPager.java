package com.reddit.frontpage.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisableableViewPager extends ViewPager {
    private OverrideHandler f29447a;

    public interface OverrideHandler {
    }

    public DisableableViewPager(Context context) {
        super(context);
    }

    public DisableableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!isEnabled() || super.onTouchEvent(motionEvent) == null) ? null : true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (!isEnabled() || super.onInterceptTouchEvent(motionEvent) == null) ? null : true;
    }

    public boolean canScrollHorizontally(int i) {
        return isEnabled() && super.canScrollHorizontally(i) != 0;
    }

    public void setOverrideHandler(OverrideHandler overrideHandler) {
        this.f29447a = overrideHandler;
    }
}
