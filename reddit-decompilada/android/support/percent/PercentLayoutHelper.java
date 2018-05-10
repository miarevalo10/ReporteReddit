package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

@Deprecated
public class PercentLayoutHelper {
    final ViewGroup f815a;

    @Deprecated
    public static class PercentLayoutInfo {
        public float f803a = -1.0f;
        public float f804b = -1.0f;
        public float f805c = -1.0f;
        public float f806d = -1.0f;
        public float f807e = -1.0f;
        public float f808f = -1.0f;
        public float f809g = -1.0f;
        public float f810h = -1.0f;
        public float f811i;
        final PercentMarginLayoutParams f812j = new PercentMarginLayoutParams();

        public final void m418a(LayoutParams layoutParams, int i, int i2) {
            this.f812j.width = layoutParams.width;
            this.f812j.height = layoutParams.height;
            boolean z = false;
            boolean z2 = (this.f812j.f814b || this.f812j.width == 0) && this.f803a < 0.0f;
            if ((this.f812j.f813a || this.f812j.height == 0) && this.f804b < 0.0f) {
                z = true;
            }
            if (this.f803a >= 0.0f) {
                layoutParams.width = Math.round(((float) i) * this.f803a);
            }
            if (this.f804b >= 0) {
                layoutParams.height = Math.round(((float) i2) * this.f804b);
            }
            if (this.f811i >= 0) {
                if (z2) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * this.f811i);
                    this.f812j.f814b = true;
                }
                if (z) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.f811i);
                    this.f812j.f813a = true;
                }
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.f803a), Float.valueOf(this.f804b), Float.valueOf(this.f805c), Float.valueOf(this.f806d), Float.valueOf(this.f807e), Float.valueOf(this.f808f), Float.valueOf(this.f809g), Float.valueOf(this.f810h)});
        }

        public final void m417a(LayoutParams layoutParams) {
            if (!this.f812j.f814b) {
                layoutParams.width = this.f812j.width;
            }
            if (!this.f812j.f813a) {
                layoutParams.height = this.f812j.height;
            }
            this.f812j.f814b = false;
            this.f812j.f813a = false;
        }
    }

    @Deprecated
    public interface PercentLayoutParams {
        PercentLayoutInfo mo127a();
    }

    static class PercentMarginLayoutParams extends MarginLayoutParams {
        private boolean f813a;
        private boolean f814b;

        public PercentMarginLayoutParams() {
            super(0, 0);
        }
    }

    public PercentLayoutHelper(ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("host must be non-null");
        }
        this.f815a = viewGroup;
    }

    public static void m425a(LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    public static PercentLayoutInfo m424a(Context context, AttributeSet attributeSet) {
        PercentLayoutInfo percentLayoutInfo;
        context = context.obtainStyledAttributes(attributeSet, C0060R.styleable.PercentLayout_Layout);
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            percentLayoutInfo = new PercentLayoutInfo();
            percentLayoutInfo.f803a = attributeSet;
        } else {
            percentLayoutInfo = null;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f804b = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f805c = attributeSet;
            percentLayoutInfo.f806d = attributeSet;
            percentLayoutInfo.f807e = attributeSet;
            percentLayoutInfo.f808f = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f805c = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f806d = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f807e = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f808f = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f809g = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f810h = attributeSet;
        }
        attributeSet = context.getFraction(C0060R.styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (attributeSet != -1082130432) {
            if (percentLayoutInfo == null) {
                percentLayoutInfo = new PercentLayoutInfo();
            }
            percentLayoutInfo.f811i = attributeSet;
        }
        context.recycle();
        return percentLayoutInfo;
    }

    static boolean m426a(View view, PercentLayoutInfo percentLayoutInfo) {
        return ((view.getMeasuredWidthAndState() & -16777216) == 16777216 && percentLayoutInfo.f803a >= 0.0f && percentLayoutInfo.f812j.width == -2) ? true : null;
    }

    static boolean m427b(View view, PercentLayoutInfo percentLayoutInfo) {
        return ((view.getMeasuredHeightAndState() & -16777216) == 16777216 && percentLayoutInfo.f804b >= 0.0f && percentLayoutInfo.f812j.height == -2) ? true : null;
    }
}
