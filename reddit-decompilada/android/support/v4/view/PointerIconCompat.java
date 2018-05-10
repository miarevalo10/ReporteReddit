package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class PointerIconCompat {
    Object f1451a;

    private PointerIconCompat(Object obj) {
        this.f1451a = obj;
    }

    public static PointerIconCompat m1147a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(PointerIcon.getSystemIcon(context, 1002));
        }
        return new PointerIconCompat(null);
    }
}
