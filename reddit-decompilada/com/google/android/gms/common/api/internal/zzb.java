package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzb<T> extends zza {
    protected final TaskCompletionSource<T> f13894a;

    public zzb(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.f13894a = taskCompletionSource;
    }

    public void mo1584a(Status status) {
        this.f13894a.m6860b(new ApiException(status));
    }

    public void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
    }

    public final void mo1586a(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws DeadObjectException {
        try {
            mo3416b(com_google_android_gms_common_api_internal_zzbo_);
        } catch (RemoteException e) {
            mo1584a(zza.m4689a(e));
            throw e;
        } catch (RemoteException e2) {
            mo1584a(zza.m4689a(e2));
        }
    }

    protected abstract void mo3416b(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws RemoteException;
}
