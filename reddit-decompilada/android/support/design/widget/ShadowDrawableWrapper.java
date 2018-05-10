package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
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
import android.support.design.C0016R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper extends DrawableWrapper {
    static final double f11099a = Math.cos(Math.toRadians(45.0d));
    final Paint f11100b;
    final Paint f11101c;
    final RectF f11102d;
    float f11103e;
    Path f11104f;
    float f11105g;
    float f11106h;
    float f11107i;
    float f11108j;
    boolean f11109k = true;
    float f11110l;
    private boolean f11111n = true;
    private final int f11112o;
    private final int f11113p;
    private final int f11114q;
    private boolean f11115r = false;

    public int getOpacity() {
        return -3;
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f11112o = ContextCompat.m719c(context, C0016R.color.design_fab_shadow_start_color);
        this.f11113p = ContextCompat.m719c(context, C0016R.color.design_fab_shadow_mid_color);
        this.f11114q = ContextCompat.m719c(context, C0016R.color.design_fab_shadow_end_color);
        this.f11100b = new Paint(5);
        this.f11100b.setStyle(Style.FILL);
        this.f11103e = (float) Math.round(f);
        this.f11102d = new RectF();
        this.f11101c = new Paint(this.f11100b);
        this.f11101c.setAntiAlias(false);
        m9590a(f2, f3);
    }

    private static int m9588b(float f) {
        f = Math.round(f);
        return f % 2 == 1 ? f - Float.MIN_VALUE : f;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f11100b.setAlpha(i);
        this.f11101c.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f11111n = true;
    }

    final void m9590a(float f, float f2) {
        if (f >= 0.0f) {
            if (f2 >= 0.0f) {
                f = (float) m9588b(f);
                f2 = (float) m9588b(f2);
                if (f > f2) {
                    if (this.f11115r == null) {
                        this.f11115r = true;
                    }
                    f = f2;
                }
                if (this.f11108j != f || this.f11106h != f2) {
                    this.f11108j = f;
                    this.f11106h = f2;
                    this.f11107i = (float) Math.round(f * 1.5f);
                    this.f11105g = f2;
                    this.f11111n = true;
                    invalidateSelf();
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("invalid shadow size");
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m9586a(this.f11106h, this.f11103e, this.f11109k));
        int ceil2 = (int) Math.ceil((double) m9587b(this.f11106h, this.f11103e, this.f11109k));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float m9586a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f11099a) * ((double) f2))) : f * 1.5f;
    }

    public static float m9587b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f11099a) * ((double) f2))) : f;
    }

    public void draw(Canvas canvas) {
        float f;
        int i;
        int i2;
        Canvas canvas2 = canvas;
        if (this.f11111n) {
            Rect bounds = getBounds();
            float f2 = r0.f11106h * 1.5f;
            r0.f11102d.set(((float) bounds.left) + r0.f11106h, ((float) bounds.top) + f2, ((float) bounds.right) - r0.f11106h, ((float) bounds.bottom) - f2);
            r0.f1861m.setBounds((int) r0.f11102d.left, (int) r0.f11102d.top, (int) r0.f11102d.right, (int) r0.f11102d.bottom);
            RectF rectF = new RectF(-r0.f11103e, -r0.f11103e, r0.f11103e, r0.f11103e);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-r0.f11107i, -r0.f11107i);
            if (r0.f11104f == null) {
                r0.f11104f = new Path();
            } else {
                r0.f11104f.reset();
            }
            r0.f11104f.setFillType(FillType.EVEN_ODD);
            r0.f11104f.moveTo(-r0.f11103e, 0.0f);
            r0.f11104f.rLineTo(-r0.f11107i, 0.0f);
            r0.f11104f.arcTo(rectF2, 180.0f, 90.0f, false);
            r0.f11104f.arcTo(rectF, 270.0f, -90.0f, false);
            r0.f11104f.close();
            f2 = -rectF2.top;
            if (f2 > 0.0f) {
                float f3 = r0.f11103e / f2;
                f = ((1.0f - f3) / 2.0f) + f3;
                r0.f11100b.setShader(new RadialGradient(0.0f, 0.0f, f2, new int[]{0, r0.f11112o, r0.f11113p, r0.f11114q}, new float[]{0.0f, f3, f, 1.0f}, TileMode.CLAMP));
            }
            Paint paint = r0.f11101c;
            float f4 = rectF.top;
            float f5 = rectF2.top;
            r8 = new int[3];
            i = 1;
            r8[1] = r0.f11113p;
            r8[2] = r0.f11114q;
            paint.setShader(new LinearGradient(0.0f, f4, 0.0f, f5, r8, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            r0.f11101c.setAntiAlias(false);
            r0.f11111n = false;
        } else {
            i = 1;
        }
        int save = canvas.save();
        canvas2.rotate(r0.f11110l, r0.f11102d.centerX(), r0.f11102d.centerY());
        float f6 = (-r0.f11103e) - r0.f11107i;
        float f7 = r0.f11103e;
        float f8 = 2.0f * f7;
        int i3 = r0.f11102d.width() - f8 > 0.0f ? i : false;
        if (r0.f11102d.height() - f8 <= 0.0f) {
            i = 0;
        }
        float f9 = f7 / ((r0.f11108j - (r0.f11108j * 0.5f)) + f7);
        float f10 = f7 / ((r0.f11108j - (r0.f11108j * 0.25f)) + f7);
        f = f7 / ((r0.f11108j - (r0.f11108j * 1.0f)) + f7);
        int save2 = canvas.save();
        canvas2.translate(r0.f11102d.left + f7, r0.f11102d.top + f7);
        canvas2.scale(f9, f10);
        canvas2.drawPath(r0.f11104f, r0.f11100b);
        if (i3 != 0) {
            canvas2.scale(1.0f / f9, 1.0f);
            i2 = save;
            save = save2;
            canvas2.drawRect(0.0f, f6, r0.f11102d.width() - f8, -r0.f11103e, r0.f11101c);
        } else {
            i2 = save;
            save = save2;
        }
        canvas2.restoreToCount(save);
        save = canvas.save();
        canvas2.translate(r0.f11102d.right - f7, r0.f11102d.bottom - f7);
        canvas2.scale(f9, f);
        canvas2.rotate(180.0f);
        canvas2.drawPath(r0.f11104f, r0.f11100b);
        if (i3 != 0) {
            canvas2.scale(1.0f / f9, 1.0f);
            canvas2.drawRect(0.0f, f6, r0.f11102d.width() - f8, (-r0.f11103e) + r0.f11107i, r0.f11101c);
        }
        canvas2.restoreToCount(save);
        save = canvas.save();
        canvas2.translate(r0.f11102d.left + f7, r0.f11102d.bottom - f7);
        canvas2.scale(f9, f);
        canvas2.rotate(270.0f);
        canvas2.drawPath(r0.f11104f, r0.f11100b);
        if (i != 0) {
            canvas2.scale(1.0f / f, 1.0f);
            canvas2.drawRect(0.0f, f6, r0.f11102d.height() - f8, -r0.f11103e, r0.f11101c);
        }
        canvas2.restoreToCount(save);
        save = canvas.save();
        canvas2.translate(r0.f11102d.right - f7, r0.f11102d.top + f7);
        canvas2.scale(f9, f10);
        canvas2.rotate(90.0f);
        canvas2.drawPath(r0.f11104f, r0.f11100b);
        if (i != 0) {
            canvas2.scale(1.0f / f10, 1.0f);
            canvas2.drawRect(0.0f, f6, r0.f11102d.height() - f8, -r0.f11103e, r0.f11101c);
        }
        canvas2.restoreToCount(save);
        canvas2.restoreToCount(i2);
        super.draw(canvas);
    }

    public final void m9589a(float f) {
        m9590a(f, this.f11106h);
    }
}
