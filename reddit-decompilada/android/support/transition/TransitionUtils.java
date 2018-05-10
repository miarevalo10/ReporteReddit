package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class TransitionUtils {
    static View m489a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        ViewUtils.m502a(view, matrix);
        ViewUtils.m504b(viewGroup, matrix);
        viewGroup = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(viewGroup);
        view2 = Math.round(viewGroup.left);
        int round = Math.round(viewGroup.top);
        int round2 = Math.round(viewGroup.right);
        int round3 = Math.round(viewGroup.bottom);
        View imageView = new ImageView(view.getContext());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        int round4 = Math.round(viewGroup.width());
        int round5 = Math.round(viewGroup.height());
        if (round4 <= 0 || round5 <= 0) {
            viewGroup = null;
        } else {
            float min = Math.min(1.0f, 1048576.0f / ((float) (round4 * round5)));
            round4 = (int) (((float) round4) * min);
            round5 = (int) (((float) round5) * min);
            matrix.postTranslate(-viewGroup.left, -viewGroup.top);
            matrix.postScale(min, min);
            viewGroup = Bitmap.createBitmap(round4, round5, Config.ARGB_8888);
            Canvas canvas = new Canvas(viewGroup);
            canvas.concat(matrix);
            view.draw(canvas);
        }
        if (viewGroup != null) {
            imageView.setImageBitmap(viewGroup);
        }
        imageView.measure(MeasureSpec.makeMeasureSpec(round2 - view2, 1073741824), MeasureSpec.makeMeasureSpec(round3 - round, 1073741824));
        imageView.layout(view2, round, round2, round3);
        return imageView;
    }

    static Animator m488a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
