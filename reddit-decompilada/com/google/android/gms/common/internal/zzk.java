package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzk extends zzax {
    private zzd f17338a;
    private final int f17339b;

    public zzk(zzd com_google_android_gms_common_internal_zzd, int i) {
        this.f17338a = com_google_android_gms_common_internal_zzd;
        this.f17339b = i;
    }

    public final void mo3425a() {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void mo3426a(int i, IBinder iBinder, Bundle bundle) {
        zzbq.m4809a(this.f17338a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.f17338a.m4843a(i, iBinder, bundle, this.f17339b);
        this.f17338a = null;
    }
}
