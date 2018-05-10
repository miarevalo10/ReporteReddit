package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

public final class zzl implements ServiceConnection {
    private final int f5939a;
    private /* synthetic */ zzd f5940b;

    public zzl(zzd com_google_android_gms_common_internal_zzd, int i) {
        this.f5940b = com_google_android_gms_common_internal_zzd;
        this.f5939a = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            zzd.m4826a(this.f5940b);
            return;
        }
        synchronized (this.f5940b.f5923o) {
            zzay com_google_android_gms_common_internal_zzay;
            zzd com_google_android_gms_common_internal_zzd = this.f5940b;
            if (iBinder == null) {
                com_google_android_gms_common_internal_zzay = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                com_google_android_gms_common_internal_zzay = (queryLocalInterface == null || !(queryLocalInterface instanceof zzay)) ? new zzaz(iBinder) : (zzay) queryLocalInterface;
            }
            com_google_android_gms_common_internal_zzd.f5924p = com_google_android_gms_common_internal_zzay;
        }
        this.f5940b.m4842a(0, this.f5939a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f5940b.f5923o) {
            this.f5940b.f5924p = null;
        }
        this.f5940b.f5914f.sendMessage(this.f5940b.f5914f.obtainMessage(6, this.f5939a, 1));
    }
}
