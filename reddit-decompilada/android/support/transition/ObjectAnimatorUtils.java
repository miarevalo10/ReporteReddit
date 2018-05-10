package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class ObjectAnimatorUtils {
    private static final ObjectAnimatorUtilsImpl f842a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f842a = new ObjectAnimatorUtilsApi21();
        } else {
            f842a = new ObjectAnimatorUtilsApi14();
        }
    }

    static <T> ObjectAnimator m435a(T t, Property<T, PointF> property, Path path) {
        return f842a.mo155a(t, property, path);
    }
}
