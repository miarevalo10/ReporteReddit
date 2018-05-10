package com.google.android.gms.internal;

final class zzalw implements Runnable {
    private /* synthetic */ int f6525a;
    private /* synthetic */ int f6526b;
    private /* synthetic */ zzalr f6527c;

    zzalw(zzalr com_google_android_gms_internal_zzalr, int i, int i2) {
        this.f6527c = com_google_android_gms_internal_zzalr;
        this.f6525a = i;
        this.f6526b = i2;
    }

    public final void run() {
        if (this.f6527c.f17572r != null) {
            this.f6527c.f17572r.mo1742a(this.f6525a, this.f6526b);
        }
    }
}
