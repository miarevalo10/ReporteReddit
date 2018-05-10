package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class PropertyValuesHolderUtils {
    private static final PropertyValuesHolderUtilsImpl f849a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f849a = new PropertyValuesHolderUtilsApi21();
        } else {
            f849a = new PropertyValuesHolderUtilsApi14();
        }
    }

    static PropertyValuesHolder m438a(Property<?, PointF> property, Path path) {
        return f849a.mo156a(property, path);
    }
}
