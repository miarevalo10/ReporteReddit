package com.reddit.frontpage.ui.tokenautocomplete;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

public class ViewSpan extends ReplacementSpan {
    private int f21685a;
    protected View f21686c;

    public ViewSpan(View view, int i) {
        this.f21685a = i;
        this.f21686c = view;
        this.f21686c.setLayoutParams(new LayoutParams(-2, -2));
    }

    private void mo5022a() {
        this.f21686c.measure(MeasureSpec.makeMeasureSpec(this.f21685a, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        this.f21686c.layout(0, 0, this.f21686c.getMeasuredWidth(), this.f21686c.getMeasuredHeight());
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        mo5022a();
        canvas.save();
        canvas.translate(f, (float) ((i5 - this.f21686c.getBottom()) - (((i5 - i3) - this.f21686c.getBottom()) / 2)));
        this.f21686c.draw(canvas);
        canvas.restore();
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        mo5022a();
        if (fontMetricsInt != null) {
            paint = this.f21686c.getMeasuredHeight() - (fontMetricsInt.descent - fontMetricsInt.ascent);
            if (paint > null) {
                charSequence = paint / 2;
                paint -= charSequence;
                fontMetricsInt.descent += paint;
                fontMetricsInt.ascent -= charSequence;
                fontMetricsInt.bottom += paint;
                fontMetricsInt.top -= charSequence;
            }
        }
        return this.f21686c.getRight();
    }
}
