package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

@zzzv
@TargetApi(14)
public final class zzgp implements ActivityLifecycleCallbacks, OnAttachStateChangeListener, OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long f7604a = ((Long) zzkb.m6350f().m6488a(zznh.aZ)).longValue();
    private final Context f7605b;
    private Application f7606c;
    private final WindowManager f7607d;
    private final PowerManager f7608e;
    private final KeyguardManager f7609f;
    private BroadcastReceiver f7610g;
    private WeakReference<ViewTreeObserver> f7611h;
    private WeakReference<View> f7612i;
    private zzgu f7613j;
    private zzaji f7614k = new zzaji(f7604a);
    private boolean f7615l = false;
    private int f7616m = -1;
    private HashSet<zzgt> f7617n = new HashSet();
    private DisplayMetrics f7618o;

    public zzgp(Context context, View view) {
        this.f7605b = context.getApplicationContext();
        this.f7607d = (WindowManager) context.getSystemService("window");
        this.f7608e = (PowerManager) this.f7605b.getSystemService("power");
        this.f7609f = (KeyguardManager) context.getSystemService("keyguard");
        if (this.f7605b instanceof Application) {
            this.f7606c = (Application) this.f7605b;
            this.f7613j = new zzgu((Application) this.f7605b, this);
        }
        this.f7618o = context.getResources().getDisplayMetrics();
        View view2 = this.f7612i != null ? (View) this.f7612i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            m6263b(view2);
        }
        this.f7612i = new WeakReference(view);
        if (view != null) {
            if (zzbs.m4488g().mo4423a(view)) {
                m6260a(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect m6257a(Rect rect) {
        return new Rect(m6262b(rect.left), m6262b(rect.top), m6262b(rect.right), m6262b(rect.bottom));
    }

    private final void m6258a() {
        zzbs.m4486e();
        zzahn.f6379a.post(new zzgq(this));
    }

    private final void m6259a(Activity activity, int i) {
        if (this.f7612i != null) {
            Window window = activity.getWindow();
            if (window != null) {
                View peekDecorView = window.peekDecorView();
                View view = (View) this.f7612i.get();
                if (!(view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView())) {
                    this.f7616m = i;
                }
            }
        }
    }

    private final void m6260a(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f7611h = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f7610g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f7610g = new zzgr(this);
            zzbs.m4480C().m5309a(this.f7605b, this.f7610g, intentFilter);
        }
        if (this.f7606c != null) {
            try {
                this.f7606c.registerActivityLifecycleCallbacks(this.f7613j);
            } catch (Throwable e) {
                zzakb.m5367b("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final int m6262b(int i) {
        return (int) (((float) i) / this.f7618o.density);
    }

    private final void m6263b(View view) {
        try {
            if (this.f7611h != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f7611h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.f7611h = null;
            }
        } catch (Throwable e) {
            zzakb.m5367b("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Throwable e2) {
            zzakb.m5367b("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.f7610g != null) {
            try {
                zzbs.m4480C().m5308a(this.f7605b, this.f7610g);
            } catch (Throwable e22) {
                zzakb.m5367b("Failed trying to unregister the receiver", e22);
            } catch (Throwable e222) {
                zzbs.m4490i().m13246a(e222, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.f7610g = null;
        }
        if (this.f7606c != null) {
            try {
                this.f7606c.unregisterActivityLifecycleCallbacks(this.f7613j);
            } catch (Throwable e2222) {
                zzakb.m5367b("Error registering activity lifecycle callbacks.", e2222);
            }
        }
    }

    final void m6264a(int i) {
        int i2 = i;
        if (this.f7617n.size() != 0 && r1.f7612i != null) {
            boolean z;
            boolean z2;
            boolean z3;
            long b;
            boolean isScreenOn;
            zzgs com_google_android_gms_internal_zzgs;
            Iterator it;
            View view = (View) r1.f7612i.get();
            boolean z4 = false;
            int i3 = i2 == 1 ? 1 : 0;
            int i4 = view == null ? 1 : 0;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            Rect rect5 = new Rect();
            rect5.right = r1.f7607d.getDefaultDisplay().getWidth();
            rect5.bottom = r1.f7607d.getDefaultDisplay().getHeight();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Throwable e) {
                    zzakb.m5367b("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
                z = globalVisibleRect;
                z2 = localVisibleRect;
            } else {
                z = false;
                z2 = z;
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            if (r1.f7616m != -1) {
                windowVisibility = r1.f7616m;
            }
            if (i4 == 0) {
                zzbs.m4486e();
                if (zzahn.m5181a(view, r1.f7608e, r1.f7609f) && z && z2 && r13 == 0) {
                    z3 = true;
                    if (i3 != 0 || r1.f7614k.m5301a() || z3 != r1.f7615l) {
                        if (z3 || r1.f7615l || i2 != 1) {
                            b = zzbs.m4492k().mo1633b();
                            isScreenOn = r1.f7608e.isScreenOn();
                            if (view != null) {
                                z4 = zzbs.m4488g().mo4423a(view);
                            }
                            com_google_android_gms_internal_zzgs = new zzgs(b, isScreenOn, z4, view == null ? view.getWindowVisibility() : 8, m6257a(rect5), m6257a(rect), m6257a(rect2), z, m6257a(rect3), z2, m6257a(rect4), r1.f7618o.density, z3);
                            it = r1.f7617n.iterator();
                            while (it.hasNext()) {
                                ((zzgt) it.next()).mo1711a(com_google_android_gms_internal_zzgs);
                            }
                            r1.f7615l = z3;
                        }
                        return;
                    }
                    return;
                }
            }
            z3 = false;
            if (i3 != 0) {
            }
            if (!z3) {
            }
            b = zzbs.m4492k().mo1633b();
            isScreenOn = r1.f7608e.isScreenOn();
            if (view != null) {
                z4 = zzbs.m4488g().mo4423a(view);
            }
            if (view == null) {
            }
            com_google_android_gms_internal_zzgs = new zzgs(b, isScreenOn, z4, view == null ? view.getWindowVisibility() : 8, m6257a(rect5), m6257a(rect), m6257a(rect2), z, m6257a(rect3), z2, m6257a(rect4), r1.f7618o.density, z3);
            it = r1.f7617n.iterator();
            while (it.hasNext()) {
                ((zzgt) it.next()).mo1711a(com_google_android_gms_internal_zzgs);
            }
            r1.f7615l = z3;
        }
    }

    public final void m6265a(zzgt com_google_android_gms_internal_zzgt) {
        this.f7617n.add(com_google_android_gms_internal_zzgt);
        m6264a(3);
    }

    public final void m6266b(zzgt com_google_android_gms_internal_zzgt) {
        this.f7617n.remove(com_google_android_gms_internal_zzgt);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m6259a(activity, 0);
        m6264a(3);
        m6258a();
    }

    public final void onActivityDestroyed(Activity activity) {
        m6264a(3);
        m6258a();
    }

    public final void onActivityPaused(Activity activity) {
        m6259a(activity, 4);
        m6264a(3);
        m6258a();
    }

    public final void onActivityResumed(Activity activity) {
        m6259a(activity, 0);
        m6264a(3);
        m6258a();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6264a(3);
        m6258a();
    }

    public final void onActivityStarted(Activity activity) {
        m6259a(activity, 0);
        m6264a(3);
        m6258a();
    }

    public final void onActivityStopped(Activity activity) {
        m6264a(3);
        m6258a();
    }

    public final void onGlobalLayout() {
        m6264a(2);
        m6258a();
    }

    public final void onScrollChanged() {
        m6264a(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f7616m = -1;
        m6260a(view);
        m6264a(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f7616m = -1;
        m6264a(3);
        m6258a();
        m6263b(view);
    }
}
