package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzn;

public final class zzjx extends zza<zzpu> {
    private /* synthetic */ FrameLayout f14561a;
    private /* synthetic */ FrameLayout f14562b;
    private /* synthetic */ Context f14563c;
    private /* synthetic */ zzjr f14564d;

    public zzjx(zzjr com_google_android_gms_internal_zzjr, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f14564d = com_google_android_gms_internal_zzjr;
        this.f14561a = frameLayout;
        this.f14562b = frameLayout2;
        this.f14563c = context;
        super(com_google_android_gms_internal_zzjr);
    }

    public final /* synthetic */ Object mo1959a() throws RemoteException {
        zzpu a = this.f14564d.f7762f.m14234a(this.f14563c, this.f14561a, this.f14562b);
        if (a != null) {
            return a;
        }
        zzjr.m6339a(this.f14563c, "native_ad_view_delegate");
        return new zzmj();
    }

    public final /* synthetic */ Object mo1960a(zzla com_google_android_gms_internal_zzla) throws RemoteException {
        return com_google_android_gms_internal_zzla.createNativeAdViewDelegate(zzn.m17692a(this.f14561a), zzn.m17692a(this.f14562b));
    }
}
