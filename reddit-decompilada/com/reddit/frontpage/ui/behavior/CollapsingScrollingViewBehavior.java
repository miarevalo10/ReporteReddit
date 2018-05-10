package com.reddit.frontpage.ui.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.ScrollingViewBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class CollapsingScrollingViewBehavior extends ScrollingViewBehavior {
    boolean f39140e;
    boolean f39141f;

    public CollapsingScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean m39066a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        if (!this.f39140e) {
            this.f39141f = view.isEnabled();
            view.setEnabled(false);
        }
        return super.a(coordinatorLayout, view, view2, view3, i);
    }

    public final void m39068c(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (!this.f39140e) {
            view.setEnabled(this.f39141f);
        }
        super.c(coordinatorLayout, view, view2);
    }

    public final boolean m39067b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view2 instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            this.f39140e = appBarLayout.getTotalScrollRange() + appBarLayout.getMinimumHeight() == appBarLayout.getHeight();
        }
        return super.b(coordinatorLayout, view, view2);
    }
}
