package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzy implements zzcd {
    private /* synthetic */ zzv f13988a;

    private zzy(zzv com_google_android_gms_common_api_internal_zzv) {
        this.f13988a = com_google_android_gms_common_api_internal_zzv;
    }

    public final void mo1590a(int i, boolean z) {
        this.f13988a.f13985m.lock();
        try {
            if (this.f13988a.f13984l) {
                this.f13988a.f13984l = false;
                zzv.m13056a(this.f13988a, i, z);
            } else {
                this.f13988a.f13984l = true;
                this.f13988a.f13976d.mo1581a(i);
            }
            this.f13988a.f13985m.unlock();
        } catch (Throwable th) {
            this.f13988a.f13985m.unlock();
        }
    }

    public final void mo1591a(Bundle bundle) {
        this.f13988a.f13985m.lock();
        try {
            this.f13988a.f13983k = ConnectionResult.f17256a;
            zzv.m13060b(this.f13988a);
        } finally {
            this.f13988a.f13985m.unlock();
        }
    }

    public final void mo1592a(ConnectionResult connectionResult) {
        this.f13988a.f13985m.lock();
        try {
            this.f13988a.f13983k = connectionResult;
            zzv.m13060b(this.f13988a);
        } finally {
            this.f13988a.f13985m.unlock();
        }
    }
}
