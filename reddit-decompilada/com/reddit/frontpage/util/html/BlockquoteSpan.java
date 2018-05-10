package com.reddit.frontpage.util.html;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.style.QuoteSpan;

@SuppressLint({"ParcelCreator"})
public class BlockquoteSpan extends QuoteSpan {
    private final int f21825a;
    private final int f21826b;

    public BlockquoteSpan(int i, int i2, int i3) {
        super(i);
        this.f21825a = i2;
        this.f21826b = i3;
    }

    public int getLeadingMargin(boolean z) {
        return this.f21826b + this.f21825a;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Paint paint2 = paint;
        int i8 = i;
        Style style = paint2.getStyle();
        int color = paint2.getColor();
        paint2.setStyle(Style.FILL);
        paint2.setColor(getColor());
        canvas.drawRect((float) i8, (float) i3, (float) (i8 + (this.f21826b * i2)), (float) i5, paint2);
        paint2.setStyle(style);
        paint2.setColor(color);
    }
}
