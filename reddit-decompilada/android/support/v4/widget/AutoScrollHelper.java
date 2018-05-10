package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper implements OnTouchListener {
    private static final int f1542r = ViewConfiguration.getTapTimeout();
    final ClampedScroller f1543a = new ClampedScroller();
    final View f1544b;
    boolean f1545c;
    boolean f1546d;
    boolean f1547e;
    private final Interpolator f1548f = new AccelerateInterpolator();
    private Runnable f1549g;
    private float[] f1550h = new float[]{0.0f, 0.0f};
    private float[] f1551i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1552j;
    private int f1553k;
    private float[] f1554l = new float[]{0.0f, 0.0f};
    private float[] f1555m = new float[]{0.0f, 0.0f};
    private float[] f1556n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1557o;
    private boolean f1558p;
    private boolean f1559q;

    private static class ClampedScroller {
        int f1530a;
        int f1531b;
        float f1532c;
        float f1533d;
        long f1534e = Long.MIN_VALUE;
        long f1535f = 0;
        int f1536g = 0;
        int f1537h = 0;
        long f1538i = -1;
        float f1539j;
        int f1540k;

        ClampedScroller() {
        }

        final float m1338a(long j) {
            if (j < this.f1534e) {
                return 0.0f;
            }
            if (this.f1538i >= 0) {
                if (j >= this.f1538i) {
                    return (1.0f - this.f1539j) + (this.f1539j * AutoScrollHelper.m1340a(((float) (j - this.f1538i)) / ((float) this.f1540k), 0.0f, 1.0f));
                }
            }
            return 0.5f * AutoScrollHelper.m1340a(((float) (j - this.f1534e)) / ((float) this.f1530a), 0.0f, 1.0f);
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        final /* synthetic */ AutoScrollHelper f1541a;

        ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
            this.f1541a = autoScrollHelper;
        }

        public void run() {
            if (this.f1541a.f1547e) {
                ClampedScroller clampedScroller;
                if (this.f1541a.f1545c) {
                    this.f1541a.f1545c = false;
                    clampedScroller = this.f1541a.f1543a;
                    clampedScroller.f1534e = AnimationUtils.currentAnimationTimeMillis();
                    clampedScroller.f1538i = -1;
                    clampedScroller.f1535f = clampedScroller.f1534e;
                    clampedScroller.f1539j = 0.5f;
                    clampedScroller.f1536g = 0;
                    clampedScroller.f1537h = 0;
                }
                clampedScroller = this.f1541a.f1543a;
                boolean z = clampedScroller.f1538i > 0 && AnimationUtils.currentAnimationTimeMillis() > clampedScroller.f1538i + ((long) clampedScroller.f1540k);
                if (!z) {
                    if (this.f1541a.m1345a()) {
                        if (this.f1541a.f1546d) {
                            this.f1541a.f1546d = false;
                            AutoScrollHelper autoScrollHelper = this.f1541a;
                            long uptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                            autoScrollHelper.f1544b.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (clampedScroller.f1535f == 0) {
                            throw new RuntimeException("Cannot compute scroll delta before calling start()");
                        }
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        float a = clampedScroller.m1338a(currentAnimationTimeMillis);
                        float f = ((-4.0f * a) * a) + (4.0f * a);
                        long j = currentAnimationTimeMillis - clampedScroller.f1535f;
                        clampedScroller.f1535f = currentAnimationTimeMillis;
                        float f2 = ((float) j) * f;
                        clampedScroller.f1536g = (int) (clampedScroller.f1532c * f2);
                        clampedScroller.f1537h = (int) (f2 * clampedScroller.f1533d);
                        this.f1541a.mo396a(clampedScroller.f1537h);
                        ViewCompat.m1224a(this.f1541a.f1544b, (Runnable) this);
                        return;
                    }
                }
                this.f1541a.f1547e = false;
            }
        }
    }

    static float m1340a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    public abstract void mo396a(int i);

    public abstract boolean mo397b(int i);

    public AutoScrollHelper(View view) {
        this.f1544b = view;
        view = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * view.density) + 0.5f);
        view = (int) ((315.0f * view.density) + 0.5f);
        float f = ((float) i) / 1000.0f;
        this.f1556n[0] = f;
        this.f1556n[1] = f;
        view = ((float) view) / 1148846080;
        this.f1555m[0] = view;
        this.f1555m[1] = view;
        this.f1552j = 1;
        this.f1551i[0] = 2139095039;
        this.f1551i[1] = 2139095039;
        this.f1550h[0] = 1045220557;
        this.f1550h[1] = 1045220557;
        this.f1554l[0] = 981668463;
        this.f1554l[1] = 981668463;
        this.f1553k = f1542r;
        this.f1543a.f1530a = 500;
        this.f1543a.f1531b = 500;
    }

    public final AutoScrollHelper m1343a(boolean z) {
        if (this.f1558p && !z) {
            m1342b();
        }
        this.f1558p = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f1558p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1546d = true;
                this.f1557o = false;
                break;
            case 1:
            case 3:
                m1342b();
                break;
            case 2:
                break;
            default:
                break;
        }
        float a = m1341a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1544b.getWidth());
        view = m1341a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1544b.getHeight());
        motionEvent = this.f1543a;
        motionEvent.f1532c = a;
        motionEvent.f1533d = view;
        if (this.f1547e == null && m1345a() != null) {
            if (this.f1549g == null) {
                this.f1549g = new ScrollAnimationRunnable(this);
            }
            this.f1547e = true;
            this.f1545c = true;
            if (this.f1557o != null || this.f1553k <= null) {
                this.f1549g.run();
            } else {
                ViewCompat.m1225a(this.f1544b, this.f1549g, (long) this.f1553k);
            }
            this.f1557o = true;
        }
        if (this.f1559q == null || this.f1547e == null) {
            return false;
        }
        return true;
    }

    final boolean m1345a() {
        ClampedScroller clampedScroller = this.f1543a;
        int abs = (int) (clampedScroller.f1533d / Math.abs(clampedScroller.f1533d));
        int abs2 = (int) (clampedScroller.f1532c / Math.abs(clampedScroller.f1532c));
        if (abs != 0) {
            if (mo397b(abs)) {
                return true;
            }
        }
        return false;
    }

    private void m1342b() {
        int i = 0;
        if (this.f1545c) {
            this.f1547e = false;
            return;
        }
        ClampedScroller clampedScroller = this.f1543a;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - clampedScroller.f1534e);
        int i3 = clampedScroller.f1531b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        clampedScroller.f1540k = i;
        clampedScroller.f1539j = clampedScroller.m1338a(currentAnimationTimeMillis);
        clampedScroller.f1538i = currentAnimationTimeMillis;
    }

    private float m1341a(int i, float f, float f2, float f3) {
        float f4;
        float a = m1340a(this.f1550h[i] * f2, 0.0f, this.f1551i[i]);
        f = m1339a(f2 - f, a) - m1339a(f, a);
        if (f < 0.0f) {
            f = -this.f1548f.getInterpolation(-f);
        } else if (f > 0.0f) {
            f = this.f1548f.getInterpolation(f);
        } else {
            f = 0.0f;
            f2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (f2 == null) {
                return 0.0f;
            }
            a = this.f1554l[i];
            f4 = this.f1555m[i];
            i = this.f1556n[i];
            a *= f3;
            if (f2 <= null) {
                return m1340a(f * a, f4, i);
            }
            return -m1340a((-f) * a, f4, i);
        }
        f = m1340a(f, -1.0f, 1.0f);
        f2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (f2 == null) {
            return 0.0f;
        }
        a = this.f1554l[i];
        f4 = this.f1555m[i];
        i = this.f1556n[i];
        a *= f3;
        if (f2 <= null) {
            return -m1340a((-f) * a, f4, i);
        }
        return m1340a(f * a, f4, i);
    }

    private float m1339a(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1552j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    return (this.f1547e == null || this.f1552j != Float.MIN_VALUE) ? 0.0f : 1.0f;
                }
                break;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                break;
            default:
                break;
        }
    }
}
