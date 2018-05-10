package com.instabug.library.ui.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class InstabugViewPager extends ViewPager {
    private View mCurrentView;
    private boolean swipeable = true;

    public InstabugViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.swipeable ? super.onTouchEvent(motionEvent) : null;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.swipeable ? super.onInterceptTouchEvent(motionEvent) : null;
    }

    public void setSwipeable(boolean z) {
        this.swipeable = z;
    }
}
