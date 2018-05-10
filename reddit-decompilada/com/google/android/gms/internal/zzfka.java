package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfka extends zzfjm<zzfka> {
    private byte[] f18070a;
    private byte[] f18071b;
    private byte[] f18072c;

    public zzfka() {
        this.f18070a = null;
        this.f18071b = null;
        this.f18072c = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18070a != null) {
            a += zzfjk.m6164b(1, this.f18070a);
        }
        if (this.f18071b != null) {
            a += zzfjk.m6164b(2, this.f18071b);
        }
        return this.f18072c != null ? a + zzfjk.m6164b(3, this.f18072c) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18070a = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 18) {
                this.f18071b = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 26) {
                this.f18072c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18070a != null) {
            com_google_android_gms_internal_zzfjk.m6179a(1, this.f18070a);
        }
        if (this.f18071b != null) {
            com_google_android_gms_internal_zzfjk.m6179a(2, this.f18071b);
        }
        if (this.f18072c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f18072c);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
