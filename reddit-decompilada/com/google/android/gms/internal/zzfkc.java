package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkc extends zzfjm<zzfkc> {
    private Integer f18079a;
    private byte[] f18080b;
    private byte[] f18081c;

    public zzfkc() {
        this.f18079a = null;
        this.f18080b = null;
        this.f18081c = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18079a != null) {
            a += zzfjk.m6161b(1, this.f18079a.intValue());
        }
        if (this.f18080b != null) {
            a += zzfjk.m6164b(2, this.f18080b);
        }
        return this.f18081c != null ? a + zzfjk.m6164b(3, this.f18081c) : a;
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18079a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f18079a.intValue());
        }
        if (this.f18080b != null) {
            com_google_android_gms_internal_zzfjk.m6179a(2, this.f18080b);
        }
        if (this.f18081c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f18081c);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f18079a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 18) {
                this.f18080b = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 26) {
                this.f18081c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }
}
