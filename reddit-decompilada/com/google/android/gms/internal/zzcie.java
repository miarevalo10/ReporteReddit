package com.google.android.gms.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcie implements Runnable {
    private /* synthetic */ zzcim f6943a;
    private /* synthetic */ long f6944b;
    private /* synthetic */ Bundle f6945c;
    private /* synthetic */ Context f6946d;
    private /* synthetic */ zzchm f6947e;
    private /* synthetic */ PendingResult f6948f;

    zzcie(zzcim com_google_android_gms_internal_zzcim, long j, Bundle bundle, Context context, zzchm com_google_android_gms_internal_zzchm, PendingResult pendingResult) {
        this.f6943a = com_google_android_gms_internal_zzcim;
        this.f6944b = j;
        this.f6945c = bundle;
        this.f6946d = context;
        this.f6947e = com_google_android_gms_internal_zzchm;
        this.f6948f = pendingResult;
    }

    public final void run() {
        zzclp c = this.f6943a.m5760k().m18013c(this.f6943a.m5765p().m18084z(), "_fot");
        long longValue = (c == null || !(c.f7179e instanceof Long)) ? 0 : ((Long) c.f7179e).longValue();
        long j = this.f6944b;
        if (longValue > 0 && (j >= longValue || j <= 0)) {
            j = longValue - 1;
        }
        if (j > 0) {
            this.f6945c.putLong("click_timestamp", j);
        }
        AppMeasurement.getInstance(this.f6946d).logEventInternal("auto", "_cmp", this.f6945c);
        this.f6947e.f17822g.m5693a("Install campaign recorded");
        if (this.f6948f != null) {
            this.f6948f.finish();
        }
    }
}
