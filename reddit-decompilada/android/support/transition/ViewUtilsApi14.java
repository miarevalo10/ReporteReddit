package android.support.transition;

import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@RequiresApi(14)
class ViewUtilsApi14 implements ViewUtilsImpl {
    ViewUtilsApi14() {
    }

    public ViewOverlayImpl mo178a(View view) {
        return ViewOverlayApi14.m9721c(view);
    }

    public WindowIdImpl mo182b(View view) {
        return new WindowIdApi14(view.getWindowToken());
    }

    public void mo179a(View view, float f) {
        Float f2 = (Float) view.getTag(C0069R.id.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public float mo184c(View view) {
        Float f = (Float) view.getTag(C0069R.id.save_non_transition_alpha);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    public void mo185d(View view) {
        if (view.getTag(C0069R.id.save_non_transition_alpha) == null) {
            view.setTag(C0069R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void mo186e(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(C0069R.id.save_non_transition_alpha, null);
        }
    }

    public void mo181a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo181a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            matrix.preConcat(view);
        }
    }

    public void mo183b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo183b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        view = view.getMatrix();
        if (!view.isIdentity()) {
            Matrix matrix2 = new Matrix();
            if (view.invert(matrix2) != null) {
                matrix.postConcat(matrix2);
            }
        }
    }

    public void mo180a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
