package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import java.util.Collections;

public final class zzaz implements zzbh {
    private final zzbi f13893a;

    public zzaz(zzbi com_google_android_gms_common_api_internal_zzbi) {
        this.f13893a = com_google_android_gms_common_api_internal_zzbi;
    }

    public final <A extends zzb, R extends Result, T extends zzm<R, A>> T mo1570a(T t) {
        this.f13893a.f17288m.f13895a.add(t);
        return t;
    }

    public final void mo1571a() {
        for (zze e : this.f13893a.f17281f.values()) {
            e.mo4292e();
        }
        this.f13893a.f17288m.f13897c = Collections.emptySet();
    }

    public final void mo1572a(int i) {
    }

    public final void mo1573a(Bundle bundle) {
    }

    public final void mo1574a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T mo1575b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean mo1576b() {
        return true;
    }

    public final void mo1577c() {
        zzbi com_google_android_gms_common_api_internal_zzbi = this.f13893a;
        com_google_android_gms_common_api_internal_zzbi.f17276a.lock();
        try {
            com_google_android_gms_common_api_internal_zzbi.f17286k = new zzao(com_google_android_gms_common_api_internal_zzbi, com_google_android_gms_common_api_internal_zzbi.f17283h, com_google_android_gms_common_api_internal_zzbi.f17284i, com_google_android_gms_common_api_internal_zzbi.f17279d, com_google_android_gms_common_api_internal_zzbi.f17285j, com_google_android_gms_common_api_internal_zzbi.f17276a, com_google_android_gms_common_api_internal_zzbi.f17278c);
            com_google_android_gms_common_api_internal_zzbi.f17286k.mo1571a();
            com_google_android_gms_common_api_internal_zzbi.f17277b.signalAll();
        } finally {
            com_google_android_gms_common_api_internal_zzbi.f17276a.unlock();
        }
    }
}
