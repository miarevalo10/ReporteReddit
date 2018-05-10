package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getPaddingLeft();
        i3 -= i;
        i = i3 - getPaddingRight();
        i3 = (i3 - z) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i5 = gravity & 112;
        gravity &= 8388615;
        if (i5 == 16) {
            i2 = getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
        } else if (i5 != 80) {
            i2 = getPaddingTop();
        } else {
            i2 = ((getPaddingTop() + i4) - i2) - measuredHeight;
        }
        i4 = getDividerDrawable();
        measuredHeight = 0;
        if (i4 == 0) {
            i4 = 0;
        } else {
            i4 = i4.getIntrinsicHeight();
        }
        while (measuredHeight < childCount) {
            View childAt = getChildAt(measuredHeight);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.f2299h;
                if (i6 < 0) {
                    i6 = gravity;
                }
                i6 = GravityCompat.m1096a(i6, ViewCompat.m1242f(this)) & 7;
                if (i6 == 1) {
                    i6 = ((((i3 - measuredWidth) / 2) + z) + layoutParams.leftMargin) - layoutParams.rightMargin;
                } else if (i6 != 5) {
                    i6 = layoutParams.leftMargin + z;
                } else {
                    i6 = (i - measuredWidth) - layoutParams.rightMargin;
                }
                if (hasDividerBeforeChildAt(measuredHeight)) {
                    i2 += i4;
                }
                i2 += layoutParams.topMargin;
                childAt.layout(i6, i2, measuredWidth + i6, i2 + measuredHeight2);
                i2 += measuredHeight2 + layoutParams.bottomMargin;
            }
            measuredHeight++;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int combineMeasuredStates;
        int n;
        int i5;
        AlertDialogLayout alertDialogLayout = this;
        int i6 = i;
        int childCount = getChildCount();
        int i7 = 0;
        View view = null;
        View view2 = view;
        View view3 = view2;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0164R.id.topPanel) {
                    view = childAt;
                } else if (id == C0164R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if (id != C0164R.id.contentPanel) {
                        if (id != C0164R.id.customPanel) {
                            i4 = i2;
                            break;
                        }
                    }
                    if (view3 != null) {
                        i4 = i2;
                        break;
                    }
                    view3 = childAt;
                }
            }
        }
        i3 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i6, 0);
            paddingTop += view.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            combineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i6, 0);
            View view4 = view2;
            while (true) {
                n = ViewCompat.m1253n(view4);
                if (n <= 0) {
                    if (!(view4 instanceof ViewGroup)) {
                        break;
                    }
                    ViewGroup viewGroup = (ViewGroup) view4;
                    if (viewGroup.getChildCount() != 1) {
                        break;
                    }
                    view4 = viewGroup.getChildAt(0);
                } else {
                    break;
                }
                i4 = view2.getMeasuredHeight() - n;
                paddingTop += n;
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
            }
            n = 0;
            i4 = view2.getMeasuredHeight() - n;
            paddingTop += n;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        } else {
            i4 = 0;
            n = i4;
        }
        if (view3 != null) {
            if (i3 == 0) {
                i5 = 0;
            } else {
                i5 = MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), i3);
            }
            view3.measure(i6, i5);
            i5 = view3.getMeasuredHeight();
            paddingTop += i5;
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        } else {
            i5 = 0;
        }
        size -= paddingTop;
        if (view2 != null) {
            paddingTop -= n;
            i4 = Math.min(size, i4);
            if (i4 > 0) {
                size -= i4;
                n += i4;
            }
            view2.measure(i6, MeasureSpec.makeMeasureSpec(n, 1073741824));
            paddingTop += view2.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && size > 0) {
            paddingTop -= i5;
            view3.measure(i6, MeasureSpec.makeMeasureSpec(i5 + size, i3));
            paddingTop += view3.getMeasuredHeight();
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view3.getMeasuredState());
        }
        i3 = 0;
        int i8 = i3;
        while (i3 < childCount) {
            view3 = getChildAt(i3);
            if (view3.getVisibility() != 8) {
                i8 = Math.max(i8, view3.getMeasuredWidth());
            }
            i3++;
        }
        i4 = i2;
        setMeasuredDimension(View.resolveSizeAndState(i8 + (getPaddingLeft() + getPaddingRight()), i6, combineMeasuredStates), View.resolveSizeAndState(paddingTop, i4, 0));
        if (mode != 1073741824) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            for (mode = 0; mode < childCount; mode++) {
                View childAt2 = getChildAt(mode);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (layoutParams.width == -1) {
                        n = layoutParams.height;
                        layoutParams.height = childAt2.getMeasuredHeight();
                        measureChildWithMargins(childAt2, makeMeasureSpec, 0, i4, 0);
                        layoutParams.height = n;
                    }
                }
            }
        }
        i7 = 1;
        if (i7 == 0) {
            super.onMeasure(i, i2);
        }
    }
}
