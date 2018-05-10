package com.google.android.gms.internal;

final class zzalu implements Runnable {
    private /* synthetic */ String f6521a;
    private /* synthetic */ String f6522b;
    private /* synthetic */ zzalr f6523c;

    zzalu(zzalr com_google_android_gms_internal_zzalr, String str, String str2) {
        this.f6523c = com_google_android_gms_internal_zzalr;
        this.f6521a = str;
        this.f6522b = str2;
    }

    public final void run() {
        if (this.f6523c.f17572r != null) {
            this.f6523c.f17572r.mo1743a(this.f6521a, this.f6522b);
        }
    }
}
