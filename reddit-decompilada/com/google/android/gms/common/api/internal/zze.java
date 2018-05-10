package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zze<TResult> extends zza {
    private final zzdd<zzb, TResult> f13957a;
    private final TaskCompletionSource<TResult> f13958b;
    private final zzcz f13959c;

    public zze(int i, zzdd<zzb, TResult> com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource, zzcz com_google_android_gms_common_api_internal_zzcz) {
        super(i);
        this.f13958b = taskCompletionSource;
        this.f13957a = com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult;
        this.f13959c = com_google_android_gms_common_api_internal_zzcz;
    }

    public final void mo1584a(Status status) {
        this.f13958b.m6860b(this.f13959c.mo1612a(status));
    }

    public final void mo1586a(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws DeadObjectException {
    }

    public final void mo1585a(zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
        TaskCompletionSource taskCompletionSource = this.f13958b;
        com_google_android_gms_common_api_internal_zzae.f5767b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.f8211a.mo2306a(new zzag(com_google_android_gms_common_api_internal_zzae, taskCompletionSource));
    }
}
