package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzgx implements zzhc {
    private /* synthetic */ Activity f14496a;

    zzgx(Activity activity) {
        this.f14496a = activity;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f14496a);
    }
}
