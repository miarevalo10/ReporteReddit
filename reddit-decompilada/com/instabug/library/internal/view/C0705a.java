package com.instabug.library.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.TextView;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: BubbleTextView */
public class C0705a extends TextView {
    private RectF f9683a = new RectF();
    private Paint f9684b = new Paint(1);
    private float f9685c;
    private PointF f9686d;
    private PointF f9687e;
    private PointF f9688f;
    private Path f9689g;
    private float f9690h;

    public C0705a(Context context) {
        super(context);
        setTextColor(-1);
        this.f9684b.setColor(-12303292);
        this.f9684b.setStyle(Style.FILL);
        this.f9685c = TypedValue.applyDimension(1, 7.0f, getContext().getResources().getDisplayMetrics());
        this.f9690h = this.f9685c / 2.0f;
        context = (int) this.f9685c;
        setPadding((int) (((double) this.f9685c) * 1.5d), context, (int) ((1.5d * ((double) this.f9685c)) + ((double) this.f9685c)), context);
        this.f9686d = new PointF();
        this.f9687e = new PointF();
        this.f9688f = new PointF();
        this.f9689g = new Path();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i = getMeasuredHeight();
        i2 = getMeasuredWidth();
        setMeasuredDimension(i2, i);
        i2 = (float) i2;
        this.f9683a.right = i2 - this.f9685c;
        this.f9683a.bottom = (float) i;
        this.f9686d.x = i2;
        this.f9686d.y = this.f9683a.centerY();
        float cos = (float) (((double) this.f9685c) / Math.cos(45.0d));
        C0635b.m8079a(cos, 225.0f, this.f9686d, this.f9687e);
        C0635b.m8079a(cos, 135.0f, this.f9686d, this.f9688f);
        this.f9689g.moveTo(this.f9687e.x, this.f9687e.y);
        this.f9689g.lineTo(this.f9686d.x, this.f9686d.y);
        this.f9689g.lineTo(this.f9688f.x, this.f9688f.y);
        this.f9689g.close();
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.f9683a, this.f9690h, this.f9690h, this.f9684b);
        canvas.drawPath(this.f9689g, this.f9684b);
        super.onDraw(canvas);
    }
}
