package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzdc implements zzdi {
    private /* synthetic */ Activity f14279a;

    zzdc(Activity activity) {
        this.f14279a = activity;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f14279a);
    }
}
