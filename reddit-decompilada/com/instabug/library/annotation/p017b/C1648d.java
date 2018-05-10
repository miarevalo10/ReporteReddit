package com.instabug.library.annotation.p017b;

import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: OvalShape */
public class C1648d extends C1352f {
    public C1648d(int i, float f, int i2) {
        super(i, f, i2);
    }

    public final void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        C0635b.m8080a(canvas, pointF, pointF2, this.d);
        C0635b.m8080a(canvas, pointF, pointF4, this.d);
        C0635b.m8080a(canvas, pointF2, pointF3, this.d);
        C0635b.m8080a(canvas, pointF3, pointF4, this.d);
    }

    protected final void mo3675a(C0633b c0633b) {
        RectF rectF = c0633b;
        this.b.reset();
        if (this.a != 0) {
            if (r0.a != 180) {
                PointF a = C0635b.m8077a(rectF.f9539e, rectF.f9540f);
                PointF a2 = C0635b.m8077a(rectF.f9539e, a);
                PointF a3 = C0635b.m8077a(rectF.f9540f, a);
                PointF a4 = C0635b.m8077a(rectF.f9540f, rectF.f9541g);
                PointF a5 = C0635b.m8077a(rectF.f9540f, a4);
                PointF a6 = C0635b.m8077a(rectF.f9541g, a4);
                PointF a7 = C0635b.m8077a(rectF.f9541g, rectF.f9542h);
                PointF a8 = C0635b.m8077a(rectF.f9541g, a7);
                PointF a9 = C0635b.m8077a(rectF.f9542h, a7);
                PointF a10 = C0635b.m8077a(rectF.f9542h, rectF.f9539e);
                PointF a11 = C0635b.m8077a(rectF.f9542h, a10);
                PointF a12 = C0635b.m8077a(rectF.f9539e, a10);
                r0.b.moveTo(a.x, a.y);
                PointF pointF = a;
                r0.b.cubicTo(a3.x, a3.y, a5.x, a5.y, a4.x, a4.y);
                r0.b.cubicTo(a6.x, a6.y, a8.x, a8.y, a7.x, a7.y);
                r0.b.cubicTo(a9.x, a9.y, a11.x, a11.y, a10.x, a10.y);
                a5 = pointF;
                r0.b.cubicTo(a12.x, a12.y, a2.x, a2.y, a5.x, a5.y);
                r0.b.close();
                return;
            }
        }
        r0.b.addOval(rectF, Direction.CW);
    }

    protected final void mo3674a(Canvas canvas, C0633b c0633b) {
        canvas.drawPath(mo2580b(c0633b), this.e);
    }
}
