package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ViewGroupUtils {
    private static final ThreadLocal<Matrix> f719a = new ThreadLocal();
    private static final ThreadLocal<RectF> f720b = new ThreadLocal();

    static void m352a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = (Matrix) f719a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f719a.set(matrix);
        } else {
            matrix.reset();
        }
        m353a((ViewParent) viewGroup, view, matrix);
        viewGroup = (RectF) f720b.get();
        if (viewGroup == null) {
            viewGroup = new RectF();
            f720b.set(viewGroup);
        }
        viewGroup.set(rect);
        matrix.mapRect(viewGroup);
        rect.set((int) (viewGroup.left + 1056964608), (int) (viewGroup.top + 0.5f), (int) (viewGroup.right + 0.5f), (int) (viewGroup.bottom + 1056964608));
    }

    private static void m353a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m353a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (view.getMatrix().isIdentity() == null) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
