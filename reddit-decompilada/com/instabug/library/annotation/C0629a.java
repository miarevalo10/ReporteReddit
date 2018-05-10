package com.instabug.library.annotation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;

/* compiled from: ControlButton */
public class C0629a {
    public PointF f9524a = new PointF();
    public int f9525b;
    private final Paint f9526c = new Paint(1);

    public final void m8053a(float f, float f2) {
        this.f9524a = new PointF(f, f2);
    }

    public final boolean m8055a(PointF pointF) {
        float f = this.f9524a.x - pointF.x;
        float f2 = this.f9524a.y - pointF.y;
        return (f * f) + (f2 * f2) <= 1764.0f ? true : null;
    }

    public final void m8054a(Canvas canvas) {
        this.f9526c.setColor(this.f9525b);
        this.f9526c.setStyle(Style.FILL);
        canvas.drawCircle(this.f9524a.x, this.f9524a.y, 12.0f, this.f9526c);
        this.f9526c.setColor(-1);
        this.f9526c.setStyle(Style.STROKE);
        this.f9526c.setStrokeWidth(2.0f);
        canvas.drawCircle(this.f9524a.x, this.f9524a.y, 12.0f, this.f9526c);
    }
}
