package com.instabug.library.annotation.p017b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.p018c.C0635b;
import java.util.List;

/* compiled from: PathShape */
public class C1649e extends C1352f {
    private final RectF f18551c = new RectF();
    private final Paint f18552f;
    private Path f18553g;
    private Matrix f18554h;
    private List<PointF> f18555i;

    public C1649e(Path path, float f, Paint paint, List<PointF> list) {
        super(paint.getColor(), f, 0);
        this.f18553g = path;
        this.f18552f = new Paint(paint);
        this.f18555i = list;
        path.computeBounds(this.f18551c, true);
        this.f18554h = new Matrix();
    }

    public final void mo2575a(Canvas canvas, C0633b c0633b, C0633b c0633b2) {
        this.f18554h.reset();
        c0633b2 = new Path(this.f18553g);
        this.f18554h.setRectToRect(this.f18551c, new RectF(c0633b), ScaleToFit.FILL);
        c0633b2.transform(this.f18554h);
        canvas.drawPath(c0633b2, this.f18552f);
    }

    public final boolean mo2579a(PointF pointF, C0633b c0633b) {
        c0633b = new RectF(pointF.x - 50.0f, pointF.y - 50.0f, pointF.x + 50.0f, pointF.y + 1112014848);
        for (PointF pointF2 : this.f18555i) {
            float[] fArr = new float[]{pointF2.x, pointF2.y};
            float[] fArr2 = new float[2];
            this.f18554h.mapPoints(fArr2, fArr);
            if (c0633b.contains(fArr2[0], fArr2[1])) {
                return true;
            }
        }
        return false;
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

    public final void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        C0635b.m8080a(canvas, pointF, pointF2, this.d);
        C0635b.m8080a(canvas, pointF, pointF4, this.d);
        C0635b.m8080a(canvas, pointF2, pointF3, this.d);
        C0635b.m8080a(canvas, pointF3, pointF4, this.d);
    }
}
