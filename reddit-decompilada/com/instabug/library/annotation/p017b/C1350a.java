package com.instabug.library.annotation.p017b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import com.instabug.library.annotation.C0629a;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.C0633b.C0630a;
import com.instabug.library.annotation.C0633b.C0631b;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: ArrowShape */
public class C1350a extends C0632g {
    public final PointF f15451a;
    public final PointF f15452b;
    public String f15453c;
    private final Paint f15454f = new Paint(1);

    public final void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    public C1350a(PointF pointF, PointF pointF2, int i, float f) {
        super(i, f);
        this.f15454f.setColor(i);
        this.f15454f.setStyle(Style.STROKE);
        this.f15454f.setStrokeWidth(f);
        this.f15451a = pointF;
        this.f15452b = pointF2;
    }

    public final void mo2575a(Canvas canvas, C0633b c0633b, C0633b c0633b2) {
        if (c0633b.f9535a == C0630a.RIGHT) {
            this.f15451a.x = c0633b.right;
        } else if (c0633b.f9535a == C0630a.LEFT) {
            this.f15451a.x = c0633b.left;
        }
        if (c0633b.f9536b == C0631b.TOP) {
            this.f15451a.y = c0633b.top;
        } else if (c0633b.f9536b == C0631b.BOTTOM) {
            this.f15451a.y = c0633b.bottom;
        }
        if (c0633b.f9537c == C0630a.RIGHT) {
            this.f15452b.x = c0633b.right;
        } else if (c0633b.f9537c == C0630a.LEFT) {
            this.f15452b.x = c0633b.left;
        }
        if (c0633b.f9538d == C0631b.TOP) {
            this.f15452b.y = c0633b.top;
        } else if (c0633b.f9538d == C0631b.BOTTOM) {
            this.f15452b.y = c0633b.bottom;
        }
        canvas.drawPath(mo2580b(c0633b), this.f15454f);
    }

    public final boolean mo2579a(PointF pointF, C0633b c0633b) {
        m15353a(c0633b);
        c0633b = C0635b.m8074a(this.f15452b.x, this.f15452b.y, this.f15451a.x, this.f15451a.y);
        float f = 90.0f + c0633b;
        PointF a = C0635b.m8076a(60.0f, f, this.f15451a);
        float f2 = c0633b + 270.0f;
        PointF a2 = C0635b.m8076a(60.0f, f2, this.f15451a);
        c0633b = C0635b.m8076a(60.0f, f2, this.f15452b);
        PointF a3 = C0635b.m8076a(60.0f, f, this.f15452b);
        Region region = new Region();
        RectF rectF = new RectF();
        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(a2.x, a2.y);
        path.lineTo(c0633b.x, c0633b.y);
        path.lineTo(a3.x, a3.y);
        path.close();
        path.computeBounds(rectF, true);
        region.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return region.contains((int) pointF.x, (int) pointF.y);
    }

    public final void m15353a(C0633b c0633b) {
        if (this.f15451a.x < this.f15452b.x) {
            c0633b.left = this.f15451a.x;
            c0633b.right = this.f15452b.x;
            c0633b.f9535a = C0630a.LEFT;
            c0633b.f9537c = C0630a.RIGHT;
        } else {
            c0633b.right = this.f15451a.x;
            c0633b.left = this.f15452b.x;
            c0633b.f9535a = C0630a.RIGHT;
            c0633b.f9537c = C0630a.LEFT;
        }
        if (this.f15451a.y < this.f15452b.y) {
            c0633b.top = this.f15451a.y;
            c0633b.bottom = this.f15452b.y;
            c0633b.f9536b = C0631b.TOP;
            c0633b.f9538d = C0631b.BOTTOM;
            return;
        }
        c0633b.bottom = this.f15451a.y;
        c0633b.top = this.f15452b.y;
        c0633b.f9536b = C0631b.BOTTOM;
        c0633b.f9538d = C0631b.TOP;
    }

    public final void mo2576a(Canvas canvas, C0633b c0633b, C0629a[] c0629aArr) {
        c0633b = this.f15454f.getColor();
        int i = 0;
        c0629aArr[0].f9524a = this.f15451a;
        c0629aArr[1].f9524a = this.f15452b;
        while (i < 2) {
            c0629aArr[i].f9525b = c0633b;
            c0629aArr[i].m8054a(canvas);
            i++;
        }
    }

    public final void mo2577a(C0633b c0633b, C0633b c0633b2, int i, int i2) {
        i = (float) i;
        c0633b.left = c0633b2.left + i;
        i2 = (float) i2;
        c0633b.top = c0633b2.top + i2;
        c0633b.right = c0633b2.right + i;
        c0633b.bottom = c0633b2.bottom + i2;
    }

    public final Path mo2580b(C0633b c0633b) {
        c0633b = new Path();
        float a = C0635b.m8074a(this.f15452b.x, this.f15452b.y, this.f15451a.x, this.f15451a.y);
        PointF a2 = C0635b.m8076a(60.0f, 225.0f + a, this.f15452b);
        PointF a3 = C0635b.m8076a(60.0f, a + 135.0f, this.f15452b);
        c0633b.moveTo(this.f15451a.x, this.f15451a.y);
        c0633b.lineTo(this.f15452b.x + 1.0f, this.f15452b.y + 1.0f);
        if ("arrow".equals(this.f15453c)) {
            c0633b.moveTo(a2.x, a2.y);
            c0633b.lineTo(this.f15452b.x, this.f15452b.y);
            c0633b.lineTo(a3.x, a3.y);
        }
        return c0633b;
    }

    public final void mo2578a(C0633b c0633b, C0633b c0633b2, boolean z) {
        c0633b2.m8065a(c0633b);
    }
}
