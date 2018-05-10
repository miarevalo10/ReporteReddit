package com.google.android.gms.internal;

final class zzdo implements Runnable {
    private /* synthetic */ int f7235a;
    private /* synthetic */ boolean f7236b;
    private /* synthetic */ zzdm f7237c;

    zzdo(zzdm com_google_android_gms_internal_zzdm, int i, boolean z) {
        this.f7237c = com_google_android_gms_internal_zzdm;
        this.f7235a = i;
        this.f7236b = z;
    }

    public final void run() {
        zzaz b = this.f7237c.m5850b(this.f7235a, this.f7236b);
        this.f7237c.f7221f = b;
        if (zzdm.m5841a(this.f7235a, b)) {
            this.f7237c.m5847a(this.f7235a + 1, this.f7236b);
        }
    }
}
