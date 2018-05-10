package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.zzn;

public final class zzjv extends zza<zzkn> {
    private /* synthetic */ Context f14557a;
    private /* synthetic */ String f14558b;
    private /* synthetic */ zzux f14559c;
    private /* synthetic */ zzjr f14560d;

    public zzjv(zzjr com_google_android_gms_internal_zzjr, Context context, String str, zzux com_google_android_gms_internal_zzux) {
        this.f14560d = com_google_android_gms_internal_zzjr;
        this.f14557a = context;
        this.f14558b = str;
        this.f14559c = com_google_android_gms_internal_zzux;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzkn a = this.f14560d.f7760d.m13976a(this.f14557a, this.f14558b, this.f14559c);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14557a, "native_ad");
        return new zzmc();
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createAdLoaderBuilder(zzn.m17692a(this.f14557a), this.f14558b, this.f14559c, zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
