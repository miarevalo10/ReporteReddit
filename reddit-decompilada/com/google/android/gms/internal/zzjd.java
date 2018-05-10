package com.google.android.gms.internal;

import java.io.IOException;

public final class zzjd extends zzfjm<zzjd> {
    public Integer f18129a;
    public Integer f18130b;
    public Integer f18131c;

    public zzjd() {
        this.f18129a = null;
        this.f18130b = null;
        this.f18131c = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18129a != null) {
            a += zzfjk.m6161b(1, this.f18129a.intValue());
        }
        if (this.f18130b != null) {
            a += zzfjk.m6161b(2, this.f18130b.intValue());
        }
        return this.f18131c != null ? a + zzfjk.m6161b(3, this.f18131c.intValue()) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 8) {
                this.f18129a = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 16) {
                this.f18130b = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (a == 24) {
                this.f18131c = Integer.valueOf(com_google_android_gms_internal_zzfjj.m6146f());
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18129a != null) {
            com_google_android_gms_internal_zzfjk.m6174a(1, this.f18129a.intValue());
        }
        if (this.f18130b != null) {
            com_google_android_gms_internal_zzfjk.m6174a(2, this.f18130b.intValue());
        }
        if (this.f18131c != null) {
            com_google_android_gms_internal_zzfjk.m6174a(3, this.f18131c.intValue());
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
