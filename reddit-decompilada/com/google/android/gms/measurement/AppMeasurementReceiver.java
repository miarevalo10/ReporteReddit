package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.zzcid;
import com.google.android.gms.internal.zzcif;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzcif {
    private zzcid f14810a;

    public final PendingResult mo2300a() {
        return goAsync();
    }

    public final void mo2301a(Context context, Intent intent) {
        WakefulBroadcastReceiver.a_(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f14810a == null) {
            this.f14810a = new zzcid(this);
        }
        this.f14810a.m5708a(context, intent);
    }
}
