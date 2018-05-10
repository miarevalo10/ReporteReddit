package com.reddit.frontpage.widgets.comment;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import com.reddit.frontpage.C1761R;

public class CommentIndentView extends View {
    private int f21983a;
    private int[] f21984b;
    private int f21985c;
    private int f21986d;
    private ShapeDrawable f21987e;
    private int f21988f;
    private int f21989g;

    public CommentIndentView(Context context) {
        this(context, null);
    }

    public CommentIndentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentIndentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24212a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public CommentIndentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24212a(context, attributeSet, i, i2);
    }

    private void m24212a(Context context, AttributeSet attributeSet, int i, int i2) {
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.CommentIndentView, i, i2);
        try {
            this.f21984b = context.getResources().getIntArray(context.getResourceId(2, -1));
            this.f21983a = context.getDimensionPixelSize(0, 1);
            this.f21985c = context.getDimensionPixelSize(3, 0);
            this.f21986d = context.getDimensionPixelOffset(1, 0);
            this.f21987e = new ShapeDrawable(new RectShape());
        } finally {
            context.recycle();
        }
    }

    public final void m24213a(int i, int i2) {
        this.f21988f = i;
        this.f21989g = i2;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f21988f * this.f21983a, getDefaultSize(getSuggestedMinimumHeight(), i2));
    }

    protected void onDraw(Canvas canvas) {
        int length = this.f21984b.length;
        int height = getHeight();
        int i = this.f21983a;
        int i2 = 0;
        while (i2 < this.f21988f) {
            int i3 = i2 >= this.f21989g ? this.f21986d : 0;
            this.f21987e.getPaint().setColor(this.f21984b[i2 % length]);
            this.f21987e.setBounds(i - this.f21985c, 0, i, height - i3);
            this.f21987e.draw(canvas);
            i += this.f21983a;
            i2++;
        }
    }
}
