package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzc<A extends zzm<? extends Result, zzb>> extends zza {
    private A f13938a;

    public zzc(int i, A a) {
        super(i);
        this.f13938a = a;
    }

    public final void mo1584a(Status status) {
        this.f13938a.m17674c(status);
    }

    public final void mo1586a(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws DeadObjectException {
        this.f13938a.m17673b(com_google_android_gms_common_api_internal_zzbo_.f17291a);
    }

    public final void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
        PendingResult pendingResult = this.f13938a;
        com_google_android_gms_common_api_internal_zzae.f5766a.put(pendingResult, Boolean.valueOf(z));
        pendingResult.mo1542a(new zzaf(com_google_android_gms_common_api_internal_zzae, pendingResult));
    }
}
