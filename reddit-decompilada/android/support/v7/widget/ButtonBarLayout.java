package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout extends LinearLayout {
    private boolean f2195a;
    private int f2196b = -1;
    private int f2197c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        this.f2197c = 0;
        if (getResources().getConfiguration().screenHeightDp >= 320) {
            z = true;
        }
        context = context.obtainStyledAttributes(attributeSet, C0164R.styleable.ButtonBarLayout);
        this.f2195a = context.getBoolean(C0164R.styleable.ButtonBarLayout_allowStacking, z);
        context.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.f2195a != z) {
            this.f2195a = z;
            if (!this.f2195a && getOrientation()) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = MeasureSpec.getSize(i);
        int i3 = 0;
        if (this.f2195a) {
            if (size > this.f2196b && m1857a()) {
                setStacked(false);
            }
            this.f2196b = size;
        }
        if (m1857a() || MeasureSpec.getMode(i) != 1073741824) {
            size = i;
            z = false;
        } else {
            size = MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(size, i2);
        if (this.f2195a && !m1857a()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        i = m1856a(0);
        if (i >= 0) {
            i2 = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            i3 = 0 + (((getPaddingTop() + i2.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
            if (m1857a() != 0) {
                i = m1856a(i + 1);
                if (i >= 0) {
                    i3 += getChildAt(i).getPaddingTop() + ((int) (1098907648 * getResources().getDisplayMetrics().density));
                }
            } else {
                i3 += getPaddingBottom();
            }
        }
        if (ViewCompat.m1253n(this) != i3) {
            setMinimumHeight(i3);
        }
    }

    private int m1856a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.f2197c, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0164R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? true : true);
        }
        for (z = getChildCount() - 2; z < false; z--) {
            bringChildToFront(getChildAt(z));
        }
    }

    private boolean m1857a() {
        return getOrientation() == 1;
    }
}
