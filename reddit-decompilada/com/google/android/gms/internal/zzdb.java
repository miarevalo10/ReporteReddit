package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzdb implements zzdi {
    private /* synthetic */ Activity f14277a;
    private /* synthetic */ Bundle f14278b;

    zzdb(Activity activity, Bundle bundle) {
        this.f14277a = activity;
        this.f14278b = bundle;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f14277a, this.f14278b);
    }
}
