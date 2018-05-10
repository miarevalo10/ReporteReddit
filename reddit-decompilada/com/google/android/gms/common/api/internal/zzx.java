package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzx implements zzcd {
    private /* synthetic */ zzv f13987a;

    private zzx(zzv com_google_android_gms_common_api_internal_zzv) {
        this.f13987a = com_google_android_gms_common_api_internal_zzv;
    }

    public final void mo1590a(int i, boolean z) {
        this.f13987a.f13985m.lock();
        try {
            if (!(this.f13987a.f13984l || this.f13987a.f13983k == null)) {
                if (this.f13987a.f13983k.m17584b()) {
                    this.f13987a.f13984l = true;
                    this.f13987a.f13977e.mo1581a(i);
                    this.f13987a.f13985m.unlock();
                }
            }
            this.f13987a.f13984l = false;
            zzv.m13056a(this.f13987a, i, z);
            this.f13987a.f13985m.unlock();
        } catch (Throwable th) {
            this.f13987a.f13985m.unlock();
        }
    }

    public final void mo1591a(Bundle bundle) {
        this.f13987a.f13985m.lock();
        try {
            zzv.m13057a(this.f13987a, bundle);
            this.f13987a.f13982j = ConnectionResult.f17256a;
            zzv.m13060b(this.f13987a);
        } finally {
            this.f13987a.f13985m.unlock();
        }
    }

    public final void mo1592a(ConnectionResult connectionResult) {
        this.f13987a.f13985m.lock();
        try {
            this.f13987a.f13982j = connectionResult;
            zzv.m13060b(this.f13987a);
        } finally {
            this.f13987a.f13985m.unlock();
        }
    }
}
