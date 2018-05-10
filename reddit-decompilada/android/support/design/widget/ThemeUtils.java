package android.support.design.widget;

import android.content.Context;
import android.support.v7.appcompat.C0164R;

class ThemeUtils {
    private static final int[] f697a = new int[]{C0164R.attr.colorPrimary};

    static void m333a(Context context) {
        context = context.obtainStyledAttributes(f697a);
        int hasValue = context.hasValue(0) ^ 1;
        context.recycle();
        if (hasValue != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
