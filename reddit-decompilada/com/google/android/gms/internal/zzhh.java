package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public final class zzhh implements ActivityLifecycleCallbacks {
    Activity f7659a;
    public Context f7660b;
    final Object f7661c = new Object();
    final List<zzhj> f7662d = new ArrayList();
    public boolean f7663e = false;
    public long f7664f;
    private boolean f7665g = true;
    private boolean f7666h = false;
    private final List<zzhw> f7667i = new ArrayList();
    private Runnable f7668j;

    public final void m6290a(Activity activity) {
        synchronized (this.f7661c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f7659a = activity;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f7661c) {
            if (this.f7659a == null) {
                return;
            }
            if (this.f7659a.equals(activity)) {
                this.f7659a = null;
            }
            Iterator it = this.f7667i.iterator();
            while (it.hasNext()) {
                try {
                    if (((zzhw) it.next()).m6303a()) {
                        it.remove();
                    }
                } catch (Throwable e) {
                    zzbs.m4490i().m13246a(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzakb.m5367b("onActivityStateChangedListener threw exception.", e);
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        m6290a(activity);
        synchronized (this.f7661c) {
            Iterator it = this.f7667i.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.f7666h = true;
        if (this.f7668j != null) {
            zzahn.f6379a.removeCallbacks(this.f7668j);
        }
        Handler handler = zzahn.f6379a;
        Runnable com_google_android_gms_internal_zzhi = new zzhi(this);
        this.f7668j = com_google_android_gms_internal_zzhi;
        handler.postDelayed(com_google_android_gms_internal_zzhi, this.f7664f);
    }

    public final void onActivityResumed(Activity activity) {
        m6290a(activity);
        this.f7666h = false;
        int i = this.f7665g ^ 1;
        this.f7665g = true;
        if (this.f7668j != null) {
            zzahn.f6379a.removeCallbacks(this.f7668j);
        }
        synchronized (this.f7661c) {
            Iterator it = this.f7667i.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (i != 0) {
                for (zzhj d : this.f7662d) {
                    try {
                        d.mo1716d(true);
                    } catch (Throwable e) {
                        zzakb.m5367b("OnForegroundStateChangedListener threw exception.", e);
                    }
                }
            } else {
                zzakb.m5366b("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        m6290a(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }
}
