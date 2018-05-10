package com.instabug.library.invocation.p025a;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.instabug.library.invocation.C0729a;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: TwoFingerSwipeLeftInvoker */
public class C1377f implements C0711a<MotionEvent> {
    public GestureDetectorCompat f15506a;
    public boolean f15507b = false;
    private C0728a f15508c;
    private Context f15509d;
    private C0729a f15510e;

    /* compiled from: TwoFingerSwipeLeftInvoker */
    class C0728a extends SimpleOnGestureListener {
        final /* synthetic */ C1377f f9778a;

        C0728a(C1377f c1377f) {
            this.f9778a = c1377f;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!(C1377f.m15418a(motionEvent, motionEvent2) == null || this.f9778a.f15507b == null)) {
                InstabugSDKLogger.m8356d(this, "Two fingers swiped left, invoking SDK");
                this.f9778a.f15510e.mo2599a();
            }
            this.f9778a.f15507b = false;
            return null;
        }
    }

    public C1377f(Context context, C0729a c0729a) {
        this.f15509d = context;
        this.f15510e = c0729a;
    }

    public final void mo2596a() {
        this.f15508c = new C0728a(this);
        this.f15506a = new GestureDetectorCompat(this.f15509d, this.f15508c);
    }

    public final void mo2597b() {
        this.f15508c = null;
        this.f15506a = null;
    }

    static /* synthetic */ boolean m15418a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent == null || motionEvent2 == null || motionEvent.getX() <= motionEvent2.getX() || motionEvent.getX() - motionEvent2.getX() < Math.abs(motionEvent.getY() - motionEvent2.getY())) ? null : true;
    }
}
