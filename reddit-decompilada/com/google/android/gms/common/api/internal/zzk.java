package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzk implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzk f5848c = new zzk();
    final AtomicBoolean f5849a = new AtomicBoolean();
    final AtomicBoolean f5850b = new AtomicBoolean();
    private final ArrayList<zzl> f5851d = new ArrayList();
    private boolean f5852e = false;

    private zzk() {
    }

    public static zzk m4769a() {
        return f5848c;
    }

    public static void m4770a(Application application) {
        synchronized (f5848c) {
            if (!f5848c.f5852e) {
                application.registerActivityLifecycleCallbacks(f5848c);
                application.registerComponentCallbacks(f5848c);
                f5848c.f5852e = true;
            }
        }
    }

    private final void m4771a(boolean z) {
        synchronized (f5848c) {
            ArrayList arrayList = this.f5851d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzl) obj).mo1604a(z);
            }
        }
    }

    public final void m4772a(zzl com_google_android_gms_common_api_internal_zzl) {
        synchronized (f5848c) {
            this.f5851d.add(com_google_android_gms_common_api_internal_zzl);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f5849a.compareAndSet(true, false);
        this.f5850b.set(true);
        if (compareAndSet) {
            m4771a(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f5849a.compareAndSet(true, false);
        this.f5850b.set(true);
        if (compareAndSet) {
            m4771a(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f5849a.compareAndSet(false, true)) {
            this.f5850b.set(true);
            m4771a(true);
        }
    }
}
