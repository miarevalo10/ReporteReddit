package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.zzn;

public final class zzjs extends zza<zzks> {
    private /* synthetic */ Context f14543a;
    private /* synthetic */ zzjn f14544b;
    private /* synthetic */ String f14545c;
    private /* synthetic */ zzux f14546d;
    private /* synthetic */ zzjr f14547e;

    public zzjs(zzjr com_google_android_gms_internal_zzjr, Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux) {
        this.f14547e = com_google_android_gms_internal_zzjr;
        this.f14543a = context;
        this.f14544b = com_google_android_gms_internal_zzjn;
        this.f14545c = str;
        this.f14546d = com_google_android_gms_internal_zzux;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzks a = this.f14547e.f7759c.m13978a(this.f14543a, this.f14544b, this.f14545c, this.f14546d, 1);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14543a, "banner");
        return new zzmg();
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createBannerAdManager(zzn.m17692a(this.f14543a), this.f14544b, this.f14545c, this.f14546d, zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
