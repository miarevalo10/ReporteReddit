package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzcid;
import com.google.android.gms.internal.zzcif;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzcif {
    private zzcid f14808a;

    public final PendingResult mo2300a() {
        return goAsync();
    }

    public final void mo2301a(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f14808a == null) {
            this.f14808a = new zzcid(this);
        }
        this.f14808a.m5708a(context, intent);
    }
}
