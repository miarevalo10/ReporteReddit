package com.google.android.gms.internal;

import java.io.IOException;

public final class zzjb extends zzfjm<zzjb> {
    public String f18123a;
    public zzjd f18124b;

    public zzjb() {
        this.f18123a = null;
        this.f18124b = null;
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f18123a != null) {
            a += zzfjk.m6163b(1, this.f18123a);
        }
        return this.f18124b != null ? a + zzfjk.m6162b(4, this.f18124b) : a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                this.f18123a = com_google_android_gms_internal_zzfjj.m6142d();
            } else if (a == 34) {
                if (this.f18124b == null) {
                    this.f18124b = new zzjd();
                }
                com_google_android_gms_internal_zzfjj.m6137a(this.f18124b);
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f18123a != null) {
            com_google_android_gms_internal_zzfjk.m6177a(1, this.f18123a);
        }
        if (this.f18124b != null) {
            com_google_android_gms_internal_zzfjk.m6176a(4, this.f18124b);
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }
}
