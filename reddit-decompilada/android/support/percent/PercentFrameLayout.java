package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.percent.PercentLayoutHelper.PercentLayoutInfo;
import android.support.percent.PercentLayoutHelper.PercentLayoutParams;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;

@Deprecated
public class PercentFrameLayout extends FrameLayout {
    private final PercentLayoutHelper f802a = new PercentLayoutHelper(this);

    @Deprecated
    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams implements PercentLayoutParams {
        private PercentLayoutInfo f11201a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11201a = PercentLayoutHelper.m424a(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public final PercentLayoutInfo mo127a() {
            if (this.f11201a == null) {
                this.f11201a = new PercentLayoutInfo();
            }
            return this.f11201a;
        }

        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            PercentLayoutHelper.m425a(this, typedArray, i, i2);
        }
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m416a(attributeSet);
    }

    public /* synthetic */ android.widget.FrameLayout.LayoutParams m44254generateLayoutParams(AttributeSet attributeSet) {
        return m416a(attributeSet);
    }

    public PercentFrameLayout(Context context) {
        super(context);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private LayoutParams m416a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        PercentLayoutHelper percentLayoutHelper = this.f802a;
        int size = (MeasureSpec.getSize(i) - percentLayoutHelper.f815a.getPaddingLeft()) - percentLayoutHelper.f815a.getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - percentLayoutHelper.f815a.getPaddingTop()) - percentLayoutHelper.f815a.getPaddingBottom();
        int childCount = percentLayoutHelper.f815a.getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i4 >= childCount) {
                break;
            }
            View childAt = percentLayoutHelper.f815a.getChildAt(i4);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof PercentLayoutParams) {
                PercentLayoutInfo a = ((PercentLayoutParams) layoutParams).mo127a();
                if (a != null) {
                    if (layoutParams instanceof MarginLayoutParams) {
                        int i6;
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        a.m418a(marginLayoutParams, size, size2);
                        a.f812j.leftMargin = marginLayoutParams.leftMargin;
                        a.f812j.topMargin = marginLayoutParams.topMargin;
                        a.f812j.rightMargin = marginLayoutParams.rightMargin;
                        a.f812j.bottomMargin = marginLayoutParams.bottomMargin;
                        MarginLayoutParamsCompat.m1102a(a.f812j, MarginLayoutParamsCompat.m1101a(marginLayoutParams));
                        MarginLayoutParamsCompat.m1104b(a.f812j, MarginLayoutParamsCompat.m1103b(marginLayoutParams));
                        if (a.f805c >= 0.0f) {
                            marginLayoutParams.leftMargin = Math.round(((float) size) * a.f805c);
                        }
                        if (a.f806d >= 0.0f) {
                            marginLayoutParams.topMargin = Math.round(((float) size2) * a.f806d);
                        }
                        if (a.f807e >= 0.0f) {
                            marginLayoutParams.rightMargin = Math.round(((float) size) * a.f807e);
                        }
                        if (a.f808f >= 0.0f) {
                            marginLayoutParams.bottomMargin = Math.round(((float) size2) * a.f808f);
                        }
                        if (a.f809g >= 0.0f) {
                            MarginLayoutParamsCompat.m1102a(marginLayoutParams, Math.round(((float) size) * a.f809g));
                            i6 = 1;
                        } else {
                            i6 = 0;
                        }
                        if (a.f810h >= 0.0f) {
                            MarginLayoutParamsCompat.m1104b(marginLayoutParams, Math.round(((float) size) * a.f810h));
                        } else {
                            i5 = i6;
                        }
                        if (!(i5 == 0 || childAt == null)) {
                            MarginLayoutParamsCompat.m1105c(marginLayoutParams, ViewCompat.m1242f(childAt));
                        }
                    } else {
                        a.m418a(layoutParams, size, size2);
                    }
                }
            }
            i4++;
        }
        super.onMeasure(i, i2);
        percentLayoutHelper = this.f802a;
        size = percentLayoutHelper.f815a.getChildCount();
        size2 = 0;
        while (i3 < size) {
            View childAt2 = percentLayoutHelper.f815a.getChildAt(i3);
            android.view.ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
            if (layoutParams2 instanceof PercentLayoutParams) {
                PercentLayoutInfo a2 = ((PercentLayoutParams) layoutParams2).mo127a();
                if (a2 != null) {
                    if (PercentLayoutHelper.m426a(childAt2, a2)) {
                        layoutParams2.width = -2;
                        size2 = 1;
                    }
                    if (PercentLayoutHelper.m427b(childAt2, a2)) {
                        layoutParams2.height = -2;
                        size2 = 1;
                    }
                }
            }
            i3++;
        }
        if (size2 != 0) {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        z = this.f802a;
        i = z.f815a.getChildCount();
        for (i2 = 0; i2 < i; i2++) {
            i3 = z.f815a.getChildAt(i2).getLayoutParams();
            if ((i3 instanceof PercentLayoutParams) != 0) {
                i4 = ((PercentLayoutParams) i3).mo127a();
                if (i4 != 0) {
                    if (i3 instanceof MarginLayoutParams) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) i3;
                        i4.m417a(marginLayoutParams);
                        marginLayoutParams.leftMargin = i4.f812j.leftMargin;
                        marginLayoutParams.topMargin = i4.f812j.topMargin;
                        marginLayoutParams.rightMargin = i4.f812j.rightMargin;
                        marginLayoutParams.bottomMargin = i4.f812j.bottomMargin;
                        MarginLayoutParamsCompat.m1102a(marginLayoutParams, MarginLayoutParamsCompat.m1101a(i4.f812j));
                        MarginLayoutParamsCompat.m1104b(marginLayoutParams, MarginLayoutParamsCompat.m1103b(i4.f812j));
                    } else {
                        i4.m417a(i3);
                    }
                }
            }
        }
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m44253generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
