package com.instabug.library.annotation;

import android.graphics.Canvas;
import android.graphics.PointF;
import com.instabug.library.annotation.p017b.C0632g;
import java.util.Stack;

/* compiled from: MarkUpDrawable */
public class C0636c {
    protected C0632g f9545a;
    protected C0632g f9546b;
    protected C0633b f9547c = new C0633b();
    protected C0633b f9548d = new C0633b();
    private Stack<C0633b> f9549e = new Stack();

    public C0636c(C0632g c0632g) {
        this.f9545a = c0632g;
        this.f9546b = c0632g;
    }

    public final void m8087a(C0633b c0633b) {
        this.f9547c = c0633b;
        this.f9548d.m8065a(c0633b);
    }

    public final boolean m8088a(PointF pointF) {
        return this.f9548d.f9544j ? this.f9545a.mo2579a(pointF, this.f9547c) : null;
    }

    protected final void m8084a(Canvas canvas) {
        if (this.f9548d.f9544j) {
            canvas.save();
            this.f9545a.mo2575a(canvas, this.f9547c, this.f9548d);
            canvas.restore();
        }
    }

    private void m8081c(C0633b c0633b) {
        if (this.f9548d != null) {
            this.f9549e.push(new C0633b(this.f9548d));
        }
        this.f9548d = c0633b;
    }

    public final void m8082a() {
        m8081c(new C0633b(this.f9547c));
    }

    public final void m8089b() {
        C0633b c0633b = new C0633b(this.f9547c);
        c0633b.f9544j = false;
        m8081c(c0633b);
    }

    public final boolean m8092c() {
        if (this.f9549e.size() <= 0) {
            return false;
        }
        this.f9548d = (C0633b) this.f9549e.pop();
        if (this.f9549e.size() == 0) {
            this.f9545a = this.f9546b;
        }
        this.f9545a.mo2578a(this.f9548d, this.f9547c, true);
        return true;
    }

    public final void m8083a(int i, int i2) {
        this.f9545a.mo2577a(this.f9547c, this.f9548d, i, i2);
    }

    public final C0632g m8093d() {
        return this.f9545a;
    }

    public final void m8091b(C0633b c0633b) {
        this.f9545a.mo2578a(c0633b, this.f9547c, false);
    }

    public final void m8085a(Canvas canvas, C0629a... c0629aArr) {
        this.f9545a.mo2576a(canvas, this.f9547c, c0629aArr);
    }

    public final void m8090b(Canvas canvas) {
        this.f9545a.mo2574a(canvas, this.f9547c.m8064a(), this.f9547c.m8066b(), this.f9547c.m8067c(), this.f9547c.m8068d());
    }

    public final void m8086a(C0632g c0632g, C0633b c0633b) {
        m8081c(new C0633b(c0633b));
        this.f9545a = c0632g;
    }

    public final boolean m8094e() {
        return this.f9548d.f9544j;
    }
}
