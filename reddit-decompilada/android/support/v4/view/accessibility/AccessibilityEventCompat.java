package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat {
    public static void m1315a(AccessibilityEvent accessibilityEvent, int i) {
        if (VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    public static int m1314a(AccessibilityEvent accessibilityEvent) {
        return VERSION.SDK_INT >= 19 ? accessibilityEvent.getContentChangeTypes() : null;
    }
}
