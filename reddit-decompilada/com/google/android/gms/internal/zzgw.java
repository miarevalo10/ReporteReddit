package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzgw implements zzhc {
    private /* synthetic */ Activity f14495a;

    zzgw(Activity activity) {
        this.f14495a = activity;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f14495a);
    }
}
