package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

class ThemeUtils {
    static final int[] f2576a = new int[]{-16842910};
    static final int[] f2577b = new int[]{16842908};
    static final int[] f2578c = new int[]{16843518};
    static final int[] f2579d = new int[]{16842919};
    static final int[] f2580e = new int[]{16842912};
    static final int[] f2581f = new int[]{16842913};
    static final int[] f2582g = new int[]{-16842919, -16842908};
    static final int[] f2583h = new int[0];
    private static final ThreadLocal<TypedValue> f2584i = new ThreadLocal();
    private static final int[] f2585j = new int[1];

    public static int m2301a(Context context, int i) {
        f2585j[0] = i;
        context = TintTypedArray.m2307a(context, null, f2585j);
        try {
            i = context.m2313b(0, 0);
            return i;
        } finally {
            context.f2595b.recycle();
        }
    }

    public static ColorStateList m2302b(Context context, int i) {
        f2585j[0] = i;
        context = TintTypedArray.m2307a(context, null, f2585j);
        try {
            i = context.m2320e(0);
            return i;
        } finally {
            context.f2595b.recycle();
        }
    }

    public static int m2303c(Context context, int i) {
        ColorStateList b = m2302b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2576a, b.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) f2584i.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f2584i.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        context = m2301a(context, i);
        return ColorUtils.m798b(context, Math.round(((float) Color.alpha(context)) * f));
    }
}
