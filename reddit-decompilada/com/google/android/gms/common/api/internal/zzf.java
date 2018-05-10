package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf extends zzb<Boolean> {
    private zzck<?> f17311b;

    public zzf(zzck<?> com_google_android_gms_common_api_internal_zzck_, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f17311b = com_google_android_gms_common_api_internal_zzck_;
    }

    public final /* bridge */ /* synthetic */ void mo1584a(Status status) {
        super.mo1584a(status);
    }

    public final /* bridge */ /* synthetic */ void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
    }

    public final void mo3416b(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws RemoteException {
        zzcr com_google_android_gms_common_api_internal_zzcr = (zzcr) com_google_android_gms_common_api_internal_zzbo_.f17294d.remove(this.f17311b);
        if (com_google_android_gms_common_api_internal_zzcr != null) {
            com_google_android_gms_common_api_internal_zzcr.f5821a.f5820a.f5810a = null;
            return;
        }
        com_google_android_gms_common_api_internal_zzbo_ = this.a;
        com_google_android_gms_common_api_internal_zzbo_.f8211a.m14532b(Boolean.valueOf(false));
    }
}
