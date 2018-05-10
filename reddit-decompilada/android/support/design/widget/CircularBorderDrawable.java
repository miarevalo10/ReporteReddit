package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;

class CircularBorderDrawable extends Drawable {
    final Paint f458a = new Paint(1);
    final Rect f459b = new Rect();
    final RectF f460c = new RectF();
    float f461d;
    int f462e;
    int f463f;
    int f464g;
    int f465h;
    boolean f466i = true;
    float f467j;
    private ColorStateList f468k;
    private int f469l;

    public CircularBorderDrawable() {
        this.f458a.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        if (this.f466i) {
            Paint paint = this.f458a;
            Rect rect = this.f459b;
            copyBounds(rect);
            float height = this.f461d / ((float) rect.height());
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.m794a(this.f462e, this.f469l), ColorUtils.m794a(this.f463f, this.f469l), ColorUtils.m794a(ColorUtils.m798b(this.f463f, 0), this.f469l), ColorUtils.m794a(ColorUtils.m798b(this.f465h, 0), this.f469l), ColorUtils.m794a(this.f465h, this.f469l), ColorUtils.m794a(this.f464g, this.f469l)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.f466i = false;
        }
        float strokeWidth = this.f458a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f460c;
        copyBounds(this.f459b);
        rectF.set(this.f459b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f467j, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f458a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f461d);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.f458a.setAlpha(i);
        invalidateSelf();
    }

    final void m187a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f469l = colorStateList.getColorForState(getState(), this.f469l);
        }
        this.f468k = colorStateList;
        this.f466i = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f458a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f461d > 0.0f ? -3 : -2;
    }

    protected void onBoundsChange(Rect rect) {
        this.f466i = true;
    }

    public boolean isStateful() {
        return (this.f468k != null && this.f468k.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f468k != null) {
            iArr = this.f468k.getColorForState(iArr, this.f469l);
            if (iArr != this.f469l) {
                this.f466i = true;
                this.f469l = iArr;
            }
        }
        if (this.f466i != null) {
            invalidateSelf();
        }
        return this.f466i;
    }
}
