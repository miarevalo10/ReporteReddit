package org.sufficientlysecure.htmltextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;

public class NumberSpan implements LeadingMarginSpan {
    private final String f27252a;
    private final int f27253b;

    public NumberSpan(TextPaint textPaint, int i) {
        this.f27252a = Integer.toString(i).concat(". ");
        this.f27253b = (int) textPaint.measureText(this.f27252a);
    }

    public int getLeadingMargin(boolean z) {
        return this.f27253b;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if ((charSequence instanceof Spanned) != 0 && ((Spanned) charSequence).getSpanStart(this) == i6) {
            canvas.drawText(this.f27252a, (float) i, (float) i4, paint);
        }
    }
}
