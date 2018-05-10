package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzd extends zzb<Void> {
    private zzcq<zzb, ?> f17305b;
    private zzdn<zzb, ?> f17306c;

    public zzd(zzcr com_google_android_gms_common_api_internal_zzcr, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.f17305b = com_google_android_gms_common_api_internal_zzcr.f5821a;
        this.f17306c = com_google_android_gms_common_api_internal_zzcr.f5822b;
    }

    public final /* bridge */ /* synthetic */ void mo1584a(Status status) {
        super.mo1584a(status);
    }

    public final /* bridge */ /* synthetic */ void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
    }

    public final void mo3416b(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws RemoteException {
        if (this.f17305b.f5820a.f5811b != null) {
            com_google_android_gms_common_api_internal_zzbo_.f17294d.put(this.f17305b.f5820a.f5811b, new zzcr(this.f17305b, this.f17306c));
        }
    }
}
