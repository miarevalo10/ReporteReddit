package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

public final class zzj {
    final ArrayMap<zzh<?>, ConnectionResult> f5843a = new ArrayMap();
    final TaskCompletionSource<Map<zzh<?>, String>> f5844b = new TaskCompletionSource();
    private final ArrayMap<zzh<?>, String> f5845c = new ArrayMap();
    private int f5846d;
    private boolean f5847e = false;

    public zzj(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi zzagn : iterable) {
            this.f5843a.put(zzagn.zzagn(), null);
        }
        this.f5846d = this.f5843a.keySet().size();
    }

    public final void m4768a(zzh<?> com_google_android_gms_common_api_internal_zzh_, ConnectionResult connectionResult, String str) {
        this.f5843a.put(com_google_android_gms_common_api_internal_zzh_, connectionResult);
        this.f5845c.put(com_google_android_gms_common_api_internal_zzh_, str);
        this.f5846d--;
        if (!connectionResult.m17584b()) {
            this.f5847e = true;
        }
        if (this.f5846d == 0) {
            if (this.f5847e) {
                this.f5844b.m6858a(new AvailabilityException(this.f5843a));
                return;
            }
            this.f5844b.m6859a(this.f5845c);
        }
    }
}
