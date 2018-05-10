package com.reddit.frontpage.widgets.bottomnav;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.design.widget.TwoActionSnackbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u0013\u001a\u00020\t*\u00020\u000eH\u0002¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/widgets/bottomnav/BottomNavBehavior;", "Landroid/support/design/widget/CoordinatorLayout$Behavior;", "Lcom/reddit/frontpage/widgets/bottomnav/BottomNavView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "layoutDependsOn", "", "parent", "Landroid/support/design/widget/CoordinatorLayout;", "child", "dependency", "Landroid/view/View;", "onAttachedToLayoutParams", "", "params", "Landroid/support/design/widget/CoordinatorLayout$LayoutParams;", "isSnackbar", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BottomNavBehavior.kt */
public final class BottomNavBehavior extends Behavior<BottomNavView> {
    public BottomNavBehavior() {
        this();
    }

    public final /* synthetic */ boolean m30507a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        MarginLayoutParams marginLayoutParams;
        BottomNavView bottomNavView = (BottomNavView) view;
        Intrinsics.m26847b(coordinatorLayout, "parent");
        Intrinsics.m26847b(bottomNavView, "child");
        Intrinsics.m26847b(view2, "dependency");
        if ((view2 instanceof SnackbarLayout) == null) {
            if ((view2 instanceof TwoActionSnackbar.SnackbarLayout) == null) {
                coordinatorLayout = null;
                if (coordinatorLayout != null) {
                    coordinatorLayout = view2.getLayoutParams();
                    if (!(coordinatorLayout instanceof MarginLayoutParams)) {
                        coordinatorLayout = null;
                    }
                    marginLayoutParams = (MarginLayoutParams) coordinatorLayout;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.bottomMargin = bottomNavView.getMeasuredHeight() - ((int) bottomNavView.getTranslationY());
                        view2.requestLayout();
                    }
                }
                return false;
            }
        }
        coordinatorLayout = true;
        if (coordinatorLayout != null) {
            coordinatorLayout = view2.getLayoutParams();
            if (coordinatorLayout instanceof MarginLayoutParams) {
                coordinatorLayout = null;
            }
            marginLayoutParams = (MarginLayoutParams) coordinatorLayout;
            if (marginLayoutParams != null) {
                marginLayoutParams.bottomMargin = bottomNavView.getMeasuredHeight() - ((int) bottomNavView.getTranslationY());
                view2.requestLayout();
            }
        }
        return false;
    }

    public BottomNavBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void m30506a(LayoutParams layoutParams) {
        Intrinsics.m26847b(layoutParams, "params");
        super.a(layoutParams);
        layoutParams.g = 80;
    }
}
