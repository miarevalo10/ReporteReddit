package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

public final class zzdt implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final Handler f7285c = new Handler(Looper.getMainLooper());
    WeakReference<View> f7286a;
    long f7287b = -3;
    private final Context f7288d;
    private Application f7289e;
    private final PowerManager f7290f;
    private final KeyguardManager f7291g;
    private final zzdm f7292h;
    private BroadcastReceiver f7293i;
    private WeakReference<ViewTreeObserver> f7294j;
    private zzda f7295k;
    private boolean f7296l = false;
    private int f7297m = -1;

    public zzdt(zzdm com_google_android_gms_internal_zzdm, View view) {
        this.f7292h = com_google_android_gms_internal_zzdm;
        this.f7288d = com_google_android_gms_internal_zzdm.f7216a;
        this.f7290f = (PowerManager) this.f7288d.getSystemService("power");
        this.f7291g = (KeyguardManager) this.f7288d.getSystemService("keyguard");
        if (this.f7288d instanceof Application) {
            this.f7289e = (Application) this.f7288d;
            this.f7295k = new zzda((Application) this.f7288d, this);
        }
        m5901a(view);
    }

    private final void m5895a() {
        f7285c.post(new zzdu(this));
    }

    private final void m5896a(Activity activity, int i) {
        if (this.f7286a != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f7286a.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f7297m = i;
                }
            }
        }
    }

    private final void m5899b(android.view.View r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r3 = r3.getViewTreeObserver();
        r0 = r3.isAlive();
        if (r0 == 0) goto L_0x0017;
    L_0x000a:
        r0 = new java.lang.ref.WeakReference;
        r0.<init>(r3);
        r2.f7294j = r0;
        r3.addOnScrollChangedListener(r2);
        r3.addOnGlobalLayoutListener(r2);
    L_0x0017:
        r3 = r2.f7293i;
        if (r3 != 0) goto L_0x003d;
    L_0x001b:
        r3 = new android.content.IntentFilter;
        r3.<init>();
        r0 = "android.intent.action.SCREEN_ON";
        r3.addAction(r0);
        r0 = "android.intent.action.SCREEN_OFF";
        r3.addAction(r0);
        r0 = "android.intent.action.USER_PRESENT";
        r3.addAction(r0);
        r0 = new com.google.android.gms.internal.zzdv;
        r0.<init>(r2);
        r2.f7293i = r0;
        r0 = r2.f7288d;
        r1 = r2.f7293i;
        r0.registerReceiver(r1, r3);
    L_0x003d:
        r3 = r2.f7289e;
        if (r3 == 0) goto L_0x0048;
    L_0x0041:
        r3 = r2.f7289e;	 Catch:{ Exception -> 0x0048 }
        r0 = r2.f7295k;	 Catch:{ Exception -> 0x0048 }
        r3.registerActivityLifecycleCallbacks(r0);	 Catch:{ Exception -> 0x0048 }
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.b(android.view.View):void");
    }

    private final void m5900c(android.view.View r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.f7294j;	 Catch:{ Exception -> 0x001d }
        if (r1 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x001d }
    L_0x0005:
        r1 = r3.f7294j;	 Catch:{ Exception -> 0x001d }
        r1 = r1.get();	 Catch:{ Exception -> 0x001d }
        r1 = (android.view.ViewTreeObserver) r1;	 Catch:{ Exception -> 0x001d }
        if (r1 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x000f:
        r2 = r1.isAlive();	 Catch:{ Exception -> 0x001d }
        if (r2 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x0015:
        r1.removeOnScrollChangedListener(r3);	 Catch:{ Exception -> 0x001d }
        r1.removeGlobalOnLayoutListener(r3);	 Catch:{ Exception -> 0x001d }
    L_0x001b:
        r3.f7294j = r0;	 Catch:{ Exception -> 0x001d }
    L_0x001d:
        r4 = r4.getViewTreeObserver();	 Catch:{ Exception -> 0x002d }
        r1 = r4.isAlive();	 Catch:{ Exception -> 0x002d }
        if (r1 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x002d }
    L_0x0027:
        r4.removeOnScrollChangedListener(r3);	 Catch:{ Exception -> 0x002d }
        r4.removeGlobalOnLayoutListener(r3);	 Catch:{ Exception -> 0x002d }
    L_0x002d:
        r4 = r3.f7293i;
        if (r4 == 0) goto L_0x003a;
    L_0x0031:
        r4 = r3.f7288d;	 Catch:{ Exception -> 0x0038 }
        r1 = r3.f7293i;	 Catch:{ Exception -> 0x0038 }
        r4.unregisterReceiver(r1);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        r3.f7293i = r0;
    L_0x003a:
        r4 = r3.f7289e;
        if (r4 == 0) goto L_0x0045;
    L_0x003e:
        r4 = r3.f7289e;	 Catch:{ Exception -> 0x0045 }
        r0 = r3.f7295k;	 Catch:{ Exception -> 0x0045 }
        r4.unregisterActivityLifecycleCallbacks(r0);	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.c(android.view.View):void");
    }

    final void m5901a(View view) {
        long j;
        View view2 = this.f7286a != null ? (View) this.f7286a.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m5900c(view2);
        }
        this.f7286a = new WeakReference(view);
        if (view != null) {
            Object obj;
            if (view.getWindowToken() == null) {
                if (view.getWindowVisibility() == 8) {
                    obj = null;
                    if (obj != null) {
                        m5899b(view);
                    }
                    view.addOnAttachStateChangeListener(this);
                    j = -2;
                }
            }
            obj = 1;
            if (obj != null) {
                m5899b(view);
            }
            view.addOnAttachStateChangeListener(this);
            j = -2;
        } else {
            j = -3;
        }
        this.f7287b = j;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m5896a(activity, 0);
        m5898b();
    }

    public final void onActivityDestroyed(Activity activity) {
        m5898b();
    }

    public final void onActivityPaused(Activity activity) {
        m5896a(activity, 4);
        m5898b();
    }

    public final void onActivityResumed(Activity activity) {
        m5896a(activity, 0);
        m5898b();
        m5895a();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m5898b();
    }

    public final void onActivityStarted(Activity activity) {
        m5896a(activity, 0);
        m5898b();
    }

    public final void onActivityStopped(Activity activity) {
        m5898b();
    }

    public final void onGlobalLayout() {
        m5898b();
    }

    public final void onScrollChanged() {
        m5898b();
    }

    public final void onViewAttachedToWindow(View view) {
        this.f7297m = -1;
        m5899b(view);
        m5898b();
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f7297m = -1;
        m5898b();
        m5895a();
        m5900c(view);
    }

    private final void m5898b() {
        if (this.f7286a != null) {
            View view = (View) this.f7286a.get();
            boolean z = false;
            if (view == null) {
                this.f7287b = -3;
                this.f7296l = false;
                return;
            }
            boolean z2;
            int windowVisibility;
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            boolean localVisibleRect = view.getLocalVisibleRect(new Rect());
            if (!this.f7292h.f7227l) {
                if (this.f7291g.inKeyguardRestrictedInputMode()) {
                    Activity a = zzdr.m5887a(view);
                    if (a != null) {
                        Window window = a.getWindow();
                        LayoutParams attributes = window == null ? null : window.getAttributes();
                        if (!(attributes == null || (attributes.flags & 524288) == 0)) {
                            z2 = true;
                            if (z2) {
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                z2 = false;
                windowVisibility = view.getWindowVisibility();
                if (this.f7297m != -1) {
                    windowVisibility = this.f7297m;
                }
                if (view.getVisibility() == 0 && view.isShown() && this.f7290f.isScreenOn() && r4 && localVisibleRect && globalVisibleRect && r6 == 0) {
                    z = true;
                }
                if (this.f7296l != z) {
                    this.f7287b = z ? SystemClock.elapsedRealtime() : -2;
                    this.f7296l = z;
                }
            }
            z2 = true;
            windowVisibility = view.getWindowVisibility();
            if (this.f7297m != -1) {
                windowVisibility = this.f7297m;
            }
            z = true;
            if (this.f7296l != z) {
                if (z) {
                }
                this.f7287b = z ? SystemClock.elapsedRealtime() : -2;
                this.f7296l = z;
            }
        }
    }
}
