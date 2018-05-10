package com.reddit.frontpage.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class WhenView extends AppCompatTextView {
    public WhenView(Context context) {
        super(context);
        setSingleLine(true);
    }

    public WhenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSingleLine(true);
    }

    public WhenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSingleLine(true);
    }
}
