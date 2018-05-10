package com.reddit.frontpage.ui.layout;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerViewHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class StickyHeaderLinearLayoutManager extends LinearLayoutManager {
    public View f34304a;
    public ViewGroup f34305b;
    public ViewGroup f34306c;
    public ViewGroup f34307d;
    private int f34308e = -1;

    public StickyHeaderLinearLayoutManager(Context context) {
        super(context);
    }

    public StickyHeaderLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    public StickyHeaderLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final int m35014b(int i, Recycler recycler, State state) {
        i = super.b(i, recycler, state);
        m35011A();
        return i;
    }

    public final void m35015c(Recycler recycler, State state) {
        super.c(recycler, state);
        m35011A();
    }

    private void m35011A() {
        RecyclerView a = RecyclerViewHelper.a(this);
        View a2 = RecyclerViewHelper.a(this);
        View view = this.f34305b;
        int i = 0;
        while (view != a2 && view != null) {
            i += view.getTop();
            view = (View) view.getParent();
        }
        int i2 = i < 0 ? 1 : i + this.f34305b.getHeight() > a.getHeight() ? 3 : 2;
        if (i2 != this.f34308e) {
            this.f34308e = i2;
            ViewGroup viewGroup = (ViewGroup) this.f34304a.getParent();
            viewGroup.setVisibility(4);
            viewGroup.removeView(this.f34304a);
            if (i2 == 2) {
                this.f34305b.addView(this.f34304a);
                this.f34305b.setVisibility(0);
            } else if (i2 == 1) {
                this.f34306c.addView(this.f34304a, 0);
                this.f34306c.setVisibility(0);
            } else {
                this.f34307d.addView(this.f34304a);
                this.f34307d.setVisibility(0);
            }
        }
    }

    public final void m35013a(RecyclerView recyclerView, int i) {
        SmoothScroller c26881 = new LinearSmoothScroller(this, recyclerView.getContext()) {
            final /* synthetic */ StickyHeaderLinearLayoutManager f34303f;

            protected final int m35009b() {
                return -1;
            }

            public final PointF m35010c(int i) {
                return this.f34303f.b(i);
            }

            public final int m35008a(View view, int i) {
                LayoutManager layoutManager = this.i;
                int i2 = 0;
                if (layoutManager != null) {
                    if (layoutManager.f()) {
                        if (this.f34303f.f34304a != null) {
                            i2 = this.f34303f.f34304a.getHeight();
                        }
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        return a(LayoutManager.f(view) - layoutParams.topMargin, LayoutManager.h(view) + layoutParams.bottomMargin, layoutManager.u() + i2, layoutManager.E - layoutManager.w(), i);
                    }
                }
                return 0;
            }
        };
        c26881.g = i;
        a(c26881);
    }
}
