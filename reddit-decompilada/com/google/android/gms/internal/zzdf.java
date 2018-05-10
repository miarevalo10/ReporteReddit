package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzdf implements zzdi {
    private /* synthetic */ Activity f14282a;

    zzdf(Activity activity) {
        this.f14282a = activity;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f14282a);
    }
}
