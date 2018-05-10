package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public class SwipeToDismissTouchListener implements OnTouchListener {
    private int f24238a;
    private float f24239b;
    private final float f24240c;
    private final float f24241d;
    private Callback f24242e;
    private float f24243f;
    private float f24244g;
    private int f24245h;
    private boolean f24246i;

    class C20831 implements AnimatorUpdateListener {
        final /* synthetic */ SwipeToDismissTouchListener f24237a;

        C20831(SwipeToDismissTouchListener swipeToDismissTouchListener) {
            this.f24237a = swipeToDismissTouchListener;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    public interface Callback {
        void mo5493a();
    }

    public interface SwipeableViewProvider {
        boolean mo5513b();
    }

    public static SwipeToDismissTouchListener m25964a(View view, Callback callback) {
        return new SwipeToDismissTouchListener(callback, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), ((float) view.getContext().getResources().getDisplayMetrics().heightPixels) * 0.5f);
    }

    private SwipeToDismissTouchListener(Callback callback, int i, float f) {
        this(callback, i, f, 0.2f * f);
    }

    private SwipeToDismissTouchListener(Callback callback, int i, float f, float f2) {
        this.f24242e = callback;
        this.f24238a = i;
        this.f24240c = f;
        this.f24241d = f2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r0 = r12 instanceof com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = r12;
        r0 = (com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.SwipeableViewProvider) r0;
        r0 = r0.mo5513b();
        if (r0 != 0) goto L_0x0017;
    L_0x000f:
        r0 = r11.f24246i;
        if (r0 == 0) goto L_0x0014;
    L_0x0013:
        goto L_0x0017;
    L_0x0014:
        r0 = r2;
        goto L_0x00f6;
    L_0x0017:
        r0 = r13.getActionMasked();
        r3 = 5;
        if (r0 == r3) goto L_0x00ec;
    L_0x001e:
        switch(r0) {
            case 0: goto L_0x00cf;
            case 1: goto L_0x00a0;
            case 2: goto L_0x0022;
            case 3: goto L_0x00a0;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x0014;
    L_0x0022:
        r0 = r13.getRawX();
        r3 = r13.getRawY();
        r4 = r11.f24239b;
        r4 = r3 - r4;
        r5 = r11.f24243f;
        r5 = r0 - r5;
        r6 = r11.f24244g;
        r6 = r3 - r6;
        r11.f24243f = r0;
        r11.f24244g = r3;
        r0 = r11.m25966a(r13);
        if (r0 == 0) goto L_0x0014;
    L_0x0040:
        r0 = r11.f24246i;
        if (r0 != 0) goto L_0x0065;
    L_0x0044:
        r0 = java.lang.Math.abs(r4);
        r3 = r11.f24238a;
        r3 = (float) r3;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x004f:
        r0 = r1;
        goto L_0x0052;
    L_0x0051:
        r0 = r2;
    L_0x0052:
        if (r0 == 0) goto L_0x0014;
    L_0x0054:
        r0 = java.lang.Math.abs(r6);
        r3 = java.lang.Math.abs(r5);
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x0062;
    L_0x0060:
        r0 = r1;
        goto L_0x0063;
    L_0x0062:
        r0 = r2;
    L_0x0063:
        if (r0 == 0) goto L_0x0014;
    L_0x0065:
        r11.f24246i = r1;
        r0 = r12.getTranslationY();
        r3 = (double) r6;
        r5 = java.lang.Math.abs(r0);
        r6 = r11.f24241d;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r6 * r7;
        r7 = (double) r5;
        r9 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r7 = java.lang.Math.pow(r7, r9);
        r5 = (double) r6;
        r5 = java.lang.Math.pow(r5, r9);
        r9 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r7 = r7 / r5;
        r9 = r9 - r7;
        r3 = r3 * r9;
        r3 = (float) r3;
        r0 = r0 + r3;
        r3 = r11.f24240c;
        r3 = -r3;
        r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x0093;
    L_0x008f:
        r0 = r11.f24240c;
        r0 = -r0;
        goto L_0x009b;
    L_0x0093:
        r3 = r11.f24240c;
        r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r3 <= 0) goto L_0x009b;
    L_0x0099:
        r0 = r11.f24240c;
    L_0x009b:
        r12.setTranslationY(r0);
        goto L_0x0014;
    L_0x00a0:
        r0 = r11.m25966a(r13);
        if (r0 == 0) goto L_0x00cb;
    L_0x00a6:
        r0 = r11.f24246i;
        if (r0 == 0) goto L_0x00cb;
    L_0x00aa:
        r0 = r12.getTranslationY();
        r3 = r11.f24241d;
        r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x00c0;
    L_0x00b4:
        r3 = r11.f24241d;
        r3 = -r3;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x00bc;
    L_0x00bb:
        goto L_0x00c0;
    L_0x00bc:
        r11.m25965a(r12);
        goto L_0x00cb;
    L_0x00c0:
        r0 = r11.f24242e;
        if (r0 == 0) goto L_0x00c9;
    L_0x00c4:
        r0 = r11.f24242e;
        r0.mo5493a();
    L_0x00c9:
        r0 = r1;
        goto L_0x00cc;
    L_0x00cb:
        r0 = r2;
    L_0x00cc:
        r11.f24246i = r2;
        goto L_0x00f6;
    L_0x00cf:
        r0 = r13.getRawX();
        r11.f24243f = r0;
        r0 = r13.getRawY();
        r11.f24244g = r0;
        r11.f24239b = r0;
        r11.f24246i = r2;
        r0 = r13.getPointerCount();
        r0 = r0 - r1;
        r0 = r13.getPointerId(r0);
        r11.f24245h = r0;
        goto L_0x0014;
    L_0x00ec:
        r11.m25965a(r12);
        r11.f24246i = r2;
        r0 = -1;
        r11.f24245h = r0;
        goto L_0x0014;
    L_0x00f6:
        if (r0 != 0) goto L_0x0100;
    L_0x00f8:
        r12 = r12.onTouchEvent(r13);
        if (r12 == 0) goto L_0x00ff;
    L_0x00fe:
        goto L_0x0100;
    L_0x00ff:
        return r2;
    L_0x0100:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private boolean m25966a(MotionEvent motionEvent) {
        return (this.f24245h < 0 || motionEvent.getPointerCount() != 1) ? null : true;
    }

    private void m25965a(View view) {
        if (view.getTranslationY() != 0.0f) {
            view = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(100);
            view.addUpdateListener(new C20831(this));
            view.start();
        }
    }
}
