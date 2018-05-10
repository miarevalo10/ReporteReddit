package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzgz implements zzhc {
    private /* synthetic */ Activity f14498a;

    zzgz(Activity activity) {
        this.f14498a = activity;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f14498a);
    }
}
