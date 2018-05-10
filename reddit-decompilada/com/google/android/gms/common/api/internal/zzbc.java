package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

final class zzbc implements ConnectionCallbacks {
    private /* synthetic */ AtomicReference f13921a;
    private /* synthetic */ zzda f13922b;
    private /* synthetic */ zzba f13923c;

    zzbc(zzba com_google_android_gms_common_api_internal_zzba, AtomicReference atomicReference, zzda com_google_android_gms_common_api_internal_zzda) {
        this.f13923c = com_google_android_gms_common_api_internal_zzba;
        this.f13921a = atomicReference;
        this.f13922b = com_google_android_gms_common_api_internal_zzda;
    }

    public final void mo1581a(int i) {
    }

    public final void mo1582a(Bundle bundle) {
        this.f13923c.m12952a((GoogleApiClient) this.f13921a.get(), this.f13922b, true);
    }
}
