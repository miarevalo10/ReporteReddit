package com.instabug.library.annotation.p016a;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: Utility */
public class C0626f {
    private static final RectF f9506a = new RectF(0.0f, 0.0f, 28.0f, 28.0f);

    public static Path m8050a(Path path) {
        Path path2 = new Path(path);
        path = new RectF();
        path2.computeBounds(path, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(path, f9506a, ScaleToFit.CENTER);
        path2.transform(matrix);
        return path2;
    }

    public static Path m8051a(Path path, int i) {
        Path path2 = new Path(path);
        path = new Matrix();
        path.postRotate((float) i, 14.0f, 14.0f);
        path2.transform(path);
        return C0626f.m8050a(path2);
    }
}
