package com.instabug.library.annotation.p017b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.C0633b;

/* compiled from: CroppedRectShape */
public abstract class C1351c extends C0632g {
    protected Bitmap f15455a;

    public abstract void mo3673a(Canvas canvas, Bitmap bitmap, float f, float f2);

    public C1351c() {
        super(-65536, 0.0f);
    }

    public final void mo2575a(Canvas canvas, C0633b c0633b, C0633b c0633b2) {
        if (this.f15455a != null) {
            c0633b2 = c0633b.left;
            float f = c0633b.top;
            float width = c0633b.width();
            float height = c0633b.height();
            if (c0633b2 < null) {
                width += c0633b2;
                c0633b2 = null;
            }
            if (f < 0.0f) {
                height += f;
                f = 0.0f;
            }
            if (c0633b2 + width > ((float) this.f15455a.getWidth())) {
                width = ((float) this.f15455a.getWidth()) - c0633b2;
            }
            if (f + height > ((float) this.f15455a.getHeight())) {
                height = ((float) this.f15455a.getHeight()) - f;
            }
            if (width > 0.0f && height > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f15455a, (int) c0633b2, (int) f, (int) width, (int) height);
                f = c0633b.left;
                width = c0633b.top;
                if (c0633b.left < 0.0f) {
                    f = c0633b.right - ((float) createBitmap.getWidth());
                }
                if (c0633b.top < 0.0f) {
                    width = c0633b.bottom - ((float) createBitmap.getHeight());
                }
                mo3673a(canvas, createBitmap, f, width);
            }
        }
    }

    public boolean mo2579a(PointF pointF, C0633b c0633b) {
        float b = m8062b() + 20.0f;
        RectF rectF = new RectF(c0633b);
        c0633b = -b;
        rectF.inset(c0633b, c0633b);
        return rectF.contains((float) ((int) pointF.x), (float) ((int) pointF.y));
    }

    public final void mo2577a(C0633b c0633b, C0633b c0633b2, int i, int i2) {
        i = (float) i;
        c0633b.left = c0633b2.left + i;
        i2 = (float) i2;
        c0633b.top = c0633b2.top + i2;
        c0633b.right = c0633b2.right + i;
        c0633b.bottom = c0633b2.bottom + i2;
    }
}
