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
public final class zzaas extends zzd<zzabb> {
    private int f14033a;

    public zzaas(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzg com_google_android_gms_common_internal_zzg, int i) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        super(context, looper, 8, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_internal_zzg);
        this.f14033a = i;
    }

    protected final /* synthetic */ IInterface mo1646a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof zzabb ? (zzabb) queryLocalInterface : new zzabd(iBinder);
    }

    protected final String mo1647a() {
        return "com.google.android.gms.ads.service.START";
    }

    protected final String mo1648b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final zzabb mo1649n() throws DeadObjectException {
        return (zzabb) super.m4863r();
    }
}
