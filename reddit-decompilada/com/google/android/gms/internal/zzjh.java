package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;

@zzzv
public final class zzjh extends zzp<zzkq> {
    public zzjh() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzkn m13976a(Context context, String str, zzux com_google_android_gms_internal_zzux) {
        try {
            IBinder a = ((zzkq) m4950a(context)).mo1984a(zzn.m17692a((Object) context), str, com_google_android_gms_internal_zzux);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkp(a);
        } catch (Throwable e) {
            zzakb.m5369c("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo1683a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzkq ? (zzkq) queryLocalInterface : new zzkr(iBinder);
    }
}
