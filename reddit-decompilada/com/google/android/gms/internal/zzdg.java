package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzdg implements zzdi {
    private /* synthetic */ Activity f14283a;
    private /* synthetic */ Bundle f14284b;

    zzdg(Activity activity, Bundle bundle) {
        this.f14283a = activity;
        this.f14284b = bundle;
    }

    public final void mo1854a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f14283a, this.f14284b);
    }
}
