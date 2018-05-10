package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzdd implements zzdi {
    private /* synthetic */ Activity f14280a;

    zzdd(Activity activity) {
        this.f14280a = activity;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f14280a);
    }
}
