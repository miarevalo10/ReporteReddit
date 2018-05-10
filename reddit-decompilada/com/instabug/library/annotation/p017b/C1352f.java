package com.instabug.library.annotation.p017b;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.C0629a;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: RectShape */
public class C1352f extends C0632g {
    protected int f15456a;
    protected Path f15457b = new Path();

    public void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    public C1352f(int i, float f, int i2) {
        super(i, f);
        this.f15456a = i2;
    }

    public void mo2575a(Canvas canvas, C0633b c0633b, C0633b c0633b2) {
        if (m15370a() && !c0633b.f9543i) {
            c0633b2.f9543i = true;
            float centerX = c0633b.centerX();
            float centerY = c0633b.centerY();
            PointF a = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.left, c0633b.top));
            PointF a2 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.right, c0633b.top));
            PointF a3 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.right, c0633b.bottom));
            PointF a4 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.left, c0633b.bottom));
            c0633b2.f9539e.set(a);
            c0633b2.f9540f.set(a2);
            c0633b2.f9541g.set(a3);
            c0633b2.f9542h.set(a4);
        }
        mo3674a(canvas, c0633b);
    }

    public boolean mo2579a(PointF pointF, C0633b c0633b) {
        if (m15370a()) {
            c0633b = new RectF(pointF.x - 50.0f, pointF.y - 50.0f, pointF.x + 50.0f, pointF.y + 1112014848);
            for (PointF pointF2 : C0635b.m8078a(this.f15457b)) {
                if (c0633b.contains(pointF2.x, pointF2.y)) {
                    return true;
                }
            }
            return false;
        }
        RectF rectF = new RectF(c0633b);
        rectF.inset(50.0f, 50.0f);
        RectF rectF2 = new RectF(c0633b);
        rectF2.inset(-50.0f, -50.0f);
        return rectF2.contains(pointF.x, pointF.y) != null && rectF.contains(pointF.x, pointF.y) == null;
    }

    public void mo2578a(C0633b c0633b, C0633b c0633b2, boolean z) {
        if (!m15370a() || z) {
            c0633b2.m8065a(c0633b);
        }
    }

    public final void mo2576a(Canvas canvas, C0633b c0633b, C0629a[] c0629aArr) {
        int i = 0;
        if (m15370a()) {
            c0629aArr[0].m8053a(c0633b.f9539e.x, c0633b.f9539e.y);
            c0629aArr[1].m8053a(c0633b.f9540f.x, c0633b.f9540f.y);
            c0629aArr[2].m8053a(c0633b.f9541g.x, c0633b.f9541g.y);
            c0629aArr[3].m8053a(c0633b.f9542h.x, c0633b.f9542h.y);
        } else {
            c0629aArr[0].m8053a(c0633b.left, c0633b.top);
            c0629aArr[1].m8053a(c0633b.right, c0633b.top);
            c0629aArr[2].m8053a(c0633b.right, c0633b.bottom);
            c0629aArr[3].m8053a(c0633b.left, c0633b.bottom);
        }
        c0633b = this.e.getColor();
        while (i < c0629aArr.length) {
            c0629aArr[i].f9525b = c0633b;
            c0629aArr[i].m8054a(canvas);
            i++;
        }
    }

    public final void mo2577a(C0633b c0633b, C0633b c0633b2, int i, int i2) {
        i = (float) i;
        i2 = (float) i2;
        c0633b.f9539e.set(c0633b2.f9539e.x + i, c0633b2.f9539e.y + i2);
        c0633b.f9540f.set(c0633b2.f9540f.x + i, c0633b2.f9540f.y + i2);
        c0633b.f9541g.set(c0633b2.f9541g.x + i, c0633b2.f9541g.y + i2);
        c0633b.f9542h.set(c0633b2.f9542h.x + i, c0633b2.f9542h.y + i2);
        c0633b.left = c0633b2.left + i;
        c0633b.top = c0633b2.top + i2;
        c0633b.right = c0633b2.right + i;
        c0633b.bottom = c0633b2.bottom + i2;
    }

    public final void m15362a(float f, float f2, C0633b c0633b, boolean z) {
        c0633b.f9539e.set(f, f2);
        f = (float) C0635b.m8073a(c0633b.f9541g, c0633b.f9540f, c0633b.f9539e);
        if (c0633b.f9539e.x >= c0633b.f9540f.x) {
            if (c0633b.f9539e.y >= c0633b.f9540f.y) {
                if (c0633b.f9539e.x > c0633b.f9540f.x || c0633b.f9539e.y > c0633b.f9540f.y) {
                    C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9539e, c0633b.f9540f);
                }
                f = (float) C0635b.m8073a(c0633b.f9541g, c0633b.f9542h, c0633b.f9539e);
                if (c0633b.f9539e.y >= c0633b.f9542h.y) {
                    if (c0633b.f9539e.x > c0633b.f9542h.x) {
                        if (c0633b.f9539e.y > c0633b.f9542h.y || c0633b.f9539e.x < c0633b.f9542h.x) {
                            C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9539e, c0633b.f9542h);
                        }
                        if (!z) {
                            m15374c(c0633b.f9541g.x, c0633b.f9541g.y, c0633b, false);
                        }
                    }
                }
                C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9539e, c0633b.f9542h);
                if (!z) {
                    m15374c(c0633b.f9541g.x, c0633b.f9541g.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) this.f15456a, c0633b.f9539e, c0633b.f9540f);
        f = (float) C0635b.m8073a(c0633b.f9541g, c0633b.f9542h, c0633b.f9539e);
        if (c0633b.f9539e.y >= c0633b.f9542h.y) {
            if (c0633b.f9539e.x > c0633b.f9542h.x) {
                C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9539e, c0633b.f9542h);
                if (!z) {
                    m15374c(c0633b.f9541g.x, c0633b.f9541g.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9539e, c0633b.f9542h);
        if (!z) {
            m15374c(c0633b.f9541g.x, c0633b.f9541g.y, c0633b, false);
        }
    }

    public final void m15373b(float f, float f2, C0633b c0633b, boolean z) {
        c0633b.f9540f.set(f, f2);
        f = (float) C0635b.m8073a(c0633b.f9542h, c0633b.f9539e, c0633b.f9540f);
        if (c0633b.f9540f.x <= c0633b.f9539e.x) {
            if (c0633b.f9540f.y <= c0633b.f9539e.y) {
                if (c0633b.f9540f.x < c0633b.f9539e.x || c0633b.f9540f.y < c0633b.f9539e.y) {
                    C0635b.m8079a(f, (float) this.f15456a, c0633b.f9540f, c0633b.f9539e);
                }
                f = (float) C0635b.m8073a(c0633b.f9542h, c0633b.f9541g, c0633b.f9540f);
                if (c0633b.f9540f.y >= c0633b.f9541g.y) {
                    if (c0633b.f9540f.x > c0633b.f9541g.x) {
                        if (c0633b.f9540f.y > c0633b.f9541g.y || c0633b.f9540f.x < c0633b.f9541g.x) {
                            C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9540f, c0633b.f9541g);
                        }
                        if (!z) {
                            m15376d(c0633b.f9542h.x, c0633b.f9542h.y, c0633b, false);
                        }
                    }
                }
                C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9540f, c0633b.f9541g);
                if (!z) {
                    m15376d(c0633b.f9542h.x, c0633b.f9542h.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9540f, c0633b.f9539e);
        f = (float) C0635b.m8073a(c0633b.f9542h, c0633b.f9541g, c0633b.f9540f);
        if (c0633b.f9540f.y >= c0633b.f9541g.y) {
            if (c0633b.f9540f.x > c0633b.f9541g.x) {
                C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9540f, c0633b.f9541g);
                if (!z) {
                    m15376d(c0633b.f9542h.x, c0633b.f9542h.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9540f, c0633b.f9541g);
        if (!z) {
            m15376d(c0633b.f9542h.x, c0633b.f9542h.y, c0633b, false);
        }
    }

    public final void m15374c(float f, float f2, C0633b c0633b, boolean z) {
        c0633b.f9541g.set(f, f2);
        f = (float) C0635b.m8073a(c0633b.f9539e, c0633b.f9540f, c0633b.f9541g);
        if (c0633b.f9541g.y <= c0633b.f9540f.y) {
            if (c0633b.f9541g.x >= c0633b.f9540f.x) {
                if (c0633b.f9541g.y < c0633b.f9540f.y || c0633b.f9541g.x > c0633b.f9540f.x) {
                    C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9541g, c0633b.f9540f);
                }
                f = (float) C0635b.m8073a(c0633b.f9539e, c0633b.f9542h, c0633b.f9541g);
                if (c0633b.f9541g.x <= c0633b.f9542h.x) {
                    if (c0633b.f9541g.y > c0633b.f9542h.y) {
                        if (c0633b.f9541g.x < c0633b.f9542h.x || c0633b.f9541g.y < c0633b.f9542h.y) {
                            C0635b.m8079a(f, (float) this.f15456a, c0633b.f9541g, c0633b.f9542h);
                        }
                        if (!z) {
                            m15362a(c0633b.f9539e.x, c0633b.f9539e.y, c0633b, false);
                        }
                    }
                }
                C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9541g, c0633b.f9542h);
                if (!z) {
                    m15362a(c0633b.f9539e.x, c0633b.f9539e.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9541g, c0633b.f9540f);
        f = (float) C0635b.m8073a(c0633b.f9539e, c0633b.f9542h, c0633b.f9541g);
        if (c0633b.f9541g.x <= c0633b.f9542h.x) {
            if (c0633b.f9541g.y > c0633b.f9542h.y) {
                C0635b.m8079a(f, (float) this.f15456a, c0633b.f9541g, c0633b.f9542h);
                if (!z) {
                    m15362a(c0633b.f9539e.x, c0633b.f9539e.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9541g, c0633b.f9542h);
        if (!z) {
            m15362a(c0633b.f9539e.x, c0633b.f9539e.y, c0633b, false);
        }
    }

    public final void m15376d(float f, float f2, C0633b c0633b, boolean z) {
        c0633b.f9542h.set(f, f2);
        f = (float) C0635b.m8073a(c0633b.f9540f, c0633b.f9539e, c0633b.f9542h);
        if (c0633b.f9542h.y <= c0633b.f9539e.y) {
            if (c0633b.f9542h.x >= c0633b.f9539e.x) {
                if (c0633b.f9542h.y < c0633b.f9539e.y || c0633b.f9542h.x > c0633b.f9539e.x) {
                    C0635b.m8079a(f, (float) (1.26E-43f + this.f15456a), c0633b.f9542h, c0633b.f9539e);
                }
                f = (float) C0635b.m8073a(c0633b.f9540f, c0633b.f9541g, c0633b.f9542h);
                if (c0633b.f9542h.x >= c0633b.f9541g.x) {
                    if (c0633b.f9542h.y < c0633b.f9541g.y) {
                        if (c0633b.f9542h.x > c0633b.f9541g.x || c0633b.f9542h.y > c0633b.f9541g.y) {
                            C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9542h, c0633b.f9541g);
                        }
                        if (!z) {
                            m15373b(c0633b.f9540f.x, c0633b.f9540f.y, c0633b, false);
                        }
                    }
                }
                C0635b.m8079a(f, (float) this.f15456a, c0633b.f9542h, c0633b.f9541g);
                if (!z) {
                    m15373b(c0633b.f9540f.x, c0633b.f9540f.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) (3.78E-43f + this.f15456a), c0633b.f9542h, c0633b.f9539e);
        f = (float) C0635b.m8073a(c0633b.f9540f, c0633b.f9541g, c0633b.f9542h);
        if (c0633b.f9542h.x >= c0633b.f9541g.x) {
            if (c0633b.f9542h.y < c0633b.f9541g.y) {
                C0635b.m8079a(f, (float) (2.52E-43f + this.f15456a), c0633b.f9542h, c0633b.f9541g);
                if (!z) {
                    m15373b(c0633b.f9540f.x, c0633b.f9540f.y, c0633b, false);
                }
            }
        }
        C0635b.m8079a(f, (float) this.f15456a, c0633b.f9542h, c0633b.f9541g);
        if (!z) {
            m15373b(c0633b.f9540f.x, c0633b.f9540f.y, c0633b, false);
        }
    }

    public final void m15375c(C0633b c0633b) {
        RectF rectF = new RectF();
        this.f15457b.computeBounds(rectF, true);
        c0633b.set(rectF);
    }

    public final boolean m15370a() {
        return (this.f15456a == 0 || this.f15456a == 180 || this.f15456a == 90) ? false : true;
    }

    public final Path mo2580b(C0633b c0633b) {
        if (m15370a() && !c0633b.f9543i) {
            c0633b.f9543i = true;
            float centerX = c0633b.centerX();
            float centerY = c0633b.centerY();
            PointF a = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.left, c0633b.top));
            PointF a2 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.right, c0633b.top));
            PointF a3 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.right, c0633b.bottom));
            PointF a4 = C0635b.m8075a(centerX, centerY, (float) this.f15456a, new PointF(c0633b.left, c0633b.bottom));
            c0633b.f9539e.set(a);
            c0633b.f9540f.set(a2);
            c0633b.f9541g.set(a3);
            c0633b.f9542h.set(a4);
        }
        mo3675a(c0633b);
        return this.f15457b;
    }

    protected void mo3675a(C0633b c0633b) {
        this.f15457b.reset();
        if (m15370a()) {
            this.f15457b.moveTo(c0633b.f9539e.x, c0633b.f9539e.y);
            this.f15457b.lineTo(c0633b.f9540f.x, c0633b.f9540f.y);
            this.f15457b.lineTo(c0633b.f9541g.x, c0633b.f9541g.y);
            this.f15457b.lineTo(c0633b.f9542h.x, c0633b.f9542h.y);
            this.f15457b.close();
            return;
        }
        this.f15457b.addRect(c0633b, Direction.CW);
    }

    protected void mo3674a(Canvas canvas, C0633b c0633b) {
        canvas.drawPath(mo2580b(c0633b), this.e);
    }
}
