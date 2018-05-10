package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zze extends zzi<Boolean> {
    private int f14002a;
    private Bundle f14003b;
    private /* synthetic */ zzd f14004c;

    protected zze(zzd com_google_android_gms_common_internal_zzd, int i, Bundle bundle) {
        this.f14004c = com_google_android_gms_common_internal_zzd;
        super(com_google_android_gms_common_internal_zzd, Boolean.valueOf(true));
        this.f14002a = i;
        this.f14003b = bundle;
    }

    protected abstract void mo3427a(ConnectionResult connectionResult);

    protected final /* synthetic */ void mo1630a(Object obj) {
        if (((Boolean) obj) == null) {
            this.f14004c.m4825a(1, null);
            return;
        }
        int i = this.f14002a;
        PendingIntent pendingIntent = null;
        if (i == 0) {
            if (!mo3428a()) {
                this.f14004c.m4825a(1, null);
                mo3427a(new ConnectionResult(8, null));
            }
        } else if (i != 10) {
            this.f14004c.m4825a(1, null);
            if (this.f14003b != null) {
                pendingIntent = (PendingIntent) this.f14003b.getParcelable("pendingIntent");
            }
            mo3427a(new ConnectionResult(this.f14002a, pendingIntent));
        } else {
            this.f14004c.m4825a(1, null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        }
    }

    protected abstract boolean mo3428a();
}
