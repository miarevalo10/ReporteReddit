package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Preconditions;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator f1591b = new LinearInterpolator();
    private static final Interpolator f1592c = new FastOutSlowInInterpolator();
    private static final int[] f1593d = new int[]{-16777216};
    final Ring f1594a = new Ring();
    private float f1595e;
    private Resources f1596f;
    private Animator f1597g;
    private float f1598h;
    private boolean f1599i;

    private static class Ring {
        final RectF f1570a = new RectF();
        final Paint f1571b = new Paint();
        final Paint f1572c = new Paint();
        final Paint f1573d = new Paint();
        float f1574e = 0.0f;
        float f1575f = 0.0f;
        float f1576g = 0.0f;
        float f1577h = 5.0f;
        int[] f1578i;
        int f1579j;
        float f1580k;
        float f1581l;
        float f1582m;
        boolean f1583n;
        Path f1584o;
        float f1585p = 1.0f;
        float f1586q;
        int f1587r;
        int f1588s;
        int f1589t = 255;
        int f1590u;

        Ring() {
            this.f1571b.setStrokeCap(Cap.SQUARE);
            this.f1571b.setAntiAlias(true);
            this.f1571b.setStyle(Style.STROKE);
            this.f1572c.setStyle(Style.FILL);
            this.f1572c.setAntiAlias(true);
            this.f1573d.setColor(0);
        }

        final void m1353a(int[] iArr) {
            this.f1578i = iArr;
            m1351a((int) null);
        }

        final void m1351a(int i) {
            this.f1579j = i;
            this.f1590u = this.f1578i[this.f1579j];
        }

        final int m1349a() {
            return (this.f1579j + 1) % this.f1578i.length;
        }

        final void m1350a(float f) {
            this.f1577h = f;
            this.f1571b.setStrokeWidth(f);
        }

        final int m1354b() {
            return this.f1578i[this.f1579j];
        }

        final void m1352a(boolean z) {
            if (this.f1583n != z) {
                this.f1583n = z;
            }
        }

        final void m1355c() {
            this.f1580k = this.f1574e;
            this.f1581l = this.f1575f;
            this.f1582m = this.f1576g;
        }

        final void m1356d() {
            this.f1580k = 0.0f;
            this.f1581l = 0.0f;
            this.f1582m = 0.0f;
            this.f1574e = 0.0f;
            this.f1575f = 0.0f;
            this.f1576g = 0.0f;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public CircularProgressDrawable(Context context) {
        this.f1596f = ((Context) Preconditions.m1042a((Object) context)).getResources();
        this.f1594a.m1353a(f1593d);
        this.f1594a.m1350a(2.5f);
        invalidateSelf();
        context = this.f1594a;
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ CircularProgressDrawable f1567b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.m1362b(floatValue, context);
                CircularProgressDrawable.m1360a(this.f1567b, floatValue, context, false);
                this.f1567b.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1591b);
        ofFloat.addListener(new AnimatorListener(this) {
            final /* synthetic */ CircularProgressDrawable f1569b;

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                this.f1569b.f1598h = 0.0f;
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.m1360a(this.f1569b, 1.0f, context, true);
                context.m1355c();
                Ring ring = context;
                ring.m1351a(ring.m1349a());
                if (this.f1569b.f1599i) {
                    this.f1569b.f1599i = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    context.m1352a(false);
                    return;
                }
                this.f1569b.f1598h = this.f1569b.f1598h + 1.0f;
            }
        });
        this.f1597g = ofFloat;
    }

    private void m1358a(float f, float f2, float f3, float f4) {
        Ring ring = this.f1594a;
        float f5 = this.f1596f.getDisplayMetrics().density;
        ring.m1350a(f2 * f5);
        ring.f1586q = f * f5;
        ring.m1351a((int) 0.0f);
        f4 *= f5;
        ring.f1587r = (int) (f3 * f5);
        ring.f1588s = (int) f4;
    }

    public final void m1366a(int i) {
        if (i == 0) {
            m1358a((float) 1093664768, 3.0f, 12.0f, 6.0f);
        } else {
            m1358a((float) 1089470464, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m1367a(boolean z) {
        this.f1594a.m1352a(z);
        invalidateSelf();
    }

    public final void m1365a(float f) {
        Ring ring = this.f1594a;
        if (f != ring.f1585p) {
            ring.f1585p = f;
        }
        invalidateSelf();
    }

    public final void m1368b(float f) {
        this.f1594a.f1574e = 0.0f;
        this.f1594a.f1575f = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1595e, bounds.exactCenterX(), bounds.exactCenterY());
        Ring ring = this.f1594a;
        RectF rectF = ring.f1570a;
        float f = ring.f1586q + (ring.f1577h / 2.0f);
        if (ring.f1586q <= 0.0f) {
            f = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) ring.f1587r) * ring.f1585p) / 2.0f, ring.f1577h / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f, ((float) bounds.centerY()) - f, ((float) bounds.centerX()) + f, ((float) bounds.centerY()) + f);
        float f2 = (ring.f1574e + ring.f1576g) * 360.0f;
        float f3 = ((ring.f1575f + ring.f1576g) * 360.0f) - f2;
        ring.f1571b.setColor(ring.f1590u);
        ring.f1571b.setAlpha(ring.f1589t);
        f = ring.f1577h / 2.0f;
        rectF.inset(f, f);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, ring.f1573d);
        f = -f;
        rectF.inset(f, f);
        canvas.drawArc(rectF, f2, f3, false, ring.f1571b);
        if (ring.f1583n) {
            if (ring.f1584o == null) {
                ring.f1584o = new Path();
                ring.f1584o.setFillType(FillType.EVEN_ODD);
            } else {
                ring.f1584o.reset();
            }
            f = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f4 = (((float) ring.f1587r) * ring.f1585p) / 2.0f;
            ring.f1584o.moveTo(0.0f, 0.0f);
            ring.f1584o.lineTo(((float) ring.f1587r) * ring.f1585p, 0.0f);
            ring.f1584o.lineTo((((float) ring.f1587r) * ring.f1585p) / 2.0f, ((float) ring.f1588s) * ring.f1585p);
            ring.f1584o.offset((f + rectF.centerX()) - f4, rectF.centerY() + (ring.f1577h / 2.0f));
            ring.f1584o.close();
            ring.f1572c.setColor(ring.f1590u);
            ring.f1572c.setAlpha(ring.f1589t);
            canvas.save();
            canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
            canvas.drawPath(ring.f1584o, ring.f1572c);
            canvas.restore();
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f1594a.f1589t = i;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f1594a.f1589t;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1594a.f1571b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.f1597g.isRunning();
    }

    public void start() {
        this.f1597g.cancel();
        this.f1594a.m1355c();
        if (this.f1594a.f1575f != this.f1594a.f1574e) {
            this.f1599i = true;
            this.f1597g.setDuration(666);
            this.f1597g.start();
            return;
        }
        this.f1594a.m1351a(0);
        this.f1594a.m1356d();
        this.f1597g.setDuration(1332);
        this.f1597g.start();
    }

    public void stop() {
        this.f1597g.cancel();
        this.f1595e = 0.0f;
        this.f1594a.m1352a(false);
        this.f1594a.m1351a(0);
        this.f1594a.m1356d();
        invalidateSelf();
    }

    private static void m1362b(float f, Ring ring) {
        if (f > 0.75f) {
            f = (f - 0.75f) / 0.25f;
            int b = ring.m1354b();
            int i = ring.f1578i[ring.m1349a()];
            int i2 = (b >> 24) & 255;
            int i3 = (b >> 16) & 255;
            int i4 = (b >> 8) & 255;
            b &= 255;
            ring.f1590u = ((((i2 + ((int) (((float) (((i >> 24) & 255) - i2)) * f))) << 24) | ((i3 + ((int) (((float) (((i >> 16) & 255) - i3)) * f))) << 16)) | ((i4 + ((int) (((float) (((i >> 8) & 255) - i4)) * f))) << 8)) | (b + ((int) (f * ((float) ((i & 255) - b)))));
            return;
        }
        ring.f1590u = ring.m1354b();
    }

    static /* synthetic */ void m1360a(CircularProgressDrawable circularProgressDrawable, float f, Ring ring, boolean z) {
        if (circularProgressDrawable.f1599i) {
            m1362b(f, ring);
            circularProgressDrawable = (float) (Math.floor((double) (ring.f1582m / true)) + 1.0d);
            ring.f1574e = ring.f1580k + (((ring.f1581l - 0.01f) - ring.f1580k) * f);
            ring.f1575f = ring.f1581l;
            ring.f1576g = ring.f1582m + ((circularProgressDrawable - ring.f1582m) * f);
            return;
        }
        if (f != 1.0f || z) {
            float f2;
            float f3;
            z = ring.f1582m;
            if (f < 0.5f) {
                f2 = f / 0.5f;
                f3 = ring.f1580k;
                f2 = f3;
                f3 = ((0.79f * f1592c.getInterpolation(f2)) + 0.01f) + f3;
            } else {
                f3 = ring.f1580k + 0.79f;
                f2 = f3 - ((0.79f * (1.0f - f1592c.getInterpolation((f - 0.5f) / 0.5f))) + 0.01f);
            }
            z += 0.20999998f * f;
            float f4 = 216.0f * (f + circularProgressDrawable.f1598h);
            ring.f1574e = f2;
            ring.f1575f = f3;
            ring.f1576g = z;
            circularProgressDrawable.f1595e = f4;
        }
    }
}
