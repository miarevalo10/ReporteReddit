package com.instabug.library.annotation.p016a;

import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import com.instabug.library.annotation.p016a.C0625e.C0624a;
import com.instabug.library.annotation.p018c.C0635b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PathFactory */
public class C0620b {
    private static List<C0623d> f9493a;
    private static List<C0623d> f9494b;

    public static Path m8047a() {
        PointF pointF = new PointF(0.0f, 14.0f);
        PointF pointF2 = new PointF(28.0f, 14.0f);
        float a = C0635b.m8074a(pointF2.x, pointF2.y, pointF.x, pointF.y);
        PointF a2 = C0635b.m8076a(9.0f, 225.0f + a, pointF2);
        PointF a3 = C0635b.m8076a(9.0f, a + 135.0f, pointF2);
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.moveTo(a2.x, a2.y);
        path.lineTo(pointF2.x, pointF2.y);
        path.lineTo(a3.x, a3.y);
        return path;
    }

    public static List<C0623d> m8048a(C0624a c0624a) {
        if (c0624a == C0624a.RECT) {
            if (f9493a != null) {
                return f9493a;
            }
            f9493a = new ArrayList();
        } else if (c0624a == C0624a.OVAL) {
            if (f9494b != null) {
                return f9494b;
            }
            f9494b = new ArrayList();
        }
        RectF rectF = new RectF(0.0f, 0.0f, 28.0f, 28.0f);
        for (int i = 0; i < 12; i++) {
            C0623d c0623d = new C0623d();
            rectF.left += 1.0f;
            rectF.right -= 1.0f;
            if (c0624a == C0624a.RECT) {
                c0623d.f9498a.addRect(rectF, Direction.CW);
                f9493a.add(c0623d);
            } else if (c0624a == C0624a.OVAL) {
                c0623d.f9498a.addOval(rectF, Direction.CW);
                f9494b.add(c0623d);
            }
            c0623d.f9499b = rectF.left / 28.0f;
        }
        if (c0624a == C0624a.RECT) {
            return f9493a;
        }
        return c0624a == C0624a.OVAL ? f9494b : null;
    }
}
