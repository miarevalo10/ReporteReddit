package com.reddit.android.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewConfiguration;

public class TouchDelegate extends android.view.TouchDelegate {
    private View f10262a;
    private Rect f10263b;
    private Rect f10264c;
    private boolean f10265d;
    private int f10266e;

    public TouchDelegate(Rect rect, View view) {
        super(rect, view);
        this.f10263b = rect;
        this.f10266e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f10264c = new Rect(rect);
        this.f10264c.inset(-this.f10266e, -this.f10266e);
        this.f10262a = view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
        r5 = this;
        r0 = r6.getX();
        r0 = (int) r0;
        r1 = r6.getY();
        r1 = (int) r1;
        r2 = r6.getAction();
        r3 = 1;
        r4 = 0;
        switch(r2) {
            case 0: goto L_0x0026;
            case 1: goto L_0x001b;
            case 2: goto L_0x001b;
            case 3: goto L_0x0015;
            default: goto L_0x0013;
        };
    L_0x0013:
        r2 = r4;
        goto L_0x0035;
    L_0x0015:
        r0 = r5.f10265d;
        r5.f10265d = r4;
        r2 = r0;
        goto L_0x0035;
    L_0x001b:
        r2 = r5.f10265d;
        if (r2 == 0) goto L_0x0035;
    L_0x001f:
        r3 = r5.f10264c;
        r3 = r3.contains(r0, r1);
        goto L_0x0035;
    L_0x0026:
        r2 = r5.f10263b;
        r0 = r2.contains(r0, r1);
        if (r0 == 0) goto L_0x0032;
    L_0x002e:
        r5.f10265d = r3;
        r2 = r3;
        goto L_0x0035;
    L_0x0032:
        r5.f10265d = r4;
        goto L_0x0013;
    L_0x0035:
        if (r2 == 0) goto L_0x005a;
    L_0x0037:
        r0 = r5.f10262a;
        if (r3 == 0) goto L_0x004d;
    L_0x003b:
        r1 = r0.getWidth();
        r1 = r1 / 2;
        r1 = (float) r1;
        r2 = r0.getHeight();
        r2 = r2 / 2;
        r2 = (float) r2;
        r6.setLocation(r1, r2);
        goto L_0x0056;
    L_0x004d:
        r1 = r5.f10266e;
        r1 = r1 * 2;
        r1 = -r1;
        r1 = (float) r1;
        r6.setLocation(r1, r1);
    L_0x0056:
        r4 = r0.dispatchTouchEvent(r6);
    L_0x005a:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.android.view.TouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
