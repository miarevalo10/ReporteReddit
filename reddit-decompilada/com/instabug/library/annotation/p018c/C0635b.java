package com.instabug.library.annotation.p018c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DrawingUtility */
public class C0635b {
    public static void m8080a(Canvas canvas, PointF pointF, PointF pointF2, Paint paint) {
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, paint);
    }

    public static float m8074a(float f, float f2, float f3, float f4) {
        return (float) Math.toDegrees(Math.atan2((double) (f2 - f4), (double) (f - f3)));
    }

    public static void m8079a(float f, float f2, PointF pointF, PointF pointF2) {
        double d = (double) f;
        f = (((double) f2) * 3.141592653589793d) / 180.0d;
        pointF2.x = ((float) (Math.cos(f) * d)) + pointF.x;
        pointF2.y = ((float) (d * Math.sin(f))) + pointF.y;
    }

    public static PointF m8076a(float f, float f2, PointF pointF) {
        PointF pointF2 = new PointF();
        C0635b.m8079a(f, f2, pointF, pointF2);
        return pointF2;
    }

    public static PointF m8075a(float f, float f2, float f3, PointF pointF) {
        double d = (((double) f3) * 3.141592653589793d) / 180.0d;
        double sin = Math.sin(d);
        d = Math.cos(d);
        pointF.x -= f;
        pointF.y -= f2;
        double d2 = (((double) pointF.x) * sin) + (((double) pointF.y) * d);
        pointF.x = ((float) ((((double) pointF.x) * d) - (((double) pointF.y) * sin))) + f;
        pointF.y = ((float) d2) + f2;
        return pointF;
    }

    public static double m8073a(PointF pointF, PointF pointF2, PointF pointF3) {
        double[] dArr = new double[]{(double) pointF.x, (double) pointF.y};
        double[] dArr2 = new double[]{(double) pointF2.x, (double) pointF2.y};
        pointF2 = new double[]{(double) pointF3.x, (double) pointF3.y};
        pointF3 = new double[2];
        double[] dArr3 = new double[]{dArr2[0] - dArr[0], dArr2[1] - dArr[1]};
        dArr3[0] = pointF2[0] - dArr[0];
        dArr3[1] = pointF2[1] - dArr[1];
        double d = (pointF3[0] * dArr3[1]) - (pointF3[1] * dArr3[0]);
        pointF2 = dArr[0] - dArr2[0];
        double d2 = dArr[1] - dArr2[1];
        return Math.abs(d / Math.sqrt((pointF2 * pointF2) + (d2 * d2)));
    }

    public static PointF m8077a(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x + pointF2.x) / 2.0f;
        pointF3.y = (pointF.y + pointF2.y) / 1073741824;
        return pointF3;
    }

    public static List<PointF> m8078a(Path path) {
        List<PointF> arrayList = new ArrayList();
        PathMeasure pathMeasure = new PathMeasure(path, false);
        path = pathMeasure.getLength();
        float[] fArr = new float[2];
        int i = 0;
        while (true) {
            float f = (float) i;
            if (f >= path) {
                return arrayList;
            }
            pathMeasure.getPosTan(f, fArr, null);
            arrayList.add(new PointF(fArr[0], fArr[1]));
            i++;
        }
    }
}
