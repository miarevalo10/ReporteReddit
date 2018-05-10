package com.google.android.gms.internal;

public final class zziz {
    int f7733a;
    int f7734b;
    private final byte[] f7735c;
    private /* synthetic */ zzix f7736d;

    private zziz(zzix com_google_android_gms_internal_zzix, byte[] bArr) {
        this.f7736d = com_google_android_gms_internal_zzix;
        this.f7735c = bArr;
    }

    public final synchronized void m6329a() {
        try {
            if (this.f7736d.f7732b) {
                this.f7736d.f7731a.mo1934a(this.f7735c);
                this.f7736d.f7731a.mo1932a(this.f7733a);
                this.f7736d.f7731a.mo1936b(this.f7734b);
                this.f7736d.f7731a.mo1935b();
                this.f7736d.f7731a.mo1931a();
            }
        } catch (Throwable e) {
            zzakb.m5364a("Clearcut log failed", e);
        }
    }
}
