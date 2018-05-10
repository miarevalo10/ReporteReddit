package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class CollapsingTextHelper {
    private static final boolean f470k = (VERSION.SDK_INT < 18);
    private static final Paint f471l = null;
    private boolean f472A;
    private boolean f473B;
    private Bitmap f474C;
    private Paint f475D;
    private float f476E;
    private float f477F;
    private float f478G;
    private float f479H;
    private int[] f480I;
    private boolean f481J;
    private final TextPaint f482K;
    private Interpolator f483L;
    private float f484M;
    private float f485N;
    private float f486O;
    private int f487P;
    private float f488Q;
    private float f489R;
    private float f490S;
    private int f491T;
    float f492a;
    int f493b = 16;
    int f494c = 16;
    float f495d = 15.0f;
    float f496e = 15.0f;
    ColorStateList f497f;
    Typeface f498g;
    Typeface f499h;
    CharSequence f500i;
    Interpolator f501j;
    private final View f502m;
    private boolean f503n;
    private final Rect f504o;
    private final Rect f505p;
    private final RectF f506q;
    private ColorStateList f507r;
    private float f508s;
    private float f509t;
    private float f510u;
    private float f511v;
    private float f512w;
    private float f513x;
    private Typeface f514y;
    private CharSequence f515z;

    public CollapsingTextHelper(View view) {
        this.f502m = view;
        this.f482K = new TextPaint(129);
        this.f505p = new Rect();
        this.f504o = new Rect();
        this.f506q = new RectF();
    }

    final void m208a(Interpolator interpolator) {
        this.f483L = interpolator;
        m211b();
    }

    final void m205a(ColorStateList colorStateList) {
        if (this.f497f != colorStateList) {
            this.f497f = colorStateList;
            m211b();
        }
    }

    final void m214b(ColorStateList colorStateList) {
        if (this.f507r != colorStateList) {
            this.f507r = colorStateList;
            m211b();
        }
    }

    final void m204a(int i, int i2, int i3, int i4) {
        if (!m191a(this.f504o, i, i2, i3, i4)) {
            this.f504o.set(i, i2, i3, i4);
            this.f481J = true;
            m194c();
        }
    }

    final void m213b(int i, int i2, int i3, int i4) {
        if (!m191a(this.f505p, i, i2, i3, i4)) {
            this.f505p.set(i, i2, i3, i4);
            this.f481J = true;
            m194c();
        }
    }

    private void m194c() {
        boolean z = this.f505p.width() > 0 && this.f505p.height() > 0 && this.f504o.width() > 0 && this.f504o.height() > 0;
        this.f503n = z;
    }

    final void m203a(int i) {
        if (this.f493b != i) {
            this.f493b = i;
            m211b();
        }
    }

    final void m212b(int i) {
        if (this.f494c != i) {
            this.f494c = i;
            m211b();
        }
    }

    final void m215c(int i) {
        TintTypedArray a = TintTypedArray.m2306a(this.f502m.getContext(), i, C0164R.styleable.TextAppearance);
        if (a.m2322f(C0164R.styleable.TextAppearance_android_textColor)) {
            this.f497f = a.m2320e(C0164R.styleable.TextAppearance_android_textColor);
        }
        if (a.m2322f(C0164R.styleable.TextAppearance_android_textSize)) {
            this.f496e = (float) a.m2319e(C0164R.styleable.TextAppearance_android_textSize, (int) this.f496e);
        }
        this.f487P = a.m2310a(C0164R.styleable.TextAppearance_android_shadowColor, 0);
        this.f485N = a.m2309a(C0164R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f486O = a.m2309a(C0164R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f484M = a.m2309a(C0164R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a.f2595b.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f498g = m199e(i);
        }
        m211b();
    }

    final void m216d(int i) {
        TintTypedArray a = TintTypedArray.m2306a(this.f502m.getContext(), i, C0164R.styleable.TextAppearance);
        if (a.m2322f(C0164R.styleable.TextAppearance_android_textColor)) {
            this.f507r = a.m2320e(C0164R.styleable.TextAppearance_android_textColor);
        }
        if (a.m2322f(C0164R.styleable.TextAppearance_android_textSize)) {
            this.f495d = (float) a.m2319e(C0164R.styleable.TextAppearance_android_textSize, (int) this.f495d);
        }
        this.f491T = a.m2310a(C0164R.styleable.TextAppearance_android_shadowColor, 0);
        this.f489R = a.m2309a(C0164R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f490S = a.m2309a(C0164R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f488Q = a.m2309a(C0164R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        a.f2595b.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f499h = m199e(i);
        }
        m211b();
    }

    private Typeface m199e(int i) {
        i = this.f502m.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = i.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            i.recycle();
            return 0;
        } finally {
            i.recycle();
        }
    }

    final void m207a(Typeface typeface) {
        this.f499h = typeface;
        this.f498g = typeface;
        m211b();
    }

    final Typeface m201a() {
        return this.f498g != null ? this.f498g : Typeface.DEFAULT;
    }

    final void m202a(float f) {
        f = MathUtils.m853a(f);
        if (f != this.f492a) {
            this.f492a = f;
            m196d();
        }
    }

    final boolean m210a(int[] iArr) {
        this.f480I = iArr;
        iArr = ((this.f497f == null || this.f497f.isStateful() == null) && (this.f507r == null || this.f507r.isStateful() == null)) ? null : 1;
        if (iArr == null) {
            return false;
        }
        m211b();
        return true;
    }

    private void m196d() {
        m193b(this.f492a);
    }

    private int m198e() {
        if (this.f480I != null) {
            return this.f497f.getColorForState(this.f480I, 0);
        }
        return this.f497f.getDefaultColor();
    }

    public final void m206a(Canvas canvas) {
        int save = canvas.save();
        if (this.f515z != null && this.f503n) {
            float f;
            float f2 = this.f512w;
            float f3 = this.f513x;
            Object obj = (!this.f473B || this.f474C == null) ? null : 1;
            if (obj != null) {
                f = this.f476E * this.f478G;
            } else {
                this.f482K.ascent();
                f = 0.0f;
                this.f482K.descent();
            }
            if (obj != null) {
                f3 += f;
            }
            float f4 = f3;
            if (this.f478G != 1.0f) {
                canvas.scale(this.f478G, this.f478G, f2, f4);
            }
            if (obj != null) {
                canvas.drawBitmap(this.f474C, f2, f4, this.f475D);
            } else {
                canvas.drawText(this.f515z, 0, this.f515z.length(), f2, f4, this.f482K);
            }
        }
        canvas.restoreToCount(save);
    }

    private void m195c(float f) {
        m197d(f);
        f = (f470k == null || this.f478G == 1.0f) ? 0.0f : Float.MIN_VALUE;
        this.f473B = f;
        if (this.f473B != null && this.f474C == null && this.f504o.isEmpty() == null) {
            if (TextUtils.isEmpty(this.f515z) == null) {
                m193b(0.0f);
                this.f476E = this.f482K.ascent();
                this.f477F = this.f482K.descent();
                f = Math.round(this.f482K.measureText(this.f515z, 0, this.f515z.length()));
                int round = Math.round(this.f477F - this.f476E);
                if (f > null) {
                    if (round > 0) {
                        this.f474C = Bitmap.createBitmap(f, round, Config.ARGB_8888);
                        new Canvas(this.f474C).drawText(this.f515z, 0, this.f515z.length(), 0.0f, ((float) round) - this.f482K.descent(), this.f482K);
                        if (this.f475D == null) {
                            this.f475D = new Paint(3);
                        }
                    }
                }
            }
        }
        ViewCompat.m1234c(this.f502m);
    }

    static boolean m192a(Typeface typeface, Typeface typeface2) {
        return ((typeface == null || typeface.equals(typeface2)) && (typeface != null || typeface2 == null)) ? null : true;
    }

    private void m197d(float f) {
        if (this.f500i != null) {
            float f2;
            boolean z;
            float width = (float) this.f505p.width();
            float width2 = (float) this.f504o.width();
            boolean z2 = false;
            if (m190a(f, this.f496e)) {
                boolean z3;
                f = this.f496e;
                this.f478G = 1.0f;
                if (m192a(this.f514y, this.f498g)) {
                    this.f514y = this.f498g;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f2 = f;
                z = z3;
            } else {
                f2 = this.f495d;
                if (m192a(this.f514y, this.f499h)) {
                    this.f514y = this.f499h;
                    z = true;
                } else {
                    z = false;
                }
                if (m190a(f, this.f495d)) {
                    this.f478G = 1.0f;
                } else {
                    this.f478G = f / this.f495d;
                }
                f = this.f496e / this.f495d;
                width = width2 * f > width ? Math.min(width / f, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.f479H == f2 && this.f481J == null) {
                    if (!z) {
                        z = false;
                        this.f479H = f2;
                        this.f481J = false;
                    }
                }
                z = true;
                this.f479H = f2;
                this.f481J = false;
            }
            if (this.f515z == null || r6) {
                this.f482K.setTextSize(this.f479H);
                this.f482K.setTypeface(this.f514y);
                this.f482K.setLinearText(this.f478G != 1.0f);
                f = TextUtils.ellipsize(this.f500i, this.f482K, width, TruncateAt.END);
                if (!TextUtils.equals(f, this.f515z)) {
                    this.f515z = f;
                    f = this.f515z;
                    if (ViewCompat.m1242f(this.f502m) == 1) {
                        z2 = true;
                    }
                    this.f472A = (z2 ? TextDirectionHeuristicsCompat.f1370d : TextDirectionHeuristicsCompat.f1369c).mo352a(f, f.length());
                }
            }
        }
    }

    public final void m211b() {
        if (this.f502m.getHeight() > 0 && this.f502m.getWidth() > 0) {
            float f = this.f479H;
            m197d(this.f496e);
            float f2 = 0.0f;
            float measureText = this.f515z != null ? this.f482K.measureText(this.f515z, 0, this.f515z.length()) : 0.0f;
            int a = GravityCompat.m1096a(this.f494c, this.f472A);
            int i = a & 112;
            if (i == 48) {
                this.f509t = ((float) this.f505p.top) - this.f482K.ascent();
            } else if (i != 80) {
                this.f509t = ((float) this.f505p.centerY()) + (((this.f482K.descent() - this.f482K.ascent()) / 2.0f) - this.f482K.descent());
            } else {
                this.f509t = (float) this.f505p.bottom;
            }
            a &= 8388615;
            if (a == 1) {
                this.f511v = ((float) this.f505p.centerX()) - (measureText / 2.0f);
            } else if (a != 5) {
                this.f511v = (float) this.f505p.left;
            } else {
                this.f511v = ((float) this.f505p.right) - measureText;
            }
            m197d(this.f495d);
            if (this.f515z != null) {
                f2 = this.f482K.measureText(this.f515z, 0, this.f515z.length());
            }
            int a2 = GravityCompat.m1096a(this.f493b, this.f472A);
            int i2 = a2 & 112;
            if (i2 == 48) {
                this.f508s = ((float) this.f504o.top) - this.f482K.ascent();
            } else if (i2 != 80) {
                this.f508s = ((float) this.f504o.centerY()) + (((this.f482K.descent() - this.f482K.ascent()) / 2.0f) - this.f482K.descent());
            } else {
                this.f508s = (float) this.f504o.bottom;
            }
            a2 &= 8388615;
            if (a2 == 1) {
                this.f510u = ((float) this.f504o.centerX()) - (f2 / 2.0f);
            } else if (a2 != 5) {
                this.f510u = (float) this.f504o.left;
            } else {
                this.f510u = ((float) this.f504o.right) - f2;
            }
            m200f();
            m195c(f);
            m196d();
        }
    }

    final void m209a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f500i)) {
            this.f500i = charSequence;
            this.f515z = null;
            m200f();
            m211b();
        }
    }

    private void m200f() {
        if (this.f474C != null) {
            this.f474C.recycle();
            this.f474C = null;
        }
    }

    private static boolean m190a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int m189a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    private static float m188a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return AnimationUtils.m163a(f, f2, f3);
    }

    private static boolean m191a(Rect rect, int i, int i2, int i3, int i4) {
        return (rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4) ? true : null;
    }

    private void m193b(float f) {
        this.f506q.left = m188a((float) this.f504o.left, (float) this.f505p.left, f, this.f501j);
        this.f506q.top = m188a(this.f508s, this.f509t, f, this.f501j);
        this.f506q.right = m188a((float) this.f504o.right, (float) this.f505p.right, f, this.f501j);
        this.f506q.bottom = m188a((float) this.f504o.bottom, (float) this.f505p.bottom, f, this.f501j);
        this.f512w = m188a(this.f510u, this.f511v, f, this.f501j);
        this.f513x = m188a(this.f508s, this.f509t, f, this.f501j);
        m195c(m188a(this.f495d, this.f496e, f, this.f483L));
        if (this.f497f != this.f507r) {
            int colorForState;
            TextPaint textPaint = this.f482K;
            if (this.f480I != null) {
                colorForState = this.f507r.getColorForState(this.f480I, 0);
            } else {
                colorForState = this.f507r.getDefaultColor();
            }
            textPaint.setColor(m189a(colorForState, m198e(), f));
        } else {
            this.f482K.setColor(m198e());
        }
        this.f482K.setShadowLayer(m188a(this.f488Q, this.f484M, f, null), m188a(this.f489R, this.f485N, f, null), m188a(this.f490S, this.f486O, f, null), m189a(this.f491T, this.f487P, f));
        ViewCompat.m1234c(this.f502m);
    }
}
