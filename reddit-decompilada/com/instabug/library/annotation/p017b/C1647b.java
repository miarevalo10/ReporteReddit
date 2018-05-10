package com.instabug.library.annotation.p017b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import com.instabug.library.Instabug;
import com.instabug.library.annotation.C0629a;
import com.instabug.library.annotation.C0633b;
import com.instabug.library.annotation.p018c.C0634a;
import com.instabug.library.annotation.p018c.C0635b;

/* compiled from: BlurredRectShape */
public class C1647b extends C1351c {
    public final Path mo2580b(C0633b c0633b) {
        return null;
    }

    public C1647b(Bitmap bitmap, Context context) {
        this.a = C0634a.m8071a(bitmap, context);
    }

    public final void mo3673a(Canvas canvas, Bitmap bitmap, float f, float f2) {
        canvas.drawBitmap(bitmap, f, f2, null);
    }

    public final void mo2576a(Canvas canvas, C0633b c0633b, C0629a[] c0629aArr) {
        c0633b = c0633b.m8069e();
        for (int i = 0; i < c0629aArr.length; i++) {
            c0629aArr[i].f9524a = c0633b[i];
            c0629aArr[i].f9525b = Instabug.getPrimaryColor();
            c0629aArr[i].m8054a(canvas);
        }
    }

    public final void mo2574a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        C0635b.m8080a(canvas, pointF, pointF2, this.d);
        C0635b.m8080a(canvas, pointF, pointF4, this.d);
        C0635b.m8080a(canvas, pointF2, pointF3, this.d);
        C0635b.m8080a(canvas, pointF3, pointF4, this.d);
    }

    public final void mo2578a(C0633b c0633b, C0633b c0633b2, boolean z) {
        c0633b2.m8065a(c0633b);
    }
}
