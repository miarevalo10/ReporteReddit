package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.C0165R;

class RoundRectDrawableWithShadow extends Drawable {
    static RoundRectHelper f2453b;
    private static final double f2454h = Math.cos(Math.toRadians(45.0d));
    final int f2455a;
    float f2456c;
    float f2457d;
    float f2458e;
    ColorStateList f2459f;
    boolean f2460g = true;
    private Paint f2461i;
    private Paint f2462j;
    private Paint f2463k;
    private final RectF f2464l;
    private Path f2465m;
    private float f2466n;
    private final int f2467o;
    private final int f2468p;
    private boolean f2469q = true;
    private boolean f2470r = false;

    interface RoundRectHelper {
        void mo599a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f2467o = resources.getColor(C0165R.color.cardview_shadow_start_color);
        this.f2468p = resources.getColor(C0165R.color.cardview_shadow_end_color);
        this.f2455a = resources.getDimensionPixelSize(C0165R.dimen.cardview_compat_inset_shadow);
        this.f2461i = new Paint(5);
        m2253a(colorStateList);
        this.f2462j = new Paint(5);
        this.f2462j.setStyle(Style.FILL);
        this.f2456c = (float) ((int) (f + 0.5f));
        this.f2464l = new RectF();
        this.f2463k = new Paint(this.f2462j);
        this.f2463k.setAntiAlias(false);
        m2252a(f2, f3);
    }

    final void m2253a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.f2459f = colorStateList;
        this.f2461i.setColor(this.f2459f.getColorForState(getState(), this.f2459f.getDefaultColor()));
    }

    private static int m2250a(float f) {
        f = (int) (f + 0.5f);
        return f % 2 == 1 ? f - Float.MIN_VALUE : f;
    }

    final void m2254a(boolean z) {
        this.f2469q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f2461i.setAlpha(i);
        this.f2462j.setAlpha(i);
        this.f2463k.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2460g = true;
    }

    final void m2252a(float f, float f2) {
        StringBuilder stringBuilder;
        if (f < 0.0f) {
            stringBuilder = new StringBuilder("Invalid shadow size ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f2 < 0.0f) {
            stringBuilder = new StringBuilder("Invalid max shadow size ");
            stringBuilder.append(f2);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            f = (float) m2250a(f);
            f2 = (float) m2250a(f2);
            if (f > f2) {
                if (this.f2470r == null) {
                    this.f2470r = true;
                }
                f = f2;
            }
            if (this.f2458e != f || this.f2457d != f2) {
                this.f2458e = f;
                this.f2457d = f2;
                this.f2466n = (float) ((int) (((f * 1.5f) + ((float) this.f2455a)) + 0.5f));
                this.f2460g = true;
                invalidateSelf();
            }
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m2249a(this.f2457d, this.f2456c, this.f2469q));
        int ceil2 = (int) Math.ceil((double) m2251b(this.f2457d, this.f2456c, this.f2469q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float m2249a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f2454h) * ((double) f2))) : f * 1.5f;
    }

    static float m2251b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f2454h) * ((double) f2))) : f;
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.f2459f.getColorForState(iArr, this.f2459f.getDefaultColor());
        if (this.f2461i.getColor() == iArr) {
            return null;
        }
        this.f2461i.setColor(iArr);
        this.f2460g = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.f2459f != null && this.f2459f.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2461i.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        int i;
        Canvas canvas2 = canvas;
        if (this.f2460g) {
            Rect bounds = getBounds();
            float f = r0.f2457d * 1.5f;
            r0.f2464l.set(((float) bounds.left) + r0.f2457d, ((float) bounds.top) + f, ((float) bounds.right) - r0.f2457d, ((float) bounds.bottom) - f);
            RectF rectF = new RectF(-r0.f2456c, -r0.f2456c, r0.f2456c, r0.f2456c);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-r0.f2466n, -r0.f2466n);
            if (r0.f2465m == null) {
                r0.f2465m = new Path();
            } else {
                r0.f2465m.reset();
            }
            r0.f2465m.setFillType(FillType.EVEN_ODD);
            r0.f2465m.moveTo(-r0.f2456c, 0.0f);
            r0.f2465m.rLineTo(-r0.f2466n, 0.0f);
            r0.f2465m.arcTo(rectF2, 180.0f, 90.0f, false);
            r0.f2465m.arcTo(rectF, 270.0f, -90.0f, false);
            r0.f2465m.close();
            float f2 = r0.f2456c / (r0.f2456c + r0.f2466n);
            r0.f2462j.setShader(new RadialGradient(0.0f, 0.0f, r0.f2456c + r0.f2466n, new int[]{r0.f2467o, r0.f2467o, r0.f2468p}, new float[]{0.0f, f2, 1.0f}, TileMode.CLAMP));
            r0.f2463k.setShader(new LinearGradient(0.0f, (-r0.f2456c) + r0.f2466n, 0.0f, (-r0.f2456c) - r0.f2466n, new int[]{r0.f2467o, r0.f2467o, r0.f2468p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            r0.f2463k.setAntiAlias(false);
            r0.f2460g = false;
        }
        canvas2.translate(0.0f, r0.f2458e / 2.0f);
        float f3 = (-r0.f2456c) - r0.f2466n;
        float f4 = (r0.f2456c + ((float) r0.f2455a)) + (r0.f2458e / 2.0f);
        float f5 = 2.0f * f4;
        int i2 = r0.f2464l.width() - f5 > 0.0f ? 1 : false;
        int i3 = r0.f2464l.height() - f5 > 0.0f ? 1 : false;
        int save = canvas.save();
        canvas2.translate(r0.f2464l.left + f4, r0.f2464l.top + f4);
        canvas2.drawPath(r0.f2465m, r0.f2462j);
        if (i2 != 0) {
            i = save;
            canvas2.drawRect(0.0f, f3, r0.f2464l.width() - f5, -r0.f2456c, r0.f2463k);
        } else {
            i = save;
        }
        canvas2.restoreToCount(i);
        i = canvas.save();
        canvas2.translate(r0.f2464l.right - f4, r0.f2464l.bottom - f4);
        canvas2.rotate(180.0f);
        canvas2.drawPath(r0.f2465m, r0.f2462j);
        if (i2 != 0) {
            canvas2.drawRect(0.0f, f3, r0.f2464l.width() - f5, (-r0.f2456c) + r0.f2466n, r0.f2463k);
        }
        canvas2.restoreToCount(i);
        int save2 = canvas.save();
        canvas2.translate(r0.f2464l.left + f4, r0.f2464l.bottom - f4);
        canvas2.rotate(270.0f);
        canvas2.drawPath(r0.f2465m, r0.f2462j);
        if (i3 != 0) {
            canvas2.drawRect(0.0f, f3, r0.f2464l.height() - f5, -r0.f2456c, r0.f2463k);
        }
        canvas2.restoreToCount(save2);
        int save3 = canvas.save();
        canvas2.translate(r0.f2464l.right - f4, r0.f2464l.top + f4);
        canvas2.rotate(90.0f);
        canvas2.drawPath(r0.f2465m, r0.f2462j);
        if (i3 != 0) {
            canvas2.drawRect(0.0f, f3, r0.f2464l.height() - f5, -r0.f2456c, r0.f2463k);
        }
        canvas2.restoreToCount(save3);
        canvas2.translate(0.0f, (-r0.f2458e) / 2.0f);
        f2453b.mo599a(canvas2, r0.f2464l, r0.f2456c, r0.f2461i);
    }
}
