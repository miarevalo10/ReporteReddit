package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class ViewGroupUtils {
    private static final ViewGroupUtilsImpl f909a;

    static {
        if (VERSION.SDK_INT >= 18) {
            f909a = new ViewGroupUtilsApi18();
        } else {
            f909a = new ViewGroupUtilsApi14();
        }
    }

    static ViewGroupOverlayImpl m490a(ViewGroup viewGroup) {
        return f909a.mo174a(viewGroup);
    }

    static void m491a(ViewGroup viewGroup, boolean z) {
        f909a.mo175a(viewGroup, z);
    }
}
