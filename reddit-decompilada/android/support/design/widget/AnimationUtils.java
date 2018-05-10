package android.support.design.widget;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class AnimationUtils {
    static final Interpolator f406a = new LinearInterpolator();
    static final Interpolator f407b = new FastOutSlowInInterpolator();
    static final Interpolator f408c = new FastOutLinearInInterpolator();
    static final Interpolator f409d = new LinearOutSlowInInterpolator();
    static final Interpolator f410e = new DecelerateInterpolator();

    static float m163a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    static int m164a(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
