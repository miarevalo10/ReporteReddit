package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzgu implements ActivityLifecycleCallbacks {
    private final Application f7634a;
    private final WeakReference<ActivityLifecycleCallbacks> f7635b;
    private boolean f7636c = false;

    public zzgu(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f7635b = new WeakReference(activityLifecycleCallbacks);
        this.f7634a = application;
    }

    private final void m6268a(zzhc com_google_android_gms_internal_zzhc) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f7635b.get();
            if (activityLifecycleCallbacks != null) {
                com_google_android_gms_internal_zzhc.mo1949a(activityLifecycleCallbacks);
                return;
            }
            if (!this.f7636c) {
                this.f7634a.unregisterActivityLifecycleCallbacks(this);
                this.f7636c = true;
            }
        } catch (Throwable e) {
            zzakb.m5367b("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m6268a(new zzgv(activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m6268a(new zzhb(activity));
    }

    public final void onActivityPaused(Activity activity) {
        m6268a(new zzgy(activity));
    }

    public final void onActivityResumed(Activity activity) {
        m6268a(new zzgx(activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m6268a(new zzha(activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m6268a(new zzgw(activity));
    }

    public final void onActivityStopped(Activity activity) {
        m6268a(new zzgz(activity));
    }
}
