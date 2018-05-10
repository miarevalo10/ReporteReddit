package org.sufficientlysecure.htmltextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.style.ReplacementSpan;

public class DrawTableLinkSpan extends ReplacementSpan {
    private static float f27235d = 80.0f;
    private static int f27236e = -16776961;
    protected String f27237a = "";
    protected float f27238b = f27235d;
    protected int f27239c = f27236e;

    public final DrawTableLinkSpan m28720a() {
        DrawTableLinkSpan drawTableLinkSpan = new DrawTableLinkSpan();
        drawTableLinkSpan.f27237a = this.f27237a;
        drawTableLinkSpan.f27238b = this.f27238b;
        drawTableLinkSpan.f27239c = this.f27239c;
        return drawTableLinkSpan;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        charSequence = (int) paint.measureText(this.f27237a, 0, this.f27237a.length());
        this.f27238b = paint.getTextSize();
        return charSequence;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        charSequence = new Paint();
        charSequence.setStyle(Style.STROKE);
        charSequence.setColor(this.f27239c);
        charSequence.setAntiAlias(1);
        charSequence.setTextSize(this.f27238b);
        canvas.drawText(this.f27237a, f, (float) i5, charSequence);
    }

    public final void m28722a(String str) {
        this.f27237a = str;
    }

    public final void m28721a(int i) {
        this.f27239c = i;
    }
}
