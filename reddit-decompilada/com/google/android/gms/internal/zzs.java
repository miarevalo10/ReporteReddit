package com.google.android.gms.internal;

final class zzs implements Runnable {
    private /* synthetic */ String f7981a;
    private /* synthetic */ long f7982b;
    private /* synthetic */ zzr f7983c;

    zzs(zzr com_google_android_gms_internal_zzr, String str, long j) {
        this.f7983c = com_google_android_gms_internal_zzr;
        this.f7981a = str;
        this.f7982b = j;
    }

    public final void run() {
        this.f7983c.f7978m.m5040a(this.f7981a, this.f7982b);
        this.f7983c.f7978m.m5039a(toString());
    }
}
