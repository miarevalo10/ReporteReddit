package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzq;

public abstract class zza {
    private int f5765a;

    public zza(int i) {
        this.f5765a = i;
    }

    public abstract void mo1584a(Status status);

    public abstract void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z);

    public abstract void mo1586a(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws DeadObjectException;

    static /* synthetic */ Status m4689a(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (zzq.m4909a() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }
}
