package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.zzn;

public final class zzjt extends zza<zzks> {
    private /* synthetic */ Context f14548a;
    private /* synthetic */ zzjn f14549b;
    private /* synthetic */ String f14550c;
    private /* synthetic */ zzjr f14551d;

    public zzjt(zzjr com_google_android_gms_internal_zzjr, Context context, zzjn com_google_android_gms_internal_zzjn, String str) {
        this.f14551d = com_google_android_gms_internal_zzjr;
        this.f14548a = context;
        this.f14549b = com_google_android_gms_internal_zzjn;
        this.f14550c = str;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzks a = this.f14551d.f7759c.m13978a(this.f14548a, this.f14549b, this.f14550c, null, 3);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14548a, "search");
        return new zzmg();
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createSearchAdManager(zzn.m17692a(this.f14548a), this.f14549b, this.f14550c, zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
