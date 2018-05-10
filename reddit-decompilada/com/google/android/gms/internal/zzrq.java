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
public final class zzrq extends zzd<zzrv> {
    zzrq(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg) {
        super(context, looper, 166, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_internal_zzg);
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        return queryLocalInterface instanceof zzrv ? (zzrv) queryLocalInterface : new zzrw(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    public final zzrv mo1649n() throws DeadObjectException {
        return (zzrv) super.m4863r();
    }
}
