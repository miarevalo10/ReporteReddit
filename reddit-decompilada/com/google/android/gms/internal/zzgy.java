package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzgy implements zzhc {
    private /* synthetic */ Activity f14497a;

    zzgy(Activity activity) {
        this.f14497a = activity;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f14497a);
    }
}
