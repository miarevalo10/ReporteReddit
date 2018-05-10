package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbd extends zzfjm<zzbd> {
    public byte[] f17699a;
    public byte[] f17700b;
    public byte[] f17701c;
    public byte[] f17702d;

    public zzbd() {
        this.f17699a = null;
        this.f17700b = null;
        this.f17701c = null;
        this.f17702d = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17699a != null) {
            a += zzfjk.m6164b(1, this.f17699a);
        }
        if (this.f17700b != null) {
            a += zzfjk.m6164b(2, this.f17700b);
        }
        if (this.f17701c != null) {
            a += zzfjk.m6164b(3, this.f17701c);
        }
        return this.f17702d != null ? a + zzfjk.m6164b(4, this.f17702d) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f17699a = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 18) {
                this.f17700b = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 26) {
                this.f17701c = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (a == 34) {
                this.f17702d = com_google_android_gms_internal_zzfjj.m6145e();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17699a != null) {
            com_google_android_gms_internal_zzfjk.m6179a(1, this.f17699a);
        }
        if (this.f17700b != null) {
            com_google_android_gms_internal_zzfjk.m6179a(2, this.f17700b);
        }
        if (this.f17701c != null) {
            com_google_android_gms_internal_zzfjk.m6179a(3, this.f17701c);
        }
        if (this.f17702d != null) {
            com_google_android_gms_internal_zzfjk.m6179a(4, this.f17702d);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
