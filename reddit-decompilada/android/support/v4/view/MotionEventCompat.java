package android.support.v4.view;

import android.view.MotionEvent;

public final class MotionEventCompat {
    @Deprecated
    public static int m1120a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean m1121b(MotionEvent motionEvent) {
        return (motionEvent.getSource() & 8194) == 8194 ? true : null;
    }
}
