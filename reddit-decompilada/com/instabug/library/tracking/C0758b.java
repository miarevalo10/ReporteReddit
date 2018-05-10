package com.instabug.library.tracking;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: InstabugTouchEventsHandler */
public class C0758b {
    public static void m8321a(MotionEvent motionEvent, Activity activity) {
        if (C0758b.m8324b()) {
            InstabugSDKLogger.m8356d(C0758b.class, motionEvent.toString());
            C1381b.m15431c().m15437a(motionEvent);
        }
        InstabugInternalTrackingDelegate.getInstance().trackTouchEvent(motionEvent, activity);
    }

    public static void m8322a(View view, final Activity activity) {
        view.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (C0758b.m8324b() != null) {
                    C1381b.m15431c().m15437a(motionEvent);
                }
                InstabugInternalTrackingDelegate.getInstance().trackTouchEvent(motionEvent, activity);
                return null;
            }
        });
    }

    private static boolean m8324b() {
        return C1381b.m15431c().f15517b == InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT;
    }
}
