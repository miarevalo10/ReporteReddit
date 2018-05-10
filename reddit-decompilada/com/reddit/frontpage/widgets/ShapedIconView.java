package com.reddit.frontpage.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.reddit.frontpage.C1761R;

public class ShapedIconView extends BezelImageView {
    private Drawable f37431a;
    private Drawable f37432b;
    private Drawable f37433c;
    private Drawable f37434d;
    private Drawable f37435e;
    private Drawable f37436f;
    private int f37437g;

    public ShapedIconView(Context context) {
        this(context, null);
    }

    public ShapedIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1761R.attr.shaped_icon_view_style);
    }

    public ShapedIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f37437g = 0;
        context = context.obtainStyledAttributes(attributeSet, C1761R.styleable.ShapedIconView, i, 0);
        this.f37434d = context.getDrawable(2);
        this.f37435e = context.getDrawable(1);
        this.f37436f = context.getDrawable(0);
        this.f37431a = context.getDrawable(5);
        this.f37432b = context.getDrawable(4);
        this.f37433c = context.getDrawable(3);
        context.recycle();
    }

    public void setShape(int i) {
        if (this.f37437g != i) {
            this.f37437g = i;
            if (i == 2) {
                setMaskDrawable(this.f37434d);
                setBorderDrawable(this.f37435e);
                setBackground(this.f37436f);
                return;
            }
            setMaskDrawable(this.f37431a);
            setBorderDrawable(this.f37432b);
            setBackground(this.f37433c);
        }
    }
}
