package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@zzzv
public final class zzpg extends zzpv implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static String[] f18244b = new String[]{"2011", "1009"};
    FrameLayout f18245a;
    private final Object f18246c = new Object();
    private final FrameLayout f18247d;
    private View f18248e;
    private final boolean f18249f;
    private Map<String, WeakReference<View>> f18250g = Collections.synchronizedMap(new HashMap());
    private View f18251h;
    private zzos f18252i;
    private boolean f18253j = false;
    private Point f18254k = new Point();
    private Point f18255l = new Point();
    private WeakReference<zzgp> f18256m = new WeakReference(null);

    @TargetApi(21)
    public zzpg(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f18247d = frameLayout;
        this.f18245a = frameLayout2;
        zzbs.m4506y();
        zzaln.m5398a(this.f18247d, (OnGlobalLayoutListener) this);
        zzbs.m4506y();
        zzaln.m5399a(this.f18247d, (OnScrollChangedListener) this);
        this.f18247d.setOnTouchListener(this);
        this.f18247d.setOnClickListener(this);
        if (frameLayout2 != null && zzq.m4915g()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zznh.m6490a(this.f18247d.getContext());
        this.f18249f = ((Boolean) zzkb.m6350f().m6488a(zznh.bU)).booleanValue();
    }

    private final int m18931a(int i) {
        zzkb.m6345a();
        return zzajr.m5329b(this.f18252i.mo2088i(), i);
    }

    private final void m18933a(View view) {
        if (this.f18252i != null) {
            zzos d = this.f18252i instanceof zzor ? ((zzor) this.f18252i).m18927d() : this.f18252i;
            if (d != null) {
                d.mo2080b(view);
            }
        }
    }

    private final void m18937b() {
        synchronized (this.f18246c) {
            if (!this.f18249f && this.f18253j) {
                int measuredWidth = this.f18247d.getMeasuredWidth();
                int measuredHeight = this.f18247d.getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.f18245a == null)) {
                    this.f18245a.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.f18253j = false;
                }
            }
        }
    }

    public final IObjectWrapper mo2097a(String str) {
        synchronized (this.f18246c) {
            Object obj = null;
            if (this.f18250g == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.f18250g.get(str);
            if (weakReference != null) {
                obj = (View) weakReference.get();
            }
            IObjectWrapper a = zzn.m17692a(obj);
            return a;
        }
    }

    public final void mo2098a() {
        synchronized (this.f18246c) {
            if (this.f18245a != null) {
                this.f18245a.removeAllViews();
            }
            this.f18245a = null;
            this.f18250g = null;
            this.f18251h = null;
            this.f18252i = null;
            this.f18254k = null;
            this.f18255l = null;
            this.f18256m = null;
            this.f18248e = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2101a(java.lang.String r4, com.google.android.gms.dynamic.IObjectWrapper r5) {
        /*
        r3 = this;
        r5 = com.google.android.gms.dynamic.zzn.m17693a(r5);
        r5 = (android.view.View) r5;
        r0 = r3.f18246c;
        monitor-enter(r0);
        r1 = r3.f18250g;	 Catch:{ all -> 0x0037 }
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return;
    L_0x000f:
        if (r5 != 0) goto L_0x0017;
    L_0x0011:
        r5 = r3.f18250g;	 Catch:{ all -> 0x0037 }
        r5.remove(r4);	 Catch:{ all -> 0x0037 }
        goto L_0x0035;
    L_0x0017:
        r1 = r3.f18250g;	 Catch:{ all -> 0x0037 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0037 }
        r2.<init>(r5);	 Catch:{ all -> 0x0037 }
        r1.put(r4, r2);	 Catch:{ all -> 0x0037 }
        r1 = "1098";
        r4 = r1.equals(r4);	 Catch:{ all -> 0x0037 }
        if (r4 == 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return;
    L_0x002b:
        r5.setOnTouchListener(r3);	 Catch:{ all -> 0x0037 }
        r4 = 1;
        r5.setClickable(r4);	 Catch:{ all -> 0x0037 }
        r5.setOnClickListener(r3);	 Catch:{ all -> 0x0037 }
    L_0x0035:
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        return;
    L_0x0037:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0037 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpg.a(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
        r7 = this;
        r0 = r7.f18246c;
        monitor-enter(r0);
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x0089 }
        return;
    L_0x0009:
        r4 = new android.os.Bundle;	 Catch:{ all -> 0x0089 }
        r4.<init>();	 Catch:{ all -> 0x0089 }
        r1 = "x";
        r2 = r7.f18254k;	 Catch:{ all -> 0x0089 }
        r2 = r2.x;	 Catch:{ all -> 0x0089 }
        r2 = r7.m18931a(r2);	 Catch:{ all -> 0x0089 }
        r2 = (float) r2;	 Catch:{ all -> 0x0089 }
        r4.putFloat(r1, r2);	 Catch:{ all -> 0x0089 }
        r1 = "y";
        r2 = r7.f18254k;	 Catch:{ all -> 0x0089 }
        r2 = r2.y;	 Catch:{ all -> 0x0089 }
        r2 = r7.m18931a(r2);	 Catch:{ all -> 0x0089 }
        r2 = (float) r2;	 Catch:{ all -> 0x0089 }
        r4.putFloat(r1, r2);	 Catch:{ all -> 0x0089 }
        r1 = "start_x";
        r2 = r7.f18255l;	 Catch:{ all -> 0x0089 }
        r2 = r2.x;	 Catch:{ all -> 0x0089 }
        r2 = r7.m18931a(r2);	 Catch:{ all -> 0x0089 }
        r2 = (float) r2;	 Catch:{ all -> 0x0089 }
        r4.putFloat(r1, r2);	 Catch:{ all -> 0x0089 }
        r1 = "start_y";
        r2 = r7.f18255l;	 Catch:{ all -> 0x0089 }
        r2 = r2.y;	 Catch:{ all -> 0x0089 }
        r2 = r7.m18931a(r2);	 Catch:{ all -> 0x0089 }
        r2 = (float) r2;	 Catch:{ all -> 0x0089 }
        r4.putFloat(r1, r2);	 Catch:{ all -> 0x0089 }
        r1 = r7.f18251h;	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x007e;
    L_0x004a:
        r1 = r7.f18251h;	 Catch:{ all -> 0x0089 }
        r1 = r1.equals(r8);	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x007e;
    L_0x0052:
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        r1 = r1 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x0075;
    L_0x0058:
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        r1 = (com.google.android.gms.internal.zzor) r1;	 Catch:{ all -> 0x0089 }
        r1 = r1.m18927d();	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x0087;
    L_0x0062:
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        r1 = (com.google.android.gms.internal.zzor) r1;	 Catch:{ all -> 0x0089 }
        r1 = r1.m18927d();	 Catch:{ all -> 0x0089 }
        r3 = "1007";
        r5 = r7.f18250g;	 Catch:{ all -> 0x0089 }
        r6 = r7.f18247d;	 Catch:{ all -> 0x0089 }
    L_0x0070:
        r2 = r8;
        r1.mo2074a(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0089 }
        goto L_0x0087;
    L_0x0075:
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        r3 = "1007";
        r5 = r7.f18250g;	 Catch:{ all -> 0x0089 }
        r6 = r7.f18247d;	 Catch:{ all -> 0x0089 }
        goto L_0x0070;
    L_0x007e:
        r1 = r7.f18252i;	 Catch:{ all -> 0x0089 }
        r2 = r7.f18250g;	 Catch:{ all -> 0x0089 }
        r3 = r7.f18247d;	 Catch:{ all -> 0x0089 }
        r1.mo2076a(r8, r2, r4, r3);	 Catch:{ all -> 0x0089 }
    L_0x0087:
        monitor-exit(r0);	 Catch:{ all -> 0x0089 }
        return;
    L_0x0089:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0089 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpg.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.f18246c) {
            m18937b();
            if (this.f18252i != null) {
                this.f18252i.mo2084c(this.f18247d, this.f18250g);
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.f18246c) {
            if (this.f18252i != null) {
                this.f18252i.mo2084c(this.f18247d, this.f18250g);
            }
            m18937b();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f18246c) {
            if (this.f18252i == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.f18247d.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
            this.f18254k = point;
            if (motionEvent.getAction() == 0) {
                this.f18255l = point;
            }
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setLocation((float) point.x, (float) point.y);
            this.f18252i.mo2071a(motionEvent);
            motionEvent.recycle();
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2099a(com.google.android.gms.dynamic.IObjectWrapper r11) {
        /*
        r10 = this;
        r0 = r10.f18246c;
        monitor-enter(r0);
        r1 = 0;
        r10.m18933a(r1);	 Catch:{ all -> 0x01a8 }
        r11 = com.google.android.gms.dynamic.zzn.m17693a(r11);	 Catch:{ all -> 0x01a8 }
        r2 = r11 instanceof com.google.android.gms.internal.zzow;	 Catch:{ all -> 0x01a8 }
        if (r2 != 0) goto L_0x0016;
    L_0x000f:
        r11 = "Not an instance of native engine. This is most likely a transient error";
        com.google.android.gms.internal.zzakb.m5371e(r11);	 Catch:{ all -> 0x01a8 }
        monitor-exit(r0);	 Catch:{ all -> 0x01a8 }
        return;
    L_0x0016:
        r2 = r10.f18249f;	 Catch:{ all -> 0x01a8 }
        r3 = 0;
        if (r2 != 0) goto L_0x002e;
    L_0x001b:
        r2 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        if (r2 == 0) goto L_0x002e;
    L_0x001f:
        r2 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        r4 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x01a8 }
        r4.<init>(r3, r3);	 Catch:{ all -> 0x01a8 }
        r2.setLayoutParams(r4);	 Catch:{ all -> 0x01a8 }
        r2 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r2.requestLayout();	 Catch:{ all -> 0x01a8 }
    L_0x002e:
        r2 = 1;
        r10.f18253j = r2;	 Catch:{ all -> 0x01a8 }
        r11 = (com.google.android.gms.internal.zzow) r11;	 Catch:{ all -> 0x01a8 }
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x0052;
    L_0x0037:
        r4 = com.google.android.gms.internal.zznh.bM;	 Catch:{ all -> 0x01a8 }
        r5 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x01a8 }
        r4 = r5.m6488a(r4);	 Catch:{ all -> 0x01a8 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x01a8 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x0052;
    L_0x0049:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r5 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r6 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        r4.mo2081b(r5, r6);	 Catch:{ all -> 0x01a8 }
    L_0x0052:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r4 = r4 instanceof com.google.android.gms.internal.zzow;	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x008a;
    L_0x0058:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r4 = (com.google.android.gms.internal.zzow) r4;	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x008a;
    L_0x005e:
        r5 = r4.f14575b;	 Catch:{ all -> 0x01a8 }
        if (r5 == 0) goto L_0x008a;
    L_0x0062:
        r5 = com.google.android.gms.ads.internal.zzbs.m4507z();	 Catch:{ all -> 0x01a8 }
        r6 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r6 = r6.getContext();	 Catch:{ all -> 0x01a8 }
        r5 = r5.m5097c(r6);	 Catch:{ all -> 0x01a8 }
        if (r5 == 0) goto L_0x008a;
    L_0x0072:
        r4 = r4.m14149j();	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x007b;
    L_0x0078:
        r4.m13229a(r3);	 Catch:{ all -> 0x01a8 }
    L_0x007b:
        r5 = r10.f18256m;	 Catch:{ all -> 0x01a8 }
        r5 = r5.get();	 Catch:{ all -> 0x01a8 }
        r5 = (com.google.android.gms.internal.zzgp) r5;	 Catch:{ all -> 0x01a8 }
        if (r5 == 0) goto L_0x008a;
    L_0x0085:
        if (r4 == 0) goto L_0x008a;
    L_0x0087:
        r5.m6266b(r4);	 Catch:{ all -> 0x01a8 }
    L_0x008a:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r4 = r4 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x00a2;
    L_0x0090:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r4 = (com.google.android.gms.internal.zzor) r4;	 Catch:{ all -> 0x01a8 }
        r4 = r4.m18926c();	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x00a2;
    L_0x009a:
        r4 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r4 = (com.google.android.gms.internal.zzor) r4;	 Catch:{ all -> 0x01a8 }
        r4.m18922a(r11);	 Catch:{ all -> 0x01a8 }
        goto L_0x00ae;
    L_0x00a2:
        r10.f18252i = r11;	 Catch:{ all -> 0x01a8 }
        r4 = r11 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x00ae;
    L_0x00a8:
        r4 = r11;
        r4 = (com.google.android.gms.internal.zzor) r4;	 Catch:{ all -> 0x01a8 }
        r4.m18922a(r1);	 Catch:{ all -> 0x01a8 }
    L_0x00ae:
        r4 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        if (r4 != 0) goto L_0x00b4;
    L_0x00b2:
        monitor-exit(r0);	 Catch:{ all -> 0x01a8 }
        return;
    L_0x00b4:
        r4 = com.google.android.gms.internal.zznh.bM;	 Catch:{ all -> 0x01a8 }
        r5 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x01a8 }
        r4 = r5.m6488a(r4);	 Catch:{ all -> 0x01a8 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x01a8 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x00cb;
    L_0x00c6:
        r4 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        r4.setClickable(r3);	 Catch:{ all -> 0x01a8 }
    L_0x00cb:
        r4 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        r4.removeAllViews();	 Catch:{ all -> 0x01a8 }
        r4 = r11.mo2077a();	 Catch:{ all -> 0x01a8 }
        if (r4 == 0) goto L_0x00f5;
    L_0x00d6:
        r5 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        if (r5 == 0) goto L_0x00f5;
    L_0x00da:
        r5 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        r6 = "1098";
        r5 = r5.get(r6);	 Catch:{ all -> 0x01a8 }
        r5 = (java.lang.ref.WeakReference) r5;	 Catch:{ all -> 0x01a8 }
        if (r5 == 0) goto L_0x00ed;
    L_0x00e6:
        r5 = r5.get();	 Catch:{ all -> 0x01a8 }
        r5 = (android.view.View) r5;	 Catch:{ all -> 0x01a8 }
        goto L_0x00ee;
    L_0x00ed:
        r5 = r1;
    L_0x00ee:
        r6 = r5 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x01a8 }
        if (r6 == 0) goto L_0x00f5;
    L_0x00f2:
        r1 = r5;
        r1 = (android.view.ViewGroup) r1;	 Catch:{ all -> 0x01a8 }
    L_0x00f5:
        if (r4 == 0) goto L_0x00fa;
    L_0x00f7:
        if (r1 == 0) goto L_0x00fa;
    L_0x00f9:
        goto L_0x00fb;
    L_0x00fa:
        r2 = r3;
    L_0x00fb:
        r3 = r11.mo2070a(r10, r2);	 Catch:{ all -> 0x01a8 }
        r10.f18251h = r3;	 Catch:{ all -> 0x01a8 }
        r3 = r10.f18251h;	 Catch:{ all -> 0x01a8 }
        if (r3 == 0) goto L_0x0140;
    L_0x0105:
        r3 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        if (r3 == 0) goto L_0x0117;
    L_0x0109:
        r3 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        r4 = "1007";
        r5 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x01a8 }
        r6 = r10.f18251h;	 Catch:{ all -> 0x01a8 }
        r5.<init>(r6);	 Catch:{ all -> 0x01a8 }
        r3.put(r4, r5);	 Catch:{ all -> 0x01a8 }
    L_0x0117:
        if (r2 == 0) goto L_0x0122;
    L_0x0119:
        r1.removeAllViews();	 Catch:{ all -> 0x01a8 }
        r2 = r10.f18251h;	 Catch:{ all -> 0x01a8 }
        r1.addView(r2);	 Catch:{ all -> 0x01a8 }
        goto L_0x0140;
    L_0x0122:
        r1 = r11.f14575b;	 Catch:{ all -> 0x01a8 }
        r2 = new com.google.android.gms.ads.formats.AdChoicesView;	 Catch:{ all -> 0x01a8 }
        r2.<init>(r1);	 Catch:{ all -> 0x01a8 }
        r1 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x01a8 }
        r3 = -1;
        r1.<init>(r3, r3);	 Catch:{ all -> 0x01a8 }
        r2.setLayoutParams(r1);	 Catch:{ all -> 0x01a8 }
        r1 = r10.f18251h;	 Catch:{ all -> 0x01a8 }
        r2.addView(r1);	 Catch:{ all -> 0x01a8 }
        r1 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        if (r1 == 0) goto L_0x0140;
    L_0x013b:
        r1 = r10.f18245a;	 Catch:{ all -> 0x01a8 }
        r1.addView(r2);	 Catch:{ all -> 0x01a8 }
    L_0x0140:
        r5 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r6 = r10.f18250g;	 Catch:{ all -> 0x01a8 }
        r7 = 0;
        r4 = r11;
        r8 = r10;
        r9 = r10;
        r4.mo3544a(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x01a8 }
        r1 = com.google.android.gms.internal.zzahn.f6379a;	 Catch:{ all -> 0x01a8 }
        r2 = new com.google.android.gms.internal.zzph;	 Catch:{ all -> 0x01a8 }
        r2.<init>(r10, r11);	 Catch:{ all -> 0x01a8 }
        r1.post(r2);	 Catch:{ all -> 0x01a8 }
        r11 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r10.m18933a(r11);	 Catch:{ all -> 0x01a8 }
        r11 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r1 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r11.mo2072a(r1);	 Catch:{ all -> 0x01a8 }
        r11 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r11 = r11 instanceof com.google.android.gms.internal.zzow;	 Catch:{ all -> 0x01a8 }
        if (r11 == 0) goto L_0x01a6;
    L_0x0167:
        r11 = r10.f18252i;	 Catch:{ all -> 0x01a8 }
        r11 = (com.google.android.gms.internal.zzow) r11;	 Catch:{ all -> 0x01a8 }
        if (r11 == 0) goto L_0x01a6;
    L_0x016d:
        r1 = r11.f14575b;	 Catch:{ all -> 0x01a8 }
        if (r1 == 0) goto L_0x01a6;
    L_0x0171:
        r1 = com.google.android.gms.ads.internal.zzbs.m4507z();	 Catch:{ all -> 0x01a8 }
        r2 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r2 = r2.getContext();	 Catch:{ all -> 0x01a8 }
        r1 = r1.m5097c(r2);	 Catch:{ all -> 0x01a8 }
        if (r1 == 0) goto L_0x01a6;
    L_0x0181:
        r1 = r10.f18256m;	 Catch:{ all -> 0x01a8 }
        r1 = r1.get();	 Catch:{ all -> 0x01a8 }
        r1 = (com.google.android.gms.internal.zzgp) r1;	 Catch:{ all -> 0x01a8 }
        if (r1 != 0) goto L_0x019f;
    L_0x018b:
        r1 = new com.google.android.gms.internal.zzgp;	 Catch:{ all -> 0x01a8 }
        r2 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r2 = r2.getContext();	 Catch:{ all -> 0x01a8 }
        r3 = r10.f18247d;	 Catch:{ all -> 0x01a8 }
        r1.<init>(r2, r3);	 Catch:{ all -> 0x01a8 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x01a8 }
        r2.<init>(r1);	 Catch:{ all -> 0x01a8 }
        r10.f18256m = r2;	 Catch:{ all -> 0x01a8 }
    L_0x019f:
        r11 = r11.m14149j();	 Catch:{ all -> 0x01a8 }
        r1.m6265a(r11);	 Catch:{ all -> 0x01a8 }
    L_0x01a6:
        monitor-exit(r0);	 Catch:{ all -> 0x01a8 }
        return;
    L_0x01a8:
        r11 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x01a8 }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpg.a(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void mo2100a(IObjectWrapper iObjectWrapper, int i) {
        if (!(zzbs.m4507z().m5097c(this.f18247d.getContext()) == null || this.f18256m == null)) {
            zzgp com_google_android_gms_internal_zzgp = (zzgp) this.f18256m.get();
            if (com_google_android_gms_internal_zzgp != null) {
                com_google_android_gms_internal_zzgp.m6264a(4);
            }
        }
        m18937b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m18934a(com.google.android.gms.internal.zzpg r6, com.google.android.gms.internal.zzow r7) {
        /*
        r0 = r6.f18246c;
        monitor-enter(r0);
        r1 = r6.f18250g;	 Catch:{ all -> 0x0096 }
        r2 = r7.f14576c;	 Catch:{ all -> 0x0096 }
        r2 = r2.mo3543o();	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x005a;
    L_0x000d:
        r2 = "2";
        r3 = r7.f14576c;	 Catch:{ all -> 0x0096 }
        r3 = r3.mo3540k();	 Catch:{ all -> 0x0096 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x0035;
    L_0x001b:
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x0096 }
        r3 = r7.f14574a;	 Catch:{ all -> 0x0096 }
        r3 = r3.mo1985A();	 Catch:{ all -> 0x0096 }
        r4 = r7.f14576c;	 Catch:{ all -> 0x0096 }
        r4 = r4.mo3540k();	 Catch:{ all -> 0x0096 }
        r5 = "2011";
        r1 = r1.containsKey(r5);	 Catch:{ all -> 0x0096 }
    L_0x0031:
        r2.m13242a(r3, r4, r1);	 Catch:{ all -> 0x0096 }
        goto L_0x005a;
    L_0x0035:
        r2 = "1";
        r3 = r7.f14576c;	 Catch:{ all -> 0x0096 }
        r3 = r3.mo3540k();	 Catch:{ all -> 0x0096 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0096 }
        if (r2 == 0) goto L_0x005a;
    L_0x0043:
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x0096 }
        r3 = r7.f14574a;	 Catch:{ all -> 0x0096 }
        r3 = r3.mo1985A();	 Catch:{ all -> 0x0096 }
        r4 = r7.f14576c;	 Catch:{ all -> 0x0096 }
        r4 = r4.mo3540k();	 Catch:{ all -> 0x0096 }
        r5 = "1009";
        r1 = r1.containsKey(r5);	 Catch:{ all -> 0x0096 }
        goto L_0x0031;
    L_0x005a:
        r1 = r6.f18250g;	 Catch:{ all -> 0x0096 }
        if (r1 == 0) goto L_0x007a;
    L_0x005e:
        r1 = f18244b;	 Catch:{ all -> 0x0096 }
        r2 = r1.length;	 Catch:{ all -> 0x0096 }
        r3 = 0;
    L_0x0062:
        if (r3 >= r2) goto L_0x007a;
    L_0x0064:
        r4 = r1[r3];	 Catch:{ all -> 0x0096 }
        r5 = r6.f18250g;	 Catch:{ all -> 0x0096 }
        r4 = r5.get(r4);	 Catch:{ all -> 0x0096 }
        r4 = (java.lang.ref.WeakReference) r4;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0077;
    L_0x0070:
        r1 = r4.get();	 Catch:{ all -> 0x0096 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0096 }
        goto L_0x007b;
    L_0x0077:
        r3 = r3 + 1;
        goto L_0x0062;
    L_0x007a:
        r1 = 0;
    L_0x007b:
        r2 = r1 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x0096 }
        if (r2 != 0) goto L_0x0084;
    L_0x007f:
        r7.mo2086g();	 Catch:{ all -> 0x0096 }
        monitor-exit(r0);	 Catch:{ all -> 0x0096 }
        return;
    L_0x0084:
        r2 = new com.google.android.gms.internal.zzpi;	 Catch:{ all -> 0x0096 }
        r2.<init>(r6, r1);	 Catch:{ all -> 0x0096 }
        r6 = r7 instanceof com.google.android.gms.internal.zzor;	 Catch:{ all -> 0x0096 }
        if (r6 == 0) goto L_0x0091;
    L_0x008d:
        r7.m14141b(r1, r2);	 Catch:{ all -> 0x0096 }
        goto L_0x0094;
    L_0x0091:
        r7.mo2073a(r1, r2);	 Catch:{ all -> 0x0096 }
    L_0x0094:
        monitor-exit(r0);	 Catch:{ all -> 0x0096 }
        return;
    L_0x0096:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0096 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpg.a(com.google.android.gms.internal.zzpg, com.google.android.gms.internal.zzow):void");
    }
}
