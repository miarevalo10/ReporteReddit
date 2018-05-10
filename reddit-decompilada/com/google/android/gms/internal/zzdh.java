package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzdh implements zzdi {
    private /* synthetic */ Activity f14285a;

    zzdh(Activity activity) {
        this.f14285a = activity;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f14285a);
    }
}
