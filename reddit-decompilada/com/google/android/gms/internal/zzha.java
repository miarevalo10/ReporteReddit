package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzha implements zzhc {
    private /* synthetic */ Activity f14503a;
    private /* synthetic */ Bundle f14504b;

    zzha(Activity activity, Bundle bundle) {
        this.f14503a = activity;
        this.f14504b = bundle;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f14503a, this.f14504b);
    }
}
