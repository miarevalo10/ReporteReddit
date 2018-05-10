package com.instabug.library.annotation;

import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: DirectionRectF */
public class C0633b extends RectF {
    public C0630a f9535a;
    public C0631b f9536b;
    public C0630a f9537c;
    public C0631b f9538d;
    public PointF f9539e = new PointF();
    public PointF f9540f = new PointF();
    public PointF f9541g = new PointF();
    public PointF f9542h = new PointF();
    public boolean f9543i = false;
    boolean f9544j = true;

    /* compiled from: DirectionRectF */
    public enum C0630a {
        LEFT,
        RIGHT
    }

    /* compiled from: DirectionRectF */
    public enum C0631b {
        TOP,
        BOTTOM
    }

    public C0633b(C0633b c0633b) {
        m8065a(c0633b);
    }

    public C0633b(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public final void m8065a(C0633b c0633b) {
        if (c0633b == null) {
            this.bottom = 0.0f;
            this.right = 0.0f;
            this.top = 0.0f;
            this.left = 0.0f;
            this.f9537c = null;
            this.f9535a = null;
            this.f9538d = null;
            this.f9536b = null;
            this.f9539e.set(0.0f, 0.0f);
            this.f9540f.set(0.0f, 0.0f);
            this.f9541g.set(0.0f, 0.0f);
            this.f9542h.set(0.0f, 0.0f);
            this.f9543i = null;
            this.f9544j = true;
            return;
        }
        this.left = c0633b.left;
        this.top = c0633b.top;
        this.right = c0633b.right;
        this.bottom = c0633b.bottom;
        this.f9535a = c0633b.f9535a;
        this.f9536b = c0633b.f9536b;
        this.f9537c = c0633b.f9537c;
        this.f9538d = c0633b.f9538d;
        this.f9539e.set(c0633b.f9539e);
        this.f9540f.set(c0633b.f9540f);
        this.f9541g.set(c0633b.f9541g);
        this.f9542h.set(c0633b.f9542h);
        this.f9543i = c0633b.f9543i;
        this.f9544j = c0633b.f9544j;
    }

    public final PointF m8064a() {
        return new PointF(this.left, this.top);
    }

    public final PointF m8066b() {
        return new PointF(this.right, this.top);
    }

    public final PointF m8067c() {
        return new PointF(this.right, this.bottom);
    }

    public final PointF m8068d() {
        return new PointF(this.left, this.bottom);
    }

    public final PointF[] m8069e() {
        return new PointF[]{m8064a(), m8066b(), m8067c(), m8068d()};
    }
}
