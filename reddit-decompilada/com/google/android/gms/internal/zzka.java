package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;

public final class zzka extends zza<zzxe> {
    private /* synthetic */ Activity f14565a;
    private /* synthetic */ zzjr f14566b;

    public zzka(zzjr com_google_android_gms_internal_zzjr, Activity activity) {
        this.f14566b = com_google_android_gms_internal_zzjr;
        this.f14565a = activity;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzxe a = this.f14566b.f7764h.m14433a(this.f14565a);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14565a, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createAdOverlay(zzn.m17692a(this.f14565a));
    }
}
