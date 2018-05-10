package com.reddit.frontpage.ui.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.design.widget.TwoActionSnackbar;
import android.util.AttributeSet;
import android.view.View;
import com.reddit.frontpage.animation.ScaleInOutAnimationCoordinator;
import com.reddit.frontpage.widgets.FloatingActionsView;

public class FloatingActionsViewBehavior extends Behavior<FloatingActionsView> {
    private FloatingActionsView f28894a;
    private ScaleInOutAnimationCoordinator f28895b;
    private ScaleInOutAnimationCoordinator f28896c;
    private int f28897d;
    private int f28898e;
    private int f28899f;

    public final /* bridge */ /* synthetic */ boolean m29951a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i) {
        return i == 2;
    }

    public final /* bridge */ /* synthetic */ boolean m29950a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        FloatingActionsView floatingActionsView = (FloatingActionsView) view;
        if (this.f28894a == null) {
            this.f28894a = floatingActionsView;
        }
        if ((view2 instanceof SnackbarLayout) == null) {
            if ((view2 instanceof TwoActionSnackbar.SnackbarLayout) == null) {
                return null;
            }
        }
        return true;
    }

    public FloatingActionsViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ScaleInOutAnimationCoordinator m29949a() {
        FloatingActionsView floatingActionsView = this.f28894a;
        Object obj = null;
        Object obj2 = (floatingActionsView.f21867b == null || floatingActionsView.f21867b != floatingActionsView.menuExpand) ? null : 1;
        if (obj2 != null) {
            if (this.f28895b == null) {
                this.f28895b = new ScaleInOutAnimationCoordinator(this.f28894a.getActiveView());
            }
            return this.f28895b;
        }
        floatingActionsView = this.f28894a;
        if (floatingActionsView.f21867b != null && floatingActionsView.f21867b == floatingActionsView.button) {
            obj = 1;
        }
        if (obj == null) {
            return null;
        }
        if (this.f28896c == null) {
            this.f28896c = new ScaleInOutAnimationCoordinator(this.f28894a.getActiveView());
        }
        return this.f28896c;
    }

    public final /* synthetic */ void m29952b(View view, int i) {
        if (this.f28894a.isEnabled()) {
            if (view.getHeight() != this.f28897d) {
                this.f28897d = view.getHeight();
                this.f28898e = (int) (((float) this.f28897d) * 0.01f);
            }
            this.f28899f += i;
            if (this.f28899f > this.f28898e) {
                if (this.f28894a != null) {
                    this.f28894a.m24141b();
                    view = m29949a();
                    if (view != null) {
                        view.m28892b();
                    }
                }
                this.f28899f = 0;
            } else if (this.f28899f < (-this.f28898e)) {
                if (this.f28894a != null) {
                    view = m29949a();
                    if (view != null) {
                        view.m28891a();
                    }
                }
                this.f28899f = 0;
            }
        }
    }
}
