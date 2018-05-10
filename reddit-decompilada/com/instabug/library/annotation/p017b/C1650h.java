package com.instabug.library.annotation.p017b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import com.instabug.library.Instabug;
import com.instabug.library.annotation.C0629a;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.p018c.C0634a;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: ZoomedShape */
public class C1650h extends C1351c {
    private PointF f18556b;
    private float f18557c;
    private float f18558f;
    private float f18559g;

    public final void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    public final Path mo2580b(C0633b c0633b) {
        return null;
    }

    public C1650h(Bitmap bitmap) {
        this.a = bitmap;
    }

    public final void m19483a(Bitmap bitmap) {
        this.a = bitmap;
    }

    public final void mo3673a(Canvas canvas, Bitmap bitmap, float f, float f2) {
        this.f18559g = (float) Math.min(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        this.f18557c = (((float) bitmap.getWidth()) / 2.0f) + f;
        this.f18558f = (((float) bitmap.getHeight()) / 2.0f) + f2;
        this.f18556b = C0635b.m8076a(this.f18559g, 45.0f, new PointF(this.f18557c, this.f18558f));
        canvas.drawBitmap(C0634a.m8072b(C0634a.m8070a(bitmap)), f, f2, null);
    }

    public final boolean mo2579a(PointF pointF, C0633b c0633b) {
        c0633b = new Region();
        RectF rectF = new RectF();
        Path path = new Path();
        path.addCircle(this.f18557c, this.f18558f, this.f18559g, Direction.CW);
        path.computeBounds(rectF, true);
        c0633b.setPath(path, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        return c0633b.contains((int) pointF.x, (int) pointF.y);
    }

    public final void mo2578a(C0633b c0633b, C0633b c0633b2, boolean z) {
        if (Math.abs(c0633b2.width() - c0633b.width()) >= true || Math.abs(c0633b2.height() - c0633b.height()) >= true) {
            c0633b = Math.max(c0633b.width() / c0633b2.width(), c0633b.height() / c0633b2.height());
            z = new Matrix();
            z.postScale(c0633b, c0633b, c0633b2.centerX(), c0633b2.centerY());
            z.mapRect(c0633b2);
            return;
        }
        c0633b2.m8065a(c0633b);
    }

    public final void mo2576a(Canvas canvas, C0633b c0633b, C0629a[] c0629aArr) {
        c0629aArr[2].f9524a = this.f18556b;
        c0629aArr[2].f9525b = Instabug.getPrimaryColor();
        c0629aArr[2].m8054a(canvas);
    }
}
