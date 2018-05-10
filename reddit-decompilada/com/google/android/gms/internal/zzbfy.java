package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzbfy extends zzbfs {
    private final zzn<Status> f19213a;

    public zzbfy(zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) {
        this.f19213a = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status;
    }

    public final void mo3485a(int i) throws RemoteException {
        this.f19213a.mo3421a(new Status(i));
    }
}
