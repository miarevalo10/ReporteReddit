package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable extends Drawable {
    float f2442a;
    float f2443b;
    boolean f2444c = false;
    boolean f2445d = true;
    ColorStateList f2446e;
    private final Paint f2447f;
    private final RectF f2448g;
    private final Rect f2449h;
    private PorterDuffColorFilter f2450i;
    private ColorStateList f2451j;
    private Mode f2452k = Mode.SRC_IN;

    public int getOpacity() {
        return -3;
    }

    RoundRectDrawable(ColorStateList colorStateList, float f) {
        this.f2442a = f;
        this.f2447f = new Paint(5);
        m2246a(colorStateList);
        this.f2448g = new RectF();
        this.f2449h = new Rect();
    }

    final void m2246a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.f2446e = colorStateList;
        this.f2447f.setColor(this.f2446e.getColorForState(getState(), this.f2446e.getDefaultColor()));
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f2447f;
        if (this.f2450i == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f2450i);
            obj = 1;
        }
        canvas.drawRoundRect(this.f2448g, this.f2442a, this.f2442a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    final void m2247a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2448g.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2449h.set(rect);
        if (this.f2444c != null) {
            rect = RoundRectDrawableWithShadow.m2249a(this.f2443b, this.f2442a, this.f2445d);
            this.f2449h.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.m2251b(this.f2443b, this.f2442a, this.f2445d)), (int) Math.ceil((double) rect));
            this.f2448g.set(this.f2449h);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m2247a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2449h, this.f2442a);
    }

    public void setAlpha(int i) {
        this.f2447f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2447f.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2451j = colorStateList;
        this.f2450i = m2245a(this.f2451j, this.f2452k);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2452k = mode;
        this.f2450i = m2245a(this.f2451j, this.f2452k);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.f2446e.getColorForState(iArr, this.f2446e.getDefaultColor());
        boolean z = iArr != this.f2447f.getColor();
        if (z) {
            this.f2447f.setColor(iArr);
        }
        if (this.f2451j == null || this.f2452k == null) {
            return z;
        }
        this.f2450i = m2245a(this.f2451j, this.f2452k);
        return true;
    }

    public boolean isStateful() {
        return (this.f2451j != null && this.f2451j.isStateful()) || ((this.f2446e != null && this.f2446e.isStateful()) || super.isStateful());
    }

    private PorterDuffColorFilter m2245a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }
}
