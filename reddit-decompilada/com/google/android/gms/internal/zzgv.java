package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class zzgv implements zzhc {
    private /* synthetic */ Activity f14493a;
    private /* synthetic */ Bundle f14494b;

    zzgv(Activity activity, Bundle bundle) {
        this.f14493a = activity;
        this.f14494b = bundle;
    }

    public final void mo1949a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f14493a, this.f14494b);
    }
}
