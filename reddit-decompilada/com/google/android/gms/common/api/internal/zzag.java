package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzag implements OnCompleteListener<TResult> {
    private /* synthetic */ TaskCompletionSource f13852a;
    private /* synthetic */ zzae f13853b;

    zzag(zzae com_google_android_gms_common_api_internal_zzae, TaskCompletionSource taskCompletionSource) {
        this.f13853b = com_google_android_gms_common_api_internal_zzae;
        this.f13852a = taskCompletionSource;
    }

    public final void mo1558a(Task<TResult> task) {
        this.f13853b.f5767b.remove(this.f13852a);
    }
}
