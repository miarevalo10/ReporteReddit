package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfjx extends zzfjm<zzfjx> {
    public String f18061a;

    public zzfjx() {
        this.f18061a = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        return this.f18061a != null ? a + zzfjk.m6163b(1, this.f18061a) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18061a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18061a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18061a);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
