package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.zzp;
import com.google.android.gms.dynamic.zzn;

public final class zzju extends zza<zzks> {
    private /* synthetic */ Context f14552a;
    private /* synthetic */ zzjn f14553b;
    private /* synthetic */ String f14554c;
    private /* synthetic */ zzux f14555d;
    private /* synthetic */ zzjr f14556e;

    public zzju(zzjr com_google_android_gms_internal_zzjr, Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux) {
        this.f14556e = com_google_android_gms_internal_zzjr;
        this.f14552a = context;
        this.f14553b = com_google_android_gms_internal_zzjn;
        this.f14554c = str;
        this.f14555d = com_google_android_gms_internal_zzux;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzks a = this.f14556e.f7759c.m13978a(this.f14552a, this.f14553b, this.f14554c, this.f14555d, 2);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14552a, "interstitial");
        return new zzmg();
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createInterstitialAdManager(zzn.m17692a(this.f14552a), this.f14553b, this.f14554c, this.f14555d, zzp.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }
}
