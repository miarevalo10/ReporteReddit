package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

final class zzax implements ConnectionCallbacks, OnConnectionFailedListener {
    private /* synthetic */ zzao f13892a;

    private zzax(zzao com_google_android_gms_common_api_internal_zzao) {
        this.f13892a = com_google_android_gms_common_api_internal_zzao;
    }

    public final void mo1581a(int i) {
    }

    public final void mo1582a(Bundle bundle) {
        this.f13892a.f13869k.mo4026a(new zzav(this.f13892a));
    }

    public final void mo1583a(ConnectionResult connectionResult) {
        this.f13892a.f13860b.lock();
        try {
            if (this.f13892a.m12899a(connectionResult)) {
                this.f13892a.m12914g();
                this.f13892a.m12909e();
            } else {
                this.f13892a.m12901b(connectionResult);
            }
            this.f13892a.f13860b.unlock();
        } catch (Throwable th) {
            this.f13892a.f13860b.unlock();
        }
    }
}
