package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ForwardingListener implements OnAttachStateChangeListener, OnTouchListener {
    private final float f2267a;
    private final int f2268b;
    final View f2269c;
    boolean f2270d;
    private final int f2271e;
    private Runnable f2272f;
    private Runnable f2273g;
    private int f2274h;
    private final int[] f2275i = new int[2];

    private class DisallowIntercept implements Runnable {
        final /* synthetic */ ForwardingListener f2265a;

        DisallowIntercept(ForwardingListener forwardingListener) {
            this.f2265a = forwardingListener;
        }

        public void run() {
            ViewParent parent = this.f2265a.f2269c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        final /* synthetic */ ForwardingListener f2266a;

        TriggerLongPress(ForwardingListener forwardingListener) {
            this.f2266a = forwardingListener;
        }

        public void run() {
            ForwardingListener forwardingListener = this.f2266a;
            forwardingListener.m1965d();
            View view = forwardingListener.f2269c;
            if (view.isEnabled()) {
                if (!view.isLongClickable()) {
                    if (forwardingListener.mo533b()) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        view.onTouchEvent(obtain);
                        obtain.recycle();
                        forwardingListener.f2270d = true;
                    }
                }
            }
        }
    }

    public abstract ShowableListMenu mo532a();

    public void onViewAttachedToWindow(View view) {
    }

    public ForwardingListener(View view) {
        this.f2269c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2267a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f2268b = ViewConfiguration.getTapTimeout();
        this.f2271e = (this.f2268b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
        r10 = this;
        r11 = r10.f2270d;
        r0 = 1;
        r1 = 0;
        if (r11 == 0) goto L_0x0071;
    L_0x0006:
        r2 = r10.f2269c;
        r3 = r10.mo532a();
        if (r3 == 0) goto L_0x0061;
    L_0x000e:
        r4 = r3.mo655f();
        if (r4 != 0) goto L_0x0015;
    L_0x0014:
        goto L_0x0061;
    L_0x0015:
        r3 = r3.mo656g();
        r3 = (android.support.v7.widget.DropDownListView) r3;
        if (r3 == 0) goto L_0x0061;
    L_0x001d:
        r4 = r3.isShown();
        if (r4 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0061;
    L_0x0024:
        r4 = android.view.MotionEvent.obtainNoHistory(r12);
        r5 = r10.f2275i;
        r2.getLocationOnScreen(r5);
        r2 = r5[r1];
        r2 = (float) r2;
        r5 = r5[r0];
        r5 = (float) r5;
        r4.offsetLocation(r2, r5);
        r2 = r10.f2275i;
        r3.getLocationOnScreen(r2);
        r5 = r2[r1];
        r5 = -r5;
        r5 = (float) r5;
        r2 = r2[r0];
        r2 = -r2;
        r2 = (float) r2;
        r4.offsetLocation(r5, r2);
        r2 = r10.f2274h;
        r2 = r3.mo3247a(r4, r2);
        r4.recycle();
        r12 = r12.getActionMasked();
        if (r12 == r0) goto L_0x005a;
    L_0x0055:
        r3 = 3;
        if (r12 == r3) goto L_0x005a;
    L_0x0058:
        r12 = r0;
        goto L_0x005b;
    L_0x005a:
        r12 = r1;
    L_0x005b:
        if (r2 == 0) goto L_0x0061;
    L_0x005d:
        if (r12 == 0) goto L_0x0061;
    L_0x005f:
        r12 = r0;
        goto L_0x0062;
    L_0x0061:
        r12 = r1;
    L_0x0062:
        if (r12 != 0) goto L_0x006e;
    L_0x0064:
        r12 = r10.mo569c();
        if (r12 != 0) goto L_0x006b;
    L_0x006a:
        goto L_0x006e;
    L_0x006b:
        r12 = r1;
        goto L_0x011f;
    L_0x006e:
        r12 = r0;
        goto L_0x011f;
    L_0x0071:
        r2 = r10.f2269c;
        r3 = r2.isEnabled();
        if (r3 == 0) goto L_0x00fc;
    L_0x0079:
        r3 = r12.getActionMasked();
        switch(r3) {
            case 0: goto L_0x00d0;
            case 1: goto L_0x00cc;
            case 2: goto L_0x0082;
            case 3: goto L_0x00cc;
            default: goto L_0x0080;
        };
    L_0x0080:
        goto L_0x00fc;
    L_0x0082:
        r3 = r10.f2274h;
        r3 = r12.findPointerIndex(r3);
        if (r3 < 0) goto L_0x00fc;
    L_0x008a:
        r4 = r12.getX(r3);
        r12 = r12.getY(r3);
        r3 = r10.f2267a;
        r5 = -r3;
        r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r6 < 0) goto L_0x00bd;
    L_0x0099:
        r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r5 < 0) goto L_0x00bd;
    L_0x009d:
        r5 = r2.getRight();
        r6 = r2.getLeft();
        r5 = r5 - r6;
        r5 = (float) r5;
        r5 = r5 + r3;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 >= 0) goto L_0x00bd;
    L_0x00ac:
        r4 = r2.getBottom();
        r5 = r2.getTop();
        r4 = r4 - r5;
        r4 = (float) r4;
        r4 = r4 + r3;
        r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r12 >= 0) goto L_0x00bd;
    L_0x00bb:
        r12 = r0;
        goto L_0x00be;
    L_0x00bd:
        r12 = r1;
    L_0x00be:
        if (r12 != 0) goto L_0x00fc;
    L_0x00c0:
        r10.m1965d();
        r12 = r2.getParent();
        r12.requestDisallowInterceptTouchEvent(r0);
        r12 = r0;
        goto L_0x00fd;
    L_0x00cc:
        r10.m1965d();
        goto L_0x00fc;
    L_0x00d0:
        r12 = r12.getPointerId(r1);
        r10.f2274h = r12;
        r12 = r10.f2272f;
        if (r12 != 0) goto L_0x00e1;
    L_0x00da:
        r12 = new android.support.v7.widget.ForwardingListener$DisallowIntercept;
        r12.<init>(r10);
        r10.f2272f = r12;
    L_0x00e1:
        r12 = r10.f2272f;
        r3 = r10.f2268b;
        r3 = (long) r3;
        r2.postDelayed(r12, r3);
        r12 = r10.f2273g;
        if (r12 != 0) goto L_0x00f4;
    L_0x00ed:
        r12 = new android.support.v7.widget.ForwardingListener$TriggerLongPress;
        r12.<init>(r10);
        r10.f2273g = r12;
    L_0x00f4:
        r12 = r10.f2273g;
        r3 = r10.f2271e;
        r3 = (long) r3;
        r2.postDelayed(r12, r3);
    L_0x00fc:
        r12 = r1;
    L_0x00fd:
        if (r12 == 0) goto L_0x0107;
    L_0x00ff:
        r12 = r10.mo533b();
        if (r12 == 0) goto L_0x0107;
    L_0x0105:
        r12 = r0;
        goto L_0x0108;
    L_0x0107:
        r12 = r1;
    L_0x0108:
        if (r12 == 0) goto L_0x011f;
    L_0x010a:
        r4 = android.os.SystemClock.uptimeMillis();
        r6 = 3;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r2 = r4;
        r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9);
        r3 = r10.f2269c;
        r3.onTouchEvent(r2);
        r2.recycle();
    L_0x011f:
        r10.f2270d = r12;
        if (r12 != 0) goto L_0x0127;
    L_0x0123:
        if (r11 == 0) goto L_0x0126;
    L_0x0125:
        goto L_0x0127;
    L_0x0126:
        return r1;
    L_0x0127:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ForwardingListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void onViewDetachedFromWindow(View view) {
        this.f2270d = null;
        this.f2274h = -1;
        if (this.f2272f != null) {
            this.f2269c.removeCallbacks(this.f2272f);
        }
    }

    public boolean mo533b() {
        ShowableListMenu a = mo532a();
        if (!(a == null || a.mo655f())) {
            a.mo653d();
        }
        return true;
    }

    protected boolean mo569c() {
        ShowableListMenu a = mo532a();
        if (a != null && a.mo655f()) {
            a.mo654e();
        }
        return true;
    }

    final void m1965d() {
        if (this.f2273g != null) {
            this.f2269c.removeCallbacks(this.f2273g);
        }
        if (this.f2272f != null) {
            this.f2269c.removeCallbacks(this.f2272f);
        }
    }
}
