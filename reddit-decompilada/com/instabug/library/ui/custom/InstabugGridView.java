package com.instabug.library.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

public class InstabugGridView extends GridView {
    public InstabugGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstabugGridView(Context context) {
        super(context);
    }

    public InstabugGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
