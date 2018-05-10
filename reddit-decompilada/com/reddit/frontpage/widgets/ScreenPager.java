package com.reddit.frontpage.widgets;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.RedditViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.events.v2.ScreenviewEventBuilder;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import timber.log.Timber;

public class ScreenPager extends RedditViewPager {
    private boolean f34523a;

    class C27011 extends SimpleOnPageChangeListener {
        final /* synthetic */ ScreenPager f34522a;

        C27011(ScreenPager screenPager) {
            this.f34522a = screenPager;
        }

        public final void m35295b(int i) {
            this.f34522a.m35296a();
        }
    }

    public ScreenPager(Context context) {
        super(context);
    }

    public ScreenPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addOnPageChangeListener(new C27011(this));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f34523a = true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        z = getCurrentScreen();
        if (this.f34523a != 0 && z && z.e) {
            m35296a();
            this.f34523a = false;
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
    }

    public ScreenPagerAdapter getAdapter() {
        return (ScreenPagerAdapter) super.getAdapter();
    }

    protected void populate(int i) {
        if (getAdapter().f34367g) {
            super.populate(i);
        }
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
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

    private BaseScreen getCurrentScreen() {
        return (BaseScreen) getAdapter().m35102d(getCurrentItem());
    }

    private void m35296a() {
        BaseScreen currentScreen = getCurrentScreen();
        if (currentScreen != null) {
            AppAnalytics.m21852a(currentScreen.mo7203N());
            ScreenviewEventBuilder analyticsScreenviewEvent = currentScreen.getAnalyticsScreenviewEvent();
            if (analyticsScreenviewEvent != null) {
                Timber.b("Sending v2 screen view event for %s", new Object[]{currentScreen.getAnalyticsScreenName()});
                analyticsScreenviewEvent.m21931b();
            }
        }
    }
}
