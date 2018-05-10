package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect f16449a = new Rect();
    final Rect f16450b = new Rect();
    int f16451c = 0;
    int f16452d;

    float mo3829a(View view) {
        return 1.0f;
    }

    abstract View mo3830a(List<View> list);

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean mo3086a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        HeaderScrollingViewBehavior headerScrollingViewBehavior = this;
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = mo3830a(coordinatorLayout.m16544a(view));
            if (a != null) {
                View view2;
                if (!ViewCompat.m1265z(a) || ViewCompat.m1265z(view)) {
                    view2 = view;
                } else {
                    view2 = view;
                    ViewCompat.m1232b(view2, true);
                    if (ViewCompat.m1265z(view2)) {
                        view2.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m16548a(view2, i, i2, MeasureSpec.makeMeasureSpec((size - a.getMeasuredHeight()) + mo3833b(a), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    protected final void mo3087b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = mo3830a(coordinatorLayout.m16544a(view));
        if (a != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = this.f16449a;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, a.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || ViewCompat.m1265z(coordinatorLayout) == null || ViewCompat.m1265z(view) != null)) {
                rect.left += lastWindowInsets.m1307a();
                rect.right -= lastWindowInsets.m1310c();
            }
            coordinatorLayout = this.f16450b;
            int i2 = layoutParams.f545c;
            if (i2 == 0) {
                i2 = 8388659;
            }
            GravityCompat.m1097a(i2, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, coordinatorLayout, i);
            i = m16569c(a);
            view.layout(coordinatorLayout.left, coordinatorLayout.top - i, coordinatorLayout.right, coordinatorLayout.bottom - i);
            this.f16451c = coordinatorLayout.top - a.getBottom();
            return;
        }
        super.mo3087b(coordinatorLayout, view, i);
        this.f16451c = null;
    }

    final int m16569c(View view) {
        return this.f16452d == 0 ? 0 : MathUtils.m854a((int) (mo3829a(view) * ((float) this.f16452d)), 0, this.f16452d);
    }

    int mo3833b(View view) {
        return view.getMeasuredHeight();
    }
}
