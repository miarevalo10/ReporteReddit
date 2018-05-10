package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;

@zzzv
public final class zzji extends zzp<zzkv> {
    public zzji() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzks m13978a(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, int i) {
        try {
            IBinder a = ((zzkv) m4950a(context)).mo2016a(zzn.m17692a((Object) context), com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, i);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(a);
        } catch (Throwable e) {
            zzakb.m5364a("Could not create remote AdManager.", e);
            return null;
        }
    }

    protected final /* synthetic */ Object mo1683a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzkv ? (zzkv) queryLocalInterface : new zzkw(iBinder);
    }
}
