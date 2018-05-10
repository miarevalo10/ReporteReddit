package com.google.android.gms.internal;

final class zzom implements Runnable {
    private /* synthetic */ zzol f7952a;

    zzom(zzol com_google_android_gms_internal_zzol) {
        this.f7952a = com_google_android_gms_internal_zzol;
    }

    public final void run() {
        if (this.f7952a.f18223n != null) {
            this.f7952a.f18223n.mo2086g();
            this.f7952a.f18223n.mo2085f();
        }
        this.f7952a.f18223n = null;
    }
}
