package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzde implements zzdi {
    private /* synthetic */ Activity f14281a;

    zzde(Activity activity) {
        this.f14281a = activity;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f14281a);
    }
}
