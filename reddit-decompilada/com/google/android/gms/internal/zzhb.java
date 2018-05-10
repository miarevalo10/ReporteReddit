package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzhb implements zzhc {
    private /* synthetic */ Activity f14505a;

    zzhb(Activity activity) {
        this.f14505a = activity;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f14505a);
    }
}
