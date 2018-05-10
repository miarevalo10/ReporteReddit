package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {
    private float f5155a;
    private int f5156b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5156b = 0;
        if (attributeSet != null) {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C0422R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f5156b = context.getInt(C0422R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                context.recycle();
            }
        }
    }

    public final void setAspectRatio(float f) {
        if (this.f5155a != f) {
            this.f5155a = f;
            requestLayout();
        }
    }

    public final int getResizeMode() {
        return this.f5156b;
    }

    public final void setResizeMode(int i) {
        if (this.f5156b != i) {
            this.f5156b = i;
            requestLayout();
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5156b != 3) {
            if (this.f5155a > 0) {
                i = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f = (float) i;
                float f2 = (float) measuredHeight;
                float f3 = (this.f5155a / (f / f2)) - 1.0f;
                if (Math.abs(f3) > 0.01f) {
                    int i3 = this.f5156b;
                    if (i3 != 4) {
                        switch (i3) {
                            case 1:
                                measuredHeight = (int) (f / this.f5155a);
                                break;
                            case 2:
                                i = (int) (f2 * this.f5155a);
                                break;
                            default:
                                if (f3 > 0.0f) {
                                    measuredHeight = (int) (f / this.f5155a);
                                    break;
                                }
                                break;
                        }
                    } else if (f3 <= 0.0f) {
                        measuredHeight = (int) (f / this.f5155a);
                        super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                    }
                    i = (int) (f2 * this.f5155a);
                    super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                }
            }
        }
    }
}
