package com.instabug.library.annotation.p017b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.instabug.library.annotation.C0629a;
import com.instabug.library.annotation.C0633b;

/* compiled from: Shape */
public abstract class C0632g {
    protected final Paint f9533d;
    protected Paint f9534e = new Paint(1);

    public abstract void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4);

    public abstract void mo2575a(Canvas canvas, C0633b c0633b, C0633b c0633b2);

    public abstract void mo2577a(C0633b c0633b, C0633b c0633b2, int i, int i2);

    public abstract void mo2578a(C0633b c0633b, C0633b c0633b2, boolean z);

    public abstract boolean mo2579a(PointF pointF, C0633b c0633b);

    public abstract Path mo2580b(C0633b c0633b);

    C0632g(int i, float f) {
        this.f9534e.setColor(i);
        this.f9534e.setStyle(Style.STROKE);
        this.f9534e.setStrokeWidth(f);
        this.f9534e.setStrokeCap(Cap.ROUND);
        this.f9533d = new Paint(1);
        this.f9533d.setColor(-0.0f);
    }

    public final float m8062b() {
        return this.f9534e.getStrokeWidth();
    }

    public void mo2576a(Canvas canvas, C0633b c0633b, C0629a[] c0629aArr) {
        int color = this.f9534e.getColor();
        c0633b = c0633b.m8069e();
        for (int i = 0; i < c0629aArr.length; i++) {
            c0629aArr[i].f9524a = c0633b[i];
            c0629aArr[i].f9525b = color;
            c0629aArr[i].m8054a(canvas);
        }
    }
}
