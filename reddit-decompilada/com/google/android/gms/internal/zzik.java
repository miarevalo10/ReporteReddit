package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

@zzzv
public final class zzik extends zzd<zzio> {
    zzik(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, 123, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_internal_zzg);
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return queryLocalInterface instanceof zzio ? (zzio) queryLocalInterface : new zzip(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public final zzio mo1649n() throws DeadObjectException {
        return (zzio) super.m4863r();
    }
}
