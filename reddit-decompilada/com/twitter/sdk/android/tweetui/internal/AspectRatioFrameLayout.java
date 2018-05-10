package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.C2075R;

public class AspectRatioFrameLayout extends FrameLayout {
    protected double f24222a;
    private int f24223b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = getContext().getTheme().obtainStyledAttributes(i, C2075R.styleable.AspectRatioFrameLayout);
        try {
            this.f24222a = (double) context.getFloat(C2075R.styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1065353216);
            this.f24223b = context.getInt(C2075R.styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            context.recycle();
        }
    }

    public void setAspectRatio(double d) {
        this.f24222a = d;
    }

    public double getAspectRatio() {
        return this.f24222a;
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f24223b == 0) {
            if (MeasureSpec.getMode(i) == 1073741824) {
                i = MeasureSpec.getSize(i) - paddingLeft;
            } else {
                super.onMeasure(i, i2);
                i = getMeasuredWidth() - paddingLeft;
            }
            i2 = (int) (((double) i) / this.f24222a);
        } else {
            if (MeasureSpec.getMode(i2) == 1073741824) {
                i = MeasureSpec.getSize(i2) - paddingBottom;
            } else {
                super.onMeasure(i, i2);
                i = getMeasuredHeight() - paddingBottom;
            }
            i2 = i;
            i = (int) (((double) i2) * this.f24222a);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i + paddingLeft, 1073741824), MeasureSpec.makeMeasureSpec(i2 + paddingBottom, 1073741824));
    }
}
