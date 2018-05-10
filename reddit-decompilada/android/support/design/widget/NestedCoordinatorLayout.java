package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Array;

public class NestedCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {
    private int[][] f18840j = ((int[][]) Array.newInstance(int.class, new int[]{2, 2}));
    private NestedScrollingChildHelper f18841k = new NestedScrollingChildHelper(this);

    public NestedCoordinatorLayout(Context context) {
        super(context);
        setNestedScrollingEnabled(true);
    }

    public NestedCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setNestedScrollingEnabled(true);
    }

    public NestedCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setNestedScrollingEnabled(true);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        view = super.onStartNestedScroll(view, view2, i);
        if (startNestedScroll(i) == null) {
            if (view == null) {
                return null;
            }
        }
        return true;
    }

    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        stopNestedScroll();
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        super.onNestedPreScroll(view, i, i2, this.f18840j[0]);
        dispatchNestedPreScroll(i, i2, this.f18840j[1], null);
        iArr[0] = this.f18840j[0][0] + this.f18840j[1][0];
        iArr[1] = this.f18840j[0][1] + this.f18840j[1][1];
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(view, i, i2, i3, i4);
        dispatchNestedScroll(i, i2, i3, i4, null);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        view = super.onNestedPreFling(view, f, f2);
        if (dispatchNestedPreFling(f, f2) == null) {
            if (view == null) {
                return null;
            }
        }
        return true;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        view = super.onNestedFling(view, f, f2, z);
        if (dispatchNestedFling(f, f2, z) == null) {
            if (view == null) {
                return null;
            }
        }
        return true;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f18841k.m1124a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f18841k.f1442a;
    }

    public boolean startNestedScroll(int i) {
        return this.f18841k.m1128a(i, 0);
    }

    public void stopNestedScroll() {
        this.f18841k.m1133b(0);
    }

    public boolean hasNestedScrollingParent() {
        return this.f18841k.m1127a(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f18841k.m1129a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f18841k.m1131a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f18841k.m1126a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f18841k.m1125a(f, f2);
    }
}
