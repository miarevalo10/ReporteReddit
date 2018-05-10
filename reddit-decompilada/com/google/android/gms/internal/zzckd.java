package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.zzb;

final class zzckd implements Runnable {
    private /* synthetic */ boolean f7101a;
    private /* synthetic */ zzb f7102b;
    private /* synthetic */ zzckf f7103c;
    private /* synthetic */ zzckc f7104d;

    zzckd(zzckc com_google_android_gms_internal_zzckc, boolean z, zzb com_google_android_gms_measurement_AppMeasurement_zzb, zzckf com_google_android_gms_internal_zzckf) {
        this.f7104d = com_google_android_gms_internal_zzckc;
        this.f7101a = z;
        this.f7102b = com_google_android_gms_measurement_AppMeasurement_zzb;
        this.f7103c = com_google_android_gms_internal_zzckf;
    }

    public final void run() {
        Object obj;
        Bundle bundle;
        if (this.f7101a && this.f7104d.f17877a != null) {
            zzckc.m18365a(this.f7104d, this.f7104d.f17877a);
        }
        if (this.f7102b != null && this.f7102b.f8210d == this.f7103c.d && zzclq.m18521b(this.f7102b.f8209c, this.f7103c.c)) {
            if (zzclq.m18521b(this.f7102b.f8208b, this.f7103c.b)) {
                obj = null;
                if (obj != null) {
                    bundle = new Bundle();
                    zzckc.m18366a(this.f7103c, bundle);
                    if (this.f7102b != null) {
                        if (this.f7102b.f8208b != null) {
                            bundle.putString("_pn", this.f7102b.f8208b);
                        }
                        bundle.putString("_pc", this.f7102b.f8209c);
                        bundle.putLong("_pi", this.f7102b.f8210d);
                    }
                    this.f7104d.mo1814f().m18332a("auto", "_vs", bundle);
                }
                this.f7104d.f17877a = this.f7103c;
                this.f7104d.mo1817i().m18416a(this.f7103c);
            }
        }
        obj = 1;
        if (obj != null) {
            bundle = new Bundle();
            zzckc.m18366a(this.f7103c, bundle);
            if (this.f7102b != null) {
                if (this.f7102b.f8208b != null) {
                    bundle.putString("_pn", this.f7102b.f8208b);
                }
                bundle.putString("_pc", this.f7102b.f8209c);
                bundle.putLong("_pi", this.f7102b.f8210d);
            }
            this.f7104d.mo1814f().m18332a("auto", "_vs", bundle);
        }
        this.f7104d.f17877a = this.f7103c;
        this.f7104d.mo1817i().m18416a(this.f7103c);
    }
}
